package com.cob.cobmod.entities;

import com.cob.cobmod.init.ModEntityTypes;
import com.cob.cobmod.init.SoundInit;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Parasite extends MonsterEntity {

	public Parasite(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public int strength = 2;

	public Parasite createChild(AgeableEntity ageable) {
		Parasite badentity = new Parasite(ModEntityTypes.PARASITE.get(), this.world);
		badentity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(badentity)),
				SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
		return badentity;
	}
	
	@Override
	public void onKillEntity(LivingEntity entityLivingIn) {
		super.onKillEntity(entityLivingIn);
		strength += 1;
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		
		this.targetSelector.addGoal(14, new NearestAttackableTargetGoal<>(this, MobEntity.class, true));
		this.goalSelector.addGoal(8, new LookAtGoal(this, MobEntity.class, 8.0F));
		this.goalSelector.addGoal(10, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(15, new AvoidEntityGoal<>(this, Parasite.class, 10.0F, 1.0D, 1.5D));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new SwimGoal(this));
	}
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0*strength);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.50);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0*strength);
		this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(0.2*strength);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(12.0D);
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
}