package com.benthom123.test;

import java.util.HashMap;

import java.util.ArrayList;
import com.benthom123.test.items.ModIngot;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ModMath {

    public static double calculateDamage(double baseDamage, double ratio) { // you need to do 1/ratio if it is modified/original, as the formula was constructed to work with original/modified
    	double damage = (baseDamage / ratio) - 1;
    	return damage;  	
    }
    
    public static double calculateSpeed(double baseSpeed, double ratio) { // you need to do 1/ratio if it is original/modified, as the formula was constructed to work with modified/original
    	double speedinital = (ratio * baseSpeed);
    	double speed = -1*(4 - speedinital);
    	return speed;
    }
    
    public static double plusOrMinus(boolean sign, double x, double y) {
    	if (sign) {
    		return x + y;
    	} else {
    		return x - y;
    	}
    }
	
/*    public ModIngot getHashRepair(int index) {
    HashMap<Integer, ModIngot> repairItem = new HashMap<Integer, ModIngot>();
    repairItem.put(1, ModItems.obsidianingot);
    repairItem.put(2, ModItems.copperingot);
    repairItem.put(3, ModItems.tiningot);
    repairItem.put(4, ModItems.bronzeingot);
    repairItem.put(5, ModItems.obsidianingot);
    repairItem.put(6, ModItems.obsidianingot);
    repairItem.put(7, ModItems.obsidianingot);
    repairItem.put(8, ModItems.obsidianingot);
    return repairItem.get(2);
    }*/
    
    
   /* public Item getRepairItem(int index) {
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
    
}
