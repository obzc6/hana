/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1713
 *  net.minecraft.class_1723
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_636
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player;

import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1723;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_636;
import net.minecraft.class_746;

public class Replenish
extends Module {
    private final Timer timer;
    private final SliderSetting min;
    private final SliderSetting delay;

    private /* synthetic */ boolean replenish(int n) {
        int n2;
        int a22 = n;
        Replenish a = this;
        class_1799 a22 = Replenish.mc.field_1724.method_31548().method_5438(a22);
        if (a22.method_7960()) {
            return false;
        }
        if (!a22.method_7946()) {
            return false;
        }
        if ((double)a22.method_7947() >= a.min.getValue()) {
            return false;
        }
        if (a22.method_7947() == a22.method_7914()) {
            return false;
        }
        int n3 = n2 = 9;
        while (n3 < 36) {
            class_1799 class_17992 = Replenish.mc.field_1724.method_31548().method_5438(n2);
            if (!class_17992.method_7960() && a.canMerge(a22, class_17992)) {
                Replenish.mc.field_1761.method_2906(Replenish.mc.field_1724.field_7498.field_7763, n2, 0, class_1713.field_7794, (class_1657)Replenish.mc.field_1724);
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    @Override
    public void onUpdate() {
        Replenish a;
        Replenish replenish = a;
        if (Replenish.mc.field_1755 != null && !(Replenish.mc.field_1755 instanceof ClickGuiScreen)) {
            return;
        }
        Replenish replenish2 = replenish;
        if (!replenish2.timer.passedMs((long)(replenish2.delay.getValue() * 1000.0))) {
            return;
        }
        int n = a = 0;
        while (n < 9) {
            if (replenish.replenish(a)) {
                replenish.timer.reset();
                return;
            }
            n = ++a;
        }
    }

    public Replenish() {
        Replenish a;
        Replenish replenish = a;
        super(BlockUpUtil.ALLATORIxDEMO("HGmIVn\u0001%"), Module.Category.Player);
        Replenish replenish2 = a;
        replenish2.delay = replenish.add(new SliderSetting(WebUtils.ALLATORIxDEMO("^+ke4"), 0.5, 0.0, 4.0, 0.01));
        a.min = replenish.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("J\u001b#"), 16, 1, 64));
        a.timer = new Timer();
        a.setChinese(WebUtils.ALLATORIxDEMO("\u81f7\u52fb\u887f\u510b\u4efc\u52a5\u6842"));
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean canMerge(class_1799 class_17992, class_1799 class_17993) {
        void a;
        Replenish a2 = class_17993;
        Replenish a3 = this;
        return a.method_7909() == a2.method_7909() && a.method_7964().equals((Object)a2.method_7964());
    }
}
