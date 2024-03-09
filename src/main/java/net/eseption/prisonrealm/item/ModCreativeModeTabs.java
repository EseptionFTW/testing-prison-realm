package net.eseption.prisonrealm.item;

import net.eseption.prisonrealm.PrisonRealmMod;
import net.eseption.prisonrealm.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> Creative_Mode_Tabs =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PrisonRealmMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab>  PRISON_REALM_TAB = Creative_Mode_Tabs.register("prison_realm_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LAST_RESORT.get()))
                    .title(Component.translatable("creativetab.prison_realm_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.SEALED_PRISON_REALM.get());
                        pOutput.accept(ModBlocks.PRISON_REALM.get());
                        pOutput.accept(ModBlocks.SPENT_PRISON_REALM.get());
                        pOutput.accept(ModBlocks.SIX_EYES_PRISON_REALM.get());
                        pOutput.accept(ModBlocks.PRISON_REALM_BACK.get());
                        pOutput.accept(ModItems.LAST_RESORT.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        Creative_Mode_Tabs.register(eventBus);
    }
}
