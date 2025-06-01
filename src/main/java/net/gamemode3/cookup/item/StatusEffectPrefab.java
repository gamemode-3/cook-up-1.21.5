package net.gamemode3.cookup.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;

public record StatusEffectPrefab(RegistryEntry<StatusEffect> effect, int duration, int amplifier) {
    public StatusEffectInstance instantiate() {
        return new StatusEffectInstance(effect, duration, amplifier);
    }
}
