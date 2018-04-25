package com.benthom123.test.items;

import com.benthom123.test.ModItems;
import com.benthom123.test.entity.EntitySmokeShot;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ArmaLite15 extends ItemGun {

	public boolean firstTick = true;
	
	public ArmaLite15(String name) {
		super(name, 25, 100, ModItems.tttremington, 1);
		
	}

	@Override
	public void shoot(World worldIn, EntityPlayer playerIn, EnumHand handIn) {		
		if (!worldIn.isRemote) {
			
			EntitySmokeShot entitysmokeshot = new EntitySmokeShot(worldIn, playerIn);
			entitysmokeshot.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 10.0F);
			worldIn.spawnEntity(entitysmokeshot);
			worldIn.playSound((EntityPlayer) null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		}
		
		playerIn.rotationYaw += this.itemRand.nextGaussian()*1.5/**Math.signum(this.itemRand.nextDouble() - 0.5)*/;
		playerIn.rotationPitch -= Math.abs(this.itemRand.nextGaussian()*3.0);
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(firstTick) {
			ammo = new ItemStack(ModItems.tttremington, 1, 0);
			firstTick = false;
		}
		
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
}
