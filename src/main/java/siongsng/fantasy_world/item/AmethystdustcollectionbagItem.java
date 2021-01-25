
package siongsng.fantasy_world.item;

import siongsng.fantasy_world.procedures.Amethyst_dust_Pick_upProcedure;
import siongsng.fantasy_world.itemgroup.UtilityItemGroup;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class AmethystdustcollectionbagItem extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:amethystdustcollectionbag")
	public static final Item block = null;
	public AmethystdustcollectionbagItem(SiongsngsFantasyWorldModElements instance) {
		super(instance, 193);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(UtilityItemGroup.tab).maxStackSize(64).rarity(Rarity.RARE));
			setRegistryName("amethystdustcollectionbag");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				Amethyst_dust_Pick_upProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
