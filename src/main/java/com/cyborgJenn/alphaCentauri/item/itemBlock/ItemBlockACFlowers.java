package com.cyborgJenn.alphaCentauri.item.itemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockACFlowers extends ItemBlock {

private final static String[] subNames = {
		"white", "orange", "magenta", "lightblue", "yellow", "lime", "pink", "gray", 
		"lightgray", "cyan", "purple", "blue", "brown", "green", "red", "black" 
		};
	
	public ItemBlockACFlowers(Block block) 
	{
		super(block);
		setHasSubtypes(true);
	}
	@Override
	public int getMetadata (int damageValue) 
	{
		return damageValue;
	}
	@Override
	public String getUnlocalizedName(ItemStack itemstack) 
	{
		return "tile.flower_" + subNames[itemstack.getItemDamage()] ;
	}

}
