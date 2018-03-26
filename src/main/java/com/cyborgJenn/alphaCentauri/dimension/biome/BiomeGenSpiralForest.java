package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.List;
import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.BlockACDoublePlant;
import com.cyborgJenn.alphaCentauri.blocks.BlockACFlowers;
import com.cyborgJenn.alphaCentauri.blocks.BlockACFlowers.EnumType;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenACFlowers;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenBaseTree;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenBoulders;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenUtils;
import com.cyborgJenn.alphaCentauri.dimension.generators.trees.WorldGenSpiralTree;
import com.google.common.collect.Lists;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenSpiralForest extends ACBiome{

	private ACBiomeDecorator customBiomeDecorator;
	private WorldGenBoulders worldgenboulders = new WorldGenBoulders();
	private WorldGenSpiralTree SPIRAL_TREE = new WorldGenSpiralTree();
	List<EnumType> flowers = Lists.newArrayList(BlockACFlowers.EnumType.BLUE, BlockACFlowers.EnumType.RED, BlockACFlowers.EnumType.MAGENTA, BlockACFlowers.EnumType.PURPLE);

	public BiomeGenSpiralForest(BiomeProperties biomeProperties) 
	{
		super(biomeProperties);
		/* Trees and Plants */
		biomeDecorator = new ACBiomeDecorator(this);
		customBiomeDecorator = (ACBiomeDecorator)biomeDecorator;
		this.customBiomeDecorator.treesPerChunk = 9;
		this.customBiomeDecorator.grassPerChunk = 4;
		this.customBiomeDecorator.flowersPerChunk = 100;
		WorldGenACFlowers.setFlowers(flowers);
	}
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
	{
		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) 
		{
			DOUBLE_PLANT_GEN.setPlantType(BlockACDoublePlant.EnumPlantType.GLOWBULB);
			for (int i = 0; i < 20; ++i)
			{
				int j = rand.nextInt(16) + 8;
				int k = rand.nextInt(16) + 8;
				int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
				DOUBLE_PLANT_GEN.generate(worldIn, rand, pos.add(j, l, k));

			}
		}
		if (rand.nextInt(4) == 0)
		{	
			int X = rand.nextInt(16) + 8;
			int Z = rand.nextInt(16) + 8;
			int Y = worldIn.getHeight(pos.add(X, 0, Z)).getY();

			if (WorldGenUtils.isGroundBlock(worldIn, pos.add(X,Y,Z)))
			{
				worldgenboulders.generate(worldIn, rand, pos.add(X,Y,Z));
			}
		}
		super.decorate(worldIn, rand, pos);
	}
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
	{      
		this.topBlock = ModBlocks.ACGRASS.getDefaultState();
		this.fillerBlock = ModBlocks.ACDIRT.getDefaultState();
		this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	@Override
	public WorldGenBaseTree getRandomTreeFeature(Random rand)
	{ 
		return SPIRAL_TREE; 
	}
	@Override
	public int getModdedBiomeGrassColor(int ont)
	{
		//return 0x5c96c9;// Nice Blue color.
		return 0x5D8F92; // nice
	}
	@Override
	public int getModdedBiomeFoliageColor(int original)
	{
		return 0xad5cc9;
	}
}
