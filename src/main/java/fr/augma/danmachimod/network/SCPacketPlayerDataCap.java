package fr.augma.danmachimod.network;

import fr.augma.danmachimod.capabilities.PlayerDataCapProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SCPacketPlayerDataCap implements IMessage {

    private NBTTagCompound data;

    public SCPacketPlayerDataCap() {

    }

    public SCPacketPlayerDataCap(NBTTagCompound data) {
        this.data = data;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.data = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, this.data);
    }

    public static class Handler implements IMessageHandler<SCPacketPlayerDataCap, IMessage> {

        @SideOnly(Side.CLIENT)
        @Override
        public IMessage onMessage(SCPacketPlayerDataCap message, MessageContext ctx) {
            PlayerDataCapProvider.get(Minecraft.getMinecraft().player).data(message.data);
            return null;
        }
    }
}
