package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.container.ItemDisplayContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS,
			CobCraft.MOD_ID);
	
	public static final RegistryObject<ContainerType<ItemDisplayContainer>> ITEM_DISPLAY = CONTAINER_TYPES.register("item_display", ()-> IForgeContainerType.create(ItemDisplayContainer :: new));
	
}
