package ga.williamk.mod1.init;

import ga.williamk.mod1.Mod1;
import ga.williamk.mod1.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class EntityInit {
    public static void registerEntities() {
        registerEntity("William5553", EntityWill.class, Reference.ENTITY_WILL, 50, 16746496, 255);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Mod1.instance, range, 1, true, color1, color2);
    }
}
