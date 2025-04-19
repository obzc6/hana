/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.particle;

import dev.recollect.hana.api.utils.render.Render2DUtil;
import java.util.Random;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4587;

public class Snow {
    private int y;
    private int fallingSpeed;
    private int x;
    private int size;

    public void setY(int n) {
        int a = n;
        Snow a2 = this;
        a2.y = a;
    }

    public void drawSnow(class_332 class_3322) {
        Snow a;
        Object a2 = class_3322;
        Snow snow = a = this;
        Render2DUtil.drawRect(a2.method_51448(), (float)snow.getX(), (float)a.getY(), (float)a.size, (float)a.size, -1714829883);
        snow.setY(a.getY() + a.fallingSpeed);
        if (snow.getY() > class_310.method_1551().method_22683().method_4502() + 10 || a.getY() < -10) {
            a.setY(-10);
            a2 = new Random();
            a.fallingSpeed = ((Random)a2).nextInt(10) + 1;
            a.size = ((Random)a2).nextInt(4) + 1;
        }
    }

    public int getX() {
        Snow a;
        return a.x;
    }

    /*
     * WARNING - void declaration
     */
    public Snow(int n, int n2, int n3, int n4) {
        void a;
        void a2;
        void a3;
        void a4;
        Snow a5;
        int n5 = n4;
        Snow snow = a5 = this;
        Snow snow2 = a5;
        snow2.x = a4;
        snow2.y = a3;
        snow.fallingSpeed = a2;
        snow.size = a;
    }

    public int getY() {
        Snow a;
        return a.y;
    }

    public void setX(int n) {
        int a = n;
        Snow a2 = this;
        a2.x = a;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (3 ^ 5) << 4 ^ 1;
        (2 ^ 5) << 3 ^ 2;
        int n4 = (3 ^ 5) << 3 ^ 5;
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
