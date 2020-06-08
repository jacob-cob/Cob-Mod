package com.cob.cobmod.world.biomes;

import com.cob.cobmod.world.feature.TropicalTree;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class TropicalIslands extends Biome {

	public TropicalIslands(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PARROT, 10, 5, 10));
		this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.DOLPHIN, 15, 1, 3));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.NORMAL_TREE.withConfiguration(TropicalTree.TROPICAL_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1f, 1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.BAMBOO.withConfiguration(new ProbabilityConfig(0.0F))
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(32))));
	}

}
