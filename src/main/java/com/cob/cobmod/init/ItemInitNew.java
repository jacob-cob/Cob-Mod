package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.CobCraft.ExtraGroup;
import com.cob.cobmod.CobCraft.JunkItemGroup;
import com.cob.cobmod.objects.items.ModMusicDiscItem;
import com.cob.cobmod.objects.items.PhoneItem;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew {

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, CobCraft.MOD_ID);

	public static final RegistryObject<Item> EMPTY_CAN = ITEMS.register("empty_can",
			() -> new Item(new Item.Properties().group(JunkItemGroup.instance)));

	public static final RegistryObject<Item> COB_DISC = ITEMS.register("disc_cob",
			() -> new ModMusicDiscItem(15, SoundInit.LAZY_COB_MUSIC.get(),
					new Item.Properties().group(ExtraGroup.instance).maxStackSize(1).rarity(Rarity.RARE)));

	public static final RegistryObject<Item> PARTY_REVIVE = ITEMS.register("party_revive",
			() -> new ModMusicDiscItem(20, SoundInit.LAZY_PARTY_REVIVE.get(),
					new Item.Properties().group(ExtraGroup.instance).maxStackSize(1).rarity(Rarity.EPIC)));

	public static final RegistryObject<Item> SOOTHING_DISC = ITEMS.register("disc_soothing",
			() -> new ModMusicDiscItem(2, SoundInit.LAZY_SOOTHING_MUSIC.get(),
					new Item.Properties().group(ExtraGroup.instance).maxStackSize(1).rarity(Rarity.UNCOMMON)));

	public static final RegistryObject<Item> PHONE = ITEMS.register("phone",
			() -> new PhoneItem(new Item.Properties().group(ExtraGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> TOMATO_SEED = ITEMS.register("tomato_seed",
			() -> new BlockItem(BlockInitNew.TOMATO_CROP.get(), new Item.Properties().group(ItemGroup.MISC)));

	public static final RegistryObject<Item> STONE_DEBRIS = ITEMS.register("stone_debris",
			() -> new Item(new Item.Properties().group(JunkItemGroup.instance)));
}
