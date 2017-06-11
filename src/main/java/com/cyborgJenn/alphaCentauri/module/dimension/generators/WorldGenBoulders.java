package com.cyborgJenn.alphaCentauri.module.dimension.generators;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenBoulders  implements IWorldGenerator
{
	private Block blockUsed;
    private int blockMeta;

    public WorldGenBoulders(Block block, int meta)
    {
        block = this.blockUsed;
        this.blockMeta = meta;
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
