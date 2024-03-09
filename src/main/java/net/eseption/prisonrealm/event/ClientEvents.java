package net.eseption.prisonrealm.event;

import net.eseption.prisonrealm.PrisonRealmMod;
import net.eseption.prisonrealm.networking.ModMessages;
import net.eseption.prisonrealm.networking.packet.OpenCloseGatePacket;
import net.eseption.prisonrealm.util.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {

    @Mod.EventBusSubscriber(modid = PrisonRealmMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public  static  void  onKeyInput(InputEvent.Key event) {
            if (KeyBinding.PRISON_REALM.consumeClick()){
                ModMessages.sentToServer(new OpenCloseGatePacket());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = PrisonRealmMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public  static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.PRISON_REALM);
        }
    }

}
