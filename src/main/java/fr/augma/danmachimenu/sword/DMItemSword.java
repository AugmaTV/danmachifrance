package fr.augma.danmachimenu.sword;

import fr.augma.danmachimenu.DanMachiMod;
import net.minecraft.item.ItemSword;

public class DMItemSword extends ItemSword {

    public DMItemSword(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DanMachiMod.DANMACHITAB);
    }
}
