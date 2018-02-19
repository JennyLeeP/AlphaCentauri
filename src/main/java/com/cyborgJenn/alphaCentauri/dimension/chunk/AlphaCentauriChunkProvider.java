package com.cyborgJenn.alphaCentauri.dimension.chunk;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE;

import java.util.List;
import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.dimension.biome.ModBiomes;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenACLakes;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraftforge.event.terraingen.TerrainGen;

public class AlphaCentauriChunkProvider implements  IChunkGenerator
{
	private final World worldObj;
	private Random random;
	private Biome[] biomesForGeneration;
	private WorldType terrainType;
	private NoiseGeneratorOctaves minLimitPerlinNoise;
	private NoiseGeneratorOctaves maxLimitPerlinNoise;
	private NoiseGeneratorOctaves mainPerlinNoise;
	private NoiseGeneratorPerlin surfaceNoise;
	public NoiseGeneratorOctaves scaleNoise;
	public NoiseGeneratorOctaves depthNoise;
	private double[] depthBuffer = new double[256];
	private IBlockState oceanBlock = Blocks.WATER.getDefaultState();
	private final float[] biomeWeights;
	private final double[] heightMap;
	double[] mainNoiseRegion;
	double[] minLimitRegion;
	double[] maxLimitRegion;
	double[] depthRegion;
	private static int sealevel = 63;
	private MapGenBase caveGenerator;

