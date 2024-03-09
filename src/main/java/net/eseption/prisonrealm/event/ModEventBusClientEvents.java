package net.eseption.prisonrealm.event;


import net.eseption.prisonrealm.PrisonRealmMod;
import net.eseption.prisonrealm.entity.client.ModModelLayers;
import net.eseption.prisonrealm.entity.client.PrisonRealmModel;
import net.eseption.prisonrealm.entity.client.PrisonRealmSealModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PrisonRealmMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.PRISON_REALM, PrisonRealmModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.PRISON_REALM_SEAL, PrisonRealmSealModel::createBodyLayer);
    }
}
