package com.cob.cobmod.init;

import java.util.function.Supplier;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.CobCraft.ExtraGroup;
import com.cob.cobmod.CobCraft.JunkItemGroup;
import com.cob.cobmod.objects.items.EnchantedItem;
import com.cob.cobmod.objects.items.InfiFuelItem;
import com.cob.cobmod.objects.items.SpecialItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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
	
	// Food
	public static final Item banana = null;
	public static final Item long_burger = null;
	public static final Item candy = null;
	
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
		event.getRegistry().register(new SpecialItem(new Item.Properties().group(ExtraGroup.instance)).setRegistryName("magic_staff"));
		event.getRegistry().register(new InfiFuelItem(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("non_lasting_fuel"));
		
		// Food
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(5).saturation(1.2f).effect(new EffectInstance(Effects.ABSORPTION, 1200, 2), 0.4f).build())).setRegistryName("banana"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(20).saturation(5.0f).meat().effect(new EffectInstance(Effects.SLOWNESS, 6000, 2), 1.0f).build())).setRegistryName("long_burger"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0f).setAlwaysEdible().fastToEat().effect(new EffectInstance(Effects.SPEED, 100, 10), 0.2f).build())).setRegistryName("candy"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(5).saturation(1.2f).effect(new EffectInstance(Effects.ABSORPTION, 6000, 7), 1.0f).build())).setRegistryName("diamond_banana"));
		event.getRegistry().register(new EnchantedItem(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(5).saturation(1.2f).effect(new EffectInstance(Effects.ABSORPTION, 12000, 20), 1.0f).build())).setRegistryName("enchanted_diamond_banana"));
		
		//Tools
		event.getRegistry().register(new SwordItem(CobItemTier.EXAMPLE, 10, 3.0f, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("cobium_sword"));
		event.getRegistry().register(new PickaxeItem(CobItemTier.EXAMPLE, 6, 3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("cobium_pickaxe"));
		event.getRegistry().register(new AxeItem(CobItemTier.EXAMPLE, 13, 3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("cobium_axe"));
		event.getRegistry().register(new ShovelItem(CobItemTier.EXAMPLE, 5, 3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("cobium_shovel"));
		event.getRegistry().register(new HoeItem(CobItemTier.EXAMPLE, 4, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("cobium_hoe"));
		
		//Armor
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("cobium_helmet"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("cobium_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("cobium_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("cobium_boots"));
	}
	
	public enum CobItemTier implements IItemTier
	{
		EXAMPLE(4, 5000, 20.0F, 10.0F, 250, () -> {
			return Ingredient.fromItems(ItemInit.cobium);
		});
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private CobItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) 
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
					
		}

		@Override
		public int getMaxUses() {
			return maxUses;
		}

		@Override
		public float getEfficiency() {
			return efficiency;
		}

		@Override
		public float getAttackDamage() {
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
	}
	public enum ModArmorMaterial implements IArmorMaterial
	{
		TEST(CobCraft.MOD_ID + ":test", 5, new int[] {12, 15, 16, 13}, 500, SoundEvents.field_226143_fP_, 10f, () -> {
			return Ingredient.fromItems(ItemInit.cobium);
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
	
}
