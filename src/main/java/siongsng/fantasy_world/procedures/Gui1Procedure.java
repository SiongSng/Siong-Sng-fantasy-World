package siongsng.fantasy_world.procedures;

import siongsng.fantasy_world.item.IronplateItem;
import siongsng.fantasy_world.item.CopperplateItem;
import siongsng.fantasy_world.item.CopperparticleItem;
import siongsng.fantasy_world.item.CopperingotItem;
import siongsng.fantasy_world.block.IronplatemakingmachineBlock;
import siongsng.fantasy_world.block.CooperplatepressBlock;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;
import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class Gui1Procedure extends SiongsngsFantasyWorldModElements.ModElement {
	public Gui1Procedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 24);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency entity for procedure Gui1!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency x for procedure Gui1!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency y for procedure Gui1!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency z for procedure Gui1!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency world for procedure Gui1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double previousRecipe = 0;
		double wait_time = 0;
		boolean wait = false;
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == IronplatemakingmachineBlock.block.getDefaultState()
				.getBlock())) {
			entity.getPersistentData().putDouble("wait_time", 60);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CooperplatepressBlock.block.getDefaultState()
				.getBlock())) {
			entity.getPersistentData().putDouble("wait_time", 20);
		}
		if ((((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (1))).getItem() == new ItemStack(CopperingotItem.block, (int) (1)).getItem())
				&& (((entity.getPersistentData().getBoolean("wait")) == (false)) && ((new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
									if (stack != null)
										return stack.getCount();
								}
							}
						}
						return 0;
					}
				}.getAmount((int) (1))) >= 2)))) {
			entity.getPersistentData().putBoolean("wait", (true));
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							((Slot) ((Map) invobj).get((int) (1))).decrStackSize((int) (2));
							_current.detectAndSendChanges();
						}
					}
				}
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;
				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(CopperplateItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (2))) + 1));
								((Slot) ((Map) invobj).get((int) (2))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(CopperparticleItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (3))) + 1));
								((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					entity.getPersistentData().putBoolean("wait", (false));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) (entity.getPersistentData().getDouble("wait_time")));
		} else if ((((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (1))).getItem() == new ItemStack(Items.IRON_INGOT, (int) (1)).getItem())
				&& (((entity.getPersistentData().getBoolean("wait")) == (false)) && ((new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
									if (stack != null)
										return stack.getCount();
								}
							}
						}
						return 0;
					}
				}.getAmount((int) (1))) >= 2)))) {
			entity.getPersistentData().putBoolean("wait", (true));
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							((Slot) ((Map) invobj).get((int) (1))).decrStackSize((int) (2));
							_current.detectAndSendChanges();
						}
					}
				}
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;
				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(IronplateItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (2))) + 1));
								((Slot) ((Map) invobj).get((int) (2))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Items.IRON_NUGGET, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (3))) + 1));
								((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					entity.getPersistentData().putBoolean("wait", (false));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) (entity.getPersistentData().getDouble("wait_time")));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u89F8\u767C!!!"), (true));
		}
		if (((entity.getPersistentData().getBoolean("wait")) == (true))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u958B\u59CB\u58D3\u5236"), (true));
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;
				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					entity.getPersistentData().putDouble("timer1", ((entity.getPersistentData().getDouble("timer1")) + 1));
					entity.getPersistentData().putDouble("timer2",
							((entity.getPersistentData().getDouble("wait_time")) / (entity.getPersistentData().getDouble("timer1"))));
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								(((entity.getPersistentData().getDouble("timer2"))) + "" + ((entity.getPersistentData().getDouble("timer1"))))),
								(true));
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 1);
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
