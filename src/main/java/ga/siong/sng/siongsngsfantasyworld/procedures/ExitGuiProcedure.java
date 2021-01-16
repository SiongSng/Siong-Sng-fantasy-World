package ga.siong.sng.siongsngsfantasyworld.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import ga.siong.sng.siongsngsfantasyworld.SiongsngsFantasyWorldModElements;
import ga.siong.sng.siongsngsfantasyworld.SiongsngsFantasyWorldMod;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class ExitGuiProcedure extends SiongsngsFantasyWorldModElements.ModElement {
	public ExitGuiProcedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 26);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency entity for procedure ExitGui!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
