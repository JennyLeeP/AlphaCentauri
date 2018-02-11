package com.cyborgJenn.alphaCentauri.handlers;

import com.cyborgJenn.alphaCentauri.utils.Config;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler 
{
	public void initRecipes()
	{
		if(Config.enableModuleMachine)
		{
			addMachineRecipes();
		}

	}

	private void addMachineRecipes()
	{
		if(ModHelper.isThaumcraftLoaded && Config.useThaumcraftRecipes)
		{
			//TODO add ThaumcraftRecipes
		}
		else
		{
			//TODO add regular recipes.
		}

	}
}
