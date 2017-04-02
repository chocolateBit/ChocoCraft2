package uk.co.haxyshideout.haxylib.items;

import java.util.UUID;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import uk.co.haxyshideout.chococraft2.items.ModBaseItem;

/**
 * Created by clienthax on 13/4/2015.
 */
public class ModItem extends Item implements IJsonItem {
    
	/*public ModItem(String name, CreativeTabs tab) {
		super();
	}*/	
	@Override
	public String getUnlocalizedName() {
		return super.getUnlocalizedName().substring(5);
	}

	@Override
	public String getTextureFolder() {
		return "items";
	}
	

}