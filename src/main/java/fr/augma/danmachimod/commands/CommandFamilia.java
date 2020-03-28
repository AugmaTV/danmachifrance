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
	
	public static String listToString(String[] list) {
		String response = "";
		
		for(String str : list) {
			response += str + ", ";
		}
		
		if(response.length() != 0) {
			response = response.substring(0, response.length() - 2);
		} else {
			response = "Aucun";
		}
		
		return response;
	}

	@Override
	public String getName() {
		return "familia";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Commande racine pour gérer votre familia.";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = getCommandSenderAsPlayer(sender);
		ConfigBase data;
		if(!player.world.isRemote) {
			if(args.length < 1) {
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| /familia > Liste des commandes de familia."));
				player.sendMessage(new TextComponentString("| /familia create <familia name> > Crée une familia."));
				player.sendMessage(new TextComponentString("| /familia desc <description> > Changer la description de votre familia."));
				player.sendMessage(new TextComponentString("| /familia show > Détail de votre familia."));
				player.sendMessage(new TextComponentString("| /familia invite <player> > Invité un joueur à votre familia."));
				player.sendMessage(new TextComponentString("| /familia kick <player> > Exclure un joueur de votre familia."));
				player.sendMessage(new TextComponentString("| /familia remove > Supprimé votre familia."));
				player.sendMessage(new TextComponentString("--------------------------"));
			} else if("create".equalsIgnoreCase(args[0])) {
				data = new ConfigBase("data/player");
				if(!data.getString(player.getUniqueID().toString(), "familia").equalsIgnoreCase("null")) {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Vous êtes déjà dans une familia."));
					player.sendMessage(new TextComponentString("--------------------------"));
				} else {
					if(args.length < 2) {
						player.sendMessage(new TextComponentString("--------------------------"));
						player.sendMessage(new TextComponentString("| Précisé le nom de votre familia à crée."));
						player.sendMessage(new TextComponentString("| /familia create <familia name>."));
						player.sendMessage(new TextComponentString("--------------------------"));
					} else {
						data = new ConfigBase("data/familia");
						data.writeBasicsFamilia(args[1], player.getName());
						data = new ConfigBase("data/player");
						data.writeConfig(player.getUniqueID().toString(), "familia", args[1]);
						server.getPlayerList().sendMessage(new TextComponentString("La familia " + args[1] + " à été crée."));
					}
				}
			} else if("show".equalsIgnoreCase(args[0])) {
				data = new ConfigBase("data/player");
				if(data.getString(player.getUniqueID().toString(), "familia").equalsIgnoreCase("null")) {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Tu n'as pas de familia."));
					player.sendMessage(new TextComponentString("--------------------------"));
				} else {
					String familia = data.getString(player.getUniqueID().toString(), "familia");
					data = new ConfigBase("data/familia");
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Familia : " + familia));
					player.sendMessage(new TextComponentString("| Score : " + data.getInt(familia, "score") + " point de classement"));
					player.sendMessage(new TextComponentString("| Description : " + data.getString(familia, "description")));
					player.sendMessage(new TextComponentString("| Leader : " + data.getString(familia, "leader")));
					player.sendMessage(new TextComponentString("| Officier : " + listToString(data.getStringList(familia, "officers"))));
					player.sendMessage(new TextComponentString("| Membre : " + listToString(data.getStringList(familia, "members"))));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			}
		}
	}
}
