package com.benthom123.test.items;

import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TinAxe extends ItemAxe {

	public Item repairItem;
	
	public TinAxe(String registryName, ToolMaterial material) {
		super(material, 6.2f, -2.9f);
		this.repairItem = ModItems.tiningot;
		setRegistryName(registryName);     
        setUnlocalizedName(modClass.MODID + "." + registryName);
        this.setCreativeTab(ModItems.extraTools);
	}
	@SideOnly(Side.CLIENT)
    public void initModel() {
       ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	 @Override
	    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
	        return repair.getItem() == ModItems.tiningot ? true : super.getIsRepairable(toRepair, repair);
	    }
}