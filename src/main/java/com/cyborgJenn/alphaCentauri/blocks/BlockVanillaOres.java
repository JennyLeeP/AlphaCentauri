package com.cyborgJenn.alphaCentauri.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockVanillaOres extends Block 
{
	public static final IProperty<EnumType> VARIANT = PropertyEnum.create("variant", BlockVanillaOres.EnumType.class);
	
	public BlockVanillaOres() 
	{
		super(Material.ROCK, MapColor.CYAN);
		this.setHardness(2.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(100.0F);
	}
	/**
	 * Get the damage value that this Block should drop
	 */
	
	@Override
	public int damageDropped(IBlockState state)
	{
		if (state == this.getDefaultState().withProperty(VARIANT, BlockVanillaOres.EnumType.IRON)) {
			return ((BlockVanillaOres.EnumType)state.getValue(VARIANT)).getMetadata();
		}
		else if (state == this.getDefaultState().withProperty(VARIANT, BlockVanillaOres.EnumType.GOLD)) {
			return ((BlockVanillaOres.EnumType)state.getValue(VARIANT)).getMetadata();
		}else if (state == this.getDefaultState().withProperty(VARIANT, BlockVanillaOres.EnumType.LAPIS)) {
			return EnumDyeColor.BLUE.getDyeDamage();
		}
		else {
			return 0;
		}
	}
	
	/**
     * Get the Item that this Block should drop when harvested.
     */
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	if (state == this.getDefaultState().withProperty(VARIANT, BlockVanillaOres.EnumType.DIAMOND)) {
			return Items.DIAMOND;
		}
    	else if (state == this.getDefaultState().withProperty(VARIANT, BlockVanillaOres.EnumType.COAL)) {
    		return Items.COAL;
    	}
    	else if (state == this.getDefaultState().withProperty(VARIANT, BlockVanillaOres.EnumType.LAPIS)) {
    		return Items.DYE;
    	}
    	else if (state == this.getDefaultState().withProperty(VARIANT, BlockVanillaOres.EnumType.REDSTONE)) {
    		return Items.REDSTONE;
    	}
    	else if (state == this.getDefaultState().withProperty(VARIANT, BlockVanillaOres.EnumType.EMERALD)) {
    		return Items.EMERALD;
    	}
    		return Item.getItemFromBlock(this);
    	
    }
	@Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this);
    }
	/**
     * Returns the quantity of items to drop on block destruction.
     */
	@Override
    public int quantityDropped(Random random)
    {
        return 1;
    }
	//TODO FORTUNE Bonus.
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		BlockVanillaOres.EnumType[] aenumtype = BlockVanillaOres.EnumType.values();
		int i = aenumtype.length;
		for (int j = 0; j < i; ++j)
		{
			BlockVanillaOres.EnumType enumtype = aenumtype[j];
			items.add(new ItemStack(this, 1, enumtype.getMetadata()));
		}
	}
	/**
	 * Convert the given meta-data into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, BlockVanillaOres.EnumType.byMetadata(meta));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockVanillaOres.EnumType)state.getValue(VARIANT)).getMetadata();
	}
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, VARIANT);
	}
	
	public static enum EnumType implements IStringSerializable
	{
		GOLD(0, "gold"),
		IRON(1, "iron"),
		LAPIS(2, "lapis"),
		COAL(3, "coal"),
		DIAMOND(4,"diamond"),
		EMERALD(5,"emerald"),
		REDSTONE(6,"redstone");
		private static final BlockVanillaOres.EnumType[] META_LOOKUP = new BlockVanillaOres.EnumType[values().length];
		private final int meta;
		private final String name;
		private final String unlocalizedName;


		private EnumType(int meta, String name)
		{
			this(meta, name, name);
		}

		private EnumType(int meta, String name, String unlocalizedName)
		{
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
		}

		public int getMetadata()
		{
			return this.meta;
		}

		public String toString()
		{
			return this.name;
		}

		public static BlockVanillaOres.EnumType byMetadata(int meta)
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
			BlockVanillaOres.EnumType[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2)
			{
				BlockVanillaOres.EnumType var3 = var0[var2];
				META_LOOKUP[var3.getMetadata()] = var3;
			}
		}
	}
}
