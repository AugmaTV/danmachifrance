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
    public static ToolMaterial hestia_material;
    public static Item hestia_dagger;

    public static ToolMaterial hestia_material_2;
    public static Item hestia_dagger_2;
    
    public static ToolMaterial starter_scythe_material;
    public static Item starter_scythe;
    
    public static Item cristalBlueLittle;
    public static Item cristalAmberLittle;
    public static Item cristalGreenLittle;
    public static Item cristalPurpleLittle;
    public static Item cristalRedLittle;
    public static Item cristalWhiteLittle;
    
    public static Item wooden_valis;
    public static Item stone_valis;
    public static Item copper_valis;
    public static Item silver_valis;
    public static Item gold_valis;
    public static Item diamond_valis;
    public static Item royale_valis;
    
    public static Item valis_pouch;
    
    public static void init() {
        cristalBlueLittle = new DMItemBasic("cristal_blue_little");
        cristalAmberLittle = new DMItemBasic("cristal_amber_little");
        cristalGreenLittle = new DMItemBasic("cristal_green_little");
        cristalPurpleLittle = new DMItemBasic("cristal_purple_little");
        cristalRedLittle = new DMItemBasic("cristal_red_little");
        cristalWhiteLittle = new DMItemBasic("cristal_white_little");
        
        wooden_valis = new DMItemBasic("wooden_valis");
        stone_valis = new DMItemBasic("stone_valis");
        copper_valis = new DMItemBasic("copper_valis");
        silver_valis = new DMItemBasic("silver_valis");
        gold_valis = new DMItemBasic("gold_valis");
        diamond_valis = new DMItemBasic("diamond_valis");
        royale_valis = new DMItemBasic("royale_valis");
        
        valis_pouch = new DMItemBasic("valis_pouch");

        hestia_material = EnumHelper.addToolMaterial("hestia_dagger", 0, 4000, 20.0F, 5, 22);
        hestia_dagger = new DMItemSword("hestia_dagger", hestia_material);
        
        starter_scythe_material = EnumHelper.addToolMaterial("starter_scythe", 0, 4000, 20.0F, 5, 22);
        starter_scythe = new DMItemSword("starter_scythe", starter_scythe_material);

        hestia_material_2 = EnumHelper.addToolMaterial("hestia_dagger_2", 0, 4000, 20.0F, 5, 22);
        hestia_dagger_2 = new DMItemSword("hestia_dagger_2", hestia_material_2);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(hestia_dagger, hestia_dagger_2, cristalBlueLittle, cristalAmberLittle, cristalGreenLittle, cristalPurpleLittle, cristalRedLittle
        		, cristalWhiteLittle, starter_scythe, valis_pouch, wooden_valis, stone_valis, copper_valis, silver_valis, gold_valis, diamond_valis, royale_valis);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(hestia_dagger);
        registerRender(hestia_dagger_2);
        registerRender(cristalBlueLittle);
        registerRender(cristalAmberLittle);
        registerRender(cristalGreenLittle);
        registerRender(cristalPurpleLittle);
        registerRender(cristalRedLittle);
        registerRender(cristalWhiteLittle);
        registerRender(starter_scythe);
        registerRender(valis_pouch);
        registerRender(wooden_valis);
        registerRender(stone_valis);
        registerRender(copper_valis);
        registerRender(silver_valis);
        registerRender(gold_valis);
        registerRender(diamond_valis);
        registerRender(royale_valis);
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
