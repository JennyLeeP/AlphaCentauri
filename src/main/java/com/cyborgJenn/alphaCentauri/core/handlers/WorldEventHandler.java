package com.cyborgJenn.alphaCentauri.core.handlers;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.BlockACSaplings1;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WorldEventHandler 
{
	/** Used to make the sapling grow the tree 
	 * @return **/
	@SubscribeEvent
	public void onBoneMeal(BonemealEvent event)
	{
		AlphaCentauri.logger.info("Bonemeal the things");
		
		if (event.getResult() == Result.DEFAULT && event.getBlock().equals(ModBlocks.SAPLINGS1))
		{
			if (!event.getWorld().isRemote)
			{
				((BlockACSaplings1)ModBlocks.SAPLINGS1).grow(event.getWorld(), event.getPos(), ModBlocks.SAPLINGS1.getDefaultState());
			}
			event.setResult(Result.ALLOW);
		}
	}
}
