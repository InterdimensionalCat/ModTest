package com.benthom123.test;

import java.util.Random;

import com.benthom123.test.blocks.CopperOre;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		this.runGenerator(this.copperore, world, random, chunkX, chunkZ, 15, 0, 128);
		this.runGenerator(this.titaniumore, world, random, chunkX, chunkZ, 2, 13, 17);
		this.runGenerator(this.tinore, world, random, chunkX, chunkZ, 17, 0, 128);//first int is number of times it will try to spawn per chunk, second is minimum height, third is maximum height
	}
	
	private WorldGenerator copperore;
	private WorldGenerator tinore;
	private WorldGenerator titaniumore;
	
	public WorldGen() {
	    this.copperore = new WorldGenMinable(ModBlocks.CopperOre.getDefaultState(), 10);
	    this.titaniumore = new WorldGenSmallMinable(); //single generation
	    this.tinore = new WorldGenMinable(ModBlocks.TinOre.getDefaultState(), 13);// this is the maximum vein size, must use a different method for smaller vein sizes
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z) );
	    }
	}
	
}
