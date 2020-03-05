package fr.augma.danmachimod.ctabs;

import fr.augma.danmachimod.init.ItemsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {

    public CreativeTab(String label) {
        super(label);
    }

    public ItemStack getTabIconItem() {
        return new ItemStack(ItemsMod.itemtuto);
    }

}
