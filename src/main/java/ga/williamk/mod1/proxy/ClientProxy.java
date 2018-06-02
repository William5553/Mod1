package ga.williamk.mod1.proxy;

import ga.williamk.mod1.reference.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy {


    public static void registerItemRenderer(Item item, int meta, String id) {
    }

    public void registerVariantRenderer(Item item, int meta, String filename, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, filename), id));
    }
}
