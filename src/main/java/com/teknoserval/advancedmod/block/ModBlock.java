package com.teknoserval.advancedmod.block;

import com.teknoserval.advancedmod.AdvancedMod;
import com.teknoserval.advancedmod.creativetab.ModCreativeTab;
import com.teknoserval.advancedmod.init.ModBlocks;
import com.teknoserval.advancedmod.init.ModItems;
import com.teknoserval.advancedmod.item.ModItem;
import com.teknoserval.advancedmod.utility.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class ModBlock extends Block implements IHasModel {

	public ModBlock(Material material) {

		super(material);
		String name = "base_block";
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModCreativeTab.ADVANCED_TAB);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

	

	@Override
	public void registerModels() {

		AdvancedMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

}