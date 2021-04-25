
package siongsng.fantasy_world.gui;

import siongsng.fantasy_world.SiongsngsFantasyWorldModVariables;
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
public class Openinfogui1GuiWindow extends ContainerScreen<Openinfogui1Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public Openinfogui1GuiWindow(Openinfogui1Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 190;
		this.ySize = 198;
	}
	private static final ResourceLocation texture = new ResourceLocation("siongsngs_fantasy_world:textures/openinfogui_1.png");
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
		this.blit(ms, this.guiLeft + 5, this.guiTop + 45, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("siongsngs_fantasy_world:textures/love_1.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 23, 0, 0, 19, 19, 19, 19);
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
		this.font.drawString(ms, "\u73A9\u5BB6\u8CC7\u8A0A", 71, 5, -12829636);
		this.font.drawString(ms, "" + ((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).coin) + "", 21, 48, -16777216);
		this.font.drawString(ms, "" + (entity.getPersistentData().getDouble("love")) + "", 21, 28, -16777216);
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
		this.addButton(new Button(this.guiLeft + 61, this.guiTop + 174, 73, 20, new StringTextComponent("回到選單首頁"), e -> {
			if (true) {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new Openinfogui1Gui.ButtonPressedMessage(0, x, y, z));
				Openinfogui1Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
