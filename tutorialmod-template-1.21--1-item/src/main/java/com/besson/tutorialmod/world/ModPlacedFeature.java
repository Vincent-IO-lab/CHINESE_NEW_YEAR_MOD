package com.besson.tutorialmod.world;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ModPlacedFeature {
    public static final RegistryKey<PlacedFeature> FU_TREE_PLACED_KEY = of("fu_tree_placed");
    public static final RegistryKey<PlacedFeature> RED_ENVELOPE_KEY = of("red_envelope_placed");
    public static final RegistryKey<PlacedFeature> LEEK_CROP_PLACED_KEY = of("leek_crop_placed");

    public static void bootstrap(Registerable<PlacedFeature> registerable) {
        RegistryEntryLookup<ConfiguredFeature<?,?>> registryEntryLookup =
                registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(registerable, FU_TREE_PLACED_KEY, registryEntryLookup.getOrThrow(ModConfiguredFeature.FU_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2,0.1f,2),
                        ModBlocks.FU_TREE_SAPLING
                ));
        register(registerable, RED_ENVELOPE_KEY, registryEntryLookup.getOrThrow(ModConfiguredFeature.RED_ENVELOPE_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(registerable, LEEK_CROP_PLACED_KEY, registryEntryLookup.getOrThrow(ModConfiguredFeature.LEEK_CROP_KEY),
                RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of());

    }
    public static RegistryKey<PlacedFeature> of(String id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(TutorialMod.MOD_ID,id));
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            List<PlacementModifier> modifiers
    ) {
        featureRegisterable.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            PlacementModifier... modifiers
    ) {
        register(featureRegisterable, key, feature, List.of(modifiers));
    }
}

