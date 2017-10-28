package com.benthom123.test;

import com.benthom123.test.blocks.datablock.DataBlock;
import net.minecraftforge.common.util.EnumHelper;
import com.benthom123.test.items.FirstItem;
import com.benthom123.test.items.ObsidianAxe;
import com.benthom123.test.items.ObsidianPickaxe;
import com.benthom123.test.items.ObsidianSword;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	
	public static ToolMaterial OBSIDIAN = EnumHelper.addToolMaterial("OBSIDIAN", 3, 131, 24.0F, 4.0F, 5 );

    @ObjectHolder("btm:obsidianingot")
    public static FirstItem ObsidianIngot = new FirstItem();
     
    @ObjectHolder("btm:datablock")
    public static DataBlock DataBlock = new DataBlock();
    
    @ObjectHolder("btm:obsidianpickaxe")
    public static ObsidianPickaxe obsidianpickaxe = new ObsidianPickaxe("obsidianpickaxe", OBSIDIAN);
    
    @ObjectHolder("btm:obsidiansword")
    public static ObsidianSword obsidiansword = new ObsidianSword("obsidiansword", OBSIDIAN);
   
    @ObjectHolder("btm:obsidiansword")
    public static ObsidianAxe obsidianaxe = new ObsidianAxe("obsidianAxe", OBSIDIAN);
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
        DataBlock.initModel();
        ObsidianIngot.initModel();
        obsidianpickaxe.initModel();
        obsidiansword.initModel();
        obsidianaxe.initModel();
    }
    
}