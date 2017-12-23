package com.benthom123.test;

import org.apache.logging.log4j.Logger;

import com.benthom123.test.proxy.CommonProxy;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = modClass.MODID, name = modClass.MODNAME, version = modClass.MODVERSION, acceptedMinecraftVersions = modClass.ACCEPTED_VERSIONS, useMetadata = true) //dependencies = "required-after:Forge@[14.23.0.2515,)", )
public class modClass {

    public static final String MODID = "btm";
    public static final String MODNAME = "test";
    public static final String MODVERSION = "0.0.1";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";

    @SidedProxy(clientSide = "com.benthom123.test.proxy.ClientProxy", serverSide = "com.benthom123.test.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static modClass instance;

    public static Logger logger;

    static {
    	FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
        FluidRegistry.addBucketForFluid(FluidRegistry.WATER);
        FluidRegistry.addBucketForFluid(FluidRegistry.LAVA);
        
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}



