package dev.aresiel.whynot.mixin;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import dev.aresiel.whynot.WhyNotMod;
import dev.aresiel.whynot.block.ModBlocks;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(HoneycombItem.class)
public class HoneycombItemMixin {
    @Mutable
    @Shadow @Final public static Supplier<BiMap<Block, Block>> WAXABLES;

    @Mutable
    @Shadow @Final public static Supplier<BiMap<Block, Block>> WAX_OFF_BY_BLOCK;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void makeWaxablesMutable(CallbackInfo ci) {
        WhyNotMod.LOGGER.info("Adding custom waxables...");

        var EXISTING_WAXABLES = WAXABLES;

        WAXABLES = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder().putAll(EXISTING_WAXABLES.get())
                .put(ModBlocks.CUT_COPPER_WALL.get(), ModBlocks.WAXED_CUT_COPPER_WALL.get())
                .put(ModBlocks.EXPOSED_CUT_COPPER_WALL.get(), ModBlocks.WAXED_EXPOSED_CUT_COPPER_WALL.get())
                .put(ModBlocks.WEATHERED_CUT_COPPER_WALL.get(), ModBlocks.WAXED_WEATHERED_CUT_COPPER_WALL.get())
                .put(ModBlocks.OXIDIZED_CUT_COPPER_WALL.get(), ModBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL.get())
                .build()
        );

        WAX_OFF_BY_BLOCK = Suppliers.memoize(() -> WAXABLES.get().inverse());
    }
}
