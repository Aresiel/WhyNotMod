package dev.aresiel.whynot;

import com.mojang.logging.LogUtils;
import dev.aresiel.whynot.block.ModBlocks;
import dev.aresiel.whynot.hacks.WeatheringCopperHack;
import dev.aresiel.whynot.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WhyNotMod.MODID)
public class WhyNotMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "whynot";

    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    public WhyNotMod()
    {
        // Mod-specific event bus, all events here must implement IModBusEvent
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        // Register the Deferred Register to the mod event bus so blocks get registered
        ModBlocks.REGISTRY.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ModItems.REGISTRY.register(modEventBus);


        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));

        WeatheringCopperHack.init();
    }

    public void addCreative(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.OXIDIZED_CUT_COPPER_WALL);
            event.accept(ModBlocks.WEATHERED_CUT_COPPER_WALL);
            event.accept(ModBlocks.EXPOSED_CUT_COPPER_WALL);
            event.accept(ModBlocks.CUT_COPPER_WALL);
            event.accept(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL);
            event.accept(ModBlocks.WAXED_WEATHERED_CUT_COPPER_WALL);
            event.accept(ModBlocks.WAXED_EXPOSED_CUT_COPPER_WALL);
            event.accept(ModBlocks.WAXED_CUT_COPPER_WALL);
        }
    }
}
