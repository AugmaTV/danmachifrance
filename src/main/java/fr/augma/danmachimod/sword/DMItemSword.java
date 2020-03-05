package fr.augma.danmachimod.sword;

import fr.augma.danmachimod.DanMachiMod;
import net.minecraft.item.ItemSword;

public class DMItemSword extends ItemSword {

    public DMItemSword(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DanMachiMod.DANMACHITAB);
    }
}
