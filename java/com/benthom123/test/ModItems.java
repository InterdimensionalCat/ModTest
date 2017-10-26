package com.benthom123.test;

import com.benthom123.test.blocks.datablock.DataBlock;
import com.benthom123.test.items.FirstItem;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    @ObjectHolder("btm:ObsidianIngot")
    public static FirstItem ObsidianIngot = new FirstItem();
     
    
    @ObjectHolder("btm:datablock")
    public static DataBlock DataBlock = new DataBlock();  
   
    @SideOnly(Side.CLIENT)
    public static void initModels() {
        DataBlock.initModel();
        ObsidianIngot.initModel();
    }
}