package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlantBlock extends BlockBush implements IPlantable{

	protected PlantBlock(String name) {
		super(Material.PLANTS);
		this.blockSoundType = SoundType.PLANT;
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setUnlocalizedName(Reference.MODID +"."+ name);
		GameRegistry.register(this, new ResourceLocation(Reference.MODID, name));
		GameRegistry.register(new ItemBlock(this), new ResourceLocation(Reference.MODID, name));
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
		IBlockState soil = worldIn.getBlockState(pos.down());
        return super.canPlaceBlockAt(worldIn, pos) && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
    }
}
