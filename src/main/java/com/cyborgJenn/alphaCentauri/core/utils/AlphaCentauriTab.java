package com.cyborgJenn.alphaCentauri.core.utils;

import com.cyborgJenn.alphaCentauri.core.item.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class AlphaCentauriTab extends CreativeTabs{

	public AlphaCentauriTab(int id, String name)
	  {
	    super(id, name);
	    this.setBackgroundImageName("cyborgutils_search.png");
	    
	  }
	
	@Override
	public Item getTabIconItem() {
		if (Config.enableModuleAccessories)
		{
			return ModItems.Sextant;
		}else {
			return Items.DIAMOND_SWORD;
		}
		
	}
	@Override
	public boolean hasSearchBar()
	{
		return true;
	}
}
