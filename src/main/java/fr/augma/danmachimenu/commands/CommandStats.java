package fr.augma.danmachimenu.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import fr.augma.danmachimenu.DanMachiMenuMain;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CommandStats extends CommandBase {
	private final List 	aliases;

	
	public CommandStats() {
		this.aliases = new ArrayList();
		this.aliases.add("dmfstats");
		this.aliases.add("dmfstatistique");
		this.aliases.add("dmfstat");
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "danmachidmod";
	}
	
	@Override
	public List getAliases() {
		return aliases;
	}
	
	public int getRequiredPermissionLevel() {
		return 4;
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		if(sender instanceof EntityPlayer) {
			if(!sender.canUseCommand(this.getRequiredPermissionLevel(), this.getName())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayer) {
			EntityPlayer p = (EntityPlayer) sender;
			if(args.length > 0) {
				switch(args[0]) {
				case "set":
					p.getCapability(DanMachiMenuMain.DMM_CAP, null).setMoney(5000);
					p.sendMessage(new TextComponentString("Money mise a jour"));
					break;
				case "reset":
					p.getCapability(DanMachiMenuMain.DMM_CAP, null).setMoney(0);
					p.sendMessage(new TextComponentString("Money mise a jour"));
					break;
				default:	
					p.sendMessage(new TextComponentString(args[0]));
					p.sendMessage(new TextComponentString("/dmfstatistique <set|reset>"));
					break;
				}
			} else {
				p.sendMessage(new TextComponentString("money : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMoney()));
			}
		}
	}

	@Override
	public String getName() {
		return "dmfstatistique";
	}
}
