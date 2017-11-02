package com.benthom123.test.proxy;

import java.io.File;

import com.benthom123.test.Config;
import com.benthom123.test.ModBlocks;
import com.benthom123.test.ModCrafting;
import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;
import com.benthom123.test.blocks.CopperOre;
import com.benthom123.test.blocks.CopperBlock;
import com.benthom123.test.blocks.FirstBlock;
import com.benthom123.test.blocks.datablock.DataBlock;
import com.benthom123.test.blocks.datablock.DataTileEntity;
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
import com.benthom123.test.items.WorldGen;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
	// Config instance
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "btm.cfg"));
        Config.readConfig();
    }
    public void init(FMLInitializationEvent e) {
    	 if (config.hasChanged()) {
             config.save();
         }
    	 ModCrafting.registerCrafting();
    	 ModCrafting.registerSmelting();
    	 GameRegistry.registerWorldGenerator(new WorldGen(), 0); 
    	 
    }
    
    public static ToolMaterial OBSIDIAN = EnumHelper.addToolMaterial("OBSIDIAN", 4, 3122, 5.0F, 4.0F, 5 );
    public static ToolMaterial COPPER = EnumHelper.addToolMaterial("COPPER", 3, 175, 5.0F, 1.0F, 17 );
	public static ToolMaterial DEATH = EnumHelper.addToolMaterial("DEATH", 1, 4, 1.0F, 1.0F,  1 );

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	  event.getRegistry().register(new FirstItem());
    	  event.getRegistry().register(new CopperIngot());
    	  event.getRegistry().register(new CopperNugget());
    	  event.getRegistry().register(new ObsidianPickaxe("obsidianpickaxe", OBSIDIAN));
    	  event.getRegistry().register(new CopperPickaxe("copperpickaxe", COPPER));
    	  event.getRegistry().register(new ObsidianSword("obsidiansword", OBSIDIAN));
    	  event.getRegistry().register(new CopperSword("coppersword", COPPER));
    	  event.getRegistry().register(new ObsidianAxe("obsidianaxe", OBSIDIAN));
    	  event.getRegistry().register(new ObsidianSpade("obsidianspade", OBSIDIAN));
    	  event.getRegistry().register(new ObsidianHoe("obsidianhoe", OBSIDIAN));
    	  event.getRegistry().register(new CopperHoe("copperhoe", COPPER));
    	  event.getRegistry().register(new DeathScythe("deathscythe", DEATH, ModItems.ObsidianIngot));
    	  event.getRegistry().register(new ItemBlock(ModBlocks.DataBlock).setRegistryName(ModBlocks.DataBlock.getRegistryName()));
    	  event.getRegistry().register(new ItemBlock(ModBlocks.SmoothObsidian).setRegistryName(ModBlocks.SmoothObsidian.getRegistryName()));
    	  event.getRegistry().register(new ItemBlock(ModBlocks.CopperOre).setRegistryName(ModBlocks.CopperOre.getRegistryName()));
    	  event.getRegistry().register(new ItemBlock(ModBlocks.CopperBlock).setRegistryName(ModBlocks.CopperBlock.getRegistryName()));
    	  GameRegistry.registerTileEntity(DataTileEntity.class, modClass.MODID + "_datablock");
    }            

    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	 event.getRegistry().register(new FirstBlock());
    	 event.getRegistry().register(new DataBlock());
    	 event.getRegistry().register(new CopperOre());
    	 event.getRegistry().register(new CopperBlock());
    }
}