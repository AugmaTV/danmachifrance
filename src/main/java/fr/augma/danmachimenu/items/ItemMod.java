package fr.augma.danmachimenu.items;

import fr.augma.danmachimenu.DanMachiMenuMain;
import net.minecraft.item.Item;

public class ItemMod extends Item {
	
	public ItemMod(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DanMachiMenuMain.dmmTabs);
	}
}
