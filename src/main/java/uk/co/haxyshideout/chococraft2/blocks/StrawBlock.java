package uk.co.haxyshideout.chococraft2.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import uk.co.haxyshideout.haxylib.blocks.GenericBlock;


/**
 * Created by clienthax on 13/4/2015.
 */
public class StrawBlock extends GenericBlock
{
	
	public StrawBlock(String name, CreativeTabs tab)//, float hardness, float resistance, String tool, int harvest)
	{
		super(Material.CARPET, name);//, "strawblock");
		setOpaque(false);
		setFullCube(false);
		setUnlocalizedName(name);
		setSoundType(SoundType.PLANT);
	
		//setRegistryName(name);
		setCreativeTab(tab);
	//	setHardness(hardness);
	//	setResistance(resistance);
	//	setHarvestLevel(tool, harvest);
		
		// <3 setStepSound(SoundType.GROUND);
	}
	
	@Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
    }
	
/* @Override
	 public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
	{
	        
		 return getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer);
	}
	 */
	/*  <3 @Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState worldIn, World pos, BlockPos state)
	{
		return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
	}*/
}
