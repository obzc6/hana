/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import net.minecraft.class_1657;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseChildSettings;

public class OldVClip
extends Module {
    final SliderSetting yDown;
    final BooleanSetting noWeb;
    public static OldVClip INSTANCE;

    @Override
    public void onUpdate() {
        OldVClip oldVClip = this;
        if (OldVClip.mc.field_1724 == null) {
            return;
        }
        if (oldVClip.noWeb.getValue() && OldVClip.isInWeb((class_1657)OldVClip.mc.field_1724)) {
            return;
        }
        double d = OldVClip.mc.field_1724.method_23317();
        double d2 = Math.round(OldVClip.mc.field_1724.method_23318());
        double d3 = OldVClip.mc.field_1724.method_23321();
        boolean a = OldVClip.mc.field_1724.method_24828();
        OldVClip.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(d, d2, d3, a));
        OldVClip oldVClip2 = oldVClip;
        double d4 = oldVClip2.yDown.getValue() / 400.0;
        OldVClip.mc.field_1724.method_5814(d, d2 -= d4, d3);
        OldVClip.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(d, d2, d3, a));
        OldVClip.mc.field_1724.method_5814(d, d2 -= d4 * 300.0, d3);
        OldVClip.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(d, d2, d3, a));
        oldVClip2.disable();
    }

    public OldVClip() {
        OldVClip a;
        OldVClip oldVClip = a;
        OldVClip oldVClip2 = a;
        super(BaseChildSettings.ALLATORIxDEMO("o8C\u0005y\"\u0019t"), Module.Category.Movement);
        OldVClip oldVClip3 = a;
        oldVClip3.noWeb = oldVClip2.add(new BooleanSetting(RenderHelper.ALLATORIxDEMO("[\u0018_X "), true));
        oldVClip.yDown = oldVClip2.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("*~!\u0007j"), 0.0, 0.0, 10.0, 1.0));
        oldVClip.setChinese(RenderHelper.ALLATORIxDEMO("\u65f2\u7ec2\u5419\u7a42\u58db"));
        INSTANCE = oldVClip;
    }

    public static boolean isInWeb(class_1657 a222) {
        int n;
        class_1657 class_16572 = a222;
        class_243 class_2432 = class_16572.method_19538();
        float[] arrf = new float[3];
        arrf[0] = 0.0f;
        arrf[1] = 0.3f;
        arrf[2] = -0.3f;
        float[] arrf2 = arrf;
        int n2 = arrf.length;
        int n3 = n = 0;
        while (n3 < n2) {
            int n4;
            float f = arrf2[n];
            float[] arrf3 = new float[3];
            arrf3[0] = 0.0f;
            arrf3[1] = 0.3f;
            arrf3[2] = -0.3f;
            float[] arrf4 = arrf3;
            int n5 = arrf3.length;
            int n6 = n4 = 0;
            while (n6 < n5) {
                int n7;
                float f2 = arrf4[n4];
                int[] arrn = new int[3];
                arrn[0] = 0;
                arrn[1] = 1;
                arrn[2] = 2;
                int[] arrn2 = arrn;
                int n8 = arrn.length;
                int n9 = n7 = 0;
                while (n9 < n8) {
                    int a222 = arrn2[n7];
                    class_1657 a222 = new class_2338((int)(class_2432.method_10216() + (double)f), (int)(class_2432.method_10214() + (double)a222), (int)(class_2432.method_10215() + (double)f2));
                    if (OldVClip.mc.field_1687.method_8320((class_2338)a222).method_26204() == class_2246.field_10343) {
                        return true;
                    }
                    n9 = ++n7;
                }
                n6 = ++n4;
            }
            n3 = ++n;
        }
        return false;
    }
}
