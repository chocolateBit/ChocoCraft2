package uk.co.haxyshideout.haxylib.utils;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.ResourceLocation;

/**
 * Created by clienthax on 12/4/2015.
 */
public class RegistryHelper {

    public static void addEntityEgg() {

    }

    public static void registerFieldsWithGameRegistry(int proxytype, String modid, Class clazz) {
      
    	try {
          //  JsonGenerator.setModID(modid);
            for (Field field : clazz.getFields()) {
                if (field.get(null) instanceof Block) {
                    
                	Block block = (Block) field.get(null);
                    ItemBlock itemBlock = new ItemBlock(block);
                    GameRegistry.register(block, new ResourceLocation(modid, block.getUnlocalizedName()));
                    GameRegistry.register(itemBlock, new ResourceLocation(modid, itemBlock.getUnlocalizedName()));
                    
                    if (proxytype == 0){
                    	ResourceLocation regName = block.getRegistryName();
                    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(regName, "inventory"));
                    }
                    
                } else if (field.get(null) instanceof Item) {
                   
                	Item item = (Item) field.get(null);
                   
                	GameRegistry.register(item);
                	if (proxytype == 0){
                		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
                	}
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*    public static void registerBlocks(int proxytype, String modid, Class clazz) {
        
    	try {
          //  JsonGenerator.setModID(modid);
            for (Field field : clazz.getFields()) {
                if (field.get(null) instanceof Block) {
                    
                	Block block = (Block) field.get(null);
                    
                    GameRegistry.register(block, new ResourceLocation(modid, block.getUnlocalizedName()));
                    
                    if (proxytype == 0){
                    	ResourceLocation regName = block.getRegistryName();
                    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(regName, "inventory"));
                    }
                    
                }
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

/*    @SideOnly(Side.CLIENT)
    public static void registerRenderers(Class clazz, String modId) {
    	
        try {
            for (Field field : clazz.getFields()) {
                if (field.get(null) instanceof Block) {
                    Block block = (Block) field.get(null);
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(modId + ":" + block.getUnlocalizedName(), "inventory"));
                    
                } else if (field.get(null) instanceof Item) {
                	
                    Item item = (Item) field.get(null);
                    String path = item.getRegistryName().toString();
                	
        			System.out.println("path: " + path);
        			
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(modId + ":" + item.getUnlocalizedName(), "inventory"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
