package fr.augma.danmachimenu.commands;

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

import fr.augma.danmachimenu.capabilities.IPlayerDataCap;
import fr.augma.danmachimenu.capabilities.PlayerDataCapProvider;
import fr.augma.danmachimenu.events.CommonEventHandler;
import fr.augma.danmachimenu.init.ItemsMod;

public class CommandStats extends CommandBase {

    public CommandStats() {

    }
    
    public String getNote(int attribute) {
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

    @Override
    public String getUsage(ICommandSender sender) {
        return "Show your stats";
    }

    public int getRequiredPermissionLevel() {	
        return 4;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        if (!(sender instanceof EntityPlayer)) return false;
        return sender.canUseCommand(this.getRequiredPermissionLevel(), this.getName()) || PermissionAPI.hasPermission((EntityPlayerMP) sender, "dmf.statistics");
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayerMP player = getCommandSenderAsPlayer(sender);
        IPlayerDataCap pCap = player.getCapability(PlayerDataCapProvider.CAPABILITY, null);
        NBTTagCompound pCapData = PlayerDataCapProvider.get(player).data();
        if(args.length < 1) {
        	player.sendMessage(new TextComponentString("--------------------------"));
        	player.sendMessage(new TextComponentString("| Your level : " + player.experienceLevel + "."));
        	player.sendMessage(new TextComponentString("| Strength : " + getNote(pCapData.getInteger("forcelvl" + player.experienceLevel)) + "."));
        	player.sendMessage(new TextComponentString("| Stamina : " + getNote(pCapData.getInteger("endurancelvl" + player.experienceLevel)) + "."));
        	player.sendMessage(new TextComponentString("| Agility : " + getNote(pCapData.getInteger("agilitelvl" + player.experienceLevel)) + "."));
        	player.sendMessage(new TextComponentString("| Dexterity : " + getNote(pCapData.getInteger("dexteritelvl" + player.experienceLevel)) + "."));
        	player.sendMessage(new TextComponentString("| Magie : " + getNote(pCapData.getInteger("magielvl" + player.experienceLevel)) + "."));
        	player.sendMessage(new TextComponentString("| Act of Gods : " + pCap.getLevelUp()));
        	player.sendMessage(new TextComponentString("--------------------------"));
        }
    }

    @Override
    public String getName() {
        return "dmfstat";
    }
}
