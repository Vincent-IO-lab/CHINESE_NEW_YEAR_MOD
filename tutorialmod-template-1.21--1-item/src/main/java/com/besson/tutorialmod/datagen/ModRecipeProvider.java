package com.besson.tutorialmod.datagen;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> THREE_FRESH_STUFFED_DUMPLING = List.of(ModItems.RAW_THREE_FRESH_STUFFED_DUMPLING);
    private static final List<ItemConvertible> PORK_AND_SCALLION_STUFFED_DUMPLING = List.of(ModItems.RAW_PORK_AND_SCALLION_STUFFED_DUMPLING);
    private static final List<ItemConvertible> LEEK_AND_EGG_STUFFED_DUMPLING = List.of(ModItems.RAW_LEEK_AND_EGG_STUFFED_DUMPLING);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.LITTLE_DOUGH,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.DOUGH);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ROLLING_PIN,
                RecipeCategory.MISC, Items.STICK);

        offerBlasting(exporter, THREE_FRESH_STUFFED_DUMPLING,
                RecipeCategory.MISC, ModItems.THREE_FRESH_STUFFED_DUMPLING,
                0.7F, 600, "three_fresh_stuffed_dumpling");
        offerBlasting(exporter, PORK_AND_SCALLION_STUFFED_DUMPLING,
                RecipeCategory.MISC,ModItems.PORK_AND_SCALLION_STUFFED_DUMPLING,
                0.7F, 600, "pork_and_scallion_stuffed_dumpling");
        offerBlasting(exporter, LEEK_AND_EGG_STUFFED_DUMPLING,
                RecipeCategory.MISC, ModItems.LEEK_AND_EGG_STUFFED_DUMPLING,
                0.7F, 600, "leek_and_egg_stuffed_dumpling");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLOUR_STACK)
                .input(ModItems.FLOUR)
                .input(ModItems.FLOUR)
                .input(ModItems.FLOUR)
                .input(ModItems.FLOUR)
                .input(ModItems.FLOUR)
                .input(ModItems.FLOUR)
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.FLOUR))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "flour_stack"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEEK_AND_EGG_STUFF)
                .input(ModItems.LEEK)
                .input(Items.EGG)
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.LEEK))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "leek_stack"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PORK_AND_SCALLION_STUFF)
                .input(ModItems.SCALLION)
                .input(Items.PORKCHOP)
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.SCALLION))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "scallion_stack"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.THREE_FRESH_STUFF)
                .input(ModItems.LEEK)
                .input(Items.PORKCHOP)
                .input(Items.TROPICAL_FISH)
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.LEEK))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "three_fresh_stuff"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PORK_AND_SCALLION_STUFFED_DUMPLING)
                .pattern("###")
                .input('#', Ingredient.ofItems(ModItems.DUMPLING_WRAPPER))
                .pattern("#=#")
                .input('=', Ingredient.ofItems(ModItems.PORK_AND_SCALLION_STUFF))
                .pattern("###")
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.DUMPLING_WRAPPER))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "raw_pork_and_scallion_stuff"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_LEEK_AND_EGG_STUFFED_DUMPLING)
                .pattern("###")
                .pattern("#=#")
                .pattern("###")
                .input('#', Ingredient.ofItems(ModItems.DUMPLING_WRAPPER))
                .input('=', Ingredient.ofItems(ModItems.LEEK_AND_EGG_STUFF))
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.DUMPLING_WRAPPER))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "raw_leek_and_egg_stuff"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_THREE_FRESH_STUFFED_DUMPLING)
                .pattern("###")
                .pattern("#=#")
                .pattern("###")
                .input('#', Ingredient.ofItems(ModItems.DUMPLING_WRAPPER))
                .input('=', Ingredient.ofItems(ModItems.THREE_FRESH_STUFF))
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.DUMPLING_WRAPPER))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "raw_three_fresh_stuff"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DOUGH)
                .pattern("###")
                .pattern("#=#")
                .pattern("###")
                .input('#', Ingredient.ofItems(ModItems.FLOUR))
                .input('=', Ingredient.ofItems(Items.WATER_BUCKET))
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.FLOUR))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "dough_stack"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHING_MACHINE)
                .pattern("###")
                .pattern(" -+")
                .pattern("###")
                .input('-', Ingredient.ofItems(Items.STONE_PICKAXE))
                .input('+', Ingredient.ofItems(Items.STICK))
                .input('#', Ingredient.ofItems(Items.STONE))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "machine_stack"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CRACKER)
                .pattern(" # ")
                .pattern("-+-")
                .pattern("-$-")
                .input('-', Ingredient.ofItems(Items.LEATHER))
                .input('+', Ingredient.ofItems(Items.BLAZE_POWDER))
                .input('#', Ingredient.ofItems(Items.STRING))
                .input('$', Ingredient.ofItems(Items.FLINT))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.BLAZE_POWDER))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "cracker_stack"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DUMPLING_WRAPPER, 8)
                .pattern("###")
                .pattern("#+#")
                .pattern("###")
                .input('#', Ingredient.ofItems(ModItems.LITTLE_DOUGH))
                .input('+', Ingredient.ofItems(ModItems.ROLLING_PIN))
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.LITTLE_DOUGH))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "dump_stack"));

    }

}
