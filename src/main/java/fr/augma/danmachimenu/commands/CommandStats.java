package fr.augma.danmachimenu.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.server.permission.PermissionAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import fr.augma.danmachimenu.capabilities.IPlayerDataCap;
import fr.augma.danmachimenu.capabilities.PlayerDataCapProvider;

public class CommandStats extends CommandBase {

    public CommandStats() {

    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "Show your stats";
    }

    @Override
    public List getAliases() {
        return Arrays.asList("dmfstat", "dmfstats", "dmfstatistiques", "dmfstatistique");
    }

    public int getRequiredPermissionLevel() {
        return 4;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        if (!(sender instanceof EntityPlayer)) return false;
        return sender.canUseCommand(this.getRequiredPermissionLevel(), this.getName()) || PermissionAPI.hasPermission((EntityPlayerMP) sender, "dmf.stats");
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayerMP player = getCommandSenderAsPlayer(sender);
        IPlayerDataCap pCap = player.getCapability(PlayerDataCapProvider.CAPABILITY, null);
        NBTTagCompound pCapData = PlayerDataCapProvider.get(player).data();
        if(args.length < 1) {
        	player.sendMessage(new TextComponentString("--------------------------"));
        	player.sendMessage(new TextComponentString("| Ton level : " + player.experienceLevel));
        	player.sendMessage(new TextComponentString("| Xp : " + pCap.getXP()));
        	player.sendMessage(new TextComponentString("| Force : " + pCapData.getInteger("forcelvl" + player.experienceLevel)));
        	player.sendMessage(new TextComponentString("| Endurance : " + pCapData.getInteger("endurancelvl" + player.experienceLevel)));
        	player.sendMessage(new TextComponentString("| Agilité : " + pCapData.getInteger("agilitelvl" + player.experienceLevel)));
        	player.sendMessage(new TextComponentString("| Dexterité : " + pCapData.getInteger("dexteritelvl" + player.experienceLevel)));
        	player.sendMessage(new TextComponentString("| Magie : " + pCapData.getInteger("magielvl" + player.experienceLevel)));
        	player.sendMessage(new TextComponentString("--------------------------"));
        } else {
        	switch(args[0]) {
        	case "set":
        		pCap.addXP(1000);
        		player.sendMessage(new TextComponentString("--------------------------"));
        		player.sendMessage(new TextComponentString("| 1000 XP rajouter avec votre compteur!"));
        		player.sendMessage(new TextComponentString("--------------------------"));
        		break;
        	case "reset":
        		List<String> attribute = Arrays.asList("forcelvl", "endurancelvl", "agilitelvl", "dexteritelvl", "magielvl");
        		for(int i = 1; i < 11; i++) {
        			for(int j = 0; j < 5; j++) {
        				pCapData.setInteger(attribute.get(j) + i, 0);
        			}
        		}
        		break;
        	case "actualisé":
        		boolean maxed = false;
        		int xpCount = pCap.getXP();
        		int pLvl = player.experienceLevel;
        		List<String> attributeList = Arrays.asList("forcelvl", "endurancelvl", "agilitelvl", "dexteritelvl", "magielvl");
        		Random r = new Random();
        		for(int i = 0; i < xpCount; i++) {
        			if(!(pCapData.getInteger("forcelvl"+pLvl) == 999 && pCapData.getInteger("endurancelvl"+pLvl) == 999 && pCapData.getInteger("agilitelvl"+pLvl) == 999 && pCapData.getInteger("dexteritelvl"+pLvl) == 999 && pCapData.getInteger("magielvl"+pLvl) == 999)) {
        				int rInt = r.nextInt(5);
        				if(pCapData.getInteger(attributeList.get(rInt) + pLvl) != 999) {
        					pCapData.setInteger(attributeList.get(rInt) + pLvl, pCapData.getInteger(attributeList.get(rInt) + pLvl) + 1);
        				}
        				pCap.addXP(-1);
        			} else {
        				maxed = true;
        			}
        		}
        		
        		if(maxed) {
        			player.sendMessage(new TextComponentString("--------------------------"));
            		player.sendMessage(new TextComponentString("| Vous êtes max en statistique pour votre niveau, bravo !"));
            		player.sendMessage(new TextComponentString("--------------------------"));
        		} else {
        			player.sendMessage(new TextComponentString("--------------------------"));
        			player.sendMessage(new TextComponentString("| Statistique actualisé !"));
        			player.sendMessage(new TextComponentString("--------------------------"));
        		}
        		break;
        	default:
        		player.sendMessage(new TextComponentString("--------------------------"));
        		player.sendMessage(new TextComponentString("| dmfstatistique <set|reset|actualisé>"));
        		player.sendMessage(new TextComponentString("--------------------------"));
        		break;
        	}
        }
    }

    @Override
    public String getName() {
        return "dmfstatistique";
    }
}
