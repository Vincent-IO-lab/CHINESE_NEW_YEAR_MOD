package com.besson.tutorialmod.world;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeature {
    public static final RegistryKey<ConfiguredFeature<?,?>> RED_ENVELOPE_KEY = of("red_envelope");
    public static final RegistryKey<ConfiguredFeature<?,?>> FU_TREE_KEY = of("fu_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> LEEK_CROP_KEY = of("leek_crop");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable){
        register(featureRegisterable, FU_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.GOLD_BLOCK),
                new StraightTrunkPlacer(4,3,2),
                BlockStateProvider.of(ModBlocks.FU_BLOCK),
                new BlobFoliagePlacer(ConstantIntProvider.create(4),ConstantIntProvider.create(2),2),
                new TwoLayersFeatureSize(1,0,2)
        ).build());

        register(featureRegisterable, RED_ENVELOPE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32,6,2,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RED_ENVELOPE)))));

        register(featureRegisterable, LEEK_CROP_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32,6,2,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LEEK_CROP)))));
    }
    public static RegistryKey<ConfiguredFeature<?, ?>> of(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(TutorialMod.MOD_ID,id));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config
    ) {
        registerable.register(key, new ConfiguredFeature<FC,F>(feature, config));
    }
}
