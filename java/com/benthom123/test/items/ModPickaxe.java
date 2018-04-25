package com.benthom123.test.items;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;
import com.benthom123.test.proxy.CommonProxy;
import com.google.common.collect.Multimap;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.math.Vec3d;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModPickaxe extends ItemPickaxe {
	
	public int repairItem;
	public double kickbackModifier;
	public boolean customKnockback;
	public boolean customDamage;
	public boolean customSpeed;
	public double damage;
	public double speed;

	public ModPickaxe(String registryName, ToolMaterial material, double attackDamage, double attackSpeed, int repairIndex, CreativeTabs tab, double kickback, boolean customKnockback, boolean damage, boolean speed) {
		super(material);
		this.repairItem = repairIndex;
		setRegistryName(registryName);     
        setUnlocalizedName(modClass.MODID + "." + registryName);
        this.setCreativeTab(tab);
        this.kickbackModifier = kickback;
        this.customKnockback = customKnockback;
        this.customSpeed = speed;
        this.customDamage = damage;
        this.damage = attackDamage;
        this.speed = attackSpeed;
	}
    
	@SideOnly(Side.CLIENT)
    public void initModel() {
       ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	 @Override
	    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
	        return repair.getItem() == ModIngot.getRepairItem(this.repairItem - 1) ? true : super.getIsRepairable(toRepair, repair);
	    }
	 
	 @Override
	    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slotIn, ItemStack stack)
	    {
	        final Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slotIn, stack);
	 
	        if (slotIn == EntityEquipmentSlot.MAINHAND) 
	      	{
	        	if (customSpeed) {
	            replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_SPEED /* or whatever attribute you want to modify */, ATTACK_SPEED_MODIFIER, (double)(this.speed));
	        	}
	        	if (customDamage) {
	            replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_DAMAGE /* or whatever attribute you want to modify */, ATTACK_DAMAGE_MODIFIER, (double)(this.damage));
	        	}
	             
	        }
	      
	        return modifiers;
	    }

	    private void replaceModifier(Multimap<String, AttributeModifier> modifierMultimap, IAttribute attribute, UUID id, double multiplier)
	    {
	        // Get the modifiers for the specified attribute
	        final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute.getName());

	        // Find the modifier with the specified ID, if any
	        final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(attributeModifier -> attributeModifier.getID().equals(id)).findFirst();
	 
	        if (modifierOptional.isPresent()) 
	      	{
	            final AttributeModifier modifier = modifierOptional.get();
	      
	            modifiers.remove(modifier); // Remove it
	            modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), multiplier, modifier.getOperation())); // Might wanna change the formula a bit because it's funky...
	        }
	    }
	    
		 @Override
		 public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase wielder) {
			 
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

