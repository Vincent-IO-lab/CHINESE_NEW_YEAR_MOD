package com.besson.tutorialmod.datagen;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.entity.ModEntities;
import com.besson.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModZHCNLanProvider extends FabricLanguageProvider {

    public ModZHCNLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.DOUGH, "面团");
        translationBuilder.add(ModBlocks.FLOUR_STACK, "面粉垛");
        translationBuilder.add(ModBlocks.RED_ENVELOPE, "红包");
        translationBuilder.add(ModBlocks.FORTUNE_BOX, "幸运箱");
        translationBuilder.add(ModBlocks.POLISHING_MACHINE, "磨面粉机");
//        translationBuilder.add(ModBlocks.FLOUR_MILLING_MACHINE, "Flour Milling Machine");
        translationBuilder.add(ModBlocks.FU_BLOCK, "福块");

        translationBuilder.add(ModItems.CRACKER, "爆竹");
        translationBuilder.add(ModItems.NIAN_SPAWN_EGG, "年兽蛋");
        translationBuilder.add(ModItems.LITTLE_DOUGH, "面劲儿");
        translationBuilder.add(ModItems.FLOUR, "面粉");
        translationBuilder.add(ModItems.DUMPLING_WRAPPER, "饺子皮");
        translationBuilder.add(ModItems.LEEK, "韭菜");
        translationBuilder.add(ModItems.LEEK_SEEDS, "韭菜苗");
        translationBuilder.add(ModItems.SCALLION, "大葱");
        translationBuilder.add(ModItems.SCALLION_SEEDS, "大葱秧");
        translationBuilder.add(ModBlocks.FU_TREE_SAPLING, "福树种子");
        translationBuilder.add(ModItems.THREE_FRESH_STUFF, "三鲜馅儿");
        translationBuilder.add(ModItems.PORK_AND_SCALLION_STUFF, "猪肉大葱馅儿");
        translationBuilder.add(ModItems.LEEK_AND_EGG_STUFF, "韭菜鸡蛋馅儿");
        translationBuilder.add(ModItems.LEEK_AND_EGG_STUFFED_DUMPLING, "韭菜鸡蛋馅儿饺子");
        translationBuilder.add(ModItems.RAW_LEEK_AND_EGG_STUFFED_DUMPLING, "生的韭菜鸡蛋馅饺子");
        translationBuilder.add(ModItems.PORK_AND_SCALLION_STUFFED_DUMPLING, "猪肉大葱馅儿饺子");
        translationBuilder.add(ModItems.RAW_PORK_AND_SCALLION_STUFFED_DUMPLING, "生的猪肉大葱馅儿饺子");
        translationBuilder.add(ModItems.THREE_FRESH_STUFFED_DUMPLING, "三鲜馅儿饺子");
        translationBuilder.add(ModItems.RAW_THREE_FRESH_STUFFED_DUMPLING, "生的三鲜馅儿饺子");
        translationBuilder.add(ModItems.ROLLING_PIN, "擀面杖");
//        translationBuilder.add(ModItems.FU_PAINTING, "Fu Painting");

        translationBuilder.add("itemGroup.tutorialmod", "春节");

        translationBuilder.add("container.fortune_box", "幸运箱");
        translationBuilder.add("container.polishing_machine", "磨面粉机");

        translationBuilder.add("sounds.tutorialmod.throwing", "投掷");
        translationBuilder.add("sounds.tutorialmod.cracker_sound", "爆竹声");

        translationBuilder.add(ModEntities.TIGER, "年兽");
    }
}
