package com.benthom123.test.entity;

import java.util.Random;

import com.benthom123.test.ModMath;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SmokeEntityFX<T extends Entity> extends Render<T>
{
    protected final Item item;
    private final RenderItem itemRenderer;
    protected final RenderManager trackedManager;
    public static final Factory FACTORY = new Factory();

    public SmokeEntityFX(RenderManager renderManagerIn, Item itemIn, RenderItem itemRendererIn)
    {
        super(renderManagerIn);
        this.item = itemIn;
        this.itemRenderer = itemRendererIn;
        this.trackedManager =  renderManagerIn;
        
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
/*    	int minus = 0;
        for (int k = 0; k < (12-minus); ++k)
        {
        	double randX = Math.random()/(minus/2.5);
        	double randY = Math.random()/(minus/2.5);
        	double randZ = Math.random()/(minus/2.5);
        	Random random = new Random();
            
        	this.renderManager.world.spawnAlwaysVisibleParticle(12, ModMath.plusOrMinus(random.nextBoolean(), x, randX), ModMath.plusOrMinus(random.nextBoolean(), x, randY), ModMath.plusOrMinus(random.nextBoolean(), x, randZ), 0.0D, 0.0D, 0.0D);
        }*/
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }

        this.itemRenderer.renderItem(this.getStackToRender(entity), ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(T entityIn)
    {
        return new ItemStack(this.item);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
}
