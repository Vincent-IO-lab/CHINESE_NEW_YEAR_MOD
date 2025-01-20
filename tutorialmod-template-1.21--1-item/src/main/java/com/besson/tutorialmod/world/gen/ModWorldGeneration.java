package com.besson.tutorialmod.world.gen;

import com.besson.tutorialmod.world.tree.ModTreeGenerator;

public class ModWorldGeneration {
    public static void registerModWorldGeneration() {
        ModTreeGeneration.registerTrees();
        ModRedEnvelopeGenneration.EnvelopeGenneration();
        ModLeekCropGeneration.LeekCropGeneration();
    }
}
