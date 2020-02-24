package fr.augma.danmachimenu.listeners;

import fr.augma.danmachimenu.DanMachiMenuMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerGetXpEvent {
	@SubscribeEvent
	public void playerPickupXP(PlayerPickupXpEvent e) {
		EntityPlayer p = e.getEntityPlayer();
		e.setCanceled(true);
		e.getOrb().setDead();
		p.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount() + e.getOrb().xpValue);
	}
}
