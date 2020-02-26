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
			if(args.length > 0) {
				switch(args[0]) {
				case "set":
					p.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(1000);
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Statistique mise a jour"));
					p.sendMessage(new TextComponentString("-----------------------------"));
					break;
					
				case "reset":
					p.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(0);
					p.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl1(0);
					p.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl1(0);
					p.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl1(0);
					p.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl1(0);
					p.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl1(0);
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Statistique mise a jour"));
					p.sendMessage(new TextComponentString("-----------------------------"));
					break;
					
				case "actualiser":
						Random r = new Random();
						int randomInt;
						boolean maxed = false;
						int xp = p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount();
						for(int i = 0; i < xp; i++) {
							randomInt = r.nextInt(5);
							if(p.experienceLevel == 1) {
								if(!(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl1() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl1() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl1() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl1() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl1() == 999)) {
									switch(randomInt) {
									case 0:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl1() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl1(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl1() + 1);
										}
										break;
									case 1:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl1() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl1(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl1() + 1);
										}
										break;
									case 2:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl1() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl1(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl1() + 1);
										}
										break;
									case 3:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl1() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl1(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl1() + 1);
										}
										break;
									case 4:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl1() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl1(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl1() + 1);
										}
										break;
									}
									p.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount() - 1);
								} else {
									maxed = true;
								}
							}
							if(p.experienceLevel == 2) {
								if(!(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl2() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl2() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl2() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl2() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl2() == 999)) {
									switch(randomInt) {
									case 0:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl2() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl2(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl2() + 1);
										}
										break;
									case 1:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl2() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl2(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl2() + 1);
										}
										break;
									case 2:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl2() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl2(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl2() + 1);
										}
										break;
									case 3:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl2() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl2(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl2() + 1);
										}
										break;
									case 4:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl2() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl2(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl2() + 1);
										}
										break;
									}
									p.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount() - 1);
								} else {
									maxed = true;
								}
							}
							if(p.experienceLevel == 3) {
								if(!(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl3() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl3() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl3() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl3() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl3() == 999)) {
									switch(randomInt) {
									case 0:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl3() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl3(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl3() + 1);
										}
										break;
									case 1:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl3() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl3(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl3() + 1);
										}
										break;
									case 2:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl3() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl3(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl3() + 1);
										}
										break;
									case 3:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl3() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl3(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl3() + 1);
										}
										break;
									case 4:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl3() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl3(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl3() + 1);
										}
										break;
									}
									p.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount() - 1);
								} else {
									maxed = true;
								}
							}
							if(p.experienceLevel == 4) {
								if(!(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl4() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl4() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl4() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl4() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl4() == 999)) {
									switch(randomInt) {
									case 0:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl4() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl4(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl4() + 1);
										}
										break;
									case 1:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl4() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl4(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl4() + 1);
										}
										break;
									case 2:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl4() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl4(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl4() + 1);
										}
										break;
									case 3:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl4() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl4(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl4() + 1);
										}
										break;
									case 4:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl4() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl4(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl4() + 1);
										}
										break;
									}
									p.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount() - 1);
								} else {
									maxed = true;
								}
							}
							if(p.experienceLevel == 5) {
								if(!(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl5() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl5() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl5() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl5() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl5() == 999)) {
									switch(randomInt) {
									case 0:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl5() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl5(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl5() + 1);
										}
										break;
									case 1:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl5() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl5(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl5() + 1);
										}
										break;
									case 2:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl5() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl5(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl5() + 1);
										}
										break;
									case 3:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl5() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl5(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl5() + 1);
										}
										break;
									case 4:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl5() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl5(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl5() + 1);
										}
										break;
									}
									p.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount() - 1);
								} else {
									maxed = true;
								}
							}
							if(p.experienceLevel == 6) {
								if(!(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl6() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl6() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl6() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl6() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl6() == 999)) {
									switch(randomInt) {
									case 0:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl6() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl6(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl6() + 1);
										}
										break;
									case 1:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl6() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl6(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl6() + 1);
										}
										break;
									case 2:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl6() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl6(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl6() + 1);
										}
										break;
									case 3:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl6() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl6(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl6() + 1);
										}
										break;
									case 4:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl6() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl6(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl6() + 1);
										}
										break;
									}
									p.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount() - 1);
								} else {
									maxed = true;
								}
							}
							if(p.experienceLevel == 7) {
								if(!(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl7() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl7() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl7() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl7() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl7() == 999)) {
									switch(randomInt) {
									case 0:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl7() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl7(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl7() + 1);
										}
										break;
									case 1:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl7() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl7(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl7() + 1);
										}
										break;
									case 2:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl7() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl7(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl7() + 1);
										}
										break;
									case 3:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl7() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl7(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl7() + 1);
										}
										break;
									case 4:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl7() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl7(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl7() + 1);
										}
										break;
									}
									p.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount() - 1);
								} else {
									maxed = true;
								}
							}
							if(p.experienceLevel == 8) {
								if(!(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl8() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl8() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl8() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl8() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl8() == 999)) {
									switch(randomInt) {
									case 0:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl8() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl8(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl8() + 1);
										}
										break;
									case 1:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl8() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl8(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl8() + 1);
										}
										break;
									case 2:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl8() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl8(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl8() + 1);
										}
										break;
									case 3:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl8() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl8(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl8() + 1);
										}
										break;
									case 4:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl8() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl8(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl8() + 1);
										}
										break;
									}
									p.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount() - 1);
								} else {
									maxed = true;
								}
							}
							if(p.experienceLevel == 9) {
								if(!(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl9() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl9() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl9() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl9() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl9() == 999)) {
									switch(randomInt) {
									case 0:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl9() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl9(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl9() + 1);
										}
										break;
									case 1:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl9() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl9(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl9() + 1);
										}
										break;
									case 2:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl9() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl9(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl9() + 1);
										}
										break;
									case 3:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl9() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl9(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl9() + 1);
										}
										break;
									case 4:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl9() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl9(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl9() + 1);
										}
										break;
									}
									p.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount() - 1);
								} else {
									maxed = true;
								}
							}
							if(p.experienceLevel == 10) {
								if(!(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl10() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl10() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl10() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl10() == 999 && p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl10() == 999)) {
									switch(randomInt) {
									case 0:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl10() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setForcelvl10(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl10() + 1);
										}
										break;
									case 1:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl10() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setEndurancelvl10(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl10() + 1);
										}
										break;
									case 2:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl10() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setAgilitelvl10(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl10() + 1);
										}
										break;
									case 3:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl10() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setDexteritelvl10(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl10() + 1);
										}
										break;
									case 4:
										if(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl10() != 999) {
											p.getCapability(DanMachiMenuMain.DMM_CAP, null).setMagielvl10(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl10() + 1);
										}
										break;
									}
									p.getCapability(DanMachiMenuMain.DMM_CAP, null).setXpCount(p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount() - 1);
								} else {
									maxed = true;
								}
							}
						}
					
						if(maxed) {
							p.sendMessage(new TextComponentString("-----------------------------"));
							p.sendMessage(new TextComponentString("| Vous êtes max"));
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
				if(p.experienceLevel == 1) {
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Level : " + p.experienceLevel));
					p.sendMessage(new TextComponentString("| Xp en stock : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount()));
					p.sendMessage(new TextComponentString("| Force : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl1()));
					p.sendMessage(new TextComponentString("| Endurance : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl1()));
					p.sendMessage(new TextComponentString("| Agilite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl1()));
					p.sendMessage(new TextComponentString("| Dexterite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl1()));
					p.sendMessage(new TextComponentString("| Magie : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl1()));
					p.sendMessage(new TextComponentString("-----------------------------"));
				}
				
				if(p.experienceLevel == 2) {
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Level : " + p.experienceLevel));
					p.sendMessage(new TextComponentString("| Xp en stock : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount()));
					p.sendMessage(new TextComponentString("| Force : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl2()));
					p.sendMessage(new TextComponentString("| Endurance : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl2()));
					p.sendMessage(new TextComponentString("| Agilite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl2()));
					p.sendMessage(new TextComponentString("| Dexterite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl2()));
					p.sendMessage(new TextComponentString("| Magie : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl2()));
					p.sendMessage(new TextComponentString("-----------------------------"));
				}
				
				if(p.experienceLevel == 3) {
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Level : " + p.experienceLevel));
					p.sendMessage(new TextComponentString("| Xp en stock : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount()));
					p.sendMessage(new TextComponentString("| Force : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl3()));
					p.sendMessage(new TextComponentString("| Endurance : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl3()));
					p.sendMessage(new TextComponentString("| Agilite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl3()));
					p.sendMessage(new TextComponentString("| Dexterite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl3()));
					p.sendMessage(new TextComponentString("| Magie : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl3()));
					p.sendMessage(new TextComponentString("-----------------------------"));
				}
				
				if(p.experienceLevel == 4) {
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Level : " + p.experienceLevel));
					p.sendMessage(new TextComponentString("| Xp en stock : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount()));
					p.sendMessage(new TextComponentString("| Force : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl4()));
					p.sendMessage(new TextComponentString("| Endurance : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl4()));
					p.sendMessage(new TextComponentString("| Agilite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl4()));
					p.sendMessage(new TextComponentString("| Dexterite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl4()));
					p.sendMessage(new TextComponentString("| Magie : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl4()));
					p.sendMessage(new TextComponentString("-----------------------------"));
				}
				
				if(p.experienceLevel == 5) {
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Level : " + p.experienceLevel));
					p.sendMessage(new TextComponentString("| Xp en stock : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount()));
					p.sendMessage(new TextComponentString("| Force : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl5()));
					p.sendMessage(new TextComponentString("| Endurance : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl5()));
					p.sendMessage(new TextComponentString("| Agilite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl5()));
					p.sendMessage(new TextComponentString("| Dexterite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl5()));
					p.sendMessage(new TextComponentString("| Magie : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl5()));
					p.sendMessage(new TextComponentString("-----------------------------"));
				}
				
				if(p.experienceLevel == 6) {
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Level : " + p.experienceLevel));
					p.sendMessage(new TextComponentString("| Xp en stock : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount()));
					p.sendMessage(new TextComponentString("| Force : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl6()));
					p.sendMessage(new TextComponentString("| Endurance : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl6()));
					p.sendMessage(new TextComponentString("| Agilite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl6()));
					p.sendMessage(new TextComponentString("| Dexterite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl6()));
					p.sendMessage(new TextComponentString("| Magie : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl6()));
					p.sendMessage(new TextComponentString("-----------------------------"));
				}
				
				if(p.experienceLevel == 7) {
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Level : " + p.experienceLevel));
					p.sendMessage(new TextComponentString("| Xp en stock : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount()));
					p.sendMessage(new TextComponentString("| Force : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl7()));
					p.sendMessage(new TextComponentString("| Endurance : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl7()));
					p.sendMessage(new TextComponentString("| Agilite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl7()));
					p.sendMessage(new TextComponentString("| Dexterite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl7()));
					p.sendMessage(new TextComponentString("| Magie : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl7()));
					p.sendMessage(new TextComponentString("-----------------------------"));
				}
				
				if(p.experienceLevel == 8) {
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Level : " + p.experienceLevel));
					p.sendMessage(new TextComponentString("| Xp en stock : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount()));
					p.sendMessage(new TextComponentString("| Force : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl8()));
					p.sendMessage(new TextComponentString("| Endurance : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl8()));
					p.sendMessage(new TextComponentString("| Agilite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl8()));
					p.sendMessage(new TextComponentString("| Dexterite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl8()));
					p.sendMessage(new TextComponentString("| Magie : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl8()));
					p.sendMessage(new TextComponentString("-----------------------------"));
				}
				
				if(p.experienceLevel == 9) {
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Level : " + p.experienceLevel));
					p.sendMessage(new TextComponentString("| Xp en stock : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount()));
					p.sendMessage(new TextComponentString("| Force : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl9()));
					p.sendMessage(new TextComponentString("| Endurance : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl9()));
					p.sendMessage(new TextComponentString("| Agilite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl9()));
					p.sendMessage(new TextComponentString("| Dexterite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl9()));
					p.sendMessage(new TextComponentString("| Magie : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl9()));
					p.sendMessage(new TextComponentString("-----------------------------"));
				}
				
				if(p.experienceLevel == 10) {
					p.sendMessage(new TextComponentString("-----------------------------"));
					p.sendMessage(new TextComponentString("| Level : " + p.experienceLevel));
					p.sendMessage(new TextComponentString("| Xp en stock : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getXpCount()));
					p.sendMessage(new TextComponentString("| Force : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getForcelvl10()));
					p.sendMessage(new TextComponentString("| Endurance : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getEndurancelvl10()));
					p.sendMessage(new TextComponentString("| Agilite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getAgilitelvl10()));
					p.sendMessage(new TextComponentString("| Dexterite : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getDexteritelvl10()));
					p.sendMessage(new TextComponentString("| Magie : " + p.getCapability(DanMachiMenuMain.DMM_CAP, null).getMagielvl10()));
					p.sendMessage(new TextComponentString("-----------------------------"));
				}
				
				if(p.experienceLevel > 10 || p.experienceLevel < 1) {
					p.sendMessage(new TextComponentString(":thinking:"));
				}
			}
		}
	}

	@Override
	public String getName() {
		return "dmfstatistique";
	}
}
