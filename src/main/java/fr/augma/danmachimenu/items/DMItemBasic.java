package fr.augma.danmachimenu.items;

import fr.augma.danmachimenu.DanMachiMod;
import net.minecraft.item.Item;

public class DMItemBasic extends Item {

    public DMItemBasic(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DanMachiMod.DANMACHITAB);
    }
}
