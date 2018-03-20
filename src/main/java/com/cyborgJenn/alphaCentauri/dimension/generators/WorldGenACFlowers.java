package com.cyborgJenn.alphaCentauri.dimension.generators;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.BlockACFlowers;
import com.cyborgJenn.alphaCentauri.blocks.BlockACFlowers.EnumType;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenACFlowers extends WorldGenerator 
{
	private BlockACFlowers flower;
	private IBlockState state;
	
	public WorldGenACFlowers(BlockACFlowers flower, BlockACFlowers.EnumType type) 
	{
		this.setFLowerToGen(flower, type);
	}
	private void setFLowerToGen(BlockACFlowers flowerIn, EnumType type) 
	{
		this.flower = flowerIn;
		this.state = flowerIn.getDefaultState().withProperty(BlockACFlowers.VARIANT, type);
	}
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) 
	{
		for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && this.flower.canBlockStay(worldIn, blockpos, this.state))
            {
                worldIn.setBlockState(blockpos, this.state, 2);
            }
        }

        return true;
    }
}
