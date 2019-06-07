package com.teknoserval.advancedmod.creativetab;

import com.teknoserval.advancedmod.init.ModItems;
import com.teknoserval.advancedmod.reference.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModCreativeTab {

	public static final CreativeTabs ADVANCED_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {

		@Override
		public ItemStack getTabIconItem() {

			return new ItemStack(ModItems.base_item);
		}
		
		

	};

}