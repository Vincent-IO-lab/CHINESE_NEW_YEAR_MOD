package com.besson.tutorialmod;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.block.entity.ModBlockEntities;
import com.besson.tutorialmod.entity.custom.CrackerEntity;
import com.besson.tutorialmod.entity.ModEntities;
import com.besson.tutorialmod.entity.custom.TigerEntity;
import com.besson.tutorialmod.item.ModItemGroups;
import com.besson.tutorialmod.item.ModItems;
import com.besson.tutorialmod.item.custom.CrackerItem;
import com.besson.tutorialmod.particle.ModParticles;
import com.besson.tutorialmod.recipe.ModRecipeTypes;
import com.besson.tutorialmod.screen.ModScreenHandlers;
import com.besson.tutorialmod.sound.ModSoundEvents;
import com.besson.tutorialmod.util.ModCustomTraders;
import com.besson.tutorialmod.villager.ModVillagers;
import com.besson.tutorialmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final EntityType<CrackerEntity> CRACKER_ENTITY_ENTITY_TYPE = Registry.register(
			Registries.ENTITY_TYPE,
			Identifier.of(TutorialMod.MOD_ID, "cracker"),
			FabricEntityTypeBuilder.<CrackerEntity>create(SpawnGroup.MISC, CrackerEntity::new)
					.dimensions(EntityDimensions.fixed(0.25f,0.25f))
					.trackRangeBlocks(4).trackedUpdateRate(10)
					.build()
	);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// 主类调用物品注册方法
		ModItemGroups.init();
		ModSoundEvents.init();
		ModBlocks.init();
		ModItems.registerModItems();
		ModCustomTraders.registerCustomTraders();
		ModVillagers.init();
		ModBlockEntities.init();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipeTypes.registerRecipeTypes();
		ModWorldGeneration.registerModWorldGeneration();
		ModParticles.init();
		FabricDefaultAttributeRegistry.register(ModEntities.TIGER, TigerEntity.createTigerAttributes());
		LOGGER.info("Hello Fabric world!");
	}
}