package com.teknoserval.advancedmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.teknoserval.advancedmod.handler.ConfigHandler;
import com.teknoserval.advancedmod.handler.KeyInputEventHandler;
import com.teknoserval.advancedmod.init.ModRecipes;
import com.teknoserval.advancedmod.proxy.CommonProxy;
import com.teknoserval.advancedmod.reference.Reference;
import com.teknoserval.advancedmod.utility.LogHelper;
import com.teknoserval.advancedmod.world.gen.WorldGeneratorFlag;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class AdvancedMod {

	@Instance(Reference.MOD_ID)
	public static AdvancedMod instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {

		ConfigHandler.init(event.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new ConfigHandler());
		GameRegistry.registerWorldGenerator(new WorldGeneratorFlag(), 3);

		proxy.registerKeyBindings();

		LogHelper.debug("Preinitialization Complete");

	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {

		ModRecipes.init();

		MinecraftForge.EVENT_BUS.register(new KeyInputEventHandler());

		LogHelper.debug("Initialization Complete");

	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

		LogHelper.debug("Postinitialization Complete");

	}

}