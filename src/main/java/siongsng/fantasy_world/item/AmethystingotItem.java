
package siongsng.fantasy_world.item;

import siongsng.fantasy_world.itemgroup.SiongSngOreItemGroup;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class AmethystingotItem extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:amethystingot")
	public static final Item block = null;
	public AmethystingotItem(SiongsngsFantasyWorldModElements instance) {
		super(instance, 190);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SiongSngOreItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("amethystingot");
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
