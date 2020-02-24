package fr.augma.danmachimenu.listeners;

import fr.augma.danmachimenu.DanMachiMenuMain;
import fr.augma.danmachimenu.capabilities.DmmCapabilitiesProvider;
import fr.augma.danmachimenu.capabilities.PacketCapabilitiesDmm;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerOnCloneEvent {

	@SubscribeEvent
	public void onPlayerCloned(PlayerEvent.Clone event) {
		if(event.isWasDeath()) {
			if(event.getOriginal().hasCapability(DanMachiMenuMain.DMM_CAP, null)) {
				DmmCapabilitiesProvider cap = event.getOriginal().getCapability(DanMachiMenuMain.DMM_CAP, null);
				DmmCapabilitiesProvider newCap = event.getEntityPlayer().getCapability(DanMachiMenuMain.DMM_CAP, null);
				newCap.setXpCount(cap.getXpCount());
				newCap.setForcelvl1(cap.getForcelvl1());
				newCap.setDefenselvl1(cap.getDefenselvl1());
				newCap.setAgilitelvl1(cap.getAgilitelvl1());
				newCap.setDexteritelvl1(cap.getDexteritelvl1());
				newCap.setMagielvl1(cap.getMagielvl1());
			}
		}
	}
}
