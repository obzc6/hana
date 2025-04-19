/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1267
 *  net.minecraft.class_1291
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1320
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1887
 *  net.minecraft.class_1890
 *  net.minecraft.class_1893
 *  net.minecraft.class_1927
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_5134
 *  net.minecraft.class_638
 */
package dev.recollect.hana.api.utils.combat;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import net.minecraft.class_1267;
import net.minecraft.class_1291;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1320;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_1927;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_5134;
import net.minecraft.class_638;

public class WinkExplosionUtil
implements Wrapper {
    private static final float CRYSTAL_POWER = 6.0f;

    public static float getBlastReduction(class_1309 class_13092, float f) {
        float a = f;
        class_1309 a2 = class_13092;
        if (a2 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)a2;
            float f2 = WinkExplosionUtil.getPlayerExplosionResistance(class_16572);
            class_1657 class_16573 = class_16572;
            a = WinkExplosionUtil.getDamageAfterAbsorb(a, class_16573.method_6096(), (float)class_16572.method_26825(class_5134.field_23725));
            float f3 = class_3532.method_15363((float)WinkExplosionUtil.getProtectionAmount(class_16572.method_5661()), (float)0.0f, (float)20.0f);
            a *= 1.0f - f3 / 25.0f;
            a *= 1.0f - f2;
            if (class_16573.method_6059(class_1294.field_5907)) {
                float f4 = a;
                a = f4 - f4 / 4.0f;
            }
            a = Math.max(a, 0.0f);
            return a;
        }
        a = WinkExplosionUtil.getDamageAfterAbsorb(a, a2.method_6096(), (float)a2.method_26825(class_5134.field_23725));
        return a;
    }

    /*
     * WARNING - void declaration
     */
    public static float calculateDamage(double d, double d2, double d3, class_1297 class_12972, class_1297 class_12973, float f) {
        class_1297 a32;
        void a22;
        double a;
        float a4;
        double a5;
        class_1297 class_12974 = class_12972;
        class_12972 = class_12973;
        class_1297 a6 = class_12974;
        if (a32 == null) {
            a32 = a6;
        }
        a4 = 2.0f * a4;
        double d4 = (double)class_3532.method_15355((float)((float)a32.method_5649(a, a5, (double)a22))) / (double)a4;
        class_243 class_2432 = new class_243(a, a5, (double)a22);
        a5 = 0.0;
        try {
            a5 = class_1927.method_17752((class_243)class_2432, (class_1297)a32);
        }
        catch (Exception a22) {
            // empty catch block
        }
        double a22 = (1.0 - d4) * a5;
        float a32 = (float)((a22 * a22 + a22) / 2.0 * 7.0 * (double)a4 + 1.0);
        a32 = (float)((double)a32 * Math.pow(1.0 - d4, 2.0));
        a5 = 1.0;
        if (a6 instanceof class_1309) {
            a5 = WinkExplosionUtil.getBlastReduction((class_1309)a6, WinkExplosionUtil.getDamageMultiplied(a32));
        }
        return (float)a5;
    }

    public static float getPlayerExplosionResistance(class_1657 a) {
        return 0.5f;
    }

    public static float predictCrystalDamageAtPos(class_2338 a, class_1297 a2) {
        class_2338 class_23382 = a;
        a = class_243.method_24953((class_2382)class_23382);
        return WinkExplosionUtil.calculateCrystalDamage(a.field_1352, a.field_1351, a.field_1350, a2);
    }

    public static int getProtectionAmount(Iterable<class_1799> a2) {
        Iterable<class_1799> iterable = a2;
        int a2 = 0;
        for (class_1799 class_17992 : iterable) {
            int n = class_1890.method_8225((class_1887)class_1893.field_9111, (class_1799)class_17992);
            if (n == 0) {
                a2 += class_1890.method_8225((class_1887)class_1893.field_9107, (class_1799)class_17992) * 2;
                continue;
            }
            a2 += n;
        }
        return a2;
    }

    public WinkExplosionUtil() {
        WinkExplosionUtil a;
    }

    public static float calculateCrystalDamage(double a, double a2, double a3, class_1297 a4) {
        return WinkExplosionUtil.calculateDamage(a, a2, a3, a4, null, 6.0f);
    }

    public static float anchorDamage(class_2338 a4, class_1657 a2, class_1657 a3) {
        class_2338 class_23382 = a4;
        if (BlockUtil.getBlock(class_23382) == class_2246.field_23152) {
            CombatUtil.modifyPos = class_23382;
            CombatUtil.modifyBlockState = class_2246.field_10124.method_9564();
            float a4 = WinkExplosionUtil.calculateDamage(CombatUtil.modifyPos.method_46558().method_10216(), class_23382.method_46558().method_10214(), class_23382.method_46558().method_10215(), (class_1297)a2, (class_1297)a3, 5.0f);
            CombatUtil.modifyPos = null;
            return a4;
        }
        return WinkExplosionUtil.calculateDamage(class_23382.method_46558().method_10216(), class_23382.method_46558().method_10214(), class_23382.method_46558().method_10215(), (class_1297)a2, (class_1297)a3, 5.0f);
    }

    public static float getDamageAfterAbsorb(float f, float f2, float f3) {
        float a;
        float a2 = f2;
        float a3 = f;
        a = 2.0f + a / 4.0f;
        a2 = class_3532.method_15363((float)(a2 - a3 / a), (float)(a2 * 0.2f), (float)20.0f);
        return a3 * (1.0f - a2 / 25.0f);
    }

    public static float getDamageMultiplied(float a2) {
        float f = a2;
        int a2 = WinkExplosionUtil.mc.field_1687.method_8407().method_5461();
        return f * (a2 == 0 ? 0.0f : (a2 == 2 ? 1.2f : (a2 == 1 ? 0.4f : 1.8f)));
    }
}
