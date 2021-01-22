
package siongsng.fantasy_world.item;

import siongsng.fantasy_world.itemgroup.SiongSngWorldToolsandweaponsItemGroup;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class AmethysAxeItem extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:amethys_axe")
	public static final Item block = null;
	public AmethysAxeItem(SiongsngsFantasyWorldModElements instance) {
		super(instance, 107);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 902;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 18f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 35;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(AmethystcrystallizationItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(SiongSngWorldToolsandweaponsItemGroup.tab)) {
		}.setRegistryName("amethys_axe"));
	}
}
