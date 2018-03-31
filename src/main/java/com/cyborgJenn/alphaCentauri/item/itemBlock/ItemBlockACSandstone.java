package com.cyborgJenn.alphaCentauri.item.itemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockACSandstone extends ItemBlock 
{
	private final static String[] subNames = {"light_normal", "light_smooth",
			"light_chiseled","medium_normal","medium_smooth","medium_chiseled",
			"dark_normal","dark_smooth","dark_chiseled"};
	public ItemBlockACSandstone(Block block) {
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
		return "tile.sandstone_" + subNames[itemstack.getItemDamage()] ;
	}
}
