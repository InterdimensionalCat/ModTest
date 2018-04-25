package com.benthom123.test.items;

import java.util.Random;

import com.benthom123.test.entity.EntitySmokeShot;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class SmokeShot extends PowerCrystal {
	
	private int maxDamage;

	public SmokeShot(String name) {
		super(name);
		this.setMaxDamage(100);
		maxDamage = 100;
		this.isDamageable();
		this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		if (itemstack.getItemDamage() == 0) {
			if (!playerIn.capabilities.isCreativeMode) {
				// itemstack.shrink(1);
			}
			worldIn.playSound((EntityPlayer) null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_CREEPER_PRIMED, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!worldIn.isRemote) {
				EntitySmokeShot entitysmokeshot = new EntitySmokeShot(worldIn, playerIn);
				entitysmokeshot.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
				worldIn.spawnEntity(entitysmokeshot);
			}
			playerIn.addStat(StatList.getObjectUseStats(this));
			if (playerIn.experienceLevel <= 32) {
				this.setMaxDamage(100 - (int) ((99 / 30) * playerIn.experienceLevel));
			} else {
				this.setMaxDamage(100 - (int) ((99 / 30) * 32));
			}
			maxDamage = 100 - playerIn.experienceLevel;
			itemstack.damageItem(100 - (int) ((99 / 30) * playerIn.experienceLevel) - 1, playerIn);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
		} else {
			worldIn.playSound((EntityPlayer) null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.NEUTRAL, 0.5F, 1.6F + (itemRand.nextFloat() - itemRand.nextFloat()) * 0.4F);

			return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
		}
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if (stack.getItemDamage() < stack.getMaxDamage())
		{
			stack.setItemDamage(stack.getItemDamage() - 1);
		}
    }
	
	public static Random getItemRand() {
		return itemRand;
	}
}
