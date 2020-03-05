package fr.augma.danmachimod.init;

import fr.augma.danmachimod.DanMachiMod;
import fr.augma.danmachimod.items.DMItemBasic;
import fr.augma.danmachimod.sword.DMItemSword;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = DanMachiMod.MODID)
public class ItemsMod {

    public static Item itemtuto;

    public static ToolMaterial hestia_material;
    public static Item hestia_dagger;

    public static ToolMaterial hestia_material_2;
    public static Item hestia_dagger_2;

    public static void init() {
        itemtuto = new DMItemBasic("itemtuto");

        hestia_material = EnumHelper.addToolMaterial("hestia_dagger", 0, 4000, 20.0F, 5, 22);
        hestia_dagger = new DMItemSword("hestia_dagger", hestia_material);

        hestia_material_2 = EnumHelper.addToolMaterial("hestia_dagger_2", 0, 4000, 20.0F, 5, 22);
        hestia_dagger_2 = new DMItemSword("hestia_dagger_2", hestia_material_2);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(itemtuto, hestia_dagger, hestia_dagger_2);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(itemtuto);
        registerRender(hestia_dagger);
        registerRender(hestia_dagger_2);
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
