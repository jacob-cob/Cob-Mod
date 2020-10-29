package com.cob.cobmod.init;

import com.cob.cobmod.CobCraft;

import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {

	public static final ResourceLocation ACIDIC_LIQUID_STILL_RL = new ResourceLocation(CobCraft.MOD_ID,
			"blocks/acidic_liquid_still");

	public static final ResourceLocation ACIDIC_LIQUID_FLOWING_RL = new ResourceLocation(CobCraft.MOD_ID,
			"blocks/acidic_liquid_flowing");

	public static final ResourceLocation ACIDIC_LIQUID_OVERLAY_RL = new ResourceLocation(CobCraft.MOD_ID,
			"blocks/acidic_liquid_overlay");

	public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS,
			CobCraft.MOD_ID);

	public static final RegistryObject<FlowingFluid> ACIDIC_LIQUID_FLUID = FLUIDS.register("acidic_liquid_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.ACIDIC_LIQUID_PROPERTIES));	

	public static final RegistryObject<FlowingFluid> ACIDIC_LIQUID_FLOWING = FLUIDS.register("acidic_liquid_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.ACIDIC_LIQUID_PROPERTIES));
	
	public static final RegistryObject<FlowingFluidBlock> ACIDIC_LIQUID_BLOCK = BlockInitNew.BLOCKS.register("acidic_liquid",
			() -> new FlowingFluidBlock(() -> FluidInit.ACIDIC_LIQUID_FLUID.get(), Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));

	public static final ForgeFlowingFluid.Properties ACIDIC_LIQUID_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> ACIDIC_LIQUID_FLUID.get(), () -> ACIDIC_LIQUID_FLOWING.get(),
			FluidAttributes.builder(ACIDIC_LIQUID_STILL_RL, ACIDIC_LIQUID_FLOWING_RL).density(10).luminosity(100)
					.rarity(Rarity.RARE).sound(SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE)
					.overlay(ACIDIC_LIQUID_OVERLAY_RL)).block(() -> FluidInit.ACIDIC_LIQUID_BLOCK.get());

}
