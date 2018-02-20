package com.cyborgJenn.alphaCentauri.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockACGrass extends Block implements IGrowable
{
	//public static final PropertyBool SNOWY = PropertyBool.create("snowy");
    // TODO Snow
	public BlockACGrass() 
	{
        super(Material.GRASS);
        //this.setDefaultState(this.blockState.getBaseState().withProperty(SNOWY, Boolean.valueOf(false)));
        this.setTickRandomly(true);
        this.setHardness(1.0F);
        this.blockSoundType = SoundType.PLANT;
        this.setHarvestLevel("shovel", 2);
        this.setResistance(25.0F);
    }
	/**
     * Get the actual Block state of this Block at the given position. This applies properties not visible in the
     * metadata, such as fence connections.
     */
	/*
	@Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos.up()).getBlock();
        return state.withProperty(SNOWY, Boolean.valueOf(block == Blocks.SNOW || block == Blocks.SNOW_LAYER));
    }
	*/
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > 2)
            {
                worldIn.setBlockState(pos, ModBlocks.ACDIRT.getDefaultState());
            }
            else
            {
                if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
                {
                    for (int i = 0; i < 4; ++i)
                    {
                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                        {
                            return;
                        }

                        IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                        if (iblockstate1.getBlock() == ModBlocks.ACDIRT /*&& iblockstate1.getValue(BlockACDirt.VARIANT) == BlockACDirt.DirtType.ACDIRT*/ && worldIn.getLightFromNeighbors(blockpos.up()) >= 4 && iblockstate.getLightOpacity(worldIn, pos.up()) <= 2)
                        {
                            worldIn.setBlockState(blockpos, ModBlocks.ACGRASS.getDefaultState());
                        }
                    }
                }
            }
        }
    }
    /**
    * Get the Item that this Block should drop when harvested.
    */
   @Nullable
   public Item getItemDropped(IBlockState state, Random rand, int fortune)
   {
       return ModBlocks.ACDIRT.getItemDropped(ModBlocks.ACDIRT.getDefaultState(), rand, fortune);
       //return Blocks.DIRT.getItemDropped(Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), rand, fortune);
   }

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) 
	{
		return true;
	}



	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		return true;
	}



	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		BlockPos blockpos = pos.up();

        for (int i = 0; i < 128; ++i)
        {
            BlockPos blockpos1 = blockpos;
            int j = 0;

            while (true)
            {
                if (j >= i / 16)
                {
                    if (worldIn.isAirBlock(blockpos1))
                    {
                        if (rand.nextInt(8) == 0)
                        {
                            worldIn.getBiome(blockpos1).plantFlower(worldIn, rand, blockpos1);
                        }
                        else
                        {
                            IBlockState iblockstate1 = Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS);

                            if (Blocks.TALLGRASS.canBlockStay(worldIn, blockpos1, iblockstate1))
                            {
                                worldIn.setBlockState(blockpos1, iblockstate1, 3);
                            }
                        }
                    }

                    break;
                }

                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);

                if (worldIn.getBlockState(blockpos1.down()).getBlock() != Blocks.GRASS || worldIn.getBlockState(blockpos1).isNormalCube())
                {
                    break;
                }

                ++j;
            }
        }
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable)
    {
		return true;
		
    }
	/**
     * Convert the BlockState into the correct metadata value
     */
	/*
    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }
    
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {SNOWY});
    }
    */

}
