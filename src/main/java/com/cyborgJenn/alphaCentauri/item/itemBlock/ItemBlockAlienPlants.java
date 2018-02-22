package com.cyborgJenn.alphaCentauri.item.itemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockAlienPlants extends ItemBlock {

	private final static String[] subNames = {"phileptu", "dousiou"};
	
	public ItemBlockAlienPlants(Block block) 
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
		return "tile.alienplant_" + subNames[itemstack.getItemDamage()] ;
	}
}
