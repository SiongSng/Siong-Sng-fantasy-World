
package siongsng.fantasy_world.itemgroup;

import siongsng.fantasy_world.item.AmethyArmorItem;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SiongSngWorldequipmentItemGroup extends SiongsngsFantasyWorldModElements.ModElement {
	public SiongSngWorldequipmentItemGroup(SiongsngsFantasyWorldModElements instance) {
		super(instance, 121);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsiong_sng_worldequipment") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AmethyArmorItem.helmet, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
