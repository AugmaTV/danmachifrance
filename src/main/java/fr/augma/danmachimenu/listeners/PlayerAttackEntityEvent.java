package fr.augma.danmachimenu.listeners;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlayerAttackEntityEvent {

	@SubscribeEvent
	public void onPlayerAttackEntity(LivingAttackEvent event) {
		if(event.getSource().getTrueSource() instanceof EntityPlayer && !event.getSource().getTrueSource().world.isRemote) {
			event.getSource().getTrueSource().sendMessage(new TextComponentString("" + event.getAmount()));
		}
	}
}
