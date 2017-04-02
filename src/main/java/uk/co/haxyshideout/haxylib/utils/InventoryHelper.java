package uk.co.haxyshideout.haxylib.utils;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by clienthax on 20/5/2015.
 */
public class InventoryHelper {

	/**
	 * Gives the player a {@link ItemStack} if they do not already have it in their inventory
	 * @param stack the ItemStack to give to the player if not present
	 * @param player the player to give the stack to
	 */
	public static void giveIfMissing(ItemStack stack, EntityPlayerMP player) {
		if(!player.inventory.hasItemStack(stack)) {
			player.inventory.addItemStackToInventory(stack);
			player.inventoryContainer.detectAndSendChanges();//mc is stupid and needs this to "show" the item
		}
	}

	/**
	 * Attempts to give the player a item, if their inventory is full, it will drop the item where they are standing in the world.
	 * @param stack the ItemStack to give to the player
	 * @param player the player to give the stack to
	 */
	public static void giveOrDropStack(ItemStack stack, EntityPlayerMP player) {
		boolean addedToPlayer = player.inventory.addItemStackToInventory(stack);
		if(addedToPlayer) {
			player.inventoryContainer.detectAndSendChanges();//mc is stupid and needs this to "show" the item
			return;
		}

		EntityItem entityItem = new EntityItem(player.world, player.posX, player.posY, player.posZ, stack);
		player.world.spawnEntity(entityItem);
	}

	public static void dropStack(ItemStack stack, World world, double x, double y, double z) {
		EntityItem entityItem = new EntityItem(world, x, y, z, stack);
		world.spawnEntity(entityItem);
	}

}
