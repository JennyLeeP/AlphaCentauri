package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BiomeGenLivingPlateau extends ACBiome{

	public BiomeGenLivingPlateau(BiomeProperties biomeProperties) {
		super(biomeProperties);
        this.spawnableCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.topBlock = ModBlocks.acGrass.getDefaultState();
        this.fillerBlock = ModBlocks.acDirt.getDefaultState();
        
	}
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        super.decorate(worldIn, rand, pos);
    }
}
