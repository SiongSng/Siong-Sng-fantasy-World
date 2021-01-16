
package ga.siong.sng.siongsngsfantasyworld.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import java.util.List;

import ga.siong.sng.siongsngsfantasyworld.itemgroup.SiongSngIndustrialcomponentsItemGroup;
import ga.siong.sng.siongsngsfantasyworld.SiongsngsFantasyWorldModElements;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class CoppergearItem extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:coppergear")
	public static final Item block = null;
	public CoppergearItem(SiongsngsFantasyWorldModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SiongSngIndustrialcomponentsItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON));
			setRegistryName("coppergear");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u00A7b\u8A31\u591A\u6A5F\u5668\u90FD\u6703\u7528\u5230\u7684\u91CD\u8981\u96F6\u4EF6\u3002"));
		}
	}
}
