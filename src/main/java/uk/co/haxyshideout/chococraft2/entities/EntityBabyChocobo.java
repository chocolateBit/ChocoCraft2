package uk.co.haxyshideout.chococraft2.entities;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import uk.co.haxyshideout.chococraft2.ChocoCraft2;
import uk.co.haxyshideout.chococraft2.config.Additions;
import uk.co.haxyshideout.chococraft2.config.Constants;
import uk.co.haxyshideout.chococraft2.entities.EntityChocobo.ChocoboColor;

public class EntityBabyChocobo extends EntityAnimal
{
	private static final DataParameter<Byte> dataWatcherVariant = EntityDataManager.<Byte> createKey(EntityBabyChocobo.class, DataSerializers.BYTE);
	
	private int ticksExisted;
	public EntityChocobo parent1;
	public EntityChocobo parent2;

	public EntityBabyChocobo(World worldIn)
	{
		super(worldIn);
		this.setSize(0.5f, 0.5f);
		this.tasks.addTask(2, new EntityAIWander(this, this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
		this.tasks.addTask(3, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMob.class, true));
	}
	
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		this.ticksExisted++;
		//System.out.println(this.ticksExisted);

		if (this.ticksExisted >= ChocoCraft2.instance.getConfig().getTicksToAdult() && !this.world.isRemote)
		{
			growUp();
		}
	}

	private void growUp()
	{
		this.setDead();
		EntityChocobo chocobo = new EntityChocobo(this.world);
		chocobo.setColor(this.getChocoboColor());
		chocobo.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
		this.world.spawnEntity(chocobo);
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		if (world.isRemote)// return if client
			return false;

		if (player.getHeldItem(hand) == null)// Make sure the player is holding something for the following checks
			return false;

		if (player.getHeldItem(hand).getItem() == Additions.gysahlCakeItem)
		{
			this.consumeItemFromStack(player, player.inventory.getCurrentItem());
			growUp();
		}

		return true;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable)
	{
		return null;
	}

	public void setColor(ChocoboColor color)
	{
		dataManager.set(dataWatcherVariant, Byte.valueOf((byte)color.ordinal()) );
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound)
	{
		super.writeEntityToNBT(tagCompound);
		tagCompound.setByte("Color", (byte) getChocoboColor().ordinal());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompound)
	{
		super.readEntityFromNBT(tagCompound);
		setColor(ChocoboColor.values()[tagCompound.getByte("Color")]);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();

		// corresponding to enum.ordinal
		this.dataManager.register(dataWatcherVariant, Byte.valueOf((byte)0));
	}

	public boolean isTamed()
	{
		return false;
	}

	public boolean isMale()
	{
		return true;
	}

	public ChocoboColor getChocoboColor()
	{
		return ChocoboColor.values()[dataManager.get(dataWatcherVariant)];
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return SoundEvent.REGISTRY.getObject(new ResourceLocation(Constants.MODID, "choco_kweh"));
	}

	@Override
	protected SoundEvent getHurtSound()
	{
		return SoundEvent.REGISTRY.getObject(new ResourceLocation(Constants.MODID, "choco_kweh"));
	}

	@Override
	protected SoundEvent getAmbientSound()
	{
		if (rand.nextInt(4) == 0)
			return SoundEvent.REGISTRY.getObject(new ResourceLocation(Constants.MODID, "choco_kweh"));

		return null;
	}
}
