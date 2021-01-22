
package siongsng.fantasy_world.itemgroup;

import siongsng.fantasy_world.item.CopperPickaxeItem;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SiongSngWorldToolsandweaponsItemGroup extends SiongsngsFantasyWorldModElements.ModElement {
	public SiongSngWorldToolsandweaponsItemGroup(SiongsngsFantasyWorldModElements instance) {
		super(instance, 105);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsiong_sng_world_toolsandweapons") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CopperPickaxeItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
