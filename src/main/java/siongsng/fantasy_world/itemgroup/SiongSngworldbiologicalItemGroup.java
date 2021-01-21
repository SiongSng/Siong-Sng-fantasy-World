
package siongsng.fantasy_world.itemgroup;

import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SiongSngworldbiologicalItemGroup extends SiongsngsFantasyWorldModElements.ModElement {
	public SiongSngworldbiologicalItemGroup(SiongsngsFantasyWorldModElements instance) {
		super(instance, 89);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsiong_sngworldbiological") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.FOX_SPAWN_EGG, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
