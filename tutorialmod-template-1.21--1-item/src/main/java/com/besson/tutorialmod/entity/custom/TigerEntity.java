package com.besson.tutorialmod.entity.custom;

import com.besson.tutorialmod.entity.ModEntities;
import com.besson.tutorialmod.entity.ai.TigerAttackGoal;
import com.besson.tutorialmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.NavigationConditions;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class TigerEntity extends AnimalEntity {
    private boolean canBreakDoors;
    private final BreakDoorGoal breakDoorsGoal = new BreakDoorGoal(this, DOOR_BREAK_DIFFICULTY_CHECKER);
    private static final Predicate<Difficulty> DOOR_BREAK_DIFFICULTY_CHECKER = difficulty -> difficulty == Difficulty.HARD;
    private static final TrackedData<Boolean> IS_ATTACKING =
            DataTracker.registerData(TigerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final AnimationState idleAnimation = new AnimationState();
    public int idleAnimationTimeOut = 0;
    public static final AnimationState attackAnimation = new AnimationState();
    public int attackAnimationTimeOut = 0;
    public TigerEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }
    private void setupAnimation() {
        if (idleAnimationTimeOut <= 0) {
            idleAnimationTimeOut = this.random.nextInt(40) + 80;
            idleAnimation.start(this.age);
        } else {
            idleAnimationTimeOut--;
        }

        if (this.isAttacking() && attackAnimationTimeOut <= 0) {
            attackAnimationTimeOut = 50;
            attackAnimation.start(this.age);
        } else {
            attackAnimationTimeOut--;
        }

        if (!this.isAttacking()) {
            attackAnimation.stop();
        }
    }

    @Override
    public void tick() {
        super.tick();
        setupAnimation();
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(2, new TemptGoal(this, 1.25D, Ingredient.ofItems(ModItems.CRACKER), true));
        this.goalSelector.add(3, new FollowParentGoal(this, 1.25D));
        this.goalSelector.add(4, new WanderAroundGoal(this, 1.0D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 3.0f));
        this.goalSelector.add(6, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this));
        this.goalSelector.add(1, new TigerAttackGoal(this, 2.0D, true));
    }



    public static DefaultAttributeContainer.Builder createTigerAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10);
    }



    private boolean canBreakDoors() {
        return this.canBreakDoors;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.BEEF);
    }

//    public void setCanBreakDoors(boolean canBreakDoors) {
//        if (this.shouldBreakDoors() && NavigationConditions.hasMobNavigation(this)) {
//            if (this.canBreakDoors != canBreakDoors) {
//                this.canBreakDoors = canBreakDoors;
//                ((MobNavigation)this.getNavigation()).setCanPathThroughDoors(canBreakDoors);
//                if (canBreakDoors) {
//                    this.goalSelector.add(1, this.breakDoorsGoal);
//                } else {
//                    this.goalSelector.remove(this.breakDoorsGoal);
//                }
//            }
//        } else if (this.canBreakDoors) {
//            this.goalSelector.remove(this.breakDoorsGoal);
//            this.canBreakDoors = false;
//        }
//    }

//    protected boolean shouldBreakDoors() {
//        return true;
//    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.TIGER.create(world);
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(IS_ATTACKING, false);
    }
    public void setAttacking(boolean attacking) {
        this.dataTracker.set(IS_ATTACKING, attacking);
    }
    public boolean isAttacking() {
        return this.dataTracker.get(IS_ATTACKING);
    }
}
