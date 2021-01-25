
package siongsng.fantasy_world.item;

import siongsng.fantasy_world.itemgroup.SiongSngIndustrialcomponentsItemGroup;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class AmethystplateItem extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:amethystplate")
	public static final Item block = null;
	public AmethystplateItem(SiongsngsFantasyWorldModElements instance) {
		super(instance, 228);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SiongSngIndustrialcomponentsItemGroup.tab).maxStackSize(32).rarity(Rarity.COMMON));
			setRegistryName("amethystplate");
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
	}
}
