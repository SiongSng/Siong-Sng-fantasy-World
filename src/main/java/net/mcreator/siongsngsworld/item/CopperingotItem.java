
package net.mcreator.siongsngsworld.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.siongsngsworld.itemgroup.SiongSngOreItemGroup;
import net.mcreator.siongsngsworld.SiongsngsWorldModElements;

import java.util.List;

@SiongsngsWorldModElements.ModElement.Tag
public class CopperingotItem extends SiongsngsWorldModElements.ModElement {
	@ObjectHolder("siongsngs_world:copperingot")
	public static final Item block = null;
	public CopperingotItem(SiongsngsWorldModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SiongSngOreItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("copperingot");
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
			list.add(new StringTextComponent(
					"\u00A7b\u4F7F\u7528\u9285\u7926\u71D2\u88FD\u800C\u6210\u7684\u91D1\u5C6C\uFF0C\u88AB\u5EE3\u6CDB\u4F7F\u7528\uFF0C\u53EF\u4EE5\u505A\u51FA\u8A31\u591A\u7269\u54C1\u3002"));
		}
	}
}
