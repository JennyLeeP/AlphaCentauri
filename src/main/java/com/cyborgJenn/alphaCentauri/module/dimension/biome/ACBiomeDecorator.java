package com.cyborgJenn.alphaCentauri.module.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenACMinable;
import com.google.common.base.Predicate;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ACBiomeDecorator extends BiomeDecorator 
{
	public ChunkProviderSettings chunkProviderSettings;

	public WorldGenerator dirtGen;
	public WorldGenerator gravelGen;
	public WorldGenerator plantYellowGen;
	public WorldGenerator plantRedGen;
	public WorldGenerator methIceGen;

	public WorldGenerator iron;
	public WorldGenerator gold;
	public WorldGenerator diamond;
	public WorldGenerator emerald;
	public WorldGenerator lapis;
	public WorldGenerator redStone;
	public WorldGenerator coal;

	public WorldGenerator copper;
	public WorldGenerator tin;
	public WorldGenerator silver;
	public WorldGenerator lead;
	public WorldGenerator ferrous;
	public WorldGenerator uranium;
	public WorldGenerator aluminum;
	public WorldGenerator apatite;

	public WorldGenerator Quartz;
	public WorldGenerator ardite;
	public WorldGenerator cobalt;
	public WorldGenerator saltpeter;
	public WorldGenerator sulphur;

	public WorldGenerator cursedNodesGen;

	public WorldGenerator whiteFlowersGen;
	public WorldGenerator orangeFlowersGen;
	public WorldGenerator yellowFlowersGen;
	public WorldGenerator magentaFlowersGen;
	public WorldGenerator blueFlowersGen;
	public WorldGenerator lightBlueFlowersGen;
	public WorldGenerator cyanFlowersGen;
	public WorldGenerator lightGrayFlowersGen;
	public WorldGenerator grayFlowersGen;
	public WorldGenerator purpleFlowersGen;
	public WorldGenerator pinkFlowersGen;
	public WorldGenerator limeFlowersGen;
	public WorldGenerator greenFlowersGen;
	public WorldGenerator brownFlowersGen;
	public WorldGenerator redFlowersGen;
	public WorldGenerator blackFlowersGen;


	public int methIcePerChunk;
	public int grassPerChunk;
	public int nodesPerChunk;

	public int whiteFlowersPerChunk;
	public int orangeFlowersPerChunk;
	public int yellowFlowersPerChunk;
	public int blueFlowersPerChunk;
	public int lightBlueFlowersPerChunk;
	public int CyanFlowersPerChunk;
	public int limeFlowersPerChunk;
	public int lightGrayFlowersPerChunk;
	public int grayFlowersPerChunk;
	public int purpleFlowersPerChunk;
	public int magentaFlowersPerChunk;
	public int pinkFlowersPerChunk;
	public int greenFlowersPerChunk;
	public int brownFlowersPerChunk;
	public int redFlowersPerChunk;
	public int blackFlowersPerChunk;
	//World world;
	public ACBiomeDecorator(Biome biomeGenBase) {
		super();
		// TODO chunkprovider settings ?.
		
		//String settings = world.getWorldInfo().getGeneratorOptions();
		//this.chunkProviderSettings = ChunkProviderSettings.Factory.jsonToFactory(settings).build();
		//this.sandGen = new WorldGenTDSand(7, ModBlocks.lightSand,0);
		this.dirtGen = new WorldGenACMinable(ModBlocks.acDirt.getDefaultState(), 12);
		this.gravelGen = new WorldGenACMinable(ModBlocks.blueGravel.getDefaultState(), 21);
		//this.methIceGen = new WorldGenMethIce(4);


		/* Vanilla Ores  - Block placed, int meta, int number , Block target */

		this.iron     = new WorldGenACMinable(ModBlocks.oreIron.getDefaultState(), 6);
		this.gold     = new WorldGenACMinable(ModBlocks.oreGold.getDefaultState(), 6);
		this.diamond  = new WorldGenACMinable(ModBlocks.oreDiamond.getDefaultState(), 6);
		this.lapis    = new WorldGenACMinable(ModBlocks.oreLapis.getDefaultState(), 6);
		this.emerald  = new WorldGenACMinable(ModBlocks.oreEmerald.getDefaultState(), 6);
		this.redStone = new WorldGenACMinable(ModBlocks.oreRedstone.getDefaultState(), 6);
		this.coal     = new WorldGenACMinable(ModBlocks.oreCoal.getDefaultState(), 6);
				/* Modded Ores  - Block placed, int meta, int number , Block target */
/*
		this.aluminum  = new WorldGenACMinable(ModBlocks.oreAluminum.getDefaultState(), 6);
		this.apatite   = new WorldGenACMinable(ModBlocks.oreApatite.getDefaultState(),   12);
		this.ardite    = new WorldGenACMinable(ModBlocks.oreArdite.getDefaultState(),    12);
		this.cobalt    = new WorldGenACMinable(ModBlocks.oreCobalt.getDefaultState(),     8);
		this.copper    = new WorldGenACMinable(ModBlocks.oreCopper.getDefaultState(),     8);
		this.ferrous   = new WorldGenACMinable(ModBlocks.oreNickel.getDefaultState(),     4);
		this.lead      = new WorldGenACMinable(ModBlocks.oreLead.getDefaultState(),       8);
		this.saltpeter = new WorldGenACMinable(ModBlocks.oreSaltpeter.getDefaultState(), 12);
		this.silver    = new WorldGenACMinable(ModBlocks.oreSilver.getDefaultState(),     8);
		this.sulphur   = new WorldGenACMinable(ModBlocks.oreSulfur.getDefaultState(),     8);
		this.tin       = new WorldGenACMinable(ModBlocks.oreTin.getDefaultState(),       12);
		this.uranium   = new WorldGenACMinable(ModBlocks.oreUranium.getDefaultState(),    1);
*/
		// TODO this.cursedNodesGen = new WorldGenCursedNodes(ModBlocks.cursedStone, ModBlocks.gateGalifrey, 0);
		/*
        this.whiteFlowersGen     = new WorldGenFlowers(ModBlocks.whiteFlower);
        //BlockFlower flowerIn, BlockFlower.EnumFlowerType type
        this.orangeFlowersGen    = new WorldGenFlowers(ModBlocks.orangeFlower);
        this.magentaFlowersGen   = new WorldGenFlowers(ModBlocks.magentaFlower);
        this.lightBlueFlowersGen = new WorldGenFlowers(ModBlocks.lightBlueFlower);
        this.yellowFlowersGen    = new WorldGenFlowers(ModBlocks.yellowFlower);
        this.limeFlowersGen      = new WorldGenFlowers(ModBlocks.limeFlower);
        this.pinkFlowersGen      = new WorldGenFlowers(ModBlocks.pinkFlower);
        this.grayFlowersGen      = new WorldGenFlowers(ModBlocks.grayFlower);
        this.lightGrayFlowersGen = new WorldGenFlowers(ModBlocks.lightGrayFlower);
        this.cyanFlowersGen      = new WorldGenFlowers(ModBlocks.cyanFlower);
        this.purpleFlowersGen    = new WorldGenFlowers(ModBlocks.purpleFlower);
        this.blueFlowersGen      = new WorldGenFlowers(ModBlocks.blueFlower);
        this.brownFlowersGen     = new WorldGenFlowers(ModBlocks.brownFlower);
        this.greenFlowersGen     = new WorldGenFlowers(ModBlocks.greenFlower);
        this.redFlowersGen       = new WorldGenFlowers(ModBlocks.redFlower);
        this.blackFlowersGen     = new WorldGenFlowers(ModBlocks.blackFlower);



        this.whiteFlowersPerChunk = 0;
        this.orangeFlowersPerChunk = 0;
        this.yellowFlowersPerChunk = 0;
        this.blueFlowersPerChunk = 0;
        this.lightBlueFlowersPerChunk = 0;
        this.CyanFlowersPerChunk = 0;
        this.limeFlowersPerChunk = 0;
        this.lightGrayFlowersPerChunk = 0;
        this.grayFlowersPerChunk = 0;
        this.purpleFlowersPerChunk = 0;
        this.magentaFlowersPerChunk = 0;
        this.pinkFlowersPerChunk = 0;
        this.greenFlowersPerChunk = 0;
        this.brownFlowersPerChunk = 0;
        this.redFlowersPerChunk = 0;
        this.blackFlowersPerChunk = 0;

        this.methIcePerChunk = 2;
        this.flowersPerChunk = 0;
        this.grassPerChunk = 1;
        this.sandPerChunk = 7;
        this.sandPerChunk2 = 5;
        this.nodesPerChunk = 0;
		 */
	}
	
	/**
	 * The method that does the work of actually decorating chunks
	 */
	@Override
	protected void genDecorations(Biome biomeIn, World worldIn, Random random)
	{

		MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Pre(worldIn, random, chunkPos));
		this.generateOres(worldIn, random);

		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND))
			for (int i = 0; i < this.sandPerChunk; ++i)
			{
				int j = random.nextInt(16) + 8;
				int k = random.nextInt(16) + 8;
				this.sandGen.generate(worldIn, random, worldIn.getTopSolidOrLiquidBlock(this.chunkPos.add(j, 0, k)));
			}
		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND_PASS2))
			for (int j1 = 0; j1 < this.sandPerChunk2; ++j1)
			{
				int i2 = random.nextInt(16) + 8;
				int j6 = random.nextInt(16) + 8;
				this.gravelAsSandGen.generate(worldIn, random, worldIn.getTopSolidOrLiquidBlock(this.chunkPos.add(i2, 0, j6)));
			}
		/*
        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, CLAY);
        for (i = 0; doGen && i < this.methIcePerChunk; ++i)
        {
            j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.methIceGen.generate(this.currentWorld, this.randomGenerator, j, this.currentWorld.getTopSolidOrLiquidBlock(j, k), k);
        }
		 */
		int k1 = this.treesPerChunk;

		if (random.nextFloat() < this.extraTreeChance)
		{
			++k1;
		}

		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE))
			for (int j2 = 0; j2 < k1; ++j2)
			{
				int k6 = random.nextInt(16) + 8;
				int l5 = random.nextInt(16) + 8;
				WorldGenAbstractTree worldgenabstracttree = biomeIn.genBigTreeChance(random);
				worldgenabstracttree.setDecorationDefaults();
				BlockPos blockpos = worldIn.getHeight(this.chunkPos.add(k6, 0, l5));

				if (worldgenabstracttree.generate(worldIn, random, blockpos))
				{
					worldgenabstracttree.generateSaplings(worldIn, random, blockpos);
				}
			}
		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS))
			for (int l2 = 0; l2 < this.flowersPerChunk; ++l2)
			{
				int i7 = random.nextInt(16) + 8;
				int l10 = random.nextInt(16) + 8;
				int j14 = worldIn.getHeight(this.chunkPos.add(i7, 0, l10)).getY() + 32;

				if (j14 > 0)
				{
					int k17 = random.nextInt(j14);
					BlockPos blockpos1 = this.chunkPos.add(i7, k17, l10);
					BlockFlower.EnumFlowerType blockflower$enumflowertype = biomeIn.pickRandomFlower(random, blockpos1);
					BlockFlower blockflower = blockflower$enumflowertype.getBlockType().getBlock();

					if (blockflower.getDefaultState().getMaterial() != Material.AIR)
					{
						this.yellowFlowerGen.setGeneratedBlock(blockflower, blockflower$enumflowertype);
						this.yellowFlowerGen.generate(worldIn, random, blockpos1);
						//this.plantRedGen.generate(this.currentWorld, this.randomGenerator, k, l, i1);
					}
				}
			}
		/*
        for (j = 0; j < whiteFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            whiteFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < orangeFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            orangeFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < magentaFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            magentaFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < lightBlueFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            lightBlueFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < yellowFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            yellowFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < limeFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
           limeFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < pinkFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
           pinkFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < grayFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            grayFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < lightGrayFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            lightGrayFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < CyanFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            cyanFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < purpleFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            purpleFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < blueFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            blueFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < brownFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            brownFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < greenFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            greenFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < redFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            redFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < blackFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            blackFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
		 */
		/*
        for (j = 0; j < nodesPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            cursedNodesGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
		 */
		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
			for (int i3 = 0; i3 < this.grassPerChunk; ++i3)
			{
				int j7 = random.nextInt(16) + 8;
				int i11 = random.nextInt(16) + 8;
				int k14 = worldIn.getHeight(this.chunkPos.add(j7, 0, i11)).getY() * 2;

				if (k14 > 0)
				{
					int l17 = random.nextInt(k14);
					biomeIn.getRandomWorldGenForGrass(random).generate(worldIn, random, this.chunkPos.add(j7, l17, i11));
				}
			}
		net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Post(worldIn, random, chunkPos));

	}

	/**
	 * Standard ore generation helper. Generates most ores.
	 */
	@Override
	protected void genStandardOre1(World worldIn, Random random, int blockCount, WorldGenerator generator, int minHeight, int maxHeight)
	{
		if (maxHeight < minHeight)
		{
			int i = minHeight;
			minHeight = maxHeight;
			maxHeight = i;
		}
		else if (maxHeight == minHeight)
		{
			if (minHeight < 255)
			{
				++maxHeight;
			}
			else
			{
				--minHeight;
			}
		}

		for (int j = 0; j < blockCount; ++j)
		{
			BlockPos blockpos = this.chunkPos.add(random.nextInt(16), random.nextInt(maxHeight - minHeight) + minHeight, random.nextInt(16));
			generator.generate(worldIn, random, blockpos);
		}
	}

	/**
	 * Standard ore generation helper. Vanilla uses this to generate Lapis Lazuli.
	 * The main difference between this and {@link #genStandardOre1} is that this takes takes center and spread, while
	 * genStandardOre1 takes min and max heights.
	 */
	@Override
	protected void genStandardOre2(World worldIn, Random random, int blockCount, WorldGenerator generator, int centerHeight, int spread)
	{
		for (int i = 0; i < blockCount; ++i)
		{
			BlockPos blockpos = this.chunkPos.add(random.nextInt(16), random.nextInt(spread) + random.nextInt(spread) + centerHeight - spread, random.nextInt(16));
			generator.generate(worldIn, random, blockpos);
		}
	}
	/**
	 * Generates ores in the current chunk
	 */
	@Override
	protected void generateOres(World worldIn, Random random)
	{

		net.minecraftforge.common.MinecraftForge.ORE_GEN_BUS.post(new net.minecraftforge.event.terraingen.OreGenEvent.Pre(worldIn, random, chunkPos));
		/*
		if (TerrainGen.generateOre(worldIn, random, dirtGen, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIRT))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.dirtCount, this.dirtGen, this.chunkProviderSettings.dirtMinHeight, this.chunkProviderSettings.dirtMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, gravelGen, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GRAVEL))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.gravelCount, this.gravelGen, this.chunkProviderSettings.gravelMinHeight, this.chunkProviderSettings.gravelMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, coalGen, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.COAL))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.coalCount, this.coalGen, this.chunkProviderSettings.coalMinHeight, this.chunkProviderSettings.coalMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, ironGen, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.IRON))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.ironCount, this.ironGen, this.chunkProviderSettings.ironMinHeight, this.chunkProviderSettings.ironMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, goldGen, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GOLD))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.goldCount, this.goldGen, this.chunkProviderSettings.goldMinHeight, this.chunkProviderSettings.goldMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, redstoneGen, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.REDSTONE))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.redstoneCount, this.redstoneGen, this.chunkProviderSettings.redstoneMinHeight, this.chunkProviderSettings.redstoneMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, diamondGen, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIAMOND))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.diamondCount, this.diamondGen, this.chunkProviderSettings.diamondMinHeight, this.chunkProviderSettings.diamondMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, lapisGen, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.LAPIS))
			this.genStandardOre2(worldIn, random, this.chunkProviderSettings.lapisCount, this.lapisGen, this.chunkProviderSettings.lapisCenterHeight, this.chunkProviderSettings.lapisSpread);
*/

		/* 
		 * Mod Ore spawns set according to :
		 * http://ftbwiki.org/Ore - if changes are needed to match FTB in the future : remind me I may have forgotten.
		 */

		
        //if (TerrainGen.generateOre(worldIn, random, copper, chunk_X, chunk_Z, CUSTOM))
           // this.genStandardOre1(12, this.copper, 40, 75);
        //if (TerrainGen.generateOre(worldIn, random, tin, chunk_X, chunk_Z, CUSTOM))
            //this.genStandardOre1(9, this.tin, 20, 55);
            
           /* 
        if (TerrainGen.generateOre(currentWorld, randomGenerator, silver, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre1(4, this.silver, 5, 30);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, lead, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre1(4, this.lead, 2, 35);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, ferrous, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre1(2, this.ferrous, 5, 20);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, uranium, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre1(4, this.uranium, 0, 64);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, aluminum, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre1(2, this.aluminum, 0, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, apatite, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre1(4, this.apatite, 30, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, apatite, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre1(4, this.ardite, 30, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, apatite, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre1(4, this.cobalt, 30, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, apatite, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre1(4, this.saltpeter, 30, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, apatite, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre1(4, this.sulphur, 30, 128);
		 */
		net.minecraftforge.common.MinecraftForge.ORE_GEN_BUS.post(new net.minecraftforge.event.terraingen.OreGenEvent.Post(worldIn, random, chunkPos));

	}
}
