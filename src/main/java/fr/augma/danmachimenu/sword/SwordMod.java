package fr.augma.danmachimenu.sword;

import fr.augma.danmachimenu.DanMachiMenuMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class SwordMod extends ItemSword {

	public SwordMod(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DanMachiMenuMain.dmmTabs);
	}
}
