/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.miscellaneous.AutoPearl;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.xibao.Snow;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_746;

public class PearlPhase
extends Module {
    public final BooleanSetting bypass;
    public final BooleanSetting autoYaw;
    public static PearlPhase INSTANCE;

    public PearlPhase() {
        PearlPhase a;
        PearlPhase pearlPhase = a;
        PearlPhase pearlPhase2 = a;
        super(WebUtils.ALLATORIxDEMO("\u00035o?J&fw("), Module.Category.Misc);
        PearlPhase pearlPhase3 = a;
        pearlPhase3.autoYaw = pearlPhase2.add(new BooleanSetting(Snow.ALLATORIxDEMO("Aw}Bgz"), true));
        pearlPhase.bypass = pearlPhase2.add(new BooleanSetting(WebUtils.ALLATORIxDEMO("\u0011c>fw>"), true));
        pearlPhase.setChinese(Snow.ALLATORIxDEMO("\u73dd\u73fb\u7a79\u5894"));
        INSTANCE = pearlPhase;
    }

    private /* synthetic */ double roundToClosest(double a, double a2, double a3) {
        double d = a - a2;
        if (a3 - a > d) {
            return a2;
        }
        return a3;
    }

    @Override
    public void onEnable() {
        PearlPhase a;
        float f;
        PearlPhase pearlPhase;
        PearlPhase pearlPhase2 = a;
        if (PearlPhase.nullCheck()) {
            pearlPhase2.disable();
            return;
        }
        a = new class_243(PearlPhase.mc.field_1724.method_23317() + class_3532.method_15350((double)(pearlPhase2.roundToClosest(PearlPhase.mc.field_1724.method_23317(), Math.floor(PearlPhase.mc.field_1724.method_23317()) + 0.241, Math.floor(PearlPhase.mc.field_1724.method_23317()) + 0.759) - PearlPhase.mc.field_1724.method_23317()), (double)-0.03, (double)0.03), PearlPhase.mc.field_1724.method_23318(), PearlPhase.mc.field_1724.method_23321() + class_3532.method_15350((double)(pearlPhase2.roundToClosest(PearlPhase.mc.field_1724.method_23321(), Math.floor(PearlPhase.mc.field_1724.method_23321()) + 0.241, Math.floor(PearlPhase.mc.field_1724.method_23321()) + 0.759) - PearlPhase.mc.field_1724.method_23321()), (double)-0.03, (double)0.03));
        if (pearlPhase2.autoYaw.getValue()) {
            f = EntityUtil.getLegitRotations((class_243)a)[0];
            pearlPhase = pearlPhase2;
        } else {
            f = PearlPhase.mc.field_1724.method_36454();
            pearlPhase = pearlPhase2;
        }
        AutoPearl.INSTANCE.throwPearl(f, pearlPhase.bypass.getValue() ? 89.0f : 80.0f);
        pearlPhase2.disable();
    }
}
