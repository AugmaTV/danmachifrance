package fr.augma.danmachimenu.listeners;

import fr.augma.danmachimenu.DanMachiMenuMain;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerRespawnEvent {

	@SubscribeEvent
	public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
		if(!event.player.world.isRemote) {
			event.player.getCapability(DanMachiMenuMain.DMM_CAP, null).sync();
		}
	}
}
