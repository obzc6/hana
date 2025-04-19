/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  ladysnake.satin.api.managed.ManagedShaderEffect
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_279
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_761
 *  net.minecraft.class_898
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ShaderManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.modules.impl.render.FreeCam;
import dev.recollect.hana.mod.modules.impl.render.NoInterp;
import dev.recollect.hana.mod.modules.impl.render.Shader;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import ladysnake.satin.api.managed.ManagedShaderEffect;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_279;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_761;
import net.minecraft.class_898;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_761.class})
public abstract class MixinWorldRenderer {
    @Final
    @Shadow
    private class_310 field_4088;
    @Shadow
    @Final
    private class_898 field_4109;

    @Shadow
    protected abstract void method_3250(class_4587 var1);

    @Inject(method={"renderEntity"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderEntityHook(class_1297 entity, double cameraX, double cameraY, double cameraZ, float tickDelta, class_4587 matrices, class_4597 vertexConsumers, CallbackInfo ci) {
        if (NoInterp.INSTANCE.isOn() && entity != class_310.method_1551().field_1724 && entity instanceof class_1657) {
            ci.cancel();
            double d = entity.method_23317();
            double e = entity.method_23318();
            double f = entity.method_23321();
            float g = entity.method_36454();
            this.field_4109.method_3954(entity, d - cameraX, e - cameraY, f - cameraZ, g, 0.0f, matrices, vertexConsumers, this.field_4109.method_23839(entity, tickDelta));
        }
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gl/PostEffectProcessor;render(F)V", ordinal=0))
    void replaceShaderHook(class_279 instance, float tickDelta) {
        ShaderManager.Shader shaders = Shader.INSTANCE.mode.getValue();
        if (Shader.INSTANCE.isOn() && Wrapper.mc.field_1687 != null) {
            Hana.SHADER.setupShader(shaders, Hana.SHADER.getShaderOutline(shaders));
        } else {
            instance.method_1258(tickDelta);
        }
    }

    @Inject(method={"renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderSkyHead(class_4587 matrices, Matrix4f matrix4f, float tickDelta, class_4184 camera, boolean bl, Runnable runnable, CallbackInfo info) {
        if (Shader.INSTANCE.isOn() && Shader.INSTANCE.sky.getValue()) {
            Hana.SHADER.applyShader(() -> this.method_3250(matrices), Shader.INSTANCE.skyMode.getValue());
            info.cancel();
        }
    }

    @ModifyArg(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/WorldRenderer;setupTerrain(Lnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/Frustum;ZZ)V"), index=3)
    private boolean renderSetupTerrainModifyArg(boolean spectator) {
        return FreeCam.INSTANCE.isOn() || spectator;
    }
}
