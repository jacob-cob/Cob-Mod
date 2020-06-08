package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
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
}
