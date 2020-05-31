package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.CobCraft.ExtraGroup;
import com.cob.cobmod.CobCraft.JunkItemGroup;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew {
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,CobCraft.MOD_ID);
	
	public static final RegistryObject<Item> EMPTY_CAN = ITEMS.register("empty_can", () -> new Item(new Item.Properties().group(JunkItemGroup.instance)));
	public static final RegistryObject<Item> PHONE = ITEMS.register("phone", () -> new Item(new Item.Properties().group(ExtraGroup.instance)));
}
