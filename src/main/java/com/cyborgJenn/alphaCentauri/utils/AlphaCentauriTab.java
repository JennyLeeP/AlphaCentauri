package com.cyborgJenn.alphaCentauri.utils;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AlphaCentauriTab extends CreativeTabs
{
	public AlphaCentauriTab(int id, String name)
	{
		super(id, name);
		this.setNoTitle();
		this.setBackgroundImageName("cyborgutils.png");  
	}
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Item.getItemFromBlock(ModBlocks.gateAlphaCentauri));	
	}
	@Override
	public boolean hasSearchBar()
	{
		return false;
	}
}
