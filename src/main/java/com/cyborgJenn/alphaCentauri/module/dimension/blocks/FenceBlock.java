package com.cyborgJenn.alphaCentauri.module.dimension.blocks;



import java.util.List;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FenceBlock extends BlockFence{

	String[] TreeTypes = {"sparkling","charred","brilliant", "dark", "icebound", "infernal", "life", "death"};
	
	public FenceBlock() {
		super(Material.WOOD, MapColor.WOOD);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.blockSoundType = SoundType.WOOD;
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
	}
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */



	
	public static boolean canConnectFenceTo(int par0)
	{
		return true;
	}

	

	public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
	{
		return true;
	}
	

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
	{
		for(int i = 0; i < TreeTypes.length; i++)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}
	/*
	public int getRenderType()
	{
		return ZetaFenceRender.fenceModel;
	}
	*/
}
