package com.cyborgJenn.alphaCentauri.module.dimension.world;


import javax.annotation.Nullable;

import com.cyborgJenn.alphaCentauri.core.render.ACSkyRenderer;
import com.cyborgJenn.alphaCentauri.core.utils.Config;
import com.cyborgJenn.alphaCentauri.core.utils.Registry;
import com.cyborgJenn.alphaCentauri.module.dimension.biome.ACBiomeProvider;
import com.cyborgJenn.alphaCentauri.module.dimension.biome.ModBiomes;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.module.dimension.chunk.AlphaCentauriChunkProvider;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ACWorldProvider extends WorldProvider{
	//private WorldType terrainType;
	public static final float[] MOON_PHASE_FACTORS = new float[] {1.0F, 0.75F, 0.5F, 0.25F, 0.0F, 0.25F, 0.5F, 0.75F};
	/** Light to brightness conversion table */
    protected final float[] lightBrightnessTable = new float[16];
    /** Array for sunrise/sunset colors (RGBA) */
    private final float[] colorsSunriseSunset = new float[4];
	
	@Override
    protected void createBiomeProvider()
    {
		this.setDimension(Config.dimensionID);
		this.hasNoSky = false;
        this.biomeProvider = new ACBiomeProvider(worldObj.getSeed(), worldObj.getWorldType(), worldObj.getWorldInfo().getGeneratorOptions());
        this.generateLightBrightnessTable();
    }
	@Override
	public IChunkGenerator createChunkGenerator()
	{
		return new AlphaCentauriChunkProvider(worldObj);
	}
	@Override
	public DimensionType getDimensionType() 
	{
		return Registry.DIMENSION;
	}
	@Override
	public String getSaveFolder()
	{
		return "AlphaCentauri";
	}
	@Override
	@SideOnly(Side.CLIENT)
	public IRenderHandler getSkyRenderer()
	{
		return new ACSkyRenderer();
	}
	
	/* ------------------------------------------------------------------------------*/
	/**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    public boolean isSurfaceWorld()
    {
        return true;
    }
	/**
     * Creates the light to brightness table
     */
	@Override
    protected void generateLightBrightnessTable()
    {
		//TODO maybe change World Light Level - i.e. TwilightForest ish.
        float f = 0.0F;

        for (int i = 0; i <= 15; ++i)
        {
            float f1 = 1.0F - (float)i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * 1.0F + 0.0F;
        }
    }
	/**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
	@Override
    public float calculateCelestialAngle(long worldTime, float partialTicks)
    {
        int i = (int)(worldTime % 24000L);
        float f = ((float)i + partialTicks) / 24000.0F - 0.25F;

        if (f < 0.0F)
        {
            ++f;
        }

        if (f > 1.0F)
        {
            --f;
        }

        float f1 = 1.0F - (float)((Math.cos((double)f * Math.PI) + 1.0D) / 2.0D);
        f = f + (f1 - f) / 3.0F;
        return f;
    }
	/**
     * Returns array with sunrise/sunset colors
     */
    @Nullable
    @SideOnly(Side.CLIENT)
    @Override
    public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks)
    {
        float f = 0.4F;
        float f1 = MathHelper.cos(celestialAngle * ((float)Math.PI * 2F)) - 0.0F;
        float f2 = -0.0F;

        if (f1 >= -0.4F && f1 <= 0.4F)
        {
            float f3 = (f1 - -0.0F) / 0.4F * 0.5F + 0.5F;
            float f4 = 1.0F - (1.0F - MathHelper.sin(f3 * (float)Math.PI)) * 0.99F;
            f4 = f4 * f4;
            this.colorsSunriseSunset[0] = f3 * 0.3F + 0.7F;
            this.colorsSunriseSunset[1] = f3 * f3 * 0.7F + 0.2F;
            this.colorsSunriseSunset[2] = f3 * f3 * 0.0F + 0.2F;
            this.colorsSunriseSunset[3] = f4;
            //System.out.println("Sunset Color /s ? - "+ colorsSunriseSunset);
            return this.colorsSunriseSunset;
        }
        else
        {
            return null;
        }
    }
    /**
     * Return Vec3D with biome specific fog color
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Vec3d getFogColor(float p_76562_1_, float p_76562_2_)
    {
        float f = MathHelper.cos(p_76562_1_ * ((float)Math.PI * 2F)) * 2.0F + 0.5F;
        f = MathHelper.clamp_float(f, 0.0F, 1.0F);
        float f1 = 0.7529412F;
        float f2 = 0.84705883F;
        float f3 = 1.0F;
        f1 = f1 * (f * 0.94F + 0.06F);
        f2 = f2 * (f * 0.94F + 0.06F);
        f3 = f3 * (f * 0.91F + 0.09F);
        return new Vec3d((double)f1, (double)f2, (double)f3);
    }
    /**
     * the y level at which clouds are rendered.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public float getCloudHeight()
    {
        return 140F;
    }
	@Override
	public int getMoonPhase(long worldTime)
    {
        return (int)(worldTime / 24000L % 8L + 8L) % 8;
    }
	/**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
	@Override
    public boolean canRespawnHere()
    {
        return true;
    }
    /**
     * Will check if the x, z position specified is alright to be set as the map spawn point
     */
	@Override
    public boolean canCoordinateBeSpawn(int x, int z)
    {
        BlockPos blockpos = new BlockPos(x, 0, z);
        return this.worldObj.getBiome(blockpos).ignorePlayerSpawnSuitability() ? true : this.worldObj.getGroundAboveSeaLevel(blockpos).getBlock() == ModBlocks.acGrass;
    }
	public boolean getHasNoSky()
    {
        return this.hasNoSky;
    }

    public float[] getLightBrightnessTable()
    {
        return this.lightBrightnessTable;
    }
    public WorldBorder createWorldBorder()
    {
        return new WorldBorder();
    }
}
