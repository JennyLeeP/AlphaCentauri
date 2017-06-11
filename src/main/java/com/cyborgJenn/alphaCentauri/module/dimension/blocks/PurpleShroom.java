package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PurpleShroom extends BlockBush implements IGrowable
{

	public PurpleShroom(String name)
	{
		super(Material.PLANTS);
		this.blockSoundType = SoundType.PLANT;
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setUnlocalizedName(Reference.MODID +"."+ name);
		GameRegistry.register(this, new ResourceLocation(Reference.MODID, name));
		GameRegistry.register(new ItemBlock(this), new ResourceLocation(Reference.MODID, name));
	}
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) 
	{
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		return (double)rand.nextFloat() < 0.4D;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		this.generatePurpleMushroom(worldIn, pos, state, rand);	
	}
	/**
     * Return true if the block can sustain a Bush
     */
	@Override
    protected boolean canSustainBush(IBlockState state)
    {
        return state.isFullBlock();
    }
	public boolean generatePurpleMushroom(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        worldIn.setBlockToAir(pos);
        WorldGenerator worldgenerator = null;

        if (this == ModBlocks.Purple_Mushroom)
        {
            worldgenerator = new WorldGenPurpleMushroom(Blocks.BROWN_MUSHROOM_BLOCK);// TODO make custom large mushroom.
        }
        if (worldgenerator != null && worldgenerator.generate(worldIn, rand, pos))
        {
            return true;
        }
        else
        {
            worldIn.setBlockState(pos, state, 3);
            return false;
        }
    }
}
