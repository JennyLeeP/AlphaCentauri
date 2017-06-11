package com.cyborgJenn.alphaCentauri.module.accessories.render;

import org.lwjgl.opengl.GL11;

import com.cyborgJenn.alphaCentauri.api.AccessoriesAPI;
import com.cyborgJenn.alphaCentauri.core.item.ModItems;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.stats.StatList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome.TempCategory;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHud extends Gui
{
	private Minecraft minecraft;
	//private ScaledResolution scaledResolution;
	//private World world;
	private static int FONTCOLOR = 0xffffff;
	private final static int compassIndexDefault = 3;
	private static int compassIndex = compassIndexDefault;
	//private int screenHeight = scaledResolution.getScaledHeight();
	private int screenWidth;// = scaledResolution.getScaledWidth();;
	
	private static final ResourceLocation HUDTEXTURE = new ResourceLocation(Reference.MODID, "/textures/gui/accessoryhud.png");

	public RenderHud(Minecraft minecraft)
	{
		super();
		this.minecraft = minecraft;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
		if(event.isCancelable() || event.getType() != ElementType.EXPERIENCE)
		{      
			return;
		}
		
		if(isEquipped(ModItems.Pda))
		{
			renderPDA();
		}
		else if (isEquipped(ModItems.GPS))
		{
			renderGPS();
		}
		else if (isEquipped(ModItems.FancyCompass))
		{
			renderCompass();
		}
		else
		{
			// do other stuff
		}
	}

	private void renderPDA()
	{
		renderCompassCore();
		//this.drawTexturedModalRect(xBaseOverlay, yBaseOverlay, 0, 112, 173, 16);
	}
	
	private void renderGPS()
	{
		renderCompassCore();
		float xBaseOverlay = (screenWidth / 2) - 86.5F;
		float yBaseOverlay = 1;
		this.drawTexturedModalRect(xBaseOverlay, yBaseOverlay, 0, 112, 173, 16);
		renderPosition(0, 45);
		renderBedLoc();
		renderTime(300, 9.5F);
		renderTemp(280.0F, 5.5F);
		renderWeather(0,0);
	}
	
	private void renderCompass()
	{
		renderCompassCore();
		float xBaseOverlay = (screenWidth / 2) - 46.5F;
		float yBaseOverlay = 1;
		this.drawTexturedModalRect(xBaseOverlay, yBaseOverlay, 0, 96, 93, 16);
	}
	
	private void renderCompassCore()
	{
		minecraft.getTextureManager().bindTexture(HUDTEXTURE);
		int direction = MathHelper.floor_double(((minecraft.thePlayer.rotationYaw * 256F) / 360F) + 0.5D) & 255;
		float xBase = (screenWidth / 2) - 32.5F; // Centers compass in game window.
		float yBase = 3;
		if (direction < 128)
			this.drawTexturedModalRect(xBase, yBase, direction, (compassIndex * 24), 65, 12);
		else
			this.drawTexturedModalRect(xBase, yBase, direction - 128, (compassIndex * 24) + 12, 65, 12);
	}

	
	private void renderPosition(int xPosGui, int yPosGui)
	{
		GL11.glPushMatrix();
		int xPos = (int) Math.floor(minecraft.thePlayer.posX);
		int yPos = (int) Math.floor(minecraft.thePlayer.posY);
		int zPos = (int) Math.floor(minecraft.thePlayer.posZ);
		String position = new String("X: "+ xPos + " Y: " + yPos + " Z: " + zPos);
		int stringLength = minecraft.fontRendererObj.getStringWidth(position);
		int stringLengthCentered = stringLength / 2;
		float scaledCenterPoss = (getCenteredScreenPos() * 2) - stringLengthCentered; // should = twice the viewport size
		GL11.glScalef(0.5F,0.5F, 1.0F);
		minecraft.fontRendererObj.drawString(position, scaledCenterPoss, yPosGui, FONTCOLOR, false);
		GL11.glScalef(1.0F,1.0F, 1.0F);
		GL11.glPopMatrix();
	}

	private void renderTime(float xPosGui, float yPosGui)
	{
		GL11.glPushMatrix();
		int hours = getWorldHours();
		int minutes = getWorldMinutes();
		String mins;
		if (minutes < 9)
		{
			mins = "0" + minutes;//TODO display 0 before single digit 
		}else 
		{
			mins = "" + minutes;
		}
		String time = hours + ":" + mins;
		float calcPoss = getCenteredScreenPos() + xPosGui;
		GL11.glScalef(0.5F,0.5F, 1.0F);
		minecraft.fontRendererObj.drawString(time, calcPoss, yPosGui, FONTCOLOR, false);
		GL11.glScalef(1.0F,1.0F, 1.0F);
		GL11.glPopMatrix();
	}
	
	private void renderWeather(float xPosGui, float yPosGui)
	{
		BlockPos pos = minecraft.thePlayer.getPosition();
		float tempFloat = minecraft.theWorld.getBiomeForCoordsBody(pos).getFloatTemperature(pos);
		float rainRate = minecraft.theWorld.getBiomeForCoordsBody(pos).getRainfall();
		boolean isPrecipitating = minecraft.theWorld.isRaining();
		if (tempFloat < 0.148 && rainRate > 0.0){
			//TODO Snow Possible Icon
		}else
		{
			//TODO Rain possible icon
		}
		if (isPrecipitating)
		{
			if(tempFloat < 0.148)
			{
				//TODO is Snow icon
			}else
			{
				//TODO is Rain Icon
			}
		}
		
	}
	
	private void renderTemp(float xPosGui, float yPosGui)
	{
		GL11.glPushMatrix();
		minecraft.getTextureManager().bindTexture(HUDTEXTURE);
		BlockPos pos = minecraft.thePlayer.getPosition();
		TempCategory temp = minecraft.theWorld.getBiomeForCoordsBody(pos).getTempCategory();
		String temperature = temp.toString();
		int yIconPos = 0;
		if(temperature!= null && temperature == "WARM"){
			
			yIconPos = 204;
		}
		else if (temperature == "COLD") {
			
			yIconPos = 192;
		}else {
			
			yIconPos = 198;
		}
		GL11.glScalef(0.5F,0.5F, 1.0F);
		this.drawTexturedModalRect(xPosGui * 2, yPosGui * 2, yIconPos, 16, 7, 14);
		GL11.glScalef(1.0F,1.0F, 1.0F);
		GL11.glPopMatrix();
		
	}
	
	private void renderBedLoc()
	{
		GL11.glPushMatrix();
		minecraft.getTextureManager().bindTexture(HUDTEXTURE);
		double dir = 0.0D;
		double posX = minecraft.thePlayer.posX;
		double posZ = minecraft.thePlayer.posZ;
		double rotYaw = minecraft.thePlayer.rotationYaw;
		BlockPos blockpos = minecraft.theWorld.getSpawnPoint();
        double bedX = (double)blockpos.getX() - posX;
        double bedZ = (double)blockpos.getZ() - posZ;
        rotYaw = rotYaw % 360.0D; //  = Player Rotation in 360 degrees
        //dir = -((rotYaw - 90) * Math.PI / 180.0D - Math.atan2(bedZ, bedX)); // radians
        dir = rotYaw / Math.PI - Math.atan2(bedZ, bedX);
        //int direction = MathHelper.floor_double(((minecraft.thePlayer.rotationYaw * 256F) / 360F) + 0.5D) & 255;
		float xBase = (screenWidth / 2) - 32.5F; // Centers compass in game window.
		float yBase = 3;
		if (dir < 128)
			this.drawTexturedModalRect(xBase, yBase, (int) dir, 128, 65, 12);
		else
			this.drawTexturedModalRect(xBase, yBase, (int) (dir - 128), 128 + 12, 65, 12);
		//System.out.println(dir);
		GL11.glPopMatrix();
	}
	
	private void renderDepthMeter(float xPosElem, float yPosElem)
	{
		//TODO render Depth Meter
	}
	
	private void renderStopWatch(float xPosElem, float yPosElem)
	{
		//TODO get player speed , likely calculated from player.motionX and player.motionZ
		
	}
	
	private void renderSextant(float xPosElem, float yPosElem)
	{
		int moonPhase = minecraft.theWorld.getMoonPhase();
		switch(moonPhase)
		{
		case 0:
			//Full Moon
			break;
		case 1:
			//Waning Gibbous
			break;
		case 2:
			//Last Quarter
			break;
		case 3:
			//Waning Crescent
			break;
		case 4:
			//New Moon
			break;
		case 5:
			//Waxing Crescent
			break;
		case 6:
			//First Quarter
			break;
		case 7:
			//Waxing Gibbous
			break;
		}

	}
	private void renderTallyCounter(float xPosElem, float yPosElem)
	{
		int monsterkills = minecraft.thePlayer.getStatFileWriter().readStat(StatList.MOB_KILLS);	
		//System.out.println(monsterkills);
	}
	
	private boolean isEquipped(Item item)
	{
		EntityPlayer player = minecraft.thePlayer;
		IInventory accessories = AccessoriesAPI.getAccessories(player);

		for (int i = 0; i < accessories.getSizeInventory(); i++)
		{
			if(accessories.getStackInSlot(i) != null && accessories.getStackInSlot(i).getItem() == item)
			{
				return true;
			}			
		}
		if(player.getHeldItemMainhand() != null){
			if (player.getHeldItemMainhand().getItem() == item){
				return true;
			}
		}
		return false;
	}
	
	public int getWorldMinutes()
	{
		int time = (int) Math.abs((minecraft.theWorld.getWorldTime() + 6000) % 24000);
		return (time % 1000) * 6 / 100;
	}

	public int getWorldHours()
	{
		int time = (int)Math.abs((minecraft.theWorld.getWorldTime()+ 6000) % 24000);
		//int adjTime = (int)((float)time / 1000F);

		return (int)((float)time / 1000F);
	}
	
	private int getCenteredScreenPos()
	{
		ScaledResolution scaledResolution = new ScaledResolution(minecraft);
		screenWidth = scaledResolution.getScaledWidth();
		int screenWidthCentered = screenWidth / 2;
		return screenWidthCentered;
	}

}
