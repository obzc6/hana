/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 */
package dev.recollect.hana.mod.modules.impl.combat.dev;

import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.impl.combat.dev.ExtraOldTrap;
import dev.recollect.hana.mod.modules.impl.combat.dev.OldTrap;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import net.minecraft.class_2338;

public static class ExtraOldTrap.placePosition {
    public final Timer timer;
    public final Color posColor;
    public final FadeUtils firstFade;
    public final class_2338 pos;
    public boolean isAir;

    public ExtraOldTrap.placePosition(class_2338 class_23382) {
        ExtraOldTrap.placePosition a;
        ExtraOldTrap.placePosition a2 = class_23382;
        ExtraOldTrap.placePosition placePosition2 = a = this;
        ExtraOldTrap.placePosition placePosition3 = a;
        placePosition2.firstFade = new FadeUtils((long)OldTrap.INSTANCE.fadeTime.getValue());
        placePosition2.pos = a2;
        placePosition2.posColor = OldTrap.INSTANCE.color.getValue();
        a.timer = new Timer();
        a.isAir = true;
        a.timer.reset();
    }
}
