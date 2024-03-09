package net.eseption.prisonrealm.effect;

import net.eseption.prisonrealm.item.ModItems;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import java.util.HashSet;
import static net.minecraft.world.level.Level.NETHER;


public class SealingEffect extends MobEffect {
    public SealingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        pLivingEntity.setSpeed(0);

        if (pLivingEntity.getEffect(ModEffects.SEALING.get()).getDuration() == 1) {
            pLivingEntity.removeEffect(ModEffects.SEALING.get());



            if (!pLivingEntity.level().isClientSide()) {
                pLivingEntity.teleportTo(pLivingEntity.getServer().getLevel(NETHER),0,15,0,new HashSet<>(),0,0);
                pLivingEntity.spawnAtLocation(ModItems.LAST_RESORT.get());
                pLivingEntity.clearSleepingPos();
                pLivingEntity.setSleepingPos(pLivingEntity.getOnPos());
            }
        }

        if (!pLivingEntity.level().isClientSide()) {
            pLivingEntity.setDeltaMovement(0, 0, 0);
            pLivingEntity.setOnGround(true);
            pLivingEntity.setShiftKeyDown(true);
            pLivingEntity.setJumping(false);
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2,100));
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 2,100));
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 2,150));

        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
