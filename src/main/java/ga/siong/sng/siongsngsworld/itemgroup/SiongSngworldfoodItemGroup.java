
package ga.siong.sng.siongsngsworld.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import ga.siong.sng.siongsngsworld.SiongsngsWorldModElements;

@SiongsngsWorldModElements.ModElement.Tag
public class SiongSngworldfoodItemGroup extends SiongsngsWorldModElements.ModElement {
	public SiongSngworldfoodItemGroup(SiongsngsWorldModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsiong_sngworldfood") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.CARROT, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
