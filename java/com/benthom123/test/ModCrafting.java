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
	}
	public static void registerSmelting()
	{
    GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(ModItems.ObsidianIngot, 2), 10);
	}
}
