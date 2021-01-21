package siongsng.fantasy_world.procedures;

import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;
import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraft.entity.Entity;

import java.util.Map;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class Platen_press_timerProcedure extends SiongsngsFantasyWorldModElements.ModElement {
	public Platen_press_timerProcedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 79);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency entity for procedure Platen_press_timer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("timer2", ((entity.getPersistentData().getDouble("timer")) / 100));
		if (((entity.getPersistentData().getDouble("timer2")) >= 1)) {
			entity.getPersistentData().putDouble("timer2", 0);
		}
	}
}
