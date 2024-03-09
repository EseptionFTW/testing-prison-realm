package net.eseption.prisonrealm.block.entity;

import net.eseption.prisonrealm.PrisonRealmMod;
import net.eseption.prisonrealm.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PrisonRealmMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<SealedPrisonRealmBlockEntity>> SEALED_PRISON_REALM_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("sealed_prison_realm_block_entity", () ->
                    BlockEntityType.Builder.of(SealedPrisonRealmBlockEntity::new,
                            ModBlocks.SEALED_PRISON_REALM.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
