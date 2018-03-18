package com.cyborgJenn.alphaCentauri.item.itemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockACDoublePlants extends ItemBlock {

private final static String[] subNames = {"glowbulb", "flipant"};
	
	public ItemBlockACDoublePlants(Block block) 
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
		return "tile.plant_" + subNames[itemstack.getItemDamage()] ;
	}

}
