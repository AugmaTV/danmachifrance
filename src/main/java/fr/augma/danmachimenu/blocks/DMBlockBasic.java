package fr.augma.danmachimenu.blocks;

import fr.augma.danmachimenu.DanMachiMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DMBlockBasic extends Block {

    public DMBlockBasic(String name, Material mat) {
        super(mat);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DanMachiMod.DANMACHITAB);
    }
}
