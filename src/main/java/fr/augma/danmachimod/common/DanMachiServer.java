package fr.augma.danmachimod.common;

import java.io.File;

import fr.augma.danmachimod.DanMachiMod;
import fr.augma.danmachimod.commands.CommandFamilia;
import fr.augma.danmachimod.config.ConfigBase;

public class DanMachiServer extends DanMachiCommon {
	public static ConfigBase modConfig;
	public static ConfigBase dataFamilia;
	public static ConfigBase dataPlayer;
	
    @Override
    public void preInit(File configFile) {
        super.preInit(configFile);
        System.out.println("pre init coté server");

        modConfig = new ConfigBase(DanMachiMod.MODID);
        dataPlayer = new ConfigBase("data/player");
        dataFamilia = new ConfigBase("data/familia");
    }

    @Override
    public void init() {
        super.init();
    }
}
