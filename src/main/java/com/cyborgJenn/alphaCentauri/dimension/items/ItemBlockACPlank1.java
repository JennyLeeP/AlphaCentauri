package com.cyborgJenn.alphaCentauri.dimension.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockACPlank1 extends ItemBlock 
{
	private final static String[] subNames = {"spiral", "splotch", "mangrove", "adonsonia"};
	
	public ItemBlockACPlank1(Block block) 
	{
		super(block);
		setHasSubtypes(true);
	}
	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return "tile.plank_" + subNames[itemstack.getItemDamage()] ;
	}

}
