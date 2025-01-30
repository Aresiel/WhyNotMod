package dev.aresiel.whynot.mixin;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

/* OBSERVE!!!
 * Does not work at the moment, since injecting into interfaces is not supported on stock Mixin
 * See WeatheringCopperHack for present workaround.
 */
@Mixin(WeatheringCopper.class)
public class WeatheringCopperMixin {

    @Mutable
    @Shadow @Final public static Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK;

    @Mutable
    @Shadow @Final public static Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void makeBlockAgeStatesMutable(CallbackInfo ci) {
        var nextByBlock = NEXT_BY_BLOCK.get();
        var previousByBlock = PREVIOUS_BY_BLOCK.get();

        var newNextByBlock = HashBiMap.create(nextByBlock);
        var newPreviousByBlock = HashBiMap.create(previousByBlock);

        NEXT_BY_BLOCK = () -> newNextByBlock;
        PREVIOUS_BY_BLOCK = () -> newPreviousByBlock;
    }
}