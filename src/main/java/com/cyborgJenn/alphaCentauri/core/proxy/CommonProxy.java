package com.cyborgJenn.alphaCentauri.core.proxy;

import com.cyborgJenn.alphaCentauri.core.handlers.KeyInputHandler;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;
import com.cyborgJenn.alphaCentauri.module.accessories.inventory.ContainerAccessories;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler{

	public KeyInputHandler keyHandler;

	public void registerHudRenderer() {}
	public void registerAccessoryRenderers() {}
	public void registerCombatRenderers() {}
	public void registerDimensionRenderers() {}
	public void registerKeyBindings() {}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case Reference.ACCESSORYGUI: return new ContainerAccessories(player.inventory, !world.isRemote, player);
		}
		return null;
	}

	public World getClientWorld() {
		return null;
	}
	
}
