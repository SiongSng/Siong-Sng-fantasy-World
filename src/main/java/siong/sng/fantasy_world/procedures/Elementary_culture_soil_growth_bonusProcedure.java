package siong.sng.fantasy_world.procedures;

import siong.sng.fantasy_world.SiongsngsFantasyWorldModElements;
import siong.sng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BoneMealItem;

import java.util.Map;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class Elementary_culture_soil_growth_bonusProcedure extends SiongsngsFantasyWorldModElements.ModElement {
	public Elementary_culture_soil_growth_bonusProcedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 33);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency x for procedure Elementary_culture_soil_growth_bonus!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency y for procedure Elementary_culture_soil_growth_bonus!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency z for procedure Elementary_culture_soil_growth_bonus!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency world for procedure Elementary_culture_soil_growth_bonus!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld)
			((ServerWorld) world).setDayTime((int) ((world.getWorldInfo().getDayTime()) + 0.5));
		if (world instanceof World) {
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) (y + 1), (int) z))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) (y + 1), (int) z),
							(Direction) null)) {
				if (!world.isRemote())
					((World) world).playEvent(2005, new BlockPos((int) x, (int) (y + 1), (int) z), 0);
			}
		}
	}
}
