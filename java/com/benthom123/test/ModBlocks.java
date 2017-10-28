package com.benthom123.test;

import com.benthom123.test.blocks.FirstBlock;
import com.benthom123.test.blocks.datablock.DataBlock;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @ObjectHolder("btm:smoothobsidian")
    public static FirstBlock SmoothObsidian = new FirstBlock();



    @ObjectHolder("btm:datablock")
    public static DataBlock DataBlock = new DataBlock();


    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	DataBlock.initModel();
    	SmoothObsidian.initModel();
    }
}