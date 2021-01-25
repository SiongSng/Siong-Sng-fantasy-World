package siongsng.fantasy_world.procedures;

import siongsng.fantasy_world.SiongsngsFantasyWorldModVariables;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;
import siongsng.fantasy_world.SiongsngsFantasyWorldMod;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import java.util.Map;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class Amethyst_dust_Pick_upProcedure extends SiongsngsFantasyWorldModElements.ModElement {
	public Amethyst_dust_Pick_upProcedure(SiongsngsFantasyWorldModElements instance) {
		super(instance, 194);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency entity for procedure Amethyst_dust_Pick_up!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				SiongsngsFantasyWorldMod.LOGGER.warn("Failed to load dependency itemstack for procedure Amethyst_dust_Pick_up!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		{
			boolean _setval = (boolean) (true);
			entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.amethyst_dust_tf = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		((itemstack)).setDisplayName(new StringTextComponent((("\u7D2B\u6676\u7C89\u8490\u96C6\u5E36-\u76EE\u524D\u5171\u6709") + ""
				+ (((entity.getCapability(SiongsngsFantasyWorldModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SiongsngsFantasyWorldModVariables.PlayerVariables())).amethyst_dust)))));
	}
}
