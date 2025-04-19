/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_3532
 *  net.minecraft.class_4050
 */
package dev.recollect.hana.api.utils.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1309;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_3532;
import net.minecraft.class_4050;

public class MathUtil {
    public MathUtil() {
        MathUtil a;
    }

    public static double square(double a) {
        double d = a;
        return d * d;
    }

    public static double random(double a, double a2) {
        return (float)(Math.random() * (a2 - a) + a);
    }

    public static double clamp(double a, double a2, double a3) {
        if (a < a2) {
            return a2;
        }
        return Math.min(a, a3);
    }

    public static float rad(float a) {
        return (float)((double)a * 3.141592653589793 / 180.0);
    }

    public static float random(float f, float f2) {
        float a = f2;
        float a2 = f;
        return (float)(Math.random() * (double)(a - a2) + (double)a2);
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> a, boolean a22) {
        Map<K, V> map = a;
        a = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        if (a22) {
            a.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        } else {
            a.sort(Map.Entry.comparingByValue());
        }
        LinkedHashMap a22 = new LinkedHashMap();
        Iterator iterator = a = ((AbstractSequentialList)((Object)a)).iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)a.next();
            iterator = a;
            a22.put(entry.getKey(), entry.getValue());
        }
        return a22;
    }

    public static double interpolate(double a, double a2, float a3) {
        double d = a;
        return d + (a2 - d) * (double)a3;
    }

    public static class_2350 getFacingOrder(float a, float a2) {
        class_2350 class_23502;
        float f = a;
        a = -f * 0.017453292f;
        float f2 = class_3532.method_15374((float)(a2 *= 0.017453292f));
        a2 = class_3532.method_15362((float)a2);
        float f3 = class_3532.method_15374((float)a);
        a = class_3532.method_15362((float)a);
        boolean bl = f3 > 0.0f;
        boolean bl2 = f2 < 0.0f;
        boolean bl3 = a > 0.0f;
        float f4 = bl ? f3 : -f3;
        f3 = bl2 ? -f2 : f2;
        f2 = bl3 ? a : -a;
        a = f4 * a2;
        a2 = f2 * a2;
        class_2350 class_23503 = bl ? class_2350.field_11034 : class_2350.field_11039;
        class_2350 class_23504 = bl2 ? class_2350.field_11036 : class_2350.field_11033;
        class_2350 class_23505 = class_23502 = bl3 ? class_2350.field_11035 : class_2350.field_11043;
        if (f4 > f2) {
            if (f3 > a) {
                return class_23504;
            }
            return class_23503;
        }
        if (f3 > a2) {
            return class_23504;
        }
        return class_23502;
    }

    public static float round(float f, int n) {
        int a = n;
        float a2 = f;
        if (a < 0) {
            throw new IllegalArgumentException();
        }
        return BigDecimal.valueOf(a2).setScale(a, RoundingMode.FLOOR).floatValue();
    }

    public static class_2350 getDirectionFromEntityLiving(class_2338 class_23382, class_1309 class_13092) {
        class_2338 a = class_13092;
        class_2338 a2 = class_23382;
        if (Math.abs(a.method_23317() - ((double)a2.method_10263() + 0.5)) < 2.0 && Math.abs(a.method_23321() - ((double)a2.method_10260() + 0.5)) < 2.0) {
            double d;
            class_2338 class_23383 = a;
            double d2 = a.method_23318() + (double)class_23383.method_18381(class_23383.method_18376());
            if (d - (double)a2.method_10264() > 2.0) {
                return class_2350.field_11036;
            }
            if ((double)a2.method_10264() - d2 > 0.0) {
                return class_2350.field_11033;
            }
        }
        return a.method_5735().method_10153();
    }

    /*
     * WARNING - void declaration
     */
    public static float clamp(float f, float f2, float f3) {
        void a;
        float a2 = f;
        float a3 = f2;
        if (a2 < a3) {
            return a3;
        }
        return Math.min(a2, (float)a);
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).insert(0, stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 1;
        1 << 3 ^ 3;
        int n4 = 3 << 3 ^ 5;
        int n5 = a2 = string2.length() - 1;
        String string3 = string2;
        while (n2 >= 0) {
            int n6 = n2--;
            arrc[n6] = (char)(n4 ^ (string.charAt(n6) ^ string3.charAt(a2)));
            if (n2 < 0) break;
            int n7 = n2--;
            char c = arrc[n7] = (char)(n3 ^ (string.charAt(n7) ^ string3.charAt(a2)));
            if (--a2 < 0) {
                int a2 = n5;
            }
            int n8 = n2;
        }
        return new String(arrc);
    }
}
