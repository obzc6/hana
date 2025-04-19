/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_4184
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArgs
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  org.spongepowered.asm.mixin.injection.invoke.arg.Args
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.mod.modules.impl.render.CameraClip;
import dev.recollect.hana.mod.modules.impl.render.FreeCam;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_4184;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value={class_4184.class})
public abstract class MixinCamera {
    @Shadow
    private boolean field_18719;

    @Shadow
    protected abstract double method_19318(double var1);

    @ModifyArgs(method={"update"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/Camera;moveBy(DDD)V", ordinal=0))
    private void modifyCameraDistance(Args args) {
        if (CameraClip.INSTANCE.isOn()) {
            args.set(0, (Object)(-this.method_19318(CameraClip.INSTANCE.getDistance())));
        }
    }

    @Inject(method={"clipToSpace"}, at={@At(value="HEAD")}, cancellable=true)
    private void onClipToSpace(double desiredCameraDistance, CallbackInfoReturnable<Double> info) {
        if (CameraClip.INSTANCE.isOn()) {
            info.setReturnValue((Object)CameraClip.INSTANCE.getDistance());
        }
    }

    @Inject(method={"update"}, at={@At(value="TAIL")})
    private void updateHook(class_1922 area, class_1297 focusedEntity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo ci) {
        if (FreeCam.INSTANCE.isOn()) {
            this.field_18719 = true;
        }
    }

    @ModifyArgs(method={"update"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/Camera;setRotation(FF)V"))
    private void setRotationHook(Args args) {
        if (FreeCam.INSTANCE.isOn()) {
            args.setAll(new Object[]{Float.valueOf(FreeCam.INSTANCE.getFakeYaw()), Float.valueOf(FreeCam.INSTANCE.getFakePitch())});
        }
    }

    @ModifyArgs(method={"update"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/Camera;setPos(DDD)V"))
    private void setPosHook(Args args) {
        if (FreeCam.INSTANCE.isOn()) {
            args.setAll(new Object[]{FreeCam.INSTANCE.getFakeX(), FreeCam.INSTANCE.getFakeY(), FreeCam.INSTANCE.getFakeZ()});
        }
    }
}
