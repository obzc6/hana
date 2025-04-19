/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1267
 */
package dev.recollect.hana.api.utils.combat;

import dev.recollect.hana.api.utils.combat.MioExplosionUtil;
import net.minecraft.class_1267;

static class MioExplosionUtil.1 {
    static final /* synthetic */ int[] $SwitchMap$net$minecraft$world$Difficulty;

    static {
        $SwitchMap$net$minecraft$world$Difficulty = new int[class_1267.values().length];
        try {
            MioExplosionUtil.1.$SwitchMap$net$minecraft$world$Difficulty[class_1267.field_5801.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            MioExplosionUtil.1.$SwitchMap$net$minecraft$world$Difficulty[class_1267.field_5805.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            MioExplosionUtil.1.$SwitchMap$net$minecraft$world$Difficulty[class_1267.field_5807.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
