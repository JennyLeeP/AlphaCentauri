package com.cyborgJenn.alphaCentauri.blocks;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockACFlowers extends BlockBush implements IPlantable {

	public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", BlockACFlowers.EnumType.class);
	public BlockACFlowers() {
		super(Material.PLANTS);
		this.blockSoundType = SoundType.PLANT;
	}
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
		IBlockState soil = worldIn.getBlockState(pos.down());
        return super.canPlaceBlockAt(worldIn, pos) && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
    }
	/**
     * Get the damage value that this Block should drop
     */
    public int damageDropped(IBlockState state)
    {
        return ((BlockACFlowers.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    @SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
    	BlockACFlowers.EnumType[] aenumtype = BlockACFlowers.EnumType.values();
        int i = aenumtype.length;

        for (int j = 0; j < i; ++j)
        {
        	BlockACFlowers.EnumType enumtype = aenumtype[j];
        	items.add(new ItemStack(this, 1, enumtype.getMetadata()));
        }
    }

    /**
     * Convert the given meta-data into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockACFlowers.EnumType.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockACFlowers.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
	
	public static enum EnumType implements IStringSerializable
    {
        WHITE(0, "white"),
        ORANGE(1, "orange"),
		MAGENTA(2, "magenta"),
		LIGHTBLUE(3, "lightblue"),
		YELLOW(4, "yellow"),
		LIME(5, "lime"),
		PINK(6, "pink"),
		GRAY(7, "gray"),
		LIGHTGRAY(8, "lightgray"),
		CYAN(9, "cyan"),
		PURPLE(10, "purple"),
		BLUE(11, "blue"),
		BROWN(12, "brown"),
		GREEN(13, "green"),
		RED(14, "red"),
		BLACK(15, "black");
        private static final BlockACFlowers.EnumType[] META_LOOKUP = new BlockACFlowers.EnumType[values().length];
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

        public static BlockACFlowers.EnumType byMetadata(int meta)
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
        	BlockACFlowers.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
            	BlockACFlowers.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
}
