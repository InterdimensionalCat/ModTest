package com.benthom123.test.blocks;


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
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class CopperOre extends Block {
	
	private Item drop;
	private int least_quantity;
	private int most_quantity;
	private int meta;

	    public CopperOre() {
	        super(Material.ROCK);
	        this.drop = ModItems.copperingot;
	        this.least_quantity = 1;
	        this.most_quantity = 3;
	        this.meta = 0;
	        this.setHarvestLevel("pickaxe", 2 );
	        this.setHardness(3.0F);
	        this.setResistance(15.0f);
	        setUnlocalizedName(modClass.MODID + ".copperore");     // Used for localization (en_US.lang)
	        setRegistryName("copperore");        // The unique name (within your mod) that identifies this block
	        this.setCreativeTab(ModItems.extraTools);
	        
	    }
	        
	        @Override
	        public Item getItemDropped(IBlockState blockstate, Random random, int fortune) {
	            return this.drop;
	        }
	        
	        @Override
	        public int damageDropped(IBlockState blockstate) {
	            return this.meta;
	        }

	        @Override
	        public int quantityDropped(IBlockState blockstate, int fortune, Random random) {
	            if (this.least_quantity >= this.most_quantity)
	                return this.least_quantity;
	            return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	        }
	        
	    
	    @SideOnly(Side.CLIENT)
	    public void initModel() {
	        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	    }

	}

