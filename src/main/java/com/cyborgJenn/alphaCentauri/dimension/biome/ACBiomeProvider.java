package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ACBiomeProvider extends BiomeProvider 
{
	private ChunkGeneratorSettings settings;
	private GenLayer acGenBiomes;
	private GenLayer acBiomeIndexLayer;
	private BiomeCache biomecache;
	private List<Biome> allowedBiomes = Lists.newArrayList(ModBiomes.LUSHHILLS,ModBiomes.BEACH,ModBiomes.GREENRIVER,
			ModBiomes.LIVINGPLATEAU,ModBiomes.Mangroves,ModBiomes.Morass,ModBiomes.PrimevalForest,ModBiomes.SPIRAL_FOREST,
			ModBiomes.DESERT,ModBiomes.FUNGALFOREST,ModBiomes.PAINTED_CLIFFS);

	public ACBiomeProvider()
	{
		this.biomecache = new BiomeCache(this);
		this.allowedBiomes = new ArrayList<Biome>();
		this.allowedBiomes.addAll(allowedBiomes);
	}

	public ACBiomeProvider(long seed, WorldType worldTypeIn, String options)
	{
		this();
		if (worldTypeIn == WorldType.CUSTOMIZED && !options.isEmpty())
        {
            this.settings = ChunkGeneratorSettings.Factory.jsonToFactory(options).build();
        }
		GenLayer[] agenlayer = ACGenLayer.initializeAllBiomeGenerators(seed, worldTypeIn, this.settings);
		agenlayer = getModdedBiomeGenerators(worldTypeIn, seed, agenlayer);//TODO may cause issues
		this.acGenBiomes = agenlayer[0];
		this.acBiomeIndexLayer = agenlayer[1];
	}

	public ACBiomeProvider(WorldInfo info)
	{
		this(info.getSeed(), info.getTerrainType(), info.getGeneratorOptions());
	}

	/**
	 * Gets the list of valid biomes for the player to spawn in.
	 */
	@Override
	public List<Biome> getBiomesToSpawnIn()
	{
		return this.allowedBiomes;
	}
    
    /**
     * Return an adjusted version of a given temperature based on the y height
     */
    @Override
    @SideOnly(Side.CLIENT)
    public float getTemperatureAtHeight(float par1, int par2)
    {
        return par1;
    }
    
    /**
     * Returns an array of biomes for the location input.
     */
    @Override
    public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int width, int height)
    {
        IntCache.resetIntCache();

        if (biomes == null || biomes.length < width * height)
        {
        	biomes = new Biome[width * height];
        }
        //System.out.println("X: "+x+" Z: "+z+" Width: "+width+" Height: "+height);
        
        int[] aint = this.acGenBiomes.getInts(x, z, width, height);
        
        try
        {
            for (int i1 = 0; i1 < width * height; ++i1)
            {
            	biomes[i1] = ACBiome.getBiome(aint[i1]);
            }

            return biomes;
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("RawBiomeBlock");
            crashreportcategory.addCrashSection("biomes[] size", Integer.valueOf(biomes.length));
            crashreportcategory.addCrashSection("x", Integer.valueOf(x));
            crashreportcategory.addCrashSection("z", Integer.valueOf(z));
            crashreportcategory.addCrashSection("w", Integer.valueOf(width));
            crashreportcategory.addCrashSection("h", Integer.valueOf(height));
            throw new ReportedException(crashreport);
        }
    }

    /**
     * Gets biomes to use for the blocks and loads the other data like temperature and humidity onto the
     * WorldChunkManager.
     */
    @Override
    public Biome[] getBiomes(@Nullable Biome[] oldBiomeList, int x, int z, int width, int depth)
    {
        return this.getBiomes(oldBiomeList, x, z, width, depth, true);
    }

    /**
     * Gets a list of biomes for the specified blocks.
     */
    @Override
    public Biome[] getBiomes(@Nullable Biome[] listToReuse, int x, int z, int width, int length, boolean cacheFlag)
    {
        IntCache.resetIntCache();
        if (listToReuse == null || listToReuse.length < width * length)
        {
            listToReuse = new Biome[width * length];
        }
        if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (z & 15) == 0)
        {
            Biome[] abiome = this.biomecache.getCachedBiomes(x, z);
            System.arraycopy(abiome, 0, listToReuse, 0, width * length);
            return listToReuse;
        }
        else
        {
            int[] aint = this.acBiomeIndexLayer.getInts(x, z, width, length);

            for (int i = 0; i < width * length; ++i)
            {
            	listToReuse[i] = Biome.getBiome(aint[i]);
            }
            return listToReuse;
        }
    }
    /**
     * checks given Chunk's Biomes against List of allowed ones
     */
    @Override
    public boolean areBiomesViable(int x, int z, int radius, List<Biome> allowed)
    {
        IntCache.resetIntCache();
        int l  = x - radius >> 2;
        int i1 = z - radius >> 2;
        int j1 = x + radius >> 2;
        int k1 = z + radius >> 2;
        int l1 = j1 - l + 1;
        int i2 = k1 - i1 + 1;
        int[] aint = this.acGenBiomes.getInts(l, i1, l1, i2);

        try
        {
            for (int j2 = 0; j2 < l1 * i2; ++j2)
            {
                Biome biome = Biome.getBiome(aint[j2]);

                if (!allowed.contains(biome))
                {
                    return false;
                }
            }

            return true;
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("Layer");
            crashreportcategory.addCrashSection("Layer", this.acGenBiomes.toString());
            crashreportcategory.addCrashSection("x", Integer.valueOf(x));
            crashreportcategory.addCrashSection("z", Integer.valueOf(z));
            crashreportcategory.addCrashSection("radius", Integer.valueOf(radius));
            crashreportcategory.addCrashSection("allowed", allowed);
            throw new ReportedException(crashreport);
        }
    }
    @Override
    public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random)
    {
        IntCache.resetIntCache();
        int l  = x - range >> 2;
        int i1 = z - range >> 2;
        int j1 = x + range >> 2;
        int k1 = z + range >> 2;
        int l1 = j1 - l + 1;
        int i2 = k1 - i1 + 1;
        int[] aint = this.acGenBiomes.getInts(l, i1, l1, i2);
        BlockPos blockpos = null;
        int j2 = 0;

        for (int k2 = 0; k2 < l1 * i2; ++k2)
        {
            int l2 = l + k2 % l1 << 2;
            int i3 = i1 + k2 / l1 << 2;
            Biome biome = Biome.getBiome(aint[k2]);

            if (biomes.contains(biome) && (blockpos == null || random.nextInt(j2 + 1) == 0))
            {
            	blockpos = new BlockPos(l2, 0, i3);
                ++j2;
            }
        }

        return blockpos;
    }

	/**
	 * Calls the WorldChunkManager's biomeCache.cleanupCache()
	 */
    @Override
	public void cleanupCache()
	{
		this.biomecache.cleanupCache();
	}

}
