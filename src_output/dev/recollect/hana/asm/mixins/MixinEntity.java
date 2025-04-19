/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_4050
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArgs
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  org.spongepowered.asm.mixin.injection.invoke.arg.Args
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.modules.impl.movement.Velocity;
import dev.recollect.hana.mod.modules.impl.render.NoRender;
import dev.recollect.hana.mod.modules.impl.render.Shader;
import dev.recollect.hana.mod.modules.impl.render.dev.ForceSneak;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_4050;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value={class_1297.class})
public abstract class MixinEntity {
    @Shadow
    public abstract class_2561 method_5477();

    @Shadow
    public abstract boolean method_41328(class_4050 var1);

    @Inject(method={"isInSneakingPose"}, at={@At(value="RETURN")}, cancellable=true)
    private void isSneaking(CallbackInfoReturnable cir) {
        if (Wrapper.mc.field_1724 == null || this.method_5477() != Wrapper.mc.field_1724.method_5477()) {
            cir.setReturnValue((Object)(ForceSneak.INSTANCE.isOn() || this.method_41328(class_4050.field_18081)));
        }
    }

    @Inject(at={@At(value="HEAD")}, method={"isInvisibleTo(Lnet/minecraft/entity/player/PlayerEntity;)Z"}, cancellable=true)
    private void onIsInvisibleCheck(class_1657 message, CallbackInfoReturnable<Boolean> cir) {
        if (NoRender.INSTANCE.isOn() && NoRender.INSTANCE.invisible.getValue()) {
            cir.setReturnValue((Object)false);
        }
    }

    @Inject(method={"isGlowing"}, at={@At(value="HEAD")}, cancellable=true)
    void isGlowingHook(CallbackInfoReturnable<Boolean> cir) {
        if (Shader.INSTANCE.isOn()) {
            cir.setReturnValue((Object)Shader.INSTANCE.shouldRender((class_1297)this));
        }
    }

    @ModifyArgs(method={"pushAwayFrom"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/Entity;addVelocity(DDD)V"))
    private void pushAwayFromHook(Args args) {
        if ((class_1297)this == class_310.method_1551().field_1724) {
            double value = 1.0;
            if (Velocity.INSTANCE.isOn() && Velocity.INSTANCE.entityPush.getValue()) {
                value = 0.0;
            }
            args.set(0, (Object)((Double)args.get(0) * value));
            args.set(1, (Object)((Double)args.get(1) * value));
            args.set(2, (Object)((Double)args.get(2) * value));
        }
    }

    @Inject(method={"isOnFire"}, at={@At(value="HEAD")}, cancellable=true)
    void isOnFireHook(CallbackInfoReturnable<Boolean> cir) {
        if (NoRender.INSTANCE.isOn() && NoRender.INSTANCE.fireEntity.getValue()) {
            cir.setReturnValue((Object)false);
        }
    }
}
