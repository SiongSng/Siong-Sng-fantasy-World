package siongsng.fantasy_world.procedures;

import siongsng.fantasy_world.item.AmethystdustItem;
import siongsng.fantasy_world.item.AmethystcrystallizationItem;
import siongsng.fantasy_world.SiongsngsFantasyWorldModVariables;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;
import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class CoinProcedure extends SiongsngsFantasyWorldModElements.ModElement {
	public CoinProcedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 80);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency entity for procedure Coin!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency itemstack for procedure Coin!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((itemstack).getItem() == new ItemStack(AmethystcrystallizationItem.block, (int) (1)).getItem())) {
			{
				double _setval = (double) (((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).coin) + (((itemstack)).getCount()));
				entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.coin = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			((itemstack)).setCount((int) 0);
		}
		if ((((itemstack).getItem() == new ItemStack(AmethystdustItem.block, (int) (1)).getItem())
				&& (((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).amethyst_dust_tf) == (true)))) {
			{
				double _setval = (double) (((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).amethyst_dust) + (((itemstack)).getCount()));
				entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.amethyst_dust = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			((itemstack)).setCount((int) 0);
		}
	}

	@SubscribeEvent
	public void onPickup(EntityItemPickupEvent event) {
		PlayerEntity entity = event.getPlayer();
		ItemStack itemstack = event.getItem().getItem();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		World world = entity.world;
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("itemstack", itemstack);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
