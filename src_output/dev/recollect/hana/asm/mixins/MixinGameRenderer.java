/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1533
 *  net.minecraft.class_1675
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3695
 *  net.minecraft.class_3965
 *  net.minecraft.class_3966
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_757
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.recollect.hana.asm.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.managers.ShaderManager;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.api.utils.world.InteractUtil;
import dev.recollect.hana.mod.modules.impl.exploit.MineTweak;
import dev.recollect.hana.mod.modules.impl.render.AspectRatio;
import dev.recollect.hana.mod.modules.impl.render.CustomFov;
import dev.recollect.hana.mod.modules.impl.render.FreeCam;
import dev.recollect.hana.mod.modules.impl.render.NoRender;
import dev.recollect.hana.mod.modules.impl.render.TotemAnimation;
import dev.recollect.hana.mod.modules.impl.render.Zoom;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1533;
import net.minecraft.class_1675;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3695;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_757;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_757.class})
public class MixinGameRenderer {
    @Shadow
    @Final
    class_310 field_4015;
    @Shadow
    private float field_4005;
    @Shadow
    private float field_3988;
    @Shadow
    private float field_4004;
    @Shadow
    private float field_4025;

    @Inject(method={"showFloatingItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void onShowFloatingItem(class_1799 floatingItem, CallbackInfo info) {
        if (floatingItem.method_7909() == class_1802.field_8288 && NoRender.INSTANCE.isOn() && NoRender.INSTANCE.totem.getValue()) {
            info.cancel();
        }
    }

    @Inject(method={"showFloatingItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void showFloatingItemHook(class_1799 floatingItem, CallbackInfo info) {
        if (TotemAnimation.instance.isOn()) {
            TotemAnimation.instance.showFloatingItem(floatingItem);
            info.cancel();
        }
    }

    @Inject(method={"renderFloatingItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderFloatingItemHook(int scaledWidth, int scaledHeight, float tickDelta, CallbackInfo ci) {
        if (TotemAnimation.instance.isOn()) {
            TotemAnimation.instance.renderFloatingItem(scaledWidth, scaledHeight, tickDelta);
            ci.cancel();
        }
    }

    @Redirect(method={"renderWorld"}, at=@At(value="INVOKE", target="Lnet/minecraft/util/math/MathHelper;lerp(FFF)F"))
    private float applyCameraTransformationsMathHelperLerpProxy(float delta, float first, float second) {
        if (NoRender.INSTANCE.isOn() && NoRender.INSTANCE.nausea.getValue()) {
            return 0.0f;
        }
        return class_3532.method_16439((float)delta, (float)first, (float)second);
    }

    @Inject(method={"tiltViewWhenHurt"}, at={@At(value="HEAD")}, cancellable=true)
    private void tiltViewWhenHurtHook(class_4587 matrices, float tickDelta, CallbackInfo ci) {
        if (NoRender.INSTANCE.isOn() && NoRender.INSTANCE.hurtCam.getValue()) {
            ci.cancel();
        }
    }

    @Inject(at={@At(value="FIELD", target="Lnet/minecraft/client/render/GameRenderer;renderHand:Z", opcode=180, ordinal=0)}, method={"renderWorld"})
    void render3dHook(float tickDelta, long limitTime, class_4587 matrix, CallbackInfo ci) {
        TextUtil.lastProjMat.set((Matrix4fc)RenderSystem.getProjectionMatrix());
        TextUtil.lastModMat.set((Matrix4fc)RenderSystem.getModelViewMatrix());
        TextUtil.lastWorldSpaceMatrix.set((Matrix4fc)matrix.method_23760().method_23761());
        Hana.FPS.record();
        Hana.MODULE.render3D(matrix);
    }

    @Inject(method={"renderWorld"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/GameRenderer;renderHand(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/Camera;F)V", shift=At.Shift.AFTER)})
    public void postRender3dHook(float tickDelta, long limitTime, class_4587 matrix, CallbackInfo ci) {
        Hana.SHADER.renderShaders();
    }

    @Inject(method={"getFov(Lnet/minecraft/client/render/Camera;FZ)D"}, at={@At(value="TAIL")}, cancellable=true)
    public void getFov(class_4184 camera, float tickDelta, boolean changingFov, CallbackInfoReturnable<Double> cb) {
        if (CustomFov.INSTANCE.isOn()) {
            if ((Double)cb.getReturnValue() == 70.0 && !CustomFov.INSTANCE.itemFov.getValue()) {
                return;
            }
            if (CustomFov.INSTANCE.itemFov.getValue() && (Double)cb.getReturnValue() == 70.0) {
                cb.setReturnValue((Object)CustomFov.INSTANCE.itemFovModifier.getValue());
                return;
            }
            cb.setReturnValue((Object)CustomFov.INSTANCE.fov.getValue());
        }
        if ((Double)cb.getReturnValue() == 70.0) {
            return;
        }
        if (Zoom.on) {
            cb.setReturnValue((Object)Math.min(Math.max((Double)cb.getReturnValue() - Zoom.INSTANCE.currentFov, 1.0), 177.0));
        }
    }

    @Inject(method={"getBasicProjectionMatrix"}, at={@At(value="TAIL")}, cancellable=true)
    public void getBasicProjectionMatrixHook(double fov, CallbackInfoReturnable<Matrix4f> cir) {
        if (AspectRatio.INSTANCE.isOn()) {
            class_4587 matrixStack = new class_4587();
            matrixStack.method_23760().method_23761().identity();
            if (this.field_4005 != 1.0f) {
                matrixStack.method_46416(this.field_3988, -this.field_4004, 0.0f);
                matrixStack.method_22905(this.field_4005, this.field_4005, 1.0f);
            }
            matrixStack.method_23760().method_23761().mul((Matrix4fc)new Matrix4f().setPerspective((float)(fov * 0.01745329238474369), AspectRatio.INSTANCE.ratio.getValueFloat(), 0.05f, this.field_4025 * 4.0f));
            cir.setReturnValue((Object)matrixStack.method_23760().method_23761());
        }
    }

    @Inject(method={"updateTargetedEntity"}, at={@At(value="HEAD")}, cancellable=true)
    private void updateTargetedEntityHook(float tickDelta, CallbackInfo ci) {
        ci.cancel();
        this.update(tickDelta);
    }

    @Unique
    public void update(float tickDelta) {
        class_1297 entity = this.field_4015.method_1560();
        if (entity != null && this.field_4015.field_1687 != null) {
            class_3966 entityHitResult;
            this.field_4015.method_16011().method_15396("pick");
            this.field_4015.field_1692 = null;
            double d = this.field_4015.field_1761.method_2904();
            MineTweak.INSTANCE.isActive = MineTweak.INSTANCE.ghostHand();
            this.field_4015.field_1765 = entity.method_5745(d, tickDelta, false);
            MineTweak.INSTANCE.isActive = false;
            class_243 vec3d = entity.method_5836(tickDelta);
            boolean bl = false;
            double e = d;
            if (this.field_4015.field_1761.method_2926()) {
                d = e = 6.0;
            } else if (d > 3.0) {
                bl = true;
            }
            e *= e;
            if (this.field_4015.field_1765 != null) {
                e = this.field_4015.field_1765.method_17784().method_1025(vec3d);
            }
            class_243 vec3d2 = entity.method_5828(1.0f);
            class_243 vec3d3 = vec3d.method_1031(vec3d2.field_1352 * d, vec3d2.field_1351 * d, vec3d2.field_1350 * d);
            class_238 box = entity.method_5829().method_18804(vec3d2.method_1021(d)).method_1009(1.0, 1.0, 1.0);
            if (FreeCam.INSTANCE.isOn()) {
                this.field_4015.field_1765 = InteractUtil.getRtxTarget(FreeCam.INSTANCE.getFakeYaw(), FreeCam.INSTANCE.getFakePitch(), FreeCam.INSTANCE.getFakeX(), FreeCam.INSTANCE.getFakeY(), FreeCam.INSTANCE.getFakeZ());
                this.field_4015.method_16011().method_15407();
                return;
            }
            if (!MineTweak.INSTANCE.noEntityTrace() && (entityHitResult = class_1675.method_18075((class_1297)entity, (class_243)vec3d, (class_243)vec3d3, (class_238)box, entityx -> !entityx.method_7325() && entityx.method_5863(), (double)e)) != null) {
                class_1297 entity2 = entityHitResult.method_17782();
                class_243 vec3d4 = entityHitResult.method_17784();
                double g = vec3d.method_1025(vec3d4);
                if (bl && g > 9.0) {
                    this.field_4015.field_1765 = class_3965.method_17778((class_243)vec3d4, (class_2350)class_2350.method_10142((double)vec3d2.field_1352, (double)vec3d2.field_1351, (double)vec3d2.field_1350), (class_2338)class_2338.method_49638((class_2374)vec3d4));
                } else if (g < e || this.field_4015.field_1765 == null) {
                    this.field_4015.field_1765 = entityHitResult;
                    if (entity2 instanceof class_1309 || entity2 instanceof class_1533) {
                        this.field_4015.field_1692 = entity2;
                    }
                }
            }
            this.field_4015.method_16011().method_15407();
        }
    }
}
