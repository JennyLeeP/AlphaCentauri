package com.cyborgJenn.alphaCentauri.core.handlers;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.BlockACSaplings1;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;

public class WorldEventHandler 
{
	private int BlockID;
	/** Used to make the sapling grow the tree **/
	@EventHandler
	public void bonemealUsed(BonemealEvent event)
	{
		if(event.getWorld().getBlockState(event.getPos()).getBlock() == ModBlocks.SAPLINGS1.getDefaultState())
		{
			AlphaCentauri.logger.info("Bonemeal the things");
			((BlockACSaplings1)ModBlocks.SAPLINGS1).grow(event.getWorld(), event.getPos(), ModBlocks.SAPLINGS1.getDefaultState());
		}
	}
}
