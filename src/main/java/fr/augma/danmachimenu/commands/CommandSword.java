package fr.augma.danmachimenu.commands;

import java.util.Arrays;
import java.util.List;

import fr.augma.danmachimenu.init.ItemsMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.server.permission.PermissionAPI;

public class CommandSword extends CommandBase {

	public CommandSword() {
		
	}
	
	@Override
	public String getName() {
		return "dmfsword";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Show amount of xp in your sword";
	}
	
	public int getRequiredPermissionLevel() {	
        return 4;
    }
	
	@Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        if (!(sender instanceof EntityPlayer)) return false;
        return sender.canUseCommand(this.getRequiredPermissionLevel(), this.getName()) || PermissionAPI.hasPermission((EntityPlayerMP) sender, "dmf.sword");
    }
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayerMP player = getCommandSenderAsPlayer(sender);
		if(player.getHeldItem(EnumHand.MAIN_HAND).getItem().getUnlocalizedName().equalsIgnoreCase(ItemsMod.hestia_dagger_2.getUnlocalizedName())) {
        	ItemStack pItemHand = player.getHeldItem(EnumHand.MAIN_HAND);
        	if(pItemHand.hasTagCompound()) {
        		if(pItemHand.getTagCompound().hasKey("xpSword")) {
        			NBTTagCompound pCompoundItem = pItemHand.getTagCompound();
        			player.sendMessage(new TextComponentString("" + pCompoundItem.getInteger("xpSword")));
        		}
        	} else {
        		pItemHand.setTagCompound(new NBTTagCompound());
        		pItemHand.getTagCompound().setInteger("xpSword", 0);
        		player.sendMessage(new TextComponentString("" + pItemHand.getTagCompound().getInteger("xpSword")));
        	}
		}
	}

}
