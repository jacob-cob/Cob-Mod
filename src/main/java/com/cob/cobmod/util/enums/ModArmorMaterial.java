package com.cob.cobmod.util.enums;

import java.util.function.Supplier;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.init.ItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterial implements IArmorMaterial {
	
	COBIUM(CobCraft.MOD_ID + ":cobium", 5, new int[] {12, 15, 16, 13}, 500, SoundEvents.field_226143_fP_, 10f, () -> {
		return Ingredient.fromItems(ItemInit.cobium);
	}),
	
	REINFORCED_COBIUM(CobCraft.MOD_ID + ":reinforced_cobium", 10, new int[] {24, 30, 32, 26}, 1000, SoundEvents.field_226143_fP_, 12.0f, () -> {
		return Ingredient.fromItems(ItemInit.cobium);
	}),
	
	CLOTHES(CobCraft.MOD_ID +":clothes", 2, new int[]{0, 0, 0, 0}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, () -> {
	      return Ingredient.fromItems(Items.STRING);
	}),
	
	GENERIC_CLOTHES(CobCraft.MOD_ID +":generic_clothes", 1, new int[]{0, 0, 0, 0}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, () -> {
	      return Ingredient.fromItems(Items.STRING);
	});
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[] {400, 720, 800, 480};
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyValue<Ingredient> repairMaterial;
	
	private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
			Supplier<Ingredient> repairMaterialIn) {

			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}
	
		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}
		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}
		@Override
		public int getEnchantability() {
			return this.enchantability;
		}
		@Override
		public SoundEvent getSoundEvent() {
			return this.soundEvent;
		}
		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			return this.name;
		}
		@Override
		public float getToughness() {
			return this.toughness;
		}
}