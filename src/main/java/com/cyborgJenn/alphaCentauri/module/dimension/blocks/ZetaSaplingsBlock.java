package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import java.util.List;
import java.util.Random;

import com.cyborgJenn.alphaCentauri.core.utils.Reference;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenBrilliantTrees;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenCharredTrees;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenDarkTrees;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenGenericTrees;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenIceBoundTrees;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenInfernalTrees;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenWillowTrees;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ZetaSaplingsBlock extends BlockSapling{

	public static String[] textureNames = new String[]{"sparkling","charred","brilliant", "dark", "icebound", "infernal", "life", "death"};
	
	protected ZetaSaplingsBlock()
	{
		super();
		float f = 0.4F;
		this.setSoundType(SoundType.PLANT);
		//this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and wood.
	 */
	public int damageDropped(int meta)
	{
		return meta;
	}

	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		
	}

	
}
