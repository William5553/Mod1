package ga.williamk.mod1.blocks;

import ga.williamk.mod1.Mod1;
import ga.williamk.mod1.entity.EntityNukePrimed;
import ga.williamk.mod1.init.BlockInit;
import ga.williamk.mod1.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockNuke extends Block {

    public static final PropertyBool EXPLODE = PropertyBool.create("explode");


    public BlockNuke(Material material) {
        super(material);
        setUnlocalizedName("nuke");
        setRegistryName("nuke");
        setCreativeTab(CreativeTabs.REDSTONE);
        setHardness(0.5F);
        setSoundType(SoundType.METAL);
        setDefaultState(this.blockState.getBaseState().withProperty(EXPLODE, Boolean.valueOf(false)));
        setCreativeTab(Mod1.tabMod1);

        BlockInit.BLOCKS.add(this);
    }


    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);

        if (worldIn.isBlockPowered(pos)) {
            this.onBlockDestroyedByPlayer(worldIn, pos, state.withProperty(EXPLODE, Boolean.valueOf(true)));
            worldIn.setBlockToAir(pos);
        }
    }


    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */

    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if (worldIn.isBlockPowered(pos)) {
            this.onBlockDestroyedByPlayer(worldIn, pos, state.withProperty(EXPLODE, Boolean.valueOf(true)));
            worldIn.setBlockToAir(pos);
        }
    }

    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
        if (!worldIn.isRemote) {
            EntityNukePrimed entitynukeprimed = new EntityNukePrimed(worldIn, (double) ((float) pos.getX() + 0.5F), (double) pos.getY(), (double) ((float) pos.getZ() + 0.5F), explosionIn.getExplosivePlacedBy());
            entitynukeprimed.setFuse((short) (worldIn.rand.nextInt(entitynukeprimed.getFuse() / 4) + entitynukeprimed.getFuse() / 8));
            worldIn.spawnEntity(entitynukeprimed);
        }
    }


    /**
     * Called after a player destroys this Block - the posiiton pos may no longer hold the state indicated.
     */
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        this.explode(worldIn, pos, state, null);
    }

    public void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
        if (!worldIn.isRemote) {
            if (state.getValue(EXPLODE).booleanValue()) {
                EntityNukePrimed entitynukeprimed = new EntityNukePrimed(worldIn, (double) ((float) pos.getX() + 0.5F), (double) pos.getY(), (double) ((float) pos.getZ() + 0.5F), igniter);
                worldIn.spawnEntity(entitynukeprimed);
                worldIn.playSound(null, entitynukeprimed.posX, entitynukeprimed.posY, entitynukeprimed.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
    }

    /**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = playerIn.getHeldItem(hand);

        if (!itemstack.isEmpty() && (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE)) {
            this.explode(worldIn, pos, state.withProperty(EXPLODE, Boolean.valueOf(true)), playerIn);
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);

            if (itemstack.getItem() == Items.FLINT_AND_STEEL) {
                itemstack.damageItem(4, playerIn);
            } else if (!playerIn.capabilities.isCreativeMode) {
                itemstack.shrink(1);
            }

            return true;
        } else {
            return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
        }
    }

    /**
     * Called When an Entity Collided with the Block
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (!worldIn.isRemote && entityIn instanceof EntityArrow) {
            EntityArrow entityarrow = (EntityArrow) entityIn;

            if (entityarrow.isBurning()) {
                this.explode(worldIn, pos, worldIn.getBlockState(pos).withProperty(EXPLODE, Boolean.valueOf(true)), entityarrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase) entityarrow.shootingEntity : null);
                worldIn.setBlockToAir(pos);
            }
        }
    }

    /**
     * Return whether this block can drop from an explosion.
     */
    public boolean canDropFromExplosion(Explosion explosionIn) {
        return false;
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(EXPLODE, Boolean.valueOf((meta & 1) > 0));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state) {
        return state.getValue(EXPLODE).booleanValue() ? 1 : 0;
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, EXPLODE);
    }
}
