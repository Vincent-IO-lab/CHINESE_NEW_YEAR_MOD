package com.besson.tutorialmod.villager;

import com.besson.tutorialmod.TutorialMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

public class ModPointOfInterestTypes {
    public static final RegistryKey<PointOfInterestType> FORTUNE_GIVER_KEY = of("fortune_giver_point_of_interest");
    public static final RegistryKey<PointOfInterestType> FLOUR_MILLER = of("flour_miller_point_of_interest");

    private static RegistryKey<PointOfInterestType> of(String id) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(TutorialMod.MOD_ID,id));
    }
}
