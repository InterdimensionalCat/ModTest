package com.benthom123.test.items;

import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.benthom123.test.items.ItemAmmo;

public abstract class ItemGun extends Item {

	protected int clipSize;
	protected int currentClip;
	protected int maxDamage;
	protected boolean reloading;
	protected ItemStack ammo;
	protected final int fireRate;
	protected int fireCD;
	
	public ItemGun(String name, int clipSize, int reloadTime, ItemAmmo ammo, int fireRate) {
		setRegistryName(name);
        setUnlocalizedName(modClass.MODID + "." + name);
        this.setCreativeTab(ModItems.powerCrystal);
        this.currentClip = 0;
        this.clipSize = clipSize;
        
        this.setMaxDamage(reloadTime + 1);
		maxDamage = reloadTime;
		this.isDamageable();
		this.setMaxStackSize(1);
		
		this.ammo = new ItemStack(ammo, 1, 0);
		this.fireRate = fireRate;
		fireCD = 0;
    }
	
    public abstract void shoot(World worldIn, EntityPlayer playerIn, EnumHand handIn);
	
    @SideOnly(Side.CLIENT)
    public void initModel() {
       ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
    
    /**
     * Called when the equipped item is right clicked.
     */
    
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
    	ItemStack itemstack = playerIn.getHeldItem(handIn);
    	if (!reloading&&fireCD == 0) {
			if(currentClip > 0) {
				shoot(worldIn, playerIn, handIn);
				if(!worldIn.isRemote) {
					currentClip--;
					System.out.println(currentClip);
					fireCD = fireRate;
				}
				playerIn.addStat(StatList.getObjectUseStats(this));
				//itemstack.setItemDamage(itemstack.getItemDamage() - (maxDamage*(clipSize - currentClip) / clipSize));
				itemstack.damageItem(maxDamage / clipSize, playerIn);
				System.out.println(itemstack.getItemDamage());
				return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
			} else {
				if(playerIn.inventory.hasItemStack(new ItemStack(ModItems.tttremington))) {
					reloading = true;
					//itemstack.setItemDamage(maxDamage);
					currentClip = clipSize;
						//playerIn.inventory.getStackInSlot(playerIn.inventory.getSlotFor(new ItemStack(ammo, 1))).shrink(1);
						for (int i = 0; i < playerIn.inventory.getSizeInventory(); i++) {
							if (playerIn.inventory.getStackInSlot(i).isItemEqual(new ItemStack(ModItems.tttremington))) {
								//ItemAmmo.remove(i, playerIn);
								//playerIn.inventory.deleteStack(playerIn.inventory.getStackInSlot(i));
								//playerIn.inventory.getStackInSlot(i).damageItem(1, playerIn);
								///playerIn.inventory.setInventorySlotContents(i, playerIn.inventory.getStackInSlot(i));
								ItemStack is = playerIn.inventory.getStackInSlot(i);
			                    if (!playerIn.capabilities.isCreativeMode)
			                    {
			                    	is.shrink(1);

			                        if (is.isEmpty())
			                        {
			                        	playerIn.inventory.deleteStack(is);
			                        }
			                    }

								break;
							}
						} 
	               playerIn.addStat(StatList.getObjectUseStats(this));
				}
			}
		}
    	
    	 return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
    }
    
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (reloading) {
			if (stack.getItemDamage() > 0) {
				stack.setItemDamage(stack.getItemDamage() - 1);
				System.out.println(stack.getItemDamage());
			} else {
				reloading = false;
			}
		}
		
		if(fireCD > 0) {
			fireCD--;
		}
    }
}
