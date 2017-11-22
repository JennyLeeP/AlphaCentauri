package com.cyborgJenn.alphaCentauri.core.utils;

import com.cyborgJenn.alphaCentauri.core.item.ModItems;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
