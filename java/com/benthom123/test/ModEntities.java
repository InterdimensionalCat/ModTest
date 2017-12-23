package com.benthom123.test;

import com.benthom123.test.entity.EntitySmokeShot;
import com.benthom123.test.entity.SmokeEntityFX;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {
	public static void init() {
		// Every entity in our mod has an ID (local to this mod)
		int id = 1;
		EntityRegistry.registerModEntity(EntitySmokeShot.smokeshot, EntitySmokeShot.class, "Smoke Shot", id++, modClass.instance, 128, 1, true);
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySmokeShot.class, SmokeEntityFX.FACTORY);
    }
}
