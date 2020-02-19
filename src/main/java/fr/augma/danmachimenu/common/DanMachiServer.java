package fr.augma.danmachimenu.common;

import java.io.File;

import fr.augma.danmachimenu.gui.GuiCustomMainMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DanMachiServer extends DanMachiCommon {
	@Override
	public void preInit(File configFile)
	{
		super.preInit(configFile);
		System.out.println("pre init coté server");
	}
	
	@Override
	public void init()
	{
		super.init();
	}
}
