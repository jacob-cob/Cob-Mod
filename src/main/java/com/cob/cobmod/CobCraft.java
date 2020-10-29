package com.cob.cobmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cob.cobmod.init.BiomeInit;
import com.cob.cobmod.init.BlockInitNew;
import com.cob.cobmod.init.DimensionInit;
import com.cob.cobmod.init.EnchantmentInit;
import com.cob.cobmod.init.FluidInit;
import com.cob.cobmod.init.ItemInit;
import com.cob.cobmod.init.ItemInitNew;
import com.cob.cobmod.init.ModContainerTypes;
import com.cob.cobmod.init.ModEntityTypes;
import com.cob.cobmod.init.ModTileEntityTypes;
import com.cob.cobmod.init.PotionInit;
import com.cob.cobmod.init.SoundInit;
import com.cob.cobmod.objects.blocks.TomatoCrop;
import com.cob.cobmod.world.gen.OreGen;

import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("cobcraft")
@Mod.EventBusSubscriber(modid = CobCraft.MOD_ID, bus = Bus.MOD)
public class CobCraft {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "cobcraft";
	public static CobCraft instance;
	public static final ResourceLocation ANCIENT_DIMENSION_TYPE = new ResourceLocation(MOD_ID, "ancient_lands");

	public CobCraft() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::doClientStuff);

		SoundInit.SOUNDS.register(modEventBus);
		PotionInit.POTIONS.register(modEventBus);
		PotionInit.POTION_EFFECTS.register(modEventBus);
		EnchantmentInit.ENCHANTMENTS.register(modEventBus);
		
		ItemInitNew.ITEMS.register(modEventBus);
		FluidInit.FLUIDS.register(modEventBus);
		BlockInitNew.BLOCKS.register(modEventBus);
		
		ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
		ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);

		BiomeInit.BIOMES.register(modEventBus);
		DimensionInit.MOD_DIMENSIONS.register(modEventBus);

		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		BlockInitNew.BLOCKS.getEntries().stream()
				.filter(block -> !(block.get() instanceof TomatoCrop) && !(block.get() instanceof FlowingFluidBlock))
				.map(RegistryObject::get).forEach(block -> {
					final Item.Properties properties = new Item.Properties().group(ExtraGroup.instance);
					final BlockItem blockItem = new BlockItem(block, properties);
					blockItem.setRegistryName(block.getRegistryName());
					registry.register(blockItem);
				});
	}

	@SubscribeEvent
	public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
		BiomeInit.registerBiomes();
	}

	private void setup(final FMLCommonSetupEvent event) {
		ComposterBlock.registerCompostable(1, ItemInit.banana);
		ComposterBlock.registerCompostable(0.4f, ItemInit.tomato);
		ComposterBlock.registerCompostable(0.1f, ItemInitNew.TOMATO_SEED.get());
	}

	private void doClientStuff(final FMLClientSetupEvent event) {

	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}

	@SubscribeEvent
	public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
		OreGen.generateOre();
	}

	public static class JunkItemGroup extends ItemGroup {
		public static final JunkItemGroup instance = new JunkItemGroup(ItemGroup.GROUPS.length, "junktab");

		private JunkItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.soggy_paper);
		}
	}

	public static class ExtraGroup extends ItemGroup {
		public static final ExtraGroup instance = new ExtraGroup(ItemGroup.GROUPS.length, "extrastab");

		private ExtraGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.magic_staff);
		}
	}
}
