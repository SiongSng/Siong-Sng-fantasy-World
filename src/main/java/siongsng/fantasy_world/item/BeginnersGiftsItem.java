
package siongsng.fantasy_world.item;

import siongsng.fantasy_world.procedures.Beginnersgiftsgui_openProcedure;
import siongsng.fantasy_world.itemgroup.PrizeItemGroup;
import siongsng.fantasy_world.SiongsngsFantasyWorldModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class BeginnersGiftsItem extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:beginners_gifts")
	public static final Item block = null;
	public BeginnersGiftsItem(SiongsngsFantasyWorldModElements instance) {
		super(instance, 198);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(PrizeItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("beginners_gifts");
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
					"\u00A7b\u6B61\u8FCE\u60A8\u4F86\u5230\u83D8\u83D8\u7684\u5E7B\u60F3\u4E16\u754C\uFF0C\u9019\u662F\u83D8\u83D8\u9001\u7D66\u60A8\u7684\u79AE\u7269\uFF0C\u6536\u4E0B\u5427!!!"));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				Beginnersgiftsgui_openProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}
