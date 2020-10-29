package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.CobCraft.ExtraGroup;
import com.cob.cobmod.CobCraft.JunkItemGroup;
import com.cob.cobmod.objects.items.EnchantedItem;
import com.cob.cobmod.objects.items.InfiFuelItem;
import com.cob.cobmod.objects.items.SpecialItem;
import com.cob.cobmod.util.enums.CobItemTier;
import com.cob.cobmod.util.enums.ModArmorMaterial;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = CobCraft.MOD_ID,bus = Bus.MOD)
@ObjectHolder(CobCraft.MOD_ID)
public class ItemInit
{
	// Others
	public static final Item soggy_paper = null;
	public static final Item dust = null;
	public static final Item cobium = null;
	public static final Item hardened_ice_shard = null;
	public static final Item magic_staff = null;
	public static final Item non_lasting_fuel = null;
	public static final Item lithium = null;
	
	// Food
	public static final Item banana = null;
	public static final Item bat = null;
	public static final Item long_burger = null;
	public static final Item candy = null;
	public static final Item tomato = null;
	public static final Item cheese = null;
	public static final Item dough = null;
	public static final Item pizza_base = null;
	public static final Item pizza = null;
	
	// Tools
	public static final Item cobium_sword = null;
	public static final Item cobium_pickaxe = null;
	public static final Item cobium_shovel = null;
	public static final Item cobium_axe = null;
	public static final Item cobium_hoe = null;
	
	//Armor
	public static final Item cobium_helmet = null;
	public static final Item cobium_chestplate = null;
	public static final Item cobium_leggings = null;
	public static final Item cobium_boots = null;
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) 
	{
		// Others
		event.getRegistry().register(new Item(new Item.Properties().group(JunkItemGroup.instance)).setRegistryName("soggy_paper"));
		event.getRegistry().register(new Item(new Item.Properties().group(JunkItemGroup.instance)).setRegistryName("dust"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("cobium"));
		event.getRegistry().register(new EnchantedItem(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("hardened_ice_shard"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("lithium"));
		event.getRegistry().register(new SpecialItem(new Item.Properties().group(ExtraGroup.instance)).setRegistryName("magic_staff"));
		event.getRegistry().register(new InfiFuelItem(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("non_lasting_fuel"));
		
		// Food
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(2).saturation(0.6f).build())).setRegistryName("tomato"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.8f).build())).setRegistryName("cheese"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.1f).build())).setRegistryName("dough"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.1f).build())).setRegistryName("pizza_base"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(10).saturation(4.0f).build())).setRegistryName("pizza"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(5).saturation(1.2f).effect(new EffectInstance(Effects.ABSORPTION, 1200, 2), 0.4f).build())).setRegistryName("banana"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.4f).effect(new EffectInstance(Effects.POISON, 72000, 0), 0.4f).build())).setRegistryName("bat"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(20).saturation(5.0f).meat().effect(new EffectInstance(Effects.SLOWNESS, 6000, 2), 1.0f).build())).setRegistryName("long_burger"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.1f).setAlwaysEdible().fastToEat().effect(new EffectInstance(Effects.SPEED, 100, 10), 0.2f).build())).setRegistryName("candy"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).rarity(Rarity.RARE).food(new Food.Builder().hunger(5).saturation(1.2f).effect(new EffectInstance(Effects.ABSORPTION, 6000, 7), 1.0f).effect(new EffectInstance(Effects.STRENGTH, 3000, 4), 1.0f).effect(new EffectInstance(Effects.SPEED, 3000, 3), 1.0f).build())).setRegistryName("diamond_banana"));
		event.getRegistry().register(new EnchantedItem(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(5).saturation(1.2f).effect(new EffectInstance(Effects.ABSORPTION, 12000, 20), 1.0f).effect(new EffectInstance(Effects.STRENGTH, 6000, 7), 1.0f).effect(new EffectInstance(Effects.SPEED, 6000, 5), 1.0f).build())).setRegistryName("enchanted_diamond_banana"));
		
		//Tools
		event.getRegistry().register(new SwordItem(CobItemTier.COBIUM, 10, 3.0f, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("cobium_sword"));
		event.getRegistry().register(new PickaxeItem(CobItemTier.COBIUM, 6, 3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("cobium_pickaxe"));
		event.getRegistry().register(new AxeItem(CobItemTier.COBIUM, 13, 3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("cobium_axe"));
		event.getRegistry().register(new ShovelItem(CobItemTier.COBIUM, 5, 3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("cobium_shovel"));
		event.getRegistry().register(new HoeItem(CobItemTier.COBIUM, 4, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("cobium_hoe"));
		
		event.getRegistry().register(new SwordItem(CobItemTier.REINFORCED_COBIUM, 20, 6.0f, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("reinforced_cobium_sword"));
		event.getRegistry().register(new PickaxeItem(CobItemTier.REINFORCED_COBIUM, 12, 6.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("reinforced_cobium_pickaxe"));
		
		//Armor
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.GENERIC_CLOTHES, EquipmentSlotType.CHEST, new Item.Properties().group(ExtraGroup.instance)).setRegistryName("shirt"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.GENERIC_CLOTHES, EquipmentSlotType.HEAD, new Item.Properties().group(ExtraGroup.instance)).setRegistryName("hat"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.GENERIC_CLOTHES, EquipmentSlotType.LEGS, new Item.Properties().group(ExtraGroup.instance)).setRegistryName("trousers"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.GENERIC_CLOTHES, EquipmentSlotType.FEET, new Item.Properties().group(ExtraGroup.instance)).setRegistryName("shoes"));
		
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.CLOTHES, EquipmentSlotType.CHEST, new Item.Properties().group(ExtraGroup.instance)).setRegistryName("cob_shirt"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.CLOTHES, EquipmentSlotType.HEAD, new Item.Properties().group(ExtraGroup.instance)).setRegistryName("cob_hoodie"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.CLOTHES, EquipmentSlotType.LEGS, new Item.Properties().group(ExtraGroup.instance)).setRegistryName("cob_trousers"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.CLOTHES, EquipmentSlotType.FEET, new Item.Properties().group(ExtraGroup.instance)).setRegistryName("cob_shoes"));
		
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.COBIUM, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("cobium_helmet"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.COBIUM, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("cobium_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.COBIUM, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("cobium_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.COBIUM, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("cobium_boots"));
		
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.REINFORCED_COBIUM, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("reinforced_cobium_helmet"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.REINFORCED_COBIUM, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("reinforced_cobium_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.REINFORCED_COBIUM, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("reinforced_cobium_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.REINFORCED_COBIUM, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("reinforced_cobium_boots"));
	}
}
