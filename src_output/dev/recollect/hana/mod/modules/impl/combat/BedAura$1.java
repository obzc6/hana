/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.mod.modules.impl.combat.AnchorAura;
import dev.recollect.hana.mod.modules.impl.combat.BedAura;

static class BedAura.1 {
    static final /* synthetic */ int[] $SwitchMap$dev$recollect$hana$mod$modules$impl$combat$AnchorAura$CalcMode;

    static {
        $SwitchMap$dev$recollect$hana$mod$modules$impl$combat$AnchorAura$CalcMode = new int[AnchorAura.CalcMode.values().length];
        try {
            BedAura.1.$SwitchMap$dev$recollect$hana$mod$modules$impl$combat$AnchorAura$CalcMode[AnchorAura.CalcMode.Meteor.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BedAura.1.$SwitchMap$dev$recollect$hana$mod$modules$impl$combat$AnchorAura$CalcMode[AnchorAura.CalcMode.Thunder.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BedAura.1.$SwitchMap$dev$recollect$hana$mod$modules$impl$combat$AnchorAura$CalcMode[AnchorAura.CalcMode.OyVey.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            BedAura.1.$SwitchMap$dev$recollect$hana$mod$modules$impl$combat$AnchorAura$CalcMode[AnchorAura.CalcMode.Edit.ordinal()] = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
