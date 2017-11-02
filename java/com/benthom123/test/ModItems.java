package com.benthom123.test;

import com.benthom123.test.blocks.CopperBlock;
import com.benthom123.test.blocks.CopperOre;
import com.benthom123.test.blocks.datablock.DataBlock;
import net.minecraftforge.common.util.EnumHelper;

import com.benthom123.test.items.CopperHoe;
import com.benthom123.test.items.CopperIngot;
import com.benthom123.test.items.CopperNugget;
import com.benthom123.test.items.CopperPickaxe;
import com.benthom123.test.items.CopperSword;
import com.benthom123.test.items.DeathScythe;
import com.benthom123.test.items.FirstItem;
import com.benthom123.test.items.ObsidianAxe;
import com.benthom123.test.items.ObsidianHoe;
import com.benthom123.test.items.ObsidianPickaxe;
import com.benthom123.test.items.ObsidianSpade;
import com.benthom123.test.items.ObsidianSword;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	
	
	public static CreativeTabs extraTools = new ModTabs(CreativeTabs.getNextID(), "Extra Tools");
	
    @ObjectHolder("btm:obsidianingot")
    public static FirstItem ObsidianIngot;
    
    @ObjectHolder("btm:copperingot")
    public static CopperIngot copperingot;
    
    @ObjectHolder("btm:coppernugget")
    public static CopperNugget coppernugget;
     
    @ObjectHolder("btm:datablock")
    public static DataBlock DataBlock;
    
    @ObjectHolder("btm:copperore")
    public static CopperOre CopperOre;
    
    @ObjectHolder("btm:copperblock")
    public static CopperBlock CopperBlock;
    
    @ObjectHolder("btm:obsidianpickaxe")
    public static ObsidianPickaxe obsidianpickaxe;
    
    @ObjectHolder("btm:copperpickaxe")
    public static CopperPickaxe copperpickaxe;
    
    @ObjectHolder("btm:obsidiansword")
    public static ObsidianSword obsidiansword;
    
    @ObjectHolder("btm:coppersword")
    public static CopperSword coppersword;
   
    @ObjectHolder("btm:obsidianaxe")
    public static ObsidianAxe obsidianaxe;
    
    @ObjectHolder("btm:obsidianspade")
    public static ObsidianSpade obsidianspade;
    
    @ObjectHolder("btm:obsidianhoe")
    public static ObsidianHoe obsidianhoe;
    
    @ObjectHolder("btm:copperhoe")
    public static CopperHoe copperhoe;
    
    @ObjectHolder("btm:deathscythe")
    public static DeathScythe deathscythe;
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
        DataBlock.initModel();
        ObsidianIngot.initModel();
        CopperOre.initModel();  
        CopperBlock.initModel();
        obsidianpickaxe.initModel();
        obsidiansword.initModel();
        obsidianaxe.initModel();
        obsidianspade.initModel();
        obsidianhoe.initModel();
        deathscythe.initModel();
        copperingot.initModel();
        coppernugget.initModel();
        copperpickaxe.initModel();
        coppersword.initModel();
        copperhoe.initModel();
    }
    
}