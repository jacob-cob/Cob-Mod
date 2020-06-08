package com.cob.cobmod.world.biomes;

import com.cob.cobmod.init.ModEntityTypes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class AncientLands extends Biome {

	public AncientLands(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SILVERFISH, 10, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(ModEntityTypes.GLOW_BUG.get(), 20, 1, 3));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285717F)));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(128))));
		DefaultBiomeFeatures.addExtraGoldOre(this);
		DefaultBiomeFeatures.addExtraEmeraldOre(this);
	}

}
