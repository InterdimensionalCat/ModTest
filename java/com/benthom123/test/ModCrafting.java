package com.benthom123.test;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {
	public static void registerCrafting()
	{
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:obsidianpickaxe"), new ResourceLocation("btm:obsidianingot"), new ItemStack(ModItems.obsidianpickaxe), new Object[] {"XXX"," I "," I ", 'X', ModItems.ObsidianIngot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:obsidiansword"), new ResourceLocation("btm:obsidianingot"), new ItemStack(ModItems.obsidiansword), new Object[] {" X "," X "," I ", 'X', ModItems.ObsidianIngot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:obsidianaxe"), new ResourceLocation("btm:obsidianingot"), new ItemStack(ModItems.obsidianaxe), new Object[] {" XX"," IX"," I ", 'X', ModItems.ObsidianIngot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:obsidianspade"), new ResourceLocation("btm:obsidianingot"), new ItemStack(ModItems.obsidianspade), new Object[] {" X "," I "," I ", 'X', ModItems.ObsidianIngot, 'I', Items.STICK});
	GameRegistry.addShapedRecipe(new ResourceLocation("btm:obsidianhoe"), new ResourceLocation("btm:obsidianingot"), new ItemStack(ModItems.obsidianhoe), new Object[] {" XX"," I "," I ", 'X', ModItems.ObsidianIngot, 'I', Items.STICK});
	}
	public static void registerSmelting()
	{
    GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(ModItems.ObsidianIngot, 2), 100);
    GameRegistry.addSmelting(ModBlocks.CopperOre, new ItemStack(ModItems.copperingot, 1), 10);
	}
}
