package fr.augma.danmachimenu.commands;

import fr.augma.danmachimenu.capabilities.IPlayerDataCap;
import fr.augma.danmachimenu.capabilities.PlayerDataCapProvider;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CommandAdminGetXp extends CommandBase {

	@Override
	public String getName() {
		return "dmfadmingetxp";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Add xp only for admin";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = getCommandSenderAsPlayer(sender);
		IPlayerDataCap pCap = player.getCapability(PlayerDataCapProvider.CAPABILITY, null);
		pCap.addXP(1000);
		player.sendMessage(new TextComponentString("--------------------------"));
		player.sendMessage(new TextComponentString("| 1000 XP have been added to your counter !"));
		player.sendMessage(new TextComponentString("--------------------------"));
	}

}
