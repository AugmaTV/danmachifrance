package fr.augma.danmachimod.items;

import java.util.List;

import fr.augma.danmachimod.DanMachiMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DMItemBasic extends Item {

    public DMItemBasic(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DanMachiMod.DANMACHITAB);
    }
}
