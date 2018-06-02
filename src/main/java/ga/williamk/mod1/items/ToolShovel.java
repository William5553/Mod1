package ga.williamk.mod1.items;

import ga.williamk.mod1.Mod1;
import ga.williamk.mod1.init.ItemInit;
import ga.williamk.mod1.proxy.ClientProxy;
import ga.williamk.mod1.util.IHasModel;
import net.minecraft.item.ItemSpade;

public class ToolShovel extends ItemSpade implements IHasModel {
    public ToolShovel(String name, ToolMaterial material) {
        super(material);
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