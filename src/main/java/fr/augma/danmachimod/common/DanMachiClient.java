package fr.augma.danmachimod.common;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

import fr.augma.danmachimod.DanMachiMod;
import fr.augma.danmachimod.gui.GuiCustomMainMenu;

public class DanMachiClient extends DanMachiCommon {

    @Override
    public void preInit(File configFile) {
        super.preInit(configFile);
        OBJLoader.INSTANCE.addDomain(DanMachiMod.MODID);
        System.out.println("pre init coté client");
    }

    @Override
    public void init() {
        super.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onOpenGui(GuiOpenEvent event) {
        if (event.getGui() != null && event.getGui().getClass() == GuiMainMenu.class) {
            event.setGui(new GuiCustomMainMenu());
        }
    }
}
