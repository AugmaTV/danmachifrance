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
	public int xpCount;
	public EntityPlayer player;

	public static void register() {
		CapabilityManager.INSTANCE.register(PacketCapabilitiesDmm.class, new DmmCapabilitiesProvider.Storage(), new DmmCapabilitiesProvider.Factory());
	}
	
	public DmmCapabilitiesProvider(EntityPlayer player) {
		//level 1
		this.forcelvl1 = 0;
		this.endurancelvl1 = 0;
		this.agilitelvl1 = 0;
		this.dexteritelvl1 = 0;
		this.magielvl1 = 0;
		//level 2
		this.forcelvl2 = 0;
		this.endurancelvl2 = 0;
		this.agilitelvl2 = 0;
		this.dexteritelvl2 = 0;
		this.magielvl2 = 0;
		//level 3
		this.forcelvl3 = 0;
		this.endurancelvl3 = 0;
		this.agilitelvl3 = 0;
		this.dexteritelvl3 = 0;
		this.magielvl3 = 0;
		//level 4
		this.forcelvl4 = 0;
		this.endurancelvl4 = 0;
		this.agilitelvl4 = 0;
		this.dexteritelvl4 = 0;
		this.magielvl4 = 0;
		//level 5
		this.forcelvl5 = 0;
		this.endurancelvl5 = 0;
		this.agilitelvl5 = 0;
		this.dexteritelvl5 = 0;
		this.magielvl5 = 0;
		//level 6
		this.forcelvl6 = 0;
		this.endurancelvl6 = 0;
		this.agilitelvl6 = 0;
		this.dexteritelvl6 = 0;
		this.magielvl6 = 0;
		//level 7
		this.forcelvl7 = 0;
		this.endurancelvl7 = 0;
		this.agilitelvl7 = 0;
		this.dexteritelvl7 = 0;
		this.magielvl7 = 0;
		//level 8
		this.forcelvl8 = 0;
		this.endurancelvl8 = 0;
		this.agilitelvl8 = 0;
		this.dexteritelvl8 = 0;
		this.magielvl8 = 0;
		//level 9
		this.forcelvl9 = 0;
		this.endurancelvl9 = 0;
		this.agilitelvl9 = 0;
		this.dexteritelvl9 = 0;
		this.magielvl9 = 0;
		//level 10
		this.forcelvl10 = 0;
		this.endurancelvl10 = 0;
		this.agilitelvl10 = 0;
		this.dexteritelvl10 = 0;
		this.magielvl10 = 0;
		this.xpCount = 0;
		this.player = player;
	}
	
	public void sync() {
		PacketCapabilitiesDmm packet = new PacketCapabilitiesDmm(this.getXpCount(), this.getForcelvl1(), this.getEndurancelvl1(), this.getAgilitelvl1(), this.getDexteritelvl1(), this.getMagielvl1(), this.getForcelvl2(), this.getEndurancelvl2(), this.getAgilitelvl2(), this.getDexteritelvl2(), this.getMagielvl2(), this.getForcelvl3(), this.getEndurancelvl3(), this.getAgilitelvl3(), this.getDexteritelvl3(), this.getMagielvl3(), this.getForcelvl4(), this.getEndurancelvl4(), this.getAgilitelvl4(), this.getDexteritelvl4(), this.getMagielvl4(), this.getForcelvl5(), this.getEndurancelvl5(), this.getAgilitelvl5(), this.getDexteritelvl5(), this.getMagielvl5(), this.getForcelvl6(), this.getEndurancelvl6(), this.getAgilitelvl6(), this.getDexteritelvl6(), this.getMagielvl6(), this.getForcelvl7(), this.getEndurancelvl7(), this.getAgilitelvl7(), this.getDexteritelvl7(), this.getMagielvl7(), this.getForcelvl8(), this.getEndurancelvl8(), this.getAgilitelvl8(), this.getDexteritelvl8(), this.getMagielvl8(), this.getForcelvl9(), this.getEndurancelvl9(), this.getAgilitelvl9(), this.getDexteritelvl9(), this.getMagielvl9(), this.getForcelvl10(), this.getEndurancelvl10(), this.getAgilitelvl10(), this.getDexteritelvl10(), this.getMagielvl10());
		if(!this.player.world.isRemote) {
			EntityPlayerMP playerMP = (EntityPlayerMP) player;
			DanMachiMenuMain.network.sendTo(packet, playerMP);
		} else {
			DanMachiMenuMain.network.sendToServer(packet);
		}
	}

	//level 1
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
	
	public void setEndurancelvl1(int endurancelvl1) {
		this.endurancelvl1 = endurancelvl1;
	}
	
	public int getEndurancelvl1() {
		return this.endurancelvl1;
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
	
	//level 2
	public void setForcelvl2(int forcelvl2) {
		this.forcelvl2 = forcelvl2;
	}
	
	public int getForcelvl2() {
		return this.forcelvl2;
	}
	
	public void setAgilitelvl2(int agilitelvl2) {
		this.agilitelvl2 = agilitelvl2;
	}
	
	public int getAgilitelvl2() {
		return this.agilitelvl2;
	}
	
	public void setEndurancelvl2(int endurancelvl2) {
		this.endurancelvl2 = endurancelvl2;
	}
	
	public int getEndurancelvl2() {
		return this.endurancelvl2;
	}
	
	public void setDexteritelvl2(int dexteritelvl2) {
		this.dexteritelvl2 = dexteritelvl2;
	}
	
	public int getDexteritelvl2() {
		return this.dexteritelvl2;
	}
	
	public void setMagielvl2(int magielvl2) {
		this.magielvl2 = magielvl2;
	}
	
	public int getMagielvl2() {
		return this.magielvl2;
	}
	
	//level 3
	public void setForcelvl3(int forcelvl3) {
		this.forcelvl3 = forcelvl3;
	}
	
	public int getForcelvl3() {
		return this.forcelvl3;
	}
	
	public void setAgilitelvl3(int agilitelvl3) {
		this.agilitelvl3 = agilitelvl3;
	}
	
	public int getAgilitelvl3() {
		return this.agilitelvl3;
	}
	
	public void setEndurancelvl3(int endurancelvl3) {
		this.endurancelvl3 = endurancelvl3;
	}
	
	public int getEndurancelvl3() {
		return this.endurancelvl3;
	}
	
	public void setDexteritelvl3(int dexteritelvl3) {
		this.dexteritelvl3 = dexteritelvl3;
	}
	
	public int getDexteritelvl3() {
		return this.dexteritelvl3;
	}
	
	public void setMagielvl3(int magielvl3) {
		this.magielvl3 = magielvl3;
	}
	
	public int getMagielvl3() {
		return this.magielvl3;
	}
	
	//level 4
	public void setForcelvl4(int forcelvl4) {
		this.forcelvl4 = forcelvl4;
	}
	
	public int getForcelvl4() {
		return this.forcelvl4;
	}
	
	public void setAgilitelvl4(int agilitelvl4) {
		this.agilitelvl4 = agilitelvl4;
	}
	
	public int getAgilitelvl4() {
		return this.agilitelvl4;
	}
	
	public void setEndurancelvl4(int endurancelvl4) {
		this.endurancelvl4 = endurancelvl4;
	}
	
	public int getEndurancelvl4() {
		return this.endurancelvl4;
	}
	
	public void setDexteritelvl4(int dexteritelvl4) {
		this.dexteritelvl4 = dexteritelvl4;
	}
	
	public int getDexteritelvl4() {
		return this.dexteritelvl4;
	}
	
	public void setMagielvl4(int magielvl4) {
		this.magielvl4 = magielvl4;
	}
	
	public int getMagielvl4() {
		return this.magielvl4;
	}
	
	//level 5
	public void setForcelvl5(int forcelvl5) {
		this.forcelvl5 = forcelvl5;
	}
	
	public int getForcelvl5() {
		return this.forcelvl5;
	}
	
	public void setAgilitelvl5(int agilitelvl5) {
		this.agilitelvl5 = agilitelvl5;
	}
	
	public int getAgilitelvl5() {
		return this.agilitelvl5;
	}
	
	public void setEndurancelvl5(int endurancelvl5) {
		this.endurancelvl5 = endurancelvl5;
	}
	
	public int getEndurancelvl5() {
		return this.endurancelvl5;
	}
	
	public void setDexteritelvl5(int dexteritelvl5) {
		this.dexteritelvl5 = dexteritelvl5;
	}
	
	public int getDexteritelvl5() {
		return this.dexteritelvl5;
	}
	
	public void setMagielvl5(int magielvl5) {
		this.magielvl5 = magielvl5;
	}
	
	public int getMagielvl5() {
		return this.magielvl5;
	}
	
	//level 6
	public void setForcelvl6(int forcelvl6) {
		this.forcelvl6 = forcelvl6;
	}
	
	public int getForcelvl6() {
		return this.forcelvl6;
	}
	
	public void setAgilitelvl6(int agilitelvl6) {
		this.agilitelvl6 = agilitelvl6;
	}
	
	public int getAgilitelvl6() {
		return this.agilitelvl6;
	}
	
	public void setEndurancelvl6(int endurancelvl6) {
		this.endurancelvl6 = endurancelvl6;
	}
	
	public int getEndurancelvl6() {
		return this.endurancelvl6;
	}
	
	public void setDexteritelvl6(int dexteritelvl6) {
		this.dexteritelvl6 = dexteritelvl6;
	}
	
	public int getDexteritelvl6() {
		return this.dexteritelvl6;
	}
	
	public void setMagielvl6(int magielvl6) {
		this.magielvl6 = magielvl6;
	}
	
	public int getMagielvl6() {
		return this.magielvl6;
	}
	
	//level 7
	public void setForcelvl7(int forcelvl7) {
		this.forcelvl7 = forcelvl7;
	}
	
	public int getForcelvl7() {
		return this.forcelvl7;
	}
	
	public void setAgilitelvl7(int agilitelvl7) {
		this.agilitelvl7 = agilitelvl7;
	}
	
	public int getAgilitelvl7() {
		return this.agilitelvl7;
	}
	
	public void setEndurancelvl7(int endurancelvl7) {
		this.endurancelvl7 = endurancelvl7;
	}
	
	public int getEndurancelvl7() {
		return this.endurancelvl7;
	}
	
	public void setDexteritelvl7(int dexteritelvl7) {
		this.dexteritelvl7 = dexteritelvl7;
	}
	
	public int getDexteritelvl7() {
		return this.dexteritelvl7;
	}
	
	public void setMagielvl7(int magielvl7) {
		this.magielvl7 = magielvl7;
	}
	
	public int getMagielvl7() {
		return this.magielvl7;
	}
	
	//level 8
	public void setForcelvl8(int forcelvl8) {
		this.forcelvl8 = forcelvl8;
	}
	
	public int getForcelvl8() {
		return this.forcelvl8;
	}
	
	public void setAgilitelvl8(int agilitelvl8) {
		this.agilitelvl8 = agilitelvl8;
	}
	
	public int getAgilitelvl8() {
		return this.agilitelvl8;
	}
	
	public void setEndurancelvl8(int endurancelvl8) {
		this.endurancelvl8 = endurancelvl8;
	}
	
	public int getEndurancelvl8() {
		return this.endurancelvl8;
	}
	
	public void setDexteritelvl8(int dexteritelvl8) {
		this.dexteritelvl8 = dexteritelvl8;
	}
	
	public int getDexteritelvl8() {
		return this.dexteritelvl8;
	}
	
	public void setMagielvl8(int magielvl8) {
		this.magielvl8 = magielvl8;
	}
	
	public int getMagielvl8() {
		return this.magielvl8;
	}
	
	//level 9
	public void setForcelvl9(int forcelvl9) {
		this.forcelvl9 = forcelvl9;
	}
	
	public int getForcelvl9() {
		return this.forcelvl9;
	}
	
	public void setAgilitelvl9(int agilitelvl9) {
		this.agilitelvl9 = agilitelvl9;
	}
	
	public int getAgilitelvl9() {
		return this.agilitelvl9;
	}
	
	public void setEndurancelvl9(int endurancelvl9) {
		this.endurancelvl9 = endurancelvl9;
	}
	
	public int getEndurancelvl9() {
		return this.endurancelvl9;
	}
	
	public void setDexteritelvl9(int dexteritelvl9) {
		this.dexteritelvl9 = dexteritelvl9;
	}
	
	public int getDexteritelvl9() {
		return this.dexteritelvl9;
	}
	
	public void setMagielvl9(int magielvl9) {
		this.magielvl9 = magielvl9;
	}
	
	public int getMagielvl9() {
		return this.magielvl9;
	}
	
	//level 10
	public void setForcelvl10(int forcelvl10) {
		this.forcelvl10 = forcelvl10;
	}
	
	public int getForcelvl10() {
		return this.forcelvl10;
	}
	
	public void setAgilitelvl10(int agilitelvl10) {
		this.agilitelvl10 = agilitelvl10;
	}
	
	public int getAgilitelvl10() {
		return this.agilitelvl10;
	}
	
	public void setEndurancelvl10(int endurancelvl10) {
		this.endurancelvl10 = endurancelvl10;
	}
	
	public int getEndurancelvl10() {
		return this.endurancelvl10;
	}
	
	public void setDexteritelvl10(int dexteritelvl10) {
		this.dexteritelvl10 = dexteritelvl10;
	}
	
	public int getDexteritelvl10() {
		return this.dexteritelvl10;
	}
	
	public void setMagielvl10(int magielvl10) {
		this.magielvl10 = magielvl10;
	}
	
	public int getMagielvl10() {
		return this.magielvl10;
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
		//level 1
		compound.setInteger("forcelvl1", this.getForcelvl1());
		compound.setInteger("endurancelvl1", this.getEndurancelvl1());
		compound.setInteger("agilitelvl1", this.getAgilitelvl1());
		compound.setInteger("dexteritelvl1", this.getDexteritelvl1());
		compound.setInteger("magielvl1", this.getMagielvl1());
		//level 2
		compound.setInteger("forcelvl2", this.getForcelvl2());
		compound.setInteger("endurancelvl2", this.getEndurancelvl2());
		compound.setInteger("agilitelvl2", this.getAgilitelvl2());
		compound.setInteger("dexteritelvl2", this.getDexteritelvl2());
		compound.setInteger("magielvl2", this.getMagielvl2());
		//level 3
		compound.setInteger("forcelvl3", this.getForcelvl3());
		compound.setInteger("endurancelvl3", this.getEndurancelvl3());
		compound.setInteger("agilitelvl3", this.getAgilitelvl3());
		compound.setInteger("dexteritelvl3", this.getDexteritelvl3());
		compound.setInteger("magielvl3", this.getMagielvl3());
		//level 4
		compound.setInteger("forcelvl4", this.getForcelvl4());
		compound.setInteger("endurancelvl4", this.getEndurancelvl4());
		compound.setInteger("agilitelvl4", this.getAgilitelvl4());
		compound.setInteger("dexteritelvl4", this.getDexteritelvl4());
		compound.setInteger("magielvl4", this.getMagielvl4());
		//level 5
		compound.setInteger("forcelvl5", this.getForcelvl5());
		compound.setInteger("endurancelvl5", this.getEndurancelvl5());
		compound.setInteger("agilitelvl5", this.getAgilitelvl5());
		compound.setInteger("dexteritelvl5", this.getDexteritelvl5());
		compound.setInteger("magielvl5", this.getMagielvl5());
		//level 6
		compound.setInteger("forcelvl6", this.getForcelvl6());
		compound.setInteger("endurancelvl6", this.getEndurancelvl6());
		compound.setInteger("agilitelvl6", this.getAgilitelvl6());
		compound.setInteger("dexteritelvl6", this.getDexteritelvl6());
		compound.setInteger("magielvl6", this.getMagielvl6());
		//level 7
		compound.setInteger("forcelvl7", this.getForcelvl7());
		compound.setInteger("endurancelvl7", this.getEndurancelvl7());
		compound.setInteger("agilitelvl7", this.getAgilitelvl7());
		compound.setInteger("dexteritelvl7", this.getDexteritelvl7());
		compound.setInteger("magielvl7", this.getMagielvl7());
		//level 8
		compound.setInteger("forcelvl8", this.getForcelvl8());
		compound.setInteger("endurancelvl8", this.getEndurancelvl8());
		compound.setInteger("agilitelvl8", this.getAgilitelvl8());
		compound.setInteger("dexteritelvl8", this.getDexteritelvl8());
		compound.setInteger("magielvl8", this.getMagielvl8());
		//level 9
		compound.setInteger("forcelvl9", this.getForcelvl9());
		compound.setInteger("endurancelvl9", this.getEndurancelvl9());
		compound.setInteger("agilitelvl9", this.getAgilitelvl9());
		compound.setInteger("dexteritelvl9", this.getDexteritelvl9());
		compound.setInteger("magielvl9", this.getMagielvl9());
		//level 10
		compound.setInteger("forcelvl10", this.getForcelvl10());
		compound.setInteger("endurancelvl10", this.getEndurancelvl10());
		compound.setInteger("agilitelvl10", this.getAgilitelvl10());
		compound.setInteger("dexteritelvl10", this.getDexteritelvl10());
		compound.setInteger("magielvl12", this.getMagielvl10());
		compound.setInteger("xpCount", this.getXpCount());
		return compound;
	}

	@Override
	public void deserializeNBT(NBTTagCompound compound) {
		//level 1
		this.setForcelvl1(compound.getInteger("forcelvl1"));
		this.setEndurancelvl1(compound.getInteger("endurancelvl1"));
		this.setAgilitelvl1(compound.getInteger("agilitelvl1"));
		this.setDexteritelvl1(compound.getInteger("dexteritelvl1"));
		this.setMagielvl1(compound.getInteger("magielvl1"));
		//level 2
		this.setForcelvl2(compound.getInteger("forcelvl2"));
		this.setEndurancelvl2(compound.getInteger("endurancelvl2"));
		this.setAgilitelvl2(compound.getInteger("agilitelvl2"));
		this.setDexteritelvl2(compound.getInteger("dexteritelvl2"));
		this.setMagielvl2(compound.getInteger("magielvl2"));
		//level 3
		this.setForcelvl3(compound.getInteger("forcelvl3"));
		this.setEndurancelvl3(compound.getInteger("endurancelvl3"));
		this.setAgilitelvl3(compound.getInteger("agilitelvl3"));
		this.setDexteritelvl3(compound.getInteger("dexteritelvl3"));
		this.setMagielvl3(compound.getInteger("magielvl3"));
		//level 4
		this.setForcelvl4(compound.getInteger("forcelvl4"));
		this.setEndurancelvl4(compound.getInteger("endurancelvl4"));
		this.setAgilitelvl4(compound.getInteger("agilitelvl4"));
		this.setDexteritelvl4(compound.getInteger("dexteritelvl4"));
		this.setMagielvl4(compound.getInteger("magielvl4"));
		//level 5
		this.setForcelvl5(compound.getInteger("forcelvl5"));
		this.setEndurancelvl5(compound.getInteger("endurancelvl5"));
		this.setAgilitelvl5(compound.getInteger("agilitelvl5"));
		this.setDexteritelvl5(compound.getInteger("dexteritelvl5"));
		this.setMagielvl5(compound.getInteger("magielvl5"));
		//level 6
		this.setForcelvl6(compound.getInteger("forcelvl6"));
		this.setEndurancelvl6(compound.getInteger("endurancelvl6"));
		this.setAgilitelvl6(compound.getInteger("agilitelvl6"));
		this.setDexteritelvl6(compound.getInteger("dexteritelvl6"));
		this.setMagielvl6(compound.getInteger("magielvl6"));
		//level 7
		this.setForcelvl7(compound.getInteger("forcelvl7"));
		this.setEndurancelvl7(compound.getInteger("endurancelvl7"));
		this.setAgilitelvl7(compound.getInteger("agilitelvl7"));
		this.setDexteritelvl7(compound.getInteger("dexteritelvl7"));
		this.setMagielvl7(compound.getInteger("magielvl7"));
		//level 8
		this.setForcelvl8(compound.getInteger("forcelvl8"));
		this.setEndurancelvl8(compound.getInteger("endurancelvl8"));
		this.setAgilitelvl8(compound.getInteger("agilitelvl8"));
		this.setDexteritelvl8(compound.getInteger("dexteritelvl8"));
		this.setMagielvl8(compound.getInteger("magielvl8"));
		//level 9
		this.setForcelvl9(compound.getInteger("forcelvl9"));
		this.setEndurancelvl9(compound.getInteger("endurancelvl9"));
		this.setAgilitelvl9(compound.getInteger("agilitelvl9"));
		this.setDexteritelvl9(compound.getInteger("dexteritelvl9"));
		this.setMagielvl9(compound.getInteger("magielvl9"));
		//level 10
		this.setForcelvl10(compound.getInteger("forcelvl10"));
		this.setEndurancelvl10(compound.getInteger("endurancelvl10"));
		this.setAgilitelvl10(compound.getInteger("agilitelvl10"));
		this.setDexteritelvl10(compound.getInteger("dexteritelvl10"));
		this.setMagielvl10(compound.getInteger("magielvl10"));
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
