package com.benthom123.test.blocks;

import com.benthom123.test.modClass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FirstBlock extends Block {
    public FirstBlock() {
        super(Material.ROCK);
        setUnlocalizedName(modClass.MODID + ".SmoothObsidian");     // Used for localization (en_US.lang)
        setRegistryName("SmoothObsidian");        // The unique name (within your mod) that identifies this block
    }

}