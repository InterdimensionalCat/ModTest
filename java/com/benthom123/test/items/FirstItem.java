package com.benthom123.test.items;

import com.benthom123.test.modClass;
import com.benthom123.test.proxy.CommonProxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FirstItem extends Item {

    protected String name;
    
	public static final Item ObsidianIngot = null;
	public FirstItem() {

		setRegistryName("obsidianingot");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(modClass.MODID + ".ObsidianIngot");     // Used for localization (en_US.lang)
        this.setCreativeTab(CreativeTabs.MISC);
    }
    @SideOnly(Side.CLIENT)
    public void initModel() {
       ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}