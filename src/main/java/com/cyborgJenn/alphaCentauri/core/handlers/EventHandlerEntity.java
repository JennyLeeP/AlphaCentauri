package com.cyborgJenn.alphaCentauri.core.handlers;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.api.AccessoriesAPI;
import com.cyborgJenn.alphaCentauri.api.IAccessory;
import com.cyborgJenn.alphaCentauri.core.item.ModItems;
import com.cyborgJenn.alphaCentauri.module.accessories.inventory.InventoryAccessories;
import com.google.common.io.Files;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class EventHandlerEntity {
	static HashSet<Integer> syncSchedule = new HashSet<Integer>();
	@SubscribeEvent
	public void playerTick(PlayerEvent.LivingUpdateEvent event)
	{
		// player events
		if (event.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntity();

			if (!syncSchedule.isEmpty() && syncSchedule.contains(player.getEntityId()))
			{
				CyborgEventHandler.syncaccessories(player);
				syncSchedule.remove(player.getEntityId());
			}

			InventoryAccessories accessories = PlayerHandler.getPlayerAccessories(player);
			for (int a = 0; a < accessories.getSizeInventory(); a++)
			{
				if (accessories.getStackInSlot(a) != null
						&& accessories.getStackInSlot(a).getItem() instanceof IAccessory)
				{
					((IAccessory) accessories.getStackInSlot(a).getItem()).onWornTick(accessories.getStackInSlot(a), player);
				}
			}

		}

	}
	@SubscribeEvent
	public void onNameFormat(PlayerEvent.NameFormat event){
		/*
		if (event.getUsername().compareTo("JennyLeeP") == 0){
			System.out.println("NameFormat for JennyLeeP");
			event.setDisplayname(TextFormatting.GOLD+""+TextFormatting.BOLD+"      "+TextFormatting.RESET+"  ");
		}
		*/
	}
	@SubscribeEvent
	public void renderGlowNames(RenderGameOverlayEvent.Post event){
		GuiNewChat c = Minecraft.getMinecraft().ingameGUI.getChatGUI();
		Field f_lines;
		Field f_counter;
		if (event.getType() == ElementType.CHAT){
			try {
				f_lines = c.getClass().getDeclaredField("drawnChatLines");
				f_lines.setAccessible(true);
				f_counter = Minecraft.getMinecraft().ingameGUI.getClass().getSuperclass().getDeclaredField("updateCounter");
				f_counter.setAccessible(true);
				List<ChatLine> chatLines;
				int updateCounter = 0;
				try {
					updateCounter = f_counter.getInt(Minecraft.getMinecraft().ingameGUI);
					chatLines = (List<ChatLine>) f_lines.get(c);
					for (int i = 0; c.getChatOpen() && i < chatLines.size() || !c.getChatOpen() && i < chatLines.size() && i < 10; i ++){
						ChatLine l = chatLines.get(i);
						String s = l.getChatComponent().getUnformattedText();
						for (int j = 0; j < s.length(); j ++){
							if (j < s.length()-14 && s.substring(j, j+14).compareTo(TextFormatting.GOLD+""+TextFormatting.BOLD+"      "+TextFormatting.RESET+"  ") == 0){
								String before = s.substring(0,j);
								float f = Minecraft.getMinecraft().gameSettings.chatOpacity * 0.9F + 0.1F;
								int j1 = updateCounter - l.getUpdatedCounter();
								if (j1 < 200 || c.getChatOpen()){
									double d0 = (double)j1 / 200.0D;
									d0 = 1.0D - d0;
									d0 = d0 * 10.0D;
									d0 = MathHelper.clamp_double(d0, 0.0D, 1.0D);
									d0 = d0 * d0;
									int l1 = (int)(255.0D * d0);

									if (c.getChatOpen())
									{
										l1 = 255;
									}

									l1 = (int)((float)l1 * f);
									if ((20*l1)/255 > 3){
										GlStateManager.enableAlpha();
										GlStateManager.enableBlend();
										GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE);
										int dfunc = GL11.glGetInteger(GL11.GL_DEPTH_FUNC);
										GlStateManager.depthFunc(GL11.GL_LEQUAL);
										int func = GL11.glGetInteger(GL11.GL_ALPHA_TEST_FUNC);
										float ref = GL11.glGetFloat(GL11.GL_ALPHA_TEST_REF);
										GlStateManager.alphaFunc(GL11.GL_ALWAYS, 0);
										GlStateManager.depthMask(false);
										//TODO
										//GuiCodex.drawTextGlowingAuraTransparent(Minecraft.getMinecraft().fontRendererObj, "JennyLeeP", chatX+3+Minecraft.getMinecraft().fontRendererObj.getStringWidth(before), chatY-(Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT)*i,l1);
										GlStateManager.depthMask(true);
										GlStateManager.alphaFunc(func, ref);
										GlStateManager.depthFunc(dfunc);
										GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
										GlStateManager.disableBlend();
										GlStateManager.disableAlpha();
									}
								}
							}
						}
						//System.out.println(s);
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
	}
	@SubscribeEvent
	public void playerDeath(PlayerDropsEvent event)
	{
		if (event.getEntity() instanceof EntityPlayer
				&& !event.getEntity().worldObj.isRemote
				&& !event.getEntity().worldObj.getGameRules().getBoolean("keepInventory"))
		{
			PlayerHandler.getPlayerAccessories(event.getEntityPlayer()).dropItemsAt(event.getDrops(),event.getEntityPlayer());
		}

	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void playerJump(LivingJumpEvent event)
	{
		if(event.getEntity() instanceof EntityPlayer)
		{
			if(checkForAccessoryItem(ModItems.BalloonPufferfish, (EntityPlayer)event.getEntity()))
			{
				event.getEntity().motionY += 0.6;
				//event.entity.jumpMovementFactor = 150.0F;
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void fogModifier(FogDensity event)
	{
		if(event.getEntity() instanceof EntityPlayer)
		{
			if(checkForAccessoryItem(ModItems.SwimGoggles, (EntityPlayer)event.getEntity()))
			{
				if(event.getState().getBlock() != null && event.getState().getBlock() == Blocks.WATER)
				{
					event.setDensity(0.0F);
					event.setCanceled(true);
				}
			}

		}
	}

	@SubscribeEvent
	public void playerFall(LivingFallEvent event)
	{
		if(event.getEntity() instanceof EntityPlayer)
		{
			if(checkForAccessoryItem(ModItems.LuckyHorshoe, (EntityPlayer)event.getEntity()))
			{
				if(event.isCancelable())
				{
					event.setCanceled(true);
				}
			}
		}
	}

	private boolean checkForAccessoryItem(Item item, EntityPlayer player)
	{
		IInventory accessories = AccessoriesAPI.getAccessories(player);
		for (int i = 0; i < accessories.getSizeInventory(); i++)
		{
			if(accessories.getStackInSlot(i) != null && accessories.getStackInSlot(i).getItem() == item)
			{
				return true;
			}			
		}
		return false;
	}

	@SubscribeEvent
	public void playerLoad(PlayerEvent.LoadFromFile event)
	{
		PlayerHandler.clearPlayerAccessories(event.getEntityPlayer());

		File file1 = getPlayerFile("acc", event.getPlayerDirectory(), event.getEntityPlayer().getDisplayNameString());
		if (!file1.exists())
		{
			File playerfile = event.getPlayerFile("acc");
			if (playerfile.exists())
			{
				try {
					Files.copy(playerfile, file1);					
					AlphaCentauri.logger.info("Using and converting UUID Accessories savefile for "+event.getEntityPlayer().getDisplayNameString());
					playerfile.delete();
					File fb = event.getPlayerFile("accback");
					if (fb.exists()) fb.delete();					
				} catch (IOException e) {}
			} 
			else
			{				 
				File fileq = getLegacy1110FileFromPlayer("acc", event.getPlayerDirectory(), event.getEntityPlayer().getDisplayNameString());
				if (fileq.exists()) {
					try {
						Files.copy(fileq, file1);
						fileq.deleteOnExit();
						AlphaCentauri.logger.info("Using pre 1.1.1.1 Accessories savefile for "+event.getEntityPlayer().getDisplayNameString());
					} catch (IOException e) {}
				} else {
					File filet = getLegacy1710FileFromPlayer(event.getEntityPlayer());
					if (filet.exists()) {
						try {
							Files.copy(filet, file1);
							filet.deleteOnExit();
							AlphaCentauri.logger.info("Using pre MC 1.7.10 Accessories savefile for "+event.getEntityPlayer().getDisplayNameString());
						} catch (IOException e) {}
					}
				}				
			}
		}

		PlayerHandler.loadPlayerAccessories(event.getEntityPlayer(), file1, getPlayerFile("accback", event.getPlayerDirectory(), event.getEntityPlayer().getDisplayNameString()));
		EventHandlerEntity.syncSchedule.add(event.getEntityPlayer().getEntityId());
	}

	public File getPlayerFile(String suffix, File playerDirectory, String playername)
	{
		if ("dat".equals(suffix)) throw new IllegalArgumentException("The suffix 'dat' is reserved");
		return new File(playerDirectory, "_"+playername+"."+suffix);
	}

	public static File getLegacy1710FileFromPlayer(EntityPlayer player)
	{
		try {
			File playersDirectory = new File(player.worldObj.getSaveHandler().getWorldDirectory(), "players");
			return new File(playersDirectory, player.getDisplayNameString() + ".acc");
		} catch (Exception e) { e.printStackTrace(); }
		return null;
	}

	public File getLegacy1110FileFromPlayer(String suffix, File playerDirectory, String playername)
	{
		if ("dat".equals(suffix)) throw new IllegalArgumentException("The suffix 'dat' is reserved");
		return new File(playerDirectory, playername+"."+suffix);
	}



	@SubscribeEvent
	public void playerSave(PlayerEvent.SaveToFile event) {
		PlayerHandler.savePlayerAccessories(event.getEntityPlayer(), 
				getPlayerFile("acc", event.getPlayerDirectory(), event.getEntityPlayer().getDisplayNameString()),
				getPlayerFile("accback", event.getPlayerDirectory(), event.getEntityPlayer().getDisplayNameString()));
	}
}
