package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.entities.AncientGiant;
import com.cob.cobmod.entities.GearedHunter;
import com.cob.cobmod.entities.GlowBug;
import com.cob.cobmod.entities.Parasite;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes<T extends Entity> extends net.minecraftforge.registries.ForgeRegistryEntry<EntityType<?>> {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			CobCraft.MOD_ID);
	
	public static final RegistryObject<EntityType<GlowBug>> GLOW_BUG = ENTITY_TYPES.register("glow_bug",
			() -> EntityType.Builder.<GlowBug>create(GlowBug::new, EntityClassification.AMBIENT)
			.size(0.2f, 0.3f)
		    .build(new ResourceLocation(CobCraft.MOD_ID, "glow_bug").toString()));
	
	public static final RegistryObject<EntityType<AncientGiant>> ANCIENT_GIANT = ENTITY_TYPES.register("ancient_giant",
			() -> EntityType.Builder.<AncientGiant>create(AncientGiant::new, EntityClassification.MONSTER)
			.size(2.2f, 3.0f)
		    .build(new ResourceLocation(CobCraft.MOD_ID, "ancient_giant").toString()));
	
	public static final RegistryObject<EntityType<GearedHunter>> GEARED_HUNTER = ENTITY_TYPES.register("geared_hunter",
			() -> EntityType.Builder.<GearedHunter>create(GearedHunter::new, EntityClassification.MONSTER)
			.size(0.6f, 1.8f)
		    .build(new ResourceLocation(CobCraft.MOD_ID, "geared_hunter").toString()));
	
	public static final RegistryObject<EntityType<Parasite>> PARASITE = ENTITY_TYPES.register("parasite",
			() -> EntityType.Builder.<Parasite>create(Parasite::new, EntityClassification.MONSTER)
			.size(0.2f, 0.3f)
		    .build(new ResourceLocation(CobCraft.MOD_ID, "parasite").toString()));
}
