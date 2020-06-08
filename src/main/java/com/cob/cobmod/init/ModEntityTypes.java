package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.entities.GlowBug;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			CobCraft.MOD_ID);
	public static final RegistryObject<EntityType<GlowBug>> GLOW_BUG = ENTITY_TYPES.register("glow_bug",
			() -> EntityType.Builder.<GlowBug>create(GlowBug::new, EntityClassification.CREATURE)
			.size(0.2f, 0.3f)
		    .build(new ResourceLocation(CobCraft.MOD_ID, "glow_bug").toString()));
}