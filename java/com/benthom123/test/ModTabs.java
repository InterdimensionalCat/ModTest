package com.benthom123.test;

import net.minecraft.creativetab.CreativeTabs;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ModTabs extends CreativeTabs {

public ModTabs(int par1, String par2Str) {
super(par1, par2Str);

}

@Override
@SideOnly(Side.CLIENT)
public ItemStack getTabIconItem(){
// Here you make the Icon of the creative Tab
return new ItemStack(ModItems.ObsidianIngot, 1, 0);
}
public String getTranslatedTabLabel(){
// Here the Name
return "Extra Tools";
}

}



