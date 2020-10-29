package com.cob.cobmod.world.feature;

import java.util.Random;

import com.cob.cobmod.init.BlockInitNew;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class TropicalTree extends Tree {

	public static final TreeFeatureConfig TROPICAL_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInitNew.TROPICAL_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInitNew.TROPICAL_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(3, 0))).baseHeight(6).heightRandA(2).foliageHeight(3).ignoreVines()
					.setSapling((IPlantable) BlockInitNew.TROPICAL_SAPLING.get()).build();
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(TROPICAL_TREE_CONFIG);
	}
}
