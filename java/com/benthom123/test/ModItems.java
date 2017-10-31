package com.benthom123.test;

import com.benthom123.test.blocks.CopperOre;
import com.benthom123.test.blocks.datablock.DataBlock;
import net.minecraftforge.common.util.EnumHelper;

import com.benthom123.test.items.CopperIngot;
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
	
	public static ToolMaterial OBSIDIAN = EnumHelper.addToolMaterial("OBSIDIAN", 3, 131, 24.0F, 4.0F,  5 );
	public static ToolMaterial DEATH = EnumHelper.addToolMaterial("DEATH", 1, 4, 1.0F, 1.0F,  1 );
	
	public static CreativeTabs extraTools = new ModTabs(CreativeTabs.getNextID(), "Extra Tools");
	
    @ObjectHolder("btm:obsidianingot")
    public static FirstItem ObsidianIngot = new FirstItem();
    
    @ObjectHolder("btm:copperingot")
    public static CopperIngot copperingot = new CopperIngot();
     
    @ObjectHolder("btm:datablock")
    public static DataBlock DataBlock = new DataBlock();
    
    @ObjectHolder("btm:copperore")
    public static CopperOre CopperOre = new CopperOre();
    
    @ObjectHolder("btm:obsidianpickaxe")
    public static ObsidianPickaxe obsidianpickaxe = new ObsidianPickaxe("obsidianpickaxe", OBSIDIAN);
    
    @ObjectHolder("btm:obsidiansword")
    public static ObsidianSword obsidiansword = new ObsidianSword("obsidiansword", OBSIDIAN);
   
    @ObjectHolder("btm:obsidianaxe")
    public static ObsidianAxe obsidianaxe = new ObsidianAxe("obsidianaxe", OBSIDIAN);
    
    @ObjectHolder("btm:obsidianspade")
    public static ObsidianSpade obsidianspade = new ObsidianSpade("obsidianspade", OBSIDIAN);
    
    @ObjectHolder("btm:obsidianhoe")
    public static ObsidianHoe obsidianhoe = new ObsidianHoe("obsidianhoe", OBSIDIAN);
    
    @ObjectHolder("btm:deathscythe")
    public static DeathScythe deathscythe = new DeathScythe("obsidianhoe", DEATH, ObsidianIngot	 );
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
        DataBlock.initModel();
        ObsidianIngot.initModel();
        obsidianpickaxe.initModel();
        obsidiansword.initModel();
        obsidianaxe.initModel();
        obsidianspade.initModel();
        obsidianhoe.initModel();
        deathscythe.initModel();
        copperingot.initModel();
        CopperOre.initModel();    
    }
    
}