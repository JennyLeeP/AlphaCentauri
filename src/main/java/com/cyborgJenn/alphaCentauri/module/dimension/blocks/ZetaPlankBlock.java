package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import java.util.List;

import com.cyborgJenn.alphaCentauri.core.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ZetaPlankBlock extends Block{
	
	String[] PlankTypes ={"sparkling","charred","brilliant", "dark", "icebound", "infernal", "life", "death"};
	public ZetaPlankBlock() {
		super(Material.WOOD);
		this.setHardness(2.0F);
		this.setSoundType(SoundType.WOOD);
		//TODO add Flamability
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List list)
	{
		for(int i = 0; i < PlankTypes.length; i++){
			list.add(new ItemStack(par1, 1, i));
		}
	}
}
