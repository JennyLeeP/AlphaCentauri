package com.cyborgJenn.alphaCentauri.item.itemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockACPlank2 extends ItemBlock 
{
	private final static String[] subNames = {"peylal", "nefralia", "beratuzia"};
	
	public ItemBlockACPlank2(Block block) 
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
		return "tile.plank_" + subNames[itemstack.getItemDamage()] ;
	}

}
