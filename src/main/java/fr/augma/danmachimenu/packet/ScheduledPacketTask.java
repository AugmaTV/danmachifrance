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
		player.getCapability(DanMachiMenuMain.DMM_CAP, null).setMoney(message.money);
	}

	@SideOnly(Side.CLIENT)
	private EntityPlayer getPlayer() {
		return Minecraft.getMinecraft().player;
	}
}
