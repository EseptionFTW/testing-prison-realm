package net.eseption.prisonrealm.entity.client;

import net.eseption.prisonrealm.PrisonRealmMod;
import net.eseption.prisonrealm.entity.custom.PrisonRealmEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class PrisonRealmRenderer extends MobRenderer<PrisonRealmEntity, PrisonRealmModel<PrisonRealmEntity>> {
    public PrisonRealmRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PrisonRealmModel<>(pContext.bakeLayer(ModModelLayers.PRISON_REALM)), 0f);
    }

    @Override
    public ResourceLocation getTextureLocation(PrisonRealmEntity pEntity) {
        return new ResourceLocation(PrisonRealmMod.MOD_ID, "textures/entity/prison_realm_gate_full_texture.png");
    }
}
