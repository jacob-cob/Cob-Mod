package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.objects.blocks.InfectionBlock;
import com.cob.cobmod.objects.blocks.ItemDisplayBlock;
import com.cob.cobmod.objects.blocks.ModSaplingBlock;
import com.cob.cobmod.objects.blocks.TomatoCrop;
import com.cob.cobmod.objects.blocks.TropicalDoor;
import com.cob.cobmod.objects.blocks.TropicalWoodButtonBlock;
import com.cob.cobmod.objects.blocks.TropicalWoodPressurePlateBlock;
import com.cob.cobmod.world.feature.TropicalTree;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitNew {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
			CobCraft.MOD_ID);

	public static final RegistryObject<Block> TROPICAL_STAIRS = BLOCKS.register("tropical_stairs",
			() -> new StairsBlock(() -> BlockInit.tropical_planks.getDefaultState(),
					Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 3.0f)));
	
	public static final RegistryObject<Block> TROPICAL_FENCE = BLOCKS.register("tropical_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 3.0f)));
	
	public static final RegistryObject<Block> TROPICAL_BUTTON = BLOCKS.register("tropical_button",
			() -> new TropicalWoodButtonBlock(
					Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5f, 0.5f)));
	
	public static final RegistryObject<Block> TROPICAL_PRESSURE_PLATE = BLOCKS.register("tropical_pressure_plate",
			() -> new TropicalWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5f, 0.5f)));
	
	public static final RegistryObject<Block> TROPICAL_LOG = BLOCKS.register("tropical_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.ACACIA_LOG)));
	
	public static final RegistryObject<Block> TROPICAL_LEAVES = BLOCKS.register("tropical_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES).lightValue(5)));
	
	public static final RegistryObject<Block> TROPICAL_SAPLING = BLOCKS.register("tropical_sapling",
			() -> new ModSaplingBlock(() -> new TropicalTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	
	public static final RegistryObject<Block> TROPICAL_SLAB = BLOCKS.register("tropical_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	
	public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register("tomato_crop",
			() -> new TomatoCrop(Block.Properties.from(Blocks.WHEAT)));
	
	public static final RegistryObject<Block> TROPICAL_DOOR = BLOCKS.register("tropical_door",
			() -> new TropicalDoor(Block.Properties.from(Blocks.ACACIA_DOOR)));
	
	public static final RegistryObject<Block> ITEM_DISPLAY = BLOCKS.register("item_display",
			() -> new ItemDisplayBlock(Block.Properties.from(Blocks.LECTERN)));
	
	public static final RegistryObject<Block> INFECTION_BLOCK = BLOCKS.register("infection_block",
			() -> new InfectionBlock(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(1.0f, 3.0f).lightValue(1).slipperiness(0.5f).sound(SoundType.SLIME)));
}

