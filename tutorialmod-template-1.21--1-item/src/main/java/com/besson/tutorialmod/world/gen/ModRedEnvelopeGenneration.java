package com.besson.tutorialmod.world.gen;

import com.besson.tutorialmod.world.ModPlacedFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;

public class ModRedEnvelopeGenneration {
    public static void EnvelopeGenneration() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.BAMBOO_JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeature.RED_ENVELOPE_KEY);
    }
}
