package siongsng.fantasy_world.procedures;

import siongsng.fantasy_world.item.AmethystingotItem;
import siongsng.fantasy_world.item.AmethystdustItem;
import siongsng.fantasy_world.SiongsngsFantasyWorldModVariables;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;
import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class Amethystdustcollectionbag_Right_clickProcedure extends SiongsngsFantasyWorldModElements.ModElement {
	public Amethystdustcollectionbag_Right_clickProcedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 195);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency entity for procedure Amethystdustcollectionbag_Right_click!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double test = 0;
		if ((((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).amethyst_dust) <= 63)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(AmethystdustItem.block, (int) (1));
				_setstack.setCount((int) ((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).amethyst_dust));
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.amethyst_dust = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.isSneaking())) {
			if ((((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).amethyst_dust) >= 9)) {
				if ((Math.round((((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).amethyst_dust) / 9)) <= 64)) {
					test = (double) Math.round((((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).amethyst_dust) / 9));
				} else {
					test = (double) 64;
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(AmethystingotItem.block, (int) (1));
					_setstack.setCount((int) (test));
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					double _setval = (double) (((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).amethyst_dust) - ((test) * 9));
					entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.amethyst_dust = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(AmethystdustItem.block, (int) (1));
				_setstack.setCount((int) 64);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = (double) (((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).amethyst_dust) - 64);
				entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.amethyst_dust = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
