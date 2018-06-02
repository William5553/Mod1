package ga.williamk.mod1.util;

import ga.williamk.mod1.Mod1;
import ga.williamk.mod1.init.BlockInit;
import ga.williamk.mod1.init.ItemInit;
import ga.williamk.mod1.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Mod1.tabMod1);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }


    @Override
    public void registerModels() {
        ClientProxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}