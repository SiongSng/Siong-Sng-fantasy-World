
package siong.sng.siongsngsworld.item;

import siong.sng.siongsngsworld.itemgroup.SiongSngIndustrialcomponentsItemGroup;
import siong.sng.siongsngsworld.SiongsngsFantasyWorldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class CopperplateItem extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:copperplate")
	public static final Item block = null;
	public CopperplateItem(SiongsngsFantasyWorldModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SiongSngIndustrialcomponentsItemGroup.tab).maxStackSize(32).rarity(Rarity.COMMON));
			setRegistryName("copperplate");
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
