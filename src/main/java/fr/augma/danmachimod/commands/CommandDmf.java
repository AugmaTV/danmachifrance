package fr.augma.danmachimod.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.server.permission.PermissionAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import fr.augma.danmachimod.capabilities.IPlayerDataCap;
import fr.augma.danmachimod.capabilities.PlayerDataCapProvider;
import fr.augma.danmachimod.events.CommonEventHandler;
import fr.augma.danmachimod.init.ItemsMod;

public class CommandDmf extends CommandBase {

    public CommandDmf() {

    }
    
    public static String getNote(int attribute) {
    	String note = "";
    	if(attribute <= 99) note = "I";
    	else if(attribute <= 199) note = "H";
    	else if(attribute <= 299) note = "G";
    	else if(attribute <= 399) note = "F";
    	else if(attribute <= 499) note = "E";
    	else if(attribute <= 599) note = "D";
    	else if(attribute <= 699) note = "C";
    	else if(attribute <= 799) note = "B";
    	else if(attribute <= 899) note = "A";
    	else if(attribute <= 999) note = "S";
    	return attribute + " " + note;
    }
    
    public static int getPercentage(int playerLevel) {
		int playerPercentage = 0;
		if(playerLevel == 1) playerPercentage = 25; 	 // level 1 : 1/4
		else if(playerLevel == 2) playerPercentage = 23; // level 2 : 1/4,34
		else if(playerLevel == 3) playerPercentage = 21; // level 3 : 1/4,76
		else if(playerLevel == 4) playerPercentage = 19; // level 4 : 1/5,26
		else if(playerLevel == 5) playerPercentage = 17; // level 5 : 1/5,88
		else if(playerLevel == 6) playerPercentage = 15; // level 6 : 1/6,66
		else if(playerLevel == 7) playerPercentage = 13; // level 7 : 1/7,69
		else if(playerLevel == 8) playerPercentage = 11; // level 8 : 1/9,09
		else if(playerLevel == 9) playerPercentage = 10; // level 9 : 1/10
		else if(playerLevel == 10) playerPercentage = 5; // level 10 : 1/20
		return playerPercentage;
	}

    @Override
    public String getUsage(ICommandSender sender) {
        return "Commande racine pour vos statistiques";
    }

