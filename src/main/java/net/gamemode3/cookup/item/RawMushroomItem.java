package net.gamemode3.cookup.item;

import net.gamemode3.cookup.component.type.ModConsumableComponents;
import net.gamemode3.cookup.component.type.ModFoodComponents;
import net.minecraft.block.Block;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.UseAction;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.List;

public class RawMushroomItem extends BlockItem {
    List<StatusEffectPrefab> effects;
    FoodComponent foodComponent;

    public RawMushroomItem(Block block, Settings settings, FoodComponent foodComponent, List<StatusEffectPrefab> effects) {
        super(block, settings.food(foodComponent, ModConsumableComponents.RAW_MUSHROOM));
        this.effects = effects;
        this.foodComponent = foodComponent;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    public int getMaxUseTime() {
        return 16;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player) {
            player.getHungerManager().eat(foodComponent);

            for (StatusEffectPrefab effect : effects) {
                player.addStatusEffect(effect.instantiate(), user);
            }

            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.PLAYERS,
                    0.5F, world.random.nextFloat() * 0.1F + 0.9F);
        }

        if (!user.getWorld().isClient && !(user instanceof PlayerEntity player && player.getAbilities().creativeMode)) {
            stack.decrement(1);
        }

        return stack;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (user.canConsume(foodComponent.canAlwaysEat())) {
            user.setCurrentHand(hand);
            return ActionResult.CONSUME;
        }
        return ActionResult.PASS;
    }

}