package uk.co.haxyshideout.haxylib.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class GenericArmor extends ItemArmor implements IJsonItem
{
	public boolean equippedSet = false;
	private String name;
	
	public GenericArmor(ItemArmor.ArmorMaterial material, EntityEquipmentSlot armorType, String name, CreativeTabs tab)// int renderIndex, EntityEquipmentSlot armorType)
	{
		super(material, 0, armorType);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
		setCreativeTab(tab);
	}

	@Override
	public String getUnlocalizedName()
	{
		return super.getUnlocalizedName().substring(5);
	}

	@Override
	public String getTextureFolder()
	{
		return "items/armor";
	}
}
