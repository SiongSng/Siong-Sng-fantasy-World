
package siong.sng.fantasy_world.itemgroup;

import siong.sng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SiongSngworldblockItemGroup extends SiongsngsFantasyWorldModElements.ModElement {
	public SiongSngworldblockItemGroup(SiongsngsFantasyWorldModElements instance) {
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
