package com.benthom123.test.items;

import com.benthom123.test.modClass;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ObsidianAxe extends ItemAxe {

	public ObsidianAxe(String registryName, ToolMaterial material) {
		super(material);
		setRegistryName(registryName);     
        setUnlocalizedName(modClass.MODID + "." + registryName);
        this.setCreativeTab(CreativeTabs.MISC);
	}
	@SideOnly(Side.CLIENT)
    public void initModel() {
       ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}