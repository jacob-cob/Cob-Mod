package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.enchantments.FloatationEnchantment;
import com.cob.cobmod.enchantments.HealingEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentInit {

	public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(
			ForgeRegistries.ENCHANTMENTS, CobCraft.MOD_ID);

	public static final RegistryObject<Enchantment> FLOATATION = ENCHANTMENTS.register("floatation",
			() -> new FloatationEnchantment(Rarity.VERY_RARE, EnchantmentType.ARMOR_FEET,
					new EquipmentSlotType[] { EquipmentSlotType.FEET }));
	
	public static final RegistryObject<Enchantment> HEALING = ENCHANTMENTS.register("healing",
			() -> new HealingEnchantment(Rarity.VERY_RARE, EnchantmentType.ARMOR_CHEST,
					new EquipmentSlotType[] { EquipmentSlotType.CHEST }));
	
	public static final RegistryObject<Enchantment> DOUBLE_JUMP = ENCHANTMENTS.register("double_jump",
			() -> new HealingEnchantment(Rarity.VERY_RARE, EnchantmentType.ARMOR_FEET,
					new EquipmentSlotType[] { EquipmentSlotType.FEET }));
}
