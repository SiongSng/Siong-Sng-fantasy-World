
package siongsng.fantasy_world.item;

import siongsng.fantasy_world.itemgroup.SiongSngWorldToolsandweaponsItemGroup;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class CopperPickaxeItem extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:copper_pickaxe")
	public static final Item block = null;
	public CopperPickaxeItem(SiongsngsFantasyWorldModElements instance) {
		super(instance, 95);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
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
				return 4;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CopperingotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(SiongSngWorldToolsandweaponsItemGroup.tab)) {
		}.setRegistryName("copper_pickaxe"));
	}
}
