package com.cyborgJenn.alphaCentauri.dimension.generators;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenBoulders  implements IWorldGenerator
{
	private Block blockUsed;

    public WorldGenBoulders(Block block)
    {
        block = this.blockUsed;
    }

    public WorldGenBoulders() 
    {
		// TODO Boulders
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		// TODO Auto-generated method stub	
	}
}
