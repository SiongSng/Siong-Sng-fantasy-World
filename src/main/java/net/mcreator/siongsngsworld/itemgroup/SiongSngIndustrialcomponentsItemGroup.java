
package net.mcreator.siongsngsworld.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.siongsngsworld.item.CoppergearItem;
import net.mcreator.siongsngsworld.SiongsngsWorldModElements;

@SiongsngsWorldModElements.ModElement.Tag
public class SiongSngIndustrialcomponentsItemGroup extends SiongsngsWorldModElements.ModElement {
	public SiongSngIndustrialcomponentsItemGroup(SiongsngsWorldModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsiong_sng_industrialcomponents") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CoppergearItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
