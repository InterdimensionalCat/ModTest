package com.benthom123.test.proxy;

import com.benthom123.test.ModBlocks;
import com.benthom123.test.ModEntities;
import com.benthom123.test.ModItems;
import com.benthom123.test.particle.HealingParticle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.world.World;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);;
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    	ModBlocks.initModels();
        ModItems.initModels();
        ModEntities.init();
        ModEntities.initModels();
    }
    
/*    public void generateHealingParticle(Entity theEntity, double posX, double posY, double posZ, double motionX, double motionY, double motionZ)
    {
        motionX *= theEntity.world.rand.nextGaussian() * 0.02D;
        motionY *= theEntity.world.rand.nextGaussian() * 0.02D;
        motionZ *= theEntity.world.rand.nextGaussian() * 0.02D;
        Particle particleMysterious = new HealingParticle(

              theEntity.getEntityWorld(), 
              posX + theEntity.world.rand.nextFloat() * theEntity.width 

                    * 2.0F - theEntity.width, 
              posY + 0.5D + theEntity.world.rand.nextFloat() 

                    * theEntity.height, 
              posZ + theEntity.world.rand.nextFloat() * theEntity.width 

                    * 2.0F - theEntity.width, 

              motionX, 

              motionY, 

              motionZ);
        Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);        
    }*/

}
