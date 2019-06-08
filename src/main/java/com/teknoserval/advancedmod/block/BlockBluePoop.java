package com.teknoserval.advancedmod.block;

import com.teknoserval.advancedmod.creativetab.ModCreativeTab;
import com.teknoserval.advancedmod.init.ModBlocks;
import com.teknoserval.advancedmod.init.ModItems;
import com.teknoserval.advancedmod.utility.IHasModel;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBluePoop extends ModBlock implements IHasModel {

	public BlockBluePoop(Material material) {
		super(material);
		String name = "blue_poop_block";
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModCreativeTab.ADVANCED_TAB);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public BlockBluePoop() {
		this(Material.ROCK);
	}

}
