package uk.co.haxyshideout.chococraft2.proxies;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.co.haxyshideout.chococraft2.ChocoCraft2;
import uk.co.haxyshideout.chococraft2.config.Additions;
import uk.co.haxyshideout.chococraft2.config.ChococraftConfig;
import uk.co.haxyshideout.chococraft2.config.Constants;
import uk.co.haxyshideout.chococraft2.entities.EntityBabyChocobo;
import uk.co.haxyshideout.chococraft2.entities.EntityChocobo;
import uk.co.haxyshideout.chococraft2.worldgen.GysahlGen;

import java.util.List;

/**
 * Created by clienthax on 12/4/2015.
 */
public class ServerProxy
{

	public void preInit()
	{
		//register additions
		Additions.register(1);
		//Additions.registerAdditions();
	}
	
	public void init() {
		// leave
		//Additions.registerBlocks(1);
		
	}
	
	public void registerSounds()
	{

	}

	public void registerEntities()
	{
		int entityId = 0;
		
		// <3 <3
		ResourceLocation resource_babychocobo = new ResourceLocation(Constants.MODID, "babychocobo");
		ResourceLocation resource_chocobo = new ResourceLocation(Constants.MODID, "chocobo");
		
		EntityRegistry.registerModEntity(resource_babychocobo, EntityBabyChocobo.class, resource_babychocobo.toString(), entityId++, ChocoCraft2.instance, 64, 1, true);
		EntityRegistry.registerModEntity(resource_chocobo, EntityChocobo.class, resource_chocobo.toString(), entityId++, ChocoCraft2.instance, 64, 1, true);
		
		ChococraftConfig config = ChocoCraft2.instance.getConfig();
		List<Biome> spawnBiomes = config.getSpawnBiomes();
		EntityRegistry.addSpawn(EntityChocobo.class, config.getOverworldWeight(), config.getOverworldMinGroup(), config.getOverworldMaxGroup(), EnumCreatureType.CREATURE, spawnBiomes.toArray(new Biome[spawnBiomes.size()]));
		EntityRegistry.addSpawn(EntityChocobo.class, config.getNetherWeight(), config.getNetherMinGroup(), config.getNetherMaxGroup(), EnumCreatureType.CREATURE, Biome.getBiome(8));
	}

	public void registerWorldGenerators()
	{
		GameRegistry.registerWorldGenerator(new GysahlGen(), ChocoCraft2.instance.getConfig().getGysahlWorldGenWeight());
	}

	public void openChocopedia(EntityChocobo chocobo)
	{
	}

	public void updateRiderState(EntityPlayer rider)
	{
	}

}
