package dev.aresiel.whynot.hacks;

import com.dwarveddonuts.neverwinter.handle.AccessType;
import com.dwarveddonuts.neverwinter.handle.Handles;
import com.dwarveddonuts.neverwinter.handle.RequestType;
import com.dwarveddonuts.neverwinter.unsafe.FieldAddress;
import com.dwarveddonuts.neverwinter.unsafe.TypedUnsafe;
import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import cpw.mods.modlauncher.api.INameMappingService;
import dev.aresiel.whynot.WhyNotMod;
import dev.aresiel.whynot.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.util.function.Supplier;

public class WeatheringCopperHack {



    // Safer Method but does not work as SET accessmodes aren't supported on the handles for some reason
//    private static final VarHandle nextByBlockHandle = Handles.linkField(RequestType.trusted(), AccessType.staticAccess(), WeatheringCopper.class, ObfuscationReflectionHelper.remapName(INameMappingService.Domain.FIELD, "f_154886_"), Supplier.class);
//    private static final VarHandle previousByBlockHandle = Handles.linkField(RequestType.trusted(), AccessType.staticAccess(), WeatheringCopper.class, ObfuscationReflectionHelper.remapName(INameMappingService.Domain.FIELD, "f_154887_"), Supplier.class);
//
//    public static void init() {
//        WhyNotMod.LOGGER.info("Adding custom aging copper...");
//
//        Supplier<BiMap<Block, Block>> EXISTING_NEXT_BY_BLOCK = (Supplier<BiMap<Block, Block>>) nextByBlockHandle.get();
//
//        Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder().putAll(EXISTING_NEXT_BY_BLOCK.get())
//                .put(ModBlocks.CUT_COPPER_WALL.get(), ModBlocks.EXPOSED_CUT_COPPER_WALL.get())
//                .put(ModBlocks.EXPOSED_CUT_COPPER_WALL.get(), ModBlocks.WEATHERED_CUT_COPPER_WALL.get())
//                .put(ModBlocks.WEATHERED_CUT_COPPER_WALL.get(), ModBlocks.OXIDIZED_CUT_COPPER_WALL.get())
//                .build()
//        );
//
//        Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> NEXT_BY_BLOCK.get().inverse());
//
//        nextByBlockHandle.set(NEXT_BY_BLOCK);
//        previousByBlockHandle.set(PREVIOUS_BY_BLOCK);
//    }

    // Unsafe method
    public static void init() {
        WhyNotMod.LOGGER.info("Adding custom aging copper...");

        Field nextByBlockField = ObfuscationReflectionHelper.findField(WeatheringCopper.class, "f_154886_"); // NEXT_BY_BLOCK
        Field previousByBlockField = ObfuscationReflectionHelper.findField(WeatheringCopper.class, "f_154887_"); // PREVIOUS_BY_BLOCK

        FieldAddress<Supplier<BiMap<Block, Block>>> nextByBlockFieldAddress = TypedUnsafe.fieldAddress(nextByBlockField);
        FieldAddress<Supplier<BiMap<Block, Block>>> previousByBlockFieldAddress = TypedUnsafe.fieldAddress(previousByBlockField);

        Supplier<BiMap<Block, Block>> EXISTING_NEXT_BY_BLOCK = TypedUnsafe.get(nextByBlockFieldAddress);

        Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder().putAll(EXISTING_NEXT_BY_BLOCK.get())
                .put(ModBlocks.CUT_COPPER_WALL.get(), ModBlocks.EXPOSED_CUT_COPPER_WALL.get())
                .put(ModBlocks.EXPOSED_CUT_COPPER_WALL.get(), ModBlocks.WEATHERED_CUT_COPPER_WALL.get())
                .put(ModBlocks.WEATHERED_CUT_COPPER_WALL.get(), ModBlocks.OXIDIZED_CUT_COPPER_WALL.get())
                .build()
        );

        Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> NEXT_BY_BLOCK.get().inverse());

        TypedUnsafe.put(nextByBlockFieldAddress, NEXT_BY_BLOCK);
        TypedUnsafe.put(previousByBlockFieldAddress, PREVIOUS_BY_BLOCK);


    }
}
