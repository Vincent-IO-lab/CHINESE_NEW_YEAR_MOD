package com.besson.tutorialmod.datagen;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.block.custom.ScallionCropBlock;
import com.besson.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUGH);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOUR_STACK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FU_BLOCK);
        blockStateModelGenerator.registerCrop(ModBlocks.LEEK_CROP, Properties.AGE_5, 0,1,2,3,4,5);

        blockStateModelGenerator.blockStateCollector
                .accept(
                        VariantsBlockStateSupplier.create(ModBlocks.SCALLION_CROP)
                                .coordinate(
                                        BlockStateVariantMap.create(ScallionCropBlock.AGE)
                                                .register(
                                                        stage -> BlockStateVariant.create()
                                                                .put(VariantSettings.MODEL, blockStateModelGenerator
                                                                        .createSubModel(ModBlocks.SCALLION_CROP, "_stage" + stage, Models.CROSS, TextureMap::cross))
                                                )
                                )
                );

        blockStateModelGenerator.registerTintableCross(ModBlocks.FU_TREE_SAPLING,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.RED_ENVELOPE, ModBlocks.POTTED_RED_ENVELOPE,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleState(ModBlocks.FORTUNE_BOX);
//        blockStateModelGenerator.registerSimpleState(ModBlocks.FLOUR_MILLING_MACHINE);
        blockStateModelGenerator.registerSimpleState(ModBlocks.POLISHING_MACHINE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LITTLE_DOUGH, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOUR, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUMPLING_WRAPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEEK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCALLION, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCALLION_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.THREE_FRESH_STUFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.PORK_AND_SCALLION_STUFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEEK_AND_EGG_STUFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEEK_AND_EGG_STUFFED_DUMPLING, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_LEEK_AND_EGG_STUFFED_DUMPLING, Models.GENERATED);
        itemModelGenerator.register(ModItems.PORK_AND_SCALLION_STUFFED_DUMPLING, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PORK_AND_SCALLION_STUFFED_DUMPLING, Models.GENERATED);
        itemModelGenerator.register(ModItems.THREE_FRESH_STUFFED_DUMPLING, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_THREE_FRESH_STUFFED_DUMPLING, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRACKER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROLLING_PIN, Models.GENERATED);
//        itemModelGenerator.register(ModItems.FU_PAINTING, Models.GENERATED);
    }
}
