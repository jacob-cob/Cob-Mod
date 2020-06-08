package com.cob.cobmod.client.entity.render;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.client.entity.model.GlowBugModel;
import com.cob.cobmod.entities.GlowBug;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GlowBugRender extends MobRenderer<GlowBug, GlowBugModel<GlowBug>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(CobCraft.MOD_ID,
			"textures/entity/glow_bug.png");
	public GlowBugRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GlowBugModel<GlowBug>(), 0.3f);
	}
	@Override
	public ResourceLocation getEntityTexture(GlowBug entity) {
		return TEXTURE;
	}
}
