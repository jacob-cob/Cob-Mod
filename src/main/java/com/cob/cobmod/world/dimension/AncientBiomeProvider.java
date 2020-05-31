package com.cob.cobmod.world.dimension;

import java.util.Random;
import java.util.Set;

import com.cob.cobmod.init.BiomeInit;
import com.google.common.collect.ImmutableSet;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class AncientBiomeProvider extends BiomeProvider{

	private Random rand;
	
	public AncientBiomeProvider() {
		super(biomeList);
		rand = new Random();
	}
	
	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.ANCIENT_LANDS.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return BiomeInit.ANCIENT_LANDS.get();
	}

}
