package net.eseption.prisonrealm.event;

import net.eseption.prisonrealm.PrisonRealmMod;

import net.eseption.prisonrealm.entity.ModEntities;
import net.eseption.prisonrealm.entity.custom.PrisonRealmEntity;
import net.eseption.prisonrealm.entity.custom.PrisonRealmSealEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PrisonRealmMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.PRISON_REALM.get(), PrisonRealmEntity.createAttributes().build());
        event.put(ModEntities.PRISON_REALM_SEAL.get(), PrisonRealmSealEntity.createAttributes().build());
    }
}
