package com.benthom123.test;

import com.benthom123.test.blocks.CopperBlock;
import com.benthom123.test.blocks.CopperOre;
import com.benthom123.test.blocks.OreBlock;
import com.benthom123.test.blocks.TinOre;
import com.benthom123.test.blocks.TitaniumOre;
import com.benthom123.test.blocks.datablock.DataBlock;
import net.minecraftforge.common.util.EnumHelper;

import com.benthom123.test.items.*;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
		
    @ObjectHolder("btm:obsidianingot")
    public static ModIngot obsidianingot;
    
    @ObjectHolder("btm:copperingot")
    public static ModIngot copperingot;
    
    @ObjectHolder("btm:tiningot")
    public static ModIngot tiningot;
    
    @ObjectHolder("btm:bronzeingot")
    public static ModIngot bronzeingot;
    
    @ObjectHolder("btm:aluminumingot")
    public static ModIngot aluminumingot;
    
    @ObjectHolder("btm:silveringot")
    public static ModIngot silveringot;
    
    @ObjectHolder("btm:titaniumingot")
    public static ModIngot titaniumingot;
    
    @ObjectHolder("btm:platinumingot")
    public static ModIngot platinumingot;
    
    @ObjectHolder("btm:tincan")
    public static TinCan tincan;
    
    @ObjectHolder("btm:tinmushroomsoup")
    public static TinMushroomSoup tinmushroomsoup;
    
    @ObjectHolder("btm:tinbeetrootsoup")
    public static TinBeetrootSoup tinbeetrootsoup;
    
    @ObjectHolder("btm:tinfish")
    public static TinFish tinfish;
    
    @ObjectHolder("btm:tinrabbitsoup")
    public static TinRabbitSoup tinrabbitsoup;
    
    @ObjectHolder("btm:watertincan")
    public static WaterTinCan watertincan;
    
    @ObjectHolder("btm:lavatincan")
    public static LavaTinCan lavatincan;
    
    @ObjectHolder("btm:coppernugget")
    public static CopperNugget coppernugget;
     
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
    
    @ObjectHolder("btm:smokeshot")
    public static PowerCrystal smokeshot;
    
    
    
    
    
    //OBSIDIAN TOOLS
    @ObjectHolder("btm:obsidianpickaxe")
    public static ModPickaxe obsidianpickaxe;
    
    @ObjectHolder("btm:obsidiansword")
    public static ModSword obsidiansword;
    
    @ObjectHolder("btm:obsidianaxe")
    public static ModAxe obsidianaxe;
    
    @ObjectHolder("btm:obsidianspade")
    public static ModSpade obsidianspade;
    
    @ObjectHolder("btm:obsidianhoe")
    public static ModHoe obsidianhoe;
    
    
    
    //COPPER TOOLS
    @ObjectHolder("btm:copperpickaxe")
    public static ModPickaxe copperpickaxe;
    
    @ObjectHolder("btm:coppersword")
    public static ModSword coppersword;
    
    @ObjectHolder("btm:copperaxe")
    public static ModAxe copperaxe;
    
    @ObjectHolder("btm:copperspade")
    public static ModSpade copperspade;
    
    @ObjectHolder("btm:copperhoe")
    public static ModHoe copperhoe;
    
    
    //TIN TOOLS
    @ObjectHolder("btm:tinpickaxe")
    public static ModPickaxe tinpickaxe;
    
    @ObjectHolder("btm:tinsword")
    public static ModSword tinsword;
    
    @ObjectHolder("btm:tinaxe")
    public static ModAxe tinaxe;
    
    @ObjectHolder("btm:tinspade")
    public static ModSpade tinspade;
    
    @ObjectHolder("btm:tinhoe")
    public static ModHoe tinhoe;
    
    
    //BRONZE TOOLS
    @ObjectHolder("btm:bronzepickaxe")
    public static ModPickaxe bronzepickaxe;
    
    @ObjectHolder("btm:bronzesword")
    public static ModSword bronzesword;
    
    @ObjectHolder("btm:bronzeaxe")
    public static ModAxe bronzeaxe;
    
    @ObjectHolder("btm:bronzespade")
    public static ModSpade bronzespade;
    
    @ObjectHolder("btm:bronzehoe")
    public static ModHoe bronzehoe;
    
    
    //EMERALD TOOLS
    @ObjectHolder("btm:emeraldpickaxe")
    public static ModPickaxe emeraldpickaxe;
    
    @ObjectHolder("btm:emeraldsword")
    public static ModSword emeraldsword;
    
    @ObjectHolder("btm:emeraldaxe")
    public static ModAxe emeraldaxe;
    
    @ObjectHolder("btm:emeraldspade")
    public static ModSpade emeraldspade;
    
    @ObjectHolder("btm:emeraldhoe")
    public static ModHoe emeraldhoe;
    
    
    //TITAINUM TOOLS
    @ObjectHolder("btm:titaniumpickaxe")
    public static ModPickaxe titaniumpickaxe;
    
    @ObjectHolder("btm:titaniumsword")
    public static ModSword titaniumsword;
    
    @ObjectHolder("btm:titaniumaxe")
    public static ModAxe titaniumaxe;
    
    @ObjectHolder("btm:titaniumspade")
    public static ModSpade titaniumspade;
    
    @ObjectHolder("btm:titaniumhoe")
    public static ModHoe titaniumhoe;
    
    
    //ALUMINUM TOOLS
    @ObjectHolder("btm:aluminumpickaxe")
    public static ModPickaxe aluminumpickaxe;
    
    @ObjectHolder("btm:aluminumsword")
    public static ModSword aluminumsword;
       
    @ObjectHolder("btm:aluminumaxe")
    public static ModAxe aluminumaxe;
    
    @ObjectHolder("btm:aluminumspade")
    public static ModSpade aluminumspade;
    
    @ObjectHolder("btm:aluminumhoe")
    public static ModHoe aluminumhoe;
    
    
    //SILVER TOOLS 
    @ObjectHolder("btm:silverpickaxe")
    public static ModPickaxe silverpickaxe;
    
    @ObjectHolder("btm:silversword")
    public static ModSword silversword;
    
    @ObjectHolder("btm:silveraxe")
    public static ModAxe silveraxe;
    
    @ObjectHolder("btm:silverspade")
    public static ModSpade silverspade;
    
    @ObjectHolder("btm:silverhoe")
    public static ModHoe silverhoe;
    
    
    
    //PLATINUM TOOLS
    @ObjectHolder("btm:platinumpickaxe")
    public static ModPickaxe platinumpickaxe;
    
    @ObjectHolder("btm:platinumsword")
    public static ModSword platinumsword;
    
    @ObjectHolder("btm:platinumaxe")
    public static ModAxe platinumaxe;
    
    @ObjectHolder("btm:platinumspade")
    public static ModSpade platinumspade;
    
    @ObjectHolder("btm:platinumhoe")
    public static ModHoe platinumhoe;
    
    
    
    @ObjectHolder("btm:deathscythe")
    public static DeathScythe deathscythe;
    
	public static CreativeTabs extraTools = new ModTabs(CreativeTabs.getNextID(), "Extra Tools", 1);
	public static CreativeTabs titaniumTools = new ModTabs(CreativeTabs.getNextID(), "Titanium is OP", 2);
	public static CreativeTabs platinumTools = new ModTabs(CreativeTabs.getNextID(), "Platinum is also OP", 9);
	public static CreativeTabs aluminumTools = new ModTabs(CreativeTabs.getNextID(), "Aluminum", 3);
	public static CreativeTabs silverTools = new ModTabs(CreativeTabs.getNextID(), "Silver", 4);
	public static CreativeTabs copperTools = new ModTabs(CreativeTabs.getNextID(), "Copper", 5);
	public static CreativeTabs tinTools = new ModTabs(CreativeTabs.getNextID(), "Tin", 6);
	public static CreativeTabs bronzeTools = new ModTabs(CreativeTabs.getNextID(), "Bronze", 7);
	public static CreativeTabs emeraldTools = new ModTabs(CreativeTabs.getNextID(), "Emerald", 8);
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
        DataBlock.initModel();
        obsidianingot.initModel();
        CopperOre.initModel();  
        CopperBlock.initModel();
        TitaniumOre.initModel();
    	TinBlock.initModel();
    	TitaniumBlock.initModel();
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
        copperspade.initModel();
        copperaxe.initModel();
    	TinOre.initModel();
    	tiningot.initModel();
    	tincan.initModel();
    	watertincan.initModel();
    	lavatincan.initModel();
    	tinmushroomsoup.initModel();
    	tinbeetrootsoup.initModel();
    	tinrabbitsoup.initModel();
    	tinfish.initModel();
    	tinaxe.initModel();
    	tinhoe.initModel();
    	tinpickaxe.initModel();
    	tinspade.initModel();
      	tinsword.initModel();
      	emeraldpickaxe.initModel();
      	emeraldsword.initModel();
      	emeraldspade.initModel();
      	emeraldhoe.initModel();
      	emeraldaxe.initModel();
      	bronzeingot.initModel();
      	bronzepickaxe.initModel();
      	bronzesword.initModel();
      	bronzeaxe.initModel();
      	bronzespade.initModel();
      	bronzehoe.initModel();
      	titaniumingot.initModel();
      	titaniumpickaxe.initModel();
      	titaniumsword.initModel();
      	titaniumspade.initModel();
      	titaniumhoe.initModel();
      	titaniumaxe.initModel();
      	aluminumingot.initModel();
      	aluminumpickaxe.initModel();
      	aluminumaxe.initModel();
      	aluminumsword.initModel();
      	aluminumspade.initModel();
      	aluminumhoe.initModel();
      	silveringot.initModel();
      	silverpickaxe.initModel();
      	silveraxe.initModel();
      	silversword.initModel();
      	silverspade.initModel();
      	silverhoe.initModel();
      	platinumingot.initModel();
      	platinumpickaxe.initModel();
      	platinumsword.initModel();
      	platinumspade.initModel();
      	platinumhoe.initModel();
      	platinumaxe.initModel();
      	smokeshot.initModel();
      	
    }
    
}