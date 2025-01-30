package dev.aresiel.whynot.datagen;

import dev.aresiel.whynot.WhyNotMod;
import dev.aresiel.whynot.block.ModBlocks;
import dev.aresiel.whynot.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WhyNotMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        wallInventory(ModItems.CUT_COPPER_WALL.getId().toString(), blockTexture(Blocks.CUT_COPPER));
        wallInventory(ModItems.EXPOSED_CUT_COPPER_WALL.getId().toString(), blockTexture(Blocks.EXPOSED_CUT_COPPER));
        wallInventory(ModItems.WEATHERED_CUT_COPPER_WALL.getId().toString(), blockTexture(Blocks.WEATHERED_CUT_COPPER));
        wallInventory(ModItems.OXIDIZED_CUT_COPPER_WALL.getId().toString(), blockTexture(Blocks.OXIDIZED_CUT_COPPER));

        wallInventory(ModItems.WAXED_CUT_COPPER_WALL.getId().toString(), blockTexture(Blocks.CUT_COPPER));
        wallInventory(ModItems.WAXED_EXPOSED_CUT_COPPER_WALL.getId().toString(), blockTexture(Blocks.EXPOSED_CUT_COPPER));
        wallInventory(ModItems.WAXED_WEATHERED_CUT_COPPER_WALL.getId().toString(), blockTexture(Blocks.WEATHERED_CUT_COPPER));
        wallInventory(ModItems.WAXED_OXIDIZED_CUT_COPPER_WALL.getId().toString(), blockTexture(Blocks.OXIDIZED_CUT_COPPER));
    }

    private static ResourceLocation blockTexture(Block block) {
        ResourceLocation name = ForgeRegistries.BLOCKS.getKey(block);
        return new ResourceLocation(name.getNamespace(), "block/" + name.getPath());
    }
}
