package com.cob.cobmod.util;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.client.entity.render.AncientGiantRender;
import com.cob.cobmod.client.entity.render.GearedHunterRender;
import com.cob.cobmod.client.entity.render.GlowBugRender;
import com.cob.cobmod.client.entity.render.ParasiteRender;
import com.cob.cobmod.client.gui.ItemDisplayScreen;
import com.cob.cobmod.client.tileentity.renderer.ItemDisplayRenderer;
import com.cob.cobmod.init.BlockInitNew;
import com.cob.cobmod.init.ItemInitNew;
import com.cob.cobmod.init.ModContainerTypes;
import com.cob.cobmod.init.ModEntityTypes;
import com.cob.cobmod.init.ModTileEntityTypes;
import com.cob.cobmod.objects.items.PhoneItem;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CobCraft.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ModContainerTypes.ITEM_DISPLAY.get(), ItemDisplayScreen::new);
		RenderTypeLookup.setRenderLayer(BlockInitNew.TROPICAL_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInitNew.TOMATO_CROP.get(), RenderType.getCutout());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GLOW_BUG.get(), GlowBugRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ANCIENT_GIANT.get(), AncientGiantRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GEARED_HUNTER.get(), GearedHunterRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PARASITE.get(), ParasiteRender::new);
		
		ItemInitNew.PHONE.get().addPropertyOverride(new ResourceLocation(CobCraft.MOD_ID, "app"), new IItemPropertyGetter() {
			
			@Override
			public float call(ItemStack stack, World worldIn, LivingEntity entityIn) {
				switch (PhoneItem.apps) {
				case 2: 
					return 0.2f;
					
				case 4: 
					return 0.4f;
					
				case 6: 
					return 0.6f;
					
				case 8: 
					return 0.8f;
					
				case 10: 
					return 1.0f;

				default:
					return 0.0f;
				}
			}
		});
		
		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ITEM_DISPLAY.get(),
				ItemDisplayRenderer::new);
	}
}
