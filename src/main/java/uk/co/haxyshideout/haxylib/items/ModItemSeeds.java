package uk.co.haxyshideout.haxylib.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSeeds;

/**
 * Created by clienthax on 13/4/2015.
 */
public class ModItemSeeds extends ItemSeeds implements IJsonItem {

	public ModItemSeeds(Block crops, Block soil, CreativeTabs tab, String name) {
		super(crops, soil);
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setRegistryName(name);
	}

	@Override
	public String getUnlocalizedName() {
		return super.getUnlocalizedName().substring(5);
	}

	@Override
	public String getTextureFolder() {
		return "items";
	}

}
