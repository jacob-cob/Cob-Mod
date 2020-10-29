package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
			CobCraft.MOD_ID);

	public static final RegistryObject<SoundEvent> AMBIENT = SOUNDS.register("entity.glow_bug.ambient",
			() -> new SoundEvent(new ResourceLocation(CobCraft.MOD_ID, "entity.glow_bug.ambient")));
	
	public static final RegistryObject<SoundEvent> HURT = SOUNDS.register("entity.glow_bug.hurt",
			() -> new SoundEvent(new ResourceLocation(CobCraft.MOD_ID, "entity.glow_bug.hurt")));
	
	public static final RegistryObject<SoundEvent> DEATH = SOUNDS.register("entity.glow_bug.death",
			() -> new SoundEvent(new ResourceLocation(CobCraft.MOD_ID, "entity.glow_bug.death")));
	
	public static final RegistryObject<SoundEvent> ANCIENT_GIANT_AMBIENT = SOUNDS.register("entity.ancient_giant.ambient",
			() -> new SoundEvent(new ResourceLocation(CobCraft.MOD_ID, "entity.ancient_giant.ambient")));
	
	public static final RegistryObject<SoundEvent> ANCIENT_GIANT_HURT = SOUNDS.register("entity.ancient_giant.hurt",
			() -> new SoundEvent(new ResourceLocation(CobCraft.MOD_ID, "entity.ancient_giant.hurt")));
	
	public static final RegistryObject<SoundEvent> ANCIENT_GIANT_DEATH = SOUNDS.register("entity.ancient_giant.death",
			() -> new SoundEvent(new ResourceLocation(CobCraft.MOD_ID, "entity.ancient_giant.death")));
	
	public static final Lazy<SoundEvent> LAZY_COB_MUSIC = Lazy
			.of(() -> new SoundEvent(new ResourceLocation(CobCraft.MOD_ID, "disc.coffin_dance")));
	
	public static final RegistryObject<SoundEvent> COB_MUSIC = SOUNDS.register("cob_music",
			LAZY_COB_MUSIC);
	
	public static final Lazy<SoundEvent> LAZY_SOOTHING_MUSIC = Lazy
			.of(() -> new SoundEvent(new ResourceLocation(CobCraft.MOD_ID, "disc.soothing_music")));
	
	public static final RegistryObject<SoundEvent> SOOTHING_MUSIC = SOUNDS.register("soothing_music",
			LAZY_SOOTHING_MUSIC);
	
	public static final Lazy<SoundEvent> LAZY_PARTY_REVIVE = Lazy
			.of(() -> new SoundEvent(new ResourceLocation(CobCraft.MOD_ID, "disc.party_revive")));
	
	public static final RegistryObject<SoundEvent> PARTY_REVIVE = SOUNDS.register("party_revive",
			LAZY_PARTY_REVIVE);
}
