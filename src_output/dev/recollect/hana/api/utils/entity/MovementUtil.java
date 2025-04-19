/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 */
package dev.recollect.hana.api.utils.entity;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.asm.accessors.IVec3d;
import dev.recollect.hana.mod.modules.impl.movement.HoleSnap;
import java.util.Map;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_744;
import net.minecraft.class_746;

public class MovementUtil
implements Wrapper {
    private static final class_243 horizontalVelocity;
    private static final double diagonal;

    public static void setMotionY(double a) {
        ((IVec3d)MovementUtil.mc.field_1724.method_18798()).setY(a);
    }

    public static double getMotionY() {
        return MovementUtil.mc.field_1724.method_18798().field_1351;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static double[] directionSpeed(double a) {
        var2_1 = MovementUtil.mc.field_1724.field_3913.field_3905;
        var4_2 = MovementUtil.mc.field_1724.field_3913.field_3907;
        var3_3 = MovementUtil.mc.field_1724.field_5982 + (MovementUtil.mc.field_1724.method_36454() - MovementUtil.mc.field_1724.field_5982) * MovementUtil.mc.method_1488();
        if (var2_1 == 0.0f) ** GOTO lbl17
        if (var4_2 > 0.0f) {
            var3_3 += (float)(var2_1 > 0.0f ? -45 : 45);
        } else if (var4_2 < 0.0f) {
            var3_3 += (float)(var2_1 > 0.0f ? 45 : -45);
        }
        var4_2 = 0.0f;
        if (var2_1 > 0.0f) {
            var2_1 = 1.0f;
            v0 = var3_3;
        } else {
            if (var2_1 < 0.0f) {
                var2_1 = -1.0f;
            }
lbl17: // 4 sources:
            v0 = var3_3;
        }
        var5_4 = Math.sin(Math.toRadians(v0 + 90.0f));
        var7_5 = Math.cos(Math.toRadians(var3_3 + 90.0f));
        var9_6 = (double)var2_1 * a * var7_5 + (double)var4_2 * a * var5_4;
        var5_4 = (double)var2_1 * a * var5_4 - (double)var4_2 * a * var7_5;
        v1 = new double[2];
        v1[0] = var9_6;
        v1[1] = var5_4;
        return v1;
    }

    static {
        diagonal = 1.0 / Math.sqrt(2.0);
        horizontalVelocity = new class_243(0.0, 0.0, 0.0);
    }

    public static double getMotionX() {
        return MovementUtil.mc.field_1724.method_18798().field_1352;
    }

    public static double getSpeed(boolean a, double a2) {
        boolean bl = a;
        if (MovementUtil.mc.field_1724.method_6059(class_1294.field_5904)) {
            a = ((class_1293)MovementUtil.mc.field_1724.method_6088().get((Object)class_1294.field_5904)).method_5578();
            a2 *= 1.0 + 0.2 * (double)(a + 1);
        }
        if (bl && MovementUtil.mc.field_1724.method_6059(class_1294.field_5909)) {
            a = ((class_1293)MovementUtil.mc.field_1724.method_6088().get((Object)class_1294.field_5909)).method_5578();
            a2 /= 1.0 + 0.2 * (double)(a + 1);
        }
        if (MovementUtil.mc.field_1724.method_5715()) {
            a2 /= 5.0;
        }
        return a2;
    }

    public static boolean isJumping() {
        return MovementUtil.mc.field_1724.field_3913.field_3904;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static double[] forward(double a) {
        var2_1 = MovementUtil.mc.field_1724.field_3913.field_3905;
        var4_2 = MovementUtil.mc.field_1724.field_3913.field_3907;
        var3_3 = MovementUtil.mc.field_1724.method_36454();
        if (var2_1 == 0.0f) ** GOTO lbl17
        if (var4_2 > 0.0f) {
            var3_3 += (float)(var2_1 > 0.0f ? -45 : 45);
        } else if (var4_2 < 0.0f) {
            var3_3 += (float)(var2_1 > 0.0f ? 45 : -45);
        }
        var4_2 = 0.0f;
        if (var2_1 > 0.0f) {
            var2_1 = 1.0f;
            v0 = var3_3;
        } else {
            if (var2_1 < 0.0f) {
                var2_1 = -1.0f;
            }
lbl17: // 4 sources:
            v0 = var3_3;
        }
        var5_4 = Math.sin(Math.toRadians(v0 + 90.0f));
        var7_5 = Math.cos(Math.toRadians(var3_3 + 90.0f));
        var9_6 = (double)var2_1 * a * var7_5 + (double)var4_2 * a * var5_4;
        var5_4 = (double)var2_1 * a * var5_4 - (double)var4_2 * a * var7_5;
        v1 = new double[2];
        v1[0] = var9_6;
        v1[1] = var5_4;
        return v1;
    }

    public static void setMotionX(double a) {
        ((IVec3d)MovementUtil.mc.field_1724.method_18798()).setX(a);
    }

    public static boolean isMoving() {
        return (double)MovementUtil.mc.field_1724.field_3913.field_3905 != 0.0 || (double)MovementUtil.mc.field_1724.field_3913.field_3907 != 0.0 || HoleSnap.INSTANCE.isOn();
    }

    public MovementUtil() {
        MovementUtil a;
    }

    public static double getMotionZ() {
        return MovementUtil.mc.field_1724.method_18798().field_1350;
    }

    public static class_243 getHorizontalVelocity(double a) {
        float f = MovementUtil.mc.field_1724.method_36454();
        class_243 class_2432 = class_243.method_1030((float)0.0f, (float)f);
        class_243 class_2433 = class_243.method_1030((float)0.0f, (float)(f + 90.0f));
        double d = 0.0;
        double d2 = 0.0;
        boolean bl = false;
        if (MovementUtil.mc.field_1724.field_3913.field_3910) {
            d += class_2432.field_1352 / 20.0 * a;
            d2 += class_2432.field_1350 / 20.0 * a;
            bl = true;
        }
        if (MovementUtil.mc.field_1724.field_3913.field_3909) {
            d -= class_2432.field_1352 / 20.0 * a;
            d2 -= class_2432.field_1350 / 20.0 * a;
            bl = true;
        }
        boolean bl2 = false;
        if (MovementUtil.mc.field_1724.field_3913.field_3906) {
            d += class_2433.field_1352 / 20.0 * a;
            d2 += class_2433.field_1350 / 20.0 * a;
            bl2 = true;
        }
        if (MovementUtil.mc.field_1724.field_3913.field_3908) {
            d -= class_2433.field_1352 / 20.0 * a;
            d2 -= class_2433.field_1350 / 20.0 * a;
            bl2 = true;
        }
        if (bl && bl2) {
            d *= diagonal;
            d2 *= diagonal;
        }
        ((IVec3d)horizontalVelocity).setX(d);
        ((IVec3d)horizontalVelocity).setZ(d2);
        return horizontalVelocity;
    }

    public static void setMotionZ(double a) {
        ((IVec3d)MovementUtil.mc.field_1724.method_18798()).setZ(a);
    }

    public static float getMoveStrafe() {
        return MovementUtil.mc.field_1724.field_3913.field_3907;
    }

    public static double getJumpSpeed() {
        double d = 0.0;
        if (MovementUtil.mc.field_1724.method_6059(class_1294.field_5913)) {
            int n = ((class_1293)MovementUtil.mc.field_1724.method_6088().get((Object)class_1294.field_5913)).method_5578();
            d += (double)(n + 1) * 0.1;
        }
        return d;
    }

    public static double getSpeed(boolean a) {
        double d = 0.2873;
        return MovementUtil.getSpeed(a, d);
    }

    public static double getDistance2D() {
        double d = MovementUtil.mc.field_1724.method_23317() - MovementUtil.mc.field_1724.field_6014;
        double d2 = MovementUtil.mc.field_1724.method_23321() - MovementUtil.mc.field_1724.field_5969;
        double d3 = d;
        double d4 = d2;
        return Math.sqrt(d3 * d3 + d4 * d4);
    }

    public static float getMoveForward() {
        return MovementUtil.mc.field_1724.field_3913.field_3905;
    }
}
