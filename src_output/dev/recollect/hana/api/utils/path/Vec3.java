/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 */
package dev.recollect.hana.api.utils.path;

import net.minecraft.class_243;

public class Vec3 {
    private final double x;
    private final double z;
    private final double y;

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (2 ^ 5) << 4 ^ (3 << 2 ^ 1);
        (2 ^ 5) << 3 ^ 3;
        int n4 = 2 << 3 ^ (2 ^ 5);
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

    public double squareDistanceTo(Vec3 vec3) {
        Vec3 a = vec3;
        Vec3 a2 = this;
        return Math.pow(a.x - a2.x, 2.0) + Math.pow(a.y - a2.y, 2.0) + Math.pow(a.z - a2.z, 2.0);
    }

    public String toString() {
        Vec3 a;
        return "[" + a.x + ";" + a.y + ";" + a.z + "]";
    }

    public double getX() {
        Vec3 a;
        return a.x;
    }

    public Vec3 add(Vec3 vec3) {
        Vec3 a = vec3;
        Vec3 a2 = this;
        return a2.addVector(a.getX(), a.getY(), a.getZ());
    }

    public double getY() {
        Vec3 a;
        return a.y;
    }

    public Vec3 floor() {
        Vec3 a;
        return new Vec3(Math.floor(a.x), Math.floor(a.y), Math.floor(a.z));
    }

    public double getZ() {
        Vec3 a;
        return a.z;
    }

    public Vec3(double a, double a2, double a3) {
        Vec3 a4;
        Vec3 vec3 = a4;
        a4.x = a;
        vec3.y = a2;
        vec3.z = a3;
    }

    public Vec3 addVector(double a, double a2, double a3) {
        Vec3 a4;
        return new Vec3(a4.x + a, a4.y + a2, a4.z + a3);
    }

    public class_243 mc() {
        Vec3 a;
        return new class_243(a.x, a.y, a.z);
    }
}
