package fr.augma.danmachimod.common;

import java.io.File;

public class DanMachiServer extends DanMachiCommon {

    @Override
    public void preInit(File configFile) {
        super.preInit(configFile);
        System.out.println("pre init coté server");
    }

    @Override
    public void init() {
        super.init();
    }
}
