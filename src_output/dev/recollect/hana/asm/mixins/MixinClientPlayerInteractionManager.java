/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_636
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Constant
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyConstant
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.ClickBlockEvent;
import dev.recollect.hana.mod.modules.impl.combat.Reach;
import dev.recollect.hana.mod.modules.impl.exploit.MineTweak;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1799;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_636;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_636.class})
public class MixinClientPlayerInteractionManager {
    @Shadow
    private class_1799 field_3718;

    @ModifyVariable(method={"isCurrentlyBreaking"}, at=@At(value="STORE"))
    private class_1799 stack(class_1799 stack) {
        return MineTweak.INSTANCE.noReset() ? this.field_3718 : stack;
    }

    @ModifyConstant(method={"updateBlockBreakingProgress"}, constant={@Constant(intValue=5)})
    private int MiningCooldownFix(int value) {
        return MineTweak.INSTANCE.noDelay() ? 0 : value;
    }

    @Inject(method={"cancelBlockBreaking"}, at={@At(value="HEAD")}, cancellable=true)
    private void hookCancelBlockBreaking(CallbackInfo callbackInfo) {
        if (MineTweak.INSTANCE.noAbort()) {
            callbackInfo.cancel();
        }
    }

    @Inject(at={@At(value="HEAD")}, method={"getReachDistance()F"}, cancellable=true)
    private void onGetReachDistance(CallbackInfoReturnable<Float> ci) {
        Reach reachHack = Reach.INSTANCE;
        if (reachHack.isOn()) {
            ci.setReturnValue((Object)Float.valueOf(reachHack.distance.getValueFloat()));
        }
    }

    @Inject(at={@At(value="HEAD")}, method={"hasExtendedReach()Z"}, cancellable=true)
    private void hasExtendedReach(CallbackInfoReturnable<Boolean> cir) {
        Reach reachHack = Reach.INSTANCE;
        if (reachHack.isOn()) {
            cir.setReturnValue((Object)true);
        }
    }

    @Inject(method={"attackBlock"}, at={@At(value="HEAD")}, cancellable=true)
    private void onAttackBlock(class_2338 pos, class_2350 direction, CallbackInfoReturnable<Boolean> cir) {
        ClickBlockEvent event = new ClickBlockEvent(pos);
        Hana.EVENT_BUS.post(event);
        if (event.isCancelled()) {
            cir.setReturnValue((Object)false);
        }
    }
}
