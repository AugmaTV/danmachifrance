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
		return "It's a command only for admin";
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
        	player.sendMessage(new TextComponentString("| /dmfadmin > Show command list and usage."));
			player.sendMessage(new TextComponentString("| /dmfadmin stats <player> > Show the statistics of an player."));
			player.sendMessage(new TextComponentString("| /dmfadmin refresh <player> > Refresh your stats or stats of an other player."));
			player.sendMessage(new TextComponentString("| /dmfadmin overall [<player>] > See the overall stats + stats with level for you or an other player."));
			player.sendMessage(new TextComponentString("| /dmfadmin reset [<player>] > Reset you'r stats of for an other player."));
			player.sendMessage(new TextComponentString("| /dmfadmin aog [<player>] > Set the Act Of Gods to true for an player or for you."));
			player.sendMessage(new TextComponentString("| /dmfadmin levelup <player> > Command for level up an player."));
			player.sendMessage(new TextComponentString("| /dmfadmin addxp <player> [<number>] > Command to set xp, default 100, for an player."));
			player.sendMessage(new TextComponentString("--------------------------"));
			
		/*
		 * Command /dmfadmin stats <player>
		 */
		} else if("stats".equalsIgnoreCase(args[0])) {
			if(args.length < 2) {
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| Precise the player please."));
				player.sendMessage(new TextComponentString("| /dmfadmin stats <player>."));
				player.sendMessage(new TextComponentString("--------------------------"));
			} else {
				target = server.getPlayerList().getPlayerByUsername(args[1]);
				if(target != null) {
					tCap = target.getCapability(PlayerDataCapProvider.CAPABILITY, null);
					tCapData = tCap.data();
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| You'r level > " + target.experienceLevel + "."));
					player.sendMessage(new TextComponentString("| You'r xp in stock > " + tCap.getXP() + " xp."));
		        	player.sendMessage(new TextComponentString("| Strength > " + CommandDmf.getNote(tCapData.getInteger("forcelvl" + target.experienceLevel)) + "."));
		        	player.sendMessage(new TextComponentString("| Stamina > " + CommandDmf.getNote(tCapData.getInteger("endurancelvl" + target.experienceLevel)) + "."));
		        	player.sendMessage(new TextComponentString("| Agility > " + CommandDmf.getNote(tCapData.getInteger("agilitelvl" + target.experienceLevel)) + "."));
		        	player.sendMessage(new TextComponentString("| Dexterity > " + CommandDmf.getNote(tCapData.getInteger("dexteritelvl" + target.experienceLevel)) + "."));
		        	player.sendMessage(new TextComponentString("| Magie > " + CommandDmf.getNote(tCapData.getInteger("magielvl" + target.experienceLevel)) + "."));
		        	player.sendMessage(new TextComponentString("| Act of Gods > " + tCap.getLevelUp()));
		        	player.sendMessage(new TextComponentString("--------------------------"));
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| The player \"" + args[1] + "\" was not found."));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			}
		/*
		 * Command /dmfadmin refresh <player>
		 */
		} else if("refresh".equalsIgnoreCase(args[0])) {
			if(args.length < 2) {
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| Precise the player please."));
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
		    	    		player.sendMessage(new TextComponentString("| He is full of statistics for his level !"));
		    	    		if(target.experienceLevel == 10) {
		    	    			player.sendMessage(new TextComponentString("| He is at the maximum level, powerfull !"));
		    	    		}
		    	    		player.sendMessage(new TextComponentString("--------------------------"));
		    			} else {
		    				player.sendMessage(new TextComponentString("--------------------------"));
		    				player.sendMessage(new TextComponentString("| Statistics refresh !"));
		    				player.sendMessage(new TextComponentString("--------------------------"));
		    			}
		    		} else {
		    			player.sendMessage(new TextComponentString("--------------------------"));
		    			player.sendMessage(new TextComponentString("| He don't have enough falnas"));
		    			player.sendMessage(new TextComponentString("--------------------------"));
		    		}
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| The player \"" + args[1] + "\" was not found."));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			}
		/*
		 * Command /dmfadmin overall [<player>]
		 */
		} else if("overall".equalsIgnoreCase(args[0])) {
			if(args.length < 2) {
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| Level > " + pCap.getXP() + "."));
				player.sendMessage(new TextComponentString("| Sums of strength > " + (pCap.getSumsForce() + (player.experienceLevel - 1) * 200)));
				player.sendMessage(new TextComponentString("| Sums of stamina > " + (pCap.getSumsEndurance() + (player.experienceLevel - 1) * 200)));
				player.sendMessage(new TextComponentString("| Sums of agility > " + (pCap.getSumsAgilite() + (player.experienceLevel - 1) * 200)));
				player.sendMessage(new TextComponentString("| Sums of dexterity > " + (pCap.getSumsDexterite() + (player.experienceLevel - 1) * 200)));
				player.sendMessage(new TextComponentString("| Sums of magie > " + (pCap.getSumsMagie() + (player.experienceLevel - 1) * 200)));
				player.sendMessage(new TextComponentString("--------------------------"));
			} else {
				target = server.getPlayerList().getPlayerByUsername(args[1]);
				if(target != null) {
					tCap = target.getCapability(PlayerDataCapProvider.CAPABILITY, null);
					tCapData = tCap.data();
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| Player > " + args[1] + "."));
					player.sendMessage(new TextComponentString("| Level > " + tCap.getXP() + "."));
					player.sendMessage(new TextComponentString("| Sums of strength > " + (tCap.getSumsForce() + (target.experienceLevel - 1) * 200) + "."));
					player.sendMessage(new TextComponentString("| Sums of stamina > " + (tCap.getSumsEndurance() + (target.experienceLevel - 1) * 200) + "."));
					player.sendMessage(new TextComponentString("| Sums of agility > " + (tCap.getSumsAgilite() + (target.experienceLevel - 1) * 200) + "."));
					player.sendMessage(new TextComponentString("| Sums of dexterity > " + (pCap.getSumsDexterite() + (target.experienceLevel - 1) * 200) + "."));
					player.sendMessage(new TextComponentString("| Sums of magie > " + (tCap.getSumsMagie() + (target.experienceLevel - 1) * 200) + "."));
					player.sendMessage(new TextComponentString("--------------------------"));
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| The player \"" + args[1] + "\" was not found."));
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
				player.sendMessage(new TextComponentString("| Reset success !"));
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
					player.sendMessage(new TextComponentString("| Reset success !"));
					player.sendMessage(new TextComponentString("--------------------------"));
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| The player \"" + args[1] + "\" was not found."));
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
				player.sendMessage(new TextComponentString("| You'r Act Of Gods is now true"));
				player.sendMessage(new TextComponentString("--------------------------"));
			} else {
				target = server.getPlayerList().getPlayerByUsername(args[1]);
				if(target != null) {
					tCap = target.getCapability(PlayerDataCapProvider.CAPABILITY, null);
					tCap.setLevelUp(true);
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| The Act Of Gods for " + args[1] + " is now true"));
					player.sendMessage(new TextComponentString("--------------------------"));
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| The player \"" + args[1] + "\" was not found."));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			}
		/*
		 * Command /dmfadmin levelup <player>
		 */
		} else if("levelup".equalsIgnoreCase(args[0])) {
			if(args.length < 2) {
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| Precise the player please."));
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
		    					target.sendMessage(new TextComponentString("| Congratulation you have level up !"));
		    					target.sendMessage(new TextComponentString("--------------------------"));
		    					
		    					player.sendMessage(new TextComponentString("--------------------------"));
		    					player.sendMessage(new TextComponentString("| The player have level up."));
		    					player.sendMessage(new TextComponentString("--------------------------"));
		    				} else {
		    					player.sendMessage(new TextComponentString("--------------------------"));
		    					player.sendMessage(new TextComponentString("| He haven't done an act recognized by the Gods."));
		    					player.sendMessage(new TextComponentString("--------------------------"));
		    				}
		    			} else {
		    				player.sendMessage(new TextComponentString("--------------------------"));
		    				player.sendMessage(new TextComponentString("| He is at the maximum level."));
		    				player.sendMessage(new TextComponentString("--------------------------"));
		    			}
		    		} else {
		    			player.sendMessage(new TextComponentString("--------------------------"));
		    			player.sendMessage(new TextComponentString("| He is unworthy of reaching the next level."));
		    			player.sendMessage(new TextComponentString("--------------------------"));
		    		}
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| The player \"" + args[1] + "\" was not found."));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			}
		/*
		 * Command /dmfadmin addxp <player> [<number>]
		 */
		} else if("addxp".equalsIgnoreCase(args[0])) {
			if(args.length < 2) {
				player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| Precise the player please."));
				player.sendMessage(new TextComponentString("| /dmfadmin addxp <player> [<number>]."));
				player.sendMessage(new TextComponentString("--------------------------"));
			} else {
				target = server.getPlayerList().getPlayerByUsername(args[1]);
				if(target != null) {
					tCap = target.getCapability(PlayerDataCapProvider.CAPABILITY, null);
					if(args.length < 3) {
						tCap.addXP(100);
						player.sendMessage(new TextComponentString("--------------------------"));
						player.sendMessage(new TextComponentString("| 100 xp have been added to " + args[1] + " counter."));
						player.sendMessage(new TextComponentString("--------------------------"));
					} else {
						int xp = Integer.valueOf(args[2]);
						tCap.addXP(xp);
						player.sendMessage(new TextComponentString("--------------------------"));
						player.sendMessage(new TextComponentString("| " + xp + "xp have been added to " + args[1] + " counter."));
						player.sendMessage(new TextComponentString("--------------------------"));
					}
				} else {
					player.sendMessage(new TextComponentString("--------------------------"));
					player.sendMessage(new TextComponentString("| The player \"" + args[1] + "\" was not found."));
					player.sendMessage(new TextComponentString("--------------------------"));
				}
			}
		}
	}
}
