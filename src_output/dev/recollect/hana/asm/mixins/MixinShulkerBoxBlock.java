/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_1836
 *  net.minecraft.class_1922
 *  net.minecraft.class_2480
 *  net.minecraft.class_2561
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.mod.modules.impl.miscellaneous.ShulkerViewer;
import java.util.List;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1922;
import net.minecraft.class_2480;
import net.minecraft.class_2561;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_2480.class})
public class MixinShulkerBoxBlock {
    @Inject(method={"appendTooltip"}, at={@At(value="HEAD")}, cancellable=true)
    private void onAppendTooltip(class_1799 stack, class_1922 view, List<class_2561> tooltip, class_1836 options, CallbackInfo info) {
        if (ShulkerViewer.INSTANCE.isOn()) {
            info.cancel();
        }
    }
}
