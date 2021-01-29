
package siongsng.fantasy_world.itemgroup;

import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SiongSngworldliquidItemGroup extends SiongsngsFantasyWorldModElements.ModElement {
	public SiongSngworldliquidItemGroup(SiongsngsFantasyWorldModElements instance) {
		super(instance, 231);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsiong_sngworldliquid") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.BUCKET, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
