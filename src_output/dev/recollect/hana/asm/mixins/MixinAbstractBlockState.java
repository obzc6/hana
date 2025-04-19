/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4970
 *  net.minecraft.class_4970$class_4971
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.Ambience;
import dev.recollect.hana.mod.modules.impl.render.dev.XRay;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_4970;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_4970.class_4971.class})
public class MixinAbstractBlockState {
    @Inject(method={"getLuminance"}, at={@At(value="HEAD")}, cancellable=true)
    public void getLuminanceHook(CallbackInfoReturnable<Integer> cir) {
        if (Module.nullCheck()) {
            return;
        }
        if (XRay.INSTANCE.isOn()) {
            cir.setReturnValue((Object)15);
        } else if (Ambience.INSTANCE.customLuminance.getValue()) {
            cir.setReturnValue((Object)Ambience.INSTANCE.luminance.getValueInt());
        }
    }
}
