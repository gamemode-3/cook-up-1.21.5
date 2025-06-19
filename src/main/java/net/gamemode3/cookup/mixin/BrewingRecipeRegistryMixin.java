package net.gamemode3.cookup.mixin;

import net.gamemode3.cookup.potion.ModPotions;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {

    @Inject(method = "registerDefaults", at = @At("TAIL"))
    private static void addCustomBrewingRecipes(BrewingRecipeRegistry.Builder builder, CallbackInfo ci) {
        // Register potion types if needed
        builder.registerPotionType(Items.POTION);

        // Register the base potion + ingredient → result logic
        builder.registerPotionRecipe(
                Potions.AWKWARD, // base potion
                Items.CRIMSON_FUNGUS, // ingredient item
                ModPotions.CRIMSON_POTION
        );
        builder.registerPotionRecipe(
                Potions.AWKWARD, // base potion
                Items.WARPED_FUNGUS, // ingredient item
                ModPotions.WARPED_POTION
        );
    }
}