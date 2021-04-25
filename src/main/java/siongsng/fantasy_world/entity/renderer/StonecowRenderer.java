package siongsng.fantasy_world.entity.renderer;

import siongsng.fantasy_world.entity.StonecowEntity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.client.renderer.entity.MobRenderer;

@OnlyIn(Dist.CLIENT)
public class StonecowRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(StonecowEntity.entity,
					renderManager -> new MobRenderer(renderManager, new CowModel(), 0.5f) {
						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("siongsngs_fantasy_world:textures/stone_cow.png");
						}
					});
		}
	}
}
