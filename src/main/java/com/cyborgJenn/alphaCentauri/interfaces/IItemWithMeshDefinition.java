package com.cyborgJenn.alphaCentauri.interfaces;

import net.minecraft.client.renderer.ItemMeshDefinition;

public interface IItemWithMeshDefinition {
	/**
	 * Used to provide NBT based item models
	 * @return
	 */
	public ItemMeshDefinition getMeshDefinition();
}
