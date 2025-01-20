package com.besson.tutorialmod.villager;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterest;
import net.minecraft.world.poi.PointOfInterestType;
import org.jetbrains.annotations.Nullable;

public class ModVillagers {
    public static final VillagerProfession FORTUNE_GIVER = registerVillagerProfession("fortune_giver",
            ModPointOfInterestTypes.FORTUNE_GIVER_KEY, SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER);
    public static final PointOfInterestType FORTUNE_GIVER_POINT_OF_INTEREST = registerPointOfInterestType("fortune_giver_point_of_interest",
            ModBlocks.RED_ENVELOPE);
    public static final VillagerProfession FLOUR_MILLER = registerVillagerProfession("flour_miller",
            ModPointOfInterestTypes.FLOUR_MILLER, SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER);
    public static final PointOfInterestType FLOUR_MILLER_POINT_OF_INTEREST = registerPointOfInterestType("flour_miller_point_of_interest",
            ModBlocks.POLISHING_MACHINE);

    private static VillagerProfession registerVillagerProfession(String id, RegistryKey<PointOfInterestType> heldWorkStation, @Nullable SoundEvent worksound) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(TutorialMod.MOD_ID, id),
                new VillagerProfession(id, entry -> entry.matchesKey(heldWorkStation), entry -> entry.matchesKey(heldWorkStation),
                        ImmutableSet.of(), ImmutableSet.of(), worksound));
    }
    private static PointOfInterestType registerPointOfInterestType(String id, Block block) {
        return PointOfInterestHelper.register(Identifier.of(TutorialMod.MOD_ID,id), 1,2,block);
    }
    public static void init() {

    }
}
