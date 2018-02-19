package com.cyborgJenn.alphaCentauri.handlers;

import com.cyborgJenn.alphaCentauri.proxy.CommonProxy;

import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CyborgEventHandler 
{
	public static int dimension;

	/*
	 * Gets the MinecraftForge WorldEvent.
	 */
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void getWorldEvent(WorldEvent event)
	{
		dimension = event.getWorld().provider.getDimension();
	}

	/*
	 * Gets the MinecraftForge MapGen event type
	 */
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void getMapGenEvent(InitMapGenEvent event)
	{
		if (dimension == 0){
			switch(event.getType()){
			case CAVE:
				//TODO fix cave Gen event.setNewGen(CommonProxy.caveGen); //= CyborgUtils.caveGen;
				break;
			case CUSTOM:
				break;
			case MINESHAFT:
				break;
			case NETHER_BRIDGE:
				break;
			case NETHER_CAVE:
				break;
			case RAVINE:// TODO larger Ravines
				break;
			case SCATTERED_FEATURE:
				break;
			case STRONGHOLD:
				break;
			case VILLAGE:
				break;
			case OCEAN_MONUMENT:
				break;
			default:
				break;
				
			}
			
		}


	}
	
}
