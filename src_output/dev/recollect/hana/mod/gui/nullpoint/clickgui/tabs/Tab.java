/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs;

import java.awt.Color;
import net.minecraft.class_310;
import net.minecraft.class_332;

public abstract class Tab {
    protected class_310 mc = class_310.method_1551();
    protected int x;
    protected int height;
    public static final int defaultHeight = 15;
    protected int y;
    protected int width;

    public void setY(int n) {
        int a = n;
        Tab a2 = this;
        a2.y = a;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).insert(0, stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (3 ^ 5) << 4 ^ 3 << 1;
        2 << 3 ^ 5;
        int n4 = 5;
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

    public void setX(int n) {
        int a = n;
        Tab a2 = this;
        a2.x = a;
    }

    public int getX() {
        Tab a;
        return a.x;
    }

    public abstract void draw(class_332 var1, float var2, Color var3);

    /*
     * WARNING - void declaration
     */
    public void moveWindow(int n, int n2) {
        void a;
        Tab a2;
        int a3 = n2;
        Tab tab = a2 = this;
        tab.x -= a;
        tab.y -= a3;
    }

    public void setHeight(int n) {
        int a = n;
        Tab a2 = this;
        a2.height = a;
    }

    public int getHeight() {
        Tab a;
        return a.height;
    }

    public abstract void update(double var1, double var3, boolean var5);

    public int getWidth() {
        Tab a;
        return a.width;
    }

    public void setWidth(int n) {
        int a = n;
        Tab a2 = this;
        a2.width = a;
    }

    public Tab() {
        Tab a;
    }

    public int getY() {
        Tab a;
        return a.y;
    }
}
