package com.cyborgJenn.alphaCentauri.core.handlers;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class EventHandlerEntity {
	static HashSet<Integer> syncSchedule = new HashSet<Integer>();
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
									d0 = MathHelper.clampedLerp(d0, 0.0D, 1.0D);
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
}
