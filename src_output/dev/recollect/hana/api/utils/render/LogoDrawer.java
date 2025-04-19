/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_332
 */
package dev.recollect.hana.api.utils.render;

import dev.recollect.hana.api.utils.math.WebUtils;
import net.minecraft.class_2960;
import net.minecraft.class_332;

public class LogoDrawer {
    public static final class_2960 LOGO_TEXTURE = new class_2960(WebUtils.ALLATORIxDEMO("=~<t`wj*"));

    public LogoDrawer() {
        LogoDrawer a;
    }

    /*
     * WARNING - void declaration
     */
    public static void draw(class_332 class_3322, int n, int n2, float f) {
        void a;
        void a2;
        class_332 a3;
        int a4 = n2;
        class_332 class_3323 = a3 = class_3322;
        class_3323.method_51422(1.0f, 1.0f, 1.0f, (float)a2);
        a = a / 2 - 25;
        a4 = a4 / 4 - 25;
        class_3323.method_25290(LOGO_TEXTURE, (int)a, a4, 0.0f, 0.0f, 50, 50, 50, 50);
        class_3323.method_51422(1.0f, 1.0f, 1.0f, 1.0f);
    }
}
