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

public class HealingEnchantment extends Enchantment {
	
	public static int heal = 0;
	
	public HealingEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
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
		return true;
	}
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return ench.equals(Enchantments.THORNS) ? false : true;
	}
	
	@Mod.EventBusSubscriber(modid = CobCraft.MOD_ID, bus = Bus.FORGE)
	public static class HealingEquipped {
		
		@SubscribeEvent
		public static void doStuff(PlayerTickEvent event) {
			PlayerEntity playerIn = event.player;
			if (playerIn.hasItemInSlot(EquipmentSlotType.CHEST)
					&& EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.HEALING.get(),
							playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST)) > 0) {
				heal++;
				if (heal >= 400 && heal <= 405) {
					playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 1, 10));
				}
				if (heal > 405) {
					playerIn.removeActivePotionEffect(Effects.REGENERATION);
					heal = 0;
				}
			} else {
				playerIn.removeActivePotionEffect(Effects.REGENERATION);
				heal = 0;
			}
		}
	}
}
