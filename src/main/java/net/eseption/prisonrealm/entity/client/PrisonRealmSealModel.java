package net.eseption.prisonrealm.entity.client;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class PrisonRealmSealModel<T extends Entity> extends EntityModel<T> {
	private final ModelPart bone;

	public PrisonRealmSealModel(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition arm1 = bone.addOrReplaceChild("arm1", CubeListBuilder.create(), PartPose.offset(-3.6607F, -10.4927F, -13.7242F));

		PartDefinition stem_r1 = arm1.addOrReplaceChild("stem_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.3103F, -1.2333F, -20.0131F, 3.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8607F, -8.2699F, 13.4223F, 0.534F, 0.1886F, 0.1104F));

		PartDefinition mass1 = arm1.addOrReplaceChild("mass1", CubeListBuilder.create(), PartPose.offset(-0.4393F, 1.5652F, -2.527F));

		PartDefinition cube_r1 = mass1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.1932F, 0.0518F, -0.2778F, -0.3367F, 0.0939F));

		PartDefinition cube_r2 = mass1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(27, 28).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.1932F, -0.0518F, -0.2875F, 0.4205F, -0.1201F));

		PartDefinition arm2 = bone.addOrReplaceChild("arm2", CubeListBuilder.create(), PartPose.offset(0.9715F, -19.0588F, -0.8888F));

		PartDefinition stem_r2 = arm2.addOrReplaceChild("stem_r2", CubeListBuilder.create().texOffs(27, 28).addBox(-1.6459F, -1.8828F, -19.156F, 3.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 1.3F, -0.7F, 0.2618F, -0.48F, 0.0F));

		PartDefinition mass2 = arm2.addOrReplaceChild("mass2", CubeListBuilder.create(), PartPose.offset(9.5535F, 5.8083F, -17.2062F));

		PartDefinition cube_r3 = mass2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.625F, -0.2495F, -0.005F, 0.0F, -0.9599F, 0.0F));

		PartDefinition cube_r4 = mass2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(54, 52).addBox(-2.5F, -2.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.625F, 0.2495F, 0.005F, 0.0F, 0.1745F, 0.0F));

		PartDefinition arm3 = bone.addOrReplaceChild("arm3", CubeListBuilder.create(), PartPose.offset(13.037F, -20.6621F, -8.5211F));

		PartDefinition stem_r3 = arm3.addOrReplaceChild("stem_r3", CubeListBuilder.create().texOffs(0, 24).addBox(-1.8369F, -1.0539F, -20.3867F, 3.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.8F, 2.4F, 8.7F, -0.2008F, -0.9554F, 0.019F));

		PartDefinition mass3 = arm3.addOrReplaceChild("mass3", CubeListBuilder.create(), PartPose.offset(3.5813F, -0.9211F, -2.4981F));

		PartDefinition cube_r5 = mass3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 34).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2008F, -0.9554F, 0.019F));

		PartDefinition arm4 = bone.addOrReplaceChild("arm4", CubeListBuilder.create(), PartPose.offset(13.6012F, -25.3151F, 10.6939F));

		PartDefinition stem_r4 = arm4.addOrReplaceChild("stem_r4", CubeListBuilder.create().texOffs(54, 0).addBox(-1.2537F, -1.3159F, -0.0849F, 3.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.6165F, 7.9141F, -9.0495F, 0.4316F, 0.9208F, 0.0041F));

		PartDefinition mass4 = arm4.addOrReplaceChild("mass4", CubeListBuilder.create(), PartPose.offset(1.4069F, -1.3211F, 1.2496F));

		PartDefinition cube_r6 = mass4.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, -3.999F, -2.999F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(27, 0).addBox(-3.0F, -4.0F, -3.0F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(27, 52).addBox(-2.0F, -2.001F, -1.99F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0815F, 1.0775F, -0.012F, 0.4316F, 0.9208F, 0.0041F));

		PartDefinition arm5 = bone.addOrReplaceChild("arm5", CubeListBuilder.create(), PartPose.offset(-0.75F, -25.487F, 16.9663F));

		PartDefinition stem_r5 = arm5.addOrReplaceChild("stem_r5", CubeListBuilder.create().texOffs(0, 48).addBox(-1.0F, -1.3379F, -0.0133F, 3.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 8.187F, -14.8663F, 0.4363F, 0.0F, 0.0F));

		PartDefinition mass5 = arm5.addOrReplaceChild("mass5", CubeListBuilder.create(), PartPose.offset(-0.25F, -1.3711F, 1.9156F));

		PartDefinition cube_r7 = mass5.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(54, 9).addBox(-4.0F, -3.45F, -2.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(27, 12).addBox(-2.0F, -6.45F, -2.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(54, 0).addBox(-2.0F, -3.45F, -2.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.8581F, 1.4181F, 0.4363F, 0.0F, 0.0F));

		PartDefinition arm6 = bone.addOrReplaceChild("arm6", CubeListBuilder.create(), PartPose.offset(-12.3051F, -24.0168F, 9.2794F));

		PartDefinition stem_r6 = arm6.addOrReplaceChild("stem_r6", CubeListBuilder.create().texOffs(27, 52).addBox(-1.2003F, -1.141F, -0.0391F, 3.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.6435F, 5.9152F, -7.9683F, 0.3464F, -1.0088F, 0.1522F));

		PartDefinition mass6 = arm6.addOrReplaceChild("mass6", CubeListBuilder.create(), PartPose.offset(-3.3246F, -1.7121F, 2.6575F));

		PartDefinition cube_r8 = mass6.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(54, 28).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7606F, 0.0705F, 1.7774F));

		PartDefinition arm7 = bone.addOrReplaceChild("arm7", CubeListBuilder.create(), PartPose.offset(-13.3236F, -23.808F, -10.3507F));

		PartDefinition stem_r7 = arm7.addOrReplaceChild("stem_r7", CubeListBuilder.create().texOffs(27, 4).addBox(-1.5821F, -0.9704F, -20.1997F, 3.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5969F, 5.246F, 10.3797F, -0.3054F, 0.829F, 0.0F));

		PartDefinition mass7 = arm7.addOrReplaceChild("mass7", CubeListBuilder.create(), PartPose.offset(-2.126F, -1.342F, -1.8804F));

		PartDefinition cube_r9 = mass7.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(54, 39).addBox(-3.8233F, -4.7379F, -6.0291F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(-3.8233F, -3.4379F, -6.0291F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.023F, 2.5879F, 2.7601F, 0.0F, 0.4363F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}