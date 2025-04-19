/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1675
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_4050
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.api.utils.world;

import dev.recollect.hana.api.utils.Wrapper;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1675;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4050;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class InteractUtil
implements Wrapper {
    public InteractUtil() {
        InteractUtil a;
    }

    /*
     * WARNING - void declaration
     */
    public static class_239 getRtxTarget(float f, float f2, double d, double d2, double d3) {
        void a2;
        void a32;
        void a4;
        float a222 = f2;
        float a5 = f;
        class_239 class_2392 = InteractUtil.rayTrace(5.0, a5, a222, (double)a32, (double)a2, (double)a4);
        class_243 class_2432 = new class_243((double)a32, (double)a2, (double)a4).method_1031(0.0, (double)InteractUtil.mc.field_1724.method_18381(InteractUtil.mc.field_1724.method_18376()), 0.0);
        double d4 = 25.0;
        if (class_2392 != null) {
            d4 = class_2392.method_17784().method_1025(class_2432);
        }
        class_243 a222 = InteractUtil.getRotationVector(a5, a222);
        class_243 class_2433 = class_2432.method_1031(a222.field_1352 * 5.0, a222.field_1351 * 5.0, a222.field_1350 * 5.0);
        a222 = new class_238((double)(a32 - 0.3), (double)a2, (double)(a4 - 0.3), (double)(a32 + 0.3), (double)(a2 + (double)InteractUtil.mc.field_1724.method_18381(InteractUtil.mc.field_1724.method_18376())), (double)(a4 + 0.3)).method_18804(a222.method_1021(5.0)).method_1009(1.0, 1.0, 1.0);
        if ((a222 = class_1675.method_18075((class_1297)InteractUtil.mc.field_1724, (class_243)class_2432, (class_243)class_2433, (class_238)a222, a -> !a.method_7325() && a.method_5863(), (double)d4)) != null) {
            class_243 class_2434 = a222;
            class_2433 = class_2434.method_17782();
            class_243 a32 = class_2434.method_17784();
            if ((class_2432.method_1025(a32) < d4 || class_2392 == null) && class_2433 instanceof class_1309) {
                return a222;
            }
        }
        return class_2392;
    }

    private static /* synthetic */ class_243 getRotationVector(float f, float f2) {
        float a = f2;
        float a2 = f;
        return new class_243((double)(class_3532.method_15374((float)(-a * 0.017453292f)) * class_3532.method_15362((float)(a2 * 0.017453292f))), (double)(-class_3532.method_15374((float)(a2 * 0.017453292f))), (double)(class_3532.method_15362((float)(-a * 0.017453292f)) * class_3532.method_15362((float)(a2 * 0.017453292f))));
    }

    /*
     * WARNING - void declaration
     */
    public static class_239 rayTrace(double d, float f, float f2, double d2, double d3, double d4) {
        void a;
        void a22;
        double a3;
        void a4;
        float a5 = f2;
        float a322 = f;
        class_243 a22 = new class_243((double)a22, (double)a4, (double)a);
        class_243 a322 = InteractUtil.getRotationVector(a5, a322);
        a322 = a22.method_1031(a322.field_1352 * a3, a322.field_1351 * a3, a322.field_1350 * a3);
        return InteractUtil.mc.field_1687.method_17742(new class_3959(a22, a322, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)InteractUtil.mc.field_1724));
    }
}
