package com.benthom123.test.items;

import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;
import com.benthom123.test.proxy.CommonProxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TinBeetrootSoup extends ItemSoup {

	public TinBeetrootSoup(int healAmount, String unlocalizedName) {

		super(healAmount);
		setRegistryName(unlocalizedName);        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(modClass.MODID + "." + unlocalizedName);     // Used for localization (en_US.lang)
        this.setCreativeTab(ModItems.extraTools);
    }
    @SideOnly(Side.CLIENT)
    public void initModel() {
       ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
    
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        return new ItemStack(ModItems.tincan);
    }
    
}