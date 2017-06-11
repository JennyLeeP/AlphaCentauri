package com.cyborgJenn.alphaCentauri.module.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenBoulders;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenLushHills extends ACBiome{

	private ACBiomeDecorator customBiomeDecorator;
	public BiomeGenLushHills(BiomeProperties biomeProperties) {
		super(biomeProperties);
		theBiomeDecorator = new ACBiomeDecorator(this);
		customBiomeDecorator = (ACBiomeDecorator)theBiomeDecorator;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
		this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
		this.customBiomeDecorator.whiteFlowersPerChunk = 3;
		this.customBiomeDecorator.grayFlowersPerChunk = 2;
		this.customBiomeDecorator.purpleFlowersPerChunk = 3;
		this.customBiomeDecorator.treesPerChunk = 10;
		this.customBiomeDecorator.nodesPerChunk = 3;
	}
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
	{      
		this.topBlock = ModBlocks.acGrass.getDefaultState();
		this.fillerBlock = ModBlocks.acDirt.getDefaultState();

		this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	@Override
	public BiomeDecorator createBiomeDecorator()
	{   
		return getModdedBiomeDecorator(new ACBiomeDecorator(this));
	}
	/*
    @Override
    public WorldGenAbstractTree func_150567_a(Random random)
    {
        return random.nextInt(5) == 0 ? new WorldGenShrubs(ModBlocks.log2, ModBlocks.leaves, 2, 6, true, false) : 
        	 new WorldGenWillowTrees(true, 1);
    }
	 */
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
	{
		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
			/*
			for (int i = 0; i < 7; ++i)
			{
				int j = rand.nextInt(16) + 8;
				int k = rand.nextInt(16) + 8;
				int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
				DOUBLE_PLANT_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
			}
			*/
		if (rand.nextInt(20) == 0)
		{
			WorldGenBoulders worldgenboulders = new WorldGenBoulders(ModBlocks.basaltCobble, 0);

		}
		super.decorate(worldIn, rand, pos);
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
