package fr.augma.danmachimenu.listeners;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetHandler;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class PlayerJoinEvent {
	
	public PlayerJoinEvent() {}
	
	@SubscribeEvent
	public void onPlayerJoinEvent(PlayerLoggedInEvent event) {
		if(event.player instanceof EntityPlayer) {
			if(event.player.experienceLevel == 0) {
				event.player.addExperienceLevel(1);
			}
		}
	}
}
