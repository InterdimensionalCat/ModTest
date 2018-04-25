package com.benthom123.test;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {
	public static void registerCrafting()
	{
/*	GameRegistry.addShapedRecipe(new ResourceLocation("btm:obsidianpickaxe"), new ResourceLocation("btm:obsidianingot"), new ItemStack(ModItems.obsidianpickaxe), new Object[] {"XXX"," I "," I ", 'X', ModItems.obsidianingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:obsidiansword"), new ResourceLocation("btm:obsidianingot"), new ItemStack(ModItems.obsidiansword), new Object[] {" X "," X "," I ", 'X', ModItems.obsidianingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:obsidianaxe"), new ResourceLocation("btm:obsidianingot"), new ItemStack(ModItems.obsidianaxe), new Object[] {" XX"," IX"," I ", 'X', ModItems.obsidianingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:obsidianspade"), new ResourceLocation("btm:obsidianingot"), new ItemStack(ModItems.obsidianspade), new Object[] {" X "," I "," I ", 'X', ModItems.obsidianingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:obsidianhoe"), new ResourceLocation("btm:obsidianingot"), new ItemStack(ModItems.obsidianhoe), new Object[] {" XX"," I "," I ", 'X', ModItems.obsidianingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:copperingot"), new ResourceLocation("btm:coppernugget"), new ItemStack(ModItems.copperingot, 2), new Object[] {"XXX","XXX","XXX", 'X', ModItems.coppernugget,});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:copperblock"), new ResourceLocation("btm:copperingot"), new ItemStack(ModBlocks.CopperBlock, 2), new Object[] {"XXX","XXX","XXX", 'X', ModItems.copperingot,});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:copperpickaxe"), new ResourceLocation("btm:copperingot"), new ItemStack(ModItems.copperpickaxe), new Object[] {"XXX"," I "," I ", 'X', ModItems.copperingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:coppersword"), new ResourceLocation("btm:copperingot"), new ItemStack(ModItems.coppersword), new Object[] {" X "," X "," I ", 'X', ModItems.copperingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:copperhoe"), new ResourceLocation("btm:copperingot"), new ItemStack(ModItems.copperhoe), new Object[] {" XX"," I "," I ", 'X', ModItems.copperingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:copperspade"), new ResourceLocation("btm:copperingot"), new ItemStack(ModItems.copperspade), new Object[] {" X "," I "," I ", 'X', ModItems.copperingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:copperaxe"), new ResourceLocation("btm:copperingot"), new ItemStack(ModItems.copperaxe), new Object[] {" XX"," IX"," I ", 'X', ModItems.copperingot, 'I', Items.STICK}); 
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:tinpickaxe"), new ResourceLocation("btm:tiningot"), new ItemStack(ModItems.tinpickaxe), new Object[] {"XXX"," I "," I ", 'X', ModItems.tiningot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:tinsword"), new ResourceLocation("btm:tiningot"), new ItemStack(ModItems.tinsword), new Object[] {" X "," X "," I ", 'X', ModItems.tiningot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:tinhoe"), new ResourceLocation("btm:tiningot"), new ItemStack(ModItems.tinhoe), new Object[] {" XX"," I "," I ", 'X', ModItems.tiningot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:tinspade"), new ResourceLocation("btm:tiningot"), new ItemStack(ModItems.tinspade), new Object[] {" X "," I "," I ", 'X', ModItems.tiningot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:tinaxe"), new ResourceLocation("btm:tiningot"), new ItemStack(ModItems.tinaxe), new Object[] {" XX"," IX"," I ", 'X', ModItems.tiningot, 'I', Items.STICK}); */
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:tincan"), new ResourceLocation("btm:tiningot"), new ItemStack(ModItems.tincan), new Object[] {"   ","X X"," X ", 'X', ModItems.tiningot});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:tinmushroomsoup"), new ResourceLocation("btm:tincan"), new ItemStack(ModItems.tinmushroomsoup), new Object[] {"XI "," V ","   ", 'X', Blocks.BROWN_MUSHROOM, 'I', Blocks.RED_MUSHROOM, 'V', ModItems.tincan});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:tinbeetrootsoup"), new ResourceLocation("btm:tincan"), new ItemStack(ModItems.tinbeetrootsoup), new Object[] {"XXX","XXX"," V ", 'X', Items.BEETROOT, 'V', ModItems.tincan});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:tinrabbitsoup"), new ResourceLocation("btm:tincan"), new ItemStack(ModItems.tinrabbitsoup), new Object[] {" X ","IVL"," C ", 'X', Items.COOKED_RABBIT, 'I', Items.CARROT, 'V', Items.BAKED_POTATO, 'L', Blocks.BROWN_MUSHROOM, 'C', ModItems.tincan});
/*	GameRegistry.addShapedRecipe(new ResourceLocation("btm:emeraldpickaxe"), new ResourceLocation("btm:emeraldpickaxe"), new ItemStack(ModItems.emeraldpickaxe), new Object[] {"XXX"," I "," I ", 'X', Items.EMERALD, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:emeraldsword"), new ResourceLocation("btm:emeraldsword"), new ItemStack(ModItems.emeraldsword), new Object[] {" X "," X "," I ", 'X', Items.EMERALD, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:emeraldspade"), new ResourceLocation("btm:emeraldspade"), new ItemStack(ModItems.emeraldspade), new Object[] {" X "," I "," I ", 'X', Items.EMERALD, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:emeraldhoe"), new ResourceLocation("btm:emeraldhoe"), new ItemStack(ModItems.emeraldhoe), new Object[] {" XX"," I "," I ", 'X', Items.EMERALD, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:emeraldaxe"), new ResourceLocation("btm:emeraldaxe"), new ItemStack(ModItems.emeraldaxe), new Object[] {" XX"," IX"," I ", 'X', Items.EMERALD, 'I', Items.STICK});*/
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:bronzeingot"), new ResourceLocation("btm:bronzeingot"), new ItemStack(ModItems.bronzeingot), new Object[] {"XXX","XIX","XXX", 'X', ModItems.coppernugget, 'I', ModItems.tiningot});
/*	GameRegistry.addShapedRecipe(new ResourceLocation("btm:bronzepickaxe"), new ResourceLocation("btm:bronzepickaxe"), new ItemStack(ModItems.bronzepickaxe), new Object[] {"XXX"," I "," I ", 'X', ModItems.bronzeingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:bronzesword"), new ResourceLocation("btm:bronzesword"), new ItemStack(ModItems.bronzesword), new Object[] {" X "," X "," I ", 'X', ModItems.bronzeingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:bronzeaxe"), new ResourceLocation("btm:bronzeaxe"), new ItemStack(ModItems.bronzeaxe), new Object[] {" XX"," IX"," I ", 'X', ModItems.bronzeingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:bronzespade"), new ResourceLocation("btm:bronzespade"), new ItemStack(ModItems.bronzespade), new Object[] {" X "," I "," I ", 'X', ModItems.bronzeingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:bronzehoe"), new ResourceLocation("btm:bronzehoe"), new ItemStack(ModItems.bronzehoe), new Object[] {" XX"," I "," I ", 'X', ModItems.bronzeingot, 'I', Items.STICK});*/
/*	GameRegistry.addShapedRecipe(new ResourceLocation("btm:titaniumpickaxe"), new ResourceLocation("btm:titaniumpickaxe"), new ItemStack(ModItems.titaniumpickaxe), new Object[] {"XXX"," I "," I ", 'X', ModItems.titaniumingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:titaniumsword"), new ResourceLocation("btm:titaniumsword"), new ItemStack(ModItems.titaniumsword), new Object[] {" X "," X "," I ", 'X', ModItems.titaniumingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:titaniumaxe"), new ResourceLocation("btm:titaniumaxe"), new ItemStack(ModItems.titaniumaxe), new Object[] {" XX"," IX"," I ", 'X', ModItems.titaniumingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:titaniumspade"), new ResourceLocation("btm:titaniumspade"), new ItemStack(ModItems.titaniumspade), new Object[] {" X "," I "," I ", 'X', ModItems.titaniumingot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:titaniumhoe"), new ResourceLocation("btm:titaniumhoe"), new ItemStack(ModItems.titaniumhoe), new Object[] {" XX"," I "," I ", 'X', ModItems.titaniumingot, 'I', Items.STICK});*/
	
	
	}
	public static void registerToolCrafting(String materialName, Item pickaxe, Item sword, Item axe, Item spade, Item hoe, Item material) {
		GameRegistry.addShapedRecipe(new ResourceLocation("btm:" + materialName + "pickaxe"), new ResourceLocation("btm:" + materialName + "pickaxe"), new ItemStack(pickaxe), new Object[] {"XXX"," I "," I ", 'X', material, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("btm:" + materialName + "sword"), new ResourceLocation("btm:" + materialName + "sword"), new ItemStack(sword), new Object[] {" X "," X "," I ", 'X', material, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("btm:" + materialName + "axe"), new ResourceLocation("btm:" + materialName + "axe"), new ItemStack(axe), new Object[] {" XX"," IX"," I ", 'X', material, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("btm:" + materialName + "spade"), new ResourceLocation("btm:" + materialName + "spade"), new ItemStack(spade), new Object[] {" X "," I "," I ", 'X', material, 'I', Items.STICK});
		GameRegistry.addShapedRecipe(new ResourceLocation("btm:" + materialName + "hoe"), new ResourceLocation("btm:" + materialName + "hoe"), new ItemStack(hoe), new Object[] {" XX"," I "," I ", 'X', material, 'I', Items.STICK});
		
	}
	
	public static void registerSmelting()
	{
    GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(ModItems.obsidianingot, 2), 100);
    GameRegistry.addSmelting(ModBlocks.TinOre, new ItemStack(ModItems.tiningot, 3), 10); //requiring smelting might be too much of a cost for something that is intended to be on the level of stone.
	}
}
