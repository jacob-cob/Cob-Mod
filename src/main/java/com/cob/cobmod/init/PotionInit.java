package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.effects.CoronaEffect;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PotionInit extends Effects{
	
	public static final DeferredRegister<Effect> POTIONS = new DeferredRegister<>(ForgeRegistries.POTIONS,
			CobCraft.MOD_ID);

	public static final DeferredRegister<Potion> POTION_EFFECTS = new DeferredRegister<>(ForgeRegistries.POTION_TYPES,
			CobCraft.MOD_ID);
	
	public static final RegistryObject<Effect> CORONA_EFFECT = POTIONS.register("corona_virus",
			() -> new CoronaEffect(EffectType.HARMFUL, 16759225).addAttributesModifier(
					SharedMonsterAttributes.MAX_HEALTH, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", -0.4D,
					Operation.MULTIPLY_BASE));

	public static final RegistryObject<Potion> CORONA_POTION = POTION_EFFECTS.register("corona_virus",
			() -> new Potion(new EffectInstance(CORONA_EFFECT.get())));

}
