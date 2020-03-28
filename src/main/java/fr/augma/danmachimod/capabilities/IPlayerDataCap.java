package fr.augma.danmachimod.capabilities;

import net.minecraft.nbt.NBTTagCompound;

public interface IPlayerDataCap {

    NBTTagCompound data();

    void data(NBTTagCompound data);
    
    default int getTotalSums() {
    	return getSumsForce() + getSumsEndurance() + getSumsAgilite() + getSumsDexterite() + getSumsMagie();
    }
    
    default int getSumsForce() {
    	return getForce1() + getForce2() + getForce3() + getForce4() + getForce5() + getForce6() + getForce7() + getForce8() + getForce9() + getForce10();
    }
    
    default int getSumsEndurance() {
    	return getEndurance1() + getEndurance2() + getEndurance3() + getEndurance4() + getEndurance5() + getEndurance6() + getEndurance7() + getEndurance8() + getEndurance9() + getEndurance10();
    }
    
    default int getSumsAgilite() {
    	return getAgilite1() + getAgilite2() + getAgilite3() + getAgilite4() + getAgilite5() + getAgilite6() + getAgilite7() + getAgilite8() + getAgilite9() + getAgilite10();
    }
    
    default int getSumsDexterite() {
    	return getDexterite1() + getDexterite2() + getDexterite3() + getDexterite4() + getDexterite5() + getDexterite6() + getDexterite7() + getDexterite8() + getDexterite9() + getDexterite10();
    }
    
    default int getSumsMagie() {
    	return getMagie1() + getMagie2() + getMagie3() + getMagie4() + getMagie5() + getMagie6() + getMagie7() + getMagie8() + getMagie9() + getMagie10();
    }

    default int getForce1() {
        return this.data().getInteger("forcelvl1");
    }

    default void setForce1(int param) {
        this.data().setInteger("forcelvl1", param);
    }

    default int getAgilite1() {
        return this.data().getInteger("agilitelvl1");
    }

    default void setAgilite1(int param) {
        this.data().setInteger("agilitelvl1", param);
    }

    default int getEndurance1() {
        return this.data().getInteger("endurancelvl1");
    }

    default void setEndurance1(int param) {
        this.data().setInteger("endurancelvl1", param);
    }

    default int getDexterite1() {
        return this.data().getInteger("dexteritelvl1");
    }

    default void setDexterite1(int param) {
        this.data().setInteger("dexteritelvl1", param);
    }

    default int getMagie1() {
        return this.data().getInteger("magielvl1");
    }

    default void setMagie1(int param) {
        this.data().setInteger("magielvl1", param);
    }

    default int getForce2() {
        return this.data().getInteger("forcelvl2");
    }

    default void setForce2(int param) {
        this.data().setInteger("forcelvl2", param);
    }

    default int getAgilite2() {
        return this.data().getInteger("agilitelvl2");
    }

    default void setAgilite2(int param) {
        this.data().setInteger("agilitelvl2", param);
    }

    default int getEndurance2() {
        return this.data().getInteger("endurancelvl2");
    }

    default void setEndurance2(int param) {
        this.data().setInteger("endurancelvl2", param);
    }

    default int getDexterite2() {
        return this.data().getInteger("dexteritelvl2");
    }

    default void setDexterite2(int param) {
        this.data().setInteger("dexteritelvl2", param);
    }

    default int getMagie2() {
        return this.data().getInteger("magielvl2");
    }

    default void setMagie2(int param) {
        this.data().setInteger("magielvl2", param);
    }

    default int getForce3() {
        return this.data().getInteger("forcelvl3");
    }

    default void setForce3(int param) {
        this.data().setInteger("forcelvl3", param);
    }

    default int getAgilite3() {
        return this.data().getInteger("agilitelvl3");
    }

    default void setAgilite3(int param) {
        this.data().setInteger("agilitelvl3", param);
    }

    default int getEndurance3() {
        return this.data().getInteger("endurancelvl3");
    }

    default void setEndurance3(int param) {
        this.data().setInteger("endurancelvl3", param);
    }

    default int getDexterite3() {
        return this.data().getInteger("dexteritelvl3");
    }

    default void setDexterite3(int param) {
        this.data().setInteger("dexteritelvl3", param);
    }

    default int getMagie3() {
        return this.data().getInteger("magielvl3");
    }

    default void setMagie3(int param) {
        this.data().setInteger("magielvl3", param);
    }

    default int getForce4() {
        return this.data().getInteger("forcelvl4");
    }

    default void setForce4(int param) {
        this.data().setInteger("forcelvl4", param);
    }

    default int getAgilite4() {
        return this.data().getInteger("agilitelvl4");
    }

    default void setAgilite4(int param) {
        this.data().setInteger("agilitelvl4", param);
    }

    default int getEndurance4() {
        return this.data().getInteger("endurancelvl4");
    }

    default void setEndurance4(int param) {
        this.data().setInteger("endurancelvl4", param);
    }

    default int getDexterite4() {
        return this.data().getInteger("dexteritelvl4");
    }

    default void setDexterite4(int param) {
        this.data().setInteger("dexteritelvl4", param);
    }

    default int getMagie4() {
        return this.data().getInteger("magielvl4");
    }

    default void setMagie4(int param) {
        this.data().setInteger("magielvl4", param);
    }

    default int getForce5() {
        return this.data().getInteger("forcelvl5");
    }

    default void setForce5(int param) {
        this.data().setInteger("forcelvl5", param);
    }

    default int getAgilite5() {
        return this.data().getInteger("agilitelvl5");
    }

    default void setAgilite5(int param) {
        this.data().setInteger("agilitelvl5", param);
    }

    default int getEndurance5() {
        return this.data().getInteger("endurancelvl5");
    }

