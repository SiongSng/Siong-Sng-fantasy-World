
package siongsng.fantasy_world.item;

import siongsng.fantasy_world.itemgroup.SiongSngWorldToolsandweaponsItemGroup;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class CopperSwordItem extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:copper_sword")
	public static final Item block = null;
	public CopperSwordItem(SiongsngsFantasyWorldModElements instance) {
		super(instance, 97);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 660;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 10f;
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
		}, 3, -3f, new Item.Properties().group(SiongSngWorldToolsandweaponsItemGroup.tab)) {
		}.setRegistryName("copper_sword"));
	}
}
