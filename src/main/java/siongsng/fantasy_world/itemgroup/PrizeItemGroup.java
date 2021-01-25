
package siongsng.fantasy_world.itemgroup;

import siongsng.fantasy_world.item.BeginnersGiftsItem;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class PrizeItemGroup extends SiongsngsFantasyWorldModElements.ModElement {
	public PrizeItemGroup(SiongsngsFantasyWorldModElements instance) {
		super(instance, 202);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabprize") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BeginnersGiftsItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
