package com.benthom123.test.items;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;
import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
public class TinHoe extends ItemHoe {
	
	public Item repairItem;

	public TinHoe(String registryName, ToolMaterial material) {
        super(material);
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
	 
	 @Override
	    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slotIn, ItemStack stack)
	    {
	        final Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slotIn, stack);
	 
	        if (slotIn == EntityEquipmentSlot.MAINHAND) 
	      	{
	            replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_SPEED /* or whatever attribute you want to modify */, ATTACK_SPEED_MODIFIER, (double)(0.625));
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
	            modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), modifier.getAmount() * multiplier, modifier.getOperation())); // Might wanna change the formula a bit because it's funky...
	        }
	    }
}

	 
