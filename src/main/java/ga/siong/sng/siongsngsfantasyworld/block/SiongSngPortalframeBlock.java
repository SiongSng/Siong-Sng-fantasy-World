
package ga.siong.sng.siongsngsfantasyworld.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.Minecraft;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.Random;
import java.util.List;
import java.util.Collections;

import ga.siong.sng.siongsngsfantasyworld.particle.BlueflameParticle;
import ga.siong.sng.siongsngsfantasyworld.itemgroup.SiongSngworldblockItemGroup;
import ga.siong.sng.siongsngsfantasyworld.SiongsngsFantasyWorldModElements;

@SiongsngsFantasyWorldModElements.ModElement.Tag
public class SiongSngPortalframeBlock extends SiongsngsFantasyWorldModElements.ModElement {
	@ObjectHolder("siongsngs_fantasy_world:siong_sng_portalframe")
	public static final Block block = null;
	public SiongSngPortalframeBlock(SiongsngsFantasyWorldModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(SiongSngworldblockItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(4f, 20f).setLightLevel(s -> 0).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("siong_sng_portalframe");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void addInformation(ItemStack itemstack, IBlockReader world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent(
					"\u00A7b\u5C07\u6B64\u65B9\u584A\u4F7F\u7528\u985E\u4F3C\u5730\u7344\u9580\u7684\u84CB\u6CD5\uFF0C\u5373\u53EF\u84CB\u51FA\u3010\u83D8\u83D8\u7684\u5E7B\u60F3\u4E16\u754C-\u50B3\u9001\u9580\u3011\uFF0C\u518D\u4F7F\u7528\u50B3\u9001\u9580\u6FC0\u6D3B\u5DE5\u5177\uFF0C\u4F86\u958B\u555F\u6B64\u50B3\u9001\u9580\u3002"));
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
			super.animateTick(state, world, pos, random);
			PlayerEntity entity = Minecraft.getInstance().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (true)
				for (int l = 0; l < 8; ++l) {
					double d0 = (x + random.nextFloat());
					double d1 = (y + random.nextFloat());
					double d2 = (z + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 0.5D;
					double d4 = (random.nextFloat() - 0.5D) * 0.5D;
					double d5 = (random.nextFloat() - 0.5D) * 0.5D;
					world.addParticle(BlueflameParticle.particle, d0, d1, d2, d3, d4, d5);
				}
		}
	}
}
