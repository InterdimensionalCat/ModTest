package com.benthom123.test.entity;

import com.benthom123.test.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class HealingFactory implements IRenderFactory<EntityHealingRift> {

    @Override
    public Render<? super EntityHealingRift> createRenderFor(RenderManager manager) {
        return new VoidEntityFX(manager);
    }

}

