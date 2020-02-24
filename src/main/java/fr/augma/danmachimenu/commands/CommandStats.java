package fr.augma.danmachimenu.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import fr.augma.danmachimenu.DanMachiMenuMain;
import fr.augma.danmachimenu.capabilities.DmmCapabilitiesProvider;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.capabilities.Capability;

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
			DmmCapabilitiesProvider pCap = p.getCapability(DanMachiMenuMain.DMM_CAP, null);
			if(args.length > 0) {
				switch(args[0]) {
				case "set":
					pCap.setXpCount(1000);
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Statistique mise a jour"));
					p.sendMessage(new TextComponentString("-----------------------------"));
					break;
					
				case "reset":
					pCap.setXpCount(0);
					pCap.setForcelvl1(0);
					pCap.setDefenselvl1(0);
					pCap.setAgilitelvl1(0);
					pCap.setDexteritelvl1(0);
					pCap.setMagielvl1(0);
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Statistique mise a jour"));
					p.sendMessage(new TextComponentString("-----------------------------"));
					break;
					
				case "actualiser":
						Random r = new Random();
						int randomInt;
						boolean maxed = false;
						int xp = pCap.getXpCount();
						for(int i = 0; i < xp; i++) {
							randomInt = r.nextInt(5);
							if(!(pCap.getForcelvl1() == 999 && pCap.getDefenselvl1() == 999 && pCap.getAgilitelvl1() == 999 && pCap.getDexteritelvl1() == 999 && pCap.getMagielvl1() == 999)) {
								switch(randomInt) {
								case 0:
									if(pCap.getForcelvl1() != 999) {
										pCap.setForcelvl1(pCap.getForcelvl1() + 1);
									}
									break;
								case 1:
									if(pCap.getDefenselvl1() != 999) {
										pCap.setDefenselvl1(pCap.getDefenselvl1() + 1);
									}
									break;
								case 2:
									if(pCap.getAgilitelvl1() != 999) {
										pCap.setAgilitelvl1(pCap.getAgilitelvl1() + 1);
									}
									break;
								case 3:
									if(pCap.getDexteritelvl1() != 999) {
										pCap.setDexteritelvl1(pCap.getDexteritelvl1() + 1);
									}
									break;
								case 4:
									if(pCap.getMagielvl1() != 999) {
										pCap.setMagielvl1(pCap.getMagielvl1() + 1);
									}
									break;
								}
								pCap.setXpCount(pCap.getXpCount() - 1);
							} else {
								maxed = true;
							}
						}
					
						if(maxed) {
							p.sendMessage(new TextComponentString("-----------------------------"));
							p.sendMessage(new TextComponentString("| Vous êtes maxé"));
							p.sendMessage(new TextComponentString("-----------------------------"));
						} else {
							p.sendMessage(new TextComponentString("-----------------------------"));
							p.sendMessage(new TextComponentString("| Statistique mise a jour"));
							p.sendMessage(new TextComponentString("-----------------------------"));
						}
					break;
					
				default:
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| /dmfstatistique <set|reset|actualiser>"));
					p.sendMessage(new TextComponentString("-----------------------------"));
					break;
				}
			} else {
				p.sendMessage(new TextComponentString("-----------------------------"));
				p.sendMessage(new TextComponentString("| Level : " + p.experienceLevel));
				p.sendMessage(new TextComponentString("| Xp Stocké : " + pCap.getXpCount()));
				p.sendMessage(new TextComponentString("| Force : " + pCap.getForcelvl1()));
				p.sendMessage(new TextComponentString("| Defense : " + pCap.getDefenselvl1()));
				p.sendMessage(new TextComponentString("| Agilite : " + pCap.getAgilitelvl1()));
				p.sendMessage(new TextComponentString("| Dexterite : " + pCap.getDexteritelvl1()));
				p.sendMessage(new TextComponentString("| Magie : " + pCap.getMagielvl1()));
				p.sendMessage(new TextComponentString("-----------------------------"));
			}
		}
	}

	@Override
	public String getName() {
		return "dmfstatistique";
	}
}
