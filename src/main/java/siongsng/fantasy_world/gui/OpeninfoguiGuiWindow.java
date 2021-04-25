
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
public class OpeninfoguiGuiWindow extends ContainerScreen<OpeninfoguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public OpeninfoguiGuiWindow(OpeninfoguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 190;
		this.ySize = 198;
	}
	private static final ResourceLocation texture = new ResourceLocation("siongsngs_fantasy_world:textures/openinfogui.png");
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
		this.blit(ms, this.guiLeft + 34, this.guiTop + 2, 0, 0, 16, 16, 16, 16);
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
		this.font.drawString(ms, "\u83D8\u83D8\u7684\u5E7B\u60F3\u4E16\u754C-\u9078\u55AE", 51, 5, -12829636);
		this.font.drawString(ms, "\u6CE8\u610F:\u6B64\u9078\u55AE\u4ECD\u6709\u8A31\u591A\u529F\u80FD\u5C1A\u672A\u5BE6\u88DD", 30, 177, -12829636);
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
		this.addButton(new Button(this.guiLeft + 5, this.guiTop + 30, 57, 20, new StringTextComponent("玩家資訊"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new OpeninfoguiGui.ButtonPressedMessage(0, x, y, z));
				OpeninfoguiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 66, this.guiTop + 30, 57, 20, new StringTextComponent("時裝系統"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new OpeninfoguiGui.ButtonPressedMessage(1, x, y, z));
				OpeninfoguiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 127, this.guiTop + 30, 57, 20, new StringTextComponent("好友介面"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new OpeninfoguiGui.ButtonPressedMessage(2, x, y, z));
				OpeninfoguiGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 4, this.guiTop + 59, 57, 20, new StringTextComponent("任務系統"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new OpeninfoguiGui.ButtonPressedMessage(3, x, y, z));
				OpeninfoguiGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
