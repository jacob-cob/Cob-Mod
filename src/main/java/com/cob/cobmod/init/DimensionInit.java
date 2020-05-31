package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.world.dimension.CobModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit 
{
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, CobCraft.MOD_ID);
	
	public static final RegistryObject<ModDimension> ANCIENT_LANDS = MOD_DIMENSIONS.register("ancient_lands", () -> new CobModDimension());
}
