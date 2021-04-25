
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
public class Openinfogui2GuiWindow extends ContainerScreen<Openinfogui2Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public Openinfogui2GuiWindow(Openinfogui2Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 290;
		this.ySize = 232;
	}
	private static final ResourceLocation texture = new ResourceLocation("siongsngs_fantasy_world:textures/openinfogui_2.png");
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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("siongsngs_fantasy_world:textures/oak_planks.png"));
		this.blit(ms, this.guiLeft + 9, this.guiTop + 25, 0, 0, 16, 16, 16, 16);
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
		this.font.drawString(ms, "\u4EFB\u52D9\u7CFB\u7D71", 127, 4, -16777216);
		this.font.drawString(ms, "\u5F85\u5B8C\u6210\u4EFB\u52D9", 10, 5, -12829636);
		this.font.drawString(ms,
				"\u8AAA\u660E:\\n\u9EDE\u64CA\u5DE6\u5074\u908A\u7684\u6309\u9215\\n\u53EF\u4EE5\u67E5\u770B\u4EFB\u52D9\u5167\u5BB9\u548C\u5B8C\u6210\u5F8C\u7372\u5F97\u7684\u734E\u52F5\\n\\n\u52A0\u6CB9!! \u52AA\u529B\u5B8C\u6210\u4EFB\u52D9\u5427!!!!",
				138, 37, -12829636);
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
		this.addButton(new Button(this.guiLeft + 108, this.guiTop + 202, 73, 20, new StringTextComponent("回到選單首頁"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new Openinfogui2Gui.ButtonPressedMessage(0, x, y, z));
				Openinfogui2Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 28, this.guiTop + 24, 57, 20, new StringTextComponent("獲得木材"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new Openinfogui2Gui.ButtonPressedMessage(1, x, y, z));
				Openinfogui2Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
