package ga.williamk.mod1.entity.render;

import ga.williamk.mod1.entity.EntityWill;
import ga.williamk.mod1.entity.model.ModelWill;
import ga.williamk.mod1.reference.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderWill extends RenderLiving<EntityWill> {

    public static final ResourceLocation TEXTURES = new ResouceLocation(Reference.MOD_ID + ":textures/entity/will.png")

    public RenderWill(RenderManager manager) {
        super(manager, new ModelWill(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityWill entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityWill entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
