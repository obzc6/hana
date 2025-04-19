/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.impl.combat.Blocker;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_2338;

public static class Blocker.BlockerRenderer.placePosition {
    public boolean isAir;
    public final class_2338 pos;
    public final Timer timer;
    public final FadeUtils firstFade;

    public Blocker.BlockerRenderer.placePosition(class_2338 class_23382) {
        Blocker.BlockerRenderer.placePosition a;
        Blocker.BlockerRenderer.placePosition a2 = class_23382;
        Blocker.BlockerRenderer.placePosition placePosition2 = a = this;
        Blocker.BlockerRenderer.placePosition placePosition3 = a;
        placePosition3.firstFade = new FadeUtils((long)Blocker.INSTANCE.fadeTime.getValue());
        placePosition2.pos = a2;
        placePosition2.timer = new Timer();
        placePosition2.isAir = true;
    }
}
