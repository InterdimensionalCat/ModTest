package com.benthom123.test.proxy;

import java.io.File;

import com.benthom123.test.Config;
import com.benthom123.test.ModBlocks;
import com.benthom123.test.ModCrafting;
import com.benthom123.test.ModEntities;
import com.benthom123.test.ModItems;
import com.benthom123.test.ModMath;
import com.benthom123.test.ModTabs;
import com.benthom123.test.WorldGen;
import com.benthom123.test.modClass;
import com.benthom123.test.blocks.CopperOre;
import com.benthom123.test.blocks.TinOre;
import com.benthom123.test.blocks.TitaniumOre;
import com.benthom123.test.blocks.CopperBlock;
import com.benthom123.test.blocks.FirstBlock;
import com.benthom123.test.blocks.OreBlock;
import com.benthom123.test.blocks.datablock.DataBlock;
import com.benthom123.test.blocks.datablock.DataTileEntity;
import com.benthom123.test.entity.EntitySmokeShot;
import com.benthom123.test.items.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSoup;
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
        ModEntities.init();
    }
    public void init(FMLInitializationEvent e) {
    	 if (config.hasChanged()) {
             config.save();
         }
    	 ModCrafting.registerCrafting();
    	 ModCrafting.registerToolCrafting("aluminum", ModItems.aluminumpickaxe, ModItems.aluminumsword, ModItems.aluminumaxe, ModItems.aluminumspade, ModItems.aluminumhoe, ModItems.aluminumingot);
    	 ModCrafting.registerToolCrafting("silver", ModItems.silverpickaxe, ModItems.silversword, ModItems.silveraxe, ModItems.silverspade, ModItems.silverhoe, ModItems.silveringot);
    	 ModCrafting.registerToolCrafting("obsidian", ModItems.obsidianpickaxe, ModItems.obsidiansword, ModItems.obsidianaxe, ModItems.obsidianspade, ModItems.obsidianhoe, ModItems.obsidianingot);
    	 ModCrafting.registerToolCrafting("copper", ModItems.copperpickaxe, ModItems.coppersword, ModItems.copperaxe, ModItems.copperspade, ModItems.copperhoe, ModItems.copperingot);
    	 ModCrafting.registerToolCrafting("tin", ModItems.tinpickaxe, ModItems.tinsword, ModItems.tinaxe, ModItems.tinspade, ModItems.tinhoe, ModItems.tiningot);
    	 ModCrafting.registerToolCrafting("bronze", ModItems.bronzepickaxe, ModItems.bronzesword, ModItems.bronzeaxe, ModItems.bronzespade, ModItems.bronzehoe, ModItems.bronzeingot);
    	 ModCrafting.registerToolCrafting("emerald", ModItems.emeraldpickaxe, ModItems.emeraldsword, ModItems.emeraldaxe, ModItems.emeraldspade, ModItems.emeraldhoe, Items.EMERALD);
    	 ModCrafting.registerToolCrafting("titanium", ModItems.titaniumpickaxe, ModItems.titaniumsword, ModItems.titaniumaxe, ModItems.titaniumspade, ModItems.titaniumhoe, ModItems.titaniumingot);
    	 ModCrafting.registerToolCrafting("platinum", ModItems.platinumpickaxe, ModItems.platinumsword, ModItems.platinumaxe, ModItems.platinumspade, ModItems.platinumhoe, ModItems.platinumingot);
    	 ModCrafting.registerSmelting();
    	 GameRegistry.registerWorldGenerator(new WorldGen(), 0);	 
    	 
    }
    
    public static ToolMaterial OBSIDIAN = EnumHelper.addToolMaterial/*NEW OBSIDIAN RATIOS ARE 2.50 SPEED, and 1.25 for attack */("OBSIDIAN", 3, 1561, 8.0F, 3.0F, 10 );//fast, light diamond alternative
    public static ToolMaterial TIN = EnumHelper.addToolMaterial/* new/vanilla attSpeed = 1.375, vanilla/new damage = 1.25 */("TIN", 1, 131, 4.0F, 1.0F, 5 );  //intended to be an alternative to stone, same harvest level, durability, and lower attack damage, but better attack speed, mining speed and enchant, However slightly harder to get than stone (smelting), low damage for high attack speed (MAY SWAP TIN AND ALUMINUM PLACEMENT AND MAKE BRONZE ALUMINUM BRONZE)
    public static ToolMaterial COPPER = EnumHelper.addToolMaterial/*the COPPER SPEED / the stone speed = 0.75 , uses a flat attack damage increase */("COPPER", 1, 131, 5.0F, 2.0F, 5 ); //intended to be another alternative to stone same harvest level, iron level durability high mining speed and damage, same enchant. Lower attack speed and will be hard to find.
    public static ToolMaterial BRONZE = EnumHelper.addToolMaterial("BRONZE", 2, 250, 7.0F, 3.0F, 14 /*attack speed ratio of 1.5 I SWAPPED BRONZE AND ALUMINUM AND I WAS TOO LAZY TO CHANGE THE COMMENT(vanilla/modified)*/); //intended to be a heavier, more powerful iron, will be constructed from copper and tin. Same harvest level and durability, slightly more than diamond attack, slightly higher attack speed drop from copper, slightly higher mining speed, same enchant
    public static ToolMaterial ALUMINUM = EnumHelper.addToolMaterial("ALUMINUM", 2, 250, 6.0F, 2.0F /*this value was achieved by increasing the stone/tin damage ratio(1.25) to 2.25 FOR BOTH ATTACK SPEED AND DAMAGE !!! THE ATTACK SPEED WAS CHANGED TO 2.0 BECAUSE IT WAS TOO CHEEKY, FLOAT VALUE FOR ATTACK HERE CHANGD TO 2.0 FROM 0.89, ATTACK RATIO CHANGED TO 1.25 LIKE THE REST OF THE ATTACK UP TOOLS*/, 14 ); //intended to be a lighter, weaker iron
    public static ToolMaterial SILVER = EnumHelper.addToolMaterial("SILVER", 3, 1561, 10.0F, 4.0F, 10 ); //heavier, more powerful diamond faster mining speed and higher damage
    public static ToolMaterial EMERALD = EnumHelper.addToolMaterial("EMERALD", 4, 3122, 12.0F, 4.0F, 30 ); //logical extention of the basic tools, elite harvest rank, highest durability, gold mining speed, insane attack, insane enchantment rate
    public static ToolMaterial PLATINUM = EnumHelper.addToolMaterial("PLATINUM", 4, 3122, 12.0F, 6.5F, 30 ); //intended to be a god tier metal with insane attack damage
    public static ToolMaterial TITANIUM = EnumHelper.addToolMaterial("TITANIUM", 4, 3122, 12.0F, 4.0F, 30 );  //intended to be a god tier metal with insane attack speed (TONED THE ATTACK SPEED DOWN BECAUSE IT WAS LITERALLY OVER THE MAX LMAOOOO)
    public static ToolMaterial MARTENSITIC_STAINLESS_STEEL = EnumHelper.addToolMaterial("MARTENSITIC_STAINLESS_STEEL", 1, 250, 5.0F, 2.0F, 5 ); //will be a composition of chromium, diamond, and iron, will be a god tier all in one tool
    public static ToolMaterial DEATH = EnumHelper.addToolMaterial("DEATH", 1, 4, 1.0F, 1.0F,  1 );

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	  //event.getRegistry().register(new FirstItem());
 /*   	  event.getRegistry().register(new CopperIngot());
    	  event.getRegistry().register(new TinIngot());
    	  event.getRegistry().register(new BronzeIngot());
    	  event.getRegistry().register(new TitaniumIngot());*/
    	  
    	  //INGOTS
    	  event.getRegistry().register(new ModIngot("obsidianingot", ModItems.extraTools));
    	  event.getRegistry().register(new ModIngot("copperingot", ModItems.extraTools));
    	  event.getRegistry().register(new ModIngot("tiningot", ModItems.extraTools));
    	  event.getRegistry().register(new ModIngot("bronzeingot", ModItems.extraTools));
    	  event.getRegistry().register(new ModIngot("aluminumingot", ModItems.aluminumTools));
    	  event.getRegistry().register(new ModIngot("silveringot", ModItems.silverTools));
    	  event.getRegistry().register(new ModIngot("titaniumingot", ModItems.extraTools));
    	  event.getRegistry().register(new ModIngot("platinumingot", ModItems.extraTools));

    	  event.getRegistry().register(new CopperNugget());
    	  event.getRegistry().register(new TinCan(Blocks.AIR));
    	  event.getRegistry().register(new WaterTinCan(Blocks.FLOWING_WATER));
    	  event.getRegistry().register(new LavaTinCan(Blocks.FLOWING_LAVA));
    	  event.getRegistry().register(new TinMushroomSoup(6 , "tinmushroomsoup"));
    	  event.getRegistry().register(new TinBeetrootSoup(6 , "tinbeetrootsoup"));
    	  event.getRegistry().register(new TinRabbitSoup(10 , "tinrabbitsoup"));
    	  event.getRegistry().register(new TinFish(5, 0.6F, false ));
    	  
    	  //MAGIC
    	  event.getRegistry().register(new PowerCrystal("smokeshot"));
    	  
    	  
    	  
    	  
    	  //TIN TOOLS
     	  event.getRegistry().register(new ModPickaxe("tinpickaxe", TIN, ModMath.calculateDamage(3.0, 1.25) , ModMath.calculateSpeed(1.2, 1.375), 3 , ModItems.tinTools, 0.0D, false, true, true));
    	  event.getRegistry().register(new ModSword("tinsword", TIN, ModMath.calculateDamage(5.0, 1.25) , ModMath.calculateSpeed(1.6, 1.375), 3 , ModItems.tinTools, 0.0D, false, true, true));
    	  event.getRegistry().register(new ModAxe("tinaxe", TIN, 6.0F, (float)ModMath.calculateSpeed(0.8, 1.375), 3, ModItems.tinTools, 0.0D, false));
    	  event.getRegistry().register(new ModSpade("tinspade", TIN, ModMath.calculateDamage(3.5, 1.25) , ModMath.calculateSpeed(1.0, 1.375), 3 , ModItems.tinTools, 0.0D, false, true, true));
    	  event.getRegistry().register(new ModHoe("tinhoe", TIN, ModMath.calculateSpeed(2.0, 1.375) , 3 , ModItems.tinTools, 0.0D, false, true));
    	  
    	  //ALUMINUM TOOLS
    	  event.getRegistry().register(new ModPickaxe("aluminumpickaxe", ALUMINUM, ModMath.calculateDamage(4.0, 1.25) , ModMath.calculateSpeed(1.2, 2.0), 5 , ModItems.aluminumTools, 0.0D, false, true, true)); // damage and speed: 0.77, -1.3
    	  event.getRegistry().register(new ModSword("aluminumsword", ALUMINUM, ModMath.calculateDamage(6.0, 1.25), ModMath.calculateSpeed(1.6, 2.0), 5, ModItems.aluminumTools, 0.0D, false, true, true)); //speed -0.4
    	  event.getRegistry().register(new ModAxe("aluminumaxe", ALUMINUM, 6.0F, (float)ModMath.calculateSpeed(0.9, 2.0), 5, ModItems.aluminumTools, 0.0D, false));
    	  event.getRegistry().register(new ModSpade("aluminumspade", ALUMINUM, ModMath.calculateDamage(4.5, 1.25), ModMath.calculateSpeed(1.0, 2.0) , 5, ModItems.aluminumTools, 0.0D, false, true, true)); //speed -1.75
    	  event.getRegistry().register(new ModHoe("aluminumhoe", ALUMINUM, ModMath.calculateSpeed(3.0, 2.0) , 5, ModItems.aluminumTools, 0.0D, false, true)); //NEED  TO JUST LOOK AT ALL OF THE HOE ATTACK SPEED VALUES ANYWAY LOL
    	  
    	  //OBSIDIAN TOOLS
    	  event.getRegistry().register(new ModPickaxe("obsidianpickaxe", OBSIDIAN, ModMath.calculateDamage(5.0, 1.25) , ModMath.calculateSpeed(1.2, 2.50), 1 , ModItems.extraTools, 0.0D, false, true, true));
    	  event.getRegistry().register(new ModSword("obsidiansword", OBSIDIAN, ModMath.calculateDamage(7.0, 1.25) , ModMath.calculateSpeed(1.6, 2.50), 1 , ModItems.extraTools, 0.0D, false, true, true));
    	  event.getRegistry().register(new ModAxe("obsidianaxe", OBSIDIAN, 6.0F, (float)ModMath.calculateSpeed(1.0, 2.50), 1, ModItems.extraTools, 0.0D, false));
    	  event.getRegistry().register(new ModSpade("obsidianspade", OBSIDIAN, ModMath.calculateDamage(5.5, 1.25) , ModMath.calculateSpeed(1.0, 2.50), 1 , ModItems.extraTools, 0.0D, false, true, true));
    	  event.getRegistry().register(new ModHoe("obsidianhoe", OBSIDIAN, ModMath.calculateSpeed(4, 2.50) , 1 , ModItems.extraTools, 0.0D, false, true));
    	  
    	  //TITANIUM TOOLS
     	  event.getRegistry().register(new ModPickaxe("titaniumpickaxe", TITANIUM, 0.0D , ModMath.calculateSpeed(1.2, (3.0)), 8 , ModItems.titaniumTools, 0, true, false, true));
    	  event.getRegistry().register(new ModSword("titaniumsword", TITANIUM, 0.0D , ModMath.calculateSpeed(1.6, (3.0)), 8 , ModItems.titaniumTools, 0, true, false, true));
    	  event.getRegistry().register(new ModAxe("titaniumaxe", TITANIUM, 8.0f, (float)ModMath.calculateSpeed(1.1, (3.0)) , 8, ModItems.titaniumTools, 0, true)); //SPEED FORMERLY 2.875f
    	  event.getRegistry().register(new ModSpade("titaniumspade", TITANIUM, 0.0D , ModMath.calculateSpeed(1.0, (3.0)), 8 , ModItems.titaniumTools, 0, true, false, true));
    	  event.getRegistry().register(new ModHoe("titaniumhoe", TITANIUM, ModMath.calculateSpeed(5, (3.0)) , 8 , ModItems.titaniumTools, 0, true, true));
    	  

    	  
    	  
    	  
    	  
    	  //COPPER TOOLS
    	  event.getRegistry().register(new ModPickaxe("copperpickaxe", COPPER, 0.0D , ModMath.calculateSpeed(1.2, (1/1.5)), 2 , ModItems.copperTools, 0.0D, false, false, true));
    	  event.getRegistry().register(new ModSword("coppersword", COPPER, 0.0D , ModMath.calculateSpeed(1.6, (1/1.5)), 2 , ModItems.copperTools, 0.0D, false, false, true));
    	  event.getRegistry().register(new ModAxe("copperaxe", COPPER, 10.0F, (float)ModMath.calculateSpeed(0.8, (1/1.5)), 2, ModItems.copperTools, 0.0D, false));
    	  event.getRegistry().register(new ModSpade("copperspade", COPPER, 0.0D , ModMath.calculateSpeed(1.0, (1/1.5)), 2 , ModItems.copperTools, 0.0D, false, false, true));
    	  event.getRegistry().register(new ModHoe("copperhoe", COPPER, ModMath.calculateSpeed(2, (1/1.5)) , 2 , ModItems.copperTools, 0.0D, false, true));
    	  
    	  //BRONZE TOOLS
     	  event.getRegistry().register(new ModPickaxe("bronzepickaxe", BRONZE, 0.0D , ModMath.calculateSpeed(1.2, 0.75), 4 , ModItems.bronzeTools, 0.3D, false, false, true));
    	  event.getRegistry().register(new ModSword("bronzesword", BRONZE, 0.0D , ModMath.calculateSpeed(1.6, 0.75), 4 , ModItems.bronzeTools, 0.3D, false, false, true));
    	  event.getRegistry().register(new ModAxe("bronzeaxe", BRONZE, 10.0F, (float)ModMath.calculateSpeed(0.9, 0.75), 4, ModItems.bronzeTools, 0.3D, true));
    	  event.getRegistry().register(new ModSpade("bronzespade", BRONZE, 0.0D , ModMath.calculateSpeed(1.0, 0.75), 4 , ModItems.bronzeTools, 0.3D, false, false, true));
    	  event.getRegistry().register(new ModHoe("bronzehoe", BRONZE, ModMath.calculateSpeed(3, 0.75) , 4 , ModItems.bronzeTools, 0.3D, true, true));
    	  
    	  //SILVER TOOLS
    	  event.getRegistry().register(new ModPickaxe("silverpickaxe", SILVER, 0.0D , ModMath.calculateSpeed(1.2, (1/1.2)), 6 , ModItems.silverTools, 0.4D, false, false, true));
    	  event.getRegistry().register(new ModSword("silversword", SILVER, 0.0D , ModMath.calculateSpeed(1.6, (1/1.2)), 6 , ModItems.silverTools, 0.4D, false, false, true));
    	  event.getRegistry().register(new ModAxe("silveraxe", SILVER, 10.0F, (float)ModMath.calculateSpeed(1.0, (1/1.2)), 6, ModItems.silverTools, 0.4D, false)); //-1.5F was the old speed, but it was wrong
    	  event.getRegistry().register(new ModSpade("silverspade", SILVER, 0.0D , ModMath.calculateSpeed(1.0, (1/1.2)), 6 , ModItems.silverTools, 0.4D, false, false, true));
    	  event.getRegistry().register(new ModHoe("silverhoe", SILVER , ModMath.calculateSpeed(4, (1/1.2)), 6 , ModItems.silverTools, 0.4D, false, true));
    	  
    	  //PLATINUM TOOLS
    	  event.getRegistry().register(new ModPickaxe("platinumpickaxe", PLATINUM, 0.0D , 0.0D, 9 , ModItems.platinumTools, 0.0D, true, false, false));
    	  event.getRegistry().register(new ModSword("platinumsword", PLATINUM, 0.0D , 0.0D, 9 , ModItems.platinumTools, 0.0D, true, false, false));
    	  event.getRegistry().register(new ModAxe("platinumaxe", PLATINUM, 15.0F, -2.9F, 9, ModItems.platinumTools, 0.0D, true));
    	  event.getRegistry().register(new ModSpade("platinumspade", PLATINUM, 0.0D , 0.0D, 9 , ModItems.platinumTools, 0.0D, true, false, false));
    	  event.getRegistry().register(new ModHoe("platinumhoe", PLATINUM , 0.0D, 9 , ModItems.platinumTools, 0.0D, true, false));
    	  
    	  
    	  
    	  
    	  //EMERALD TOOLS
     	  event.getRegistry().register(new ModPickaxe("emeraldpickaxe", EMERALD, 0 , 0, 5 , ModItems.emeraldTools, 0, false, false, false));
    	  event.getRegistry().register(new ModSword("emeraldsword", EMERALD, 0 , 0, 5 , ModItems.emeraldTools, 0, false, false, false));
    	  event.getRegistry().register(new ModAxe("emeraldaxe", EMERALD, 8.0f, -2.9f, 5, ModItems.emeraldTools, 0.3D, false));
    	  event.getRegistry().register(new ModSpade("emeraldspade", EMERALD, 0 , 0, 5 , ModItems.emeraldTools, 0, false, false, false));
    	  event.getRegistry().register(new ModHoe("emeraldhoe", EMERALD, 0 , 5 , ModItems.emeraldTools, 0.3D, false, false));


    	  

    	  
    	  //event.getRegistry().register(new ObsidianPickaxe("obsidianpickaxe", OBSIDIAN));
    	  //event.getRegistry().register(new CopperPickaxe("copperpickaxe", COPPER));
    	  //event.getRegistry().register(new TinPickaxe("tinpickaxe", TIN));
    	  //event.getRegistry().register(new EmeraldPickaxe("emeraldpickaxe", EMERALD));
    	  //event.getRegistry().register(new BronzePickaxe("bronzepickaxe", BRONZE));
    	  //event.getRegistry().register(new TitaniumPickaxe("titaniumpickaxe", TITANIUM));
    	  //event.getRegistry().register(new ObsidianSword("obsidiansword", OBSIDIAN));
    	  //event.getRegistry().register(new CopperSword("coppersword", COPPER));
    	 //event.getRegistry().register(new TinSword("tinsword", TIN));
    	  //event.getRegistry().register(new EmeraldSword("emeraldsword", EMERALD));
    	  //event.getRegistry().register(new BronzeSword("bronzesword", BRONZE));
    	  //event.getRegistry().register(new TitaniumSword("titaniumsword", TITANIUM));
    	  //event.getRegistry().register(new ObsidianAxe("obsidianaxe", OBSIDIAN));
    	  //event.getRegistry().register(new CopperAxe("copperaxe", COPPER));
    	  //event.getRegistry().register(new TinAxe("tinaxe", TIN));
    	  //event.getRegistry().register(new EmeraldAxe("emeraldaxe", EMERALD));
    	  //event.getRegistry().register(new BronzeAxe("bronzeaxe", BRONZE));
    	  //event.getRegistry().register(new TitaniumAxe("titaniumaxe", TITANIUM));
    	  //event.getRegistry().register(new ObsidianSpade("obsidianspade", OBSIDIAN));
    	  //event.getRegistry().register(new CopperSpade("copperspade", COPPER));
    	  //event.getRegistry().register(new TinSpade("tinspade", TIN));
    	  //event.getRegistry().register(new EmeraldSpade("emeraldspade", EMERALD));
    	 //event.getRegistry().register(new BronzeSpade("bronzespade", BRONZE));
    	  //event.getRegistry().register(new TitaniumSpade("titaniumspade", TITANIUM));
    	  //event.getRegistry().register(new ObsidianHoe("obsidianhoe", OBSIDIAN));
    	  //event.getRegistry().register(new CopperHoe("copperhoe", COPPER));
    	  //event.getRegistry().register(new TinHoe("tinhoe", TIN));
    	  //event.getRegistry().register(new EmeraldHoe("emeraldhoe", EMERALD));
    	  //event.getRegistry().register(new BronzeHoe("bronzehoe", BRONZE));
    	  //event.getRegistry().register(new TitaniumHoe("titaniumhoe", TITANIUM));
    	  event.getRegistry().register(new DeathScythe("deathscythe", DEATH, ModItems.obsidianingot));
    	  event.getRegistry().register(new ItemBlock(ModBlocks.DataBlock).setRegistryName(ModBlocks.DataBlock.getRegistryName()));
    	  event.getRegistry().register(new ItemBlock(ModBlocks.SmoothObsidian).setRegistryName(ModBlocks.SmoothObsidian.getRegistryName()));
    	  event.getRegistry().register(new ItemBlock(ModBlocks.CopperOre).setRegistryName(ModBlocks.CopperOre.getRegistryName()));
    	  event.getRegistry().register(new ItemBlock(ModBlocks.CopperBlock).setRegistryName(ModBlocks.CopperBlock.getRegistryName()));
    	  event.getRegistry().register(new ItemBlock(ModBlocks.TinOre).setRegistryName(ModBlocks.TinOre.getRegistryName()));
    	  event.getRegistry().register(new ItemBlock(ModBlocks.TitaniumOre).setRegistryName(ModBlocks.TitaniumOre.getRegistryName()));
    	  event.getRegistry().register(new ItemBlock(ModBlocks.TitaniumBlock).setRegistryName(ModBlocks.TitaniumBlock.getRegistryName()));
    	  event.getRegistry().register(new ItemBlock(ModBlocks.TinBlock).setRegistryName(ModBlocks.TinBlock.getRegistryName()));
    	  GameRegistry.registerTileEntity(DataTileEntity.class, modClass.MODID + "_datablock");
    }            


    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	 event.getRegistry().register(new FirstBlock());
    	 event.getRegistry().register(new DataBlock());
    	 event.getRegistry().register(new CopperOre());
    	 event.getRegistry().register(new TinOre());
    	 event.getRegistry().register(new TitaniumOre());
    	 event.getRegistry().register(new CopperBlock());
    	 event.getRegistry().register(new OreBlock(Material.ROCK, "tinblock", 0, 3.0F, 12.0F, ModItems.extraTools)); // this and titanium I need to make multi textured to make the shine more believable
    	 event.getRegistry().register(new OreBlock(Material.ROCK, "titaniumblock", 4, 10.0F, 100.0F, ModItems.titaniumTools));
    }
}