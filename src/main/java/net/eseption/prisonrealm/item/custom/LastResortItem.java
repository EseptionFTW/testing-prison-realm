package net.eseption.prisonrealm.item.custom;

import net.eseption.prisonrealm.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LastResortItem extends Item {
    public static final FoodProperties LASTRESORT = new FoodProperties.Builder().alwaysEat().effect(() -> new MobEffectInstance(MobEffects.WITHER,20000,9),1.0f).build();
    public LastResortItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isEdible() {
        return true;
    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.prisonrealm.last_resort.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.EAT;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
            return 64;
    }


    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }
}
