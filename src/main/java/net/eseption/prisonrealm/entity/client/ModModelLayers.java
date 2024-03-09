package net.eseption.prisonrealm.entity.client;

import net.eseption.prisonrealm.PrisonRealmMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation PRISON_REALM = new ModelLayerLocation(
            new ResourceLocation(PrisonRealmMod.MOD_ID, "prison_realm_gate_full_texture"), "main");

    public static final ModelLayerLocation PRISON_REALM_SEAL = new ModelLayerLocation(
            new ResourceLocation(PrisonRealmMod.MOD_ID, "prison_seal_texture"), "main");
}
