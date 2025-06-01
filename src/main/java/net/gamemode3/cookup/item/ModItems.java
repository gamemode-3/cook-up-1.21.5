package net.gamemode3.cookup.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gamemode3.cookup.CookUp;
import net.gamemode3.cookup.component.type.ModConsumableComponents;
import net.gamemode3.cookup.component.type.ModFoodComponents;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    // Mushroom Items
    public static final Item RAW_BROWN_MUSHROOM = registerItem("raw_brown_mushroom", new RawMushroomItem(
            Blocks.BROWN_MUSHROOM, newSettings("raw_brown_mushroom"), ModFoodComponents.RAW_MUSHROOM,
            List.of()
    ));
    public static final Item RAW_RED_MUSHROOM = registerItem("raw_red_mushroom", new RawMushroomItem(
            Blocks.RED_MUSHROOM, newSettings("raw_red_mushroom"), ModFoodComponents.RAW_MUSHROOM,
            List.of(new StatusEffectPrefab(StatusEffects.POISON, 25, 1))
    ));
    public static final Item RAW_CRIMSON_FUNGUS = registerItem("raw_crimson_fungus", new RawMushroomItem(
            Blocks.CRIMSON_FUNGUS, newSettings("raw_crimson_fungus"), ModFoodComponents.RAW_FUNGUS,
            List.of(
                    new StatusEffectPrefab(StatusEffects.FIRE_RESISTANCE, 16, 1),
                    new StatusEffectPrefab(StatusEffects.SLOWNESS, 16, 1)
            )
    ));
    public static final Item RAW_WARPED_FUNGUS = registerItem("raw_warped_fungus", new RawMushroomItem(
            Blocks.WARPED_FUNGUS, newSettings("raw_warped_fungus"), ModFoodComponents.RAW_FUNGUS,
            List.of(
                    new StatusEffectPrefab(StatusEffects.JUMP_BOOST, 15, 1),
                    new StatusEffectPrefab(StatusEffects.NAUSEA, 110, 255)
            )
        ));

    public static final Item ROASTED_BROWN_MUSHROOM = registerFoodItem("roasted_brown_mushroom", ModFoodComponents.ROASTED_MUSHROOM, ModConsumableComponents.ROASTED_MUSHROOM);
    public static final Item ROASTED_RED_MUSHROOM = registerFoodItem("roasted_red_mushroom", ModFoodComponents.ROASTED_MUSHROOM, ModConsumableComponents.ROASTED_MUSHROOM);

    // Egg Items
    public static final Item BOILED_EGG = registerFoodItem("boiled_egg", ModFoodComponents.BOILED_EGG);
    public static final Item BOILED_BROWN_EGG = registerFoodItem("boiled_brown_egg", ModFoodComponents.BOILED_EGG);
    public static final Item BOILED_BLUE_EGG = registerFoodItem("boiled_blue_egg", ModFoodComponents.BOILED_EGG);

    public static final Item FRIED_EGG = registerFoodItem("fried_egg", ModFoodComponents.FRIED_EGG);


    public static Item.Settings newSettings(String name) {
        return new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CookUp.MOD_ID, name)));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CookUp.MOD_ID, name), item);
    }

    private static Item registerFoodItem(String name, FoodComponent foodComponent) {
        return registerItem(name, new Item(newSettings(name).food(foodComponent)));
    }

    private static Item registerFoodItem(String name, FoodComponent foodComponent, ConsumableComponent consumableComponent) {
        return registerItem(name, new Item(newSettings(name).food(foodComponent, consumableComponent)));
    }

    public static void registerModItems() {
        CookUp.LOGGER.info("Registering Mod Items for " + CookUp.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(RAW_BROWN_MUSHROOM);
            entries.add(RAW_RED_MUSHROOM);
            entries.add(ROASTED_BROWN_MUSHROOM);
            entries.add(ROASTED_RED_MUSHROOM);
            entries.add(RAW_CRIMSON_FUNGUS);
            entries.add(RAW_WARPED_FUNGUS);
            entries.add(RAW_RED_MUSHROOM);
            entries.add(BOILED_EGG);
            entries.add(BOILED_BROWN_EGG);
            entries.add(BOILED_BLUE_EGG);
            entries.add(FRIED_EGG);
        });
    }
}
