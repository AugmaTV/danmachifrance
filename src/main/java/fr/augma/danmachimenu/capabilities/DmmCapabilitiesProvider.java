package fr.augma.danmachimenu.capabilities;

import java.util.concurrent.Callable;

import fr.augma.danmachimenu.DanMachiMenuMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;

public class DmmCapabilitiesProvider implements ICapabilityProvider, INBTSerializable<NBTTagCompound> {

	public int money;
	public EntityPlayer player;
	
	public static void register() {
		CapabilityManager.INSTANCE.register(PacketCapabilitiesDmm.class, new DmmCapabilitiesProvider.Storage(), new DmmCapabilitiesProvider.Factory());
	}
	
	public DmmCapabilitiesProvider(EntityPlayer player) {
		this.money = 0;
		this.player = player;
	}
	
	public void sync() {
		PacketCapabilitiesDmm packet = new PacketCapabilitiesDmm(this.getMoney());
		if(!this.player.world.isRemote) {
			EntityPlayerMP playerMP = (EntityPlayerMP) player;
			DanMachiMenuMain.network.sendTo(packet, playerMP);
		} else {
			DanMachiMenuMain.network.sendToServer(packet);
		}
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}

	
	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("Money", this.getMoney());
		return compound;
	}

	@Override
	public void deserializeNBT(NBTTagCompound compound) {
		this.setMoney(compound.getInteger("Money"));
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return DanMachiMenuMain.DMM_CAP != null && capability == DanMachiMenuMain.DMM_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return DanMachiMenuMain.DMM_CAP != null && capability == DanMachiMenuMain.DMM_CAP ? (T)this : null;
	}

	public static class Storage implements Capability.IStorage<PacketCapabilitiesDmm> {

		@Override
		public NBTBase writeNBT(Capability<PacketCapabilitiesDmm> capability, PacketCapabilitiesDmm instance,
				EnumFacing side) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void readNBT(Capability<PacketCapabilitiesDmm> capability, PacketCapabilitiesDmm instance,
				EnumFacing side, NBTBase nbt) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static class Factory implements Callable<PacketCapabilitiesDmm> {

		@Override
		public PacketCapabilitiesDmm call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
