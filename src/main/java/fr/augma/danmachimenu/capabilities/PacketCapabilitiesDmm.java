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
	//level 1
	public int forcelvl1;
	public int endurancelvl1;
	public int agilitelvl1;
	public int dexteritelvl1;
	public int magielvl1;
	//level 2
	public int forcelvl2;
	public int endurancelvl2;
	public int agilitelvl2;
	public int dexteritelvl2;
	public int magielvl2;
	//level 3
	public int forcelvl3;
	public int endurancelvl3;
	public int agilitelvl3;
	public int dexteritelvl3;
	public int magielvl3;
	//level 4
	public int forcelvl4;
	public int endurancelvl4;
	public int agilitelvl4;
	public int dexteritelvl4;
	public int magielvl4;
	//level 5
	public int forcelvl5;
	public int endurancelvl5;
	public int agilitelvl5;
	public int dexteritelvl5;
	public int magielvl5;
	//level 6
	public int forcelvl6;
	public int endurancelvl6;
	public int agilitelvl6;
	public int dexteritelvl6;
	public int magielvl6;
	//level 7
	public int forcelvl7;
	public int endurancelvl7;
	public int agilitelvl7;
	public int dexteritelvl7;
	public int magielvl7;
	//level 8
	public int forcelvl8;
	public int endurancelvl8;
	public int agilitelvl8;
	public int dexteritelvl8;
	public int magielvl8;
	//level 9
	public int forcelvl9;
	public int endurancelvl9;
	public int agilitelvl9;
	public int dexteritelvl9;
	public int magielvl9;
	//level 10
	public int forcelvl10;
	public int endurancelvl10;
	public int agilitelvl10;
	public int dexteritelvl10;
	public int magielvl10;

	public PacketCapabilitiesDmm(int xp, int forcelvl1, int endurancelvl1, int agilitelvl1, int dexteritelvl1, int magielvl1, int forcelvl2, int endurancelvl2, int agilitelvl2, int dexteritelvl2, int magielvl2, int forcelvl3, int endurancelvl3, int agilitelvl3, int dexteritelvl3, int magielvl3, int forcelvl4, int endurancelvl4, int agilitelvl4, int dexteritelvl4, int magielvl4, int forcelvl5, int endurancelvl5, int agilitelvl5, int dexteritelvl5, int magielvl5, int forcelvl6, int endurancelvl6, int agilitelvl6, int dexteritelvl6, int magielvl6, int forcelvl7, int endurancelvl7, int agilitelvl7, int dexteritelvl7, int magielvl7, int forcelvl8, int endurancelvl8, int agilitelvl8, int dexteritelvl8, int magielvl8, int forcelvl9, int endurancelvl9, int agilitelvl9, int dexteritelvl9, int magielvl9, int forcelvl10, int endurancelvl10, int agilitelvl10, int dexteritelvl10, int magielvl10) {
		//level 1
		this.forcelvl1 = forcelvl1;
		this.endurancelvl1 = endurancelvl1;
		this.agilitelvl1 = agilitelvl1;
		this.dexteritelvl1 = dexteritelvl1;
		this.magielvl1 = magielvl1;
		//level 2
		this.forcelvl2 = forcelvl2;
		this.endurancelvl2 = endurancelvl2;
		this.agilitelvl2 = agilitelvl2;
		this.dexteritelvl2 = dexteritelvl2;
		this.magielvl2 = magielvl2;
		//level 3
		this.forcelvl3 = forcelvl3;
		this.endurancelvl3 = endurancelvl3;
		this.agilitelvl3 = agilitelvl3;
		this.dexteritelvl3 = dexteritelvl3;
		this.magielvl3 = magielvl3;
		//level 4
		this.forcelvl4 = forcelvl4;
		this.endurancelvl4 = endurancelvl4;
		this.agilitelvl4 = agilitelvl4;
		this.dexteritelvl4 = dexteritelvl4;
		this.magielvl4 = magielvl4;
		//level 5
		this.forcelvl5 = forcelvl5;
		this.endurancelvl5 = endurancelvl5;
		this.agilitelvl5 = agilitelvl5;
		this.dexteritelvl5 = dexteritelvl5;
		this.magielvl5 = magielvl5;
		//level 6
		this.forcelvl6 = forcelvl6;
		this.endurancelvl6 = endurancelvl6;
		this.agilitelvl6 = agilitelvl6;
		this.dexteritelvl6 = dexteritelvl6;
		this.magielvl6 = magielvl6;
		//level 7
		this.forcelvl7 = forcelvl7;
		this.endurancelvl7 = endurancelvl7;
		this.agilitelvl7 = agilitelvl7;
		this.dexteritelvl7 = dexteritelvl7;
		this.magielvl7 = magielvl7;
		//level 8
		this.forcelvl8 = forcelvl8;
		this.endurancelvl8 = endurancelvl8;
		this.agilitelvl8 = agilitelvl8;
		this.dexteritelvl8 = dexteritelvl8;
		this.magielvl8 = magielvl8;
		//level 9
		this.forcelvl9 = forcelvl9;
		this.endurancelvl9 = endurancelvl9;
		this.agilitelvl9 = agilitelvl9;
		this.dexteritelvl9 = dexteritelvl9;
		this.magielvl9 = magielvl9;
		//level 10
		this.forcelvl10 = forcelvl10;
		this.endurancelvl10 = endurancelvl10;
		this.agilitelvl10 = agilitelvl10;
		this.dexteritelvl10 = dexteritelvl10;
		this.magielvl10 = magielvl10;
		this.xpCount = xp;
	}
	
	public PacketCapabilitiesDmm() {}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.xpCount = buf.readInt();
		//level 1
		this.forcelvl1 = buf.readInt();
		this.endurancelvl1 = buf.readInt();
		this.agilitelvl1 = buf.readInt();
		this.dexteritelvl1 = buf.readInt();
		this.magielvl1 = buf.readInt();
		//level 2
		this.forcelvl2 = buf.readInt();
		this.endurancelvl2 = buf.readInt();
		this.agilitelvl2 = buf.readInt();
		this.dexteritelvl2 = buf.readInt();
		this.magielvl2 = buf.readInt();
		//level 3
		this.forcelvl3 = buf.readInt();
		this.endurancelvl3 = buf.readInt();
		this.agilitelvl3 = buf.readInt();
		this.dexteritelvl3 = buf.readInt();
		this.magielvl3 = buf.readInt();
		//level 4
		this.forcelvl4 = buf.readInt();
		this.endurancelvl4 = buf.readInt();
		this.agilitelvl4 = buf.readInt();
		this.dexteritelvl4 = buf.readInt();
		this.magielvl4 = buf.readInt();
		//level 5
		this.forcelvl5 = buf.readInt();
		this.endurancelvl5 = buf.readInt();
		this.agilitelvl5 = buf.readInt();
		this.dexteritelvl5 = buf.readInt();
		this.magielvl5 = buf.readInt();
		//level 6
		this.forcelvl6 = buf.readInt();
		this.endurancelvl6 = buf.readInt();
		this.agilitelvl6 = buf.readInt();
		this.dexteritelvl6 = buf.readInt();
		this.magielvl6 = buf.readInt();
		//level 7
		this.forcelvl7 = buf.readInt();
		this.endurancelvl7 = buf.readInt();
		this.agilitelvl7 = buf.readInt();
		this.dexteritelvl7 = buf.readInt();
		this.magielvl7 = buf.readInt();
		//level 8
		this.forcelvl8 = buf.readInt();
		this.endurancelvl8 = buf.readInt();
		this.agilitelvl8 = buf.readInt();
		this.dexteritelvl8 = buf.readInt();
		this.magielvl8 = buf.readInt();
		//level 9
		this.forcelvl9 = buf.readInt();
		this.endurancelvl9 = buf.readInt();
		this.agilitelvl9 = buf.readInt();
		this.dexteritelvl9 = buf.readInt();
		this.magielvl9 = buf.readInt();
		//level 10
		this.forcelvl10 = buf.readInt();
		this.endurancelvl10 = buf.readInt();
		this.agilitelvl10 = buf.readInt();
		this.dexteritelvl10 = buf.readInt();
		this.magielvl10 = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.xpCount);
		//level 1
		buf.writeInt(this.forcelvl1);
		buf.writeInt(this.endurancelvl1);
		buf.writeInt(this.agilitelvl1);
		buf.writeInt(this.dexteritelvl1);
		buf.writeInt(this.magielvl1);
		//level 2
		buf.writeInt(this.forcelvl2);
		buf.writeInt(this.endurancelvl2);
		buf.writeInt(this.agilitelvl2);
		buf.writeInt(this.dexteritelvl2);
		buf.writeInt(this.magielvl2);
		//level 3
		buf.writeInt(this.forcelvl3);
		buf.writeInt(this.endurancelvl3);
		buf.writeInt(this.agilitelvl3);
		buf.writeInt(this.dexteritelvl3);
		buf.writeInt(this.magielvl3);
		//level 4
		buf.writeInt(this.forcelvl4);
		buf.writeInt(this.endurancelvl4);
		buf.writeInt(this.agilitelvl4);
		buf.writeInt(this.dexteritelvl4);
		buf.writeInt(this.magielvl4);
		//level 5
		buf.writeInt(this.forcelvl5);
		buf.writeInt(this.endurancelvl5);
		buf.writeInt(this.agilitelvl5);
		buf.writeInt(this.dexteritelvl5);
		buf.writeInt(this.magielvl5);
		//level 6
		buf.writeInt(this.forcelvl6);
		buf.writeInt(this.endurancelvl6);
		buf.writeInt(this.agilitelvl6);
		buf.writeInt(this.dexteritelvl6);
		buf.writeInt(this.magielvl6);
		//level 7
		buf.writeInt(this.forcelvl7);
		buf.writeInt(this.endurancelvl7);
		buf.writeInt(this.agilitelvl7);
		buf.writeInt(this.dexteritelvl7);
		buf.writeInt(this.magielvl7);
		//level 8
		buf.writeInt(this.forcelvl8);
		buf.writeInt(this.endurancelvl8);
		buf.writeInt(this.agilitelvl8);
		buf.writeInt(this.dexteritelvl8);
		buf.writeInt(this.magielvl8);
		//level 9
		buf.writeInt(this.forcelvl9);
		buf.writeInt(this.endurancelvl9);
		buf.writeInt(this.agilitelvl9);
		buf.writeInt(this.dexteritelvl9);
		buf.writeInt(this.magielvl9);
		//level 10
		buf.writeInt(this.forcelvl10);
		buf.writeInt(this.endurancelvl10);
		buf.writeInt(this.agilitelvl10);
		buf.writeInt(this.dexteritelvl10);
		buf.writeInt(this.magielvl10);
	}

	public static class ServerHandler implements IMessageHandler <PacketCapabilitiesDmm, IMessage> {
	
		@Override
		public IMessage onMessage(PacketCapabilitiesDmm message, MessageContext ctx) {
			FMLCommonHandler.instance().getMinecraftServerInstance().addScheduledTask(new ScheduledPacketTask(ctx.getServerHandler().player, message));
			return null;
		}
		
	}
	
	public static class ClientHandler implements IMessageHandler <PacketCapabilitiesDmm, IMessage> {
	
		@SideOnly(Side.CLIENT)
		@Override
		public IMessage onMessage(PacketCapabilitiesDmm message, MessageContext ctx) {
			Minecraft.getMinecraft().addScheduledTask(new ScheduledPacketTask(null, message));
			return null;
		}
		
	}
}
