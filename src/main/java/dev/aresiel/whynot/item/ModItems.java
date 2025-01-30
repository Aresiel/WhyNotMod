package dev.aresiel.whynot.item;

import dev.aresiel.whynot.WhyNotMod;
import dev.aresiel.whynot.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, WhyNotMod.MODID);

    public static final RegistryObject<Item> OXIDIZED_CUT_COPPER_WALL = REGISTRY.register("oxidized_cut_copper_wall", () -> new BlockItem(ModBlocks.OXIDIZED_CUT_COPPER_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> WEATHERED_CUT_COPPER_WALL = REGISTRY.register("weathered_cut_copper_wall", () -> new BlockItem(ModBlocks.WEATHERED_CUT_COPPER_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> EXPOSED_CUT_COPPER_WALL = REGISTRY.register("exposed_cut_copper_wall", () -> new BlockItem(ModBlocks.EXPOSED_CUT_COPPER_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> CUT_COPPER_WALL = REGISTRY.register("cut_copper_wall", () -> new BlockItem(ModBlocks.CUT_COPPER_WALL.get(), new Item.Properties()));

    public static final RegistryObject<Item> WAXED_OXIDIZED_CUT_COPPER_WALL = REGISTRY.register("waxed_oxidized_cut_copper_wall", () -> new BlockItem(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> WAXED_WEATHERED_CUT_COPPER_WALL = REGISTRY.register("waxed_weathered_cut_copper_wall", () -> new BlockItem(ModBlocks.WAXED_WEATHERED_CUT_COPPER_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> WAXED_EXPOSED_CUT_COPPER_WALL = REGISTRY.register("waxed_exposed_cut_copper_wall", () -> new BlockItem(ModBlocks.WAXED_EXPOSED_CUT_COPPER_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> WAXED_CUT_COPPER_WALL = REGISTRY.register("waxed_cut_copper_wall", () -> new BlockItem(ModBlocks.WAXED_CUT_COPPER_WALL.get(), new Item.Properties()));
}
