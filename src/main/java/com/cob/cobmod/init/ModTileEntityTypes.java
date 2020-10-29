package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.tileentity.ItemDisplayTileEntity;
import com.cob.cobmod.tileentity.QuarryTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, CobCraft.MOD_ID);

	public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY = TILE_ENTITY_TYPES.register("quarry",
			() -> TileEntityType.Builder.create(QuarryTileEntity::new, BlockInit.quarry).build(null));
	
	public static final RegistryObject<TileEntityType<ItemDisplayTileEntity>> ITEM_DISPLAY = TILE_ENTITY_TYPES.register("item_display",
			() -> TileEntityType.Builder.create(ItemDisplayTileEntity::new, BlockInitNew.ITEM_DISPLAY.get()).build(null));
	
}
