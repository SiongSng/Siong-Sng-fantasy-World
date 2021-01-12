
package net.mcreator.siongsngsworld.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.siongsngsworld.itemgroup.SiongSngworldfoodItemGroup;
import net.mcreator.siongsngsworld.SiongsngsWorldModElements;

import java.util.List;

@SiongsngsWorldModElements.ModElement.Tag
public class StonesteakItem extends SiongsngsWorldModElements.ModElement {
	@ObjectHolder("siongsngs_world:stonesteak")
	public static final Item block = null;
	public StonesteakItem(SiongsngsWorldModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(SiongSngworldfoodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.2f).setAlwaysEdible().meat().build()));
			setRegistryName("stonesteak");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u4E0D\u4EFF\u5403\u5403\u770B?  \u53EF\u80FD\u6703\u611F\u89BA\u6709\u9EDE\u786C!!"));
		}
	}
}
