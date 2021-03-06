package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.BlockACSand;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenFossils;

public class BiomeACDesert extends ACBiome 
{
	public BiomeACDesert(BiomeProperties properties) 
	{
		super(properties);
        this.topBlock = ModBlocks.SAND.getDefaultState().withProperty(BlockACSand.VARIANT, BlockACSand.EnumType.LIGHT);
        this.fillerBlock = ModBlocks.SAND.getDefaultState().withProperty(BlockACSand.VARIANT, BlockACSand.EnumType.LIGHT);
        this.customBiomeDecorator.treesPerChunk = -999;
        this.customBiomeDecorator.deadBushPerChunk = 2;
        this.customBiomeDecorator.reedsPerChunk = 50;
        this.customBiomeDecorator.cactiPerChunk = 10;
	}
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        super.decorate(worldIn, rand, pos);
        //TODO make desert less boring.
        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FOSSIL))
            if (rand.nextInt(64) == 0)
            {
                (new WorldGenFossils()).generate(worldIn, rand, pos);
            }
    }
}
