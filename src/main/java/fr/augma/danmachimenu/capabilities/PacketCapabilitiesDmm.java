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
	
	public int xpCount;
	public int forcelvl1;
	public int defenselvl1;
	public int agilitelvl1;
	public int dexteritelvl1;
	public int magielvl1;

	public PacketCapabilitiesDmm(int xp, int forcelvl1, int defenselvl1, int agilitelvl1, int dexteritelvl1, int magielvl1) {
		this.xpCount = xp;
		this.forcelvl1 = forcelvl1;
		this.defenselvl1 = defenselvl1;
		this.agilitelvl1 = agilitelvl1;
		this.dexteritelvl1 = dexteritelvl1;
		this.magielvl1 = magielvl1;
	}
	
	public PacketCapabilitiesDmm() {}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.xpCount = buf.readInt();
		this.forcelvl1 = buf.readInt();
		this.defenselvl1 = buf.readInt();
		this.agilitelvl1 = buf.readInt();
		this.dexteritelvl1 = buf.readInt();
		this.magielvl1 = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.xpCount);
		buf.writeInt(this.forcelvl1);
		buf.writeInt(this.defenselvl1);
		buf.writeInt(this.agilitelvl1);
		buf.writeInt(this.dexteritelvl1);
		buf.writeInt(this.magielvl1);
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
