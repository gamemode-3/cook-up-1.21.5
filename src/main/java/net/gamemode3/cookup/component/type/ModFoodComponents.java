package net.gamemode3.cookup.component.type;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent ROASTED_MUSHROOM = new FoodComponent.Builder().nutrition(2).saturationModifier(0.5F).build();
    public static final FoodComponent RAW_MUSHROOM = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1F).build();
    public static final FoodComponent RAW_FUNGUS = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1F).alwaysEdible().build();
    public static final FoodComponent BOILED_EGG = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).build();
    public static final FoodComponent FRIED_EGG = new FoodComponent.Builder().nutrition(4).saturationModifier(0.5F).build();
}
