package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import java.util.List;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SandstoneBlock extends Block {

	private int sandstoneBlocks = 6; // Number of blocks , 3 light and 3 dark
	
    private static final String[] sandstoneTypes = new String[] {"smooth", "carved", "normal"};

	protected SandstoneBlock(String name) 
	{
		super(Material.ROCK);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);

	}
	
}
