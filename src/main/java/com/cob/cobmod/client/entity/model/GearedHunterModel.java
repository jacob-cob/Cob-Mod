package com.cob.cobmod.client.entity.model;

import com.cob.cobmod.entities.GearedHunter;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GearedHunterModel<T extends GearedHunter> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Tummy;
	private final ModelRenderer RightHand;
	private final ModelRenderer LeftHand;
	private final ModelRenderer Head;

	public GearedHunterModel() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, -8.0F);
		

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(LeftLeg);
		LeftLeg.setTextureOffset(30, 30).addBox(-3.0F, -10.0F, 6.0F, 3.0F, 10.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(4.0F, 0.0F, 0.0F);
		Body.addChild(RightLeg);
		RightLeg.setTextureOffset(0, 26).addBox(-4.0F, -10.0F, 6.0F, 3.0F, 10.0F, 4.0F, 0.0F, false);

		Tummy = new ModelRenderer(this);
		Tummy.setRotationPoint(4.0F, -7.0F, 0.0F);
		Body.addChild(Tummy);
		Tummy.setTextureOffset(0, 12).addBox(-7.0F, -13.0F, 6.0F, 6.0F, 10.0F, 4.0F, 0.0F, false);

		RightHand = new ModelRenderer(this);
		RightHand.setRotationPoint(7.0F, -6.0F, 0.0F);
		Body.addChild(RightHand);
		RightHand.setTextureOffset(24, 0).addBox(-4.0F, -14.0F, 6.0F, 3.0F, 10.0F, 4.0F, 0.0F, false);

		LeftHand = new ModelRenderer(this);
		LeftHand.setRotationPoint(-2.0F, -6.0F, 0.0F);
		Body.addChild(LeftHand);
		LeftHand.setTextureOffset(20, 20).addBox(-4.0F, -14.0F, 6.0F, 3.0F, 10.0F, 4.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(3.0F, -20.0F, 6.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(-6.0F, -6.0F, -1.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float redIn, float greenIn, float blueIn, float alphaIn){
		Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, redIn, greenIn, blueIn, alphaIn);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
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
	public ModelRenderer getTummy() {
		return Tummy;
	}
	public ModelRenderer getRightLeg() {
		return RightLeg;
	}
	public ModelRenderer getLeftLeg() {
		return LeftLeg;
	}
	public ModelRenderer getRightHand(){
		return RightHand;
	}
	public ModelRenderer getLeftHand() {
		return LeftHand;
	}
}