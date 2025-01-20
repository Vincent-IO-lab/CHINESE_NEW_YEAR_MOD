package com.besson.tutorialmod.util;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.item.ModItems;
import com.besson.tutorialmod.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

public class ModCustomTraders {
    public static void registerCustomTraders() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,1,factories ->{
            factories.add(new TradeOffers.BuyItemFactory(ModItems.FLOUR, 5 ,12,64,30));
            factories.add(new TradeOffers.SellItemFactory(ModItems.LEEK,5,12,64,30));
            factories.add(new TradeOffers.SellItemFactory(ModItems.LEEK_SEEDS,7,12,64,30));
            factories.add(new TradeOffers.SellItemFactory(ModItems.SCALLION,5,12,64,30));
            factories.add(new TradeOffers.SellItemFactory(ModItems.SCALLION_SEEDS,7,12,64,30));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,2,factories ->{
            factories.add(new TradeOffers.ProcessItemFactory(ModItems.LITTLE_DOUGH,64,20,ModItems.DUMPLING_WRAPPER,64,16,5,0.5f));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.FORTUNE_GIVER,1,factories ->{
            factories.add(new TradeOffers.SellItemFactory(ModBlocks.RED_ENVELOPE,1,12,64,30));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.FORTUNE_GIVER,2,factories ->{
            factories.add(new TradeOffers.SellItemFactory(ModBlocks.RED_ENVELOPE,1,24,64,30));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.FORTUNE_GIVER,3,factories ->{
            factories.add(new TradeOffers.SellItemFactory(ModBlocks.RED_ENVELOPE,1,64,64,30));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.FLOUR_MILLER,1,factories ->{
            factories.add(new TradeOffers.ProcessItemFactory(Items.WHEAT, 16, 10, ModItems.FLOUR,64,64,30,0.5f));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.FLOUR_MILLER,2,factories ->{
            factories.add(new TradeOffers.ProcessItemFactory(Items.WHEAT, 8, 10, ModItems.FLOUR,64,64,30,0.5f));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.FLOUR_MILLER,3,factories ->{
            factories.add(new TradeOffers.ProcessItemFactory(Items.WHEAT, 8, 8, ModItems.FLOUR,64,64,30,0.5f));
        });
    }
}
