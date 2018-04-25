package com.benthom123.test.items;

import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAmmo extends Item {
	
	
	public boolean used = false;
	

	public ItemAmmo(String name, int stackSize) {
		setRegistryName(name);
        setUnlocalizedName(modClass.MODID + "." + name);
        this.setCreativeTab(ModItems.powerCrystal);
        this.setMaxStackSize(1);
        this.setMaxDamage(1);
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
       ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	public static void remove(int i, EntityPlayer playerIn) {
		//ItemStack ii = playerIn.inventory.removeStackFromSlot(i);
		playerIn.inventory.deleteStack(playerIn.inventory.getStackInSlot(i));
		//playerIn.replaceItemInInventory(i, new ItemStack(Items.IRON_NUGGET, 1, 0));
		//ii = null;
	}
}
