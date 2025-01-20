package com.besson.tutorialmod.datagen;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.entity.ModEntities;
import com.besson.tutorialmod.item.ModItemGroups;
import com.besson.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModENUSLanProvider extends FabricLanguageProvider {
    public ModENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.DOUGH, "Dough");
        translationBuilder.add(ModBlocks.FLOUR_STACK, "Flour Stack");
        translationBuilder.add(ModBlocks.RED_ENVELOPE, "Red Envelope");
        translationBuilder.add(ModBlocks.FORTUNE_BOX, "Fortune Box");
        translationBuilder.add(ModBlocks.POLISHING_MACHINE, "flour milling Machine");
//        translationBuilder.add(ModBlocks.FLOUR_MILLING_MACHINE, "Flour Milling Machine");
        translationBuilder.add(ModBlocks.FU_BLOCK, "Fu Block");

        translationBuilder.add(ModItems.CRACKER, "Cracker");
        translationBuilder.add(ModItems.NIAN_SPAWN_EGG, "Nian Spawn Egg");
        translationBuilder.add(ModItems.LITTLE_DOUGH, "Little Dough");
        translationBuilder.add(ModItems.FLOUR, "Flour");
        translationBuilder.add(ModItems.DUMPLING_WRAPPER, "Dumpling Wrapper");
        translationBuilder.add(ModItems.LEEK, "Leek");
        translationBuilder.add(ModItems.LEEK_SEEDS, "Leek Seeds");
        translationBuilder.add(ModItems.SCALLION, "Scallion");
        translationBuilder.add(ModItems.SCALLION_SEEDS, "Scallion Seeds");
        translationBuilder.add(ModBlocks.FU_TREE_SAPLING, "Fu Tree Sapling");
        translationBuilder.add(ModItems.THREE_FRESH_STUFF, "Three Fresh Stuff");
        translationBuilder.add(ModItems.PORK_AND_SCALLION_STUFF, "Pork and Scallion Stuff");
        translationBuilder.add(ModItems.LEEK_AND_EGG_STUFF, "Leek and Egg Stuff");
        translationBuilder.add(ModItems.LEEK_AND_EGG_STUFFED_DUMPLING, "Leek and Egg Stuffed Dumpling");
        translationBuilder.add(ModItems.RAW_LEEK_AND_EGG_STUFFED_DUMPLING, "Raw Leek and Egg Stuffed Dumpling");
        translationBuilder.add(ModItems.PORK_AND_SCALLION_STUFFED_DUMPLING, "Pork and Scallion Stuffed Dumpling");
        translationBuilder.add(ModItems.RAW_PORK_AND_SCALLION_STUFFED_DUMPLING, "Raw Pork and Scallion Stuffed Dumpling");
        translationBuilder.add(ModItems.THREE_FRESH_STUFFED_DUMPLING, "Three Fresh Stuffed Dumpling");
        translationBuilder.add(ModItems.RAW_THREE_FRESH_STUFFED_DUMPLING, "Raw Three Fresh Stuffed Dumpling");
        translationBuilder.add(ModItems.ROLLING_PIN, "Rolling Pin");
//        translationBuilder.add(ModItems.FU_PAINTING, "Fu Painting");

        translationBuilder.add("itemGroup.tutorialmod", "Spring Festival");

        translationBuilder.add("container.fortune_box", "Fortune Box");
        translationBuilder.add("container.polishing_machine", "Flour Milling Machine");

        translationBuilder.add("sounds.tutorialmod.throwing", "Throwing");
        translationBuilder.add("sounds.tutorialmod.cracker_sound", "Cracker Sound");

        translationBuilder.add(ModEntities.TIGER, "Nian");
    }
}
