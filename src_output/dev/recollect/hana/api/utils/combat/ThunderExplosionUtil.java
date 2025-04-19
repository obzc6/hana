/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1267
 *  net.minecraft.class_1280
 *  net.minecraft.class_1282
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1320
 *  net.minecraft.class_1324
 *  net.minecraft.class_1656
 *  net.minecraft.class_1657
 *  net.minecraft.class_1890
 *  net.minecraft.class_1927
 *  net.minecraft.class_1927$class_4179
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_5134
 *  net.minecraft.class_638
 *  net.minecraft.class_8109
 */
package dev.recollect.hana.api.utils.combat;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.asm.accessors.IExplosion;
import java.util.Objects;
import net.minecraft.class_1267;
import net.minecraft.class_1280;
import net.minecraft.class_1282;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1320;
import net.minecraft.class_1324;
import net.minecraft.class_1656;
import net.minecraft.class_1657;
import net.minecraft.class_1890;
import net.minecraft.class_1927;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_5134;
import net.minecraft.class_638;
import net.minecraft.class_8109;

public class ThunderExplosionUtil
implements Wrapper {
    public static final class_1927 explosion = new class_1927((class_1937)ThunderExplosionUtil.mc.field_1687, null, 0.0, 0.0, 0.0, 6.0f, false, class_1927.class_4179.field_18687);

    /*
     * WARNING - void declaration
     */
    public static float calculateDamage(class_2338 class_23382, class_1657 class_16572, class_1657 class_16573, float f) {
        void a;
        void a2;
        float a3 = f;
        class_2338 a4 = class_23382;
        return ThunderExplosionUtil.calculateDamage(a4.method_46558().method_1031(0.0, -0.5, 0.0), (class_1657)a2, (class_1657)a, a3);
    }

    public ThunderExplosionUtil() {
        ThunderExplosionUtil a;
    }

    public static float anchorDamage(class_2338 a4, class_1657 a2, class_1657 a3) {
        class_2338 class_23382 = a4;
        if (BlockUtil.getBlock(class_23382) == class_2246.field_23152) {
            CombatUtil.modifyPos = class_23382;
            CombatUtil.modifyBlockState = class_2246.field_10124.method_9564();
            float a4 = ThunderExplosionUtil.calculateDamage(CombatUtil.modifyPos.method_46558(), a2, a3, 5.0f);
            CombatUtil.modifyPos = null;
            return a4;
        }
        return ThunderExplosionUtil.calculateDamage(class_23382.method_46558(), a2, a3, 5.0f);
    }

    /*
     * WARNING - void declaration
     */
    public static float calculateDamage(class_243 class_2432, class_1657 class_16572, class_1657 class_16573, float f) {
        void a5;
        void a2;
        class_243 a32 = class_16573;
        class_243 a4 = class_2432;
        if (ThunderExplosionUtil.mc.field_1687.method_8407() == class_1267.field_5801) {
            return 0.0f;
        }
        if (a2.method_31549().field_7477) {
            return 0.0f;
        }
        if (a32 == null) {
            a32 = a2;
        }
        ((IExplosion)explosion).setWorld((class_1937)ThunderExplosionUtil.mc.field_1687);
        ((IExplosion)explosion).setX(a4.field_1352);
        ((IExplosion)explosion).setY(a4.field_1351);
        ((IExplosion)explosion).setZ(a4.field_1350);
        ((IExplosion)explosion).setPower((float)a5);
        if (!new class_238((double)class_3532.method_15357((double)(a4.field_1352 - 11.0)), (double)class_3532.method_15357((double)(a4.field_1351 - 11.0)), (double)class_3532.method_15357((double)(a4.field_1350 - 11.0)), (double)class_3532.method_15357((double)(a4.field_1352 + 13.0)), (double)class_3532.method_15357((double)(a4.field_1351 + 13.0)), (double)class_3532.method_15357((double)(a4.field_1350 + 13.0))).method_994(a32.method_5829())) {
            return 0.0f;
        }
        if (!a2.method_5659(explosion) && !a2.method_5655()) {
            double d;
            double d2 = (double)class_3532.method_15355((float)((float)a32.method_5707(a4))) / 12.0;
            if (d <= 1.0) {
                class_243 class_2433 = a32;
                double d3 = class_2433.method_23317() - a4.field_1352;
                double d4 = class_2433.method_23318() - a4.field_1351;
                double d5 = class_2433.method_23317() - a4.field_1350;
                double d6 = d3;
                double d7 = d4;
                double d8 = d5;
                if ((double)class_3532.method_15355((float)((float)(d6 * d6 + d7 * d7 + d8 * d8))) != 0.0) {
                    float f2;
                    d3 = class_1927.method_17752((class_243)a4, (class_1297)a32);
                    d2 = (1.0 - d2) * d3;
                    float a32 = (float)Math.floor((d2 * d2 + d2) / 2.0 * 7.0 * 12.0 + 1.0);
                    if (ThunderExplosionUtil.mc.field_1687.method_8407() == class_1267.field_5805) {
                        f2 = a32 = Math.min(a32 / 2.0f + 1.0f, a32);
                    } else {
                        if (ThunderExplosionUtil.mc.field_1687.method_8407() == class_1267.field_5807) {
                            a32 = a32 * 3.0f / 2.0f;
                        }
                        f2 = a32;
                    }
                    a32 = class_1280.method_5496((float)f2, (float)a2.method_6096(), (float)((float)Objects.requireNonNull(a2.method_5996(class_5134.field_23725)).method_6194()));
                    if (a2.method_6059(class_1294.field_5907)) {
                        int a5 = 25 - (Objects.requireNonNull(a2.method_6112(class_1294.field_5907)).method_5578() + 1) * 5;
                        a32 = Math.max(a32 * (float)a5 / 25.0f, 0.0f);
                    }
                    if (a32 <= 0.0f) {
                        a32 = 0.0f;
                        return 0.0f;
                    }
                    int a5 = class_1890.method_8219((Iterable)a2.method_5661(), (class_1282)ThunderExplosionUtil.mc.field_1687.method_48963().method_48807(explosion));
                    if (a5 > 0) {
                        a32 = class_1280.method_5497((float)a32, (float)a5);
                    }
                    return a32;
                }
            }
        }
        return 0.0f;
    }
}
