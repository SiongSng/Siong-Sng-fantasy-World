
package ga.siong.sng.siongsngsfantasyworld.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import ga.siong.sng.siongsngsfantasyworld.SiongsngsFantasyWorldModElements;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SiongSngOreItemGroup extends SiongsngsFantasyWorldModElements.ModElement {
	public SiongSngOreItemGroup(SiongsngsFantasyWorldModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsiong_sng_ore") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.DIAMOND_ORE, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
