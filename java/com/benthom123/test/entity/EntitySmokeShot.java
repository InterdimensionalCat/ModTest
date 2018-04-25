package com.benthom123.test.entity;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Nullable;

import com.benthom123.test.ModMath;
import com.benthom123.test.items.SmokeShot;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySmokeShot extends EntityThrowable
{
	
    private int xTile;
    private int yTile;
    private int zTile;
    private Block inTile;
    protected boolean inGround;
    public int throwableShake;
    /** The entity that threw this throwable item. */
    protected EntityLivingBase thrower;
    private String throwerName;
    private int ticksInGround;
    private int ticksInAir;
    public Entity ignoreEntity;
    private int ignoreTime;
    private int minus;
    boolean wasHit = false;
	
	public static ResourceLocation smokeshot = new ResourceLocation("btm:smokeshot");
    public EntitySmokeShot(World worldIn)
    {
        super(worldIn);
        this.minus = 0;
        this.setNoGravity(true);
    }

    public EntitySmokeShot(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
        this.thrower = throwerIn;
        this.minus = 0;
        this.setNoGravity(true);
    }

    public EntitySmokeShot(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
        this.minus = 0;
        this.setNoGravity(true);
    }
    
    
    
    
    
    /**
     * Sets throwable heading based on an entity that's throwing it
     */
    public void shoot(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float velocity, float inaccuracy)
    {
        float f = -MathHelper.sin(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
        float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * 0.017453292F);
        float f2 = MathHelper.cos(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
        this.shoot((double)f, (double)f1, (double)f2, velocity, inaccuracy);
        this.motionX += entityThrower.motionX;
        this.motionZ += entityThrower.motionZ;

        if (!entityThrower.onGround)
        {
            this.motionY += entityThrower.motionY;
        }
    }

    /**
     * Similar to setArrowHeading, it's point the throwable entity to a x, y, z direction.
     */
    public void shoot(double x, double y, double z, float velocity, float inaccuracy)
    {
        float f = MathHelper.sqrt(x * x + y * y + z * z);
        x = x / (double)f;
        y = y / (double)f;
        z = z / (double)f;
        x = x + this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
        y = y + this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
        z = z + this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
        x = x * (double)velocity;
        y = y * (double)velocity;
        z = z * (double)velocity;
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
        float f1 = MathHelper.sqrt(x * x + z * z);
        this.rotationYaw = (float)(MathHelper.atan2(x, z) * (180D / Math.PI));
        this.rotationPitch = (float)(MathHelper.atan2(y, (double)f1) * (180D / Math.PI));
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
        this.ticksInGround = 0;
    }
    
    
    
    
    

    public static void registerFixesSmokeShot(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "SmokeShot");
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            for (int i = 0; i < 8; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
                this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            int i = 2;

            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
            this.world.playSound((EntityPlayer)null, result.entityHit.posX, result.entityHit.posY, result.entityHit.posZ, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.NEUTRAL, 3.0F, 0.4F / (SmokeShot.getItemRand().nextFloat() * 0.4F + 0.8F));
            this.wasHit = true;
			if (this.ticksExisted > 10 && !this.world.isRemote) {
				result.entityHit.setFire(10);
			} else {
				if (!this.world.isRemote) {
					result.entityHit.setFire(2);
				}
			}
        }

        if (!this.world.isRemote)
        {
            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
        
    }
    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
    @Override
    protected float getGravityVelocity()
    {
        return 0.0F;
    }
    
    
    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderDist(double distance)
    {
    	return true;
    }

    
    public void onUpdate()
    {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();
    

        

        if (this.throwableShake > 0)
        {
            --this.throwableShake;
        }

        if (this.inGround)
        {
            if (this.world.getBlockState(new BlockPos(this.xTile, this.yTile, this.zTile)).getBlock() == this.inTile)
            {
                ++this.ticksInGround;

                if (this.ticksInGround == 1200)
                {
                    this.setDead();
                }

                return;
            }

            this.inGround = false;
            this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
            this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
            this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
            this.ticksInGround = 0;
            this.ticksInAir = 0;
        }
        else
        {
            ++this.ticksInAir;
        }

        Vec3d vec3d = new Vec3d(this.posX, this.posY, this.posZ);
        Vec3d vec3d1 = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        RayTraceResult raytraceresult = this.world.rayTraceBlocks(vec3d, vec3d1);
        vec3d = new Vec3d(this.posX, this.posY, this.posZ);
        vec3d1 = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

        if ((raytraceresult != null) && (raytraceresult.entityHit != this.thrower))
        {
            vec3d1 = new Vec3d(raytraceresult.hitVec.x, raytraceresult.hitVec.y, raytraceresult.hitVec.z);
        }

        Entity entity = null;
        List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(this.motionX, this.motionY, this.motionZ).grow(1.0D));
        double d0 = 0.0D;
        boolean flag = false;

        for (int i = 0; i < list.size(); ++i)
        {
            Entity entity1 = list.get(i);

            if (entity1 != this.thrower) {
				if (entity1.canBeCollidedWith()) {
					if (entity1 == this.ignoreEntity) {
						flag = true;
					} else if (this.thrower != null && this.ticksExisted < 2 && this.ignoreEntity == null) {
						this.ignoreEntity = entity1;
						flag = true;
					} else {
						flag = false;
						AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow(0.30000001192092896D);
						RayTraceResult raytraceresult1 = axisalignedbb.calculateIntercept(vec3d, vec3d1);

						if (raytraceresult1 != null) {
							double d1 = vec3d.squareDistanceTo(raytraceresult1.hitVec);

							if (d1 < d0 || d0 == 0.0D) {
								entity = entity1;
								d0 = d1;
							}
						}
					}
				}
			}  else {
				this.ignoreEntity = this.thrower;
			}
        }

        if (this.ignoreEntity != null)
        {
            if (this.ignoreEntity == this.thrower) {
				if (flag) {
					this.ignoreTime = 2;
				} else if (this.ignoreTime-- <= 0) {
					this.ignoreEntity = null;
				} 
			}
        }

        if ((entity != null)&&(entity != this.thrower))
        {
		    raytraceresult = new RayTraceResult(entity);
        }

        if (raytraceresult != null && (raytraceresult.entityHit != this.thrower))
        {
            if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK && this.world.getBlockState(raytraceresult.getBlockPos()).getBlock() == Blocks.PORTAL)
            {
                this.setPortal(raytraceresult.getBlockPos());
            }
            else
            {
                if(!net.minecraftforge.common.ForgeHooks.onThrowableImpact(this, raytraceresult) && entity != this.thrower)
                this.onImpact(raytraceresult);
            }
        }

        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        float f = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * (180D / Math.PI));

        for (this.rotationPitch = (float)(MathHelper.atan2(this.motionY, (double)f) * (180D / Math.PI)); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
        {
            ;
        }

        while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
        {
            this.prevRotationPitch += 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw < -180.0F)
        {
            this.prevRotationYaw -= 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
        {
            this.prevRotationYaw += 360.0F;
        }

        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
        float f1 = 0.99F;
        float f2 = this.getGravityVelocity();

        if (this.isInWater())
        {
        	this.setDead();
        }
        
        if(this.minus != 10) {
            this.minus++;
        }
    	
        for (int k = 0; k < (12-this.minus); k++)
        {
        	double randX = Math.random()/(this.minus/2.5);
        	double randY = Math.random()/(this.minus/2.5);
        	double randZ = Math.random()/(this.minus/2.5);
        	Random random = new Random();
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, true, ModMath.plusOrMinus(random.nextBoolean(), this.posX, randX), ModMath.plusOrMinus(random.nextBoolean(),this.posY, randY), ModMath.plusOrMinus(random.nextBoolean(), this.posZ, randZ), 0.0D, 0.0D, 0.0D);
            if((this.minus % 2 == 0)&&(k % 2 == 0)) {
                this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, true, ModMath.plusOrMinus(random.nextBoolean(), this.posX, randX), ModMath.plusOrMinus(random.nextBoolean(),this.posY, randY), ModMath.plusOrMinus(random.nextBoolean(), this.posZ, randZ), 0.0D, 0.0D, 0.0D);
            }
            if((this.minus % 2 != 0)&&(k % 2 != 0)) {
                this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, true, ModMath.plusOrMinus(random.nextBoolean(), this.posX, randX), ModMath.plusOrMinus(random.nextBoolean(),this.posY, randY), ModMath.plusOrMinus(random.nextBoolean(), this.posZ, randZ), 0.0D, 0.0D, 0.0D);
            }
            if (this.ticksExisted > 10) {
            	 this.world.spawnParticle(EnumParticleTypes.FLAME, true, ModMath.plusOrMinus(random.nextBoolean(), this.posX, randX), ModMath.plusOrMinus(random.nextBoolean(),this.posY, randY), ModMath.plusOrMinus(random.nextBoolean(), this.posZ, randZ), 0.0D, 0.0D, 0.0D);
            	 this.world.spawnParticle(EnumParticleTypes.DRIP_LAVA, true, ModMath.plusOrMinus(random.nextBoolean(), this.posX, randX), ModMath.plusOrMinus(random.nextBoolean(),this.posY, randY), ModMath.plusOrMinus(random.nextBoolean(), this.posZ, randZ), 0.0D, 0.0D, 0.0D);
            	 this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, true, ModMath.plusOrMinus(random.nextBoolean(), this.posX, randX), ModMath.plusOrMinus(random.nextBoolean(),this.posY, randY), ModMath.plusOrMinus(random.nextBoolean(), this.posZ, randZ), 0.0D, 0.0D, 0.0D);
            }
        }
        
        
        this.motionX *= (double)f1;
        this.motionY *= (double)f1;
        this.motionZ *= (double)f1;

        if (!this.hasNoGravity())
        {
            this.motionY -= (double)f2;
        }

        this.setPosition(this.posX, this.posY, this.posZ);
        
        if(this.ticksExisted > 100) {
        	this.setDead();
        }
    }
    
    public double getX() {
    	return this.posX;
    }
    
    public double getY() {
    	return this.posY;
    }
    
    public double getZ() {
    	return this.posZ;
    }
    
}
