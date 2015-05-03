package uk.co.haxyshideout.chococraft2.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import uk.co.haxyshideout.chococraft2.config.Constants;

/**
 * Created by clienthax on 14/4/2015.
 */
public class EntityChocobo extends EntityTameable {

	public float wingRotation;
	public float destPos;
	private float wingRotDelta;

	public static enum chocoboColor
	{
		YELLOW,
		GREEN,
		BLUE,
		WHITE,
		BLACK,
		GOLD,
		PINK,
		RED,
		PURPLE
	}

	public EntityChocobo(World world) {
		super(world);
		this.setSize(1.3f, 1.9f);

		((PathNavigateGround)this.getNavigator()).setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAIWander(this, 1.0D));
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();

		//Wing rotations, client side
		if(worldObj.isRemote) {//Client side..
			this.destPos += (double)(this.onGround ? -1 : 4) * 0.3D;
			this.destPos = MathHelper.clamp_float(destPos, 0f, 1f);

			if (!this.onGround)
			{
				this.wingRotDelta = Math.min(wingRotation, 1f);
			}

			this.wingRotDelta *= 0.9D;

			if (!this.onGround && this.motionY < 0.0D)
			{
				this.motionY *= 0.8D;
			}
			this.wingRotation += this.wingRotDelta * 2.0F;
		}

	}

	@Override
	protected void entityInit() {
		super.entityInit();
		//corresponding to enum.ordinal
		this.dataWatcher.addObject(Constants.dataWatcherVariant, Integer.valueOf(0));//Should this be stored in nbt instead?
		//0 for no bag, 1 for saddlebag, 2 for pack bag
		this.dataWatcher.addObject(Constants.dataWatcherBagType, Byte.valueOf((byte)0));
		//1 if saddled, 0 if not
		this.dataWatcher.addObject(Constants.dataWatcherSaddled, Byte.valueOf((byte)0));
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}

	@Override
	protected String getDeathSound() {
		return "chococraft2:choco_kweh";
	}

	@Override
	protected String getHurtSound() {
		return "chococraft2:choco_kweh";
	}

	@Override
	protected String getLivingSound() {
		if(rand.nextInt(4) == 0)
			return "chococraft2:choco_kweh";

		return null;
	}

	/**
	 * Get number of ticks, at least during which the living entity will be silent.
	 */
	@Override
	public int getTalkInterval() {
		return 150;
	}

	public boolean interact(EntityPlayer player) {
		if(isSaddled()) {
			player.mountEntity(this);
			return true;
		} else
		//dataWatcher.updateObject(Constants.dataWatcherSaddled, (byte)1);//TEST LINE
		jump();

		return false;
	}

	public boolean isSaddled() {
		return dataWatcher.getWatchableObjectByte(Constants.dataWatcherSaddled) == 1;
	}

	@Override
	public float getJumpUpwardsMotion() {
		return 1f;
	}




}
