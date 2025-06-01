package net.gamemode3.cookup.component.type;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;

public class ModConsumableComponents {
    public static final ConsumableComponent RAW_MUSHROOM = ConsumableComponents.food().consumeSeconds(0.8F).build();
    public static final ConsumableComponent ROASTED_MUSHROOM = ConsumableComponents.food().consumeSeconds(0.8F).build();
}
