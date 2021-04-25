
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
public class SiongSngBookguiGuiWindow extends ContainerScreen<SiongSngBookguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public SiongSngBookguiGuiWindow(SiongSngBookguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 372;
		this.ySize = 195;
	}
	private static final ResourceLocation texture = new ResourceLocation("siongsngs_fantasy_world:textures/siong_sng_bookgui.png");
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
		this.blit(ms, this.guiLeft + 2, this.guiTop + 5, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("siongsngs_fantasy_world:textures/icon_1.png"));
		this.blit(ms, this.guiLeft + 42, this.guiTop + 23, 0, 0, 64, 64, 64, 64);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("siongsngs_fantasy_world:textures/icon_text.png"));
		this.blit(ms, this.guiLeft + -49, this.guiTop + -28, 0, 0, 250, 250, 250, 250);
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
		this.font.drawString(ms, "\u83D8\u83D8\u7684\u5E7B\u60F3\u4E16\u754C \u8FAD\u5178-\u77E5\u8B58\u4E4B\u66F8", 17, 7, -12829636);
		this.font.drawString(ms, "\u89E3\u9396\u5167\u5BB9 " + (entity.getPersistentData().getDouble("The_completion_rate")) + " %", 3, 176,
				-12829636);
		this.font.drawString(ms, "\u66F8\u7C4D\u7DE8\u5BEB\u8005:\u83D8\u83D8", 44, 154, -12829636);
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
		this.addButton(new Button(this.guiLeft + 261, this.guiTop + 169, 105, 20, new StringTextComponent("關於\"菘菘的幻想世界\""), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngBookguiGui.ButtonPressedMessage(0, x, y, z));
				SiongSngBookguiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 167, this.guiTop + 12, 41, 20, new StringTextComponent("故事"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngBookguiGui.ButtonPressedMessage(1, x, y, z));
				SiongSngBookguiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 167, this.guiTop + 48, 41, 20, new StringTextComponent("礦物"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngBookguiGui.ButtonPressedMessage(2, x, y, z));
				SiongSngBookguiGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 212, this.guiTop + 48, 41, 20, new StringTextComponent("武器"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngBookguiGui.ButtonPressedMessage(3, x, y, z));
				SiongSngBookguiGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 302, this.guiTop + 12, 63, 20, new StringTextComponent("怪物/Boss"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngBookguiGui.ButtonPressedMessage(4, x, y, z));
				SiongSngBookguiGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 257, this.guiTop + 48, 41, 20, new StringTextComponent("裝備"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngBookguiGui.ButtonPressedMessage(5, x, y, z));
				SiongSngBookguiGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 212, this.guiTop + 12, 41, 20, new StringTextComponent("生態域"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngBookguiGui.ButtonPressedMessage(6, x, y, z));
				SiongSngBookguiGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 257, this.guiTop + 12, 41, 20, new StringTextComponent("教學"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngBookguiGui.ButtonPressedMessage(7, x, y, z));
				SiongSngBookguiGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 302, this.guiTop + 48, 63, 20, new StringTextComponent("特殊效果?"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngBookguiGui.ButtonPressedMessage(8, x, y, z));
				SiongSngBookguiGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 302, this.guiTop + 84, 63, 20, new StringTextComponent("神秘知識?"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngBookguiGui.ButtonPressedMessage(9, x, y, z));
				SiongSngBookguiGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 167, this.guiTop + 84, 41, 20, new StringTextComponent("農業"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngBookguiGui.ButtonPressedMessage(10, x, y, z));
				SiongSngBookguiGui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 257, this.guiTop + 84, 41, 20, new StringTextComponent("其他"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngBookguiGui.ButtonPressedMessage(11, x, y, z));
				SiongSngBookguiGui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 212, this.guiTop + 84, 41, 20, new StringTextComponent("NPC"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new SiongSngBookguiGui.ButtonPressedMessage(12, x, y, z));
				SiongSngBookguiGui.handleButtonAction(entity, 12, x, y, z);
			}
		}));
	}
}
