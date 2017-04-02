package uk.co.haxyshideout.chococraft2.config;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.co.haxyshideout.chococraft2.blocks.GysahlStemBlock;
import uk.co.haxyshideout.chococraft2.blocks.StrawBlock;
import uk.co.haxyshideout.chococraft2.entities.EntityChocobo.ChocoboColor;
import uk.co.haxyshideout.chococraft2.items.ChocoboWhistleItem;
import uk.co.haxyshideout.chococraft2.items.SpawnEggItem;
import uk.co.haxyshideout.haxylib.items.GenericArmor;
import uk.co.haxyshideout.haxylib.items.ModItem;
import uk.co.haxyshideout.haxylib.items.ModItemFood;
import uk.co.haxyshideout.haxylib.items.ModItemSeeds;
import uk.co.haxyshideout.haxylib.utils.JsonGenerator;
import uk.co.haxyshideout.haxylib.utils.RegistryHelper;
import uk.co.haxyshideout.chococraft2.items.ItemAdditionsItem;
import net.minecraft.item.ItemBlock;

/**
 * Created by clienthax on 12/4/2015. Should contain every block and item that
 * is added from the mod.
 */
public class Additions
{
	public static final ArmorMaterial chocoDisguiseMaterial = EnumHelper.addArmorMaterial("chocodisguise", Constants.MODID + ":chocodisguise", 200, new int[] { 3, 7, 6, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1); // <3 toughness
	
	public static Block gysahlStemBlock = new GysahlStemBlock("gysahlstemblock", ChocoCreativeTabs.chococraft2);//.setUnlocalizedName("gysahlstemblock").setCreativeTab(ChocoCreativeTabs.chococraft2);

	public static Item gysahlGreenItem = new ItemAdditionsItem("gysahlgreenitem", ChocoCreativeTabs.chococraft2);
	public static Item gysahlSeedsItem = new ModItemSeeds(gysahlStemBlock, Blocks.FARMLAND, ChocoCreativeTabs.chococraft2, "gysahlseedsitem");//("gysahlseedsitem", ChocoCreativeTabs.chococraft2);
	public static Item gysahlGoldenItem = new ItemAdditionsItem("gysahlgoldenitem", ChocoCreativeTabs.chococraft2);
	public static Item gysahlLoverlyItem = new ItemAdditionsItem("gysahlloverlyitem", ChocoCreativeTabs.chococraft2);
	public static Item gysahlPinkItem = new ItemAdditionsItem("gysahlpinkitem", ChocoCreativeTabs.chococraft2);
	public static Item gysahlRedItem = new ItemAdditionsItem("gysahlreditem", ChocoCreativeTabs.chococraft2);
	public static Item gysahlRawPicklesItem = new ItemAdditionsItem("gysahlrawpicklesitem", ChocoCreativeTabs.chococraft2);
	public static Item gysahlCookedPicklesItem = new ModItemFood("gysahlcookedpicklesitem", ChocoCreativeTabs.chococraft2, 2, 1.2F, false);
	public static Item gysahlCakeItem = new ItemAdditionsItem("gysahlcakeitem", ChocoCreativeTabs.chococraft2);
	public static Item gysahlChibiItem = new ItemAdditionsItem("gysahlchibiitem", ChocoCreativeTabs.chococraft2);
	
	public static Item chocoboFeatherItem = new ItemAdditionsItem("chocobofeatheritem", ChocoCreativeTabs.chococraft2);
	
	public static Item chocoboLegRawItem = new ModItemFood("chocobolegrawitem", ChocoCreativeTabs.chococraft2, 4, 0.3F, false);
	public static Item chocoboLegCookedItem = new ModItemFood("chocobolegcookeditem", ChocoCreativeTabs.chococraft2, 8, 1.2F, true);
	
	public static Item purpleSpawnEggItem = new SpawnEggItem(ChocoboColor.PURPLE, "purplespawneggitem", ChocoCreativeTabs.chococraft2);//.setUnlocalizedName("purplespawneggitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
	public static Item redSpawnEggItem = new SpawnEggItem(ChocoboColor.RED, "redspawneggitem", ChocoCreativeTabs.chococraft2);
	public static Item blackSpawnEggItem = new SpawnEggItem(ChocoboColor.BLACK, "blackspawneggitem", ChocoCreativeTabs.chococraft2);
	public static Item greenSpawnEggItem = new SpawnEggItem(ChocoboColor.GREEN, "greenspawneggitem", ChocoCreativeTabs.chococraft2);
	public static Item yellowSpawnEggItem = new SpawnEggItem(ChocoboColor.YELLOW, "yellowspawneggitem", ChocoCreativeTabs.chococraft2);
	public static Item goldSpawnEggItem = new SpawnEggItem(ChocoboColor.GOLD, "goldspawneggitem", ChocoCreativeTabs.chococraft2);
	public static Item whiteSpawnEggItem = new SpawnEggItem(ChocoboColor.WHITE, "whitespawneggitem", ChocoCreativeTabs.chococraft2);
	public static Item blueSpawnEggItem = new SpawnEggItem(ChocoboColor.BLUE, "bluespawneggitem", ChocoCreativeTabs.chococraft2);
	public static Item pinkSpawnEggItem = new SpawnEggItem(ChocoboColor.PINK, "pinkspawneggitem", ChocoCreativeTabs.chococraft2);
	
	public static Item chocopediaItem = new ItemAdditionsItem("chocopediaitem", ChocoCreativeTabs.chococraft2, 1); //setMaxStackSize
	
	public static Block strawBlock = new StrawBlock("strawblock", ChocoCreativeTabs.chococraft2);//.setUnlocalizedName("strawblock").setCreativeTab(ChocoCreativeTabs.chococraft2);
	
	public static Item chocoboSaddleItem = new ItemAdditionsItem("chocobosaddleitem", ChocoCreativeTabs.chococraft2, 5);
	public static Item chocoboSaddleBagItem = new ItemAdditionsItem("chocobosaddlebagitem", ChocoCreativeTabs.chococraft2, 8);
	public static Item chocoboPackBagItem = new ItemAdditionsItem("chocobopackbagitem", ChocoCreativeTabs.chococraft2, 8);
	
	public static Item chocoboWhistleItem = new ChocoboWhistleItem("chocobowhistleitem", ChocoCreativeTabs.chococraft2, 1);//.setUnlocalizedName("chocobowhistleitem").setMaxStackSize(1).setCreativeTab(ChocoCreativeTabs.chococraft2);
	
	public static Item chocoDisguiseHelm = new GenericArmor(chocoDisguiseMaterial, EntityEquipmentSlot.HEAD, "chocodisguisehelm", ChocoCreativeTabs.chococraft2);//.setUnlocalizedName("chocodisguisehelm").setCreativeTab(ChocoCreativeTabs.chococraft2);
	public static Item chocoDisguiseChest = new GenericArmor(chocoDisguiseMaterial, EntityEquipmentSlot.CHEST, "chocodisguisechest", ChocoCreativeTabs.chococraft2);//.setUnlocalizedName("chocodisguisechest").setCreativeTab(ChocoCreativeTabs.chococraft2);
	public static Item chocoDisguiseLegs = new GenericArmor(chocoDisguiseMaterial, EntityEquipmentSlot.LEGS, "chocodisguiselegs", ChocoCreativeTabs.chococraft2);//.setUnlocalizedName("chocodisguiselegs").setCreativeTab(ChocoCreativeTabs.chococraft2);
	public static Item chocoDisguiseBoots = new GenericArmor(chocoDisguiseMaterial, EntityEquipmentSlot.FEET, "chocodisguiseboots", ChocoCreativeTabs.chococraft2);//.setUnlocalizedName("chocodisguiseboots").setCreativeTab(ChocoCreativeTabs.chococraft2);

	//public static Block strawBlock;
	// public static Item gysahlGreenItem;
	//public static Item gysahlSeedsItem = new GenericItemSeeds(gysahlStemBlock, Blocks.FARMLAND).setUnlocalizedName("gysahlseedsitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
//	new GenericItemSeeds(gysahlStemBlock, Blocks.FARMLAND).setUnlocalizedName("gysahlseedsitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
	//public static Item gysahlGoldenItem;
	//public static Item gysahlLoverlyItem;
//	public static Item gysahlPinkItem;
//	public static Item gysahlRedItem;
//	public static Item gysahlRawPicklesItem;
//	public static Item gysahlCookedPicklesItem;
//	public static Item gysahlCakeItem;
//	public static Item gysahlChibiItem;// I have no idea what this is for. - apparently makes it so babies never grow up

//	public static Item chocoboFeatherItem;
//	public static Item chocoboLegRawItem;
//	public static Item chocoboLegCookedItem;
//	public static Item chocopediaItem;
//	public static Item chocoboSaddleItem;
	//public static Item chocoboSaddleBagItem;
	//public static Item chocoboPackBagItem;
//	public static Item chocoboWhistleItem;

	//public static Item purpleSpawnEggItem;
	//public static Item redSpawnEggItem;
	//public static Item blackSpawnEggItem;
	//public static Item greenSpawnEggItem;
	//public static Item yellowSpawnEggItem;
	//public static Item goldSpawnEggItem;
	//public static Item whiteSpawnEggItem;
	//public static Item blueSpawnEggItem;
	//public static Item pinkSpawnEggItem;

//	public static Item chocoDisguiseHelm;
//	public static Item chocoDisguiseChest;
//	public static Item chocoDisguiseLegs;
//	public static Item chocoDisguiseBoots;

	
	

	/*public static void register()
	{
		 
		GameRegistry.register(gysahlGreenItem);
		try {
			JsonGenerator.generateSimpleItemJson(gysahlGreenItem.getUnlocalizedName(), gysahlGreenItem instanceof ItemBlock, gysahlGreenItem);
		} catch (Exception e) {
            e.printStackTrace();
		}
		GameRegistry.register(gysahlSeedsItem);
		try {
			JsonGenerator.generateSimpleItemJson(gysahlSeedsItem.getUnlocalizedName(), gysahlSeedsItem instanceof ItemBlock, gysahlSeedsItem);
		} catch (Exception e) {
            e.printStackTrace();
		}
	}*/
	
//	public static void registerBlocks(int proxytype)
//	{
//		RegistryHelper.registerBlocks(proxytype, Constants.MODID, Additions.class);
//	}
	
	public static void register(int proxytype)
	{
		RegistryHelper.registerFieldsWithGameRegistry(proxytype, Constants.MODID, Additions.class);
		
	/*	Block block = (Block) gysahlStemBlock;
		GameRegistry.register(block, new ResourceLocation("chococraft2", block.getUnlocalizedName()));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		
    //    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(modId + ":" + block.getUnlocalizedName(), "inventory"));
		//JsonGenerator.generateSimpleBlockJson(block.getUnlocalizedName());
       
		GameRegistry.register(gysahlGreenItem);
		ModelLoader.setCustomModelResourceLocation(gysahlGreenItem, 0, new ModelResourceLocation(gysahlGreenItem.getRegistryName(), "inventory"));
		
		GameRegistry.register(gysahlSeedsItem);
		ModelLoader.setCustomModelResourceLocation(gysahlSeedsItem, 0, new ModelResourceLocation(gysahlSeedsItem.getRegistryName(), "inventory"));
		
		GameRegistry.register(gysahlGoldenItem);
		ModelLoader.setCustomModelResourceLocation(gysahlGoldenItem, 0, new ModelResourceLocation(gysahlGoldenItem.getRegistryName(), "inventory"));
		
		//String path = gysahlGreenItem.getRegistryName().toString();
		//System.out.println("path: " + path);
		//ModelLoader.setCustomModelResourceLocation(gysahlGreenItem, 0, new ModelResourceLocation(gysahlGreenItem.getRegistryName(), "inventory"));
	//	ModelLoader.setCustomModelResourceLocation(gysahlSeedsItem, 0, new ModelResourceLocation(gysahlSeedsItem.getRegistryName(), "inventory")); */
		
	}
	
//	public static void registerServer()
//	{
//		RegistryHelper.registerFieldsWithGameRegistry(1, Constants.MODID, Additions.class);
	/*	Block block = (Block) gysahlStemBlock;
		GameRegistry.register(block, new ResourceLocation("chococraft2", block.getUnlocalizedName()));
		GameRegistry.register(gysahlGreenItem);
		GameRegistry.register(gysahlSeedsItem);
		GameRegistry.register(gysahlGoldenItem);*/
		//String path = gysahlGreenItem.getRegistryName().toString();
		//System.out.println("path: " + path);
		//ModelLoader.setCustomModelResourceLocation(gysahlGreenItem, 0, new ModelResourceLocation(gysahlGreenItem.getRegistryName(), "inventory"));
	//	ModelLoader.setCustomModelResourceLocation(gysahlSeedsItem, 0, new ModelResourceLocation(gysahlSeedsItem.getRegistryName(), "inventory"));
		
//	}
	
	// Register items and blocks etc in here
//	public static void registerAdditions()
//	{
		//gysahlStemBlock = new GysahlStemBlock().setUnlocalizedName("gysahlstemblock").setCreativeTab(ChocoCreativeTabs.chococraft2);
		
		/*strawBlock = new StrawBlock().setUnlocalizedName("strawblock").setCreativeTab(ChocoCreativeTabs.chococraft2);

		
		//gysahlGreenItem = new GenericItem().setUnlocalizedName("gysahlgreenitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		gysahlSeedsItem = new GenericItemSeeds(gysahlStemBlock, Blocks.FARMLAND).setUnlocalizedName("gysahlseedsitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		gysahlGoldenItem = new GenericItem().setUnlocalizedName("gysahlgoldenitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		gysahlLoverlyItem = new GenericItem().setUnlocalizedName("gysahlloverlyitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		gysahlPinkItem = new GenericItem().setUnlocalizedName("gysahlpinkitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		gysahlRedItem = new GenericItem().setUnlocalizedName("gysahlreditem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		gysahlRawPicklesItem = new GenericItem().setUnlocalizedName("gysahlrawpicklesitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		gysahlCookedPicklesItem = new GenericItemFood(2, false).setUnlocalizedName("gysahlcookedpicklesitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		gysahlCakeItem = new GenericItem().setUnlocalizedName("gysahlcakeitem").setMaxStackSize(8).setCreativeTab(ChocoCreativeTabs.chococraft2);
		gysahlChibiItem = new GenericItem().setUnlocalizedName("gysahlchibiitem").setCreativeTab(ChocoCreativeTabs.chococraft2);

		chocoboFeatherItem = new GenericItem().setUnlocalizedName("chocobofeatheritem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		
		chocoboLegRawItem = new GenericItemFood(4, 0.3F, true).setPotionEffect(new PotionEffect(MobEffects.POISON, 30, 0), 0.3F).setUnlocalizedName("chocobolegrawitem")
		.setCreativeTab(ChocoCreativeTabs.chococraft2);
		
		*/
		/* <3 chocoboLegRawItem = new GenericItemFood(4, 0.3F, true).setPotionEffect(new PotionEffect(Potion.getPotionById(PotionType.getID(PotionTypes.poison)), 30, 0), 0.3F).setUnlocalizedName("chocoboLegRawItem")
				.setCreativeTab(ChocoCreativeTabs.chococraft2); */
	/*	chocoboLegCookedItem = new GenericItemFood(8, true).setUnlocalizedName("chocobolegcookeditem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		chocopediaItem = new GenericItem().setUnlocalizedName("chocopediaitem").setMaxStackSize(1).setCreativeTab(ChocoCreativeTabs.chococraft2);

		purpleSpawnEggItem = new SpawnEggItem(ChocoboColor.PURPLE).setUnlocalizedName("purplespawneggitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		redSpawnEggItem = new SpawnEggItem(ChocoboColor.RED).setUnlocalizedName("redspawneggitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		blackSpawnEggItem = new SpawnEggItem(ChocoboColor.BLACK).setUnlocalizedName("blackspawneggitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		greenSpawnEggItem = new SpawnEggItem(ChocoboColor.GREEN).setUnlocalizedName("greenspawneggitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		goldSpawnEggItem = new SpawnEggItem(ChocoboColor.GOLD).setUnlocalizedName("goldspawneggitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		blueSpawnEggItem = new SpawnEggItem(ChocoboColor.BLUE).setUnlocalizedName("bluespawneggitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		pinkSpawnEggItem = new SpawnEggItem(ChocoboColor.PINK).setUnlocalizedName("pinkspawneggitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		whiteSpawnEggItem = new SpawnEggItem(ChocoboColor.WHITE).setUnlocalizedName("whitespawneggitem").setCreativeTab(ChocoCreativeTabs.chococraft2);
		yellowSpawnEggItem = new SpawnEggItem(ChocoboColor.YELLOW).setUnlocalizedName("yellowspawneggitem").setCreativeTab(ChocoCreativeTabs.chococraft2);

		chocoboSaddleItem = new GenericItem().setUnlocalizedName("chocobosaddleitem").setMaxStackSize(5).setCreativeTab(ChocoCreativeTabs.chococraft2);
		chocoboSaddleBagItem = new GenericItem().setUnlocalizedName("chocobosaddlebagitem").setMaxStackSize(8).setCreativeTab(ChocoCreativeTabs.chococraft2);
		chocoboPackBagItem = new GenericItem().setUnlocalizedName("chocobopackbagitem").setMaxStackSize(8).setCreativeTab(ChocoCreativeTabs.chococraft2);
		chocoboWhistleItem = new ChocoboWhistleItem().setUnlocalizedName("chocobowhistleitem").setMaxStackSize(1).setCreativeTab(ChocoCreativeTabs.chococraft2);

		chocoDisguiseHelm = new GenericArmor(chocoDisguiseMaterial, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("chocodisguisehelm").setCreativeTab(ChocoCreativeTabs.chococraft2);
		chocoDisguiseChest = new GenericArmor(chocoDisguiseMaterial, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("chocodisguisechest").setCreativeTab(ChocoCreativeTabs.chococraft2);
		chocoDisguiseLegs = new GenericArmor(chocoDisguiseMaterial, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("chocodisguiselegs").setCreativeTab(ChocoCreativeTabs.chococraft2);
		chocoDisguiseBoots = new GenericArmor(chocoDisguiseMaterial, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("chocodisguiseboots").setCreativeTab(ChocoCreativeTabs.chococraft2);
*/
		// RegistryHelper.registerFieldsWithGameRegistry(Constants.MODID, Additions.class);
//	}

}
