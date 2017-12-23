package com.benthom123.test.items;

import java.util.ArrayList;

import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;
import com.benthom123.test.proxy.CommonProxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModIngot extends Item {

	int index = 0;
	static ArrayList arr = new ArrayList();
	public ModIngot(String unlocalizedName, CreativeTabs tab) {

		setRegistryName(unlocalizedName);
        setUnlocalizedName(modClass.MODID + "." + unlocalizedName);
        this.setCreativeTab(tab);
        this.index = index++;
        arr.add(this);
        if(arr.size() == 4) {
        	arr.add(Items.EMERALD);
        }
    }
	
	public static Object getRepairItem(int index) {
		return arr.get(index);
	}
	
    @SideOnly(Side.CLIENT)
    public void initModel() {
       ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}