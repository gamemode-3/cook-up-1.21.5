package net.gamemode3.cookup;

import net.fabricmc.api.ModInitializer;

import net.gamemode3.cookup.item.ModItems;
import net.gamemode3.cookup.potion.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookUp implements ModInitializer {
	public static final String MOD_ID = "cook-up";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModPotions.registerModPotions();
	}

}