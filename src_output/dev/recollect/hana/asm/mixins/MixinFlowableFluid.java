/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2350
 *  net.minecraft.class_3609
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.mod.modules.impl.movement.Velocity;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import java.util.Iterator;
import net.minecraft.class_2350;
import net.minecraft.class_3609;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_3609.class})
public class MixinFlowableFluid {
    @Redirect(method={"getVelocity"}, at=@At(value="INVOKE", target="Ljava/util/Iterator;hasNext()Z", ordinal=0))
    private boolean getVelocity_hasNext(Iterator<class_2350> var9) {
        if (Velocity.INSTANCE.isOn() && Velocity.INSTANCE.waterPush.getValue()) {
            return false;
        }
        return var9.hasNext();
    }
}
