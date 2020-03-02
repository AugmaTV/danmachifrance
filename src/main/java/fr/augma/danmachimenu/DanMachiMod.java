package fr.augma.danmachimenu;

import fr.augma.danmachimenu.capabilities.PlayerDataCapProvider;
import fr.augma.danmachimenu.commands.CommandAdminGetXp;
import fr.augma.danmachimenu.commands.CommandAdminReset;
import fr.augma.danmachimenu.commands.CommandLevelUp;
import fr.augma.danmachimenu.commands.CommandRefresh;
import fr.augma.danmachimenu.commands.CommandStats;
import fr.augma.danmachimenu.commands.CommandSword;
import fr.augma.danmachimenu.common.DanMachiCommon;
import fr.augma.danmachimenu.ctabs.CreativeTab;
import fr.augma.danmachimenu.init.BlocksMod;
import fr.augma.danmachimenu.init.ItemsMod;
import fr.augma.danmachimenu.network.SCPacketPlayerDataCap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

@Mod(modid = DanMachiMod.MODID, name = DanMachiMod.NAME, version = DanMachiMod.VERSION)
public class DanMachiMod {

    public static final String MODID = "dmm";
    public static final String NAME = "DanMachi France Menu";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";

    public static final CreativeTabs DANMACHITAB = new CreativeTab(MODID);

    @Instance(MODID)
    public static DanMachiMod INSTANCE;
    
    @SidedProxy(clientSide = "fr.augma.danmachimenu.common.DanMachiClient", serverSide = "fr.augma.danmachimenu.common.DanMachiServer")
    public static DanMachiCommon proxy;
    public static SimpleNetworkWrapper network;
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event.getSuggestedConfigurationFile());
        BlocksMod.init();
        ItemsMod.init();

        network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
        network.registerMessage(SCPacketPlayerDataCap.Handler.class, SCPacketPlayerDataCap.class, 3, Side.CLIENT);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
        PlayerDataCapProvider.register();
    }

    @EventHandler
    public void serverInit(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandStats());
        event.registerServerCommand(new CommandSword());
        event.registerServerCommand(new CommandRefresh());
        event.registerServerCommand(new CommandAdminReset());
        event.registerServerCommand(new CommandAdminGetXp());
        event.registerServerCommand(new CommandLevelUp());
    }
}
