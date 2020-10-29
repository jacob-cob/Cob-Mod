package com.cob.cobmod.client.tileentity.renderer;

import com.cob.cobmod.tileentity.ItemDisplayTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("deprecation")
@OnlyIn(Dist.CLIENT)
public class ItemDisplayRenderer extends TileEntityRenderer<ItemDisplayTileEntity>{
	
	private float degrees;
	
	public ItemDisplayRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
		degrees = 0.0f;
	}

	@Override
	public void render(ItemDisplayTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		NonNullList<ItemStack> items = tileEntityIn.getItems();
		for (ItemStack stack : items) {
			if (!stack.isEmpty()) {
				matrixStackIn.push();
				matrixStackIn.translate(0.5D, 1.5D, 0.5D);
				float currentTime = tileEntityIn.getWorld().getGameTime() + partialTicks;
				matrixStackIn.translate(0D, (Math.sin(Math.PI * currentTime / 16) / 4) + 0.1D, 0D);
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(degrees++ / 2));
				renderItem(stack, partialTicks, matrixStackIn, bufferIn, combinedLightIn);
				matrixStackIn.pop();
			}
		}
	}
	
	private void renderItem(ItemStack stack, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn,
			int combinedLightIn) {
		Minecraft.getInstance().getItemRenderer().renderItem(stack, TransformType.FIXED, combinedLightIn,
				OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn);
	}
}
