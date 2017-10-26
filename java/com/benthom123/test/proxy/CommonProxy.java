package com.benthom123.test.proxy;

import java.io.File;

import com.benthom123.test.Config;
import com.benthom123.test.ModBlocks;
import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;
import com.benthom123.test.blocks.FirstBlock;
import com.benthom123.test.blocks.datablock.DataTileEntity;
import com.benthom123.test.items.FirstItem;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.config.Configuration;
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
        config = new Configuration(new File(directory.getPath(), "modtut.cfg"));
        Config.readConfig();
    }
    public void init(FMLInitializationEvent e) {
    	 if (config.hasChanged()) {
             config.save();
         }
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	 event.getRegistry().register(new FirstBlock());
    	 GameRegistry.registerTileEntity(DataTileEntity.class, modClass.MODID + "_datablock");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	  event.getRegistry().register(new ItemBlock(ModBlocks.SmoothObsidian).setRegistryName(ModBlocks.SmoothObsidian.getRegistryName()));
    	  event.getRegistry().register(new FirstItem());
    	  event.getRegistry().register(new ItemBlock(ModBlocks.DataBlock).setRegistryName(ModBlocks.DataBlock.getRegistryName()));
    }            
}