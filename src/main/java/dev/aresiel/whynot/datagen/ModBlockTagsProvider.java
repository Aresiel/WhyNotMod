package dev.aresiel.whynot.datagen;

import dev.aresiel.whynot.WhyNotMod;
import dev.aresiel.whynot.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, WhyNotMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.CUT_COPPER_WALL.get())
                .add(ModBlocks.EXPOSED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WEATHERED_CUT_COPPER_WALL.get())
                .add(ModBlocks.OXIDIZED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WAXED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CUT_COPPER_WALL.get())
                .add(ModBlocks.EXPOSED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WEATHERED_CUT_COPPER_WALL.get())
                .add(ModBlocks.OXIDIZED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WAXED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.CUT_COPPER_WALL.get())
                .add(ModBlocks.EXPOSED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WEATHERED_CUT_COPPER_WALL.get())
                .add(ModBlocks.OXIDIZED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WAXED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_WALL.get())
                .add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL.get());
    }
}
