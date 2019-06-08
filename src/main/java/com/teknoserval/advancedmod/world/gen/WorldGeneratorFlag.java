package com.teknoserval.advancedmod.world.gen;

import java.util.Random;

import com.teknoserval.advancedmod.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.biome.BiomeRiver;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenSpikes;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.tools.nsc.transform.patmat.Logic.PropositionalLogic.AbsVar;

public class WorldGeneratorFlag implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

		switch (world.provider.getDimension()) {
		case -1:
			generateNether(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
			break;
		case 0:
			generateSurface(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
			break;
		case 1:
			generateEnd(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
			break;
		default:
			generateSurface(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}

	}

	private void generateEnd(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

	}

	private void generateNether(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

	}

	private void generateSurface(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

		int Xmult = 1;
		int Zmult = 1;

		if (chunkX < 0) {
			Xmult = -1;
		}
		if (chunkZ < 0) {
			Zmult = -1;
		}

		int x = chunkX * 16 + Xmult * (2 + random.nextInt(12));
		int z = chunkZ * 16 + Zmult * (2 + random.nextInt(12));
		int y = world.getHeight(x, z);

		BlockPos pos = new BlockPos(x, y, z);
		BlockPos underPos = pos.add(0, -1, 0);
		Block topBlock = world.getBlockState(underPos).getBlock();
		if (topBlock != Blocks.WATER && topBlock != Blocks.LAVA) {

			generatePoop(pos, world, random);
		}
		
		for (int i = 0; i < 5; i ++) {
			BlockPos randPos = new BlockPos(pos.getX(), 16 + random.nextInt(32), pos.getZ());
			poopGen.generate(world, random, randPos);
		}
	}

	private void generatePoop(BlockPos pos, World world, Random random) {
		// TODO Auto-generated method stub

		world.setBlockState(pos, ModBlocks.BLUE_POOP_BLOCK.getDefaultState());
		pos = pos.add(1, 0, 0);
		world.setBlockState(pos, ModBlocks.BLUE_POOP_BLOCK.getDefaultState());
		pos = pos.add(-2, 0, 0);
		world.setBlockState(pos, ModBlocks.BLUE_POOP_BLOCK.getDefaultState());
		pos = pos.add(1, 0, 1);
		world.setBlockState(pos, ModBlocks.BLUE_POOP_BLOCK.getDefaultState());
		pos = pos.add(0, 0, -2);
		world.setBlockState(pos, ModBlocks.BLUE_POOP_BLOCK.getDefaultState());
		pos = pos.add(0, 1, 1);
		world.setBlockState(pos, ModBlocks.BLUE_POOP_BLOCK.getDefaultState());
	}

	private WorldGenMinable poopGen = new WorldGenMinable(ModBlocks.BLUE_POOP_BLOCK.getDefaultState(), 20);

}
