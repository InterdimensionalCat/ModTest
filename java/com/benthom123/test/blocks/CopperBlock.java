package com.benthom123.test.blocks;

import java.util.Collection;
import java.util.Random;

import javax.annotation.Nullable;

import com.benthom123.test.ModItems;
import com.benthom123.test.modClass;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CopperBlock extends Block {
	

    //public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public CopperBlock() {
        super(Material.ROCK);
        this.setTickRandomly(true);
        this.setHarvestLevel("pickaxe", 0 );
        this.setHardness(3.0F);
        this.setResistance(15.0f);
        setUnlocalizedName(modClass.MODID + ".copperblock");
        setRegistryName("copperblock");
        this.setCreativeTab(ModItems.extraTools);
    }
    
    
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
//    
//    /**
//     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
//     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
//     * block, etc.
//     */
//    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
//    {
//        if (!worldIn.isRemote)
//        {
//            if (this.isOn && !worldIn.isBlockPowered(pos))
//            {
//                worldIn.scheduleUpdate(pos, this, 4);
//            }
//            else if (!this.isOn && worldIn.isBlockPowered(pos))
//            {
//            	getWeakPower(state, worldIn, pos, EnumFacing.UP);
//            }
//        }
//    }
//    
//    @Override
//    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
//    {
//        if (!worldIn.isRemote)
//        {
//           if (!this.isOn && worldIn.isBlockPowered(pos))
//            {
//            	getWeakPower(state, worldIn, pos, EnumFacing.UP);
//            }
//        }
//    }
//
//    @Override
//    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
//    {
//        if (!worldIn.isRemote)
//        {
//            if (this.isOn && !worldIn.isBlockPowered(pos))
//            {
//            	getWeakPower(state, worldIn, pos, EnumFacing.UP);
//            }
//        }
//    }
//    
//   protected boolean isPowered(IBlockState state)
//    {
//        return this.isOn;
//    }
//    
//    
//    public int getWeakPower(IBlockState blockState, World worldIn, BlockPos pos)
//    {
//        if (!this.isPowered(blockState))
//        {
//            return 0;
//        }
//        else
//        {
//            return this.getActiveSignal(worldIn, pos, blockState);
//        }
//    }
//        
//        protected int getActiveSignal(IBlockAccess worldIn, BlockPos pos, IBlockState state)
//        {
//            return 15;
//        }
//
//
//		@Override
//		protected int getDelay(IBlockState state) {
//			return 0;
//		}
//
//
//		@Override
//		protected IBlockState getPoweredState(IBlockState unpoweredState) {
//			return null;
//		}
//
//
//		@Override
//		protected IBlockState getUnpoweredState(IBlockState poweredState) {
//			return null;
//		}
//    
//
//}