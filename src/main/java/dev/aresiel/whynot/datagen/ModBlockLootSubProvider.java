package dev.aresiel.whynot.datagen;

import dev.aresiel.whynot.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.function.BiConsumer;

public class ModBlockLootSubProvider extends BlockLootSubProvider {

    protected ModBlockLootSubProvider() {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CUT_COPPER_WALL.get());
        dropSelf(ModBlocks.EXPOSED_CUT_COPPER_WALL.get());
        dropSelf(ModBlocks.WEATHERED_CUT_COPPER_WALL.get());
        dropSelf(ModBlocks.OXIDIZED_CUT_COPPER_WALL.get());

        dropSelf(ModBlocks.WAXED_CUT_COPPER_WALL.get());
        dropSelf(ModBlocks.WAXED_EXPOSED_CUT_COPPER_WALL.get());
        dropSelf(ModBlocks.WAXED_WEATHERED_CUT_COPPER_WALL.get());
        dropSelf(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.REGISTRY.getEntries().stream()
                .map(RegistryObject::get)
                .toList();
    }
}