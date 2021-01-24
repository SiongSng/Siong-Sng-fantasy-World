package siongsng.fantasy_world.procedures;

import siongsng.fantasy_world.item.SiongSaplingitemItem;
import siongsng.fantasy_world.item.RedwoodsaplingitemItem;
import siongsng.fantasy_world.block.SngCultivatesoilBlock;
import siongsng.fantasy_world.block.SiongSaplingBlock;
import siongsng.fantasy_world.block.RedwoodsaplingBlock;
import siongsng.fantasy_world.block.IntermediateculturesoilBlock;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;
import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;

import java.util.Map;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SiongSapling_bookProcedure extends SiongsngsFantasyWorldModElements.ModElement {
	public SiongSapling_bookProcedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 129);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency entity for procedure SiongSapling_book!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency x for procedure SiongSapling_book!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency y for procedure SiongSapling_book!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency z for procedure SiongSapling_book!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency world for procedure SiongSapling_book!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean canSaplingBePlaced = false;
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
						.getBlock()))) {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.GRASS_BLOCK.getDefaultState().getBlock())) {
				canSaplingBePlaced = (boolean) (true);
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.MYCELIUM.getDefaultState().getBlock())) {
				canSaplingBePlaced = (boolean) (true);
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.DIRT.getDefaultState().getBlock())) {
				canSaplingBePlaced = (boolean) (true);
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.COARSE_DIRT.getDefaultState()
					.getBlock())) {
				canSaplingBePlaced = (boolean) (true);
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.PODZOL.getDefaultState().getBlock())) {
				canSaplingBePlaced = (boolean) (true);
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SngCultivatesoilBlock.block.getDefaultState()
					.getBlock())) {
				canSaplingBePlaced = (boolean) (true);
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == IntermediateculturesoilBlock.block
					.getDefaultState().getBlock())) {
				canSaplingBePlaced = (boolean) (true);
			} else {
				canSaplingBePlaced = (boolean) (false);
			}
			if (((canSaplingBePlaced) == (true))) {
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(SiongSaplingitemItem.block, (int) (1)).getItem())) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), SiongSaplingBlock.block.getDefaultState(), 3);
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = ((entity instanceof LivingEntity)
									? ((LivingEntity) entity).getHeldItemMainhand()
									: ItemStack.EMPTY);
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")),
								SoundCategory.NEUTRAL, (float) 1, (float) 0.8);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")),
								SoundCategory.NEUTRAL, (float) 1, (float) 0.8, false);
					}
				}
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(RedwoodsaplingitemItem.block, (int) (1)).getItem())) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), RedwoodsaplingBlock.block.getDefaultState(), 3);
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = ((entity instanceof LivingEntity)
									? ((LivingEntity) entity).getHeldItemMainhand()
									: ItemStack.EMPTY);
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")),
								SoundCategory.NEUTRAL, (float) 1, (float) 0.8);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")),
								SoundCategory.NEUTRAL, (float) 1, (float) 0.8, false);
					}
				}
			}
		}
	}
}
