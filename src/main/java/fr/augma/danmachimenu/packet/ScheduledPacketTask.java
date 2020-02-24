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
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl1(message.forcelvl1);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setDefenselvl1(message.defenselvl1);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl1(message.agilitelvl1);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl1(message.dexteritelvl1);
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl1(message.magielvl1);
	}

	@SideOnly(Side.CLIENT)
	private EntityPlayer getPlayer() {
		return Minecraft.getMinecraft().player;
	}
}
