package com.benthom123.test.blocks;

import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FirstBlock extends Block  {
    public FirstBlock() {
        super(Material.ROCK);
        setUnlocalizedName(modClass.MODID + ".smoothobsidian");     // Used for localization (en_US.lang)
        setRegistryName("smoothobsidian");        // The unique name (within your mod) that identifies this block
        this.setCreativeTab(ModItems.extraTools);
    }
    
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}