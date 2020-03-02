package fr.augma.danmachimenu.commands;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import fr.augma.danmachimenu.capabilities.IPlayerDataCap;
import fr.augma.danmachimenu.capabilities.PlayerDataCapProvider;
import fr.augma.danmachimenu.events.CommonEventHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.server.permission.PermissionAPI;

public class CommandRefresh extends CommandBase {

	public CommandRefresh() {
		
	}
	
	@Override
	public String getName() {
		return "dmfrefresh";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Refresh your statistics";
	}
	
	public int getRequiredPermissionLevel() {	
        return 4;
    }
	
	@Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        if (!(sender instanceof EntityPlayer)) return false;
        return sender.canUseCommand(this.getRequiredPermissionLevel(), this.getName()) || PermissionAPI.hasPermission((EntityPlayerMP) sender, "dmf.refresh");
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = getCommandSenderAsPlayer(sender);
		IPlayerDataCap pCap = player.getCapability(PlayerDataCapProvider.CAPABILITY, null);
        NBTTagCompound pCapData = PlayerDataCapProvider.get(player).data();
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
		CommonEventHandler.addMaxHealth(player);
		CommonEventHandler.addVelocity(player);
		if(maxed) {
			player.sendMessage(new TextComponentString("--------------------------"));
    		player.sendMessage(new TextComponentString("| You'r full of statistics for your level, Congratulation !"));
    		if(player.experienceLevel == 10) {
    			player.sendMessage(new TextComponentString("| You'r at the maximum level, powerfull !"));
    		}
    		player.sendMessage(new TextComponentString("--------------------------"));
		} else {
			player.sendMessage(new TextComponentString("--------------------------"));
			player.sendMessage(new TextComponentString("| Statistics refresh !"));
			player.sendMessage(new TextComponentString("--------------------------"));
		}
	}
}
