/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1921
 *  net.minecraft.class_2338
 *  net.minecraft.class_2960
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4608
 *  net.minecraft.class_5617
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_630
 *  net.minecraft.class_7833
 *  net.minecraft.class_892
 *  net.minecraft.class_895
 *  net.minecraft.class_897
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.api.utils.dev.CubeUtil;
import dev.recollect.hana.mod.modules.impl.render.CrystalChams;
import dev.recollect.hana.mod.modules.impl.render.dev.CrystalRenderer;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntPredicate;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1921;
import net.minecraft.class_2338;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_5617;
import net.minecraft.class_630;
import net.minecraft.class_7833;
import net.minecraft.class_892;
import net.minecraft.class_895;
import net.minecraft.class_897;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_892.class})
public abstract class MixinEndCrystalEntityRenderer
extends class_897<class_1511> {
    private static final int ANIMATION_LENGTH = 400;
    private static final float CUBELET_SCALE = 0.4f;
    private int rotatingSide = 0;
    private long lastTime = 0L;
    private class_1511 endCrystalEntity;
    @Mutable
    @Final
    @Shadow
    private static class_1921 field_21736;
    @Shadow
    @Final
    private static class_2960 field_4663;
    @Final
    @Shadow
    private static float field_21002;
    @Final
    @Shadow
    private class_630 field_21003;
    @Final
    @Shadow
    private class_630 field_21004;
    @Final
    @Shadow
    private class_630 field_21005;
    @Unique
    final class_2960 BLANK = new class_2960("textures/blank.png");

    protected MixinEndCrystalEntityRenderer(class_5617.class_5618 ctx) {
        super(ctx);
    }

    @Unique
    private float yOffset(class_1511 crystal, float tickDelta) {
        float f = ((float)crystal.field_7034 + tickDelta) * CrystalChams.INSTANCE.floatValue.getValueFloat();
        float g = class_3532.method_15374((float)(f * 0.2f)) / 2.0f + 0.5f;
        g = (g * g + g) * 0.4f * CrystalChams.INSTANCE.bounceHeight.getValueFloat();
        return g - 1.4f + CrystalChams.INSTANCE.floatOffset.getValueFloat();
    }

    @Inject(method={"render(Lnet/minecraft/entity/decoration/EndCrystalEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"}, at={@At(value="HEAD")}, cancellable=true)
    public void render(class_1511 endCrystalEntity, float f, float g, class_4587 matrixStack, class_4597 vertexConsumerProvider, int i, CallbackInfo ci) {
        CrystalChams module = CrystalChams.INSTANCE;
        this.endCrystalEntity = endCrystalEntity;
        if (CrystalRenderer.INSTANCE.isOn() && CrystalRenderer.INSTANCE.cham.getValue()) {
            ci.cancel();
            CrystalRenderer.INSTANCE.renderCrystal(endCrystalEntity, f, g, matrixStack, i, this.field_21003, this.field_21004);
        }
        field_21736 = class_1921.method_23580((class_2960)(module.isOn() && !module.texture.getValue() ? this.BLANK : field_4663));
        if (!module.isOn()) {
            return;
        }
        ci.cancel();
        matrixStack.method_22903();
        float h = this.yOffset(endCrystalEntity, g);
        float j = (float)((double)(((float)endCrystalEntity.field_7034 + g) * 3.0f) * module.spinValue.getValue());
        class_4588 vertexConsumer = vertexConsumerProvider.getBuffer(field_21736);
        matrixStack.method_22903();
        matrixStack.method_22905(2.0f * module.scale.getValueFloat(), 2.0f * module.scale.getValueFloat(), 2.0f * module.scale.getValueFloat());
        matrixStack.method_46416(0.0f, -0.5f, 0.0f);
        int k = class_4608.field_21444;
        if (endCrystalEntity.method_6836()) {
            this.field_21005.method_22698(matrixStack, vertexConsumer, i, k);
        }
        matrixStack.method_22907(class_7833.field_40716.rotationDegrees(j));
        matrixStack.method_46416(0.0f, 1.5f + h / 2.0f, 0.0f);
        matrixStack.method_22907(new Quaternionf().setAngleAxis(1.0471976f, field_21002, 0.0f, field_21002));
        Color color = module.outerFrame.getValue();
        if (module.outerFrame.booleanValue) {
            this.field_21004.method_22699(matrixStack, vertexConsumer, i, k, (float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f);
        }
        matrixStack.method_22905(0.875f, 0.875f, 0.875f);
        matrixStack.method_22907(new Quaternionf().setAngleAxis(1.0471976f, field_21002, 0.0f, field_21002));
        matrixStack.method_22907(class_7833.field_40716.rotationDegrees(j));
        color = module.innerFrame.getValue();
        if (module.innerFrame.booleanValue) {
            this.field_21004.method_22699(matrixStack, vertexConsumer, i, k, (float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f);
        }
        matrixStack.method_22905(0.875f, 0.875f, 0.875f);
        matrixStack.method_22907(new Quaternionf().setAngleAxis(1.0471976f, field_21002, 0.0f, field_21002));
        matrixStack.method_22907(class_7833.field_40716.rotationDegrees(j));
        color = module.core.getValue();
        if (module.core.booleanValue) {
            this.field_21003.method_22699(matrixStack, vertexConsumer, i, k, (float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f);
        }
        matrixStack.method_22909();
        matrixStack.method_22909();
        class_2338 blockPos = endCrystalEntity.method_6838();
        if (blockPos != null) {
            float m = (float)blockPos.method_10263() + 0.5f;
            float n = (float)blockPos.method_10264() + 0.5f;
            float o = (float)blockPos.method_10260() + 0.5f;
            float p = (float)((double)m - endCrystalEntity.method_23317());
            float q = (float)((double)n - endCrystalEntity.method_23318());
            float r = (float)((double)o - endCrystalEntity.method_23321());
            matrixStack.method_46416(p, q, r);
            class_895.method_3917((float)(-p), (float)(-q + h), (float)(-r), (float)g, (int)endCrystalEntity.field_7034, (class_4587)matrixStack, (class_4597)vertexConsumerProvider, (int)i);
        }
        super.method_3936((class_1297)endCrystalEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="net/minecraft/client/util/math/MatrixStack.translate(FFF)V", ordinal=1), require=0)
    public void translate(class_4587 class_45872, float f, float f2, float f3) {
        class_45872.method_46416(f, this.endCrystalEntity != null && this.endCrystalEntity.method_6836() ? 1.2f : 1.0f, f3);
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="net/minecraft/client/model/ModelPart.render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;II)V", ordinal=3), require=0)
    public void renderCore(class_630 class_6302, class_4587 class_45872, class_4588 class_45882, int n, int n2) {
        this.render(class_6302, class_45872, class_45882, n, n2);
    }

    public void render(class_630 class_6302, class_4587 class_45872, class_4588 class_45882, int n, int n2) {
        if (CrystalRenderer.INSTANCE.isOn() && CrystalRenderer.INSTANCE.cube.getValue()) {
            long l = System.currentTimeMillis();
            if (l - 400L > this.lastTime) {
                int[] nArray = CubeUtil.cubeSides[this.rotatingSide];
                Quaternionf[] quaternionfArray = new Quaternionf[]{CubeUtil.cubeletStatus[nArray[0]], CubeUtil.cubeletStatus[nArray[1]], CubeUtil.cubeletStatus[nArray[2]], CubeUtil.cubeletStatus[nArray[3]], CubeUtil.cubeletStatus[nArray[4]], CubeUtil.cubeletStatus[nArray[5]], CubeUtil.cubeletStatus[nArray[6]], CubeUtil.cubeletStatus[nArray[7]], CubeUtil.cubeletStatus[nArray[8]]};
                CubeUtil.cubeletStatus[nArray[0]] = quaternionfArray[6];
                CubeUtil.cubeletStatus[nArray[1]] = quaternionfArray[3];
                CubeUtil.cubeletStatus[nArray[2]] = quaternionfArray[0];
                CubeUtil.cubeletStatus[nArray[3]] = quaternionfArray[7];
                CubeUtil.cubeletStatus[nArray[4]] = quaternionfArray[4];
                CubeUtil.cubeletStatus[nArray[5]] = quaternionfArray[1];
                CubeUtil.cubeletStatus[nArray[6]] = quaternionfArray[8];
                CubeUtil.cubeletStatus[nArray[7]] = quaternionfArray[5];
                CubeUtil.cubeletStatus[nArray[8]] = quaternionfArray[2];
                int[] nArray2 = CubeUtil.cubeSideTransforms[this.rotatingSide];
                for (int i = -1; i < 2; ++i) {
                    for (int j = -1; j < 2; ++j) {
                        for (int k = -1; k < 2; ++k) {
                            if (i == 0 && j == 0 && k == 0) continue;
                            this.applyCubeletRotation(i, j, k, nArray2[0], nArray2[1], nArray2[2]);
                        }
                    }
                }
                this.rotatingSide = ThreadLocalRandom.current().nextInt(0, 6);
                this.lastTime = l;
            }
            class_45872.method_22905(0.4f, 0.4f, 0.4f);
            for (int i = -1; i < 2; ++i) {
                for (int j = -1; j < 2; ++j) {
                    for (int k = -1; k < 2; ++k) {
                        if (i == 0 && j == 0 && k == 0) continue;
                        this.drawCubeletStatic(class_6302, class_45872, class_45882, n, n2, i, j, k);
                    }
                }
            }
            int[] nArray = CubeUtil.cubeSideTransforms[this.rotatingSide];
            class_45872.method_22903();
            class_45872.method_46416((float)nArray[0] * 0.4f, (float)nArray[1] * 0.4f, (float)nArray[2] * 0.4f);
            float f = (float)Math.toRadians(CubeUtil.easeInOutCubic((float)(l - this.lastTime) / 400.0f) * 90.0);
            float f2 = (float)((double)nArray[0] * Math.sin(f / 2.0f));
            float f3 = (float)((double)nArray[1] * Math.sin(f / 2.0f));
            float f4 = (float)((double)nArray[2] * Math.sin(f / 2.0f));
            float f5 = (float)Math.cos(f / 2.0f);
            Quaternionf quaternionf = new Quaternionf(f2, f3, f4, f5);
            class_45872.method_22907(quaternionf);
            for (int i = -1; i < 2; ++i) {
                for (int j = -1; j < 2; ++j) {
                    for (int k = -1; k < 2; ++k) {
                        if (i == 0 && j == 0 && k == 0) continue;
                        this.drawCubeletRotating(class_6302, class_45872, class_45882, n, n2, i, j, k);
                    }
                }
            }
            class_45872.method_22909();
        } else {
            class_45872.method_22903();
            class_45872.method_22905(0.875f, 0.875f, 0.875f);
            class_6302.method_22698(class_45872, class_45882, n, n2);
            class_45872.method_22909();
        }
    }

    private void drawCubeletStatic(class_630 class_6302, class_4587 class_45872, class_4588 class_45882, int n, int n3, int n4, int n5, int n6) {
        int n7 = CubeUtil.cubletLookup[n4 + 1][n5 + 1][n6 + 1];
        if (Arrays.stream(CubeUtil.cubeSides[this.rotatingSide]).anyMatch(n2 -> n2 == n7)) {
            return;
        }
        this.drawCubelet(class_6302, class_45872, class_45882, n, n3, n4, n5, n6, n7);
    }

    private void drawCubeletRotating(class_630 class_6302, class_4587 class_45872, class_4588 class_45882, int n, int n3, int n4, int n5, int n6) {
        int n7 = CubeUtil.cubletLookup[n4 + 1][n5 + 1][n6 + 1];
        if (Arrays.stream(CubeUtil.cubeSides[this.rotatingSide]).noneMatch(n2 -> n2 == n7)) {
            return;
        }
        int[] nArray = CubeUtil.cubeSideTransforms[this.rotatingSide];
        this.drawCubelet(class_6302, class_45872, class_45882, n, n3, n4 - nArray[0], n5 - nArray[1], n6 - nArray[2], n7);
    }

    private void applyCubeletRotation(int n, int n3, int n4, int n5, int n6, int n7) {
        int n8 = CubeUtil.cubletLookup[n + 1][n3 + 1][n4 + 1];
        if (Arrays.stream(CubeUtil.cubeSides[this.rotatingSide]).noneMatch(n2 -> n2 == n8)) {
            return;
        }
        float f = (float)Math.toRadians(90.0);
        float f2 = (float)((double)n5 * Math.sin(f / 2.0f));
        float f3 = (float)((double)n6 * Math.sin(f / 2.0f));
        float f4 = (float)((double)n7 * Math.sin(f / 2.0f));
        float f5 = (float)Math.cos(f / 2.0f);
        Quaternionf quaternionf = new Quaternionf(f2, f3, f4, f5);
        quaternionf.mul((Quaternionfc)CubeUtil.cubeletStatus[n8]);
        CubeUtil.cubeletStatus[n8] = quaternionf;
    }

    private void drawCubelet(class_630 class_6302, class_4587 class_45872, class_4588 class_45882, int n, int n2, int n3, int n4, int n5, int n6) {
        class_45872.method_22903();
        class_45872.method_46416((float)n3 * 0.4f, (float)n4 * 0.4f, (float)n5 * 0.4f);
        class_45872.method_22903();
        class_45872.method_22907(CubeUtil.cubeletStatus[n6]);
        class_45872.method_22905(0.8f, 0.8f, 0.8f);
        class_6302.method_22698(class_45872, class_45882, n, n2);
        class_45872.method_22909();
        class_45872.method_22909();
    }
}
