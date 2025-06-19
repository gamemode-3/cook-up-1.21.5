package net.gamemode3.cookup.component.type;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import java.util.List;

public class ModConsumableComponents {
    public static final ConsumableComponent BROWN_MUSHROOM = ConsumableComponents.food().consumeSeconds(0.8F).build();
    public static final ConsumableComponent RED_MUSHROOM = ConsumableComponents.food().consumeSeconds(0.8F).consumeEffect(new ApplyEffectsConsumeEffect(
        new StatusEffectInstance(StatusEffects.POISON, 25, 1)
    )).build();

    public static final ConsumableComponent ROASTED_MUSHROOM = ConsumableComponents.food().consumeSeconds(0.8F).build();

    public static final ConsumableComponent CRIMSON_FUNGUS = ConsumableComponents.food().consumeSeconds(0.8F).consumeEffect(new ApplyEffectsConsumeEffect(
        List.of(
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 16, 1),
            new StatusEffectInstance(StatusEffects.SLOWNESS, 16, 1)
        )
    )).build();
    public static final ConsumableComponent WARPED_FUNGUS = ConsumableComponents.food().consumeSeconds(0.8F).consumeEffect(new ApplyEffectsConsumeEffect(
        List.of(
            new StatusEffectInstance(StatusEffects.JUMP_BOOST, 15, 1),
            new StatusEffectInstance(StatusEffects.NAUSEA, 110, 255)
        )
    )).build();
}
