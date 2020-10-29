package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;
import com.cob.cobmod.objects.blocks.Chair;
import com.cob.cobmod.objects.blocks.QuarryBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(CobCraft.MOD_ID)
@Mod.EventBusSubscriber(modid = CobCraft.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	public static final Block meat_block = null;
	public static final Block white_sand = null;
	public static final Block tropical_planks = null;
	public static final Block mossy_stone = null;
	public static final Block chair = null;
	public static final Block mystery_portal_crate = null;
	public static final Block hardened_ice = null;
	public static final Block quarry = null;
	public static final Block cobium_block = null;
	public static final Block lithium_ore = null;
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.CAKE).hardnessAndResistance(1f, 0.1f).sound(SoundType.SLIME).slipperiness(0.7f)).setRegistryName("meat_block"));
		event.getRegistry().register(new SandBlock(16777215, Block.Properties.create(Material.SAND, MaterialColor.SAND).hardnessAndResistance(0.5f, 2.5f).sound(SoundType.SAND)).setRegistryName("white_sand"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2f, 15f).sound(SoundType.WOOD)).setRegistryName("tropical_planks"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(1.5f, 30f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(0).slipperiness(0.7f)).setRegistryName("mossy_stone"));
		event.getRegistry().register(new Chair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.3f, 10.0f).sound(SoundType.WOOD)).setRegistryName("chair"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.8f, 1000000.0f).sound(SoundType.METAL)).setRegistryName("mystery_portal_crate"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(35.0f, 1000000.0f).sound(SoundType.GLASS).harvestTool(ToolType.PICKAXE).harvestLevel(3).lightValue(9)).setRegistryName("hardened_ice"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(5.0f, 9.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("lithium_ore"));
		event.getRegistry().register(new QuarryBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(10.0f, 1000000.0f).sound(SoundType.ANVIL).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("quarry"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(60.0f, 1000000.0f).sound(SoundType.ANVIL).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("cobium_block"));
			
	}
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(meat_block, new Item.Properties().group(ItemGroup.DECORATIONS).maxStackSize(1)).setRegistryName("meat_block"));
		event.getRegistry().register(new BlockItem(white_sand, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("white_sand"));
		event.getRegistry().register(new BlockItem(chair, new Item.Properties().group(ItemGroup.DECORATIONS).maxStackSize(2)).setRegistryName("chair"));
		event.getRegistry().register(new BlockItem(mystery_portal_crate, new Item.Properties().group(ItemGroup.MISC).maxStackSize(16)).setRegistryName("mystery_portal_crate"));
		event.getRegistry().register(new BlockItem(hardened_ice, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("hardened_ice"));
		event.getRegistry().register(new BlockItem(quarry, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("quarry"));
		event.getRegistry().register(new BlockItem(mossy_stone, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("mossy_stone"));
		event.getRegistry().register(new BlockItem(tropical_planks, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("tropical_planks"));
		event.getRegistry().register(new BlockItem(cobium_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("cobium_block"));
		event.getRegistry().register(new BlockItem(lithium_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("lithium_ore"));
	}
}
