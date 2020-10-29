package com.cob.cobmod.client.entity.model;

import com.cob.cobmod.entities.Parasite;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ParasiteModel<T extends Parasite> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer Tummy;
	private final ModelRenderer Tail;
	private final ModelRenderer Suckers1;
	private final ModelRenderer Suckers2;
	private final ModelRenderer Suckers3;

	public ParasiteModel() {
		textureWidth = 32;
		textureHeight = 32;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(Body, 0.0F, 3.1416F, 0.0F);
		

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Head);
		Head.setTextureOffset(11, 12).addBox(-2.0F, -3.0F, 3.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		Tummy = new ModelRenderer(this);
		Tummy.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Tummy);
		Tummy.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 4.0F, 5.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Tail);
		Tail.setTextureOffset(0, 9).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);
		Tail.setTextureOffset(17, 0).addBox(-1.0F, -2.0F, -7.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Suckers1 = new ModelRenderer(this);
		Suckers1.setRotationPoint(-2.5F, -1.5F, 6.5F);
		Body.addChild(Suckers1);
		setRotationAngle(Suckers1, 0.0F, -0.5236F, 0.0F);
		Suckers1.setTextureOffset(17, 9).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Suckers2 = new ModelRenderer(this);
		Suckers2.setRotationPoint(1.9641F, -1.5F, 6.0F);
		Body.addChild(Suckers2);
		setRotationAngle(Suckers2, 0.0F, 0.5236F, 0.0F);
		Suckers2.setTextureOffset(11, 9).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Suckers3 = new ModelRenderer(this);
		Suckers3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Suckers3);
		Suckers3.setTextureOffset(5, 16).addBox(2.0F, -2.0F, 6.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		Suckers3.setTextureOffset(0, 15).addBox(-3.0F, -2.0F, 6.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
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
	public ModelRenderer getSuckers1() {
		return Suckers1;
	}
	public ModelRenderer getSuckers2() {
		return Suckers2;
	}
	public ModelRenderer getSuckers3() {
		return Suckers3;
	}
}