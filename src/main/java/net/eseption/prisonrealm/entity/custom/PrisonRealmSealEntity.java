package net.eseption.prisonrealm.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

public class PrisonRealmSealEntity extends Monster {
    public PrisonRealmSealEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return  Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 9999)
                .add(Attributes.MOVEMENT_SPEED, 0)
                .add(Attributes.JUMP_STRENGTH, 0)
                .add(Attributes.KNOCKBACK_RESISTANCE,1.0)
                .add(Attributes.ATTACK_DAMAGE,0);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    @Override
    public boolean isPersistenceRequired() {
        return true;
    }

    @Override
    public int getPortalWaitTime() {
        return 999999999;
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean shouldDropExperience() {
        return false;
    }

    @Override
    public boolean mayInteract(Level pLevel, BlockPos pPos) {
        return super.mayInteract(pLevel, pPos);
    }

    @Override
    public boolean skipAttackInteraction(Entity pEntity) {
        return true;
    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }

    @Override
    public boolean removeAllEffects() {
        return true;
    }

    @Override
    public boolean isPushedByFluid(FluidType type) {
        return false;
    }

    @Override
    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pDimensions) {
        return pDimensions.height * 0.5f;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    protected void doPush(Entity p_20971_) {
    }
}
