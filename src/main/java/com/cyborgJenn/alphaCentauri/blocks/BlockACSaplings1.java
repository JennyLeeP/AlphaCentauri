package com.cyborgJenn.alphaCentauri.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.dimension.generators.trees.WorldGenHouseTree;
import com.cyborgJenn.alphaCentauri.dimension.generators.trees.WorldGenMangroveTree;
import com.cyborgJenn.alphaCentauri.dimension.generators.trees.WorldGenSpiralTree;
import com.cyborgJenn.alphaCentauri.dimension.generators.trees.WorldGenSplotchTree;

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
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockACSaplings1 extends BlockBush implements IGrowable 
{
	public static final PropertyEnum<BlockACPlanks1.EnumType> VARIANT = PropertyEnum.<BlockACPlanks1.EnumType>create("variant", BlockACPlanks1.EnumType.class);
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

	public BlockACSaplings1() 
	{
		super(Material.PLANTS);
		this.blockSoundType = SoundType.PLANT;
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return SAPLING_AABB;
	}
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (!worldIn.isRemote)
		{
			super.updateTick(worldIn, pos, state, rand);

			if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
			{
				this.grow(worldIn, rand, pos, state);
			}
		}
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
	public void grow(World world, BlockPos pos, IBlockState state) 
	{
		Random rand = new Random();
		this.grow(world, rand, pos, state);

	}
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) //TODO looks like this isnt finished
	{
		if (!TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
		//AlphaCentauri.logger.info(state.getValue(VARIANT));
		switch ((BlockACPlanks1.EnumType)state.getValue(VARIANT))
		{
		case SPIRAL:
			new WorldGenSpiralTree(worldIn, pos);
			break;
		case SPLOTCH:
			new WorldGenSplotchTree(worldIn, pos);
//			labelSplo:
//				
//			for (int i = 0; i >= -1; --i)
//            {
//                for (int j = 0; j >= -1; --j)
//                {
//					if (isTwoByTwo(worldIn, pos, i, j, BlockACPlanks1.EnumType.SPLOTCH)) {
//						treeGen = new WorldGenSplotchTree(worldIn, pos);
//						break labelSplo;
//					}
//                }
//            }
			break;
			
		case MANGROVE:
			new WorldGenMangroveTree(worldIn, pos);
			break;
		case ADANSONIA:
			List<BlockPos> sapList = getsaplingRectangle(worldIn, pos, BlockACPlanks1.EnumType.ADANSONIA);
			AlphaCentauri.logger.info(sapList != null);
			if (sapList != null) new WorldGenHouseTree(worldIn, sapList);
//			labelAdon:
//				
//				for (i = 0; i >= -1; --i)
//                {
//                    for (j = 0; j >= -1; --j)
//                    {
//						if (isThreeByThree(worldIn, pos, i, j, BlockACPlanks1.EnumType.ADANSONIA)) {
//							treeGen = new WorldGenHouseTree(worldIn, pos);
//							break labelAdon;
//						}
//                    }
//                }
			break;
			
		default:
			AlphaCentauri.logger.warn("Saplings tried to grow a tree that does not exist");
			break;
		}
	}
	@SuppressWarnings("unused")
	private boolean isTwoByTwo(World worldIn, BlockPos pos, int X, int Z, BlockACPlanks1.EnumType type)
	{
		return this.isTypeAt(worldIn, pos.add(X, 0, Z), type) && this.isTypeAt(worldIn, pos.add(X + 1, 0, Z), type) && this.isTypeAt(worldIn, pos.add(X, 0, Z + 1), type) && this.isTypeAt(worldIn, pos.add(X + 1, 0, Z + 1), type);
	}
	@SuppressWarnings("unused")
	private boolean isThreeByThree(World worldIn, BlockPos pos, int X, int Z, BlockACPlanks1.EnumType type) {
		return this.isTypeAt(worldIn, pos.add(X, 0, Z), type) && this.isTypeAt(worldIn, pos.add(X + 1, 0, Z), type) && this.isTypeAt(worldIn, pos.add(X + 2, 0, Z), type) 
				&& this.isTypeAt(worldIn, pos.add(X, 0, Z + 1), type) && this.isTypeAt(worldIn, pos.add(X, 0, Z + 2), type) && this.isTypeAt(worldIn, pos.add(X + 1, 0, Z + 1), type)
				&& this.isTypeAt(worldIn, pos.add(X + 2, 0, Z + 1), type) && this.isTypeAt(worldIn, pos.add(X + 2, 0, Z + 2), type) && this.isTypeAt(worldIn, pos.add(X + 1, 0, Z + 2), type);
	}
	
	private List<BlockPos> getsaplingRectangle(World worldIn, BlockPos pos, BlockACPlanks1.EnumType type) {
		//find direction
		EnumFacing currDirection = null;
		List<BlockPos> corners = new ArrayList<BlockPos>();
		List<BlockPos> sapList = new ArrayList<BlockPos>();
		boolean rotationClockwise = false;
		for (EnumFacing direction:EnumFacing.HORIZONTALS) {
			if (this.isTypeAt(worldIn, pos.offset(direction), type)) {
				currDirection = direction;
				break;
			}
		}
		if (currDirection == null) {
			return null; //single sapling
		}
		BlockPos currpos = pos;
		//if turning, register turn direction, register corner, continue
		//if not turning, go straight and recheck
		//return to original sapling, return corners list
		//if turns more than 4, more than 40 spalings traversed or line stops, return null
		for (int i = 0; i <30; i++) {
			currpos = currpos.offset(currDirection); //move forward
			sapList.add(currpos);
			if (this.isTypeAt(worldIn, currpos.offset(currDirection.rotateY()), type) && (corners.size() == 0 || rotationClockwise)) { //a sapling exists clockwise of direction AND no corners have been found OR we are going clockwise
				rotationClockwise = true;
				corners.add(currpos);
				currDirection = currDirection.rotateY();
			}
			else if (this.isTypeAt(worldIn, currpos.offset(currDirection.rotateYCCW()), type) && (corners.size() == 0 || !rotationClockwise)) { //a sapling exists counterclockwise of direction AND no corners have been found OR we are going ccounterlockwise
				corners.add(currpos);
				currDirection = currDirection.rotateYCCW();
			}
			else if (!this.isTypeAt(worldIn, currpos.offset(currDirection), type)) { //moving straight, no saplings were found CW or CCW or forward
				return null;
			}
			//else keep moving straight
			if (corners.size() > 4) { //cant have more than 4 corners
				return null;
			}
			if (currpos.equals(pos)) { //Back to start YAY
				return sapList;
			}
		}
		return null;
	}
	
	
	/**
	 * Check whether the given BlockPos has a Sapling of the given type
	 */
	public boolean isTypeAt(World worldIn, BlockPos pos, BlockACPlanks1.EnumType variant)
	{
		IBlockState iblockstate = worldIn.getBlockState(pos);
		return iblockstate.getBlock() == this && iblockstate.getValue(VARIANT) == variant;
	}
	/**
	 * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
	 * returns the metadata of the dropped item based on the old metadata of the block.
	 */
	public int damageDropped(IBlockState state)
	{
		return ((BlockACPlanks1.EnumType)state.getValue(VARIANT)).getMetadata();
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
    @SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		for (BlockACPlanks1.EnumType blockplanks$enumtype : BlockACPlanks1.EnumType.values())
		{
			items.add(new ItemStack(this, 1, blockplanks$enumtype.getMetadata()));
		}
	}
	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, BlockACPlanks1.EnumType.byMetadata(meta & 3)).withProperty(STAGE, Integer.valueOf((meta & 8) % 4));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		i = i | ((BlockACPlanks1.EnumType)state.getValue(VARIANT)).getMetadata();
		i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
		return i;
	}

	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT, STAGE});
	}
}
