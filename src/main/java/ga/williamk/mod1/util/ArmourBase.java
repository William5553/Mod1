package ga.williamk.mod1.util;

import ga.williamk.mod1.Mod1;
import ga.williamk.mod1.init.ItemInit;
import ga.williamk.mod1.proxy.ClientProxy;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmourBase extends ItemArmor implements IHasModel {
    public ArmourBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Mod1.tabMod1);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        ClientProxy.registerItemRenderer(this, 0, "inventory");
    }
}