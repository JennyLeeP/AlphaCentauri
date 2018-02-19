package com.cyborgJenn.alphaCentauri.item.itemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockVanillaOres extends ItemBlock 
{
	private final static String[] subNames = {
			"gold", "iron", "lapis", "coal", "diamond", "emerald", "redstone"
		};
	public ItemBlockVanillaOres(Block block) 
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
		return "tile.ore_" + subNames[itemstack.getItemDamage()] ;
	}
}
