package com.cob.cobmod.util;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.init.DimensionInit;

import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = CobCraft.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber {
	@SubscribeEvent
	public static void registerDimensions(final RegisterDimensionsEvent event) {
		if (DimensionType.byName(CobCraft.ANCIENT_DIMENSION_TYPE) == null) {
			DimensionManager.registerDimension(CobCraft.ANCIENT_DIMENSION_TYPE, DimensionInit.ANCIENT_LANDS.get(), null,
					true);
		}
		CobCraft.LOGGER.info("Dimensions Registered");
	}
}
