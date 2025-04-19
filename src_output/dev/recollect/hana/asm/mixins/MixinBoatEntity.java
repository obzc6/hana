/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1690
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.BoatMoveEvent;
import dev.recollect.hana.mod.modules.impl.movement.dev.EntityControl;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import net.minecraft.class_1690;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1690.class})
public class MixinBoatEntity {
    @Shadow
    private boolean field_7710;
    @Shadow
    private boolean field_7695;

    @Inject(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/entity/vehicle/BoatEntity;move(Lnet/minecraft/entity/MovementType;Lnet/minecraft/util/math/Vec3d;)V")}, cancellable=true)
    private void onTickInvokeMove(CallbackInfo info) {
        BoatMoveEvent event = new BoatMoveEvent((class_1690)this);
        Hana.EVENT_BUS.post(event);
        if (event.isCancelled()) {
            info.cancel();
        }
    }

    @Redirect(method={"updatePaddles"}, at=@At(value="FIELD", target="Lnet/minecraft/entity/vehicle/BoatEntity;pressingLeft:Z"))
    private boolean onUpdatePaddlesPressingLeft(class_1690 boat) {
        if (EntityControl.INSTANCE.isOn() && EntityControl.INSTANCE.fly.getValue()) {
            return false;
        }
        return this.field_7710;
    }

    @Redirect(method={"updatePaddles"}, at=@At(value="FIELD", target="Lnet/minecraft/entity/vehicle/BoatEntity;pressingRight:Z"))
    private boolean onUpdatePaddlesPressingRight(class_1690 boat) {
        if (EntityControl.INSTANCE.isOn() && EntityControl.INSTANCE.fly.getValue()) {
            return false;
        }
        return this.field_7695;
    }
}
