/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.miscellaneous.AutoPearl;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_746;

public class PearlClip
extends Module {
    public static PearlClip INSTANCE;
    public final BooleanSetting bypass;
    public final BooleanSetting autoYaw;

    private /* synthetic */ double roundToClosest(double a, double a2, double a3) {
        double d = a - a2;
        if (a3 - a > d) {
            return a2;
        }
        return a3;
    }

    public PearlClip() {
        PearlClip a;
        PearlClip pearlClip = a;
        PearlClip pearlClip2 = a;
        super(HoleUtils.ALLATORIxDEMO("DaZYxm}^x"), Module.Category.Misc);
        PearlClip pearlClip3 = a;
        pearlClip3.autoYaw = pearlClip2.add(new BooleanSetting(Tab.ALLATORIxDEMO("*z\u0018}(9L"), true));
        pearlClip.bypass = pearlClip2.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("im^pD{"), true));
        pearlClip.setChinese(Tab.ALLATORIxDEMO("\u73df\u7391\u5339\u58a2"));
        INSTANCE = pearlClip;
    }

    @Override
    public void onEnable() {
        PearlClip pearlClip;
        PearlClip a;
        float f;
        PearlClip pearlClip2 = a;
        if (PearlClip.nullCheck()) {
            pearlClip2.disable();
            return;
        }
        a = new class_243(PearlClip.mc.field_1724.method_23317() + class_3532.method_15350((double)(pearlClip2.roundToClosest(PearlClip.mc.field_1724.method_23317(), Math.floor(PearlClip.mc.field_1724.method_23317()) + 0.241, Math.floor(PearlClip.mc.field_1724.method_23317()) + 0.759) - PearlClip.mc.field_1724.method_23317()), (double)-0.03, (double)0.03), PearlClip.mc.field_1724.method_23318(), PearlClip.mc.field_1724.method_23321() + class_3532.method_15350((double)(pearlClip2.roundToClosest(PearlClip.mc.field_1724.method_23321(), Math.floor(PearlClip.mc.field_1724.method_23321()) + 0.241, Math.floor(PearlClip.mc.field_1724.method_23321()) + 0.759) - PearlClip.mc.field_1724.method_23321()), (double)-0.03, (double)0.03));
        if (pearlClip2.autoYaw.getValue()) {
            f = EntityUtil.getLegitRotations((class_243)a)[0];
            pearlClip = pearlClip2;
        } else {
            f = PearlClip.mc.field_1724.method_36454();
            pearlClip = pearlClip2;
        }
        AutoPearl.INSTANCE.throwPearl(f, pearlClip.bypass.getValue() ? 89.0f : 80.0f);
        pearlClip2.disable();
    }
}
