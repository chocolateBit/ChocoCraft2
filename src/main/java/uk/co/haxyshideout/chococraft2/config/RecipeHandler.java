package uk.co.haxyshideout.chococraft2.config;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import uk.co.haxyshideout.haxylib.utils.RecipeHelper;

/**
 * Created by clienthax on 13/4/2015.
 */
public class RecipeHandler {

	public static void registerRecipies() {
		//Recipe to make 3 seeds from a gysahl green
		GameRegistry.addShapelessRecipe(new ItemStack(Additions.gysahlSeedsItem, 3), new ItemStack(Additions.gysahlGreenItem));

		//Add saddle recipe
		GameRegistry.addShapedRecipe(
				new ItemStack(Additions.chocoboSaddleItem),
				"   ",
				"sls",
				" f ",
				's', Items.STRING,
				'l', Items.LEATHER,
				'f', Additions.chocoboFeatherItem
		);

		//Saddle Bag
		GameRegistry.addShapedRecipe(
				new ItemStack(Additions.chocoboSaddleBagItem),
				" f ",
				"l l",
				" l ",
				'l', Items.LEATHER,
				'f', Additions.chocoboFeatherItem
		);

		//Pack Bag
		GameRegistry.addShapedRecipe(
				new ItemStack(Additions.chocoboPackBagItem),
				"sfs",
				"w w",
				"sls",
				's', Items.STRING,
				'l', Items.LEATHER,
				'f', Additions.chocoboFeatherItem,
				'w', Blocks.WOOL
		);

		//Whistle
		GameRegistry.addShapedRecipe(
				new ItemStack(Additions.chocoboWhistleItem),
				"   ",
				" g ",
				" f ",
				'g', Items.GOLD_INGOT,
				'f', Additions.chocoboFeatherItem
		);

		//Gysahl Cake
		GameRegistry.addShapedRecipe(
				new ItemStack(Additions.gysahlCakeItem),
				"bgb",
				"ses",
				"wgw",
				'b', Items.MILK_BUCKET,
				'g', Additions.gysahlGreenItem,
				's', Items.SUGAR,
				'e', Items.EGG,
				'w', Items.WHEAT
		);

		//Raw Pickles
		GameRegistry.addShapelessRecipe(
				new ItemStack(Additions.gysahlRawPicklesItem),
				Additions.gysahlGreenItem,
				Items.SUGAR
		);

		//Straw
		GameRegistry.addShapelessRecipe(
				new ItemStack(Additions.strawBlock, 4),
				new ItemStack(Items.WHEAT, 2)
		);

		//Alternative arrow recipe
		GameRegistry.addShapedRecipe(
				new ItemStack(Items.ARROW, 4),
				"f  ",
				"s  ",
				"c  ",
				'f', Items.FLINT,
				's', Items.STICK,
				'c', Additions.chocoboFeatherItem
		);

		//Chocopedia
		GameRegistry.addShapedRecipe(
				new ItemStack(Additions.chocopediaItem),
				"fnf",
				"ibi",
				"flf",
				'f', Additions.chocoboFeatherItem,
				'n', Items.GOLD_NUGGET,
				'i', new ItemStack(Items.DYE, 1, 0),
				'b', Items.BOOK,
				'l', new ItemStack(Items.DYE, 1, 4)
		);

		//Chocobo disguise
		RecipeHelper.makeHelmRecipe(Additions.chocoDisguiseHelm, Additions.chocoboFeatherItem);
		RecipeHelper.makePlateRecipe(Additions.chocoDisguiseChest, Additions.chocoboFeatherItem);
		RecipeHelper.makeLegsRecipe(Additions.chocoDisguiseLegs, Additions.chocoboFeatherItem);
		RecipeHelper.makeBootsRecipe(Additions.chocoDisguiseBoots, Additions.chocoboFeatherItem);

		//Cooking
		GameRegistry.addSmelting(Additions.chocoboLegRawItem, new ItemStack(Additions.chocoboLegCookedItem), 1f);
		GameRegistry.addSmelting(Additions.gysahlRawPicklesItem, new ItemStack(Additions.gysahlCookedPicklesItem), 1f);

		//Gysahls
		GameRegistry.addRecipe(new ShapelessOreRecipe(
				new ItemStack(Additions.gysahlRedItem),
				Additions.gysahlGreenItem,
				"dyeRed"
		));
		GameRegistry.addRecipe(new ShapelessOreRecipe(
				new ItemStack(Additions.gysahlPinkItem),
				Additions.gysahlGreenItem,
				"dyePink"
		));

	}
}
