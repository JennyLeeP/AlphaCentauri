package com.cyborgJenn.alphaCentauri.blocks;



import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class FenceBlock extends BlockFence{

	String[] TreeTypes = {"sparkling","charred","brilliant", "dark", "icebound", "infernal", "life", "death"};
	
	public FenceBlock() {
		super(Material.WOOD, MapColor.WOOD);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.blockSoundType = SoundType.WOOD;
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		//this.setUnlocalizedName(Reference.MODID +"."+name);
		//this.setRegistryName(name);
	}
}
