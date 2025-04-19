/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_312
 *  net.minecraft.class_437
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_312.class})
public class MixinMouse
implements Wrapper {
    @Inject(method={"onMouseButton"}, at={@At(value="HEAD")})
    private void onMouseButton(long window, int button, int action, int mods, CallbackInfo ci) {
        if (button != 3 && button != 4) {
            return;
        }
        if (MixinMouse.mc.field_1755 instanceof ClickGuiScreen && action == 1 && Hana.MODULE.setBind(button)) {
            return;
        }
        if (action == 1) {
            Hana.MODULE.onKeyPressed(button);
        }
        if (action == 0) {
            Hana.MODULE.onKeyReleased(button);
        }
    }
}
