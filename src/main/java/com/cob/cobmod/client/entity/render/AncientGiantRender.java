package com.cob.cobmod.client.entity.render;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.client.entity.model.AncientGiantModel;
import com.cob.cobmod.entities.AncientGiant;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class AncientGiantRender extends MobRenderer<AncientGiant, AncientGiantModel<AncientGiant>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(CobCraft.MOD_ID,
			"textures/entity/ancient_giant.png");
	public AncientGiantRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new AncientGiantModel<AncientGiant>(), 0.7f);
	}
	@Override
	public ResourceLocation getEntityTexture(AncientGiant entity) {
		return TEXTURE;
	}
}
