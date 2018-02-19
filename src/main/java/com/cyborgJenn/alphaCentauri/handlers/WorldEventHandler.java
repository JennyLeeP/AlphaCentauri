package com.cyborgJenn.alphaCentauri.handlers;

import com.cyborgJenn.alphaCentauri.blocks.BlockACSaplings1;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@Mod.EventBusSubscriber
public class WorldEventHandler 
{
	/** Used to make the sapling grow the tree 
	 * @return **/
	@SubscribeEvent
	public static void onBoneMeal(BonemealEvent event)
	{
		if (event.getResult() == Result.DEFAULT && event.getBlock().getBlock() == ModBlocks.SAPLINGS1)
		{
			if (!event.getWorld().isRemote)
			{
				((BlockACSaplings1)ModBlocks.SAPLINGS1).grow(event.getWorld(), event.getPos(), ModBlocks.SAPLINGS1.getDefaultState());
			}
			event.setResult(Result.ALLOW);
		}
	}
}
