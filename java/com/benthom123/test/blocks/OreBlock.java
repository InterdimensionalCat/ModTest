package com.benthom123.test.blocks;

import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OreBlock extends Block {
	
	
	 public OreBlock(Material material, String unlocalizedName, int harvestLevel, float hardness, float resistance, CreativeTabs tab ) {
	        super(material);
	        this.setHarvestLevel("pickaxe", harvestLevel);
	        this.setHardness(hardness);
	        this.setResistance(resistance);
	        setUnlocalizedName(modClass.MODID + "." + unlocalizedName);
	        setRegistryName(unlocalizedName);
	        this.setCreativeTab(tab);
	    }
	    
	    
	    @SideOnly(Side.CLIENT)
	    public void initModel() {
	        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	    }
	}
