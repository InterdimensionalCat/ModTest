package com.benthom123.test.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.Random;

import javax.annotation.Nullable;

import com.benthom123.test.modClass;
import com.benthom123.test.items.SmokeShot;
import com.benthom123.test.entity.EntityVortexField;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;


public class EntityVortexField extends Entity
{
	
	public static ResourceLocation voidrift = new ResourceLocation("btm:voidrift");
	
    private static final DataParameter<Float> RADIUS = EntityDataManager.<Float>createKey(EntityVortexField.class, DataSerializers.FLOAT);
    private static final DataParameter<Integer> COLOR = EntityDataManager.<Integer>createKey(EntityVortexField.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> IGNORE_RADIUS = EntityDataManager.<Boolean>createKey(EntityVortexField.class, DataSerializers.BOOLEAN);
/*    private static final DataParameter<Integer> PARTICLE = EntityDataManager.<Integer>createKey(EntityAreaEffectCloud.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> PARTICLE_PARAM_1 = EntityDataManager.<Integer>createKey(EntityAreaEffectCloud.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> PARTICLE_PARAM_2 = EntityDataManager.<Integer>createKey(EntityAreaEffectCloud.class, DataSerializers.VARINT);*/
    //private PotionType potion;
    //private final List<PotionEffect> effects;
    //private final Map<Entity, Integer> reapplicationDelayMap;
    private int duration;
    private int waitTime;
    //private int reapplicationDelay;
    //private boolean colorSet;
    //private int durationOnUse;
    private float radiusOnUse;
    //private float radiusPerTick;
    private EntityLivingBase owner;
    private UUID ownerUniqueId;
    private ArrayList<Entity> hit = new ArrayList<Entity>();
    public int counter = 0;

    public EntityVortexField(World worldIn)
    {
        super(worldIn);
        //this.potion = PotionTypes.EMPTY;
        //this.effects = Lists.<PotionEffect>newArrayList();
        //this.reapplicationDelayMap = Maps.<Entity, Integer>newHashMap();
        this.duration = 200;
        this.waitTime = 0;
        //this.reapplicationDelay = 20;
        this.noClip = true;
        this.isImmuneToFire = true;
        this.setRadius(3.0F);
    }

    public EntityVortexField(World worldIn, double x, double y, double z)
    {
        this(worldIn);
        this.setPosition(x, y, z);
    }

    protected void entityInit()
    {
        this.getDataManager().register(COLOR, Integer.valueOf(0));
        this.getDataManager().register(RADIUS, Float.valueOf(0.5F));
        this.getDataManager().register(IGNORE_RADIUS, Boolean.valueOf(false));
/*        this.getDataManager().register(PARTICLE, Integer.valueOf(EnumParticleTypes.SPELL_MOB.getParticleID()));
        this.getDataManager().register(PARTICLE_PARAM_1, Integer.valueOf(0));
        this.getDataManager().register(PARTICLE_PARAM_2, Integer.valueOf(0));*/
    }

    public void setRadius(float radiusIn)
    {
        double d0 = this.posX;
        double d1 = this.posY;
        double d2 = this.posZ;
        this.setSize(radiusIn * 2.0F, 0.5F);
        this.setPosition(d0, d1, d2);

        if (!this.world.isRemote)
        {
            this.getDataManager().set(RADIUS, Float.valueOf(radiusIn));
        }
    }

    public float getRadius()
    {
        return ((Float)this.getDataManager().get(RADIUS)).floatValue();
    }


    /**
     * Sets if the radius should be ignored, and the effect should be shown in a single point instead of an area
     */
    protected void setIgnoreRadius(boolean ignoreRadius)
    {
        this.getDataManager().set(IGNORE_RADIUS, Boolean.valueOf(ignoreRadius));
    }

    /**
     * Returns true if the radius should be ignored, and the effect should be shown in a single point instead of an area
     */
    public boolean shouldIgnoreRadius()
    {
        return ((Boolean)this.getDataManager().get(IGNORE_RADIUS)).booleanValue();
    }

    public int getDuration()
    {
        return this.duration;
    }

    public void setDuration(int durationIn)
    {
        this.duration = durationIn;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        boolean flag = this.shouldIgnoreRadius();
        float f = this.getRadius();

        if (this.world.isRemote)
        {
        	Random rand = new Random();
        	this.counter++;

        	for (int i = 0; i < 3; i++) {
            	double deg = this.counter*(i+1)/20.0 * 360.0;
				//double radius = this.getRadius() - (this.getRadius()*((this.getDuration()-this.ticksExisted)/this.getDuration()));
				//double deg = rand.nextDouble()*360;
				//System.out.println(deg + " degrees");
				//System.out.println(this.counter);
				double angle = Math.toRadians(deg);
				//System.out.println(angle + " is");
				//double angle = counter;
				double rad = this.getRadius()*rand.nextFloat();
/*				if (this.getRadius() / 4 > rad) {
					rad = this.getRadius();
				}*/
				double x = this.posX + rad * Math.sin(angle);
				double z = this.posZ + rad * Math.cos(angle); //this position needs to be tracked in the movement function
				//System.out.println(x + " and " + z);
				//this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, true, x, this.posY, z, 0.0D, 0.0D, 0.0D);
				if (/*rand.nextBoolean()*/rand.nextInt(this.duration) > this.ticksExisted) {
					modClass.proxy.generateVoidParticle(this, this, x, this.posY /*+ rand.nextFloat()*/, z, 0.0D, 0.0D, 0.0D, deg, rad);
				}
			}
        	
        	
            float f5 = (float)Math.PI * f * f;

            for (int k1 = 0; (float)k1 < f5; ++k1)
            {
                float f6 = this.rand.nextFloat() * ((float)Math.PI * 2F);
                float f7 = MathHelper.sqrt(this.rand.nextFloat()) * f;
                float f8 = MathHelper.cos(f6) * f7;
                float f9 = MathHelper.sin(f6) * f7;
                int l1 = 0;
                int i2 = l1 >> 16 & 255;
                int j2 = l1 >> 8 & 255;
                int j1 = l1 & 255;
                if (rand.nextBoolean()&&rand.nextInt(this.duration) > this.ticksExisted) {
                	double d1 = 1 + rand.nextDouble();
                    this.world.spawnParticle(EnumParticleTypes.PORTAL, true, this.posX + (double)f8/d1, this.posY, this.posZ + (double)f9/d1, (double)((float)i2 / 255.0F), (double)((float)j2 / 255.0F), (double)((float)j1 / 255.0F));
                }
            }
        }
        else
        {
            if (this.ticksExisted >= this.duration)
            {
                this.setDead();
                return;
            }

            boolean flag1 = this.ticksExisted < this.waitTime;

            if (flag != flag1)
            {
                this.setIgnoreRadius(flag1);
            }

            if (flag1)
            {
                return;
            }

/*            if (this.radiusPerTick != 0.0F)
            {
                f += this.radiusPerTick;

                if (f < 0.5F)
                {
                    this.setDead();
                    return;
                }

                this.setRadius(f);
            }*/

            /*if (this.ticksExisted % 5 == 0)
            {
                Iterator<Entry<Entity, Integer>> iterator = this.reapplicationDelayMap.entrySet().iterator();

                while (iterator.hasNext())
                {
                    Entry<Entity, Integer> entry = (Entry)iterator.next();

                    if (this.ticksExisted >= ((Integer)entry.getValue()).intValue())
                    {
                        iterator.remove();
                    }
                }*/

/*                List<PotionEffect> potions = Lists.<PotionEffect>newArrayList();

                for (PotionEffect potioneffect1 : this.potion.getEffects())
                {
                    potions.add(new PotionEffect(potioneffect1.getPotion(), potioneffect1.getDuration() / 4, potioneffect1.getAmplifier(), potioneffect1.getIsAmbient(), potioneffect1.doesShowParticles()));
                }

                potions.addAll(this.effects);

                if (potions.isEmpty())
                {
                    this.reapplicationDelayMap.clear();
                }
                else
                {*/
                    List<Entity> list = this.world.<Entity>getEntitiesWithinAABB(Entity.class, this.getEntityBoundingBox());
                    List<EntityLivingBase> list1 = this.world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox());
                    if (this.ticksExisted % 40 == 0) {
                    	hit.clear();
                    }

                    if (!list.isEmpty())
                    {
                        for (EntityLivingBase entity : list1)
                        {
                        	if (entity != this.owner) {
								if (!this.world.isRemote) {
									PotionEffect effect = new PotionEffect(MobEffects.SLOWNESS, 1, 4);
									entity.addPotionEffect(effect);

								}
								if (!(hit.contains(entity))) {
									PotionEffect effect1 = new PotionEffect(MobEffects.BLINDNESS, 200, 2);
									entity.addPotionEffect(effect1);
									entity.attackEntityFrom(DamageSource.MAGIC, 6.0F);
									this.hit.add(entity);
								}
								/*                            if (!this.reapplicationDelayMap.containsKey(entitylivingbase) && entitylivingbase.canBeHitWithPotion())
								                            {
								double d0 = entitylivingbase.posX - this.posX;
								double d1 = entitylivingbase.posZ - this.posZ;
								double d2 = d0 * d0 + d1 * d1;
								
								if (d2 <= (double)(f * f))
								{
								    this.reapplicationDelayMap.put(entitylivingbase, Integer.valueOf(this.ticksExisted + this.reapplicationDelay));
								
								    for (PotionEffect potioneffect : potions)
								    {
								        if (potioneffect.getPotion().isInstant())
								        {
								            potioneffect.getPotion().affectEntity(this, this.getOwner(), entitylivingbase, potioneffect.getAmplifier(), 0.5D);
								        }
								        else
								        {
								            entitylivingbase.addPotionEffect(new PotionEffect(potioneffect));
								        }
								    }
								
								    if (this.radiusOnUse != 0.0F)
								    {
								        f += this.radiusOnUse;
								
								        if (f < 0.5F)
								        {
								            this.setDead();
								            return;
								        }
								
								        this.setRadius(f);
								    }
								
								    if (this.durationOnUse != 0)
								    {
								        this.duration += this.durationOnUse;
								
								        if (this.duration <= 0)
								        {
								            this.setDead();
								            return;
								        }
								    }
								}
								                            }*/
							}
                        }
                    }   
                }
            }


