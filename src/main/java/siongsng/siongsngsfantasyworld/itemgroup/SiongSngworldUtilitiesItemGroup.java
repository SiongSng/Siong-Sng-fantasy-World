
package siongsng.siongsngsfantasyworld.itemgroup;

import siongsng.siongsngsfantasyworld.item.CopperbackpackItem;
import siongsng.siongsngsfantasyworld.SiongsngsFantasyWorldModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SiongSngworldUtilitiesItemGroup extends SiongsngsFantasyWorldModElements.ModElement {
	public SiongSngworldUtilitiesItemGroup(SiongsngsFantasyWorldModElements instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsiong_sngworld_utilities") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CopperbackpackItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
