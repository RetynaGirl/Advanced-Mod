package com.teknoserval.advancedmod.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.teknoserval.advancedmod.reference.Reference;

public class ConfigHandler {

	public static Configuration configuration;
	public static boolean testValue = false;
	public static int testInt = 69;

	public static void init(File configFile) {

		// Create the configuration object from the given config file
		if (configuration == null) {

			configuration = new Configuration(configFile);
			loadConfiguration();

		}

	}

	@SubscribeEvent
	public void onConfigChangeEvent(ConfigChangedEvent event) {

		if (event.getModID().equalsIgnoreCase(Reference.MOD_ID)) {

			loadConfiguration();

		}

	}

	private static void loadConfiguration() {

		testValue = configuration.getBoolean("testValue", Configuration.CATEGORY_GENERAL, false, "This is an example configuration value");
		
		testInt = configuration.getInt("testInt", Configuration.CATEGORY_GENERAL, 69, 0, 100, "this is a test int");
				
		if (configuration.hasChanged()) {

			configuration.save();

		}

	}
	
	

}