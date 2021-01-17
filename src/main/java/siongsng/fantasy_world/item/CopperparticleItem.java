
package siongsng.fantasy_world.item;

import siongsng.fantasy_world.itemgroup.SiongSngOreItemGroup;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

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

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class CopperparticleItem extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:copperparticle")
	public static final Item block = null;
	public CopperparticleItem(SiongsngsFantasyWorldModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SiongSngOreItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("copperparticle");
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
					"\u00A7b\u53EF\u4EE5\u4F7F\u7528\u9285\u9320\u5206\u89E3\u800C\u6210\u3002 \u00A76\u5C08\u9580\u7528\u65BC\u88FD\u4F5C\u5C0F\u90E8\u4EF6\u3002"));
		}
	}
}
