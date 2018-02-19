package com.cyborgJenn.alphaCentauri.item.itemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockACLog1 extends ItemBlock
{
	private final static String[] subNames = {
			"spiral", "splotch", "mangrove", "adansonia"
		};
	public ItemBlockACLog1(Block block)
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
		return "tile.log_" + subNames[itemstack.getItemDamage()] ;
	}
}
