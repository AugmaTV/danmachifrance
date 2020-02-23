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
				newCap.setMoney(cap.getMoney());
			}
		}
	}
}
