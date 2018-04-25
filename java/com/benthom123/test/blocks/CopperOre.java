package com.benthom123.test.blocks;


import java.util.ArrayList;
import java.util.Random;

import com.benthom123.test.ModBlocks;
import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class CopperOre extends Block {
	
    @Override
    public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        drops.add(new ItemStack(ModItems.coppernugget, RANDOM.nextInt(5) + 2)); //drops between 5 and 2 nuggets everytime with no fortune
        if (RANDOM.nextFloat() < 0.1F) //gives a one in ten chance of dropping a copper ingot
            drops.add(new ItemStack(ModItems.copperingot));
        return drops;
    }
	    public CopperOre() {
	        super(Material.ROCK);
	        this.setHarvestLevel("pickaxe", 0 );
	        this.setHardness(3.0F);
	        this.setResistance(15.0f);
	        setUnlocalizedName(modClass.MODID + ".copperore");     // Used for localization (en_US.lang)
	        setRegistryName("copperore");        // The unique name (within your mod) that identifies this block
	        this.setCreativeTab(ModItems.extraTools);
	        
	    }

	    @SideOnly(Side.CLIENT)
	    public void initModel() {
	        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	    }

	}

