package com.cyborgJenn.alphaCentauri.dimension.util;

import com.cyborgJenn.alphaCentauri.dimension.biome.ModBiomes;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@Mod.EventBusSubscriber
public class DimensionEntityHandler 
{
	@SubscribeEvent
	public static void updateBiomeFogColor(EntityViewRenderEvent.FogColors event)
	{
		BlockPos pos = event.getEntity().getPosition();
		Biome biome = event.getEntity().getEntityWorld().getBiomeProvider().getBiome(pos);

		if (biome != null)
		{
			if (biome == ModBiomes.PAINTED_CLIFFS)
			{
				event.setRed(0.481F);
				event.setGreen(0.414F);
				event.setBlue(0.425F);
			}
			if (biome == ModBiomes.FUNGALFOREST)
			{
				event.setRed(0.657F);
				event.setGreen(0.528F);
				event.setBlue(0.578F);
			}

		}	
	}
	@SubscribeEvent
	public static void updateBiomeFogDensity(EntityViewRenderEvent.FogDensity event)
	{
		BlockPos pos = event.getEntity().getPosition();
		Biome biome = event.getEntity().getEntityWorld().getBiomeProvider().getBiome(pos);
		if (biome != null )
		{
			if (biome == ModBiomes.PAINTED_CLIFFS)
			{
				event.setDensity(0.007655F);
			}
			if (biome == ModBiomes.FUNGALFOREST)
			{
				event.setDensity(1.077655F);
			}
		
		}	
	}
}
