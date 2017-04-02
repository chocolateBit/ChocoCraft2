package uk.co.haxyshideout.chococraft2.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import uk.co.haxyshideout.chococraft2.config.Constants;
import uk.co.haxyshideout.chococraft2.entities.DefaultNames;
import uk.co.haxyshideout.chococraft2.entities.EntityChocobo;
import uk.co.haxyshideout.haxylib.debug.DebugHelper;

import java.util.Random;

/**
 * Created by clienthax on 13/4/2015.
 */
public class DebugCommand extends CommandBase {

	// <3 @Override
	public String getCommandName() {
		return getName();
	}

	// <3 @Override
	public String getCommandUsage(ICommandSender sender) {
		return "/"+getName();
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		DebugHelper.langCheck(Constants.MODID);

		EntityChocobo chocobo = new EntityChocobo(sender.getEntityWorld());
		EntityPlayerMP player = (EntityPlayerMP) sender;
		chocobo.setPosition(player.posX, player.posY, player.posZ);
		player.getEntityWorld().spawnEntity(chocobo);// <3 spawnEntityInWorld(chocobo);
//		chocobo.setTamed(true);
//		chocobo.setOwnerId(((EntityPlayerMP) sender).getUniqueID().toString());
		chocobo.setSaddled(false);
		chocobo.setCustomNameTag(DefaultNames.getRandomName(chocobo.isMale()));
		
		EntityChocobo.ChocoboColor chocoColors[] = EntityChocobo.ChocoboColor.values();
		chocobo.setColor(chocoColors[new Random().nextInt(chocoColors.length)]);

//		ChocopediaGui gui = new ChocopediaGui(chocobo);
//		Minecraft.getMinecraft().displayGuiScreen(gui);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "chocodebug";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/"+getName();
	}
}
