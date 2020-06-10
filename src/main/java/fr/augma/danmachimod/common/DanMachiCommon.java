package fr.augma.danmachimod.common;

import java.io.File;

import fr.augma.danmachimod.DanMachiMod;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class DanMachiCommon {

    public void preInit(File configFile) {
        System.out.println("pre init coté commun");
    }

    public void init() {
    	
    }

}
