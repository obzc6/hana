/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_757
 *  net.minecraft.class_898
 *  org.joml.Matrix4f
 */
package dev.recollect.hana.api.utils.render;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.render.ColorUtil;
import java.awt.Color;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_757;
import net.minecraft.class_898;
import org.joml.Matrix4f;

public class JelloUtil
implements Wrapper {
    private static float prevCircleStep;
    private static float circleStep;

    public static void updateJello() {
        prevCircleStep = circleStep;
        circleStep += 0.15f;
    }

    private static /* synthetic */ double absSinAnimation(double a) {
        return Math.abs(1.0 + Math.sin(a)) / 2.0;
    }

    /*
     * WARNING - void declaration
     */
    public static void drawJello(class_4587 class_45872, class_1297 class_12972, Color color) {
        int n;
        class_4587 a = class_12972;
        class_4587 a2 = class_45872;
        double d = prevCircleStep + (circleStep - prevCircleStep) * mc.method_1488();
        double d2 = JelloUtil.absSinAnimation(d - 0.44999998807907104);
        d = JelloUtil.absSinAnimation(d);
        class_4587 class_45873 = a;
        double d3 = class_45873.field_6014 + (a.method_23317() - a.field_6014) * (double)mc.method_1488() - JelloUtil.mc.method_1561().field_4686.method_19326().method_10216();
        class_4587 class_45874 = a;
        d2 = class_45873.field_6036 + (class_45874.method_23318() - a.field_6036) * (double)mc.method_1488() - JelloUtil.mc.method_1561().field_4686.method_19326().method_10214() + d2 * (double)a.method_17682();
        double d4 = class_45874.field_5969 + (a.method_23321() - a.field_5969) * (double)mc.method_1488() - JelloUtil.mc.method_1561().field_4686.method_19326().method_10215();
        d = class_45873.field_6036 + (a.method_23318() - a.field_6036) * (double)mc.method_1488() - JelloUtil.mc.method_1561().field_4686.method_19326().method_10214() + d * (double)a.method_17682();
        a2.method_22903();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        class_289 class_2892 = class_289.method_1348();
        class_287 class_2872 = class_2892.method_1349();
        RenderSystem.setShader(class_757::method_34540);
        class_2872.method_1328(class_293.class_5596.field_27380, class_290.field_1576);
        int n2 = n = 0;
        while (n2 <= 30) {
            void a3;
            float f = (float)(d3 + Math.cos((double)n * 6.28 / 30.0) * (a.method_5829().field_1320 - a.method_5829().field_1323 + (a.method_5829().field_1324 - a.method_5829().field_1321)) * 0.5);
            float f2 = (float)(d4 + Math.sin((double)n * 6.28 / 30.0) * (a.method_5829().field_1320 - a.method_5829().field_1323 + (a.method_5829().field_1324 - a.method_5829().field_1321)) * 0.5);
            class_287 class_2873 = class_2872;
            class_2873.method_22918(a2.method_23760().method_23761(), f, (float)d, f2).method_39415(a3.getRGB()).method_1344();
            class_2873.method_22918(a2.method_23760().method_23761(), f, (float)d2, f2).method_39415(ColorUtil.injectAlpha((Color)a3, 0).getRGB()).method_1344();
            n2 = ++n;
        }
        class_2892.method_1350();
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        a2.method_22909();
    }

    public JelloUtil() {
        JelloUtil a;
    }
}
