package com.besson.tutorialmod.block.entity;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.block.ModBlocks;
import com.mojang.datafixers.types.Type;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModBlockEntities {
    public static final BlockEntityType<FortuneBoxEntity> BOX_ENTITY = create("fortune_box",
            BlockEntityType.Builder.create(FortuneBoxEntity::new, ModBlocks.FORTUNE_BOX));
    public static final BlockEntityType<PolishingMachineBlockEntity> POLISHING_MACHINE_BLOCK_ENTITY = create("polishing_machine_block_entity",
            BlockEntityType.Builder.create(PolishingMachineBlockEntity::new, ModBlocks.POLISHING_MACHINE));
//    public static final BlockEntityType<FlourMillingMachineBlockEntity> MILLING_ENTITY = create("flour_milling_machine",
//            BlockEntityType.Builder.create(FlourMillingMachineBlockEntity::new, ModBlocks.FLOUR_MILLING_MACHINE));
    private static <T extends BlockEntity> BlockEntityType<T> create(String id, BlockEntityType.Builder<T> builder) {

        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(TutorialMod.MOD_ID, id), builder.build(type));
    }
    public static void init() {

    }
}
