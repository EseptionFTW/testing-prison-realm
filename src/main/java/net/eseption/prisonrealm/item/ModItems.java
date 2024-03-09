package net.eseption.prisonrealm.item;

import net.eseption.prisonrealm.PrisonRealmMod;
import net.eseption.prisonrealm.block.ModBlocks;
import net.eseption.prisonrealm.item.custom.LastResortItem;
import net.eseption.prisonrealm.item.custom.SealedPrisonRealmItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PrisonRealmMod.MOD_ID);

    public static final RegistryObject<Item> LAST_RESORT = ITEMS.register("last_resort",
            () -> new LastResortItem(new Item.Properties().food(LastResortItem.LASTRESORT)));
    public static final RegistryObject<BlockItem> SEALED_PRISON_REALM_ITEM = ITEMS.register("sealed_prison_realm_item",
            ()-> new SealedPrisonRealmItem(ModBlocks.SEALED_PRISON_REALM.get(), new Item.Properties().fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
