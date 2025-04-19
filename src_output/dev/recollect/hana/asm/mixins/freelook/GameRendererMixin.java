/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_757
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins.freelook;

import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.impl.render.freelook.FreeLook;
import net.minecraft.class_1297;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_757;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_757.class})
public abstract class GameRendererMixin {
    @Unique
    private CameraState camera;
    @Unique
    private class_1297 cameraEntity;
    @Unique
    private float originalYaw;
    @Unique
    private float originalPitch;

    @Inject(method={"renderHand"}, at={@At(value="HEAD")})
    private void onRenderHandBegin(class_4587 matrices, class_4184 camera, float tickDelta, CallbackInfo ci) {
        this.camera = FreeLook.INSTANCE.getCameraState();
        if (this.camera.doTransition || this.camera.doLock) {
            this.cameraEntity = class_310.method_1551().method_1560();
            this.originalYaw = this.cameraEntity.method_36454();
            this.originalPitch = this.cameraEntity.method_36455();
            float pitch = this.camera.lookPitch;
            this.cameraEntity.method_36456(this.camera.lookYaw);
            this.cameraEntity.method_36457(pitch -= class_3532.method_15379((float)(this.camera.lookYaw - this.camera.originalYaw())));
        }
    }

    @Inject(method={"renderHand"}, at={@At(value="RETURN")})
    private void onRenderHandEnd(class_4587 matrices, class_4184 camera, float tickDelta, CallbackInfo ci) {
        if (this.camera.doTransition || this.camera.doLock) {
            this.cameraEntity.method_36456(this.originalYaw);
            this.cameraEntity.method_36457(this.originalPitch);
        }
    }
}
