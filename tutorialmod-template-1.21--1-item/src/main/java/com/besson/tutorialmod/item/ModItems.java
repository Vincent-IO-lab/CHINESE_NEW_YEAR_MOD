package com.besson.tutorialmod.item;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.entity.ModEntities;
import com.besson.tutorialmod.item.custom.CrackerItem;
import net.minecraft.entity.EntityType;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.DecorationItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    // 注册物品
    public static final Item CRACKER = registerItems("cracker",
            new CrackerItem(new Item.Settings().maxCount(16)));
    public static final Item ROLLING_PIN = registerItems("rolling_pin",
            new Item(new Item.Settings()));
    public static final Item NIAN_SPAWN_EGG = registerItems("nian_spawn_egg",
            new SpawnEggItem(ModEntities.TIGER, 0x456789, 0x987654, new Item.Settings()));
    public static final Item LEEK = registerItems("leek",
            new Item(new Item.Settings().food(ModFoodComponents.LEEK)));
    public static final Item LEEK_SEEDS = registerItems("leek_seeds",
            new AliasedBlockItem(ModBlocks.LEEK_CROP, new Item.Settings()));
    public static final Item SCALLION = registerItems("scallion",
            new Item(new Item.Settings().food(ModFoodComponents.SCALLION)));
    public static final Item SCALLION_SEEDS = registerItems("scallion_seeds",
            new AliasedBlockItem(ModBlocks.SCALLION_CROP, new Item.Settings()));
    public static final Item LITTLE_DOUGH = registerItems("little_dough",
            new Item(new Item.Settings()));
    public static final Item FLOUR = registerItems("flour",
            new Item(new Item.Settings()));
    public static final Item DUMPLING_WRAPPER = registerItems("dumpling_wrapper",
            new Item(new Item.Settings()));
//    public static final Item FU_PAINTING = registerItems("fu_painting",
//            new DecorationItem(EntityType.PAINTING, new Item.Settings()));

    public static final Item RAW_PORK_AND_SCALLION_STUFFED_DUMPLING = registerItems("raw_dumpling",
            new Item(new Item.Settings().food(ModFoodComponents.RAW_DUMPLING)));
    public static final Item PORK_AND_SCALLION_STUFFED_DUMPLING = registerItems("dumpling",
            new Item(new Item.Settings().food(ModFoodComponents.PORK_AND_SCALLION_STUFF)));
    public static final Item THREE_FRESH_STUFFED_DUMPLING = registerItems("three_fresh_stuffed_dumpling",
            new Item(new Item.Settings().food(ModFoodComponents.THREE_FERESH_STUFF)));
    public static final Item RAW_THREE_FRESH_STUFFED_DUMPLING = registerItems("raw_three_three_fresh_stuffed_dumpling",
            new Item(new Item.Settings().food(ModFoodComponents.RAW_DUMPLING)));
    public static final Item LEEK_AND_EGG_STUFFED_DUMPLING = registerItems("leek_and_egg_dumpling",
            new Item(new Item.Settings().food(ModFoodComponents.LEEK_AND_EGG_STUFF)));
    public static final Item RAW_LEEK_AND_EGG_STUFFED_DUMPLING = registerItems("raw_leek_and_egg_dumpling",
            new Item(new Item.Settings().food(ModFoodComponents.RAW_DUMPLING)));

    public static final Item  PORK_AND_SCALLION_STUFF = registerItems("pork_and_scallion_stuff",
            new Item(new Item.Settings().food(ModFoodComponents.PORK_AND_SCALLION_STUFF)));
    public static final Item THREE_FRESH_STUFF = registerItems("three_fresh_stuff",
            new Item(new Item.Settings().food(ModFoodComponents.THREE_FERESH_STUFF)));
    public static final Item LEEK_AND_EGG_STUFF = registerItems("leek_and_egg_stuff",
            new Item(new Item.Settings().food(ModFoodComponents.LEEK_AND_EGG_STUFF)));

    private static Item registerItems(String id, Item item){

//        return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(TutorialMod.MOD_ID, id)), item);

        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, id), item);
    }
    // 初始化方法
    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering Items");
    }
}
