package com.benthom123.test;

import com.benthom123.test.entity.EntityGlacialSpear;
import com.benthom123.test.entity.EntityHealingRift;
import com.benthom123.test.entity.EntitySmokeShot;
import com.benthom123.test.entity.EntityVoidRift;
import com.benthom123.test.entity.EntityVortexField;
import com.benthom123.test.entity.GlacialEntityFX;
import com.benthom123.test.entity.HealingEntityFX;
import com.benthom123.test.entity.SmokeEntityFX;
import com.benthom123.test.entity.VoidEntityFX;
import com.benthom123.test.entity.VoidFactory;
import com.benthom123.test.entity.VortexEntityFX;

import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {
	public static void init() {
		// Every entity in our mod has an ID (local to this mod)
		int id = 1;
		EntityRegistry.registerModEntity(EntitySmokeShot.smokeshot, EntitySmokeShot.class, "Smoke Shot", id++, modClass.instance, 128, 1, true);
		EntityRegistry.registerModEntity(EntityVoidRift.voidrift, EntityVoidRift.class, "Void Rift", id++, modClass.instance, 128, 2, false);
		EntityRegistry.registerModEntity(EntityGlacialSpear.glacialspear, EntityGlacialSpear.class, "Glacial Spear", id++, modClass.instance, 128, 1, true);
		EntityRegistry.registerModEntity(EntityHealingRift.healingrift, EntityHealingRift.class, "Healing Rift", id++, modClass.instance, 128, 2, false);
		EntityRegistry.registerModEntity(EntityVortexField.voidrift, EntityVortexField.class, "Vortex Field", id++, modClass.instance, 128, 2, false);
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySmokeShot.class, SmokeEntityFX.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityVoidRift.class, VoidEntityFX.VOIDFACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGlacialSpear.class, GlacialEntityFX.GLACIALFACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityHealingRift.class, HealingEntityFX.HEALINGFACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityVortexField.class, VortexEntityFX.VORTEXFACTORY);
    }
}
