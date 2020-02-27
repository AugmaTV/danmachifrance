package fr.augma.danmachimenu.events;

import fr.augma.danmachimenu.capabilities.IPlayerDataCap;
import fr.augma.danmachimenu.capabilities.PlayerDataCapProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber
public class CommonEventHandler {

    @SubscribeEvent
    public static void onAttachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(PlayerDataCapProvider.NAME, new PlayerDataCapProvider());
        }
    }

    @SubscribeEvent
    public static void playerPickupXP(PlayerPickupXpEvent e) {
        if (!e.getEntityPlayer().world.isRemote) {
            EntityPlayer p = e.getEntityPlayer();
            e.setCanceled(true);
            e.getOrb().setDead();
            p.getCapability(PlayerDataCapProvider.CAPABILITY, null).addXP(e.getOrb().xpValue);
            PlayerDataCapProvider.sync(e.getEntityPlayer());
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinEvent(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.player instanceof EntityPlayer) {
            if (event.player.experienceLevel == 0) {
                event.player.addExperienceLevel(1);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerAttackEntity(LivingHurtEvent event) {
        if (event.getSource().getTrueSource() instanceof EntityPlayer && !event.getEntityLiving().world.isRemote) {
            event.setAmount(event.getAmount() * 1.58F);
            event.getSource().getTrueSource().sendMessage(new TextComponentString("" +event.getAmount() + " " + event.getEntityLiving().getName()));
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(net.minecraftforge.event.entity.player.PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            if (event.getOriginal().hasCapability(PlayerDataCapProvider.CAPABILITY, null)) {
                IPlayerDataCap cap = PlayerDataCapProvider.get(event.getOriginal());
                IPlayerDataCap newCap = PlayerDataCapProvider.get(event.getEntityPlayer());
                newCap.data(cap.data().copy());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        PlayerDataCapProvider.sync(event.player);
    }
}
