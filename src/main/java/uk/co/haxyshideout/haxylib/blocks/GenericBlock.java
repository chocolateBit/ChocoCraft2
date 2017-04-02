package uk.co.haxyshideout.haxylib.blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

/**
 * Created by clienthax on 12/4/2015.
 */
public class GenericBlock extends Block
{

	private boolean opaque = true;
	private boolean fullcube = true;
	//protected String name;

	public GenericBlock(Material materialIn, String name)
	{
		super(materialIn);
		//this.name = name;
	//	setRegistryName(name);
	//	setUnlocalizedName(name);
	}

	
	public Block setFullCube(boolean fullcube)
	{
		this.fullcube = fullcube;
		return this;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return fullcube;
	}

	public Block setOpaque(boolean opaque)
	{
		this.opaque = opaque;
		return this;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return opaque;
	}

	@Override
	public String getUnlocalizedName()
	{
		return super.getUnlocalizedName().substring(5);
	}

}
