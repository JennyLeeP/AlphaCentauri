package com.cyborgJenn.alphaCentauri.render;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.utils.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ACSkyRenderer extends IRenderHandler {

	private static final ResourceLocation moonTextures = new ResourceLocation(Reference.TEXTURE + "textures/environment/moonphases.png");
	private static final ResourceLocation sunTexture = new ResourceLocation(Reference.TEXTURE + "textures/environment/blue_sun.png"); 
	private static final ResourceLocation sunBTexture = new ResourceLocation(Reference.TEXTURE + "textures/environment/sun.png");
	private int starGLCallList;
	private int glSkyList;
	private int glSkyList2;
	private boolean vboEnabled;
	private VertexFormat vertexBufferFormat;
	private net.minecraft.client.renderer.vertex.VertexBuffer starVBO;
	private net.minecraft.client.renderer.vertex.VertexBuffer skyVBO;
	//private net.minecraft.client.renderer.vertex.VertexBuffer sky2VBO;
	public ACSkyRenderer()
	{

		RenderGlobal renderGlobal = Minecraft.getMinecraft().renderGlobal;
		this.glSkyList2 = (this.glSkyList = (this.starGLCallList = ReflectionHelper.getPrivateValue(RenderGlobal.class, renderGlobal, "starGLCallList")) + 1) + 1;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void render(float partialTicks, WorldClient world, Minecraft mc) 
	{
		/* starting at renderSky() in RenderGlobal line 1324 */
		this.vboEnabled = OpenGlHelper.useVbo();
		GlStateManager.disableTexture2D();
		Vec3d vec3d = world.getSkyColor(mc.getRenderViewEntity(), partialTicks);
		float f = (float)vec3d.x;
		float f1 = (float)vec3d.y;
		float f2 = (float)vec3d.z;

		GlStateManager.color(f, f1, f2);
		Tessellator tessellator1 = Tessellator.getInstance();
		BufferBuilder bufferBuilder = tessellator1.getBuffer();
		GlStateManager.depthMask(false);
		GlStateManager.enableFog();
		GlStateManager.color(f, f1, f2);

		if (this.vboEnabled)
		{
			this.skyVBO = new net.minecraft.client.renderer.vertex.VertexBuffer(this.vertexBufferFormat);
			this.skyVBO.bindBuffer();
			GlStateManager.glEnableClientState(32884);
			GlStateManager.glVertexPointer(3, 5126, 12, 0);
			this.skyVBO.drawArrays(7);
			this.skyVBO.unbindBuffer();
			GlStateManager.glDisableClientState(32884);
		}
		else
		{
			GlStateManager.callList(this.glSkyList);
		}

		GlStateManager.disableFog();
		GlStateManager.disableAlpha();
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderHelper.disableStandardItemLighting();
		float[] afloat = world.provider.calcSunriseSunsetColors(world.getCelestialAngle(partialTicks), partialTicks);

		if (afloat != null)
		{
			GlStateManager.disableTexture2D();
			GlStateManager.shadeModel(7425);
			GlStateManager.pushMatrix();
			GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(MathHelper.sin(world.getCelestialAngleRadians(partialTicks)) < 0.0F ? 180.0F : 0.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
			float f6 = afloat[0]; // R
			float f7 = afloat[1]; // G
			float f8 = afloat[2]; // B

			bufferBuilder.begin(6, DefaultVertexFormats.POSITION_COLOR);
			bufferBuilder.pos(0.0D, 100.0D, 0.0D).color(f6, f7, f8, afloat[3]).endVertex();

			for (int l = 0; l <= 16; ++l)
			{
				float f21 = (float)l * ((float)Math.PI * 2F) / 16.0F;
				float f12 = MathHelper.sin(f21);
				float f13 = MathHelper.cos(f21);
				bufferBuilder.pos((double)(f12 * 120.0F), (double)(f13 * 120.0F), (double)(-f13 * 40.0F * afloat[3])).color(afloat[0], afloat[1], afloat[2], 0.0F).endVertex();
			}
			tessellator1.draw();
			GlStateManager.popMatrix();
			GlStateManager.shadeModel(7424);
		}
		/*---------------ALphaCentauri A   - Sun 1---------------*/
		GlStateManager.enableTexture2D();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.pushMatrix();
		float rainSt = 1.0F - world.getRainStrength(partialTicks);
		GlStateManager.color(1.0F, 1.0F, 1.0F, rainSt);
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		
		float sunDia = 30.0F;// Size of sun from center
		mc.renderEngine.bindTexture(sunTexture);
		bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		bufferBuilder.pos((double)(-sunDia), 100.0D, (double)(-sunDia)).tex(0.0D, 0.0D).endVertex();
		bufferBuilder.pos((double)sunDia, 100.0D, (double)(-sunDia)).tex(1.0D, 0.0D).endVertex();
		bufferBuilder.pos((double)sunDia, 100.0D, (double)sunDia).tex(1.0D, 1.0D).endVertex();
		bufferBuilder.pos((double)(-sunDia), 100.0D, (double)sunDia).tex(0.0D, 1.0D).endVertex();
		tessellator1.draw(); // Draw sun

		/*------------------------Moon--------------------------
		 *    this is = to renderSky() method in RenderGlobal   */
		float moonRad = 10.0F; // Size of moon from center
		mc.renderEngine.bindTexture(moonTextures);
		int i = world.getMoonPhase();
		int k = i % 4;
		int i1 = i / 4 % 2;
		float f22 = (float)(k + 0) / 4.0F;
		float f23 = (float)(i1 + 0) / 2.0F;
		float f24 = (float)(k + 1) / 4.0F;
		float f14 = (float)(i1 + 1) / 2.0F;
		bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		bufferBuilder.pos((double)(-moonRad), -100.0D, (double)moonRad).tex((double)f24, (double)f14).endVertex();
		bufferBuilder.pos((double)moonRad, -100.0D, (double)moonRad).tex((double)f22, (double)f14).endVertex();
		bufferBuilder.pos((double)moonRad, -100.0D, (double)(-moonRad)).tex((double)f22, (double)f23).endVertex();
		bufferBuilder.pos((double)(-moonRad), -100.0D, (double)(-moonRad)).tex((double)f24, (double)f23).endVertex();
		tessellator1.draw();  // Draw Moon
		
		/*------------------Alpha Centauri B-------------------*/
		GlStateManager.color(1.0F, 1.0F, 1.0F, rainSt);
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		
		float sun2Rad = 15.0F;// Size of sun from center
		mc.renderEngine.bindTexture(sunBTexture);
		bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		bufferBuilder.pos((double)(-sun2Rad), 100.0D, (double)(-sun2Rad)).tex(0.0D, 0.0D).endVertex();
		bufferBuilder.pos((double)sun2Rad, 100.0D, (double)(-sun2Rad)).tex(1.0D, 0.0D).endVertex();
		bufferBuilder.pos((double)sun2Rad, 100.0D, (double)sun2Rad).tex(1.0D, 1.0D).endVertex();
		bufferBuilder.pos((double)(-sun2Rad), 100.0D, (double)sun2Rad).tex(0.0D, 1.0D).endVertex();
		tessellator1.draw(); // Draw sun
		
		/*                 Stars                */
		GlStateManager.disableTexture2D();
		float f15 = world.getStarBrightness(partialTicks) * rainSt;
		if (f15 > 0.0F)
		{
			GlStateManager.color(f15, f15, f15, f15);

            
                GlStateManager.callList(this.starGLCallList);
            
		}
		//this.generateStars();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.enableFog();
		GlStateManager.popMatrix();
		GlStateManager.disableTexture2D();
		GlStateManager.color(0.0F, 0.0F, 0.0F);
		
		/*                        Sky 2                      */
		double d0 = mc.player.getPositionEyes(partialTicks).y - world.getHorizon();
		if (d0 < 0.0D)
		{
			GlStateManager.pushMatrix();
			GlStateManager.translate(0.0F, 12.0F, 0.0F);
			
                GlStateManager.callList(this.glSkyList2);
            
			GlStateManager.popMatrix();
			float f19 = -((float)(d0 + 65.0D));
			bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
			bufferBuilder.pos(-1.0D, (double)f19, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(1.0D, (double)f19, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(-1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(-1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(1.0D, (double)f19, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(-1.0D, (double)f19, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(1.0D, (double)f19, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(1.0D, (double)f19, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(-1.0D, (double)f19, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(-1.0D, (double)f19, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(-1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(-1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(-1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(-1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferBuilder.pos(1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			tessellator1.draw();
		}
		if (world.provider.isSkyColored())
		{
			GlStateManager.color(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F);
		}
		else
		{
			GlStateManager.color(f, f1, f2);
		}
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, -((float)(d0 - 16.0D)), 0.0F);
		GlStateManager.callList(this.glSkyList2);
		GlStateManager.popMatrix();
		GlStateManager.enableTexture2D();
		GlStateManager.depthMask(true);
	}
	
	/*-----------------------------------------------
	 * 
	 *                     NEW
	 *   TODO fix stars
	 ------------------------------------------------*/
	@SuppressWarnings("unused")
	private void generateStars()
    {
		Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();

        if (this.starVBO != null)
        {
            this.starVBO.deleteGlBuffers();
        }

        if (this.starGLCallList >= 0)
        {
            GLAllocation.deleteDisplayLists(this.starGLCallList);
            this.starGLCallList = -1;
        }

        if (this.vboEnabled)
        {
            this.starVBO = new VertexBuffer(this.vertexBufferFormat);
            this.renderStars(bufferbuilder);
            bufferbuilder.finishDrawing();
            bufferbuilder.reset();
            this.starVBO.bufferData(bufferbuilder.getByteBuffer());
        }
        else
        {
            this.starGLCallList = GLAllocation.generateDisplayLists(1);
            GlStateManager.pushMatrix();
            GlStateManager.glNewList(this.starGLCallList, 4864);
            this.renderStars(bufferbuilder);
            tessellator.draw();
            GlStateManager.glEndList();
            GlStateManager.popMatrix();
        }
    }
	private void renderStars(BufferBuilder worldRendererIn)
    {
        Random random = new Random(10842L);
        worldRendererIn.begin(7, DefaultVertexFormats.POSITION);

        for (int i = 0; i < 1500; ++i)
        {
            double d0 = (double)(random.nextFloat() * 2.0F - 1.0F);
            double d1 = (double)(random.nextFloat() * 2.0F - 1.0F);
            double d2 = (double)(random.nextFloat() * 2.0F - 1.0F);
            double d3 = (double)(0.15F + random.nextFloat() * 0.1F);
            double d4 = d0 * d0 + d1 * d1 + d2 * d2;

            if (d4 < 1.0D && d4 > 0.01D)
            {
                d4 = 1.0D / Math.sqrt(d4);
                d0 = d0 * d4;
                d1 = d1 * d4;
                d2 = d2 * d4;
                double d5 = d0 * 100.0D;
                double d6 = d1 * 100.0D;
                double d7 = d2 * 100.0D;
                double d8 = Math.atan2(d0, d2);
                double d9 = Math.sin(d8);
                double d10 = Math.cos(d8);
                double d11 = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
                double d12 = Math.sin(d11);
                double d13 = Math.cos(d11);
                double d14 = random.nextDouble() * Math.PI * 2.0D;
                double d15 = Math.sin(d14);
                double d16 = Math.cos(d14);

                for (int j = 0; j < 4; ++j)
                {
                    double d18 = (double)((j & 2) - 1) * d3;
                    double d19 = (double)((j + 1 & 2) - 1) * d3;
                    double d21 = d18 * d16 - d19 * d15;
                    double d22 = d19 * d16 + d18 * d15;
                    double d23 = d21 * d12 + 0.0D * d13;
                    double d24 = 0.0D * d12 - d21 * d13;
                    double d25 = d24 * d9 - d22 * d10;
                    double d26 = d22 * d9 + d24 * d10;
                    worldRendererIn.pos(d5 + d25, d6 + d23, d7 + d26).endVertex();
                }
            }
        }
    }
}