    public int getRequiredPermissionLevel() {	
        return 4;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        if (!(sender instanceof EntityPlayer)) return false;
        return sender.canUseCommand(this.getRequiredPermissionLevel(), this.getName()) || PermissionAPI.hasPermission((EntityPlayerMP) sender, "dmf.player");
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayerMP player = getCommandSenderAsPlayer(sender);
        IPlayerDataCap pCap = player.getCapability(PlayerDataCapProvider.CAPABILITY, null);
        NBTTagCompound pCapData = pCap.data();
        
        	// If player send command like /dmf
        if(args.length < 1) {
        	player.sendMessage(new TextComponentString("--------------------------"));
        	player.sendMessage(new TextComponentString("| /dmf > Liste des commandes."));
			player.sendMessage(new TextComponentString("| /dmf stat > Montre vos statistiques."));
			player.sendMessage(new TextComponentString("| /dmf refresh > Actualise vos statistiques."));
			player.sendMessage(new TextComponentString("| /dmf levelup > Permet de level up si vous remplissez les conditions nécessaire."));
			player.sendMessage(new TextComponentString("--------------------------"));
			
			
			// If player send command like /dmf stats
        } else if("stats".equalsIgnoreCase(args[0])) {
        	player.sendMessage(new TextComponentString("--------------------------"));
        	player.sendMessage(new TextComponentString("| Level > " + player.experienceLevel + "."));
        	player.sendMessage(new TextComponentString("| Falnas > " + pCap.getXP() + "."));
        	player.sendMessage(new TextComponentString("| Force > " + getNote(pCapData.getInteger("forcelvl" + player.experienceLevel)) + "."));
        	player.sendMessage(new TextComponentString("| Endurance > " + getNote(pCapData.getInteger("endurancelvl" + player.experienceLevel)) + "."));
        	player.sendMessage(new TextComponentString("| Agilité > " + getNote(pCapData.getInteger("agilitelvl" + player.experienceLevel)) + "."));
        	player.sendMessage(new TextComponentString("| Dexterité > " + getNote(pCapData.getInteger("dexteritelvl" + player.experienceLevel)) + "."));
        	player.sendMessage(new TextComponentString("| Magie > " + getNote(pCapData.getInteger("magielvl" + player.experienceLevel)) + "."));
        	player.sendMessage(new TextComponentString("| Acte reconnu des dieux > " + pCap.getLevelUp() + "."));
        	player.sendMessage(new TextComponentString("--------------------------"));
        	
        	
        	// If player send command like /dmf refresh
        } else if("refresh".equalsIgnoreCase(args[0])) {
        	boolean maxed = false;
    		int xpCount = pCap.getXP();
    		int pLvl = player.experienceLevel;
    		List<String> attributeList = Arrays.asList("forcelvl", "endurancelvl", "agilitelvl", "dexteritelvl", "magielvl");
    		Random r = new Random();
    		if(pCap.getXP() > 0) {
    			for(int i = 0; i < xpCount; i++) {
    				if(r.nextInt(100) + 1 < getPercentage(player.experienceLevel)) {
    					if(!(pCapData.getInteger("forcelvl"+pLvl) == 999 && pCapData.getInteger("endurancelvl"+pLvl) == 999 && pCapData.getInteger("agilitelvl"+pLvl) == 999 && pCapData.getInteger("dexteritelvl"+pLvl) == 999 && pCapData.getInteger("magielvl"+pLvl) == 999)) {
    						int rInt = r.nextInt(5);
    						if(pCapData.getInteger(attributeList.get(rInt) + pLvl) != 999) {
    							pCapData.setInteger(attributeList.get(rInt) + pLvl, pCapData.getInteger(attributeList.get(rInt) + pLvl) + 1);
    						}
    						
    					} else {
    						maxed = true;
    					}
    				}
    				pCap.addXP(-1);
    			}
    			CommonEventHandler.addMaxHealth(player);
    			CommonEventHandler.addVelocity(player);
    			if(maxed) {
    				player.sendMessage(new TextComponentString("--------------------------"));
    	    		player.sendMessage(new TextComponentString("| Tu es max dans toute les statictisques, Bravo !"));
    	    		if(player.experienceLevel == 10) {
    	    			player.sendMessage(new TextComponentString("| Tu es au level maximum, quel puissance !"));
    	    		}
    	    		player.sendMessage(new TextComponentString("--------------------------"));
    			} else {
    				player.sendMessage(new TextComponentString("--------------------------"));
    				player.sendMessage(new TextComponentString("| Statistics actualisé !"));
    				player.sendMessage(new TextComponentString("--------------------------"));
    			}
    		} else {
    			player.sendMessage(new TextComponentString("--------------------------"));
    			player.sendMessage(new TextComponentString("| Tu n'as pas assez de falnas."));
    			player.sendMessage(new TextComponentString("--------------------------"));
    		}
    		
        	
        	// If player send command like /dmf levelup
        } else if("levelup".equalsIgnoreCase(args[0])) {
        		// If player have one stats at the D rank minimum
        	if(pCapData.getInteger("forcelvl" + player.experienceLevel) > 499 || pCapData.getInteger("endurancelvl" + player.experienceLevel) > 499 || pCapData.getInteger("agilitelvl" + player.experienceLevel) > 499 || pCapData.getInteger("dexteritelvl" + player.experienceLevel) > 499 || pCapData.getInteger("magielvl" + player.experienceLevel) > 499) {
    				// If player have experienceLevel is different of 10
        		if(player.experienceLevel != 10) {
        				// If player boolean capability levelup is true
    				if(pCap.getLevelUp()) {
    					player.addExperienceLevel(1);
    					pCap.setLevelUp(false);
    					CommonEventHandler.addMaxHealth(player);
    					CommonEventHandler.addVelocity(player);
    					player.sendMessage(new TextComponentString("--------------------------"));
    					player.sendMessage(new TextComponentString("| Bravo tu as level up !"));
    					player.sendMessage(new TextComponentString("--------------------------"));
    				} else {
    					player.sendMessage(new TextComponentString("--------------------------"));
    					player.sendMessage(new TextComponentString("| Tu n'as pas fait d'acte reconnu par les dieux."));
    					player.sendMessage(new TextComponentString("--------------------------"));
    				}
    			} else {
    				player.sendMessage(new TextComponentString("--------------------------"));
    				player.sendMessage(new TextComponentString("| Tu es au level maximum."));
    				player.sendMessage(new TextComponentString("--------------------------"));
    			}
    		} else {
    			player.sendMessage(new TextComponentString("--------------------------"));
    			player.sendMessage(new TextComponentString("| Tu n'es pas apte à passer au prochain level."));
    			player.sendMessage(new TextComponentString("| Minimum une statistique au rang D et un acte reconnu des dieux."));
    			player.sendMessage(new TextComponentString("--------------------------"));
    		}
        	
        	// If player send other command for the future
        } else if("sword".equalsIgnoreCase(args[0])) {
        	if(player.getHeldItem(EnumHand.MAIN_HAND).getItem().getUnlocalizedName().equalsIgnoreCase(ItemsMod.hestia_dagger_2.getUnlocalizedName())) {
            	ItemStack pItemHand = player.getHeldItem(EnumHand.MAIN_HAND);
            	if(!pItemHand.hasTagCompound()) {
            		pItemHand.setTagCompound(new NBTTagCompound());
                	pItemHand.getTagCompound().setInteger("xpSword", 0);
            	} else if(!pItemHand.getTagCompound().hasKey("xpSword")) {
            		pItemHand.getTagCompound().setInteger("xpSword", 0);
            	}
	        	player.sendMessage(new TextComponentString("--------------------------"));
				player.sendMessage(new TextComponentString("| Ton épée a " + pItemHand.getTagCompound().getInteger("xpSword") + " xp."));
				player.sendMessage(new TextComponentString("--------------------------"));
			}
        }
    }

    @Override
    public String getName() {
        return "dmf";
    }
}
