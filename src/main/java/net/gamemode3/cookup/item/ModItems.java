package net.gamemode3.cookup.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gamemode3.cookup.CookUp;
import net.gamemode3.cookup.component.type.ModConsumableComponents;
import net.gamemode3.cookup.component.type.ModFoodComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    // Mushroom Items
    public static final Item ROASTED_BROWN_MUSHROOM = registerRoastedMushroomItem("roasted_brown_mushroom");
    public static final Item ROASTED_RED_MUSHROOM = registerRoastedMushroomItem("roasted_red_mushroom");

    // Egg Items
    public static final Item BOILED_EGG = registerBoiledEggItem("boiled_egg");
    public static final Item BOILED_BROWN_EGG = registerBoiledEggItem("boiled_brown_egg");
    public static final Item BOILED_BLUE_EGG = registerBoiledEggItem("boiled_blue_egg");

    public static final Item FRIED_EGG = registerFoodItem("fried_egg", ModFoodComponents.FRIED_EGG, settings -> settings.maxCount(16));


    public static Item.Settings newSettings(String name) {
        return new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CookUp.MOD_ID, name)));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CookUp.MOD_ID, name), item);
    }

    private static Item registerBoiledEggItem(String name) {
        return registerFoodItem(name, ModFoodComponents.BOILED_EGG, settings -> settings.maxCount(16));
    }

    private static Item registerFoodItem(String name, FoodComponent foodComponent, Function<Item.Settings, Item.Settings> settingsTransformer) {
        Item.Settings settings = newSettings(name).food(foodComponent);
        settings = settingsTransformer.apply(settings);
        return registerItem(name, new Item(settings));
    }

    private static Item registerRoastedMushroomItem(String name) {
        return registerItem(name, new Item(newSettings(name).food(ModFoodComponents.ROASTED_MUSHROOM, ModConsumableComponents.ROASTED_MUSHROOM)));
    }

    public static void registerModItems() {
        CookUp.LOGGER.info("Registering Mod Items for " + CookUp.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ROASTED_BROWN_MUSHROOM);
            entries.add(ROASTED_RED_MUSHROOM);
            entries.add(BOILED_EGG);
            entries.add(BOILED_BROWN_EGG);
            entries.add(BOILED_BLUE_EGG);
            entries.add(FRIED_EGG);
        });
    }
}
