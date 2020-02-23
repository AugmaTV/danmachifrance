package fr.augma.danmachimenu.capabilities;

import fr.augma.danmachimenu.packet.ScheduledPacketTask;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PacketCapabilitiesDmm implements IMessage {
	
	public int money;
	
	public PacketCapabilitiesDmm(int money) {
		this.money = money;
	}
	
	public PacketCapabilitiesDmm() {}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.money = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.money);
	}

	public static class ServerHandler implements IMessageHandler <PacketCapabilitiesDmm, IMessage> {
	
		@Override
		public IMessage onMessage(PacketCapabilitiesDmm message, MessageContext ctx) {
			FMLCommonHandler.instance().getMinecraftServerInstance().addScheduledTask(new ScheduledPacketTask(ctx.getServerHandler().player, message));
			return null;
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	public static class ClientHandler implements IMessageHandler <PacketCapabilitiesDmm, IMessage> {
	
		@Override
		public IMessage onMessage(PacketCapabilitiesDmm message, MessageContext ctx) {
			Minecraft.getMinecraft().addScheduledTask(new ScheduledPacketTask(null, message));
			return null;
		}
		
	}
}
