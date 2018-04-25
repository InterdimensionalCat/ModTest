package com.benthom123.test.items;

import java.util.ArrayList;

import com.benthom123.test.ModItems;
import com.benthom123.test.ModMath;
import com.benthom123.test.modClass;
import com.benthom123.test.proxy.CommonProxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModAxe extends ItemAxe {

	public int repairItem;
	public double kickbackModifier;
	public boolean customKnockback;
	
	public ModAxe(String registryName, ToolMaterial material, float attackDamage, float attackSpeed, int repairIndex, CreativeTabs tab, double kickback, boolean customKnockback) {
		super(material, attackDamage, attackSpeed);
		this.repairItem = repairIndex;
		setRegistryName(registryName);     
        setUnlocalizedName(modClass.MODID + "." + registryName);
        this.setCreativeTab(tab);
        this.kickbackModifier = kickback;
        this.customKnockback = customKnockback;
	}	
	
/*    public Item getRepairItem(int index) {
    	switch (index) {
    	case 1:
    	    return ModItems.obsidianingot; 
    	case 2:
    		return ModItems.copperingot;
    	case 3:
    		return ModItems.tiningot;
    	case 4:
    		return ModItems.bronzeingot;
    	case 5:
    		return ModItems.titaniumingot;
    	case 6:
    		return ModItems.aluminumingot;
    	case 7:
    		return ModItems.silveringot;
    	case 8:
    		return ModItems.tiningot;
        default:
    		return Items.STICK;
    	}
    }*/

    	
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
       ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	 @Override
	    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
	        return repair.getItem() == ModIngot.getRepairItem(this.repairItem - 1)  ? true : super.getIsRepairable(toRepair, repair);
	    }
	 
	 @Override
	 public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase wielder){
	     
	     // Adds velocity to the target
	     if ((!customKnockback)&&(kickbackModifier != 0.0D)) {
			// Gets a vector of length 1 in the direction the player holding this item is looking
			Vec3d look = wielder.getLookVec().normalize();
			// Play around with this value until you get the amount of knockback you want
			double knockback = this.kickbackModifier;
			target.addVelocity(look.x * knockback, look.y * knockback, look.z * knockback);
		} else {
			double knockback = 0.0D;
			if (customKnockback&&(this.toolMaterial == CommonProxy.TITANIUM)) {
			     Vec3d look = wielder.getLookVec().normalize();
			     if (look.y < 0) {
			         target.addVelocity(look.x*knockback, look.y*(-0.4), look.z*knockback);
			     } else {
			    	 target.addVelocity(look.x*knockback, look.y*(0.4), look.z*knockback);
			     }
			} else {
				if (customKnockback&&(this.toolMaterial == CommonProxy.PLATINUM)) {
				     Vec3d look = wielder.getLookVec().normalize();
				     if (look.y < 0) {
				          target.addVelocity(look.x*(2.0), look.y*(30.0), look.z*(2.0));
				     } else {
				          target.addVelocity(look.x*(2.0), look.y*(-30.0), look.z*(2.0));
				     }
				}
		    }
		}
		stack.damageItem(2, wielder);

	     return true;
	 }
	 
}