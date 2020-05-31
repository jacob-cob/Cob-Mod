package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.objects.blocks.TropicalWoodButtonBlock;
import com.cob.cobmod.objects.blocks.TropicalWoodPressurePlateBlock;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitNew 
{
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,CobCraft.MOD_ID);
	
	public static final RegistryObject<Block> TROPICAL_STAIRS = BLOCKS.register("tropical_stairs", () -> new StairsBlock(() -> BlockInit.tropical_planks.getDefaultState() , Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 3.0f)));
	public static final RegistryObject<Block> TROPICAL_FENCE = BLOCKS.register("tropical_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 3.0f)));
	public static final RegistryObject<Block> TROPICAL_BUTTON = BLOCKS.register("tropical_button", () -> new TropicalWoodButtonBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5f, 0.5f)));
	public static final RegistryObject<Block> TROPICAL_PRESSURE_PLATE = BLOCKS.register("tropical_pressure_plate", () -> new TropicalWoodPressurePlateBlock(Sensitivity.EVERYTHING,Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5f, 0.5f)));
	
}
