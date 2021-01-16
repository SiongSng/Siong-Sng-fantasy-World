
package ga.siong.sng.siongsngsfantasyworld.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import ga.siong.sng.siongsngsfantasyworld.item.CoppergearItem;
import ga.siong.sng.siongsngsfantasyworld.SiongsngsFantasyWorldModElements;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SiongSngIndustrialcomponentsItemGroup extends SiongsngsFantasyWorldModElements.ModElement {
	public SiongSngIndustrialcomponentsItemGroup(SiongsngsFantasyWorldModElements instance) {
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
