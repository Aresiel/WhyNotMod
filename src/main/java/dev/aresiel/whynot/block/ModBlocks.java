package dev.aresiel.whynot.block;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import dev.aresiel.whynot.WhyNotMod;
import dev.aresiel.whynot.mixin.HoneycombItemMixin;
import it.unimi.dsi.fastutil.Hash;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, WhyNotMod.MODID);

    public static final RegistryObject<WallBlock> OXIDIZED_CUT_COPPER_WALL = REGISTRY.register("oxidized_cut_copper_wall", () -> new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.OXIDIZED_CUT_COPPER)));
    public static final RegistryObject<WallBlock> WEATHERED_CUT_COPPER_WALL = REGISTRY.register("weathered_cut_copper_wall", () -> new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WEATHERED_COPPER)));
    public static final RegistryObject<WallBlock> EXPOSED_CUT_COPPER_WALL = REGISTRY.register("exposed_cut_copper_wall", () -> new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.EXPOSED_COPPER)));
    public static final RegistryObject<WallBlock> CUT_COPPER_WALL = REGISTRY.register("cut_copper_wall", () -> new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COPPER_BLOCK)));

    public static final RegistryObject<WallBlock> WAXED_OXIDIZED_CUT_COPPER_WALL = REGISTRY.register("waxed_oxidized_cut_copper_wall", () -> new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WAXED_OXIDIZED_CUT_COPPER)));
    public static final RegistryObject<WallBlock> WAXED_WEATHERED_CUT_COPPER_WALL = REGISTRY.register("waxed_weathered_cut_copper_wall", () -> new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WAXED_WEATHERED_COPPER)));
    public static final RegistryObject<WallBlock> WAXED_EXPOSED_CUT_COPPER_WALL = REGISTRY.register("waxed_exposed_cut_copper_wall", () -> new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WAXED_EXPOSED_COPPER)));
    public static final RegistryObject<WallBlock> WAXED_CUT_COPPER_WALL = REGISTRY.register("waxed_cut_copper_wall", () -> new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WAXED_COPPER_BLOCK)));
}
