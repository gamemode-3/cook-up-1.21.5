package net.gamemode3.cookup.mixin;

import net.gamemode3.cookup.component.type.ModFoodComponents;
import net.gamemode3.cookup.component.type.ModConsumableComponents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Items.class)
public abstract class ItemsMixin {

    @Shadow
    public static Item register(Block block, Item.Settings settings) {
        return null;
    }

    @Inject(method = "register(Lnet/minecraft/block/Block;)Lnet/minecraft/item/Item;", at = @At("HEAD"), cancellable = true)
    private static void replaceItems(Block block, CallbackInfoReturnable<Item> cir) {
        if (block == Blocks.BROWN_MUSHROOM) {
            Item item = register(Blocks.BROWN_MUSHROOM, new Item.Settings().food(ModFoodComponents.RAW_MUSHROOM).component(DataComponentTypes.CONSUMABLE, ModConsumableComponents.BROWN_MUSHROOM));
            cir.setReturnValue(item);
            return;
        }
        if (block == Blocks.RED_MUSHROOM) {
            Item item = register(Blocks.RED_MUSHROOM, new Item.Settings().food(ModFoodComponents.RAW_MUSHROOM).component(DataComponentTypes.CONSUMABLE, ModConsumableComponents.RED_MUSHROOM));
            cir.setReturnValue(item);
            return;
        }
        if (block == Blocks.CRIMSON_FUNGUS) {
            Item item = register(Blocks.CRIMSON_FUNGUS, new Item.Settings().food(ModFoodComponents.RAW_FUNGUS).component(DataComponentTypes.CONSUMABLE, ModConsumableComponents.CRIMSON_FUNGUS));
            cir.setReturnValue(item);
            return;
        }
        if (block == Blocks.WARPED_FUNGUS) {
            Item item = register(Blocks.WARPED_FUNGUS, new Item.Settings().food(ModFoodComponents.RAW_FUNGUS).component(DataComponentTypes.CONSUMABLE, ModConsumableComponents.WARPED_FUNGUS));
            cir.setReturnValue(item);
        }
    }
}
