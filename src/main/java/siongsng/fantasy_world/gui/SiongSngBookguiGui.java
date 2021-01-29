
package siongsng.fantasy_world.gui;

import siongsng.fantasy_world.procedures.SiongSngbookaboutrunProcedure;
import siongsng.fantasy_world.procedures.SiongBookgui1runProcedure;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;
import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.matrix.MatrixStack;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SiongSngBookguiGui extends SiongsngsFantasyWorldModElements.ModElement {
	public static HashMap guistate = new HashMap();
	private static ContainerType<GuiContainerMod> containerType = null;
	public SiongSngBookguiGui(SiongsngsFantasyWorldModElements instance) {
		super(instance, 51);
		elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
				ButtonPressedMessage::handler);
		elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
				GUISlotChangedMessage::handler);
		containerType = new ContainerType<>(new GuiContainerModFactory());
		FMLJavaModLoadingContext.get().getModEventBus().register(new ContainerRegisterHandler());
	}
	private static class ContainerRegisterHandler {
		@SubscribeEvent
		public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
			event.getRegistry().register(containerType.setRegistryName("siong_sng_bookgui"));
		}
	}
	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, GuiWindow::new));
	}
	public static class GuiContainerModFactory implements IContainerFactory {
		public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
			return new GuiContainerMod(id, inv, extraData);
		}
	}

	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private World world;
		private PlayerEntity entity;
		private int x, y, z;
		private IItemHandler internal;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		private boolean bound = false;
		public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
			super(containerType, id);
			this.entity = inv.player;
			this.world = inv.player.world;
			this.internal = new ItemStackHandler(0);
			BlockPos pos = null;
			if (extraData != null) {
				pos = extraData.readBlockPos();
				this.x = pos.getX();
				this.y = pos.getY();
				this.z = pos.getZ();
			}
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(PlayerEntity player) {
			return true;
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class GuiWindow extends ContainerScreen<GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		public GuiWindow(GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float par1, int par2, int par3) {
			GL11.glColor4f(1, 1, 1, 1);
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
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(0, x, y, z));
				handleButtonAction(entity, 0, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 167, this.guiTop + 12, 41, 20, new StringTextComponent("故事"), e -> {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(1, x, y, z));
				handleButtonAction(entity, 1, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 167, this.guiTop + 48, 41, 20, new StringTextComponent("礦物"), e -> {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(2, x, y, z));
				handleButtonAction(entity, 2, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 212, this.guiTop + 48, 41, 20, new StringTextComponent("武器"), e -> {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(3, x, y, z));
				handleButtonAction(entity, 3, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 302, this.guiTop + 12, 63, 20, new StringTextComponent("怪物/Boss"), e -> {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(4, x, y, z));
				handleButtonAction(entity, 4, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 257, this.guiTop + 48, 41, 20, new StringTextComponent("裝備"), e -> {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(5, x, y, z));
				handleButtonAction(entity, 5, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 212, this.guiTop + 12, 41, 20, new StringTextComponent("生態域"), e -> {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(6, x, y, z));
				handleButtonAction(entity, 6, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 257, this.guiTop + 12, 41, 20, new StringTextComponent("教學"), e -> {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(7, x, y, z));
				handleButtonAction(entity, 7, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 302, this.guiTop + 48, 63, 20, new StringTextComponent("特殊效果?"), e -> {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(8, x, y, z));
				handleButtonAction(entity, 8, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 302, this.guiTop + 84, 63, 20, new StringTextComponent("神秘知識?"), e -> {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(9, x, y, z));
				handleButtonAction(entity, 9, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 167, this.guiTop + 84, 41, 20, new StringTextComponent("農業"), e -> {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(10, x, y, z));
				handleButtonAction(entity, 10, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 257, this.guiTop + 84, 41, 20, new StringTextComponent("其他"), e -> {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(11, x, y, z));
				handleButtonAction(entity, 11, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 212, this.guiTop + 84, 41, 20, new StringTextComponent("NPC"), e -> {
				SiongsngsFantasyWorldMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(12, x, y, z));
				handleButtonAction(entity, 12, x, y, z);
			}));
		}
	}

	public static class ButtonPressedMessage {
		int buttonID, x, y, z;
		public ButtonPressedMessage(PacketBuffer buffer) {
			this.buttonID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
		}

		public ButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.buttonID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
		}

		public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}

	public static class GUISlotChangedMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		public GUISlotChangedMessage(PacketBuffer buffer) {
			this.slotID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
			this.changeType = buffer.readInt();
			this.meta = buffer.readInt();
		}

		public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.slotID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
			buffer.writeInt(message.changeType);
			buffer.writeInt(message.meta);
		}

		public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}
	private static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SiongSngbookaboutrunProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 1) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SiongBookgui1runProcedure.executeProcedure($_dependencies);
			}
		}
	}

	private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
