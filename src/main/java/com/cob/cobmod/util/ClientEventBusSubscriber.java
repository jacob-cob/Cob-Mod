package com.cob.cobmod.util;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.client.entity.render.GlowBugRender;
import com.cob.cobmod.init.BlockInitNew;
import com.cob.cobmod.init.ModEntityTypes;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CobCraft.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(BlockInitNew.TROPICAL_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.TOMATO_CROP.get(), RenderType.getCutout());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GLOW_BUG.get(), GlowBugRender::new);
	}

}
