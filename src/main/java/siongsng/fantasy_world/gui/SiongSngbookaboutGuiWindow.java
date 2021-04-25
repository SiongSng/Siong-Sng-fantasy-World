
package siongsng.fantasy_world.gui;

import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class SiongSngbookaboutGuiWindow extends ContainerScreen<SiongSngbookaboutGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public SiongSngbookaboutGuiWindow(SiongSngbookaboutGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 372;
		this.ySize = 195;
	}
	private static final ResourceLocation texture = new ResourceLocation("siongsngs_fantasy_world:textures/siong_sngbookabout.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("siongsngs_fantasy_world:textures/icon.png"));
		this.blit(ms, this.guiLeft + 1, this.guiTop + 4, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("siongsngs_fantasy_world:textures/icon_text.png"));
		this.blit(ms, this.guiLeft + 150, this.guiTop + -29, 0, 0, 250, 250, 250, 250);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("siongsngs_fantasy_world:textures/icon_1.png"));
		this.blit(ms, this.guiLeft + 244, this.guiTop + 16, 0, 0, 64, 64, 64, 64);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "\u95DC\u65BC \u83D8\u83D8\u7684\u5E7B\u60F3\u4E16\u754C-SSSFW", 16, 6, -8060673);
		this.font.drawString(ms, "\u6A21\u7D44\u540D\u7A31: Siong Sng's fantasy World", 3, 25, -12829636);
		this.font.drawString(ms, "\u6A21\u7D44\u8A3B\u518AID: siongsngs_fantasy_world", 3, 40, -12829636);
		this.font.drawString(ms, "\u6A21\u7D44\u7248\u672C: V1.0.0 Pre-alpha 18", 3, 54, -12829636);
		this.font.drawString(ms, "\u6A21\u7D44\u4F5C\u8005: Siong Sng", 3, 68, -12829636);
		this.font.drawString(ms, "\u652F\u63F4\u8A9E\u8A00: English\u3001\u7E41\u9AD4\u4E2D\u6587\u3001\u7C21\u4F53\u4E2D\u6587", 3, 96, -12829636);
		this.font.drawString(ms, "\u958B\u767C\u5DE5\u5177: IntelliJ IDEA\u3001Mcreator\u3001GIMP", 3, 81, -12829636);
		this.font.drawString(ms, "\u6A21\u7D44\u6240\u9700\u8F09\u5165\u5668: Forge(1.16.4-35.1.4)", 2, 111, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 157, this.guiTop + 166, 57, 20, new StringTextComponent("¦^¨ì­º­¶"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngbookaboutGui.ButtonPressedMessage(0, x, y, z));
				SiongSngbookaboutGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
