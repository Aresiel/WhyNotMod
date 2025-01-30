package dev.aresiel.whynot.datagen;

import dev.aresiel.whynot.WhyNotMod;
import dev.aresiel.whynot.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper efh) {
        super(output, WhyNotMod.MODID, efh);
    }

    @Override
    protected void registerStatesAndModels() {
        wallBlock(ModBlocks.CUT_COPPER_WALL.get(), blockTexture(Blocks.CUT_COPPER));
        wallBlock(ModBlocks.EXPOSED_CUT_COPPER_WALL.get(), blockTexture(Blocks.EXPOSED_CUT_COPPER));
        wallBlock(ModBlocks.OXIDIZED_CUT_COPPER_WALL.get(), blockTexture(Blocks.OXIDIZED_CUT_COPPER));
        wallBlock(ModBlocks.WEATHERED_CUT_COPPER_WALL.get(), blockTexture(Blocks.WEATHERED_CUT_COPPER));

        wallBlock(ModBlocks.WAXED_CUT_COPPER_WALL.get(), blockTexture(Blocks.CUT_COPPER));
        wallBlock(ModBlocks.WAXED_EXPOSED_CUT_COPPER_WALL.get(), blockTexture(Blocks.EXPOSED_CUT_COPPER));
        wallBlock(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL.get(), blockTexture(Blocks.OXIDIZED_CUT_COPPER));
        wallBlock(ModBlocks.WAXED_WEATHERED_CUT_COPPER_WALL.get(), blockTexture(Blocks.WEATHERED_CUT_COPPER));
    }
}
