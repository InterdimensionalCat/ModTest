package com.benthom123.test.items;

import java.util.Random;

import com.benthom123.test.entity.EntityGlacialSpear;
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

public class GlacialSpear extends PowerCrystal {
	
	private int maxDamage;
	private EntityGlacialSpear entity;
	EntityPlayer user;

	public GlacialSpear(String name) {
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
			worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.NEUTRAL, 3.0F, 0.8F / (SmokeShot.getItemRand().nextFloat() * 0.4F + 0.8F));
			if (!worldIn.isRemote) {
				EntityGlacialSpear entityglacialspear = new EntityGlacialSpear(worldIn, playerIn);
				this.entity = entityglacialspear;
				Entity p1 = (Entity) user;
/*				if (user != null) {
				entityglacialspear.setOwner(user);
				}*/
				entityglacialspear.shoot(p1, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.5F, 1.0F);
				worldIn.spawnEntity(entityglacialspear);
			}
			
			if(worldIn.isRemote) {
				user = playerIn;
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
