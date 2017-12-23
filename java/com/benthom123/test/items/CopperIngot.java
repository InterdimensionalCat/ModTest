package com.benthom123.test.items;

import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;
import com.benthom123.test.proxy.CommonProxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CopperIngot extends Item {

	public CopperIngot() {

		setRegistryName("copperingot");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(modClass.MODID + ".copperingot");     // Used for localization (en_US.lang)
        this.setCreativeTab(ModItems.extraTools);
    }
    @SideOnly(Side.CLIENT)
    public void initModel() {
       ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}