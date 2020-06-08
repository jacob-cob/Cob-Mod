package com.cob.cobmod.client.entity.model;

import com.cob.cobmod.entities.GlowBug;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GlowBugModel<T extends GlowBug> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer Tummy;
	private final ModelRenderer Tail;

	public GlowBugModel() {
		textureWidth = 16;
		textureHeight = 16;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 7).addBox(-1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		Tummy = new ModelRenderer(this);
		Tummy.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Tummy);
		Tummy.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Tail);
		Tail.setTextureOffset(8, 10).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Tummy.render(matrixStack, buffer, packedLight, packedOverlay);
		Tail.render(matrixStack, buffer, packedLight, packedOverlay);
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
	public ModelRenderer getTail() {
		return Tail;
	}
	public ModelRenderer getTummy() {
		return Tummy;
	}
}