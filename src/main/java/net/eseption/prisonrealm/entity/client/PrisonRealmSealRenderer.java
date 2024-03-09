package net.eseption.prisonrealm.entity.client;

import net.eseption.prisonrealm.PrisonRealmMod;
import net.eseption.prisonrealm.entity.custom.PrisonRealmSealEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PrisonRealmSealRenderer extends MobRenderer<PrisonRealmSealEntity, PrisonRealmSealModel<PrisonRealmSealEntity>> {
    public PrisonRealmSealRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PrisonRealmSealModel<>(pContext.bakeLayer(ModModelLayers.PRISON_REALM_SEAL)), 0f);
    }

    @Override
    public ResourceLocation getTextureLocation(PrisonRealmSealEntity pEntity) {
        return new ResourceLocation(PrisonRealmMod.MOD_ID, "textures/entity/prison_realm_seal_entity_texture.png");
    }
}
