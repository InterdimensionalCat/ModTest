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


public class TitaniumOre extends Block {
	
    @Override
    public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        drops.add(new ItemStack(ModItems.titaniumingot, 1));
        if (RANDOM.nextFloat() < 0.05F)
            drops.add(new ItemStack(ModItems.titaniumingot, 10));
        return drops;
    }
	    public TitaniumOre() {
	        super(Material.ROCK);
	        this.setHarvestLevel("pickaxe", 4 );
	        this.setHardness(10.0F);
	        this.setResistance(100.0f);
	        setUnlocalizedName(modClass.MODID + ".titaniumore");     // Used for localization (en_US.lang)
	        setRegistryName("titaniumore");        // The unique name (within your mod) that identifies this block
	        this.setCreativeTab(ModItems.titaniumTools);
	        
	    }

	    @SideOnly(Side.CLIENT)
	    public void initModel() {
	        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	    }

	}

