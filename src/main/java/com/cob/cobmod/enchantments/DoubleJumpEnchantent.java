package com.cob.cobmod.enchantments;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.init.EnchantmentInit;
import com.cob.cobmod.util.helpers.KeyboardHelper;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class DoubleJumpEnchantent extends Enchantment {
	
	public DoubleJumpEnchantent(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
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
	public boolean isTreasureEnchantment() {
		return false;
	}
	
	@Mod.EventBusSubscriber(modid = CobCraft.MOD_ID, bus = Bus.FORGE)
	public static class HealingEquipped {
		
		@SubscribeEvent
		public static void doStuff(PlayerTickEvent event) {
			PlayerEntity playerIn = event.player;
			if (playerIn.hasItemInSlot(EquipmentSlotType.CHEST)
					&& EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.HEALING.get(),
							playerIn.getItemStackFromSlot(EquipmentSlotType.FEET)) > 0) {
				boolean jumped = false; 
				if(playerIn.isAirBorne && jumped == false) {
					if(KeyboardHelper.isHoldingCtrl()) {
						playerIn.addPotionEffect(new EffectInstance(Effects.LEVITATION, 10, 100));
						jumped = true;
					}
					if(playerIn.onGround) {
						jumped = false;
					}
				}
			}
		}
	}
}
