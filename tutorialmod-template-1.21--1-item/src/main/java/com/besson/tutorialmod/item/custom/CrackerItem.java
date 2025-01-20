package com.besson.tutorialmod.item.custom;

import com.besson.tutorialmod.entity.custom.CrackerEntity;
import com.besson.tutorialmod.sound.ModSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public class CrackerItem extends Item implements ProjectileItem {

    public CrackerItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(),user.getY(),user.getZ(),
                ModSoundEvents.THROW_SOUND, SoundCategory.NEUTRAL,0.5F,
                0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            CrackerEntity crackerEntity = new CrackerEntity( user, world);
            crackerEntity.setItem(itemStack);
            crackerEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F,1.5f,0f);
            world.spawnEntity(crackerEntity);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        CrackerEntity crackerEntity = new CrackerEntity(pos.getX(), pos.getY(), pos.getZ(), world);
        crackerEntity.setItem(stack);
        return crackerEntity;
    }
}
