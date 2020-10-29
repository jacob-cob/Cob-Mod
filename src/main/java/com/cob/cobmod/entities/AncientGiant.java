package com.cob.cobmod.entities;

import com.cob.cobmod.init.BlockInit;
import com.cob.cobmod.init.ModEntityTypes;
import com.cob.cobmod.init.SoundInit;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AncientGiant extends MonsterEntity {

	public AncientGiant(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public AncientGiant createChild(AgeableEntity ageable) {
		AncientGiant badentity = new AncientGiant(ModEntityTypes.ANCIENT_GIANT.get(), this.world);
		badentity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(badentity)),
				SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
		setGlowing(false);
		return badentity;
	}
	@Override
	protected void registerGoals() {
		super.registerGoals();
		
		this.goalSelector.addGoal(10, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(12, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(20, new NearestAttackableTargetGoal<>(this, GlowBug.class, true));
		this.goalSelector.addGoal(3, new SwimGoal(this));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(BlockInit.meat_block),false));
	}
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(5.0D);
	}
	@Override
	public void onStruckByLightning(LightningBoltEntity lightningBolt) {
		this.setNoAI(true);
	}
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.ANCIENT_GIANT_AMBIENT.get();
	}
	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.ANCIENT_GIANT_DEATH.get();
	}
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.ANCIENT_GIANT_HURT.get();
	}
}
