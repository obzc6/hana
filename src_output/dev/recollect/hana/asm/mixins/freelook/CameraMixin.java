/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3532
 *  net.minecraft.class_4184
 *  net.minecraft.class_5498
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArgs
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.invoke.arg.Args
 */
package dev.recollect.hana.asm.mixins.freelook;

import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.impl.render.freelook.FreeLook;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_5498;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value={class_4184.class})
public abstract class CameraMixin {
    @Shadow
    private float field_18721;
    @Unique
    private float lastUpdate;

    @Inject(method={"update"}, at={@At(value="HEAD")})
    private void onCameraUpdate(class_1922 area, class_1297 focusedEntity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo ci) {
        CameraState camera = FreeLook.INSTANCE.getCameraState();
        if (camera.doLock) {
            float limitNegativeYaw = camera.originalYaw() - 180.0f;
            float limitPositiveYaw = camera.originalYaw() + 180.0f;
            if (camera.lookYaw > limitPositiveYaw) {
                camera.lookYaw = limitPositiveYaw;
            }
            if (camera.lookYaw < limitNegativeYaw) {
                camera.lookYaw = limitNegativeYaw;
            }
        }
    }

    @ModifyArgs(method={"update"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/Camera;setRotation(FF)V"))
    private void modifyRotationArgs(Args args) {
        CameraState camera = FreeLook.INSTANCE.getCameraState();
        if (camera.doLock) {
            float yaw = camera.lookYaw;
            float pitch = camera.lookPitch;
            if (class_310.method_1551().field_1690.method_31044().method_31035()) {
                yaw -= 180.0f;
                pitch = -pitch;
            }
            args.set(0, (Object)Float.valueOf(yaw));
            args.set(1, (Object)Float.valueOf(pitch));
        } else if (camera.doTransition) {
            float delta = this.getCurrentTime() - this.lastUpdate;
            float steps = 1.2f;
            float speed = 2.0f;
            float yawDiff = camera.lookYaw - camera.originalYaw();
            float pitchDiff = camera.lookPitch - camera.originalPitch();
            float yawStep = speed * (yawDiff * steps);
            float pitchStep = speed * (pitchDiff * steps);
            float yaw = class_3532.method_15348((float)camera.lookYaw, (float)camera.originalYaw(), (float)(yawStep * delta));
            float pitch = class_3532.method_15348((float)camera.lookPitch, (float)camera.originalPitch(), (float)(pitchStep * delta));
            camera.lookYaw = yaw;
            camera.lookPitch = pitch;
            args.set(0, (Object)Float.valueOf(yaw));
            args.set(1, (Object)Float.valueOf(pitch));
            camera.doTransition = (int)camera.originalYaw() != (int)camera.lookYaw || (int)camera.originalPitch() != (int)camera.lookPitch;
        }
        this.lastUpdate = this.getCurrentTime();
    }

    @Unique
    private float getCurrentTime() {
        return (float)((double)System.nanoTime() * 1.0E-8);
    }
}
