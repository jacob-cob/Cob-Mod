package com.cob.cobmod.client.entity.render;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.client.entity.model.GearedHunterModel;
import com.cob.cobmod.entities.GearedHunter;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GearedHunterRender extends MobRenderer<GearedHunter, GearedHunterModel<GearedHunter>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(CobCraft.MOD_ID,
			"textures/entity/geared_hunter.png");
	public GearedHunterRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GearedHunterModel<GearedHunter>(), 0.3f);
	}		
	@Override
	public ResourceLocation getEntityTexture(GearedHunter entity) {
		return TEXTURE;
	}
}
