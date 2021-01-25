
package siongsng.fantasy_world.item;

import siongsng.fantasy_world.procedures.ScrollofElementaryExperiencePoints_openProcedure;
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
public class ScrollofElementaryExperiencePointsItem extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:scrollof_elementary_experience_points")
	public static final Item block = null;
	public ScrollofElementaryExperiencePointsItem(SiongsngsFantasyWorldModElements instance) {
		super(instance, 202);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(PrizeItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("scrollof_elementary_experience_points");
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
			list.add(new StringTextComponent("\u00A7b\u4F7F\u7528\u4E4B\u5F8C\u53EF\u7372\u53D6200\u9EDE\u7D93\u9A57\u503C\u3002"));
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
				ScrollofElementaryExperiencePoints_openProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}
