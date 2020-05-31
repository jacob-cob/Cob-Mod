package com.cob.cobmod.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfiFuelItem extends Item 
{

	public InfiFuelItem(Properties properties) {
		super(properties);
	}
	@Override
	public int getBurnTime(ItemStack itemStack) 
	{
		return 72000;
	}
	
}
