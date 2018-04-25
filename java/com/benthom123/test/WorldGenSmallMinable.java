package com.benthom123.test;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.util.math.BlockPos;

public class WorldGenSmallMinable extends WorldGenerator
	{
	    @Override
	    public boolean generate(World worldIn, Random rand, BlockPos pos)
	    {
	        int count = 3 + rand.nextInt(6);
	        for (int i = 0; i < count; i++)
	        {
	            int offset = net.minecraftforge.common.ForgeModContainer.fixVanillaCascading ? 8 : 0; // MC-114332
	            //BlockPos blockpos = pos.add(rand.nextInt(16) + offset, 0, rand.nextInt(16) + offset);
	            BlockPos blockpos =  new BlockPos(pos.getX(), 17, pos.getZ());

	            net.minecraft.block.state.IBlockState state = worldIn.getBlockState(blockpos);
	            if (state.getBlock().isReplaceableOreGen(state, worldIn, blockpos, net.minecraft.block.state.pattern.BlockMatcher.forBlock(Blocks.STONE)))
	            {
	                worldIn.setBlockState(blockpos, ModBlocks.TitaniumOre.getDefaultState(), 16 | 2);
	            }
	        }
	        return true;
	    }
	}


