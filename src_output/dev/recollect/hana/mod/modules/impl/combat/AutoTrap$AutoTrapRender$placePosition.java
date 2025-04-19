/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.impl.combat.AutoTrap;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import net.minecraft.class_2338;

public static class AutoTrap.AutoTrapRender.placePosition {
    public boolean isAir;
    public final Timer timer;
    public final class_2338 pos;
    public final Color posColor;
    public final FadeUtils firstFade;

    public AutoTrap.AutoTrapRender.placePosition(class_2338 class_23382) {
        AutoTrap.AutoTrapRender.placePosition a;
        AutoTrap.AutoTrapRender.placePosition a2 = class_23382;
        AutoTrap.AutoTrapRender.placePosition placePosition2 = a = this;
        AutoTrap.AutoTrapRender.placePosition placePosition3 = a;
        placePosition2.firstFade = new FadeUtils((long)AutoTrap.INSTANCE.fadeTime.getValue());
        placePosition2.pos = a2;
        placePosition2.posColor = AutoTrap.INSTANCE.color.getValue();
        a.timer = new Timer();
        a.isAir = true;
        a.timer.reset();
    }
}
