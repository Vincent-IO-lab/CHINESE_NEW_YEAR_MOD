package com.besson.tutorialmod.sound;

import com.besson.tutorialmod.TutorialMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static final SoundEvent CRACKER_SOUND = register("cracker_sound");
    public static final SoundEvent THROW_SOUND = register("throwing");
    private static SoundEvent register(String name) {
        Identifier id = Identifier.of(TutorialMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void init() {

    }
}
