package net.eseption.prisonrealm.entity;

import net.eseption.prisonrealm.PrisonRealmMod;
import net.eseption.prisonrealm.entity.custom.PrisonRealmEntity;
import net.eseption.prisonrealm.entity.custom.PrisonRealmSealEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public  static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PrisonRealmMod.MOD_ID);

    public static final RegistryObject<EntityType<PrisonRealmEntity>> PRISON_REALM =
            ENTITY_TYPES.register("prison_realm_entity", () -> EntityType.Builder.of(PrisonRealmEntity::new, MobCategory.MISC)
                    .sized(1.5f,2.5f)
                    .fireImmune()
                    .canSpawnFarFromPlayer()
                    .build("prison_realm_entity"));
    public static final RegistryObject<EntityType<PrisonRealmSealEntity>> PRISON_REALM_SEAL =
            ENTITY_TYPES.register("prison_realm_seal_entity", () -> EntityType.Builder.of(PrisonRealmSealEntity::new, MobCategory.MISC)
                    .sized(3.5f,2.0f)
                    .fireImmune()
                    .canSpawnFarFromPlayer()
                    .build("prison_realm_seal_entity"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
