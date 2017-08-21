package com.cyborgJenn.alphaCentauri.core.integration;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.ingredients.IModIngredientRegistration;

@JEIPlugin
public class JEICyborgCorePlugin implements IModPlugin{
	
	private IJeiHelpers jeiHelpers;
	
	@Override
	public void onRuntimeAvailable(IJeiRuntime arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register(IModRegistry registry) {
		IIngredientRegistry itemRegistry = registry.getIngredientRegistry();
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();

		AlphaCentauri.logger.info("Initializing AlphaCentauri JEI plugin...");

		//registry.addDescription(new ItemStack(AccessoryItems.FancyCompass), "This Compass Shows your direction at the top of the Game Screen");
		jeiHelpers.getGuiHelper().createBlankDrawable(1, 3);
	}

	@Override
	public void registerIngredients(IModIngredientRegistration arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerItemSubtypes(ISubtypeRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

}
