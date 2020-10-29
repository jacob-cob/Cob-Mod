package com.cob.cobmod.entities;

import com.cob.cobmod.init.ModEntityTypes;
import com.cob.cobmod.init.SoundInit;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GlowBug extends AnimalEntity {

	public GlowBug(EntityType<? extends AnimalEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public GlowBug createChild(AgeableEntity ageable) {
		GlowBug badentity = new GlowBug(ModEntityTypes.GLOW_BUG.get(), this.world);
		badentity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(badentity)),
				SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
		setGlowing(true);
		return badentity;
	}
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(50, new PanicGoal(this, 10.0F));
		this.goalSelector.addGoal(50, new AvoidEntityGoal<>(this, AncientGiant.class, 10.0F, 1.0D, 1.5D));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(Items.PAPER),false));
	}
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.50D);
	}
	@Override
	public void onStruckByLightning(LightningBoltEntity lightningBolt) {
		this.setInvisible(true);
	}
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.AMBIENT.get();
	}
	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.DEATH.get();
	}
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.HURT.get();
	}
	
	@Override
	public boolean isGlowing() {
		return true;
	}
}