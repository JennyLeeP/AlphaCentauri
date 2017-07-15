package com.cyborgJenn.alphaCentauri.module.dimension.util;

import com.cyborgJenn.alphaCentauri.module.dimension.biome.ModBiomes;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DimensionEntityHandler 
{
	@SubscribeEvent
	public void updateBiomeFogColor(EntityViewRenderEvent.FogColors event)
	{
		BlockPos pos = event.getEntity().getPosition();
		Biome biome = event.getEntity().getEntityWorld().getBiomeProvider().getBiome(pos);
		
		if (biome != null && biome == ModBiomes.HOODOO_VALLEY)
		{
			event.setRed(0.481F);
			event.setGreen(0.414F);
			event.setBlue(0.425F);
		}	
	}
	@SubscribeEvent
	public void updateBiomeFogDensity(EntityViewRenderEvent.FogDensity event)
	{
		BlockPos pos = event.getEntity().getPosition();
		Biome biome = event.getEntity().getEntityWorld().getBiomeProvider().getBiome(pos);
		if (biome != null && biome == ModBiomes.HOODOO_VALLEY)
		{
			event.setDensity(0.007655F);
			//event.setCanceled(true);
		}	
	}
}
