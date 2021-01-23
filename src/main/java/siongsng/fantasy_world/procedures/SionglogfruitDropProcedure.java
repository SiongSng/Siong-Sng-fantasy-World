package siongsng.fantasy_world.procedures;

import siongsng.fantasy_world.item.SiongLogfruitItem;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;
import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.block.Blocks;

import java.util.Map;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SionglogfruitDropProcedure extends SiongsngsFantasyWorldModElements.ModElement {
	public SionglogfruitDropProcedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 158);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency x for procedure SionglogfruitDrop!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency y for procedure SionglogfruitDrop!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency z for procedure SionglogfruitDrop!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency world for procedure SionglogfruitDrop!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SiongLogfruitItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
