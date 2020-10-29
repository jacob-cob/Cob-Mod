package com.cob.cobmod.world.gen;

import com.cob.cobmod.init.BlockInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == Biomes.SNOWY_TUNDRA ) {
				@SuppressWarnings("rawtypes")
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE
				.configure(new CountRangeConfig(5, 6, 20, 25));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
				.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.hardened_ice.getDefaultState(), 5))
				.withPlacement(customConfig));
			} else if (biome == Biomes.BADLANDS || biome == Biomes.BADLANDS_PLATEAU ) {
				@SuppressWarnings("rawtypes")
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE
				.configure(new CountRangeConfig(10, 20, 40, 45));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
				.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.lithium_ore.getDefaultState(), 5))
				.withPlacement(customConfig));
			}
		}
	}
}
