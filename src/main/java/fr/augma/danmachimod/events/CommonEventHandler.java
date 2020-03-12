package fr.augma.danmachimod.events;

import java.util.Random;

import javax.annotation.Nonnull;

import fr.augma.danmachimod.capabilities.IPlayerDataCap;
import fr.augma.danmachimod.capabilities.PlayerDataCapProvider;
import fr.augma.danmachimod.init.ItemsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class CommonEventHandler {
	
	public static void addMaxHealth(EntityPlayer player) {
		IPlayerDataCap pCap = player.getCapability(PlayerDataCapProvider.CAPABILITY, null);
		double pEndurance = 0;
    	for(int i = 1; i < 11; i++) {
    		pEndurance += pCap.data().getInteger("endurancelvl" + i);
    	}
    	pEndurance += 200 * (player.experienceLevel - 1);
    	double pMultiHealth = (pEndurance * 20D) / 11790D;
    	AttributeModifier modifierHealth = new AttributeModifier("health_modifier", pMultiHealth, 0);
    	for(AttributeModifier a : player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getModifiers()) {
    		player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(a.getID());
    	}
		player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(modifierHealth);
	}
	
	public static void addVelocity(EntityPlayer player) {
		IPlayerDataCap pCap = player.getCapability(PlayerDataCapProvider.CAPABILITY, null);
		double pAgilite = 0;
    	for(int i = 1; i < 11; i++) {
    		pAgilite += pCap.data().getInteger("endurancelvl" + i);
    	}
    	pAgilite += 200 * (player.experienceLevel - 1);
    	double pMultiSpeed = (pAgilite * 0.05D) / 11790;
    	AttributeModifier modifierSpeed = new AttributeModifier("speed_modifier", pMultiSpeed, 0);
    	for(AttributeModifier a : player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getModifiers()) {
    		player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(a.getID());
    	}
		player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(modifierSpeed);
		System.out.println(player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
	}

    @SubscribeEvent
    public static void onAttachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(PlayerDataCapProvider.NAME, new PlayerDataCapProvider());
        }
    }

	@SubscribeEvent
    public static void playerPickupXP(PlayerPickupXpEvent e) {
        if (!e.getEntityPlayer().world.isRemote) {
            EntityPlayer p = e.getEntityPlayer();
            e.setCanceled(true);
            e.getOrb().setDead();
            p.getCapability(PlayerDataCapProvider.CAPABILITY, null).addXP(e.getOrb().xpValue);
            PlayerDataCapProvider.sync(e.getEntityPlayer());
            if(p.getHeldItem(EnumHand.MAIN_HAND).getItem().getUnlocalizedName().equalsIgnoreCase(ItemsMod.hestia_dagger_2.getUnlocalizedName())) {
            	ItemStack pItemHand = p.getHeldItem(EnumHand.MAIN_HAND);
            	if(pItemHand.hasTagCompound()) {
            		if(pItemHand.getTagCompound().hasKey("xpSword")) {
            			NBTTagCompound pCompoundItem = pItemHand.getTagCompound();
            			pCompoundItem.setInteger("xpSword", pCompoundItem.getInteger("xpSword") + e.getOrb().xpValue);
            		}
            	} else {
            		pItemHand.setTagCompound(new NBTTagCompound());
            		pItemHand.getTagCompound().setInteger("xpSword", 0);
            		pItemHand.getTagCompound().setInteger("xpSword", pItemHand.getTagCompound().getInteger("xpSword") + e.getOrb().xpValue);
            	}
            }
        }
    }

	
    @SubscribeEvent
    public static void onPlayerJoinEvent(PlayerEvent.PlayerLoggedInEvent event) {
        IPlayerDataCap pCap = event.player.getCapability(PlayerDataCapProvider.CAPABILITY, null);
        if (event.player.experienceLevel == 0) {
        	event.player.addExperienceLevel(1);
        }
        addVelocity(event.player);
        addMaxHealth(event.player);
    }

    
    @SubscribeEvent
    public static void onPlayerAttackEntity(LivingHurtEvent event) {
        if (event.getSource().getTrueSource() instanceof EntityPlayer && !event.getEntityLiving().world.isRemote) {
        	EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
        	IPlayerDataCap pCap = player.getCapability(PlayerDataCapProvider.CAPABILITY, null);
        	Random r = new Random();
        	float pForce = 0F;
        	float pDexte = 0F;
        	float pMulti = 0F;
        	float pCoefDexte = 0F;
        	float damage = 0F;
        	
        	for(int i = 1; i < 11; i++) {
        		pForce += pCap.data().getInteger("forcelvl" + i);
        	}
        	for(int j = 1; j < 11; j++) {
        		pDexte += pCap.data().getInteger("dexteritelvl" + j);
        	}
        	
        	pForce += 200 * (player.experienceLevel - 1);
        	pMulti = (pForce * 9.0F) / 11790 + 1;
        	pCoefDexte = (pDexte * 25.0F) / 11790;
        	damage = event.getAmount() * pMulti;
        	
        	if(r.nextDouble() * 100 <= pCoefDexte) {
        		damage = damage * 1.5F;
        		player.sendMessage(new TextComponentString(TextFormatting.DARK_GRAY + "CRITICAL"));
        	}
            event.setAmount(damage);
        }
    }
    
    
    @SubscribeEvent
    public static void onCritHit(CriticalHitEvent event) {
    	event.setDamageModifier(1);
    }

    
    @SubscribeEvent
    public static void onPlayerCloned(net.minecraftforge.event.entity.player.PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            if (event.getOriginal().hasCapability(PlayerDataCapProvider.CAPABILITY, null)) {
                IPlayerDataCap cap = PlayerDataCapProvider.get(event.getOriginal());
                IPlayerDataCap newCap = PlayerDataCapProvider.get(event.getEntityPlayer());
                newCap.data(cap.data().copy());
            }
        }
    }

    
    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        PlayerDataCapProvider.sync(event.player);
        addMaxHealth(event.player);
        addVelocity(event.player);
        event.player.setHealth(event.player.getMaxHealth());
    }
}
