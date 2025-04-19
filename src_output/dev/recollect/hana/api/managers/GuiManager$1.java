/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.mod.modules.impl.client.UIModule;

static class GuiManager.1 {
    static final /* synthetic */ int[] $SwitchMap$dev$recollect$hana$mod$modules$impl$client$UIModule$Mode;

    static {
        $SwitchMap$dev$recollect$hana$mod$modules$impl$client$UIModule$Mode = new int[UIModule.Mode.values().length];
        try {
            GuiManager.1.$SwitchMap$dev$recollect$hana$mod$modules$impl$client$UIModule$Mode[UIModule.Mode.Pull.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            GuiManager.1.$SwitchMap$dev$recollect$hana$mod$modules$impl$client$UIModule$Mode[UIModule.Mode.Scale.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            GuiManager.1.$SwitchMap$dev$recollect$hana$mod$modules$impl$client$UIModule$Mode[UIModule.Mode.Scissor.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
