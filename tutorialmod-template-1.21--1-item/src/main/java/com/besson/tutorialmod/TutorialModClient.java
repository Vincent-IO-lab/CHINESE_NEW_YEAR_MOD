package com.besson.tutorialmod;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.entity.ModEntities;
import com.besson.tutorialmod.entity.client.ModModelLayers;
import com.besson.tutorialmod.entity.client.TigerModel;
import com.besson.tutorialmod.entity.client.TigerRenderer;
import com.besson.tutorialmod.particle.ModParticles;
import com.besson.tutorialmod.screen.ModScreenHandlers;
import com.besson.tutorialmod.screen.PolishingMachineScreen;
import com.besson.tutorialmod.screen.PolishingMachineScreenHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(TutorialMod.CRACKER_ENTITY_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        HandledScreens.register(ModScreenHandlers.POLISHING_MACHINE_SCREEN_HANDLER, PolishingMachineScreen::new);
//        HandledScreens.register(ModScreenHandlers.FLOUR_MILLING_MACHINE_SCREEN_HANLER_SCREEN_HANDLER_TYPE, FlourMillingMachineScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEEK_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SCALLION_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FU_TREE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_ENVELOPE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_RED_ENVELOPE, RenderLayer.getCutout());
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TIGER, TigerModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.FU_PARTICLE, FlameParticle.Factory::new);
    }
}
