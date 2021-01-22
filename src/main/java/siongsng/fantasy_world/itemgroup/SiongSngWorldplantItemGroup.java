
package siongsng.fantasy_world.itemgroup;

import siongsng.fantasy_world.item.SiongSaplingitemItem;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SiongSngWorldplantItemGroup extends SiongsngsFantasyWorldModElements.ModElement {
	public SiongSngWorldplantItemGroup(SiongsngsFantasyWorldModElements instance) {
		super(instance, 131);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsiong_sng_worldplant") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SiongSaplingitemItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
