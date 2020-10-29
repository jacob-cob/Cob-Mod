package com.cob.cobmod.enchantments;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.init.EnchantmentInit;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class FloatationEnchantment extends Enchantment {

	public FloatationEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
		super(rarityIn, typeIn, slots);
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}
	@Override
	public int getMinLevel() {
		return 1;
	}
	
	@Override
	public boolean isAllowedOnBooks() {
		return true;
	}
	@Override
	public boolean isCurse() {
		return true;
	}
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return ench.equals(Enchantments.DEPTH_STRIDER) ? false : true;
	}
	
	@Mod.EventBusSubscriber(modid = CobCraft.MOD_ID, bus = Bus.FORGE)
	public static class FloatationEquipped {
		
		@SubscribeEvent
		public static void doStuff(PlayerTickEvent event) {
			PlayerEntity playerIn = event.player;
			if (playerIn.hasItemInSlot(EquipmentSlotType.FEET)
					&& EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.FLOATATION.get(),
							playerIn.getItemStackFromSlot(EquipmentSlotType.FEET)) > 0) {
			
				if(playerIn.isCrouching() == false) {
					playerIn.addPotionEffect(new EffectInstance(Effects.LEVITATION, 0, 10));
				}
			}
		}
	}
}
