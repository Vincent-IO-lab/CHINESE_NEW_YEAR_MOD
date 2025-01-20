package com.besson.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent RAW_DUMPLING = new FoodComponent.Builder()
            .nutrition(1).saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 900), 1.0f)
            .alwaysEdible().build();
    public static final FoodComponent PORK_AND_SCALLION_STUFF = new FoodComponent.Builder()
            .nutrition(2).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 900), 1.0f)
            .alwaysEdible().build();
    public static final FoodComponent LEEK_AND_EGG_STUFF = new FoodComponent.Builder()
            .nutrition(2).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 900), 1.0f)
            .alwaysEdible().build();
    public static final FoodComponent THREE_FERESH_STUFF = new FoodComponent.Builder()
            .nutrition(2).saturationModifier(0.9F)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 900), 1.0f)
            .alwaysEdible().build();
    public static final FoodComponent LEEK = new FoodComponent.Builder()
            .nutrition(1).saturationModifier(0.2F).alwaysEdible().build();
    public static final FoodComponent SCALLION = new FoodComponent.Builder()
            .nutrition(1).saturationModifier(0.2F).alwaysEdible().build();
}
