package ga.williamk.mod1.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ModelWill extends ModelBase {
    public ModelRenderer WillRightArm;
    public ModelRenderer WillRightLeg;
    public ModelRenderer WillHead;
    public ModelRenderer WillTorso;
    public ModelRenderer WillLeftArm;
    public ModelRenderer WillLeftLeg;

    public ModelWill() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.WillLeftLeg = new ModelRenderer(this, 0, 16);
        this.WillLeftLeg.mirror = true;
        this.WillLeftLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
        this.WillLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.WillLeftArm = new ModelRenderer(this, 40, 16);
        this.WillLeftArm.mirror = true;
        this.WillLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.WillLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.WillRightLeg = new ModelRenderer(this, 0, 16);
        this.WillRightLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
        this.WillRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.WillHead = new ModelRenderer(this, 0, 0);
        this.WillHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WillHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.WillRightArm = new ModelRenderer(this, 40, 16);
        this.WillRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.WillRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.WillTorso = new ModelRenderer(this, 16, 16);
        this.WillTorso.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WillTorso.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
    }


    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.WillLeftLeg.render(f5);
        this.WillLeftArm.render(f5);
        this.WillRightLeg.render(f5);
        this.WillHead.render(f5);
        this.WillRightArm.render(f5);
        this.WillTorso.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
