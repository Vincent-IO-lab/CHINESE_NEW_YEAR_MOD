package com.besson.tutorialmod.entity.client;

import com.besson.tutorialmod.entity.animation.TigerAnimation;
import com.besson.tutorialmod.entity.custom.TigerEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.12.0
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class TigerModel<T extends TigerEntity> extends SinglePartEntityModel<T> {
	private final ModelPart tiger;
//	private final ModelPart right_front;
//	private final ModelPart left_back;
//	private final ModelPart left_front;
//	private final ModelPart left_middle;
//	private final ModelPart right_middle;
//	private final ModelPart body;
//	private final ModelPart tail;
	private final ModelPart head;
//	private final ModelPart left_wing;
//	private final ModelPart right_wing;
//	private final ModelPart right_back;
	public TigerModel(ModelPart root) {
		this.tiger = root.getChild("tiger");
//		this.right_front = this.tiger.getChild("right_front");
//		this.left_back = this.tiger.getChild("left_back");
//		this.left_front = this.tiger.getChild("left_front");
//		this.left_middle = this.tiger.getChild("left_middle");
//		this.right_middle = this.tiger.getChild("right_middle");
//		this.body = this.tiger.getChild("body");
//		this.tail = this.tiger.getChild("tail");
		this.head = tiger.getChild("head");
//		this.left_wing = this.tiger.getChild("left_wing");
//		this.right_wing = this.tiger.getChild("right_wing");
//		this.right_back = this.tiger.getChild("right_back");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData tiger = modelPartData.addChild("tiger", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData right_front = tiger.addChild("right_front", ModelPartBuilder.create().uv(14, 33).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, -6.0F, -3.0F));

		ModelPartData left_back = tiger.addChild("left_back", ModelPartBuilder.create().uv(30, 39).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(7.0F, -6.0F, 3.0F));

		ModelPartData left_front = tiger.addChild("left_front", ModelPartBuilder.create().uv(38, 39).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, -6.0F, 3.0F));

		ModelPartData left_middle = tiger.addChild("left_middle", ModelPartBuilder.create().uv(0, 41).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 3.0F));

		ModelPartData right_middle = tiger.addChild("right_middle", ModelPartBuilder.create().uv(8, 41).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, -3.0F));

		ModelPartData body = tiger.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-23.0F, -7.0F, -3.0F, 10.0F, 7.0F, 6.0F, new Dilation(0.0F))
				.uv(28, 13).cuboid(-13.0F, -6.0F, -2.0F, 5.0F, 6.0F, 4.0F, new Dilation(0.0F))
				.uv(28, 23).cuboid(-8.0F, -4.0F, -2.0F, 5.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(15.0F, -5.0F, 0.0F));

		ModelPartData tail = tiger.addChild("tail", ModelPartBuilder.create().uv(32, 8).cuboid(1.0F, -3.0F, -2.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(11.0F, -5.0F, 1.0F));

		ModelPartData head = tiger.addChild("head", ModelPartBuilder.create().uv(44, 31).cuboid(-1.0F, -12.0F, -6.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F))
				.uv(46, 16).cuboid(-1.0F, -3.0F, -4.0F, 2.0F, 2.0F, 2.0F, new Dilation(3.0F))
				.uv(22, 33).cuboid(-5.0F, -5.0F, -2.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(22, 37).cuboid(-6.0F, -4.0F, -2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(16, 45).cuboid(-6.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(16, 41).cuboid(-5.0F, -5.0F, -6.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 33).cuboid(-5.0F, -1.0F, -6.0F, 1.0F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(32, 0).cuboid(-3.0F, -6.0F, -9.0F, 6.0F, 6.0F, 2.0F, new Dilation(0.0F))
				.uv(46, 8).cuboid(-1.0F, -12.0F, -2.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 31).cuboid(-3.0F, -6.0F, 1.0F, 6.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-10.0F, -12.0F, 3.0F));

		ModelPartData left_wing = tiger.addChild("left_wing", ModelPartBuilder.create().uv(0, 13).cuboid(-5.0F, -2.0F, 3.0F, 6.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.0F, 0.0F));

		ModelPartData right_wing = tiger.addChild("right_wing", ModelPartBuilder.create().uv(0, 23).cuboid(-5.0F, -2.0F, -12.0F, 6.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.0F, 1.0F));

		ModelPartData right_back = tiger.addChild("right_back", ModelPartBuilder.create().uv(22, 39).cuboid(6.0F, -6.0F, -4.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		tiger.render(matrices, vertexConsumer, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return this.tiger;
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);
		this.head.yaw = headYaw * 0.017453292f;
		this.head.pitch = headPitch * 0.017453292f;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);

		this.animateMovement(TigerAnimation.WALK, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(TigerEntity.idleAnimation, TigerAnimation.IDLE, animationProgress, 1f);
		this.updateAnimation(TigerEntity.attackAnimation, TigerAnimation.ATTACK, animationProgress, 1f);
	}
}