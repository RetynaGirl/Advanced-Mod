package com.teknoserval.advancedmod.item;

import net.minecraft.item.Item;
import com.teknoserval.advancedmod.creativetab.ModCreativeTab;
import com.teknoserval.advancedmod.init.ModItems;
import com.teknoserval.advancedmod.utility.IHasModel;
import com.teknoserval.advancedmod.AdvancedMod;

public class ModItem extends Item implements IHasModel {

	public ModItem() {
		
		
		String name = "base_item";
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModCreativeTab.ADVANCED_TAB);
		
		ModItems.ITEMS.add(this);
		
	}
	
	@Override
	public void registerModels() {

		AdvancedMod.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	
}
	
	
