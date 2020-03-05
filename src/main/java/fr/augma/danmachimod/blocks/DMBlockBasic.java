package fr.augma.danmachimod.blocks;

import fr.augma.danmachimod.DanMachiMod;
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
