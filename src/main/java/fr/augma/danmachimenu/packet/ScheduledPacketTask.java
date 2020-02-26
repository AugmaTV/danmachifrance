package fr.augma.danmachimenu.packet;

import fr.augma.danmachimenu.DanMachiMenuMain;
import fr.augma.danmachimenu.capabilities.PacketCapabilitiesDmm;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ScheduledPacketTask implements Runnable {
	
	private EntityPlayer player;
	private PacketCapabilitiesDmm message;
	
	public ScheduledPacketTask(EntityPlayer player, PacketCapabilitiesDmm message) {
		this.player = player;
		this.message = message;
	}
	@Override
	public void run() {
		EntityPlayer player = this.player == null ? getPlayer() : this.player;
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(message.xpCount);
		//level 1
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl1(message.forcelvl1);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl1(message.endurancelvl1);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl1(message.agilitelvl1);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl1(message.dexteritelvl1);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl1(message.magielvl1);
		//level 2
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl2(message.forcelvl2);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl2(message.endurancelvl2);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl2(message.agilitelvl2);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl2(message.dexteritelvl2);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl2(message.magielvl2);
		//Level 3
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl3(message.forcelvl3);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl3(message.endurancelvl3);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl3(message.agilitelvl3);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl3(message.dexteritelvl3);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl3(message.magielvl3);
		//level 4
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl4(message.forcelvl4);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl4(message.endurancelvl4);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl4(message.agilitelvl4);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl4(message.dexteritelvl4);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl4(message.magielvl4);
		//level 5
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl5(message.forcelvl5);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl5(message.endurancelvl5);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl5(message.agilitelvl5);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl5(message.dexteritelvl5);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl5(message.magielvl5);
		//level 6
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl6(message.forcelvl6);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl6(message.endurancelvl6);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl6(message.agilitelvl6);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl6(message.dexteritelvl6);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl6(message.magielvl6);
		//level 7
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl7(message.forcelvl7);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl7(message.endurancelvl7);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl7(message.agilitelvl7);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl7(message.dexteritelvl7);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl7(message.magielvl7);
		//level 8
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl8(message.forcelvl8);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl8(message.endurancelvl8);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl8(message.agilitelvl8);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl8(message.dexteritelvl8);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl8(message.magielvl8);
		//level 9
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl9(message.forcelvl9);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl9(message.endurancelvl9);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl9(message.agilitelvl9);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl9(message.dexteritelvl9);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl9(message.magielvl9);
		//level 10
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl10(message.forcelvl10);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl10(message.endurancelvl10);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl10(message.agilitelvl10);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl10(message.dexteritelvl10);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl10(message.magielvl10);
	}

	@SideOnly(Side.CLIENT)
	private EntityPlayer getPlayer() {
		return Minecraft.getMinecraft().player;
	}
}
