package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import java.util.List;

import com.cyborgJenn.alphaCentauri.core.utils.Reference;

import net.minecraft.block.BlockLog;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ZetaLogBlock2 extends BlockLog{
	
	public static final String[] logTypes = new String[] {"icebound", "brilliant", "life", "sparkling"};

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
    	for (int i = 0; i < this.logTypes.length; i++){
    		list.add(new ItemStack(item, 1, i));
    	}
    }

   
}
