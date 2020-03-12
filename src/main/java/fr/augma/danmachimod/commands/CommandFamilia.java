package fr.augma.danmachimod.commands;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.augma.danmachimod.common.DanMachiClient;
import fr.augma.danmachimod.common.DanMachiServer;
import fr.augma.danmachimod.config.ConfigBase;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CommandFamilia extends CommandBase {

	@Override
	public String getName() {
		return "familia";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Root command for create or manage you'r familia";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		//EntityPlayer player = getCommandSenderAsPlayer(sender);
		ConfigBase familiaData = DanMachiServer.dataFamilia;
		if(args.length < 1) {
			System.out.println("moé");
		} else {
			familiaData.writeConfig("familiaCommand", "consol", args[0]);
			familiaData.setList("familiaCommand", "testList", new String[] {"oui", "non"}, null);
			for(String str : familiaData.getStringList("familiaCommand", "testList")) {
				System.out.println(str);
			}
		}
	}

}
