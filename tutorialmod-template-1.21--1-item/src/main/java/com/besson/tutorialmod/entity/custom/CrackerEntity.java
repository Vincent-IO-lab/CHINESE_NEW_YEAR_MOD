package com.besson.tutorialmod.entity.custom;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.item.ModItems;
import com.besson.tutorialmod.item.custom.CrackerItem;
import com.besson.tutorialmod.particle.ModParticles;
import com.besson.tutorialmod.sound.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrackerEntity extends ThrownItemEntity {

    public CrackerEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public CrackerEntity( double d, double e, double f, World world) {
        super(TutorialMod.CRACKER_ENTITY_ENTITY_TYPE, d, e, f, world);
    }

    public CrackerEntity( LivingEntity livingEntity, World world) {
        super(TutorialMod.CRACKER_ENTITY_ENTITY_TYPE, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.CRACKER;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int i = entity instanceof LivingEntity ? 10 : 0;
        entityHitResult.getEntity().damage(this.getDamageSources().thrown(this, this.getOwner()), (float) i);
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 5 * 3,0));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 10 * 3,0));
            livingEntity.playSound(ModSoundEvents.CRACKER_SOUND);
        }
    }

//    @Override
//    protected void onBlockCollision(BlockState state) {
//        super.onBlockCollision(state);
//        if(!this.getWorld().isClient){
//            this.getWorld().sendEntityStatus(this, (byte)3);
//            this.kill();
//        }
//    }

    private ParticleEffect getParticleParameters() {
        ItemStack itemStack = this.getStack();
        return (ParticleEffect)(!itemStack.isEmpty() && !itemStack.isOf(this.getDefaultItem())
                ? new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack)
                : ModParticles.FU_PARTICLE);
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for (int i = 0; i < 5000; i++) {
                float x = (float)this.getX() + random.nextFloat() * 4 - random.nextFloat() * 4;
                float y = (float)this.getY() + random.nextFloat() * 4 - random.nextFloat() * 4;
                float z = (float)this.getZ() + random.nextFloat() * 4 - random.nextFloat() * 4;
                float vx = random.nextFloat() / 5;
                float vy = random.nextFloat() / 5;
                float vz = random.nextFloat() / 5;
                this.getWorld().addParticle(particleEffect, x , y, z, vx, vy, vz);
            }
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        World world = this.getWorld();
        BlockPos pos = BlockPos.ofFloored(hitResult.getPos());
        if (!this.getWorld().isClient) {
            world.playSound(null,pos, ModSoundEvents.CRACKER_SOUND, SoundCategory.NEUTRAL, 0.5F,1.0F);
            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }
}
