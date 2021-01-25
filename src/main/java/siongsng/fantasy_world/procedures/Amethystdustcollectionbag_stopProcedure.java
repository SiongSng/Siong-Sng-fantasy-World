package siongsng.fantasy_world.procedures;

import siongsng.fantasy_world.SiongsngsFantasyWorldModVariables;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;
import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraft.entity.Entity;

import java.util.Map;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class Amethystdustcollectionbag_stopProcedure extends SiongsngsFantasyWorldModElements.ModElement {
	public Amethystdustcollectionbag_stopProcedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 196);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency entity for procedure Amethystdustcollectionbag_stop!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (boolean) (false);
			entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.amethyst_dust_tf = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
