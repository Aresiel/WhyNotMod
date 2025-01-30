package dev.aresiel.whynot.datagen;

import dev.aresiel.whynot.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_COPPER_WALL.get(), Items.CUT_COPPER);
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.EXPOSED_CUT_COPPER_WALL.get(), Items.EXPOSED_COPPER);
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.WEATHERED_CUT_COPPER_WALL.get(), Items.WEATHERED_COPPER);
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.OXIDIZED_CUT_COPPER_WALL.get(), Items.OXIDIZED_COPPER);

        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CUT_COPPER_WALL.get(), Items.WAXED_CUT_COPPER);
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXPOSED_CUT_COPPER_WALL.get(), Items.WAXED_EXPOSED_COPPER);
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_WEATHERED_CUT_COPPER_WALL.get(), Items.WAXED_WEATHERED_COPPER);
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_OXIDIZED_CUT_COPPER_WALL.get(), Items.WAXED_OXIDIZED_COPPER);
    }
}
