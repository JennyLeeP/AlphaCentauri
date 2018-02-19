package com.cyborgJenn.alphaCentauri.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SandstoneBlock extends Block {

	private int sandstoneBlocks = 6; // Number of blocks , 3 light and 3 dark
	
    private static final String[] sandstoneTypes = new String[] {"smooth", "carved", "normal"};

	protected SandstoneBlock(String name) 
	{
		super(Material.ROCK);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);

	}
	
}
