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
				newCap.setXpCount((int) (cap.getXpCount() * 0.25));
				//level 1
				newCap.setForcelvl1(cap.getForcelvl1());
				newCap.setEndurancelvl1(cap.getEndurancelvl1());
				newCap.setAgilitelvl1(cap.getAgilitelvl1());
				newCap.setDexteritelvl1(cap.getDexteritelvl1());
				newCap.setMagielvl1(cap.getMagielvl1());
				//level 2
				newCap.setForcelvl2(cap.getForcelvl2());
				newCap.setEndurancelvl2(cap.getEndurancelvl2());
				newCap.setAgilitelvl2(cap.getAgilitelvl2());
				newCap.setDexteritelvl2(cap.getDexteritelvl2());
				newCap.setMagielvl2(cap.getMagielvl2());
				//level 3
				newCap.setForcelvl3(cap.getForcelvl3());
				newCap.setEndurancelvl3(cap.getEndurancelvl3());
				newCap.setAgilitelvl3(cap.getAgilitelvl3());
				newCap.setDexteritelvl3(cap.getDexteritelvl3());
				newCap.setMagielvl3(cap.getMagielvl3());
				//level 4
				newCap.setForcelvl4(cap.getForcelvl4());
				newCap.setEndurancelvl4(cap.getEndurancelvl4());
				newCap.setAgilitelvl4(cap.getAgilitelvl4());
				newCap.setDexteritelvl4(cap.getDexteritelvl4());
				newCap.setMagielvl4(cap.getMagielvl4());
				//level 5
				newCap.setForcelvl5(cap.getForcelvl5());
				newCap.setEndurancelvl5(cap.getEndurancelvl5());
				newCap.setAgilitelvl5(cap.getAgilitelvl5());
				newCap.setDexteritelvl5(cap.getDexteritelvl5());
				newCap.setMagielvl5(cap.getMagielvl5());
				//level 6
				newCap.setForcelvl6(cap.getForcelvl6());
				newCap.setEndurancelvl6(cap.getEndurancelvl6());
				newCap.setAgilitelvl6(cap.getAgilitelvl6());
				newCap.setDexteritelvl6(cap.getDexteritelvl6());
				newCap.setMagielvl6(cap.getMagielvl6());
				//level 7
				newCap.setForcelvl7(cap.getForcelvl7());
				newCap.setEndurancelvl7(cap.getEndurancelvl7());
				newCap.setAgilitelvl7(cap.getAgilitelvl7());
				newCap.setDexteritelvl7(cap.getDexteritelvl7());
				newCap.setMagielvl7(cap.getMagielvl7());
				//level 8
				newCap.setForcelvl8(cap.getForcelvl8());
				newCap.setEndurancelvl8(cap.getEndurancelvl8());
				newCap.setAgilitelvl8(cap.getAgilitelvl8());
				newCap.setDexteritelvl8(cap.getDexteritelvl8());
				newCap.setMagielvl8(cap.getMagielvl8());
				//level 9
				newCap.setForcelvl9(cap.getForcelvl9());
				newCap.setEndurancelvl9(cap.getEndurancelvl9());
				newCap.setAgilitelvl9(cap.getAgilitelvl9());
				newCap.setDexteritelvl9(cap.getDexteritelvl9());
				newCap.setMagielvl9(cap.getMagielvl9());
				//level 10
				newCap.setForcelvl10(cap.getForcelvl10());
				newCap.setEndurancelvl10(cap.getEndurancelvl10());
				newCap.setAgilitelvl10(cap.getAgilitelvl10());
				newCap.setDexteritelvl10(cap.getDexteritelvl10());
				newCap.setMagielvl10(cap.getMagielvl10());
			}
		}
	}
}
