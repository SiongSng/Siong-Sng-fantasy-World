package siongsng.fantasy_world.procedures;

import siongsng.fantasy_world.item.BeginnersGiftsItem;
import siongsng.fantasy_world.SiongsngsFantasyWorldModVariables;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;
import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class JoinProcedure extends SiongsngsFantasyWorldModElements.ModElement {
	public JoinProcedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 44);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency entity for procedure Join!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency world for procedure Join!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).JOIN_TF) == (false))) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent((("\u00A7b\u6B61\u8FCE\u60A8 \u00A7c") + ""
							+ ((entity.getDisplayName().getString())) + ""
							+ (" \u00A76\u7B2C\u4E00\u6B21\u9032\u5165\u83D8\u83D8\u7684\u5E7B\u60F3\u4E16\u754C!!!") + ""
							+ ("\u9047\u5230\u4EFB\u4F55\u554F\u984C\u8A18\u5F97\u67E5\u770B\u3010\u83D8\u83D8\u7684\u5E7B\u60F3\u4E16\u754C\u8FAD\u5178\u3011\n")
							+ "" + ("\u6216\u8005\u5230\u5B98\u65B9Discord\u8A62\u554F(https://discord.gg/gjmazfF9Rj) \n") + ""
							+ ("\u60A8\u4E5F\u6703\u7372\u5F97\u3010\u521D\u5B78\u8005\u79AE\u7269\u3011\u8A18\u5F97\u9818\u53D6\u5594w       \u6A21\u7D44\u958B\u767C\u8005-\u83D8\u83D8 \u656C\u4E0A\u3002"))),
							ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(BeginnersGiftsItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.JOIN_TF = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).JOIN_TF)) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList()
							.func_232641_a_(
									new StringTextComponent((("\u00A7b\u6B61\u8FCE \u00A7c") + "" + ((entity.getDisplayName().getString())) + ""
											+ (" \u00A7b\u9032\u5165\u83D8\u83D8\u7684\u5E7B\u60F3\u4E16\u754C!!!"))),
									ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", entity.getPosX());
		dependencies.put("y", entity.getPosY());
		dependencies.put("z", entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
