package fr.augma.danmachimenu.listeners;

import fr.augma.danmachimenu.DanMachiMenuMain;
import fr.augma.danmachimenu.capabilities.DmmCapabilitiesProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AttachCapabilityEvent {

	@SubscribeEvent
	public void onAttachCapability(AttachCapabilitiesEvent<Entity> event) {
		if(event.getObject() instanceof EntityPlayer) {
			event.addCapability(new ResourceLocation(DanMachiMenuMain.MODID + ":DMM_CAP"), new DmmCapabilitiesProvider((EntityPlayer) event.getObject()));
		}
	}
}
