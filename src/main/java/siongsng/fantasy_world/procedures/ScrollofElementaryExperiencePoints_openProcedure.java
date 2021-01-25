package siongsng.fantasy_world.procedures;

import siongsng.fantasy_world.item.ScrollofElementaryExperiencePointsItem;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;
import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class ScrollofElementaryExperiencePoints_openProcedure extends SiongsngsFantasyWorldModElements.ModElement {
	public ScrollofElementaryExperiencePoints_openProcedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 203);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency entity for procedure ScrollofElementaryExperiencePoints_open!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).giveExperiencePoints((int) 200);
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(ScrollofElementaryExperiencePointsItem.block, (int) (1));
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
	}
}
