package fr.augma.danmachimenu.commands;

import java.util.Arrays;
import java.util.List;

import fr.augma.danmachimenu.capabilities.IPlayerDataCap;
import fr.augma.danmachimenu.capabilities.PlayerDataCapProvider;
import fr.augma.danmachimenu.events.CommonEventHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CommandAdminReset extends CommandBase {

	@Override
	public String getName() {
		return "dmfadminreset";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Reset all of your statistics";
	}
	
	public int getRequiredPermissionLevel() {	
        return 4;
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = getCommandSenderAsPlayer(sender);
		NBTTagCompound pCapData = player.getCapability(PlayerDataCapProvider.CAPABILITY, null).data();
		List<String> attribute = Arrays.asList("forcelvl", "endurancelvl", "agilitelvl", "dexteritelvl", "magielvl");
		for(int i = 1; i < 11; i++) {
			for(int j = 0; j < 5; j++) {
				pCapData.setInteger(attribute.get(j) + i, 0);
			}
		}
		pCapData.setInteger("xp", 0);
		CommonEventHandler.addMaxHealth(player);
		CommonEventHandler.addVelocity(player);
		player.sendMessage(new TextComponentString("--------------------------"));
		player.sendMessage(new TextComponentString("| Reset success !"));
		player.sendMessage(new TextComponentString("--------------------------"));
	}
}
