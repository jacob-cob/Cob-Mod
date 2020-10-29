package com.cob.cobmod.objects.items;

import java.util.List;

import com.cob.cobmod.util.helpers.KeyboardHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class PhoneItem extends Item{

	public PhoneItem(Properties properties) {
		super(properties);
	}
	
	public static int apps;
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		
		if(KeyboardHelper.isHoldingShift())
		{
			tooltip.add(new StringTextComponent("\u00A7a"+"Wow! A phone, right click to change apps"));
			tooltip.add(new StringTextComponent("\u00A7a"+"Current app ID: "+(apps/2+1042)));
		} else {
			tooltip.add(new StringTextComponent("Hold "+ "\u00A7e" +" SHIFT "+ "\u00A77"+" for more info"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) 
	{
		apps = apps + 1;
		if(apps > 10) {
			apps = 1;
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
