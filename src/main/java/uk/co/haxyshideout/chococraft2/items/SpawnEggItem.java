package uk.co.haxyshideout.chococraft2.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import uk.co.haxyshideout.chococraft2.entities.EntityChocobo;
import uk.co.haxyshideout.chococraft2.entities.EntityChocobo.ChocoboColor;
import uk.co.haxyshideout.haxylib.items.ModItem;
import uk.co.haxyshideout.haxylib.utils.RandomHelper;

/**
 * Created by clienthax on 2/6/2015.
 */
public class SpawnEggItem extends ModBaseItem {

    private ChocoboColor mobColor;
    
    public SpawnEggItem(ChocoboColor mobColor, String name, CreativeTabs tab)
    {
        super(name, tab);
        
        this.mobColor = mobColor;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
    	ItemStack itemstack = player.getHeldItem(hand);
    	
       /* if (!player.capabilities.isCreativeMode)
            itemstack.stackSize--; */

        if (!player.world.isRemote && !player.capabilities.isFlying) {
            player.world.playSound(player, player.getPosition(), new SoundEvent(new ResourceLocation("random.bow")), SoundCategory.AMBIENT, 0.5F, 0.4F / (RandomHelper.random.nextFloat() * 0.4f + 0.8f));
            EntityChocobo entity = new EntityChocobo(player.world);
            entity.setColor(mobColor);
            entity.setLocationAndAngles(player.posX, player.posY, player.posZ, player.cameraYaw, player.cameraPitch);
            player.world.spawnEntity(entity);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

}
