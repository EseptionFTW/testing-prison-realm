package net.eseption.prisonrealm.block;

import net.eseption.prisonrealm.PrisonRealmMod;
import net.eseption.prisonrealm.block.custom.*;
import net.eseption.prisonrealm.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PrisonRealmMod.MOD_ID);

    public static final RegistryObject<Block> SEALED_PRISON_REALM = registerBlock("sealed_prison_realm",
            () -> new SealedPrisonRealmBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.WART_BLOCK)));
    public static final RegistryObject<Block> PRISON_REALM = registerBlock("prison_realm",
            () -> new PrisonRealmBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.WART_BLOCK).noParticlesOnBreak()));
    public static final RegistryObject<Block> SPENT_PRISON_REALM = registerBlock("spent_prison_realm",
            () -> new SpentPrisonRealmBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.NETHERITE_BLOCK).noParticlesOnBreak()));
    public static final RegistryObject<Block> SIX_EYES_PRISON_REALM = registerBlock("six_eyes_prison_realm",
            () -> new SixEyesPrisonRealmBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.NETHERITE_BLOCK).noParticlesOnBreak()));
    public static final RegistryObject<Block> PRISON_REALM_BACK = registerBlock("prison_realm_back",
            () -> new PrisonRealmBackBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.WART_BLOCK).noParticlesOnBreak()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
