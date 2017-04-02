package uk.co.haxyshideout.chococraft2.items;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import uk.co.haxyshideout.haxylib.items.IJsonItem;

public class ModBaseItem extends Item implements IJsonItem{
	
	public ModBaseItem(String name, CreativeTabs tab){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
	}
		 
	public ModBaseItem(String name, CreativeTabs tab, int stacksize){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setMaxStackSize(stacksize);
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
