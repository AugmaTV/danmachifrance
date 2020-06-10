package fr.augma.danmachimod;

import net.minecraft.client.Minecraft;
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
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

import java.awt.Color;

import org.apache.logging.log4j.Logger;

import club.minnced.discord.rpc.*;
import fr.augma.danmachimod.capabilities.PlayerDataCapProvider;
import fr.augma.danmachimod.commands.CommandDmf;
import fr.augma.danmachimod.commands.CommandDmfAdmin;
import fr.augma.danmachimod.commands.CommandFamilia;
import fr.augma.danmachimod.common.DanMachiCommon;
import fr.augma.danmachimod.ctabs.CreativeTab;
import fr.augma.danmachimod.init.BlocksMod;
import fr.augma.danmachimod.init.ItemsMod;
import fr.augma.danmachimod.network.SCPacketPlayerDataCap;

@Mod(modid = DanMachiMod.MODID, name = DanMachiMod.NAME, version = DanMachiMod.VERSION)
public class DanMachiMod {

    public static final String MODID = "dmm";
    public static final String NAME = "DanMachiFranceMod";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";

    public static final CreativeTabs DANMACHITAB = new CreativeTab(MODID);

    @Instance(MODID)
    public static DanMachiMod INSTANCE;
    
    @SidedProxy(clientSide = "fr.augma.danmachimod.common.DanMachiClient", serverSide = "fr.augma.danmachimod.common.DanMachiServer")
    public static DanMachiCommon proxy;
    public static SimpleNetworkWrapper network;
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event.getSuggestedConfigurationFile());
        BlocksMod.init();
        ItemsMod.init();
        //NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());

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
        event.registerServerCommand(new CommandDmf());
        event.registerServerCommand(new CommandDmfAdmin());
        event.registerServerCommand(new CommandFamilia());
    }
}
