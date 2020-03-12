package fr.augma.danmachimod.common;

import java.io.File;

import fr.augma.danmachimod.DanMachiMod;
import fr.augma.danmachimod.config.ConfigBase;

public class DanMachiServer extends DanMachiCommon {
	public static ConfigBase modConfig;
	public static ConfigBase dataFamilia;
	
    @Override
    public void preInit(File configFile) {
        super.preInit(configFile);
        System.out.println("pre init coté server");

        modConfig = new ConfigBase(DanMachiMod.MODID);
        modConfig.writeConfig("test", "JeanNeyMarre", "oui");
        modConfig.writeConfig("test", "JeanPeuPlus", "non");
        
        dataFamilia = new ConfigBase("data/familia");
        dataFamilia.writeConfig("FamiliaName", "Leader", "Akuma");
    }

    @Override
    public void init() {
        super.init();
    }
}
