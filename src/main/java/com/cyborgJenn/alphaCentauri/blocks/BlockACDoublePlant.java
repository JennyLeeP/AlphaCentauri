package com.cyborgJenn.alphaCentauri.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenUtils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockACDoublePlant extends BlockBush implements IGrowable, net.minecraftforge.common.IShearable
{
	public static final PropertyEnum<BlockACDoublePlant.EnumPlantType> VARIANT = PropertyEnum.<BlockACDoublePlant.EnumPlantType>create("variant", BlockACDoublePlant.EnumPlantType.class);
	public static final PropertyEnum<BlockACDoublePlant.EnumBlockHalf> HALF = PropertyEnum.<BlockACDoublePlant.EnumBlockHalf>create("half", BlockACDoublePlant.EnumBlockHalf.class);

	public BlockACDoublePlant() 
	{
		super(Material.VINE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockACDoublePlant.EnumPlantType.GLOWBULB).withProperty(HALF, BlockACDoublePlant.EnumBlockHalf.LOWER));
		this.setHardness(0.0F);
		this.setSoundType(SoundType.PLANT);
		this.setLightLevel(0.5F);
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return FULL_BLOCK_AABB;
	}

	private BlockACDoublePlant.EnumPlantType getType(IBlockAccess blockAccess, BlockPos pos, IBlockState state)
	{
		if (state.getBlock() == this)
		{
			state = state.getActualState(blockAccess, pos);
			return (BlockACDoublePlant.EnumPlantType)state.getValue(VARIANT);
		}
		else
		{
			return BlockACDoublePlant.EnumPlantType.GLOWBULB;
		}
	}
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		return super.canPlaceBlockAt(worldIn, pos) && worldIn.isAirBlock(pos.up());
	}

	/**
	 * Whether this Block can be replaced directly by other blocks (true for e.g. tall grass)
	 */
	@Override
	public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
	{
		IBlockState iblockstate = worldIn.getBlockState(pos);

		if (iblockstate.getBlock() != this)
		{
			return true;
		}
		else
		{
			BlockACDoublePlant.EnumPlantType blockdoubleplant$enumplanttype = (BlockACDoublePlant.EnumPlantType)iblockstate.getActualState(worldIn, pos).getValue(VARIANT);
			return blockdoubleplant$enumplanttype == BlockACDoublePlant.EnumPlantType.GLOWBULB || blockdoubleplant$enumplanttype == BlockACDoublePlant.EnumPlantType.FLIPANT;
		}
	}
	@Override
	protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		if (!this.canBlockStay(worldIn, pos, state))
		{
			boolean flag = state.getValue(HALF) == BlockACDoublePlant.EnumBlockHalf.UPPER;
			BlockPos blockpos = flag ? pos : pos.up();
			BlockPos blockpos1 = flag ? pos.down() : pos;
			Block block = (Block)(flag ? this : worldIn.getBlockState(blockpos).getBlock());
			Block block1 = (Block)(flag ? worldIn.getBlockState(blockpos1).getBlock() : this);

			if (!flag) this.dropBlockAsItem(worldIn, pos, state, 0); //Forge move above the setting to air.

			if (block == this)
			{
				worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 2);
			}

			if (block1 == this)
			{
				worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
			}
		}
	}
	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
	{
		if (state.getBlock() != this) return super.canBlockStay(worldIn, pos, state); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
		if (state.getValue(HALF) == BlockACDoublePlant.EnumBlockHalf.UPPER)
		{
			return worldIn.getBlockState(pos.down()).getBlock() == this;
		}
		else
		{
			IBlockState iblockstate = worldIn.getBlockState(pos.up());
			return iblockstate.getBlock() == this && super.canBlockStay(worldIn, pos, iblockstate);
		}
	}
	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if (state.getValue(HALF) == BlockACDoublePlant.EnumBlockHalf.UPPER)
		{
			return Items.AIR;
		}
		else
		{
			BlockACDoublePlant.EnumPlantType blockdoubleplant$enumplanttype = (BlockACDoublePlant.EnumPlantType)state.getValue(VARIANT);

			if (blockdoubleplant$enumplanttype == BlockACDoublePlant.EnumPlantType.GLOWBULB)
			{
				return Items.AIR;
			}
			else if (blockdoubleplant$enumplanttype == BlockACDoublePlant.EnumPlantType.FLIPANT)
			{
				return Items.AIR; //TODO drop something.
				//return rand.nextInt(8) == 0 ? Items.DIAMOND: Items.AIR;
			}
			else
			{
				return super.getItemDropped(state, rand, fortune);
			}
		}
	}
	/**
	 * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
	 * returns the metadata of the dropped item based on the old metadata of the block.
	 */
	@Override
	public int damageDropped(IBlockState state)
	{
		return state.getValue(HALF) != BlockACDoublePlant.EnumBlockHalf.UPPER && state.getValue(VARIANT) != BlockACDoublePlant.EnumPlantType.FLIPANT ? ((BlockACDoublePlant.EnumPlantType)state.getValue(VARIANT)).getMeta() : 0;
	}
	public void placeAt(World worldIn, BlockPos lowerPos, BlockACDoublePlant.EnumPlantType variant, int flags)
	{
		if (WorldGenUtils.isPosDarkEnough(worldIn, lowerPos)){
			worldIn.setBlockState(lowerPos, this.getDefaultState().withProperty(HALF, BlockACDoublePlant.EnumBlockHalf.LOWER).withProperty(VARIANT, variant), flags);
			worldIn.setBlockState(lowerPos.up(), this.getDefaultState().withProperty(HALF, BlockACDoublePlant.EnumBlockHalf.UPPER), flags);
		}
	}
	/**
	 * Called by ItemBlocks after a block is set in the world, to allow post-place logic
	 */
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		worldIn.setBlockState(pos.up(), this.getDefaultState().withProperty(HALF, BlockACDoublePlant.EnumBlockHalf.UPPER), 2);
	}

	/**
	 * Spawns the block's drops in the world. By the time this is called the Block has possibly been set to air via
	 * Block.removedByPlayer
	 */
	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
	{
		{
			super.harvestBlock(worldIn, player, pos, state, te, stack);
		}
	}
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		if (state.getValue(HALF) == BlockACDoublePlant.EnumBlockHalf.UPPER)
		{
			if (worldIn.getBlockState(pos.down()).getBlock() == this)
			{
				if (player.capabilities.isCreativeMode)
				{
					worldIn.setBlockToAir(pos.down());
				}
				else
				{
					IBlockState iblockstate = worldIn.getBlockState(pos.down());
					BlockACDoublePlant.EnumPlantType blockdoubleplant$enumplanttype = (BlockACDoublePlant.EnumPlantType)iblockstate.getValue(VARIANT);

					if (blockdoubleplant$enumplanttype != BlockACDoublePlant.EnumPlantType.GLOWBULB && blockdoubleplant$enumplanttype != BlockACDoublePlant.EnumPlantType.FLIPANT)
					{
						worldIn.destroyBlock(pos.down(), true);
					}
					else if (worldIn.isRemote)
					{
						worldIn.setBlockToAir(pos.down());
					}
					else if (!player.getHeldItemMainhand().isEmpty() && player.getHeldItemMainhand().getItem() == Items.SHEARS)
					{
						worldIn.setBlockToAir(pos.down());
					}
					else
					{
						worldIn.destroyBlock(pos.down(), true);
					}
				}
			}
		}
		else if (worldIn.getBlockState(pos.up()).getBlock() == this)
		{
			worldIn.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 2);
		}

		super.onBlockHarvested(worldIn, pos, state, player);
	}
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		for (BlockACDoublePlant.EnumPlantType blockdoubleplant$enumplanttype : BlockACDoublePlant.EnumPlantType.values())
		{
			items.add(new ItemStack(this, 1, blockdoubleplant$enumplanttype.getMeta()));
		}
	}
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(this, 1, this.getType(worldIn, pos, state).getMeta());
	}
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		BlockACDoublePlant.EnumPlantType blockdoubleplant$enumplanttype = this.getType(worldIn, pos, state);
		return blockdoubleplant$enumplanttype != BlockACDoublePlant.EnumPlantType.FLIPANT && blockdoubleplant$enumplanttype != BlockACDoublePlant.EnumPlantType.GLOWBULB;
	}
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		return true;
	}
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		spawnAsEntity(worldIn, pos, new ItemStack(this, 1, this.getType(worldIn, pos, state).getMeta()));
	}
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return (meta & 8) > 0 ? this.getDefaultState().withProperty(HALF, BlockACDoublePlant.EnumBlockHalf.UPPER) : this.getDefaultState().withProperty(HALF, BlockACDoublePlant.EnumBlockHalf.LOWER).withProperty(VARIANT, BlockACDoublePlant.EnumPlantType.byMetadata(meta & 7));
	}
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		if (state.getValue(HALF) == BlockACDoublePlant.EnumBlockHalf.UPPER)
		{
			IBlockState iblockstate = worldIn.getBlockState(pos.down());

			if (iblockstate.getBlock() == this)
			{
				state = state.withProperty(VARIANT, iblockstate.getValue(VARIANT));
			}
		}

		return state;
	}
	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(HALF) == BlockACDoublePlant.EnumBlockHalf.UPPER ? 8 : ((BlockACDoublePlant.EnumPlantType)state.getValue(VARIANT)).getMeta();
	}
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {HALF, VARIANT});
	}
	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos)
	{
		IBlockState state = world.getBlockState(pos);
		EnumPlantType type = (EnumPlantType)state.getValue(VARIANT);
		return state.getValue(HALF) == EnumBlockHalf.LOWER && (type == EnumPlantType.GLOWBULB || type == EnumPlantType.FLIPANT);
	}
	@Override
	public java.util.List<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
	{
		java.util.List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
		EnumPlantType type = (EnumPlantType)world.getBlockState(pos).getValue(VARIANT);
		if (type == EnumPlantType.GLOWBULB) ret.add(new ItemStack(ModBlocks.ACDOUBLEPLANT, 2, BlockACDoublePlant.EnumPlantType.GLOWBULB.getMeta()));
		if (type == EnumPlantType.FLIPANT) ret.add(new ItemStack(ModBlocks.ACDOUBLEPLANT, 2, BlockACDoublePlant.EnumPlantType.FLIPANT.getMeta()));
		return ret;
	}
	public static enum EnumBlockHalf implements IStringSerializable
	{
		UPPER,
		LOWER;

		public String toString()
		{
			return this.getName();
		}

		public String getName()
		{
			return this == UPPER ? "upper" : "lower";
		}
	}
	public static enum EnumPlantType implements IStringSerializable
	{
		GLOWBULB(0, "glowbulb"),
		FLIPANT(1, "flipant");

		private static final BlockACDoublePlant.EnumPlantType[] META_LOOKUP = new BlockACDoublePlant.EnumPlantType[values().length];
		private final int meta;
		private final String name;
		private final String unlocalizedName;

		private EnumPlantType(int meta, String name)
		{
			this(meta, name, name);
		}

		private EnumPlantType(int meta, String name, String unlocalizedName)
		{
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
		}

		public int getMeta()
		{
			return this.meta;
		}

		public String toString()
		{
			return this.name;
		}

		public static BlockACDoublePlant.EnumPlantType byMetadata(int meta)
		{
			if (meta < 0 || meta >= META_LOOKUP.length)
			{
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		public String getName()
		{
			return this.name;
		}

		public String getUnlocalizedName()
		{
			return this.unlocalizedName;
		}

		static
		{
			for (BlockACDoublePlant.EnumPlantType blockdoubleplant$enumplanttype : values())
			{
				META_LOOKUP[blockdoubleplant$enumplanttype.getMeta()] = blockdoubleplant$enumplanttype;
			}
		}
	}
}
