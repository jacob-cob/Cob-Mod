package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.world.biomes.AncientLands;
import com.cob.cobmod.world.biomes.TropicalBeach;
import com.cob.cobmod.world.biomes.TropicalIslands;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES,
			CobCraft.MOD_ID);
	
	public static final RegistryObject<Biome> TROPICAL_ISLANDS = BIOMES.register("tropical_islands",
			() -> new TropicalIslands(new Biome.Builder().precipitation(RainType.RAIN).scale(0.5f).temperature(0.7f)
					.waterColor(10158079).waterFogColor(15135733)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
									Blocks.STONE.getDefaultState(), BlockInit.white_sand.getDefaultState()))
					.category(Category.DESERT)
					.downfall(0.01f)
					.depth(0.128f)
					.parent(null)));
	public static final RegistryObject<Biome> TROPICAL_BEACH = BIOMES.register("tropical_beach",
			() -> new TropicalBeach(new Biome.Builder().precipitation(RainType.NONE).scale(0.2f).temperature(0.7f)
					.waterColor(10158079).waterFogColor(15135733)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(BlockInit.white_sand.getDefaultState(),
									BlockInit.white_sand.getDefaultState(), Blocks.GRAVEL.getDefaultState()))
					.category(Category.DESERT)
					.downfall(0.01f)
					.depth(0.130f)
					.parent("tropical_islands")));
	public static final RegistryObject<Biome> ANCIENT_LANDS = BIOMES.register("ancient_lands",
			() -> new AncientLands(new Biome.Builder().precipitation(RainType.RAIN).scale(2f).temperature(0.5f)
					.waterColor(16777060).waterFogColor(12632321)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(BlockInit.mossy_stone.getDefaultState(),
									Blocks.STONE.getDefaultState(), BlockInit.mossy_stone.getDefaultState()))
					.category(Category.NONE)
					.downfall(0.3f)
					.depth(0.122f)
					.parent(null)));
	
	public static void registerBiomes()
	{
		registerBiome(TROPICAL_BEACH.get(),Type.BEACH, Type.OVERWORLD);
		registerBiome(TROPICAL_ISLANDS.get(),Type.JUNGLE, Type.OVERWORLD);
		registerBiome(ANCIENT_LANDS.get(),Type.WASTELAND);
	}
	
	private static void registerBiome(Biome biome, Type... types) {
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
}
