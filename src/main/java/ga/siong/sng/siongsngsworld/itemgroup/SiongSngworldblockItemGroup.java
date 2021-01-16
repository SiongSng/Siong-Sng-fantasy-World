
package ga.siong.sng.siongsngsworld.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import ga.siong.sng.siongsngsworld.SiongsngsWorldModElements;

@SiongsngsWorldModElements.ModElement.Tag
public class SiongSngworldblockItemGroup extends SiongsngsWorldModElements.ModElement {
	public SiongSngworldblockItemGroup(SiongsngsWorldModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsiong_sngworldblock") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.SMOOTH_QUARTZ, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
