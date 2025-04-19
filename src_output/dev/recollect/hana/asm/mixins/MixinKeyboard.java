/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_309
 *  net.minecraft.class_310
 *  net.minecraft.class_364
 *  net.minecraft.class_4071
 *  net.minecraft.class_437
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.class_1041;
import net.minecraft.class_309;
import net.minecraft.class_310;
import net.minecraft.class_364;
import net.minecraft.class_4071;
import net.minecraft.class_437;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_309.class})
public class MixinKeyboard
implements Wrapper {
    @Shadow
    @Final
    private class_310 field_1678;

    @Inject(method={"onKey"}, at={@At(value="HEAD")})
    private void onKey(long windowPointer, int key, int scanCode, int action, int modifiers, CallbackInfo ci) {
        if (MixinKeyboard.mc.field_1755 instanceof ClickGuiScreen && action == 1 && Hana.MODULE.setBind(key)) {
            return;
        }
        if (action == 1) {
            Hana.MODULE.onKeyPressed(key);
        }
        if (action == 0) {
            Hana.MODULE.onKeyReleased(key);
        }
    }

    @Inject(method={"onChar"}, at={@At(value="HEAD")}, cancellable=true)
    private void onChar(long window, int codePoint, int modifiers, CallbackInfo ci) {
        class_437 element;
        if (window == this.field_1678.method_22683().method_4490() && (element = this.field_1678.field_1755) != null && this.field_1678.method_18506() == null) {
            if (Character.charCount(codePoint) == 1) {
                if (!Module.nullCheck() && Hana.GUI != null && Hana.GUI.isClickGuiOpen()) {
                    Hana.MODULE.modules.forEach(module -> module.getSettings().stream().filter(setting -> setting instanceof StringSetting).map(setting -> (StringSetting)setting).filter(StringSetting::isListening).forEach(setting -> setting.charType((char)codePoint)));
                }
                class_437.method_25412(() -> MixinKeyboard.lambda$onChar$4((class_364)element, codePoint, modifiers), (String)"charTyped event handler", (String)element.getClass().getCanonicalName());
            } else {
                char[] var6;
                for (char c : var6 = Character.toChars(codePoint)) {
                    if (!Module.nullCheck() && Hana.GUI != null && Hana.GUI.isClickGuiOpen()) {
                        Hana.MODULE.modules.forEach(module -> module.getSettings().stream().filter(setting -> setting instanceof StringSetting).map(setting -> (StringSetting)setting).filter(StringSetting::isListening).forEach(setting -> setting.charType(c)));
                    }
                    class_437.method_25412(() -> MixinKeyboard.lambda$onChar$9((class_364)element, c, modifiers), (String)"charTyped event handler", (String)element.getClass().getCanonicalName());
                }
            }
        }
        ci.cancel();
    }

    private static /* synthetic */ void lambda$onChar$9(class_364 element, char c, int modifiers) {
        element.method_25400(c, modifiers);
    }

    private static /* synthetic */ void lambda$onChar$4(class_364 element, int codePoint, int modifiers) {
        element.method_25400((char)codePoint, modifiers);
    }
}
