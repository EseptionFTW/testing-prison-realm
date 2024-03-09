package net.eseption.prisonrealm.entity.custom;

import net.eseption.prisonrealm.effect.ModEffects;
import net.eseption.prisonrealm.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.function.Predicate;

public class PrisonRealmEntity extends Monster {
    protected static final int SEAL_TIME = 600;
    private static final EntityDataAccessor<Integer> DATA_ID_SEAL_TARGET =  SynchedEntityData.defineId(PrisonRealmEntity.class, EntityDataSerializers.INT);

    @Nullable
    private LivingEntity clientSideCachedSealTarget;
    private int clientSideSealTime;

    public PrisonRealmEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 9999)
                .add(Attributes.FOLLOW_RANGE, 5)
                .add(Attributes.MOVEMENT_SPEED,0)
                .add(Attributes.KNOCKBACK_RESISTANCE,1.0)
                .add(Attributes.ATTACK_DAMAGE,0);

    }

    protected void registerGoals() {
        //this.goalSelector.addGoal(3,new LookAtPlayerGoal(this, Player.class,4.0f));
        //this.goalSelector.addGoal(4,new LookAtPlayerGoal(this, LivingEntity.class,4.0f));
        this.goalSelector.addGoal(2, new PrisonRealmEntity.PrisonEntityGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this,LivingEntity.class,1,false,false,new PrisonRealmEntity.PrisonEntitySelector(this)));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_SEAL_TARGET,0);
    }

    public int getSealDuration() {
        return 80;
    }

    @Override
    public MobType getMobType() {return MobType.UNDEFINED;}

    public float getClientsideSealTime() {return (float)this.clientSideSealTime;}

    void setActiveSealTarget(int pActiveSealTargetId) {
        this.entityData.set(DATA_ID_SEAL_TARGET, pActiveSealTargetId);
    }

    public boolean hasActiveSealTarget() {return this.entityData.get(DATA_ID_SEAL_TARGET) != 0;}

    @Nullable
    public LivingEntity getActiveSealTarget() {
        if (!this.hasActiveSealTarget()) {
            return null;
        } else if (this.level().isClientSide) {
            if (this.clientSideCachedSealTarget != null) {
                return this.clientSideCachedSealTarget;
            } else {
                Entity entity = this.level().getEntity(this.entityData.get(DATA_ID_SEAL_TARGET));
                if (entity instanceof  LivingEntity) {
                    this.clientSideCachedSealTarget = (LivingEntity)entity;
                    return  this.clientSideCachedSealTarget;
                } else {
                    return null;
                }
            }
        } else {
            return this.getTarget();
        }
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        super.onSyncedDataUpdated(pKey);
        if (DATA_ID_SEAL_TARGET.equals(pKey)) {
            this.clientSideSealTime = 0;
            this.clientSideCachedSealTarget = null;
        }
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    @Override
    public void checkDespawn() {
        super.checkDespawn();
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
    public void aiStep() {
        if (this.isAlive()) {
            if (this.level().isClientSide) {
                if (this.hasActiveSealTarget()) {
                    if (this.clientSideSealTime < this.getSealDuration()) {
                        ++this.clientSideSealTime;
                    }

                    LivingEntity livingEntity = this.getActiveSealTarget();
                    if (livingEntity != null) {
                        this.getLookControl().setLookAt(livingEntity,90.0f,90.0f);
                        this.getLookControl().tick();
                    }
                }
            }
        }
        super.aiStep();
    }

    static class PrisonEntityGoal extends Goal {
        private final PrisonRealmEntity prisonEntity;
        private int sealTime;

        public PrisonEntityGoal(PrisonRealmEntity prisonRealmEntity) {
            this.prisonEntity = prisonRealmEntity;
            this.setFlags(EnumSet.of(Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            LivingEntity livingEntity = this.prisonEntity.getTarget();
            return livingEntity != null && livingEntity.isAlive();
        }

        @Override
        public boolean canContinueToUse() {
            return super.canContinueToUse() && (this.prisonEntity.getTarget() != null && this.prisonEntity.distanceToSqr(this.prisonEntity.getTarget()) > 5.00);
        }

        @Override
        public void start() {
            this.sealTime = -10;
            this.prisonEntity.getNavigation().stop();
            LivingEntity livingEntity = this.prisonEntity.getTarget();
            if (livingEntity != null) {
                this.prisonEntity.getLookControl().setLookAt(livingEntity, 90.0f,90.0f);
        }
            //this.prisonEntity.hasImpulse = false;
    }

        @Override
        public void stop() {
            this.prisonEntity.setActiveSealTarget(0);
            this.prisonEntity.setTarget((LivingEntity)null);
        }

        @Override
        public boolean requiresUpdateEveryTick() {return true;}

        @Override
        public void tick() {
            LivingEntity livingEntity = this.prisonEntity.getTarget();
            Level worldLevel = livingEntity.level();
            if (livingEntity != null){
                //this.prisonEntity.getNavigation().stop();
                this.prisonEntity.getLookControl().setLookAt(livingEntity,90.0f,90.0f);
                if (!this.prisonEntity.hasLineOfSight(livingEntity)) {
                    this.prisonEntity.setTarget((LivingEntity)null);
                } else {
                    ++this.sealTime;
                    if (this.sealTime == 0) {
                        this.prisonEntity.setActiveSealTarget((livingEntity).getId());
                        if (!this.prisonEntity.isSilent()) {
                            this.prisonEntity.level().broadcastEntityEvent(this.prisonEntity,(byte)21);
                        }
                    } else if (this.sealTime >= this.prisonEntity.getSealDuration()) {
                        float f = 1.0f;
                        //livingEntity.forceAddEffect(new MobEffectInstance(ModEffects.SEALING.get(),-1,9),livingEntity);
                        livingEntity.addEffect(new MobEffectInstance(ModEffects.SEALING.get(), -1,9));
                        ModEntities.PRISON_REALM_SEAL.get().spawn((ServerLevel) worldLevel,livingEntity.blockPosition(),MobSpawnType.TRIGGERED);
                        this.prisonEntity.setTarget((LivingEntity)null);
                        this.prisonEntity.discard();
                    }
                    super.tick();
                }

            }

        }
    }

    static class PrisonEntitySelector implements Predicate<LivingEntity> {
        private final PrisonRealmEntity prisonEntity;

        public PrisonEntitySelector(PrisonRealmEntity prisonRealmEntity) {
            this.prisonEntity = prisonRealmEntity;
        }

        @Override
        public boolean test(@Nullable LivingEntity livingEntity) {
            return (livingEntity instanceof Player || livingEntity instanceof LivingEntity) && livingEntity.distanceToSqr(this.prisonEntity) > 5.00;
        }
    }

}
