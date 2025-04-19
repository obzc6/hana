/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1657
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2824
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.api.utils.combat;

import dev.recollect.hana.api.managers.FriendManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.settings.SwingSide;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1657;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2824;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class CombatUtil
implements Wrapper {
    public static class_2338 modifyPos;
    public static final Timer breakTimer;
    public static class_2680 modifyBlockState;
    public static boolean terrainIgnore;

    public static boolean isDoubleHole(class_2338 a) {
        class_2338 class_23382 = a;
        a = CombatUtil.is3Block(class_23382);
        if (a != null) {
            class_23382 = class_23382.method_10093((class_2350)a);
            a = CombatUtil.is3Block(class_23382);
            return a != null;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public static class_243 getMotionVecWithY(class_1297 class_12972, int n, boolean bl) {
        class_1297 a;
        void a2;
        int a3 = n;
        class_1297 class_12973 = a = class_12972;
        double d = class_12973.method_23317() - a.field_6014;
        class_1297 class_12974 = a;
        double d2 = class_12973.method_23318() - class_12974.field_6036;
        double d3 = class_12974.method_23321() - a.field_5969;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        if (a2 != false) {
            double d7;
            double d8 = d7 = 1.0;
            while (d8 <= (double)a3) {
                class_1297 class_12975 = a;
                if (!CombatUtil.mc.field_1687.method_39454(class_12975, class_12975.method_5829().method_997(new class_243(d * d7, d2 * d7, d3 * d7)))) {
                    d4 = d * d7;
                    d5 = d2 * d7;
                    d6 = d3 * d7;
                    d8 = d7 + 0.5;
                    continue;
                }
                break;
            }
        } else {
            d4 = d * (double)a3;
            d5 = d2 * (double)a3;
            d6 = d3 * (double)a3;
        }
        return new class_243(d4, d5, d6);
    }

    public static void attackCrystal(class_2338 a, boolean a2, boolean a3) {
        class_2338 class_23382 = a;
        a = CombatUtil.mc.field_1687.method_18467(class_1511.class, new class_238(class_23382)).iterator();
        if (a.hasNext()) {
            CombatUtil.attackCrystal((class_1297)((class_1511)a.next()), a2, a3);
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean isValid(class_1297 a, double a2) {
        class_1297 class_12972 = a;
        if (class_12972 == null) return false;
        if (!class_12972.method_5805()) return false;
        if (class_12972.equals((Object)CombatUtil.mc.field_1724)) return false;
        if (class_12972 instanceof class_1657) {
            if (FriendManager.isFriend(class_12972.method_5477().getString())) return false;
        }
        if (!(CombatUtil.mc.field_1724.method_5858(class_12972) > MathUtil.square(a2))) return true;
        return false;
    }

    public static List<class_1657> getEnemies(double a) {
        Iterator iterator;
        ArrayList<class_1657> arrayList = new ArrayList<class_1657>();
        Iterator iterator2 = iterator = CombatUtil.mc.field_1687.method_18456().iterator();
        while (iterator2.hasNext()) {
            class_1657 class_16572 = (class_1657)iterator.next();
            if (!CombatUtil.isValid((class_1297)class_16572, a)) {
                iterator2 = iterator;
                continue;
            }
            arrayList.add(class_16572);
            iterator2 = iterator;
        }
        return arrayList;
    }

    public static class_1657 getClosestEnemy(double a) {
        Iterator<class_1657> iterator;
        class_1657 class_16572 = null;
        Iterator<class_1657> iterator2 = iterator = CombatUtil.getEnemies(a).iterator();
        while (iterator2.hasNext()) {
            class_1657 class_16573 = iterator.next();
            if (class_16572 == null) {
                class_16572 = class_16573;
                iterator2 = iterator;
                continue;
            }
            if (!(CombatUtil.mc.field_1724.method_33571().method_1025(class_16573.method_19538()) < CombatUtil.mc.field_1724.method_5858((class_1297)class_16572))) {
                iterator2 = iterator;
                continue;
            }
            class_16572 = class_16573;
            iterator2 = iterator;
        }
        return class_16572;
    }

    public CombatUtil() {
        CombatUtil a;
    }

    public static boolean isHard(class_2338 a) {
        class_2338 class_23382 = a;
        a = BlockUtil.getState(class_23382).method_26204();
        return a == class_2246.field_10540 || a == class_2246.field_22108 || a == class_2246.field_10443 || a == class_2246.field_9987 || a == class_2246.field_10535;
    }

    public static class_243 getEntityPosVecWithY(class_1657 class_16572, int n) {
        int a = n;
        class_1657 a2 = class_16572;
        if (a <= 0) {
            return a2.method_19538();
        }
        return a2.method_19538().method_1019(CombatUtil.getMotionVecWithY((class_1297)a2, a, true));
    }

    /*
     * WARNING - void declaration
     */
    public static class_243 getMotionVec(class_1297 class_12972, float f, boolean bl) {
        class_1297 a;
        void a2;
        float a3 = f;
        class_1297 class_12973 = a = class_12972;
        double d = a.method_23317() - class_12973.field_6014;
        double d2 = class_12973.method_23321() - a.field_5969;
        double d3 = 0.0;
        double d4 = 0.0;
        if (a2 != false) {
            double d5;
            double d6 = d5 = 1.0;
            while (d6 <= (double)a3) {
                class_1297 class_12974 = a;
                if (!CombatUtil.mc.field_1687.method_39454(class_12974, class_12974.method_5829().method_997(new class_243(d * d5, 0.0, d2 * d5)))) {
                    d3 = d * d5;
                    d4 = d2 * d5;
                    d6 = d5 + 0.5;
                    continue;
                }
                break;
            }
        } else {
            d3 = d * (double)a3;
            d4 = d2 * (double)a3;
        }
        return new class_243(d3, 0.0, d4);
    }

    /*
     * WARNING - void declaration
     */
    public static void attackCrystal(class_1297 class_12972, boolean bl, boolean bl2) {
        boolean a = bl2;
        class_1297 a2 = class_12972;
        if (!breakTimer.passedMs((long)(CombatSetting.INSTANCE.attackDelay.getValue() * 1000.0))) {
            return;
        }
        if (a && EntityUtil.isUsing()) {
            return;
        }
        if (a2 != null) {
            void a3;
            breakTimer.reset();
            if (a3 != false && CombatSetting.INSTANCE.attackRotate.getValue()) {
                EntityUtil.faceVector(new class_243(a2.method_23317(), a2.method_23318() + 0.25, a2.method_23321()));
            }
            CombatUtil.mc.field_1724.field_3944.method_52787((class_2596)class_2824.method_34206((class_1297)a2, (boolean)CombatUtil.mc.field_1724.method_5715()));
            CombatUtil.mc.field_1724.method_7350();
            EntityUtil.swingHand(class_1268.field_5808, CombatSetting.INSTANCE.swingMode.getValue());
        }
    }

    static {
        terrainIgnore = false;
        modifyBlockState = class_2246.field_10124.method_9564();
        breakTimer = new Timer();
    }

    public static class_2350 is3Block(class_2338 a) {
        int n;
        class_2338 class_23382 = a;
        if (!CombatUtil.isHard(class_23382.method_10074())) {
            return null;
        }
        if (!(BlockUtil.isAir(class_23382) && BlockUtil.isAir(class_23382.method_10084()) && BlockUtil.isAir(class_23382.method_10086(2)))) {
            return null;
        }
        int n2 = 0;
        class_2338 class_23383 = null;
        class_2350[] arrclass_2350 = class_2350.values();
        int n3 = arrclass_2350.length;
        int n4 = n = 0;
        while (n4 < n3) {
            a = arrclass_2350[n];
            if (a != class_2350.field_11036 && a != class_2350.field_11033) {
                if (CombatUtil.isHard(class_23382.method_10093((class_2350)a))) {
                    ++n2;
                } else {
                    int n5;
                    int n6 = 0;
                    class_2350[] arrclass_23502 = class_2350.values();
                    int n7 = arrclass_23502.length;
                    int n8 = n5 = 0;
                    while (n8 < n7) {
                        class_2350 class_23502 = arrclass_23502[n5];
                        if (class_23502 != class_2350.field_11033 && class_23502 != a.method_10153() && CombatUtil.isHard(class_23382.method_10093((class_2350)a).method_10093(class_23502))) {
                            ++n6;
                        }
                        n8 = ++n5;
                    }
                    if (n6 == 4) {
                        ++n2;
                    } else {
                        class_23383 = a;
                    }
                }
            }
            n4 = ++n;
        }
        if (n2 == 3) {
            return class_23383;
        }
        return null;
    }

    public static void attackCrystal(class_238 a, boolean a2, boolean a3) {
        class_238 class_2382 = a;
        a = CombatUtil.mc.field_1687.method_18467(class_1511.class, class_2382).iterator();
        if (a.hasNext()) {
            CombatUtil.attackCrystal((class_1297)((class_1511)a.next()), a2, a3);
            return;
        }
    }

    public static class_243 getEntityPosVec(class_1657 class_16572, int n) {
        int a = n;
        class_1657 a2 = class_16572;
        if (a <= 0) {
            return a2.method_19538();
        }
        return a2.method_19538().method_1019(CombatUtil.getMotionVec((class_1297)a2, a, true));
    }

    public static class_2338 getHole(float a4, boolean a2, boolean a3) {
        float f = a4;
        class_2338 class_23382 = null;
        double d = f + 1.0f;
        for (class_2338 a4 : BlockUtil.getSphere(f)) {
            if (!BlockUtil.isHole(a4, true, true, a3) && (!a2 || !CombatUtil.isDoubleHole(a4))) continue;
            double d2 = class_3532.method_15355((float)((float)CombatUtil.mc.field_1724.method_5649((double)a4.method_10263() + 0.5, (double)a4.method_10264() + 0.5, (double)a4.method_10260() + 0.5)));
            if (class_23382 != null && !(d2 < d)) continue;
            class_23382 = a4;
            d = d2;
        }
        return class_23382;
    }
}
