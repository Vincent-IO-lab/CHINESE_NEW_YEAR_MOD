package com.besson.tutorialmod.block;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.block.custom.FortuneBox;
import com.besson.tutorialmod.block.custom.LeekCropBlock;
import com.besson.tutorialmod.block.custom.PolishingMachine;
import com.besson.tutorialmod.block.custom.ScallionCropBlock;
import com.besson.tutorialmod.block.entity.ModBlockEntities;
import com.besson.tutorialmod.world.tree.ModTreeGenerator;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static Block registerBlocks(String name, Block block) {
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItems(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    public static final Block DOUGH = registerBlocks("dough",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block FLOUR_STACK = registerBlocks("flour_stack",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD)));
    public static final Block LEEK_CROP = Registry.register(Registries.BLOCK,
            Identifier.of(TutorialMod.MOD_ID, "leek_crop"),
            new LeekCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final Block SCALLION_CROP = Registry.register(Registries.BLOCK,
            Identifier.of(TutorialMod.MOD_ID, "scallion_crop"),
            new ScallionCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final Block FU_TREE_SAPLING = registerBlocks("fu_tree_sapling",
            new SaplingBlock(ModTreeGenerator.FU_TREE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));
    public static final Block RED_ENVELOPE = registerBlocks("red_envelope",
            new FlowerBlock(StatusEffects.LUCK, 0.35F,
                    AbstractBlock.Settings.copy(Blocks.DANDELION)));
    public static final Block POTTED_RED_ENVELOPE = Registry.register(Registries.BLOCK,
            Identifier.of(TutorialMod.MOD_ID, "potted_red_envelope"),
            new FlowerPotBlock(RED_ENVELOPE, AbstractBlock.Settings.copy(Blocks.POTTED_DANDELION)));
    public static final Block FORTUNE_BOX = registerBlocks("fortune_box",
            new FortuneBox(AbstractBlock.Settings.copy(Blocks.CHEST), () -> ModBlockEntities.BOX_ENTITY));
//    public static final Block FLOUR_MILLING_MACHINE = registerBlocks("flour_milling_machine",
//            new FlourMillingMachine(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block POLISHING_MACHINE = registerBlocks("polishing_machine",
            new PolishingMachine(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block FU_BLOCK = registerBlocks("fu_block",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE)));


    public static void init() {

    }

}
