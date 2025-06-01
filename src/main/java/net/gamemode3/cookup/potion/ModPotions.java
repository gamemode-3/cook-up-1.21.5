package net.gamemode3.cookup.potion;

import net.gamemode3.cookup.CookUp;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static RegistryEntry<Potion> WARPED_POTION;
    public static RegistryEntry<Potion> CRIMSON_POTION;


    private static RegistryEntry<Potion> register(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(CookUp.MOD_ID, name), potion);
    }

    public static void registerModPotions() {
         CRIMSON_POTION = register(
                "crimson",
                new Potion(
                        "crimson",
                        new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.SLOWNESS, 200, 1),
                        new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.FIRE_RESISTANCE, 200, 0)
                )
        );
        WARPED_POTION = register(
                "warped",
                new Potion(
                        "warped",
                        new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.NAUSEA, 200, 0),
                        new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.JUMP_BOOST, 200, 0)
                )
        );
    }
}
