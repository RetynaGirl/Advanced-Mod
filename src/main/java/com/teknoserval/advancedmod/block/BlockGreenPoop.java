package com.teknoserval.advancedmod.block;

import com.teknoserval.advancedmod.creativetab.ModCreativeTab;
import com.teknoserval.advancedmod.init.ModBlocks;
import com.teknoserval.advancedmod.init.ModItems;
import com.teknoserval.advancedmod.utility.IHasModel;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class BlockGreenPoop extends ModBlock implements IHasModel {

	public BlockGreenPoop(Material material) {
		super(material);
		String name = "green_poop_block";
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModCreativeTab.ADVANCED_TAB);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public BlockGreenPoop() {
		this(Material.ROCK);
	}

}
