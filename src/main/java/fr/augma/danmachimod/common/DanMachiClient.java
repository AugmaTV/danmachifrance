package fr.augma.danmachimod.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreenAddServer;
import net.minecraft.client.gui.GuiScreenServerList;
import net.minecraft.client.gui.ServerSelectionList;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.GuiScrollingList;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import java.io.File;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import fr.augma.danmachimod.DanMachiMod;
import fr.augma.danmachimod.config.ConfigBase;
import fr.augma.danmachimod.gui.GuiCustomMainMenu;

public class DanMachiClient extends DanMachiCommon {
	
	public void setRPC(String state) {
		DiscordRPC lib = DiscordRPC.INSTANCE;
		String applicationId = "690143908520394783";
        String steamId = "";
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        lib.Discord_Initialize(applicationId, handlers, true, steamId);
        DiscordRichPresence presence = new DiscordRichPresence();
        presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
        presence.details = "discord.gg/hEpxS7X";
        presence.state = state;
        presence.largeImageKey = "test";
        presence.largeImageText = "discord.gg/hEpxS7X";
        lib.Discord_UpdatePresence(presence);
        // in a worker thread
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
        }, "RPC-Callback-Handler").start();
	}

    @Override
    public void preInit(File configFile) {
        super.preInit(configFile);
        System.out.println("pre init coté client");
        setRPC("Chargement de DMF");
    }

    @Override
    public void init() {
        super.init();
        MinecraftForge.EVENT_BUS.register(this);
        setRPC("Menu principale");
    }

    @SubscribeEvent
    public void onOpenGui(GuiOpenEvent event) {
        if (event.getGui() != null && event.getGui().getClass() == GuiMainMenu.class) {
            event.setGui(new GuiCustomMainMenu());
        } else if(event.getGui() != null && event.getGui().getClass() == GuiMultiplayer.class) {
        	event.setGui(new GuiCustomMainMenu());
        }
    }
    
    @SubscribeEvent
    public void onConnectServer(FMLNetworkEvent.ClientConnectedToServerEvent e) {
    	setRPC("Connecté sur DMF");
    }
    
    @SubscribeEvent
    public void onDisconnectServer(FMLNetworkEvent.ClientDisconnectionFromServerEvent e) {
    	setRPC("Menu principale");
    }
}
