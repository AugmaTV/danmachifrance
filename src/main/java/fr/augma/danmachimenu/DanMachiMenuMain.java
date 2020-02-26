package fr.augma.danmachimenu;

import net.minecraft.client.main.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import org.apache.logging.log4j.Logger;

import fr.augma.danmachimenu.capabilities.DmmCapabilitiesProvider;
import fr.augma.danmachimenu.capabilities.PacketCapabilitiesDmm;
import fr.augma.danmachimenu.commands.CommandStats;
import fr.augma.danmachimenu.common.DanMachiCommon;
import fr.augma.danmachimenu.ctabs.CreativeTab;
import fr.augma.danmachimenu.init.BlocksMod;
import fr.augma.danmachimenu.init.ItemsMod;
import fr.augma.danmachimenu.listeners.AttachCapabilityEvent;
import fr.augma.danmachimenu.listeners.PlayerAttackEntityEvent;
import fr.augma.danmachimenu.listeners.PlayerGetXpEvent;
import fr.augma.danmachimenu.listeners.PlayerJoinEvent;
import fr.augma.danmachimenu.listeners.PlayerOnCloneEvent;
import fr.augma.danmachimenu.listeners.PlayerRespawnEvent;

@Mod(modid = DanMachiMenuMain.MODID, name = DanMachiMenuMain.NAME, version = DanMachiMenuMain.VERSION)
public class DanMachiMenuMain
{
    public static final String MODID = "dmm";
    public static final String NAME = "DanMachi France Menu";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";
    
    public static final CreativeTabs dmmTabs = new CreativeTab("danmachitab");
    
    @Instance(value = MODID)
    public static DanMachiMenuMain INSTANCE;
    
    @SidedProxy(clientSide = "fr.augma.danmachimenu.common.DanMachiClient", serverSide = "fr.augma.danmachimenu.common.DanMachiServer")
    public static DanMachiCommon proxy;

    @CapabilityInject(PacketCapabilitiesDmm.class)
    public static final Capability<DmmCapabilitiesProvider> DMM_CAP = null;
    
    private static Logger logger;
    
    public static SimpleNetworkWrapper network;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new PlayerOnCloneEvent());
        MinecraftForge.EVENT_BUS.register(new AttachCapabilityEvent());
        MinecraftForge.EVENT_BUS.register(new PlayerRespawnEvent());
        MinecraftForge.EVENT_BUS.register(new PlayerJoinEvent());
        MinecraftForge.EVENT_BUS.register(new PlayerGetXpEvent());
        MinecraftForge.EVENT_BUS.register(new PlayerAttackEntityEvent());
        BlocksMod.init();
        ItemsMod.init();
        network = NetworkRegistry.INSTANCE.newSimpleChannel("dmmAttribute");
        network.registerMessage(PacketCapabilitiesDmm.ClientHandler.class, PacketCapabilitiesDmm.class, 3, Side.CLIENT);
        network.registerMessage(PacketCapabilitiesDmm.ServerHandler.class, PacketCapabilitiesDmm.class, 3, Side.SERVER);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
        DmmCapabilitiesProvider.register();
    }
    
    @EventHandler
    public void serverInit(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandStats());
    }
}
