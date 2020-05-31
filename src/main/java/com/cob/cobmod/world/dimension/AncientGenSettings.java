package com.cob.cobmod.world.dimension;

import net.minecraft.world.gen.GenerationSettings;

public class AncientGenSettings extends GenerationSettings {
	
	public int getBiomeSize() {
		return 4;
	}
	public int getRiverSize() {
		return 8;
	}
	public int getBiomeId() {
		return -1;
	}
	
	@Override
	public int getBedrockFloorHeight() {
		return 0;
	}
}
