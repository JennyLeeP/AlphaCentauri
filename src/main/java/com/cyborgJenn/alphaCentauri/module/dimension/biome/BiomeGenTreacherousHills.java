package com.cyborgJenn.alphaCentauri.module.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenBoulders;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenTreacherousHills extends ACBiome
{
	public BiomeGenTreacherousHills(BiomeProperties biomeProperties) 
	{
		super(biomeProperties);
	}
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
	{      
		this.topBlock = ModBlocks.acGrass.getDefaultState();
		this.fillerBlock = ModBlocks.acDirt.getDefaultState();

		this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	@Override
	public BiomeDecorator createBiomeDecorator()
	{   
		return getModdedBiomeDecorator(new ACBiomeDecorator(this));
	}
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
	{
		super.decorate(worldIn, rand, pos);
	}
	@Override
	public int getModdedBiomeGrassColor(int ont)
	{
		return 0x5D8F92; // nice
	}
	@Override
	public int getModdedBiomeFoliageColor(int original)
	{
		return 0xad5cc9;
	}
}
