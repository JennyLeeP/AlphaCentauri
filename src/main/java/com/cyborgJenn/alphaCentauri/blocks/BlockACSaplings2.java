package com.cyborgJenn.alphaCentauri.blocks;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.blocks.BlockACPlanks2.EnumType;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockACSaplings2 extends BlockBush implements IGrowable {

	public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.<BlockACPlanks2.EnumType>create("variant", BlockACPlanks2.EnumType.class);
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

	public BlockACSaplings2() 
	{
		super(Material.PLANTS);
		this.blockSoundType = SoundType.PLANT;
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
		if (((Integer)state.getValue(STAGE)).intValue() == 0)
		{
			worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
		}
		else
		{
			this.generateTree(worldIn, pos, state, rand);
		}
	}
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) //TODO looks like this isnt finished
	{
		if (!TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
		switch ((BlockACPlanks2.EnumType)state.getValue(VARIANT))
		{
		case PEYLAL:
			//treeGen = new WorldGenSpiralTree(worldIn, pos);
			break;
		case NEFRALIA:
			//treeGen = new WorldGenSplotchTree(worldIn, pos);
			break;
		case BERATUZIA:
			//treeGen = new WorldGenMangroveTree(worldIn, pos);
			break;
		default:
			AlphaCentauri.logger.warn("Saplings2 tried to grow a tree that does not exist");
			break;
		}
	}
	/**
	 * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
	 * returns the metadata of the dropped item based on the old metadata of the block.
	 */
	public int damageDropped(IBlockState state)
	{
		return ((BlockACPlanks2.EnumType)state.getValue(VARIANT)).getMetadata();
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		for (BlockACPlanks2.EnumType blockplanks$enumtype : BlockACPlanks2.EnumType.values())
		{
			items.add(new ItemStack(this, 1, blockplanks$enumtype.getMetadata()));
		}
	}
	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, BlockACPlanks2.EnumType.byMetadata(meta & 3)).withProperty(STAGE, Integer.valueOf((meta & 8) % 4));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		i = i | ((BlockACPlanks2.EnumType)state.getValue(VARIANT)).getMetadata();
		i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
		return i;
	}

	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT, STAGE});
	}


}
