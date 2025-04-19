/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.utils.entity;

import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.mod.modules.settings.SwingSide;

static class EntityUtil.1 {
    static final /* synthetic */ int[] $SwitchMap$dev$recollect$hana$mod$modules$settings$SwingSide;

    static {
        $SwitchMap$dev$recollect$hana$mod$modules$settings$SwingSide = new int[SwingSide.values().length];
        try {
            EntityUtil.1.$SwitchMap$dev$recollect$hana$mod$modules$settings$SwingSide[SwingSide.All.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EntityUtil.1.$SwitchMap$dev$recollect$hana$mod$modules$settings$SwingSide[SwingSide.Client.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EntityUtil.1.$SwitchMap$dev$recollect$hana$mod$modules$settings$SwingSide[SwingSide.Server.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
