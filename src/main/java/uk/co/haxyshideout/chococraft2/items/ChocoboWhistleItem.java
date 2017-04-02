package uk.co.haxyshideout.chococraft2.items;

import java.util.UUID;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import uk.co.haxyshideout.chococraft2.config.Additions;
import uk.co.haxyshideout.chococraft2.entities.EntityChocobo;
import uk.co.haxyshideout.haxylib.items.ModItem;

public class ChocoboWhistleItem extends ModBaseItem
{

	public ChocoboWhistleItem(String name, CreativeTabs tab, int stacksize) {
		super(name, tab, stacksize);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{
		ItemStack itemstack = player.getHeldItem(hand);
		
		if (world.isRemote)// return if client
			return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);

		itemstack = super.onItemRightClick(world, player, hand).getResult();
		
		if (!itemstack.hasTagCompound() || !itemstack.getTagCompound().hasKey("LinkedChocoboUUID"))
			return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);

		UUID chocoboUUID = UUID.fromString(itemstack.getTagCompound().getString("LinkedChocoboUUID"));
		Entity entity = FMLCommonHandler.instance().getMinecraftServerInstance().getEntityFromUuid(chocoboUUID);
		if (entity == null)
		{
			player.sendMessage(new TextComponentString("Unable to find linked chocobo"));
			return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
		}

		if (entity instanceof EntityChocobo)
		{
			if (entity.world != player.world)
			{
				player.sendMessage(new TextComponentString("The chocobo is not in the same world as you"));
				return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
				// MinecraftServer.getServer().getConfigurationManager().transferEntityToWorld(entity, entity.dimension, (WorldServer)entity.getEntityWorld(), (WorldServer)player.worldObj);
			}
			entity.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
			player.sendMessage(new TextComponentString("You called " + entity.getName() + " to you"));
		}

		return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
	}
}
