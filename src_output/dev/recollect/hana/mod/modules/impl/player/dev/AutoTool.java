/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1661
 *  net.minecraft.class_1799
 *  net.minecraft.class_1887
 *  net.minecraft.class_1890
 *  net.minecraft.class_1893
 *  net.minecraft.class_2189
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_239
 *  net.minecraft.class_2680
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3965
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player.dev;

import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.modules.Module;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_2189;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_239;
import net.minecraft.class_2680;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3965;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class AutoTool
extends Module {
    public static int getTool(class_2338 a2) {
        int n;
        class_2338 class_23382 = a2;
        int n2 = -1;
        float f = 1.0f;
        int n3 = n = 0;
        while (n3 < 9) {
            a2 = AutoTool.mc.field_1724.method_31548().method_5438(n);
            if (a2 != class_1799.field_8037) {
                float f2 = class_1890.method_8225((class_1887)class_1893.field_9131, (class_1799)a2);
                float a2 = a2.method_7924(AutoTool.mc.field_1687.method_8320(class_23382));
                if (AutoTool.mc.field_1687.method_8320(class_23382).method_26204() instanceof class_2189) {
                    return -1;
                }
                if (f2 + a2 > f) {
                    f = f2 + a2;
                    n2 = n;
                }
            }
            n3 = ++n;
        }
        return n2;
    }

    @Override
    public void onUpdate() {
        AutoTool a;
        AutoTool autoTool = a;
        a = AutoTool.mc.field_1765;
        if (!(a instanceof class_3965)) {
            return;
        }
        class_3965 class_39652 = (class_3965)a;
        a = class_39652.method_17777();
        if (AutoTool.mc.field_1687.method_22347((class_2338)a)) {
            return;
        }
        int n = AutoTool.getTool((class_2338)a);
        if (n != -1 && AutoTool.mc.field_1690.field_1886.method_1434()) {
            AutoTool.mc.field_1724.method_31548().field_7545 = n;
        }
    }

    public AutoTool() {
        super(MathUtil.ALLATORIxDEMO("\u0014<\u001a\u001d:\u001d\u0002\u001d"), Module.Category.Player);
        AutoTool a;
    }
}
