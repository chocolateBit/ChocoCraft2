package uk.co.haxyshideout.chococraft2.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.haxyshideout.chococraft2.client.gui.ChocopediaGui;
import uk.co.haxyshideout.chococraft2.config.Additions;
import uk.co.haxyshideout.chococraft2.config.Constants;
import uk.co.haxyshideout.chococraft2.entities.EntityBabyChocobo;
import uk.co.haxyshideout.chococraft2.entities.EntityChocobo;
import uk.co.haxyshideout.chococraft2.entities.RiderState;
import uk.co.haxyshideout.chococraft2.entities.models.ModelBabyChocobo;
import uk.co.haxyshideout.chococraft2.entities.models.ModelChocobo;
import uk.co.haxyshideout.chococraft2.entities.renderer.BabyChocoboRenderer;
import uk.co.haxyshideout.chococraft2.entities.renderer.ChocoboRenderer;
import uk.co.haxyshideout.chococraft2.network.PacketRegistry;
import uk.co.haxyshideout.chococraft2.network.side.server.RiderStateUpdatePacket;
import uk.co.haxyshideout.haxylib.utils.RegistryHelper;

import net.minecraft.util.SoundEvent;
import java.util.Iterator;


/**
 * Created by clienthax on 12/4/2015.
 */
public class ClientProxy extends ServerProxy
{

	private RiderState localRiderState = new RiderState();

	@Override
	public void preInit()
	{
		Additions.register(0);
		//RegistryHelper.registerRenderers(Additions.class, Constants.MODID);
	}
	
	@Override
	public void init()
	{
	//	Additions.registerBlocks(0);
		//Additions.register();
		//RegistryHelper.registerRenderers(Additions.class, Constants.MODID);
	}
	
	@Override
	public void registerSounds()
	{
		// See how many registered sounds there are so we have a starting id
		int soundEventId = SoundEvent.REGISTRY.getKeys().size();
		
		// Register sounds
		ResourceLocation resource_chocokweh = new ResourceLocation(Constants.MODID, "choco_kweh");
		SoundEvent.REGISTRY.register(soundEventId++, resource_chocokweh, new SoundEvent(resource_chocokweh));
	}

	@Override
	public void registerEntities()
	{
		super.registerEntities();
		// Have to register renderers in here because mojang is stupid
		RenderManager manager = Minecraft.getMinecraft().getRenderManager();
		RenderingRegistry.registerEntityRenderingHandler(EntityChocobo.class, new ChocoboRenderer(manager, new ModelChocobo()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBabyChocobo.class, new BabyChocoboRenderer(manager, new ModelBabyChocobo()));
	}

	@Override
	public void openChocopedia(EntityChocobo chocobo)
	{
		Minecraft.getMinecraft().displayGuiScreen(new ChocopediaGui(chocobo));
	}

	@Override
	public void updateRiderState(EntityPlayer rider)
	{
		EntityChocobo chocobo = (EntityChocobo) rider.getRidingEntity();
		chocobo.getRiderState().updateState(getRiderState(rider));
		if (chocobo.getRiderState().hasChanged())
		{
			RiderStateUpdatePacket packet = new RiderStateUpdatePacket(chocobo);
			PacketRegistry.INSTANCE.sendToServer(packet);
		}
		chocobo.getRiderState().resetChanged();
	}

	@SideOnly(Side.CLIENT)
	private RiderState getRiderState(Entity rider)
	{
		EntityPlayerSP riderSP = (EntityPlayerSP) rider;
		localRiderState.setJumping(riderSP.movementInput.jump);
		localRiderState.setSneaking(riderSP.movementInput.sneak);
		return localRiderState;
	}

}
