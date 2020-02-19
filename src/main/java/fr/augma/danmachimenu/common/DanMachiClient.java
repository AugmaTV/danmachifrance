package fr.augma.danmachimenu.common;

import java.io.File;

import fr.augma.danmachimenu.DanMachiMenuMain;
import fr.augma.danmachimenu.gui.GuiCustomMainMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DanMachiClient extends DanMachiCommon {
	@Override
	public void preInit(File configFile)
	{
		super.preInit(configFile);
		OBJLoader.INSTANCE.addDomain(DanMachiMenuMain.MODID);
		System.out.println("pre init coté client");
	}
	
	@Override
	public void init()
	{
		super.init();
		MinecraftForge.EVENT_BUS.register(this); 
	}
	
	@SubscribeEvent
	public void onOpenGui(GuiOpenEvent event)
	{
        if(event.getGui() != null && event.getGui().getClass() == GuiMainMenu.class)
        {
            event.setGui(new GuiCustomMainMenu());
        }
	}
}
