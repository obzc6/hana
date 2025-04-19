/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
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
import net.minecraft.class_3532;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1297.class})
public abstract class EntityMixin {
    @Unique
    private CameraState camera;

    @Inject(method={"changeLookDirection"}, at={@At(value="HEAD")}, cancellable=true)
    private void onChangeLookDirection(double cursorDeltaX, double cursorDeltaY, CallbackInfo callback) {
        if ((class_1297)this instanceof class_746) {
            this.camera = FreeLook.INSTANCE.getCameraState();
            if (this.camera.doLock) {
                this.applyTransformedAngle(cursorDeltaX, cursorDeltaY);
                callback.cancel();
            } else if (this.camera.doTransition) {
                this.applyTransformedAngle(cursorDeltaX, cursorDeltaY);
            }
        }
    }

    @Unique
    private void applyTransformedAngle(double cursorDeltaX, double cursorDeltaY) {
        float cursorDeltaMultiplier = 0.15f;
        float transformedCursorDeltaX = (float)cursorDeltaX * cursorDeltaMultiplier;
        float transformedCursorDeltaY = (float)cursorDeltaY * cursorDeltaMultiplier;
        float yaw = this.camera.lookYaw;
        float pitch = this.camera.lookPitch;
        pitch += transformedCursorDeltaY;
        pitch = class_3532.method_15363((float)pitch, (float)-90.0f, (float)90.0f);
        this.camera.lookYaw = yaw += transformedCursorDeltaX;
        this.camera.lookPitch = pitch;
    }
}
