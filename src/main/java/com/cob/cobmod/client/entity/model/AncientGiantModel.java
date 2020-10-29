package com.cob.cobmod.client.entity.model;

import com.cob.cobmod.entities.AncientGiant;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class AncientGiantModel<T extends AncientGiant> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Feet;
	private final ModelRenderer Legs1;
	private final ModelRenderer Legs2;
	private final ModelRenderer Chest1;
	private final ModelRenderer Chest2;
	private final ModelRenderer Chest3;
	private final ModelRenderer Arms1;
	private final ModelRenderer Arms2;
	private final ModelRenderer Head;
	private final ModelRenderer getBody;
	private final ModelRenderer getHead;
	private final ModelRenderer getFeet;
	private final ModelRenderer getLegs1;
	private final ModelRenderer getLegs2;
	private final ModelRenderer getChest1;
	private final ModelRenderer getChest2;
	private final ModelRenderer getChest3;
	private final ModelRenderer getArms1;
	private final ModelRenderer getArms2;

	public AncientGiantModel() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(-4.0F, 24.0F, 2.0F);
		

		Feet = new ModelRenderer(this);
		Feet.setRotationPoint(3.5F, -1.75F, -3.25F);
		Body.addChild(Feet);
		Feet.setTextureOffset(25, 25).addBox(2.5F, -1.25F, -6.75F, 6.0F, 3.0F, 13.0F, 0.0F, false);
		Feet.setTextureOffset(0, 19).addBox(-7.5F, -1.25F, -6.75F, 6.0F, 3.0F, 13.0F, 0.0F, false);

		Legs1 = new ModelRenderer(this);
		Legs1.setRotationPoint(3.5F, -2.0F, -2.0F);
		Body.addChild(Legs1);
		setRotationAngle(Legs1, -0.5236F, 0.0F, 0.0F);
		Legs1.setTextureOffset(74, 11).addBox(2.5F, -6.0F, -1.5359F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		Legs1.setTextureOffset(72, 74).addBox(-7.5F, -6.0F, -1.5359F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		Legs2 = new ModelRenderer(this);
		Legs2.setRotationPoint(0.0F, -4.5981F, 1.5F);
		Body.addChild(Legs2);
		setRotationAngle(Legs2, 0.2618F, 0.0F, 0.0F);
		Legs2.setTextureOffset(72, 29).addBox(6.0F, -9.5981F, -2.5F, 6.0F, 10.0F, 6.0F, 0.0F, false);
		Legs2.setTextureOffset(24, 72).addBox(-4.0F, -9.4019F, -2.5F, 6.0F, 10.0F, 6.0F, 0.0F, false);

		Chest1 = new ModelRenderer(this);
		Chest1.setRotationPoint(0.0F, -11.5F, 2.5F);
		Body.addChild(Chest1);
		setRotationAngle(Chest1, -0.4363F, 0.0F, 0.0F);
		Chest1.setTextureOffset(36, 41).addBox(-4.0F, -11.5F, -0.5F, 16.0F, 13.0F, 2.0F, 0.0F, false);

		Chest2 = new ModelRenderer(this);
		Chest2.setRotationPoint(0.0F, -14.5F, 3.5F);
		Body.addChild(Chest2);
		Chest2.setTextureOffset(40, 0).addBox(-4.0F, -21.5F, 2.5F, 16.0F, 15.0F, 2.0F, 0.0F, false);

		Chest3 = new ModelRenderer(this);
		Chest3.setRotationPoint(0.0F, -18.0F, 3.0F);
		Body.addChild(Chest3);
		setRotationAngle(Chest3, 0.5236F, 0.0F, 0.0F);
		Chest3.setTextureOffset(0, 41).addBox(-4.0F, -25.9545F, 11.0981F, 16.0F, 13.0F, 2.0F, 0.0F, false);

		Arms1 = new ModelRenderer(this);
		Arms1.setRotationPoint(6.0F, -13.5F, 2.5F);
		Body.addChild(Arms1);
		setRotationAngle(Arms1, -0.7854F, 0.0F, 0.0F);
		Arms1.setTextureOffset(0, 68).addBox(6.0F, -12.3995F, -6.1569F, 8.0F, 14.0F, 4.0F, 0.0F, false);
		Arms1.setTextureOffset(56, 56).addBox(-18.0F, -13.1066F, -6.864F, 8.0F, 14.0F, 4.0F, 0.0F, false);

		Arms2 = new ModelRenderer(this);
		Arms2.setRotationPoint(6.0F, -13.5F, 2.5F);
		Body.addChild(Arms2);
		setRotationAngle(Arms2, -1.5708F, 0.0F, 0.0F);
		Arms2.setTextureOffset(48, 74).addBox(6.0F, 4.7929F, -3.2071F, 8.0F, 9.0F, 4.0F, 0.0F, false);
		Arms2.setTextureOffset(30, 56).addBox(-18.0F, 2.7426F, -6.1569F, 8.0F, 11.0F, 5.0F, 0.0F, false);
		Arms2.setTextureOffset(50, 17).addBox(-18.0F, 13.0F, -5.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);
		Arms2.setTextureOffset(0, 56).addBox(6.0F, 12.0F, -3.0F, 8.0F, 5.0F, 7.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -20.0F, 0.5F);
		Body.addChild(Head);
		setRotationAngle(Head, 0.3491F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-1.0F, -25.2367F, -1.1709F, 10.0F, 9.0F, 10.0F, 0.0F, false);

		getBody = new ModelRenderer(this);
		getBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getHead = new ModelRenderer(this);
		getHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getFeet = new ModelRenderer(this);
		getFeet.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getLegs1 = new ModelRenderer(this);
		getLegs1.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getLegs2 = new ModelRenderer(this);
		getLegs2.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getChest1 = new ModelRenderer(this);
		getChest1.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getChest2 = new ModelRenderer(this);
		getChest2.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getChest3 = new ModelRenderer(this);
		getChest3.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getArms1 = new ModelRenderer(this);
		getArms1.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getArms2 = new ModelRenderer(this);
		getArms2.setRotationPoint(0.0F, 0.0F, 0.0F);
		
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
	public ModelRenderer getBody() {
		return Body;
	}
	public ModelRenderer getHead() {
		return Head;
	}
	public ModelRenderer getFeet() {
		return Feet;
	}
	public ModelRenderer getLegs1() {
		return Legs1;
	}
	public ModelRenderer getLegs2() {
		return Legs2;
	}
	public ModelRenderer getChest1() {
		return Chest1;
	}
	public ModelRenderer getChest2() {
		return Chest2;
	}
	public ModelRenderer getChest3() {
		return Chest3;
	}
	public ModelRenderer getArms1() {
		return Arms1;
	}
	public ModelRenderer getArms2() {
		return Arms2;
	}
}