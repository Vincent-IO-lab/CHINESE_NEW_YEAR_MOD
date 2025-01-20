package com.besson.tutorialmod.item;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> SPRING_FES = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(),
            Identifier.of(TutorialMod.MOD_ID, "item_group"));
    public static final ItemGroup tutorialmod_group = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.FU_BLOCK))
            .displayName(Text.translatable("itemGroup.tutorialmod"))
            .build();

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, SPRING_FES, tutorialmod_group);

        ItemGroupEvents.modifyEntriesEvent(SPRING_FES).register(itemGroup -> {
            itemGroup.add(ModBlocks.DOUGH);
            itemGroup.add(ModBlocks.FLOUR_STACK);
            itemGroup.add(ModBlocks.FORTUNE_BOX);
            itemGroup.add(ModBlocks.POLISHING_MACHINE);
            itemGroup.add(ModBlocks.FU_BLOCK);

            itemGroup.add(ModItems.LEEK);
            itemGroup.add(ModItems.LEEK_SEEDS);
            itemGroup.add(ModItems.SCALLION);
            itemGroup.add(ModItems.SCALLION_SEEDS);
            itemGroup.add(ModBlocks.RED_ENVELOPE);
            itemGroup.add(ModBlocks.FU_TREE_SAPLING);
            itemGroup.add(ModItems.LITTLE_DOUGH);
            itemGroup.add(ModItems.FLOUR);
            itemGroup.add(ModItems.DUMPLING_WRAPPER);

            itemGroup.add(ModItems.PORK_AND_SCALLION_STUFF);
            itemGroup.add(ModItems.LEEK_AND_EGG_STUFF);
            itemGroup.add(ModItems.THREE_FRESH_STUFF);

            itemGroup.add(ModItems.RAW_PORK_AND_SCALLION_STUFFED_DUMPLING);
            itemGroup.add(ModItems.PORK_AND_SCALLION_STUFFED_DUMPLING);
            itemGroup.add(ModItems.RAW_LEEK_AND_EGG_STUFFED_DUMPLING);
            itemGroup.add(ModItems.LEEK_AND_EGG_STUFFED_DUMPLING);
            itemGroup.add(ModItems.RAW_THREE_FRESH_STUFFED_DUMPLING);
            itemGroup.add(ModItems.THREE_FRESH_STUFFED_DUMPLING);

            itemGroup.add(ModItems.NIAN_SPAWN_EGG);
            itemGroup.add(ModItems.CRACKER);
//            itemGroup.add(ModItems.FU_PAINTING);
            itemGroup.add(ModItems.ROLLING_PIN);


        });
    }
}
