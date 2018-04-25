package com.benthom123.test.particle;

import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleSmokeNormal;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HealingParticle extends ParticleSmokeNormal
{
/*    public HealingParticle(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        setParticleTextureIndex(80); // same as happy villager
        particleScale = 2.0F;
        setRBGColorF(0xff, 0xff, 0x0);
    }*/
	
    public HealingParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double p_i46348_8_, double p_i46348_10_, double p_i46348_12_, float p_i46348_14_)
    {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i46348_8_, p_i46348_10_, p_i46348_12_, p_i46348_14_);
        float f = (float)Math.random() * 0.4F + 0.6F;
        int r = (int)(Math.random()*255);
        int g = (int)(Math.random()*255);
        int b = (int)(Math.random()*255);
        this.particleRed = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * r * f;
        this.particleGreen = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * g * f;
        this.particleBlue = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * b * f;
        
/*        setParticleTextureIndex(0);
        this.motionX *= 0.10000000149011612D;
        this.motionY *= 0.10000000149011612D;
        this.motionZ *= 0.10000000149011612D;
        this.motionX += p_i46348_8_;
        this.motionY += p_i46348_10_;
        this.motionZ += p_i46348_12_;
        //float f = (float)(Math.random() * 0.30000001192092896D);
//        this.particleRed = 0;
//        this.particleGreen = 0;
//        this.particleBlue = 0;
        setRBGColorF(0, 0, 255);
        this.particleScale *= 0.75F;
        this.particleScale *= p_i46348_14_;
        this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
        this.particleMaxAge = (int)((float)this.particleMaxAge * p_i46348_14_);*/
    }
}