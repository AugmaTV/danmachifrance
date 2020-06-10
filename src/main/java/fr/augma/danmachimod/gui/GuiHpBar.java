package fr.augma.danmachimod.gui;

import fr.augma.danmachimod.DanMachiMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiHpBar extends Gui {
	
	private final ResourceLocation lifebar = new ResourceLocation(DanMachiMod.MODID, "textures/gui/life_bar_test.png");
	private final ResourceLocation foodbar = new ResourceLocation(DanMachiMod.MODID, "textures/gui/food_bar_test.png");
	private final int text_width = 220, text_height = 50;
	

	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			Minecraft mc = Minecraft.getMinecraft();
			mc.fontRenderer.drawString(mc.player.getName(), 25, 8, 0xFFFFFF, true);
			mc.fontRenderer.drawString("Niveau : " + mc.player.experienceLevel, 150, 8, 0xFFFFFF, true);
			mc.renderEngine.bindTexture(lifebar);
			float oneUnit = (float) 220 / mc.player.getMaxHealth();
			int currentWidth = (int) (oneUnit * mc.player.getHealth());
			drawTexturedModalRect(1, 1, 0, 0, text_width, text_height);
			drawTexturedModalRect(-1, 8, 0, text_height+2, currentWidth, text_height);
			mc.renderEngine.bindTexture(foodbar);
			float oneUnitF = (float) 190 / 20.0F;
			int currentWidthF = (int) (oneUnitF * mc.player.getFoodStats().getFoodLevel());
			drawTexturedModalRect(21, 29, 0, 20, currentWidthF, text_height);
			drawTexturedModalRect(20, 31, 0, 0, 190, 20);
		}
		if(event.getType() == RenderGameOverlayEvent.ElementType.HEALTH) {
			if (!event.isCanceled()) {
                event.setCanceled(true);
            }
		}
		if(event.getType() == RenderGameOverlayEvent.ElementType.FOOD) {
			if (!event.isCanceled()) {
                event.setCanceled(true);
            }
		}
		
		if(event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE) {
			if (!event.isCanceled()) {
                event.setCanceled(true);
            }
		}
	}
}
