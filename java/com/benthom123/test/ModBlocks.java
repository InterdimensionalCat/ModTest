package com.benthom123.test;

import com.benthom123.test.blocks.FirstBlock;
import com.benthom123.test.blocks.OreBlock;
import com.benthom123.test.blocks.CopperBlock;
import com.benthom123.test.blocks.datablock.DataBlock;
import com.benthom123.test.blocks.CopperOre;
import com.benthom123.test.blocks.TinOre;
import com.benthom123.test.blocks.TitaniumOre;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @ObjectHolder("btm:smoothobsidian")
    public static FirstBlock SmoothObsidian;

    @ObjectHolder("btm:datablock")
    public static DataBlock DataBlock;
    
    @ObjectHolder("btm:copperore")
    public static CopperOre CopperOre;
    
    @ObjectHolder("btm:tinore")
    public static TinOre TinOre;
    
    @ObjectHolder("btm:titaniumore")
    public static TitaniumOre TitaniumOre;
    
    @ObjectHolder("btm:copperblock")
    public static CopperBlock CopperBlock;
    
    @ObjectHolder("btm:tinblock")
    public static OreBlock TinBlock;
    
    @ObjectHolder("btm:titaniumblock")
    public static OreBlock TitaniumBlock;


    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	DataBlock.initModel();
    	SmoothObsidian.initModel();
    	CopperOre.initModel();
    	CopperBlock.initModel();
    	TinOre.initModel();
    	TitaniumOre.initModel();
    	TinBlock.initModel();
    	TitaniumBlock.initModel();
    }
}