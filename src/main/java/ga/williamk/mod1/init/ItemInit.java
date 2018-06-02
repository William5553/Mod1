package ga.williamk.mod1.init;

import ga.williamk.mod1.items.*;
import ga.williamk.mod1.reference.Reference;
import ga.williamk.mod1.util.ArmourBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    //Material
    public static final ToolMaterial TOOL_ROYAL = EnumHelper.addToolMaterial("tool_royal", 2, 10000, 15.0F, 21000000.8F, 5);
    public static final ArmorMaterial ARMOUR_ROYAL = EnumHelper.addArmorMaterial("armour_royal", Reference.MOD_ID + ":royal", 1300, new int[]{20, 20, 20, 20}, 100, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 20.0F);

    //Items
    //public static final Item INGOT_royal = new ItemBase("ingot_royal");

    //Tools
    public static final Item AXE_ROYAL = new ToolAxe("axe_royal", TOOL_ROYAL);
    public static final Item HOE_ROYAL = new ToolHoe("hoe_royal", TOOL_ROYAL);
    public static final Item PICKAXE_ROYAL = new ToolPickaxe("pickaxe_royal", TOOL_ROYAL);
    public static final Item SHOVEL_ROYAL = new ToolShovel("shovel_royal", TOOL_ROYAL);
    public static final Item SWORD_ROYAL = new ToolSword("sword_royal", TOOL_ROYAL);


    //Armour
    public static final Item HELMET_ROYAL = new ArmourBase("helmet_royal", ARMOUR_ROYAL, 1, EntityEquipmentSlot.HEAD);
    public static final Item CHESTPLATE_ROYAL = new ArmourBase("chestplate_royal", ARMOUR_ROYAL, 1, EntityEquipmentSlot.CHEST);
    public static final Item LEGGINGS_ROYAL = new ArmourBase("leggings_royal", ARMOUR_ROYAL, 2, EntityEquipmentSlot.LEGS);
    public static final Item BOOTS_ROYAL = new ArmourBase("boots_royal", ARMOUR_ROYAL, 1, EntityEquipmentSlot.FEET);

}