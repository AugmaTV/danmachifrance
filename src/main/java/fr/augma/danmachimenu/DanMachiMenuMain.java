package fr.augma.danmachimenu;

import net.minecraft.client.main.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.apache.logging.log4j.Logger;

import fr.augma.danmachimenu.commands.CommandStats;
import fr.augma.danmachimenu.common.DanMachiCommon;
import fr.augma.danmachimenu.ctabs.CreativeTab;
import fr.augma.danmachimenu.init.BlocksMod;
import fr.augma.danmachimenu.init.ItemsMod;

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

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event.getSuggestedConfigurationFile());
        BlocksMod.init();
        ItemsMod.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }
    
    @EventHandler
    public void serverInit(FMLServerStartingEvent event)
    {
        //event.registerServerCommand(new CommandStats());
    }
}
