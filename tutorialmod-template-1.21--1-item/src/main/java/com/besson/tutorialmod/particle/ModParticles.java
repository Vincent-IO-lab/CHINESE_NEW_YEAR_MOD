package com.besson.tutorialmod.particle;

import com.besson.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    private static SimpleParticleType register(String name, SimpleParticleType type) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(TutorialMod.MOD_ID, name), type);
    }
    public static final SimpleParticleType FU_PARTICLE = register("fu_particle", FabricParticleTypes.simple());
    public static void init() {

    }
}
