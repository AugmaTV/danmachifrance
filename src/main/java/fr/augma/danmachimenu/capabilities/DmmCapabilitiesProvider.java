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

	public int forcelvl1;
	public int defenselvl1;
	public int agilitelvl1;
	public int dexteritelvl1;
	public int magielvl1;
	public int xpCount;
	public EntityPlayer player;

	public static void register() {
		CapabilityManager.INSTANCE.register(PacketCapabilitiesDmm.class, new DmmCapabilitiesProvider.Storage(), new DmmCapabilitiesProvider.Factory());
	}
	
	public DmmCapabilitiesProvider(EntityPlayer player) {
		this.forcelvl1 = 0;
		this.defenselvl1 = 0;
		this.agilitelvl1 = 0;
		this.dexteritelvl1 = 0;
		this.magielvl1 = 0;
		this.xpCount = 0;
		this.player = player;
	}
	
	public void sync() {
		PacketCapabilitiesDmm packet = new PacketCapabilitiesDmm(this.getXpCount(), this.getForcelvl1(), this.getDefenselvl1(), this.getAgilitelvl1(), this.getDexteritelvl1(), this.getMagielvl1());
		if(!this.player.world.isRemote) {
			EntityPlayerMP playerMP = (EntityPlayerMP) player;
			DanMachiMenuMain.network.sendTo(packet, playerMP);
		} else {
			DanMachiMenuMain.network.sendToServer(packet);
		}
	}

	public void setForcelvl1(int forcelvl1) {
		this.forcelvl1 = forcelvl1;
	}
	
	public int getForcelvl1() {
		return this.forcelvl1;
	}
	
	public void setAgilitelvl1(int agilitelvl1) {
		this.agilitelvl1 = agilitelvl1;
	}
	
	public int getAgilitelvl1() {
		return this.agilitelvl1;
	}
	
	public void setDefenselvl1(int defenselvl1) {
		this.defenselvl1 = defenselvl1;
	}
	
	public int getDefenselvl1() {
		return this.defenselvl1;
	}
	
	public void setDexteritelvl1(int dexteritelvl1) {
		this.dexteritelvl1 = dexteritelvl1;
	}
	
	public int getDexteritelvl1() {
		return this.dexteritelvl1;
	}
	
	public void setMagielvl1(int magielvl1) {
		this.magielvl1 = magielvl1;
	}
	
	public int getMagielvl1() {
		return this.magielvl1;
	}
	
	public void setXpCount(int xp) {
		this.xpCount = xp;
	}
	
	public int getXpCount() {
		return this.xpCount;
	}
	
	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("forcelvl1", this.getForcelvl1());
		compound.setInteger("defenselvl1", this.getDefenselvl1());
		compound.setInteger("agilitelvl1", this.getAgilitelvl1());
		compound.setInteger("dexteritelvl1", this.getDexteritelvl1());
		compound.setInteger("magielvl1", this.getMagielvl1());
		compound.setInteger("xpCount", this.getXpCount());
		return compound;
	}

	@Override
	public void deserializeNBT(NBTTagCompound compound) {
		this.setForcelvl1(compound.getInteger("forcelvl1"));
		this.setDefenselvl1(compound.getInteger("defenselvl1"));
		this.setAgilitelvl1(compound.getInteger("agilitelvl1"));
		this.setDexteritelvl1(compound.getInteger("dexteritelvl1"));
		this.setMagielvl1(compound.getInteger("magielvl1"));
		this.setXpCount(compound.getInteger("xpCount"));
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
