package ga.williamk.mod1.init;

import ga.williamk.mod1.entity.EntityWill;
import ga.williamk.mod1.entity.render.RenderWill;
import net.minecaft.client.renderer.entity.Render;
import net.minecaft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityWill.class, new IRenderFactory<EntityWill>() {
            public Render<? super EntityWill> createRenderFor(RenderManager manager) {
                return new RenderWill(manager);
            }
        });
    }
}
