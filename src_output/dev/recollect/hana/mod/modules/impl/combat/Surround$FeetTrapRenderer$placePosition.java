/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.impl.combat.Surround;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_2338;

public static class Surround.FeetTrapRenderer.placePosition {
    public boolean isAir;
    public final Timer timer;
    public final FadeUtils firstFade;
    public final class_2338 pos;

    public Surround.FeetTrapRenderer.placePosition(class_2338 class_23382) {
        Surround.FeetTrapRenderer.placePosition a;
        Surround.FeetTrapRenderer.placePosition a2 = class_23382;
        Surround.FeetTrapRenderer.placePosition placePosition2 = a = this;
        Surround.FeetTrapRenderer.placePosition placePosition3 = a;
        placePosition3.firstFade = new FadeUtils((long)Surround.INSTANCE.fadeTime.getValue());
        placePosition2.pos = a2;
        placePosition2.timer = new Timer();
        placePosition2.isAir = true;
    }
}
