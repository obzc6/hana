/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.player.dev;

import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.movement.ElytraFly;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import org.bytedeco.javacv.BaseSettings;

public class OffFirework
extends Module {
    public static OffFirework INSTANCE;
    public final BooleanSetting inventory;

    @Override
    public void onEnable() {
        OffFirework a;
        TipUtils.lol();
        if (OffFirework.nullCheck()) {
            a.disable();
            return;
        }
        OffFirework offFirework = a;
        offFirework.off();
        offFirework.disable();
    }

    public void off() {
        ElytraFly.INSTANCE.fireworkTimer.reset();
    }

    public OffFirework() {
        OffFirework a;
        OffFirework offFirework = a;
        super(BaseSettings.ALLATORIxDEMO("QZohrDf\\q@l"), Module.Category.Player);
        OffFirework offFirework2 = a;
        offFirework2.inventory = offFirework.add(new BooleanSetting(TipUtils.ALLATORIxDEMO("%zM$\u00002\u00063\u0017\u000f\u0004wI"), true));
        INSTANCE = offFirework;
    }
}
