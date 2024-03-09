package net.eseption.prisonrealm.networking;

import net.eseption.prisonrealm.PrisonRealmMod;
import net.eseption.prisonrealm.networking.packet.OpenCloseGatePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.core.jmx.Server;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetID = 0;
    private static int id() {
        return packetID++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(PrisonRealmMod.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(OpenCloseGatePacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(OpenCloseGatePacket::new)
                .encoder(OpenCloseGatePacket::toBytes)
                .consumerMainThread(OpenCloseGatePacket::handel)
                .add();

    }

    public static  <MSG> void  sentToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sentToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

}
