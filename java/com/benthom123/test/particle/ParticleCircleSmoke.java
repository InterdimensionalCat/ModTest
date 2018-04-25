package com.benthom123.test.particle;

import java.util.Random;

import com.benthom123.test.entity.EntityVoidRift;
import com.benthom123.test.entity.EntityVortexField;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleSmokeNormal;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ParticleCircleSmoke extends Particle {
	
	private int counter;
	private EntityVortexField vortex;
	private float radiusOnUse;
	private double angle;
	private double radius;
	private float speedModifier;
	private float rotationModifier;
	private double radiusModifier;
	private double startingY;

	public ParticleCircleSmoke(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double p_i46348_8_, double p_i46348_10_, double p_i46348_12_, float p_i46348_14_, EntityVortexField vortex, double angleIn, double radiusIn) {
		super(worldIn, xCoordIn, yCoordIn + 0.0001, zCoordIn, p_i46348_8_, p_i46348_10_, p_i46348_12_);
		//this.setRBGColorF(230,230,250);
        this.particleRed = MathHelper.nextFloat(this.rand, 0.7176471F, 0.8745098F);
        this.particleGreen = MathHelper.nextFloat(this.rand, 0.0F, 0.0F);
        this.particleBlue = MathHelper.nextFloat(this.rand, 0.8235294F, 0.9764706F);
        this.setParticleTextureIndex(7 - 8/this.particleMaxAge);
		this.counter = 0;
		this.vortex = vortex;
		this.radiusOnUse = vortex.getRadius();
		this.particleMaxAge = vortex.getDuration() - vortex.ticksExisted + 2;
		this.canCollide = false;
		this.radius = radiusIn;
		this.angle = angleIn; //angle in degrees
		Random particleRand = new Random();
		this.radiusModifier = particleRand.nextDouble()*3;
		this.speedModifier = particleRand.nextFloat() + 0.5F;
		this.rotationModifier = particleRand.nextFloat() + 0.5F;
		this.startingY = yCoordIn;
		this.motionY = 0.01;
		
	}
	
	
	@Override
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setExpired();
        }

        this.setParticleTextureIndex(7 - 8/this.particleMaxAge);
        calculatePosInCircle();
        this.motionY *= 1.0000000785423279D;
        
        this.motionX *= Math.pow(0.9599999785423279D, this.counter);
        this.motionZ *= Math.pow(0.9599999785423279D, this.counter);
        
        //this.motionY = this.posY - (this.startingY - this.startingY*(this.particleAge/this.particleMaxAge));
        this.move(this.motionX /** this.speedModifier*/, this.motionY, this.motionZ/** this.speedModifier*/);

/*        if (this.posY == this.prevPosY)
        {
            this.motionX *= 1.1D;
            this.motionZ *= 1.1D;
        }

        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }*/
    }
	
	public void calculatePosInCircle() {
		//double angle = Math.toRadians(++this.counter); //- is the desired angle
		//float r = (float) (this.radiusOnUse - (this.radiusOnUse*(this.rift.ticksExisted / this.rift.getDuration())));  //- is the radius of the circle | (a,b) - is the center of the circle 
		/*double x = this.rift.posX + r * Math.sin(angle);
		double z = this.rift.posZ + r * Math.cos(angle);
		this.motionX = x - this.posX;
		this.motionZ = z - this.posZ;*/
		if (counter < vortex.getDuration()-1) {
			this.counter++;
		}
    	double radius = this.radius - this.radius*(counter*counter/**this.radiusModifier*/)/this.particleMaxAge;
    	if (radius <= 0.1) {
    		radius = 0.1;
    		this.setExpired();
    	}
    	System.out.println(radius + " radius");
    	double deg = 360.0*((double)this.counter / (double)25) * this.rotationModifier;
    	System.out.println(deg + " degrees");
    	System.out.println(this.counter);
        double angle = Math.toRadians(deg + this.angle);
        System.out.println(angle + " is");
    	//double angle = counter;
        double x = vortex.posX + radius * Math.sin(angle);
    	double z = vortex.posZ + radius * Math.cos(angle);
    	this.motionX = x - this.prevPosX;
    	this.motionZ = z - this.prevPosZ;
    	System.out.println(x + " and " + z);
		
		 //x_velocity_object = A.(z_position_object - z_position_point)
		 //z_velocity_object = A.(x_position_object - x_position_point)
		//this.motionX = 0.0001*(this.posX - this.rift.posX);
		//this.motionZ = 0.0001*(this.posZ - this.rift.posZ);
		
	}
}
