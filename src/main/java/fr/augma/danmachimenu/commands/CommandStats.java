package fr.augma.danmachimenu.commands;

import java.util.List;

import com.google.common.collect.Lists;

import fr.augma.danmachimenu.DanMachiMenuMain;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CommandStats extends CommandBase {
	private final List<String> 	aliases = Lists.newArrayList(DanMachiMenuMain.MODID, "dmfstats", "dmfstatistique");

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "dmfstatistique <msg>";
	}
	
	@Override
	public List<String> getAliases() {
		return aliases;
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayer) {
			EntityPlayer p = (EntityPlayer) sender;
			sender.sendMessage(new TextComponentString(p.getName()));
			sender.getPosition().add(10, 0, 0);
		}
	}
}
