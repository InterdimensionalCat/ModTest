package com.benthom123.test.items;

import java.util.List;
import java.util.Random;

import com.benthom123.test.ModMath;
import com.benthom123.test.entity.EntitySmokeShot;
import com.benthom123.test.entity.EntityVoidRift;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class VoidRift extends PowerCrystal {
	
	BlockPos playerpos;
	int maxDamage;
	EntityPlayer user;

	public VoidRift(String name) {
		super(name);
		this.setMaxDamage(300);
		maxDamage = 300;
		this.isDamageable();
		this.setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		if(!playerIn.onGround) {
			worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.NEUTRAL, 3.0F, 0.8F / (SmokeShot.getItemRand().nextFloat() * 0.4F + 0.8F));
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
		}
		
		if (itemstack.getItemDamage() == 0) {
			if (!worldIn.isRemote) {
				//EntityVoidRift entitysmokeshot = new EntityVoidRift(worldIn);
				//worldIn.spawnEntity(entitysmokeshot);
				makeVoidRift(itemstack, PotionTypes.HARMING, playerIn, worldIn);
			}
			
			
			
			playerIn.addStat(StatList.getObjectUseStats(this));
			if (playerIn.experienceLevel <= 32) {
				this.setMaxDamage(300 - (int) ((199 / 30) * playerIn.experienceLevel));
			} else {
				this.setMaxDamage(300 - (int) ((199 / 30) * 32));
			}
			maxDamage = 100 - playerIn.experienceLevel;
			itemstack.damageItem(300 - (int) ((199 / 30) * playerIn.experienceLevel) - 1, playerIn);
			
			
			worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.NEUTRAL,  0.5F, itemRand.nextFloat() * 0.4F + 0.8F);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
			
/*			this.playerpos = playerIn.getPosition();
			int range = 10;
			Vec3d look = playerIn.getLookVec();
			BlockPos tPos = playerpos.add(new Vec3i(playerpos.getX() + look.x*range, playerpos.getY()+ (look.y*range), playerpos.getZ() + (look.z*range)));
			BlockPos pPos = playerpos.add(new Vec3i(playerpos.getX() - look.x*range, playerpos.getY() - (look.y*range), playerpos.getZ() - (look.z*range)));
			List<Entity> targets = playerIn.world.getEntitiesWithinAABBExcludingEntity(playerIn, new AxisAlignedBB(pPos, tPos));
			for(Entity entityIn : targets) {
			       entityIn.attackEntityFrom(DamageSource.causeIndirectMagicDamage(playerIn, entityIn), 2.0F);
			       entityIn.setFire(10);
			}
			
        	Random random = new Random();
        	int randX = random.nextInt(10);
        	int randY = random.nextInt(10);
        	int randZ = random.nextInt(10);
			
			for (int i = 0; i < 31; i++) {
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, true, ModMath.plusOrMinus(random.nextBoolean(), playerpos.getX(), randX), ModMath.plusOrMinus(random.nextBoolean(),playerpos.getY(), randY), ModMath.plusOrMinus(random.nextBoolean(), playerpos.getY(), randZ), 0.0D, 0.0D, 0.0D);
			}
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);*/
			

			
			

		} else {
			worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.NEUTRAL, 0.5F, 1.6F + (itemRand.nextFloat() - itemRand.nextFloat()) * 0.4F);
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
		}
	}
	
	private void makeVoidRift(ItemStack item, PotionType type, EntityPlayer playerIn, World worldIn)
	{
		BlockPos pos = playerIn.getPosition();
		EntityVoidRift voidrift = new EntityVoidRift(worldIn, pos.getX() , pos.getY(), pos.getZ());
	    voidrift.setOwner(playerIn);
/*	    voidrift.setRadius(3.0F);
	    voidrift.setRadiusOnUse(-0.5F);
	    voidrift.setWaitTime(10);
	    voidrift.setRadiusPerTick(-voidrift.getRadius() / (float)voidrift.getDuration());*/
	    //voidrift.setPotion(type);

/*	    for (PotionEffect potioneffect : PotionUtils.getFullEffectsFromItem(item))
	    {
	    	voidrift.addEffect(new PotionEffect(potioneffect));
	    }*/

	    worldIn.spawnEntity(voidrift);
	    //worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.AMBIENT_CAVE, SoundCategory.NEUTRAL, 0.5F, 1.6F + (itemRand.nextFloat() - itemRand.nextFloat()) * 0.4F);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if (stack.getItemDamage() < stack.getMaxDamage())
		{
			stack.setItemDamage(stack.getItemDamage() - 1);
		}
    }
}


/*private void makeAreaOfEffectCloud(ItemStack p_190542_1_, PotionType p_190542_2_)
{
    EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(this.world, this.posX, this.posY, this.posZ);
    entityareaeffectcloud.setOwner(this.getThrower());
    entityareaeffectcloud.setRadius(3.0F);
    entityareaeffectcloud.setRadiusOnUse(-0.5F);
    entityareaeffectcloud.setWaitTime(10);
    entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float)entityareaeffectcloud.getDuration());
    entityareaeffectcloud.setPotion(p_190542_2_);

    for (PotionEffect potioneffect : PotionUtils.getFullEffectsFromItem(p_190542_1_))
    {
        entityareaeffectcloud.addEffect(new PotionEffect(potioneffect));
    }

    NBTTagCompound nbttagcompound = p_190542_1_.getTagCompound();

    if (nbttagcompound != null && nbttagcompound.hasKey("CustomPotionColor", 99))
    {
        entityareaeffectcloud.setColor(nbttagcompound.getInteger("CustomPotionColor"));
    }

    this.world.spawnEntity(entityareaeffectcloud);
}*/
