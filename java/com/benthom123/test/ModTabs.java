package com.benthom123.test;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ModTabs extends CreativeTabs {
	
	public int icon;
	public String name;

    public ModTabs(int index, String label, int icon) {
    super(index, label);
    this.icon = icon;
    this.name = label;

    }

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() {
		// Here you make the Icon of the creative Tab
		switch (icon) {
		case 1:
			return new ItemStack(ModItems.obsidianingot, 1, 0);
		case 2:
			return new ItemStack(ModItems.titaniumingot, 1, 0);
		case 3:
			return new ItemStack(ModItems.aluminumingot, 1, 0);
		case 4:
			return new ItemStack(ModItems.silveringot, 1, 0);
		case 5:
			return new ItemStack(ModItems.copperingot, 1, 0);
		case 6:
			return new ItemStack(ModItems.tiningot, 1, 0);
		case 7:
			return new ItemStack(ModItems.bronzeingot, 1, 0);
		case 8:
			return new ItemStack(Items.EMERALD, 1, 0);
		case 9:
			return new ItemStack(ModItems.platinumingot, 1, 0);
	    default:
	    	return new ItemStack(Items.STICK, 1, 0);
			
    	}
    }
    public String getTranslatedTabLabel(){
    // Here the Name
    return name;
    }
	
}



