/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import org.bytedeco.javacv.BaseSettings;

public class Timer
extends Module {
    public static Timer INSTANCE;
    public final SliderSetting multiplier;

    public Timer() {
        Timer a;
        Timer timer = a;
        Timer timer2 = a;
        super(BaseSettings.ALLATORIxDEMO("UUdNl"), Module.Category.Misc);
        Timer timer3 = a;
        timer3.multiplier = timer2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("]PtHIHb\u0017)"), 1.0, 0.1, 5.0, 0.01));
        timer.setDescription(BaseSettings.ALLATORIxDEMO("VTlNlTsPs\u0018y_g\u001czFfI}\np\u0011b@Q^`Ws]o_0"));
        timer.setChinese(BlockUpUtil.ALLATORIxDEMO("\u53df\u906d\u5625"));
        INSTANCE = timer;
    }

    @Override
    public void onUpdate() {
        Hana.TIMER.tryReset();
    }

    @Override
    public void onDisable() {
        Hana.TIMER.reset();
    }

    @Override
    public void onEnable() {
        Hana.TIMER.reset();
    }
}
