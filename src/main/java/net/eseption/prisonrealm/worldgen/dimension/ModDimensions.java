package net.eseption.prisonrealm.worldgen.dimension;

import net.eseption.prisonrealm.PrisonRealmMod;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.List;
import java.util.OptionalLong;

public class ModDimensions {
    public static final ResourceKey<LevelStem> PRISON_REALM_DIM_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(PrisonRealmMod.MOD_ID, "prison_realmdim"));
    public static final ResourceKey<Level> PRISON_REALM_DIM_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(PrisonRealmMod.MOD_ID, "prison_realmdim"));
    public static final ResourceKey<DimensionType> PRISON_REALM_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(PrisonRealmMod.MOD_ID, "prison_realmdim_type"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(PRISON_REALM_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000),
                false,
                true,
                false,
                false,
                1,
                true,
                true,
                0,
                64,
                64,
                BlockTags.INFINIBURN_END,
                BuiltinDimensionTypes.OVERWORLD_EFFECTS,
                1.0f,
                new DimensionType.MonsterSettings(false,false, ConstantInt.of(0),0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(Biomes.DEEP_DARK)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.END));

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.PRISON_REALM_DIM_TYPE), wrappedChunkGenerator);

        context.register(PRISON_REALM_DIM_KEY, stem);
    }

}
