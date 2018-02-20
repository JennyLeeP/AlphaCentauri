package com.cyborgJenn.alphaCentauri.item.itemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockACGravel extends ItemBlock {

private final static String[] subNames = {"blue", "red", "dark", "purple", "rusty"};
	
	public ItemBlockACGravel(Block block) 
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
		return "tile.gravel_" + subNames[itemstack.getItemDamage()] ;
	}
}
