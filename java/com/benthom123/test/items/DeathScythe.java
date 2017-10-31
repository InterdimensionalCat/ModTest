package com.benthom123.test.items;

import java.util.Collections;
import java.util.Set;

import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DeathScythe extends ItemTool {
	 
    public Item repairItem;
    public static float attack_speed = -3.8F;
    public static float base_damage = 200.0F;
 
    public DeathScythe(String registryName, ToolMaterial material, Item repairItem) {
        super(base_damage, attack_speed, material, Collections.emptySet());
        this.setHarvestLevel("axe", material.getHarvestLevel());
        this.repairItem = repairItem;
		setRegistryName(registryName);     
        setUnlocalizedName(modClass.MODID + "." + registryName);
        this.setCreativeTab(ModItems.extraTools);  
    }
    
    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Block block = state.getBlock();

        if (block == Blocks.WEB)
        {
            return 15.0F;
        }
        else
        {
            Material material = state.getMaterial();
            return material != Material.PLANTS && material != Material.VINE && material != Material.CORAL && material != Material.LEAVES && material != Material.GOURD ? 1.0F : 1.5F;
        }
    }
    
    @Override
    public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
        if (!(state.getMaterial() == Material.AIR) && !(state.getMaterial() == Material.BARRIER)) {
            return true;
        } else {
            return false;
        }
    }
    
 
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == ModItems.ObsidianIngot ? true : super.getIsRepairable(toRepair, repair);
    }
 
    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) {
        // Only take one damage like a sword instead of 2
        itemStack.damageItem(1, attacker);
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void initModel() {
       ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
 
}