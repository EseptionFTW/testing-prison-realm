package net.eseption.prisonrealm.networking.packet;

import net.eseption.prisonrealm.block.ModBlocks;
import net.eseption.prisonrealm.block.custom.SealedPrisonRealmBlock;
import net.eseption.prisonrealm.block.entity.ModBlockEntities;
import net.eseption.prisonrealm.block.entity.SealedPrisonRealmBlockEntity;
import net.eseption.prisonrealm.entity.ModEntities;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class OpenCloseGatePacket {
    public OpenCloseGatePacket() {

    }

    public OpenCloseGatePacket(FriendlyByteBuf buf) {

    }

    public void  toBytes(FriendlyByteBuf buf) {

    }

    public boolean handel(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // On Server
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();
            UUID gateUUID = null;

            if(isNearBoundPrisonRealm(player, level)){
                //Destroy Sealed Prison Realm Block


                //level.setBlock(gatePos(player, level),ModBlocks.PRISON_REALM.get().defaultBlockState(), 3);

                level.destroyBlock(gatePos(player, level),false);

                //Summon Prison Realm Entity


                spawnPrisonRealmEntity(player, level);



                gateUUID = ModEntities.PRISON_REALM.get().spawn(level, gatePos(player, level), MobSpawnType.TRIGGERED).getUUID();


                //ModEntities.PRISON_REALM.get().spawn(level,player.blockPosition(),MobSpawnType.TRIGGERED);

                //Send Realm Message In Chat

                player.sendSystemMessage((Component.literal("Prison Realm : Gate Open").withStyle(ChatFormatting.DARK_RED)));
                //player.sendSystemMessage((Component.literal(gatePos(player, level).toString()).withStyle(ChatFormatting.WHITE)));

                //Play Prison Realm Opening Sound

                level.playSound(null, gatePos(player, level), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.BLOCKS);

                //level.playSound(null, gatePos(player,level), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.BLOCKS);
                //level.playSound(null, gatePos(player,level), SoundEvents.WARDEN_HEARTBEAT, SoundSource.BLOCKS);

            }
            else if(isNearBoundOpenPrisonRealm(player, level)) {
                //Place Prison Realm Block At Prison Realm Entity Location

                level.setBlock(gatePos(player, level),ModBlocks.PRISON_REALM.get().defaultBlockState(), 3);

                // De-summon Prison Realm Entity

                level.getEntity(gateUUID).discard();


                //   List<T>      level.getEntitiesOfClass(ModEntities.PRISON_REALM.get().getBaseClass(), player.getBoundingBox().inflate(8));
                //    level.getEntities().get(ModEntities.PRISON_REALM.get(),player.getBoundingBox().inflate(8),null);

                //level.getEntity(4).discard();

                //Send Realm Message In Chat

                player.sendSystemMessage((Component.literal("Prison Realm : Gate Close").withStyle(ChatFormatting.DARK_RED)));

                //Play Prison Realm Closing Sound

                level.playSound(null,gatePos(player,level), SoundEvents.WARDEN_HEARTBEAT, SoundSource.BLOCKS);

            }
            else if(isNearBoundSealingPrisonRealm(player,level)) {
                //De-summon Prison Realm Seal Entity


                //End Effect On Sealed Target

                //Place Spent Prison Realm Block



                //Send Realm Message In Chat

                player.sendSystemMessage((Component.literal("Prison Realm : Gate Close").withStyle(ChatFormatting.DARK_RED)));

                //Play Prison Realm Closing Sound

                level.playSound(null,gatePos(player,level), SoundEvents.WARDEN_HEARTBEAT, SoundSource.BLOCKS);

            }
            else{
                //If Player Does Not Own A Prison Realm
                if(hasBoundPrisonRealm(player,level)) {

                }

                //If Player Is Out Of Range Of Bound Prison Realm
                if(!isNearBoundPrisonRealm(player,level)) {

                    //Return Out Of Range


                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        return true;
    }

    private void spawnPrisonRealmEntity(ServerPlayer player, ServerLevel level) {

        /*
        UUID gateUUID = null;

        gateUUID = ModEntities.PRISON_REALM.get().spawn(level, gatePos(player, level), MobSpawnType.TRIGGERED).getUUID();

         */
    }

    private boolean hasBoundPrisonRealm(ServerPlayer player, ServerLevel level) {
        return false;
    }

    private boolean isNearBoundSealingPrisonRealm(ServerPlayer player, ServerLevel level) {
        return false;
    }

    private boolean isNearBoundOpenPrisonRealm(ServerPlayer player, ServerLevel level) {




        return false;
    }

    private boolean isNearBoundPrisonRealm(ServerPlayer player, ServerLevel level) {

        CompoundTag pTag = new CompoundTag();
        String idValue;

        idValue = level.getBlockEntity(gatePos(player, level)).serializeNBT().getString("prisonrealm.block_uuid");

        if (player.getStringUUID() == idValue) {
            return true;
        } else {
            return false;
        }

        /*
        return level.getBlockStates(player.getBoundingBox().inflate(32))
                .filter(state -> state.is(ModBlocks.SEALED_PRISON_REALM.get())).toArray().length > 0;
         */
        //level.getBlockEntity()

        //SealedPrisonRealmBlockEntity.getPosFromTag()

        //SealedPrisonRealmItem sealedPrisonRealmItem = new SealedPrisonRealmItem(ModItems.SEALED_PRISON_REALM_ITEM.get().getBlock(),null);

        //level.getBlockStates(player.getBoundingBox().inflate(16))
        //        .filter(state -> state.is(ModBlocks.SEALED_PRISON_REALM.get()));

    }

    //pPlayer.teleportTo(pPlayer.getServer().getLevel(END),0,90,0,new TreeSet<>(),0,0);

    //pPlayer.changeDimension(pPlayer.getServer().getLevel(END));

    //pPlayer.addEffect(new MobEffectInstance(ModEffects.SEALING.get(), -1,9),pPlayer);
    //pPlayer.forceAddEffect(new MobEffectInstance(ModEffects.SEALING.get(), -1, 9), pPlayer);
    //pPlayer.getItemInHand(pUsedHand).setTag(new CompoundTag());

    public BlockPos gatePos(ServerPlayer player, ServerLevel level) {
        BlockPos blockPos = null;
        /*
        level.getBlockStates(player.getBoundingBox().inflate(8))
                .filter(state -> state.is(ModBlocks.SEALED_PRISON_REALM.get())).toList().get(0);

        level.onBlockStateChange(null,level.getBlockStates(player.getBoundingBox().inflate(8))
                .filter(state -> state.is(ModBlocks.SEALED_PRISON_REALM.get())).toList().get(0), null);

        CompoundTag pTag = new CompoundTag();
        pTag.putString("prisonrealm.block_uuid", player.getStringUUID());


        BlockPos blockPos = SealedPrisonRealmBlockEntity.getPosFromTag(pTag);

        player.sendSystemMessage((Component.literal(Integer.toString(blockPos.getX()) +Integer.toString(blockPos.getY()) + Integer.toString(blockPos.getZ()))));


        level.getBlockStates(player.getBoundingBox().inflate(32))
                .filter(state -> state.is(ModBlocks.SEALED_PRISON_REALM.get())).toList().get(0);


        boolean a = ModBlockEntities.SEALED_PRISON_REALM_BLOCK_ENTITY.get() instanceof SealedPrisonRealmBlockEntity sealedBlockEntity;


         */
        if (ModBlocks.SEALED_PRISON_REALM.get() instanceof SealedPrisonRealmBlock sealedBlock) {
            blockPos = sealedBlock.blockPos;
        }

        //level.getBlockEntity(blockPos);






        //      ModEntities.PRISON_REALM.get().getTags().filter()

        return blockPos;
    }


    public BlockPos sealPos(Player player, Level level) {

        //level.getEntities(ModEntities.PRISON_REALM_SEAL.get().create(level), player.getBoundingBox().inflate(8)).get(0).getOnPos().above();

        BlockPos blockPos = null;
        return blockPos;
    }

    public BlockPos targetPos() {

        BlockPos blockPos = null;
        return blockPos;
    }


    public BlockPos nearestBoundPrisonRealmPos(ServerPlayer player, ServerLevel level) {


        level.getBlockStates(player.getBoundingBox().inflate(16))
                .filter(state -> state.is(ModBlocks.SEALED_PRISON_REALM.get())).toList();



        return null;
    }
}
