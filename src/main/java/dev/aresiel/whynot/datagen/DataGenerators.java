package dev.aresiel.whynot.datagen;

import dev.aresiel.whynot.WhyNotMod;
import dev.aresiel.whynot.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = WhyNotMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        var output = generator.getPackOutput();
        var efh = event.getExistingFileHelper();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(
                event.includeClient(),
                 new ModBlockStateProvider(output, efh)
        );

        generator.addProvider(
                event.includeClient(),
                new ModItemModelProvider(output, efh)
        );

        generator.addProvider(
                event.includeServer(),
                new ModBlockTagsProvider(output, lookupProvider, efh)
        );

        generator.addProvider(
                event.includeServer(),
                new LootTableProvider(
                        output,
                        Set.of(),
                        List.of(
                                new LootTableProvider.SubProviderEntry(
                                        ModBlockLootSubProvider::new,
                                        LootContextParamSets.BLOCK
                                )
                        )
                )
        );

        generator.addProvider(
                event.includeServer(),
                new ModRecipeProvider(output)
        );
    }
}
