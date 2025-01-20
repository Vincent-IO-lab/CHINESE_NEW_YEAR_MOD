package com.besson.tutorialmod.world.tree;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.world.ModConfiguredFeature;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModTreeGenerator {
    public static final SaplingGenerator FU_TREE = new SaplingGenerator(
            TutorialMod.MOD_ID + "fu_tree",
            Optional.empty(),
            Optional.of(ModConfiguredFeature.FU_TREE_KEY),
            Optional.empty()
    );
}
