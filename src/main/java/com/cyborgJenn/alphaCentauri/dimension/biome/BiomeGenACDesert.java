package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.dimension.blocks.ModBlocks;

import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenFossils;

public class BiomeGenACDesert extends ACBiome 
{
	public BiomeGenACDesert(BiomeProperties properties) 
	{
		super(properties);
        this.spawnableCreatureList.clear();
        this.topBlock = ModBlocks.lightSand.getDefaultState();
        this.fillerBlock = ModBlocks.lightSand.getDefaultState();
        //this.biomeDecorator.treesPerChunk = 0;
        //this.biomeDecorator.deadBushPerChunk = 2;
        //this.biomeDecorator.reedsPerChunk = 50;
        //this.biomeDecorator.cactiPerChunk = 10;
        this.spawnableCreatureList.clear();
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 4, 2, 3));//TODO Bunnies ? Aliens ?
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
        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FOSSIL))
            if (rand.nextInt(64) == 0)
            {
                (new WorldGenFossils()).generate(worldIn, rand, pos);
            }
    }
}