	public AlphaCentauriChunkProvider(World worldObj) 
	{
		caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
		this.worldObj = worldObj;
		long seed = worldObj.getSeed();
		this.random = new Random((seed + 516) * 314);
		this.terrainType = terrainType.DEFAULT;
		this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.random, 16);
		this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.random, 16);
		this.mainPerlinNoise = new NoiseGeneratorOctaves(this.random, 8);
		this.surfaceNoise = new NoiseGeneratorPerlin(this.random, 4);
		this.scaleNoise = new NoiseGeneratorOctaves(this.random, 10);
		this.depthNoise = new NoiseGeneratorOctaves(this.random, 16);
		this.heightMap = new double[825];
		this.biomeWeights = new float[25];

		for (int i = -2; i <= 2; ++i)
		{
			for (int j = -2; j <= 2; ++j)
			{
				float f = 10.0F / MathHelper.sqrt((float)(i * i + j * j) + 0.2F);
				this.biomeWeights[i + 2 + (j + 2) * 5] = f;
			}
		}
	}
	/**
	 * 
	 * @param x
	 * @param z
	 * @param primer
	 */
	public void setBlocksInChunk(int x, int z, ChunkPrimer primer)
	{
		this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
		this.generateHeightmap(x * 4, 0, z * 4);

		for (int i = 0; i < 4; ++i)
		{
			int j = i * 5;
			int k = (i + 1) * 5;

			for (int l = 0; l < 4; ++l)
			{
				int i1 = (j + l) * 33;
				int j1 = (j + l + 1) * 33;
				int k1 = (k + l) * 33;
				int l1 = (k + l + 1) * 33;

				for (int i2 = 0; i2 < 32; ++i2)
				{
					double d0 = 0.125D;
					double d1 = this.heightMap[i1 + i2];
					double d2 = this.heightMap[j1 + i2];
					double d3 = this.heightMap[k1 + i2];
					double d4 = this.heightMap[l1 + i2];
					double d5 = (this.heightMap[i1 + i2 + 1] - d1) * 0.125D;
					double d6 = (this.heightMap[j1 + i2 + 1] - d2) * 0.125D;
					double d7 = (this.heightMap[k1 + i2 + 1] - d3) * 0.125D;
					double d8 = (this.heightMap[l1 + i2 + 1] - d4) * 0.125D;

					for (int j2 = 0; j2 < 8; ++j2)
					{
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * 0.25D;
						double d13 = (d4 - d2) * 0.25D;

						for (int k2 = 0; k2 < 4; ++k2)
						{
							double d14 = 0.25D;
							double d16 = (d11 - d10) * 0.25D;
							double lvt_45_1_ = d10 - d16;

							for (int l2 = 0; l2 < 4; ++l2)
							{
								if ((lvt_45_1_ += d16) > 0.0D)
								{
									primer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, ModBlocks.ACSTONE.getDefaultState());
								}
								else if (i2 * 8 + j2 < this.sealevel)
								{
									primer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, this.oceanBlock);
								}
							}

							d10 += d12;
							d11 += d13;
						}

						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}
	/**
	 * Replace's Blocks with biome Specific Blocks. I.E. dirt , grass and such.
	 * @param x
	 * @param z
	 * @param primer
	 * @param biomesIn
	 */
	public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn)
	{
		if (!net.minecraftforge.event.ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, primer, this.worldObj)) return;
		double d0 = 0.03125D;
		this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, (double)(x * 16), (double)(z * 16), 16, 16, 0.0625D, 0.0625D, 1.0D);

		for (int i = 0; i < 16; ++i)
		{
			for (int j = 0; j < 16; ++j)
			{
				Biome biome = biomesIn[j + i * 16];
				biome.genTerrainBlocks(this.worldObj, this.random, primer, x * 16 + i, z * 16 + j, this.depthBuffer[j + i * 16]);
			}
		}
	}
	/**
	 * 
	 */
	@Override
	public Chunk generateChunk(int x, int z) 
	{
		this.random.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.setBlocksInChunk(x, z, chunkprimer);
		/* Setup biomes again for actual biome decoration   */
		this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16, 16);
		this.replaceBiomeBlocks(x, z, chunkprimer, biomesForGeneration);
		/*    Generate caves     */
		this.caveGenerator.generate(this.worldObj, x, z, chunkprimer);
		Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);
		byte[] biomeArray = chunk.getBiomeArray();
		for (int i = 0; i < biomeArray.length; ++i) 
		{
			biomeArray[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
		}

		chunk.generateSkylightMap();
		return chunk;
	}
	/**
	 * Generates the height map for the world.
	 * @param chunkX4
	 * @param chunkY4
	 * @param chunkZ4
	 */
	private void generateHeightmap(int chunkX4, int chunkY4, int chunkZ4) 
	{
		this.depthRegion     = this.depthNoise.generateNoiseOctaves(this.depthRegion, chunkX4, chunkZ4, 5, 5, 200.0D, 200.0D, 0.5D);
		this.mainNoiseRegion = this.mainPerlinNoise.generateNoiseOctaves(this.mainNoiseRegion, chunkX4, chunkY4, chunkZ4, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
		this.minLimitRegion  = this.minLimitPerlinNoise.generateNoiseOctaves(this.minLimitRegion, chunkX4, chunkY4, chunkZ4, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		this.maxLimitRegion  = this.maxLimitPerlinNoise.generateNoiseOctaves(this.maxLimitRegion, chunkX4, chunkY4, chunkZ4, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		int l = 0;
		int i1 = 0;

		for (int j1 = 0; j1 < 5; ++j1) 
		{
			for (int k1 = 0; k1 < 5; ++k1) 
			{
				float f = 0.0F;
				float f1 = 0.0F;
				float f2 = 0.0F;
				byte b0 = 2;
				for (int l1 = -b0; l1 <= b0; ++l1) 
				{
					for (int i2 = -b0; i2 <= b0; ++i2) 
					{
						Biome biome = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
						float baseHeight = biome.getBaseHeight();
						float variation = biome.getHeightVariation();

						float f5 = biomeWeights[l1 + 2 + (i2 + 2) * 5] / (baseHeight + 2.0F);
						f += variation * f5;
						f1 += baseHeight * f5;
						f2 += f5;
					}
				}
				f /= f2;
				f1 /= f2;
				f = f * 0.9F + 0.1F;
				f1 = (f1 * 4.0F - 1.0F) / 8.0F;
				double d12 = this.depthRegion[i1] / 8000.0D;

				if (d12 < 0.0D) 
				{
					d12 = -d12 * 0.3D;
				}
				d12 = d12 * 3.0D - 2.0D;

				if (d12 < 0.0D) 
				{
					d12 /= 2.0D;

					if (d12 < -1.0D) 
					{
						d12 = -1.0D;
					}

					d12 /= 1.4D;
					d12 /= 2.0D;
				} 
				else 
				{
					if (d12 > 1.0D) 
					{
						d12 = 1.0D;
					}

					d12 /= 8.0D;
				}

				++i1;
				double d13 = f1;
				double d14 = f;
				d13 += d12 * 0.2D;
				d13 = d13 * 8.5D / 8.0D;
				double d5 = 8.5D + d13 * 4.0D;

				for (int j2 = 0; j2 < 33; ++j2) 
				{
					double d6 = (j2 - d5) * 12.0D * 128.0D / 256.0D / d14;

					if (d6 < 0.0D) 
					{
						d6 *= 4.0D;
					}

					double d7 = this.minLimitRegion[l] / 512.0D;
					double d8 = this.maxLimitRegion[l] / 512.0D;
					double d9 = (this.mainNoiseRegion[l] / 10.0D + 1.0D) / 2.0D;
					double d10 = MathHelper.clampedLerp(d7, d8, d9) - d6;

					if (j2 > 29) 
					{
						double d11 = ((j2 - 29) / 3.0F);
						d10 = d10 * (1.0D - d11) + -10.0D * d11;
					}

					this.heightMap[l] = d10;
					++l;
				}
			}
		}
	}

	@Override
	public void populate(int x, int z) 
	{
		BlockFalling.fallInstantly = true;
		int i = x * 16;
		int j = z * 16;
		BlockPos blockpos = new BlockPos(i, 0, j);
		Biome biome = this.worldObj.getBiome(blockpos.add(16, 0, 16));
		this.random.setSeed(this.worldObj.getSeed());
		long k = this.random.nextLong() / 2L * 2L + 1L;
		long l = this.random.nextLong() / 2L * 2L + 1L;
		this.random.setSeed((long)x * k + (long)z * l ^ this.worldObj.getSeed());
		boolean flag = false;
		ChunkPos chunkpos = new ChunkPos(x, z);

		if (biome != ModBiomes.DESERT && !flag && this.random.nextInt(4) == 0)
		{
			if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.worldObj, this.random, x, z, flag, net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE))
			{
				int i1 = this.random.nextInt(16) + 8;
				int j1 = this.random.nextInt(256);
				int k1 = this.random.nextInt(16) + 8;
				//TODO change block to custom fluid when done.
				(new WorldGenACLakes(Blocks.WATER)).generate(this.worldObj, this.random, blockpos.add(i1, j1, k1));
			}
		}
		//TODO maybe make lava lakes not gen in certain biomes.
		if (!flag && this.random.nextInt(8) == 0)
		{
			if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.worldObj, this.random, x, z, flag, net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAVA))
			{
				int i2 = this.random.nextInt(16) + 8;
				int l2 = this.random.nextInt(this.random.nextInt(248) + 8);
				int k3 = this.random.nextInt(16) + 8;

				if (l2 < this.worldObj.getSeaLevel() || this.random.nextInt(10) == 0)
				{
					(new WorldGenACLakes(Blocks.LAVA)).generate(this.worldObj, this.random, blockpos.add(i2, l2, k3));
				}
			}
		}
		//TODO add dungeons here.
		
		// Adds biome decorations (like flowers, grass, trees, ...).
		biome.decorate(this.worldObj, this.random, blockpos);
		// Make sure animals appropriate to the biome spawn here when the chunk is generated.
		WorldEntitySpawner.performWorldGenSpawning(this.worldObj, biome, i + 8, j + 8, 16, 16, this.random);
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) 
	{
		return false;
	}

	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) 
	{
		Biome biome = this.worldObj.getBiome(pos);
		return biome.getSpawnableList(creatureType);
	}
	
	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) 
	{

	}
	@Override
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position,
			boolean findUnexplored) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
		// TODO Auto-generated method stub
		return false;
	}
}
