package ga.williamk.mod1.init;

import ga.williamk.mod1.blocks.BlockNuke;
import ga.williamk.mod1.util.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block BLOCK_COPPER = new BlockBase("block_royal", Material.IRON);
    public static final Block NUKE = new BlockNuke(Material.TNT);
/*
    public static final Block ORE_END = new BlockOres("ore_end", "end");
    public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
    public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether");

    public static final Block PLANKS = new BlockPlank("planks");
    public static final Block LOGS = new BlockLogs("log");
    public static final Block LEAVES = new BlockLeaf("leaves");
    public static final Block SAPLINGS = new BlockSaplings("sapling");

    public static final Block DIRT = new BlockDirts("dirt");
    */
}