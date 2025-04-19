/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_329
 *  net.minecraft.class_332
 *  net.minecraft.class_340
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArgs
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.invoke.arg.Args
 */
package dev.recollect.hana.asm.mixins.freelook;

import dev.recollect.hana.mod.modules.impl.render.Crosshair;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.impl.render.freelook.FreeLook;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_340;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value={class_329.class})
public class InGameHudMixin {
    @Unique
    private CameraState camera;
    @Unique
    private double offsetCrosshairX;
    @Unique
    private double offsetCrosshairY;

    @Inject(method={"renderCrosshair"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRenderCrosshairBegin(class_332 context, CallbackInfo ci) {
        if (Crosshair.INSTANCE.isOn()) {
            Crosshair.INSTANCE.draw(context);
            ci.cancel();
            return;
        }
        this.camera = FreeLook.INSTANCE.getCameraState();
        boolean shouldDrawCrosshair = false;
        if (this.camera.doTransition || this.camera.doLock) {
            class_243 rotation;
            class_1297 cameraEntity = class_310.method_1551().method_1560();
            int distance = Integer.MAX_VALUE;
            class_243 position = cameraEntity.method_19538();
            class_243 point = position.method_1031((rotation = class_243.method_1030((float)this.camera.originalPitch(), (float)this.camera.originalYaw())).method_10216() * (double)distance, rotation.method_10214() * (double)distance, rotation.method_10215() * (double)distance);
            class_243 projected = ProjectionUtils.worldToScreen(point);
            if (projected.method_10215() < 0.0) {
                this.offsetCrosshairX = -projected.method_10216();
                this.offsetCrosshairY = -projected.method_10214();
                shouldDrawCrosshair = true;
            }
            if (!(shouldDrawCrosshair |= class_310.method_1551().field_1705.method_53531().method_53536())) {
                ci.cancel();
            }
        }
    }

    @ModifyArgs(method={"renderCrosshair"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Lnet/minecraft/util/Identifier;IIII)V"))
    private void modifyDrawTextureArgs(Args args) {
        if (this.camera.doTransition || this.camera.doLock) {
            args.set(1, (Object)((Integer)args.get(1) + (int)this.offsetCrosshairX));
            args.set(2, (Object)((Integer)args.get(2) + (int)this.offsetCrosshairY));
        }
    }
}
