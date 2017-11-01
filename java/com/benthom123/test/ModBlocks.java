package com.benthom123.test;

import com.benthom123.test.blocks.FirstBlock;
import com.benthom123.test.blocks.CopperBlock;
import com.benthom123.test.blocks.datablock.DataBlock;
import com.benthom123.test.blocks.CopperOre;

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
    
    @ObjectHolder("btm:copperblock")
    public static CopperBlock CopperBlock;


    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	DataBlock.initModel();
    	SmoothObsidian.initModel();
    	CopperOre.initModel();
    	CopperBlock.initModel();
    }
}