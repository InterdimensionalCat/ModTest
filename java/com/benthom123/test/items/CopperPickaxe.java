package com.benthom123.test.items;

import java.util.Collections;

import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CopperPickaxe extends ItemTool {
	
	public Item repairItem;
	public static float attack_speed = -2.35F;
	public static float attack_damage = 1.0F;

	public CopperPickaxe(String registryName, ToolMaterial material) {
        super(attack_damage, attack_speed, material, Collections.emptySet());
		this.repairItem = ModItems.copperingot;
        this.setHarvestLevel("pickaxe", material.getHarvestLevel());
		setRegistryName(registryName);     
        setUnlocalizedName(modClass.MODID + "." + registryName);
        this.setCreativeTab(ModItems.extraTools);   
	}
	
    @Override
    public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
        if (!(state.getMaterial() == Material.AIR) && !(state.getMaterial() == Material.BARRIER)) {
            return true;
        } else {
            return false;
        }
    }
    
	@SideOnly(Side.CLIENT)
    public void initModel() {
       ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
	
	 @Override
	    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
	        return repair.getItem() == ModItems.copperingot ? true : super.getIsRepairable(toRepair, repair);
	    }
}
