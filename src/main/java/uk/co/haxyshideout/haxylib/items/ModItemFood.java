package uk.co.haxyshideout.haxylib.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

/**
 * Created by clienthax on 13/4/2015.
 */
public class ModItemFood extends ItemFood implements IJsonItem {

	public ModItemFood(String name, CreativeTabs tab, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
	}

	public ModItemFood(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
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
