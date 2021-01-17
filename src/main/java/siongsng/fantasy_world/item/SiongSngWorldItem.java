
package siongsng.fantasy_world.item;

import siongsng.fantasy_world.world.dimension.SiongSngWorldDimension;
import siongsng.fantasy_world.itemgroup.UtilityItemGroup;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;

public class SiongSngWorldItem extends Item {
	@ObjectHolder("siongsngs_fantasy_world:siong_sng_world")
	public static final Item block = null;
	public SiongSngWorldItem() {
		super(new Item.Properties().group(UtilityItemGroup.tab).maxDamage(64));
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity entity = context.getPlayer();
		BlockPos pos = context.getPos().offset(context.getFace());
		ItemStack itemstack = context.getItem();
		World world = context.getWorld();
		if (!entity.canPlayerEdit(pos, context.getFace(), itemstack)) {
			return ActionResultType.FAIL;
		} else {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (world.isAirBlock(pos) && true)
				SiongSngWorldDimension.portal.portalSpawn(world, pos);
			itemstack.damageItem(1, entity, c -> c.sendBreakAnimation(context.getHand()));
			return ActionResultType.SUCCESS;
		}
	}
}
