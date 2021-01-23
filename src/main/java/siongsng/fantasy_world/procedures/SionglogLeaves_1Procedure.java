package siongsng.fantasy_world.procedures;

import siongsng.fantasy_world.item.SiongSaplingitemItem;
import siongsng.fantasy_world.item.RedwoodsaplingitemItem;
import siongsng.fantasy_world.block.Siong_logLeavesBlock;
import siongsng.fantasy_world.block.RedwoodLeavesBlock;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;
import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SionglogLeaves_1Procedure extends SiongsngsFantasyWorldModElements.ModElement {
	public SionglogLeaves_1Procedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 93);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency x for procedure SionglogLeaves_1!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency y for procedure SionglogLeaves_1!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency z for procedure SionglogLeaves_1!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency world for procedure SionglogLeaves_1!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Siong_logLeavesBlock.block.getDefaultState().getBlock())) {
			if ((Math.random() < 0.4)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SiongSaplingitemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == RedwoodLeavesBlock.block.getDefaultState().getBlock())) {
			if ((Math.random() < 0.4)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(RedwoodsaplingitemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		Entity entity = event.getPlayer();
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("xpAmount", event.getExpToDrop());
		dependencies.put("x", event.getPos().getX());
		dependencies.put("y", event.getPos().getY());
		dependencies.put("z", event.getPos().getZ());
		dependencies.put("px", entity.getPosX());
		dependencies.put("py", entity.getPosY());
		dependencies.put("pz", entity.getPosZ());
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
