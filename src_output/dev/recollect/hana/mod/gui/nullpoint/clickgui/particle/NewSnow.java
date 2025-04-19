/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.particle;

import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.utils.render.TextUtil;
import java.util.Random;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_332;

public class NewSnow {
    private int horizontalSpeed;
    private int size;
    private int x;
    private int y;
    private int fallingSpeed;
    private static final Random rand = new Random();

    public int getY() {
        NewSnow a;
        return a.y;
    }

    /*
     * WARNING - void declaration
     */
    public NewSnow(int n, int n2, int n3, int n4, int n5) {
        void a;
        void a2;
        NewSnow a3;
        void a4;
        void a5;
        int n6 = n4;
        NewSnow newSnow = a3 = this;
        NewSnow newSnow2 = a3;
        newSnow2.x = a4;
        newSnow2.y = a2;
        newSnow.fallingSpeed = a5;
        newSnow.size = a;
        newSnow.horizontalSpeed = rand.nextInt(3) - 1;
    }

    public void setX(int n) {
        int a = n;
        NewSnow a2 = this;
        a2.x = a;
    }

    public int getX() {
        NewSnow a;
        return a.x;
    }

    public void drawNewSnow(class_332 class_3322) {
        NewSnow a;
        NewSnow a2 = class_3322;
        NewSnow newSnow = a = this;
        TextUtil.drawString((class_332)a2, FPSManager.ALLATORIxDEMO("\u272c"), (double)newSnow.getX(), (double)a.getY(), -1714829883);
        NewSnow newSnow2 = a;
        newSnow2.setY(a.getY() + a.fallingSpeed);
        newSnow.setX(newSnow2.getX() + a.horizontalSpeed);
        if (newSnow2.getY() > class_310.method_1551().method_22683().method_4502() + 10 || a.getY() < -10) {
            a.resetSnow();
        }
        if (a.getX() < -10 || a.getX() > class_310.method_1551().method_22683().method_4486() + 10) {
            a.setX(rand.nextInt(class_310.method_1551().method_22683().method_4486()));
        }
    }

    private /* synthetic */ void resetSnow() {
        NewSnow a;
        a.setY(-10);
        a.fallingSpeed = rand.nextInt(10) + 1;
        a.size = rand.nextInt(4) + 1;
        a.horizontalSpeed = rand.nextInt(3) - 1;
    }

    public void setY(int n) {
        int a = n;
        NewSnow a2 = this;
        a2.y = a;
    }
}