    default void setEndurance5(int param) {
        this.data().setInteger("endurancelvl5", param);
    }

    default int getDexterite5() {
        return this.data().getInteger("dexteritelvl5");
    }

    default void setDexterite5(int param) {
        this.data().setInteger("dexteritelvl5", param);
    }

    default int getMagie5() {
        return this.data().getInteger("magielvl5");
    }

    default void setMagie5(int param) {
        this.data().setInteger("magielvl5", param);
    }

    default int getForce6() {
        return this.data().getInteger("forcelvl6");
    }

    default void setForce6(int param) {
        this.data().setInteger("forcelvl6", param);
    }

    default int getAgilite6() {
        return this.data().getInteger("agilitelvl6");
    }

    default void setAgilite6(int param) {
        this.data().setInteger("agilitelvl6", param);
    }

    default int getEndurance6() {
        return this.data().getInteger("endurancelvl6");
    }

    default void setEndurance6(int param) {
        this.data().setInteger("endurancelvl6", param);
    }

    default int getDexterite6() {
        return this.data().getInteger("dexteritelvl6");
    }

    default void setDexterite6(int param) {
        this.data().setInteger("dexteritelvl6", param);
    }

    default int getMagie6() {
        return this.data().getInteger("magielvl6");
    }

    default void setMagie6(int param) {
        this.data().setInteger("magielvl6", param);
    }

    default int getForce7() {
        return this.data().getInteger("forcelvl7");
    }

    default void setForce7(int param) {
        this.data().setInteger("forcelvl7", param);
    }

    default int getAgilite7() {
        return this.data().getInteger("agilitelvl7");
    }

    default void setAgilite7(int param) {
        this.data().setInteger("agilitelvl7", param);
    }

    default int getEndurance7() {
        return this.data().getInteger("endurancelvl7");
    }

    default void setEndurance7(int param) {
        this.data().setInteger("endurancelvl7", param);
    }

    default int getDexterite7() {
        return this.data().getInteger("dexteritelvl7");
    }

    default void setDexterite7(int param) {
        this.data().setInteger("dexteritelvl7", param);
    }

    default int getMagie7() {
        return this.data().getInteger("magielvl7");
    }

    default void setMagie7(int param) {
        this.data().setInteger("magielvl7", param);
    }

    default int getForce8() {
        return this.data().getInteger("forcelvl8");
    }

    default void setForce8(int param) {
        this.data().setInteger("forcelvl8", param);
    }

    default int getAgilite8() {
        return this.data().getInteger("agilitelvl8");
    }

    default void setAgilite8(int param) {
        this.data().setInteger("agilitelvl8", param);
    }

    default int getEndurance8() {
        return this.data().getInteger("endurancelvl8");
    }

    default void setEndurance8(int param) {
        this.data().setInteger("endurancelvl8", param);
    }

    default int getDexterite8() {
        return this.data().getInteger("dexteritelvl8");
    }

    default void setDexterite8(int param) {
        this.data().setInteger("dexteritelvl8", param);
    }

    default int getMagie8() {
        return this.data().getInteger("magielvl8");
    }

    default void setMagie8(int param) {
        this.data().setInteger("magielvl8", param);
    }

    default int getForce9() {
        return this.data().getInteger("forcelvl9");
    }

    default void setForce9(int param) {
        this.data().setInteger("forcelvl9", param);
    }

    default int getAgilite9() {
        return this.data().getInteger("agilitelvl9");
    }

    default void setAgilite9(int param) {
        this.data().setInteger("agilitelvl9", param);
    }

    default int getEndurance9() {
        return this.data().getInteger("endurancelvl9");
    }

    default void setEndurance9(int param) {
        this.data().setInteger("endurancelvl9", param);
    }

    default int getDexterite9() {
        return this.data().getInteger("dexteritelvl9");
    }

    default void setDexterite9(int param) {
        this.data().setInteger("dexteritelvl9", param);
    }

    default int getMagie9() {
        return this.data().getInteger("magielvl9");
    }

    default void setMagie9(int param) {
        this.data().setInteger("magielvl9", param);
    }

    default int getForce10() {
        return this.data().getInteger("forcelvl10");
    }

    default void setForce10(int param) {
        this.data().setInteger("forcelvl10", param);
    }

    default int getAgilite10() {
        return this.data().getInteger("agilitelvl10");
    }

    default void setAgilite10(int param) {
        this.data().setInteger("agilitelvl10", param);
    }

    default int getEndurance10() {
        return this.data().getInteger("endurancelvl10");
    }

    default void setEndurance10(int param) {
        this.data().setInteger("endurancelvl10", param);
    }

    default int getDexterite10() {
        return this.data().getInteger("dexteritelvl10");
    }

    default void setDexterite10(int param) {
        this.data().setInteger("dexteritelvl10", param);
    }

    default int getMagie10() {
        return this.data().getInteger("magielvl10");
    }

    default void setMagie10(int param) {
        this.data().setInteger("magielvl10", param);
    }

    default int getXP() {
        return this.data().getInteger("xp");
    }

    default void setXP(int xp) {
        this.data().setInteger("xp", xp);
    }

    default void addXP(int xp) {
        this.data().setInteger("xp", this.getXP() + xp);
    }
    
    default void setLevelUp(boolean bool) {
    	this.data().setBoolean("levelup", bool);
    }
    
    default boolean getLevelUp() {
    	return this.data().getBoolean("levelup");
    }

    class Impl implements IPlayerDataCap {

        private NBTTagCompound data;

        public Impl(NBTTagCompound data) {
            this.data = data;
        }

        public Impl() {
            this(new NBTTagCompound());
        }

        public NBTTagCompound data() {
            return this.data;
        }

        public void data(NBTTagCompound data) {
            this.data = data;
        }
    }
}