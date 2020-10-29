package com.cob.cobmod.client.entity.render;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.client.entity.model.ParasiteModel;
import com.cob.cobmod.entities.Parasite;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ParasiteRender extends MobRenderer<Parasite, ParasiteModel<Parasite>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(CobCraft.MOD_ID,
			"textures/entity/parasite.png");
	public ParasiteRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ParasiteModel<Parasite>(), 0.3f);
	}
	@Override
	public ResourceLocation getEntityTexture(Parasite entity) {
		return TEXTURE;
	}
}
