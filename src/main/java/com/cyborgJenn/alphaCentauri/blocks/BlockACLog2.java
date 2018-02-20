package com.cyborgJenn.alphaCentauri.blocks;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockACLog2 extends BlockLog 
{
	public static final PropertyEnum<BlockACPlanks2.EnumType> VARIANT = PropertyEnum.<BlockACPlanks2.EnumType>create("variant", BlockACPlanks2.EnumType.class, new Predicate<BlockACPlanks2.EnumType>()
    {
        public boolean apply(@Nullable BlockACPlanks2.EnumType type)
        {
            return type.getMetadata() < 4;
        }
    });
    
	public BlockACLog2()
	{
		this.blockSoundType = SoundType.WOOD;
	}
	/**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    @SideOnly(Side.CLIENT)

	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
    	items.add(new ItemStack(this, 1, BlockACPlanks2.EnumType.PEYLAL.getMetadata())); // Meta 0
    	items.add(new ItemStack(this, 1, BlockACPlanks2.EnumType.NEFRALIA.getMetadata())); // Meta 1
    	items.add(new ItemStack(this, 1, BlockACPlanks2.EnumType.BERATUZIA.getMetadata())); // Meta 2
	}
    
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, BlockACPlanks2.EnumType.byMetadata((meta & 3) % 4));

        switch (meta & 12)
        {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 8:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }
		return iblockstate;
	}
    /**
     * Convert the BlockState into the correct metadata value
     */
    
    @SuppressWarnings("incomplete-switch")
    @Override
	public int getMetaFromState(IBlockState state)
    {
    	int i = 0;
        i = i | ((BlockACPlanks2.EnumType)state.getValue(VARIANT)).getMetadata();

         switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
         {
             case X:
                 i |= 4;
                 break;
             case Z:
                 i |= 8;
                 break;
             case NONE:
                 i |= 12;
         }

         return i;
    }
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT, LOG_AXIS});
    }
    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockACPlanks2.EnumType)state.getValue(VARIANT)).getMetadata());
    }
    /**
     * Get the damage value that this Block should drop
     */
    @Override
    public int damageDropped(IBlockState state)
    {
        return ((BlockACPlanks2.EnumType)state.getValue(VARIANT)).getMetadata();
    }

}
