/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1320
 *  net.minecraft.class_1322
 *  net.minecraft.class_1324
 *  net.minecraft.class_1937
 *  net.minecraft.class_310
 *  net.minecraft.class_5131
 *  net.minecraft.class_5134
 *  net.minecraft.class_746
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.mod.modules.impl.exploit.dev.NoBadEffects;
import dev.recollect.hana.mod.modules.impl.movement.dev.GlidePuls;
import dev.recollect.hana.mod.modules.impl.movement.dev.SprintPlus;
import dev.recollect.hana.mod.modules.impl.render.ViewModel;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.UUID;
import net.minecraft.class_1291;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1320;
import net.minecraft.class_1322;
import net.minecraft.class_1324;
import net.minecraft.class_1937;
import net.minecraft.class_310;
import net.minecraft.class_5131;
import net.minecraft.class_5134;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1309.class})
public abstract class MixinLivingEntity
extends class_1297 {
    @Final
    @Shadow
    private static class_1322 field_6231;

    public MixinLivingEntity(class_1299<?> type, class_1937 world) {
        super(type, world);
    }

    @Shadow
    @Nullable
    public class_1324 method_5996(class_1320 attribute) {
        return this.method_6127().method_26842(attribute);
    }

    @Shadow
    public class_5131 method_6127() {
        return null;
    }

    @Inject(method={"getHandSwingDuration"}, at={@At(value="HEAD")}, cancellable=true)
    private void getArmSwingAnimationEnd(CallbackInfoReturnable<Integer> info) {
        if (ViewModel.INSTANCE.isOn() && ViewModel.INSTANCE.slowAnimation.getValue()) {
            info.setReturnValue((Object)ViewModel.INSTANCE.slowAnimationVal.getValueInt());
        }
    }

    @Inject(method={"setSprinting"}, at={@At(value="HEAD")}, cancellable=true)
    public void setSprintingHook(boolean sprinting, CallbackInfo ci) {
        if (this == class_310.method_1551().field_1724 && SprintPlus.INSTANCE.isOn() && SprintPlus.INSTANCE.mode.getValue() == SprintPlus.Mode.Rage) {
            ci.cancel();
            sprinting = SprintPlus.shouldSprint;
            super.method_5728(sprinting);
            class_1324 entityAttributeInstance = this.method_5996(class_5134.field_23719);
            entityAttributeInstance.method_6200(field_6231.method_6189());
            if (sprinting) {
                entityAttributeInstance.method_26835(field_6231);
            }
        }
    }

    @Redirect(method={"tickMovement"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/LivingEntity;hasStatusEffect(Lnet/minecraft/entity/effect/StatusEffect;)Z"), require=0)
    private boolean tickMovementHook(class_1309 instance, class_1291 effect) {
        if (GlidePuls.INSTANCE != null && GlidePuls.INSTANCE.isOn() && GlidePuls.INSTANCE.onlyFall.getValue()) {
            return false;
        }
        return instance.method_6059(effect);
    }

    @Redirect(method={"travel"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/LivingEntity;hasStatusEffect(Lnet/minecraft/entity/effect/StatusEffect;)Z"), require=0)
    private boolean travelEffectHook(class_1309 instance, class_1291 effect) {
        if (NoBadEffects.INSTANCE.isOn()) {
            if (effect == class_1294.field_5906 && NoBadEffects.INSTANCE.slowFalling.getValue()) {
                return false;
            }
            if (effect == class_1294.field_5902 && NoBadEffects.INSTANCE.levitation.getValue()) {
                return false;
            }
        }
        return instance.method_6059(effect);
    }
}
