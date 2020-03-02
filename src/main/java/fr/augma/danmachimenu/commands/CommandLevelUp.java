package fr.augma.danmachimenu.commands;

import fr.augma.danmachimenu.capabilities.IPlayerDataCap;
import fr.augma.danmachimenu.capabilities.PlayerDataCapProvider;
import fr.augma.danmachimenu.events.CommonEventHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.server.permission.PermissionAPI;

public class CommandLevelUp extends CommandBase {

	@Override
	public String getName() {
		return "dmflevelup";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Level up";
	}

	public int getRequiredPermissionLevel() {	
        return 4;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        if (!(sender instanceof EntityPlayer)) return false;
        return sender.canUseCommand(this.getRequiredPermissionLevel(), this.getName()) || PermissionAPI.hasPermission((EntityPlayerMP) sender, "dmf.levelup");
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayerMP player = getCommandSenderAsPlayer(sender);
		IPlayerDataCap pCap = player.getCapability(PlayerDataCapProvider.CAPABILITY, null);
		NBTTagCompound pCapData = player.getCapability(PlayerDataCapProvider.CAPABILITY, null).data();
		if(pCapData.getInteger("forcelvl" + player.experienceLevel) > 499 || pCapData.getInteger("endurancelvl" + player.experienceLevel) > 499 || pCapData.getInteger("agilitelvl" + player.experienceLevel) > 499 || pCapData.getInteger("dexteritelvl" + player.experienceLevel) > 499 || pCapData.getInteger("magielvl" + player.experienceLevel) > 499) {
			if(player.experienceLevel == 10) {
				if(pCap.getLevelUp()) {
					player.addExperienceLevel(1);
					pCap.setLevelUp(false);
					CommonEventHandler.addMaxHealth(player);
					CommonEventHandler.addVelocity(player);
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Congratulation you have level up !"));
					player.sendMessage(new TextComponentString("--------------------------"));
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| You haven't done an act recognized by the Gods."));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			} else {
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| You are at the maximum level."));
				player.sendMessage(new TextComponentString("--------------------------"));
			}
		} else {
			player.sendMessage(new TextComponentString("--------------------------"));
			player.sendMessage(new TextComponentString("| You are unworthy of reaching the next level."));
			player.sendMessage(new TextComponentString("--------------------------"));
		}
	}

}
