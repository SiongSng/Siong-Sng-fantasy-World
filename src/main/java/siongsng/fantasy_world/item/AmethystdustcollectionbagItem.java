
package siongsng.fantasy_world.item;

import siongsng.fantasy_world.procedures.Amethystdustcollectionbag_stopProcedure;
import siongsng.fantasy_world.procedures.Amethystdustcollectionbag_Right_clickProcedure;
import siongsng.fantasy_world.procedures.Amethyst_dust_Pick_upProcedure;
import siongsng.fantasy_world.itemgroup.UtilityItemGroup;
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
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class AmethystdustcollectionbagItem extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:amethystdustcollectionbag")
	public static final Item block = null;
	public AmethystdustcollectionbagItem(SiongsngsFantasyWorldModElements instance) {
		super(instance, 193);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(UtilityItemGroup.tab).maxStackSize(64).rarity(Rarity.RARE));
			setRegistryName("amethystdustcollectionbag");
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
					"\u00A7b\u53F3\u9375\u53EF\u4EE5\u53D6\u51FA\u4E00\u7D44\u7D2B\u6676\u7C89\uFF0CShift(\u8E72\u4E0B)+\u53F3\u9375\u53EF\u4EE5\u53D6\u51FA\u7D2B\u6676\u9320\u3002"));
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
				Amethystdustcollectionbag_Right_clickProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}

		@Override
		public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entity, int time) {
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				Amethystdustcollectionbag_stopProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				Amethyst_dust_Pick_upProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean onDroppedByPlayer(ItemStack itemstack, PlayerEntity entity) {
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				Amethystdustcollectionbag_stopProcedure.executeProcedure($_dependencies);
			}
			return true;
		}
	}
}
