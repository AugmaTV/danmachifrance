package fr.augma.danmachimod.commands;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import fr.augma.danmachimod.capabilities.IPlayerDataCap;
import fr.augma.danmachimod.capabilities.PlayerDataCapProvider;
import fr.augma.danmachimod.events.CommonEventHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.server.permission.PermissionAPI;

public class CommandDmfAdmin extends CommandBase {
	
	@Override
	public String getName() {
		return "dmfadmin";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "c'est une commande seulement pour les administrateur";
	}
	
	public int getRequiredPermissionLevel() {	
        return 4;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        if (!(sender instanceof EntityPlayer)) return false;
        return sender.canUseCommand(this.getRequiredPermissionLevel(), this.getName()) || PermissionAPI.hasPermission((EntityPlayerMP) sender, "dmf.admin");
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = getCommandSenderAsPlayer(sender);
		EntityPlayerMP target = null;
		IPlayerDataCap tCap = null;
		NBTTagCompound tCapData = null;
		IPlayerDataCap pCap = player.getCapability(PlayerDataCapProvider.CAPABILITY, null);
		NBTTagCompound pCapData = pCap.data();
		/*
		 * Command /dmfadmin
		 */
		if(args.length < 1) {
			player.sendMessage(new TextComponentString("--------------------------"));
        	player.sendMessage(new TextComponentString("| /dmfadmin > Liste des commandes."));
			player.sendMessage(new TextComponentString("| /dmfadmin stats <player> > Montre les statistiques d'un joueur."));
			player.sendMessage(new TextComponentString("| /dmfadmin refresh <player> > Actualise les statistiques d'un joueur."));
			player.sendMessage(new TextComponentString("| /dmfadmin overall [<player>] > Permet de voir le cumule de statistiques complète d'un joueur ou, si non renseigner, du lanceur de la commande."));
			player.sendMessage(new TextComponentString("| /dmfadmin reset [<player>] > Hard reset les statistiques du joueur ou, si non renseigner, du lanceur de la commande."));
			player.sendMessage(new TextComponentString("| /dmfadmin aog [<player>] > Change l'état de l'acte reconnu par les dieux."));
			player.sendMessage(new TextComponentString("| /dmfadmin levelup <player> > Permet de levelup un joueur si il y est éligible."));
			player.sendMessage(new TextComponentString("| /dmfadmin addxp <player> [<number>] > Ajoute de l'xp à un joueur ou, si non renseigner, au lanceur de la commande."));
			player.sendMessage(new TextComponentString("| La valeur par défaut est 100."));
			player.sendMessage(new TextComponentString("--------------------------"));
			
		/*
		 * Command /dmfadmin stats <player>
		 */
		} else if("stats".equalsIgnoreCase(args[0])) {
			if(args.length < 2) {
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| Précise un nom de joueur."));
				player.sendMessage(new TextComponentString("| /dmfadmin stats <player>."));
				player.sendMessage(new TextComponentString("--------------------------"));
			} else {
				target = server.getPlayerList().getPlayerByUsername(args[1]);
				if(target != null) {
					tCap = target.getCapability(PlayerDataCapProvider.CAPABILITY, null);
					tCapData = tCap.data();
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Level > " + target.experienceLevel + "."));
					player.sendMessage(new TextComponentString("| Falnas > " + tCap.getXP() + " xp."));
		        	player.sendMessage(new TextComponentString("| Force > " + CommandDmf.getNote(tCapData.getInteger("forcelvl" + target.experienceLevel)) + "."));
		        	player.sendMessage(new TextComponentString("| Endurance > " + CommandDmf.getNote(tCapData.getInteger("endurancelvl" + target.experienceLevel)) + "."));
		        	player.sendMessage(new TextComponentString("| Agilité > " + CommandDmf.getNote(tCapData.getInteger("agilitelvl" + target.experienceLevel)) + "."));
		        	player.sendMessage(new TextComponentString("| Dexterité > " + CommandDmf.getNote(tCapData.getInteger("dexteritelvl" + target.experienceLevel)) + "."));
		        	player.sendMessage(new TextComponentString("| Magie > " + CommandDmf.getNote(tCapData.getInteger("magielvl" + target.experienceLevel)) + "."));
		        	player.sendMessage(new TextComponentString("| Acte reconnu des dieux > " + tCap.getLevelUp()));
		        	player.sendMessage(new TextComponentString("--------------------------"));
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Le joueur \"" + args[1] + "\" n'as pas été trouver."));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			}
		/*
		 * Command /dmfadmin refresh <player>
		 */
		} else if("refresh".equalsIgnoreCase(args[0])) {
			if(args.length < 2) {
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| Précise un nom de joueur."));
				player.sendMessage(new TextComponentString("| /dmfadmin refresh <player>."));
				player.sendMessage(new TextComponentString("--------------------------"));
			} else {
				target = server.getPlayerList().getPlayerByUsername(args[1]);
				if(target != null) {
					tCap = target.getCapability(PlayerDataCapProvider.CAPABILITY, null);
					tCapData = tCap.data();
					boolean maxed = false;
		    		int xpCount = tCap.getXP();
		    		int pLvl = target.experienceLevel;
		    		List<String> attributeList = Arrays.asList("forcelvl", "endurancelvl", "agilitelvl", "dexteritelvl", "magielvl");
		    		Random r = new Random();
		    		if(tCap.getXP() > 0) {
		    			for(int i = 0; i < xpCount; i++) {
		    				if(r.nextInt(100) + 1 < CommandDmf.getPercentage(target.experienceLevel)) {
		    					if(!(tCapData.getInteger("forcelvl"+pLvl) == 999 && tCapData.getInteger("endurancelvl"+pLvl) == 999 && tCapData.getInteger("agilitelvl"+pLvl) == 999 && tCapData.getInteger("dexteritelvl"+pLvl) == 999 && tCapData.getInteger("magielvl"+pLvl) == 999)) {
		    						int rInt = r.nextInt(5);
		    						if(tCapData.getInteger(attributeList.get(rInt) + pLvl) != 999) {
		    							tCapData.setInteger(attributeList.get(rInt) + pLvl, tCapData.getInteger(attributeList.get(rInt) + pLvl) + 1);
		    						}
		    					} else {
		    						maxed = true;
		    					}
		    				}
		    				tCap.addXP(-1);
		    			}
		    			CommonEventHandler.addMaxHealth(target);
		    			CommonEventHandler.addVelocity(target);
		    			if(maxed) {
		    				player.sendMessage(new TextComponentString("--------------------------"));
		    	    		player.sendMessage(new TextComponentString("| Il est max en statistiques !"));
		    	    		if(target.experienceLevel == 10) {
		    	    			player.sendMessage(new TextComponentString("| Il est au level maximum, quel puissance !"));
		    	    		}
		    	    		player.sendMessage(new TextComponentString("--------------------------"));
		    			} else {
		    				player.sendMessage(new TextComponentString("--------------------------"));
		    				player.sendMessage(new TextComponentString("| Statistiques actualisé !"));
		    				player.sendMessage(new TextComponentString("--------------------------"));
		    			}
		    		} else {
		    			player.sendMessage(new TextComponentString("--------------------------"));
		    			player.sendMessage(new TextComponentString("| Il n'a pas assez de falnas."));
		    			player.sendMessage(new TextComponentString("--------------------------"));
		    		}
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Le joueur \"" + args[1] + "\" n'a pas été trouver."));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			}
		/*
		 * Command /dmfadmin overall [<player>]
		 */
		} else if("overall".equalsIgnoreCase(args[0])) {
			if(args.length < 2) {
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| Level > " + player.experienceLevel + "."));
				player.sendMessage(new TextComponentString("| Gain grâce au level > " + (player.experienceLevel - 1) * 200 + "."));
				player.sendMessage(new TextComponentString("| Somme de la force > " + (pCap.getSumsForce() + (player.experienceLevel - 1) * 200)));
				player.sendMessage(new TextComponentString("| Somme de l'endurance > " + (pCap.getSumsEndurance() + (player.experienceLevel - 1) * 200)));
				player.sendMessage(new TextComponentString("| Somme de l'agilité > " + (pCap.getSumsAgilite() + (player.experienceLevel - 1) * 200)));
				player.sendMessage(new TextComponentString("| Somme de la dextérité > " + (pCap.getSumsDexterite() + (player.experienceLevel - 1) * 200)));
				player.sendMessage(new TextComponentString("| Somme de la magie > " + (pCap.getSumsMagie() + (player.experienceLevel - 1) * 200)));
				player.sendMessage(new TextComponentString("| Total > " + pCap.getTotalSums() + (player.experienceLevel - 1) * 200 + "."));
				player.sendMessage(new TextComponentString("--------------------------"));
			} else {
				target = server.getPlayerList().getPlayerByUsername(args[1]);
				if(target != null) {
					tCap = target.getCapability(PlayerDataCapProvider.CAPABILITY, null);
					tCapData = tCap.data();
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Level > " + target.experienceLevel + "."));
					player.sendMessage(new TextComponentString("| Gain grâce au level > " + (target.experienceLevel - 1) * 200 + "."));
					player.sendMessage(new TextComponentString("| Somme de la force > " + (tCap.getSumsForce() + (target.experienceLevel - 1) * 200)));
					player.sendMessage(new TextComponentString("| Somme de l'endurance > " + (tCap.getSumsEndurance() + (target.experienceLevel - 1) * 200)));
					player.sendMessage(new TextComponentString("| Somme de l'agilité > " + (tCap.getSumsAgilite() + (target.experienceLevel - 1) * 200)));
					player.sendMessage(new TextComponentString("| Somme de la dextérité > " + (tCap.getSumsDexterite() + (target.experienceLevel - 1) * 200)));
					player.sendMessage(new TextComponentString("| Somme de la magie > " + (tCap.getSumsMagie() + (target.experienceLevel - 1) * 200)));
					player.sendMessage(new TextComponentString("| Total > " + tCap.getTotalSums() + (target.experienceLevel - 1) * 200 + "."));
					player.sendMessage(new TextComponentString("--------------------------"));
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Le joueur \"" + args[1] + "\" n'a pas été trouver."));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			}
		/*
		 * Command /dmfadmin reset [<player>]
		 */
		} else if("reset".equalsIgnoreCase(args[0])) {
			List<String> attribute = Arrays.asList("forcelvl", "endurancelvl", "agilitelvl", "dexteritelvl", "magielvl");
			if(args.length <2) {
				for(int i = 1; i < 11; i++) {
					for(int j = 0; j < 5; j++) {
						pCapData.setInteger(attribute.get(j) + i, 0);
					}
				}
				pCapData.setInteger("xp", 0);
				player.addExperienceLevel(-(player.experienceLevel - 1));
				CommonEventHandler.addMaxHealth(player);
				CommonEventHandler.addVelocity(player);
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| Reset réussi !"));
				player.sendMessage(new TextComponentString("--------------------------"));
			} else {
				target = server.getPlayerList().getPlayerByUsername(args[1]);
				if(target != null) {
					tCap = target.getCapability(PlayerDataCapProvider.CAPABILITY, null);
					tCapData = tCap.data();
					for(int i = 1; i < 11; i++) {
						for(int j = 0; j < 5; j++) {
							tCapData.setInteger(attribute.get(j) + i, 0);
						}
					}
					tCapData.setInteger("xp", 0);
					target.addExperienceLevel(-(target.experienceLevel - 1));
					CommonEventHandler.addMaxHealth(target);
					CommonEventHandler.addVelocity(target);
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Reset reussi !"));
					player.sendMessage(new TextComponentString("--------------------------"));
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Le joueur \"" + args[1] + "\" n'a pas été trouver."));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			}
		/*
		 * Command /dmfadmin aog [<player>]
		 */
		} else if("aog".equalsIgnoreCase(args[0])) {
			if(args.length < 2) {
				pCap.setLevelUp(true);
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| L'acte reconnu des dieux à été activer."));
				player.sendMessage(new TextComponentString("--------------------------"));
			} else {
				target = server.getPlayerList().getPlayerByUsername(args[1]);
				if(target != null) {
					tCap = target.getCapability(PlayerDataCapProvider.CAPABILITY, null);
					tCap.setLevelUp(true);
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| L'acte reconnu des dieux de " + args[1] + " à été activer."));
					player.sendMessage(new TextComponentString("--------------------------"));
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Le joueur \"" + args[1] + "\" n'a pas été trouver."));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			}
		/*
		 * Command /dmfadmin levelup <player>
		 */
		} else if("levelup".equalsIgnoreCase(args[0])) {
			if(args.length < 2) {
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| Précise un nom de joueur."));
				player.sendMessage(new TextComponentString("| /dmfadmin levelup <player>."));
				player.sendMessage(new TextComponentString("--------------------------"));
			} else {
				target = server.getPlayerList().getPlayerByUsername(args[1]);
				if(target != null) {
					tCap = target.getCapability(PlayerDataCapProvider.CAPABILITY, null);
					tCapData = tCap.data();
					if(tCapData.getInteger("forcelvl" + player.experienceLevel) > 499 || tCapData.getInteger("endurancelvl" + player.experienceLevel) > 499 || tCapData.getInteger("agilitelvl" + player.experienceLevel) > 499 || tCapData.getInteger("dexteritelvl" + player.experienceLevel) > 499 || tCapData.getInteger("magielvl" + player.experienceLevel) > 499) {
		        		if(player.experienceLevel != 10) {
		    				if(tCap.getLevelUp()) {
		    					target.addExperienceLevel(1);
		    					tCap.setLevelUp(false);
		    					CommonEventHandler.addMaxHealth(player);
		    					CommonEventHandler.addVelocity(player);
		    					target.sendMessage(new TextComponentString("--------------------------"));
		    					target.sendMessage(new TextComponentString("| Bravo tu as level up !"));
		    					target.sendMessage(new TextComponentString("--------------------------"));
		    					
		    					player.sendMessage(new TextComponentString("--------------------------"));
		    					player.sendMessage(new TextComponentString("| Le joueur a level up."));
		    					player.sendMessage(new TextComponentString("--------------------------"));
		    				} else {
		    					player.sendMessage(new TextComponentString("--------------------------"));
		    					player.sendMessage(new TextComponentString("| Le joueur n'a pas effectué d'acte reconnu des dieux."));
		    					player.sendMessage(new TextComponentString("--------------------------"));
		    				}
		    			} else {
		    				player.sendMessage(new TextComponentString("--------------------------"));
		    				player.sendMessage(new TextComponentString("| Il est déjà au niveau maximum."));
		    				player.sendMessage(new TextComponentString("--------------------------"));
		    			}
		    		} else {
		    			player.sendMessage(new TextComponentString("--------------------------"));
		    			player.sendMessage(new TextComponentString("| Le joueur n'est pas apte à level up."));
		    			player.sendMessage(new TextComponentString("--------------------------"));
		    		}
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Le joueur \"" + args[1] + "\" n'a pas été trouver."));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			}
		/*
		 * Command /dmfadmin addxp <player> [<number>]
		 */
		} else if("addxp".equalsIgnoreCase(args[0])) {
			if(args.length < 2) {
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| Précise un nom de joueur."));
				player.sendMessage(new TextComponentString("| /dmfadmin addxp <player> [<number>]."));
				player.sendMessage(new TextComponentString("--------------------------"));
			} else {
				target = server.getPlayerList().getPlayerByUsername(args[1]);
				if(target != null) {
					tCap = target.getCapability(PlayerDataCapProvider.CAPABILITY, null);
					if(args.length < 3) {
						tCap.addXP(100);
						player.sendMessage(new TextComponentString("--------------------------"));
						player.sendMessage(new TextComponentString("| 100 falnas on été ajouter à " + args[1] + "."));
						player.sendMessage(new TextComponentString("--------------------------"));
					} else {
						int xp = Integer.valueOf(args[2]);
						tCap.addXP(xp);
						player.sendMessage(new TextComponentString("--------------------------"));
						player.sendMessage(new TextComponentString("| " + xp + " falnas on été ajouter à " + args[1] + "."));
						player.sendMessage(new TextComponentString("--------------------------"));
					}
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Le joueur \"" + args[1] + "\" n'a pas été trouver."));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			}
		}
	}
}
