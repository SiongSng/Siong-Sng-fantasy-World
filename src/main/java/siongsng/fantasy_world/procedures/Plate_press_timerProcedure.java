package siongsng.fantasy_world.procedures;

import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;
import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class Plate_press_timerProcedure extends SiongsngsFantasyWorldModElements.ModElement {
	public Plate_press_timerProcedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 183);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency entity for procedure Plate_press_timer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u89F8\u767C!!!"), (true));
		}
		if (((entity.getPersistentData().getBoolean("wait")) == (true))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u958B\u59CB\u58D3\u5236"), (true));
			}
			entity.getPersistentData().putDouble("timer1", ((entity.getPersistentData().getDouble("timer1")) + 1));
			entity.getPersistentData().putDouble("timer2",
					((entity.getPersistentData().getDouble("wait_time")) / (entity.getPersistentData().getDouble("timer1"))));
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent(
								(((entity.getPersistentData().getDouble("timer2"))) + "" + ((entity.getPersistentData().getDouble("timer1"))))),
						(true));
			}
			if (((entity.getPersistentData().getBoolean("wait")) == (false))) {
				entity.getPersistentData().putDouble("timer1", 0);
				entity.getPersistentData().putDouble("timer2", 0);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u5B8C\u6210\u58D3\u5236"), (true));
				}
			}
		}
	}
}
