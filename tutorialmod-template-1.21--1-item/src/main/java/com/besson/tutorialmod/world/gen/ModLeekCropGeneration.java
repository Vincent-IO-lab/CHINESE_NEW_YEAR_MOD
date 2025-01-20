package com.besson.tutorialmod.world.gen;

import com.besson.tutorialmod.world.ModPlacedFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModLeekCropGeneration {
    public static void LeekCropGeneration() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.DESERT),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeature.LEEK_CROP_PLACED_KEY);
    }
}
