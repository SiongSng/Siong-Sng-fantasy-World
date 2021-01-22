
package siongsng.fantasy_world.item;

import siongsng.fantasy_world.itemgroup.SiongSngWorldToolsandweaponsItemGroup;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class CopperHoeItem extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:copper_hoe")
	public static final Item block = null;
	public CopperHoeItem(SiongsngsFantasyWorldModElements instance) {
		super(instance, 99);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 660;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CopperingotItem.block, (int) (1)));
			}
		}, 0, -3f, new Item.Properties().group(SiongSngWorldToolsandweaponsItemGroup.tab)) {
		}.setRegistryName("copper_hoe"));
	}
}
