package net.eseption.prisonrealm.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class PrisonRealmModel<T extends Entity> extends EntityModel<T> {
	private final ModelPart body;
	private final ModelPart eye;

	public PrisonRealmModel(ModelPart root) {
		this.body = root.getChild("body");
		this.eye = root.getChild("eye");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition flesh = body.addOrReplaceChild("flesh", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -38.0F, -2.01F, 28.0F, 28.0F, 5.02F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition top_left_square = body.addOrReplaceChild("top_left_square", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = top_left_square.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(60, 65).addBox(-1.5F, -6.5F, -2.501F, 3.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.8551F, -33.9927F, 0.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r2 = top_left_square.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(33, 36).addBox(-6.0F, 1.5F, -2.499F, 14.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3425F, -42.2221F, 0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition tl_connector_r1 = top_left_square.addOrReplaceChild("tl_connector_r1", CubeListBuilder.create().texOffs(66, 18).addBox(-2.5F, -3.5F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.2879F, -38.4092F, 0.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition end_point_tl_r1 = top_left_square.addOrReplaceChild("end_point_tl_r1", CubeListBuilder.create().texOffs(0, 62).addBox(-3.0F, -3.0F, -3.5F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -42.0F, 0.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition top_right_square = body.addOrReplaceChild("top_right_square", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = top_right_square.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(26, 65).addBox(-3.5F, -7.0F, -2.501F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0105F, -32.5021F, 0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r4 = top_right_square.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 33).addBox(-8.0F, 1.5F, -2.499F, 14.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3425F, -42.2221F, 0.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition tr_connector_r1 = top_right_square.addOrReplaceChild("tr_connector_r1", CubeListBuilder.create().texOffs(71, 30).addBox(-2.5F, -4.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0657F, -38.0556F, 0.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition end_point_tr_r1 = top_right_square.addOrReplaceChild("end_point_tr_r1", CubeListBuilder.create().texOffs(26, 52).addBox(-3.0F, -3.0F, -3.5F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0F, -42.0F, 0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition bottom_left_square = body.addOrReplaceChild("bottom_left_square", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = bottom_left_square.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(66, 0).addBox(-0.5F, -6.5F, -2.499F, 3.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.779F, -14.61F, 0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r6 = bottom_left_square.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 41).addBox(-1.5F, -2.5F, -2.501F, 12.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.5F, -6.5F, 0.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition bl_connector_r1 = bottom_left_square.addOrReplaceChild("bl_connector_r1", CubeListBuilder.create().texOffs(76, 60).addBox(-2.5F, -3.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.9343F, -10.0556F, 0.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition end_point_bl_r1 = bottom_left_square.addOrReplaceChild("end_point_bl_r1", CubeListBuilder.create().texOffs(0, 49).addBox(-3.0F, -3.0F, -3.5F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -6.0F, 0.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition bottom_right_square = body.addOrReplaceChild("bottom_right_square", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = bottom_right_square.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(44, 65).addBox(-2.5F, -7.0F, -2.499F, 3.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0105F, -14.5021F, 0.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r8 = bottom_right_square.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(29, 44).addBox(-6.0F, -2.5F, -2.501F, 12.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3425F, -8.2221F, 0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition br_connector_r1 = bottom_right_square.addOrReplaceChild("br_connector_r1", CubeListBuilder.create().texOffs(0, 75).addBox(-2.5F, -3.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0657F, -10.0556F, 0.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition end_point_br_r1 = bottom_right_square.addOrReplaceChild("end_point_br_r1", CubeListBuilder.create().texOffs(52, 52).addBox(-3.0F, -3.0F, -3.5F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0F, -6.0F, 0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition eye = partdefinition.addOrReplaceChild("eye", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition nails = eye.addOrReplaceChild("nails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition nail_tl_r1 = nails.addOrReplaceChild("nail_tl_r1", CubeListBuilder.create().texOffs(0, 49).addBox(-4.6575F, -3.7221F, -1.15F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -29.0F, -3.55F, -0.3927F, 0.0F, -0.3927F));

		PartDefinition nail_tr_r1 = nails.addOrReplaceChild("nail_tr_r1", CubeListBuilder.create().texOffs(27, 53).addBox(3.6575F, -3.7221F, -1.15F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -29.0F, -3.55F, -0.3927F, 0.0F, 0.3927F));

		PartDefinition nail_br_r1 = nails.addOrReplaceChild("nail_br_r1", CubeListBuilder.create().texOffs(0, 62).addBox(3.6575F, -0.2779F, -1.15F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.0F, -3.55F, 0.3927F, 0.0F, -0.3927F));

		PartDefinition nail_bl_r1 = nails.addOrReplaceChild("nail_bl_r1", CubeListBuilder.create().texOffs(20, 75).addBox(-4.6575F, -0.2779F, -1.15F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.0F, -3.55F, 0.3927F, 0.0F, 0.3927F));

		PartDefinition eyelid = eye.addOrReplaceChild("eyelid", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r9 = eyelid.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(82, 3).addBox(9.0F, -0.1F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(82, 6).addBox(-2.8F, -0.1F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(55, 65).addBox(7.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(77, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -28.1721F, -3.1486F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r10 = eyelid.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(78, 57).addBox(10.8F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(80, 76).addBox(-1.2F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8F, -20.8025F, -3.3017F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r11 = eyelid.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(64, 31).addBox(7.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(39, 65).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -20.1721F, -3.1486F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r12 = eyelid.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(33, 33).addBox(-3.0F, -0.5F, -1.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.5F, -3.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r13 = eyelid.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(81, 16).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.1651F, -22.608F, -3.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r14 = eyelid.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(76, 78).addBox(-0.5F, -2.05F, -1.0F, 1.0F, 4.1F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.1842F, -25.9458F, -3.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r15 = eyelid.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(76, 72).addBox(-0.5F, -2.15F, -1.0F, 1.0F, 4.3F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.1301F, -25.8151F, -3.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r16 = eyelid.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(20, 81).addBox(-0.5F, -1.9F, -1.0F, 1.0F, 3.8F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.2192F, -22.4774F, -3.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r17 = eyelid.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(49, 33).addBox(-3.0F, -0.5F, -1.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.5F, -3.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition sclera = eye.addOrReplaceChild("sclera", CubeListBuilder.create().texOffs(71, 52).addBox(-5.0F, -26.0F, -4.001F, 10.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 65).addBox(-2.0F, -28.0F, -4.0001F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(61, 0).addBox(-2.0F, -22.0F, -4.0001F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(55, 52).addBox(4.9287F, -26.4005F, -3.999F, 1.0F, 4.8F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 34).addBox(-5.9713F, -26.3005F, -3.999F, 1.0F, 4.6F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(63, 44).addBox(-6.7F, -27.7F, -3.0F, 13.6F, 6.7F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r18 = sclera.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(82, 72).addBox(-1.3F, -1.7F, -0.3F, 1.8F, 3.4F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9916F, -24.0F, -3.1397F, 0.0F, -0.3927F, 0.0F));

		PartDefinition cube_r19 = sclera.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(82, 9).addBox(-0.9F, -1.7F, -0.5F, 1.9F, 3.4F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.6084F, -24.0F, -3.1397F, 0.0F, 0.3927F, 0.0F));

		PartDefinition cube_r20 = sclera.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(45, 55).addBox(-2.0F, -1.4F, -0.5F, 4.2F, 1.9F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6939F, -21.2391F, -3.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r21 = sclera.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(19, 49).addBox(-2.8F, -0.2F, -0.5F, 4.3F, 1.9F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3061F, -27.2391F, -3.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r22 = sclera.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(19, 52).addBox(-1.9F, -0.1F, -0.5F, 4.3F, 1.9F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6939F, -27.2391F, -3.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r23 = sclera.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(45, 52).addBox(-2.6F, -1.3F, -0.5F, 4.3F, 1.9F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3061F, -21.2391F, -3.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition pupil = eye.addOrReplaceChild("pupil", CubeListBuilder.create().texOffs(19, 62).addBox(-1.0F, -25.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		eye.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}