    public void setRadiusOnUse(float radiusOnUseIn)
    {
        this.radiusOnUse = radiusOnUseIn;
    }

/*    public void setRadiusPerTick(float radiusPerTickIn)
    {
        this.radiusPerTick = radiusPerTickIn;
    }*/

    public void setWaitTime(int waitTimeIn)
    {
        this.waitTime = waitTimeIn;
    }

    public void setOwner(@Nullable EntityLivingBase ownerIn)
    {
        this.owner = ownerIn;
        this.ownerUniqueId = ownerIn == null ? null : ownerIn.getUniqueID();
    }

    @Nullable
    public EntityLivingBase getOwner()
    {
        if (this.owner == null && this.ownerUniqueId != null && this.world instanceof WorldServer)
        {
            Entity entity = ((WorldServer)this.world).getEntityFromUuid(this.ownerUniqueId);

            if (entity instanceof EntityLivingBase)
            {
                this.owner = (EntityLivingBase)entity;
            }
        }

        return this.owner;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound compound)
    {
        this.ticksExisted = compound.getInteger("Age");
        this.duration = compound.getInteger("Duration");
        this.waitTime = compound.getInteger("WaitTime");
/*        this.reapplicationDelay = compound.getInteger("ReapplicationDelay");
        this.durationOnUse = compound.getInteger("DurationOnUse");*/
        this.radiusOnUse = compound.getFloat("RadiusOnUse");
//        this.radiusPerTick = compound.getFloat("RadiusPerTick");
        this.setRadius(compound.getFloat("Radius"));
        this.ownerUniqueId = compound.getUniqueId("OwnerUUID");

/*        if (compound.hasKey("Particle", 8))
        {
            EnumParticleTypes enumparticletypes = EnumParticleTypes.getByName(compound.getString("Particle"));

            if (enumparticletypes != null)
            {
                this.setParticle(enumparticletypes);
                this.setParticleParam1(compound.getInteger("ParticleParam1"));
                this.setParticleParam2(compound.getInteger("ParticleParam2"));
            }
        }

        if (compound.hasKey("Color", 99))
        {
            this.setColor(compound.getInteger("Color"));
        }

        if (compound.hasKey("Potion", 8))
        {
            this.setPotion(PotionUtils.getPotionTypeFromNBT(compound));
        }

        if (compound.hasKey("Effects", 9))
        {
            NBTTagList nbttaglist = compound.getTagList("Effects", 10);
            this.effects.clear();

            for (int i = 0; i < nbttaglist.tagCount(); ++i)
            {
                PotionEffect potioneffect = PotionEffect.readCustomPotionEffectFromNBT(nbttaglist.getCompoundTagAt(i));

                if (potioneffect != null)
                {
                    this.addEffect(potioneffect);
                }
            }
        }*/
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound compound)
    {
        compound.setInteger("Age", this.ticksExisted);
        compound.setInteger("Duration", this.duration);
        compound.setInteger("WaitTime", this.waitTime);
/*        compound.setInteger("ReapplicationDelay", this.reapplicationDelay);
        compound.setInteger("DurationOnUse", this.durationOnUse);*/
        compound.setFloat("RadiusOnUse", this.radiusOnUse);
//        compound.setFloat("RadiusPerTick", this.radiusPerTick);
        compound.setFloat("Radius", this.getRadius());
/*        compound.setString("Particle", this.getParticle().getParticleName());
        compound.setInteger("ParticleParam1", this.getParticleParam1());
        compound.setInteger("ParticleParam2", this.getParticleParam2())*/;

        if (this.ownerUniqueId != null)
        {
            compound.setUniqueId("OwnerUUID", this.ownerUniqueId);
        }

/*        if (this.colorSet)
        {
            compound.setInteger("Color", this.getColor());
        }

        if (this.potion != PotionTypes.EMPTY && this.potion != null)
        {
            compound.setString("Potion", ((ResourceLocation)PotionType.REGISTRY.getNameForObject(this.potion)).toString());
        }

        if (!this.effects.isEmpty())
        {
            NBTTagList nbttaglist = new NBTTagList();

            for (PotionEffect potioneffect : this.effects)
            {
                nbttaglist.appendTag(potioneffect.writeCustomPotionEffectToNBT(new NBTTagCompound()));
            }

            compound.setTag("Effects", nbttaglist);
        }*/
    }

    public void notifyDataManagerChange(DataParameter<?> key)
    {
        if (RADIUS.equals(key))
        {
            this.setRadius(this.getRadius());
        }

        super.notifyDataManagerChange(key);
    }

    public EnumPushReaction getPushReaction()
    {
        return EnumPushReaction.IGNORE;
    }
}
	
	
/*	this.playerpos = playerIn.getPosition();
	int range = 10;
	Vec3d look = playerIn.getLookVec();
	BlockPos tPos = playerpos.add(new Vec3i(playerpos.getX() + look.x*range, playerpos.getY()+ (look.y*range), playerpos.getZ() + (look.z*range)));
	BlockPos pPos = playerpos.add(new Vec3i(playerpos.getX() - look.x*range, playerpos.getY() - (look.y*range), playerpos.getZ() - (look.z*range)));
	List<Entity> targets = playerIn.world.getEntitiesWithinAABBExcludingEntity(playerIn, new AxisAlignedBB(pPos, tPos));
	for(Entity entityIn : targets) {
	       entityIn.attackEntityFrom(DamageSource.causeIndirectMagicDamage(playerIn, entityIn), 2.0F);
	       entityIn.setFire(10);*/

