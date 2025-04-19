/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_2338
 */
package dev.recollect.hana.api.utils.dev.hole;

import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import net.minecraft.class_1657;
import net.minecraft.class_2338;

public class HoleUtils {
    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).insert(0, stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 4 ^ (2 ^ 5);
        (3 ^ 5) << 4 ^ 1 << 1;
        int n4 = (2 ^ 5) << 4 ^ 4 << 1;
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

    /*
     * WARNING - void declaration
     */
    public static boolean isHole(class_2338 class_23382, int n, boolean bl) {
        void a;
        int a2 = bl;
        class_2338 a3 = class_23382;
        if (a2 != 0 && !HoleUtils.isBlock(a3.method_10074())) {
            return false;
        }
        int n2 = a2 = 0;
        while (n2 < a) {
            if (HoleUtils.isBlock(a3.method_10086(a2))) {
                return false;
            }
            n2 = ++a2;
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    public static Hole getHole(class_2338 class_23382, int n, boolean bl) {
        void a;
        boolean a2 = bl;
        class_2338 a3 = class_23382;
        return HoleUtils.getHole(a3, true, true, true, (int)a, a2);
    }

    public static Hole getHole(class_2338 a) {
        return HoleUtils.getHole(a, true, true, true, 3, true);
    }

    public HoleUtils() {
        HoleUtils a;
    }

    public static Hole getHole(class_2338 class_23382, int n) {
        int a = n;
        class_2338 a2 = class_23382;
        return HoleUtils.getHole(a2, a, true);
    }

    public static boolean inHole(class_1657 a) {
        class_1657 class_16572 = a;
        a = class_16572.method_24515();
        if (HoleUtils.getHole((class_2338)a, (int)1).type == Hole.HoleType.Single) {
            return true;
        }
        if (HoleUtils.getHole((class_2338)a, (int)1).type != Hole.HoleType.DoubleX && HoleUtils.getHole((class_2338)a.method_10069((int)-1, (int)0, (int)0), (int)1).type != Hole.HoleType.DoubleX) {
            if (HoleUtils.getHole((class_2338)a, (int)1).type != Hole.HoleType.DoubleZ && HoleUtils.getHole((class_2338)a.method_10069((int)0, (int)0, (int)-1), (int)1).type != Hole.HoleType.DoubleZ) {
                return HoleUtils.getHole((class_2338)a, (int)1).type == Hole.HoleType.Quad || HoleUtils.getHole((class_2338)a.method_10069((int)-1, (int)0, (int)-1), (int)1).type == Hole.HoleType.Quad || HoleUtils.getHole((class_2338)a.method_10069((int)-1, (int)0, (int)0), (int)1).type == Hole.HoleType.Quad || HoleUtils.getHole((class_2338)a.method_10069((int)0, (int)0, (int)-1), (int)1).type == Hole.HoleType.Quad;
            }
            return true;
        }
        return true;
    }

    static boolean isBlock(class_2338 a) {
        return OLEPOSSUtils.collidable(a);
    }

    /*
     * WARNING - void declaration
     */
    public static Hole getHole(class_2338 class_23382, boolean bl, boolean bl2, boolean bl3, int n, boolean bl4) {
        void a;
        void a2;
        class_2338 class_23383 = class_23382;
        if (!HoleUtils.isHole(class_23383, (int)a2, (boolean)a)) {
            return new Hole(class_23383, Hole.HoleType.NotHole);
        }
        if (HoleUtils.isBlock(class_23383.method_10067()) && HoleUtils.isBlock(class_23383.method_10095())) {
            boolean a3;
            void a4;
            void a5;
            void a6;
            boolean bl5 = HoleUtils.isHole(class_23383.method_10078(), (int)a2, (boolean)a) && HoleUtils.isBlock(class_23383.method_10078().method_10095()) && HoleUtils.isBlock(class_23383.method_10089(2));
            boolean bl6 = a3 = HoleUtils.isHole(class_23383.method_10072(), (int)a2, (boolean)a) && HoleUtils.isBlock(class_23383.method_10072().method_10067()) && HoleUtils.isBlock(class_23383.method_10077(2));
            if (a6 != false && !bl5 && !a3 && HoleUtils.isBlock(class_23383.method_10078()) && HoleUtils.isBlock(class_23383.method_10072())) {
                return new Hole(class_23383, Hole.HoleType.Single);
            }
            if (a5 != false && bl5 && a3 && HoleUtils.isHole(class_23383.method_10072().method_10078(), (int)a2, (boolean)a) && HoleUtils.isBlock(class_23383.method_10078().method_10078().method_10072()) && HoleUtils.isBlock(class_23383.method_10072().method_10072().method_10078())) {
                return new Hole(class_23383, Hole.HoleType.Quad);
            }
            if (a4 == false) {
                return new Hole(class_23383, Hole.HoleType.NotHole);
            }
            if (bl5 && !a3 && HoleUtils.isBlock(class_23383.method_10072()) && HoleUtils.isBlock(class_23383.method_10072().method_10078())) {
                return new Hole(class_23383, Hole.HoleType.DoubleX);
            }
            if (a3 && !bl5 && HoleUtils.isBlock(class_23383.method_10078()) && HoleUtils.isBlock(class_23383.method_10072().method_10078())) {
                return new Hole(class_23383, Hole.HoleType.DoubleZ);
            }
            return new Hole(class_23383, Hole.HoleType.NotHole);
        }
        return new Hole(class_23383, Hole.HoleType.NotHole);
    }
}
