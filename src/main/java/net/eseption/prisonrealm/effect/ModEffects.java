package net.eseption.prisonrealm.effect;

import net.eseption.prisonrealm.PrisonRealmMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PrisonRealmMod.MOD_ID);

    public static final RegistryObject<MobEffect> SEALING = MOB_EFFECTS.register("sealing",
            ()-> new SealingEffect(MobEffectCategory.NEUTRAL, 000000000));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
