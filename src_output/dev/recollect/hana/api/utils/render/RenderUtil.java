/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_286
 *  net.minecraft.class_287
 *  net.minecraft.class_287$class_7433
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
 *  net.minecraft.class_761
 *  net.minecraft.class_7833
 *  net.minecraft.class_898
 *  org.joml.Matrix4f
 *  org.joml.Quaternionf
 */
package dev.recollect.hana.api.utils.render;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.Wrapper;
import java.awt.Color;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_757;
import net.minecraft.class_761;
import net.minecraft.class_7833;
import net.minecraft.class_898;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

public class RenderUtil
implements Wrapper {
    /*
     * WARNING - void declaration
     */
    protected static void drawHorizontalLine(class_4587 class_45872, float f, float f2, float f3, int n) {
        float a;
        void a2;
        void a3;
        float a4 = f2;
        class_4587 a5 = class_45872;
        if (a4 < a) {
            void v0 = a;
            a = a4;
            a4 = v0;
        }
        void v1 = a2;
        RenderUtil.rectFilled(a5, a, (float)v1, a4 + 1.0f, (float)(v1 + 1.0f), (int)a3);
    }

    /*
     * WARNING - void declaration
     */
    protected static void drawHorizontalLine(class_4587 class_45872, float f, float f2, float f3, int n, float f4) {
        float a;
        void a2;
        void a3;
        void a4;
        float a5 = f2;
        class_4587 a6 = class_45872;
        if (a5 < a) {
            void v0 = a;
            a = a5;
            a5 = v0;
        }
        void v1 = a2;
        RenderUtil.rectFilled(a6, a, (float)v1, a5 + a3, (float)(v1 + a3), (int)a4);
    }

    public static void setup3D() {
        RenderUtil.setup();
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask((boolean)false);
        RenderSystem.disableCull();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawBox(class_4587 class_45872, class_2338 class_23382, Color color, double d) {
        void a;
        void a2;
        Object a3 = color;
        class_4587 a4 = class_45872;
        RenderUtil.drawBox(a4, new class_238((class_2338)a), (Color)a3, (double)a2);
    }

    public static class_4587 matrixFrom(class_243 a) {
        class_243 class_2432 = a;
        class_4587 class_45872 = new class_4587();
        a = RenderUtil.mc.field_1773.method_19418();
        class_4587 class_45873 = class_45872;
        class_45872.method_22907(class_7833.field_40714.rotationDegrees(a.method_19329()));
        class_45873.method_22907(class_7833.field_40716.rotationDegrees(a.method_19330() + 180.0f));
        class_45873.method_22904(class_2432.method_10216() - a.method_19326().field_1352, class_2432.method_10214() - a.method_19326().field_1351, class_2432.method_10215() - a.method_19326().field_1350);
        return class_45873;
    }

    /*
     * WARNING - void declaration
     */
    protected static void drawVerticalLine(class_4587 class_45872, float f, float f2, float f3, int n) {
        float a;
        void a2;
        void a3;
        float a4 = f3;
        class_4587 a5 = class_45872;
        if (a4 < a) {
            void v0 = a;
            a = a4;
            a4 = v0;
        }
        void v1 = a2;
        RenderUtil.rectFilled(a5, (float)v1, (float)(a + 1.0f), (float)(v1 + 1.0f), a4, (int)a3);
    }

    /*
     * WARNING - void declaration
     */
    protected static void drawVerticalLine(class_4587 class_45872, float f, float f2, float f3, int n, float f4) {
        float a;
        void a2;
        void a3;
        void a4;
        float a5 = f3;
        class_4587 a6 = class_45872;
        if (a5 < a) {
            void v0 = a;
            a = a5;
            a5 = v0;
        }
        void v1 = a2;
        RenderUtil.rectFilled(a6, (float)v1, (float)(a + a3), (float)(v1 + a3), a5, (int)a4);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawBox(class_4587 class_45872, class_238 class_2382, Color color, double d) {
        void a;
        void a22;
        Color a3 = color;
        class_4587 a4 = class_45872;
        void v0 = a22;
        float a22 = (float)(v0.field_1323 - RenderUtil.mc.method_1561().field_4686.method_19326().method_10216());
        float f = (float)(v0.field_1322 - RenderUtil.mc.method_1561().field_4686.method_19326().method_10214());
        float f2 = (float)(v0.field_1321 - RenderUtil.mc.method_1561().field_4686.method_19326().method_10215());
        float f3 = (float)(v0.field_1320 - RenderUtil.mc.method_1561().field_4686.method_19326().method_10216());
        float f4 = (float)(v0.field_1325 - RenderUtil.mc.method_1561().field_4686.method_19326().method_10214());
        float f5 = (float)(v0.field_1324 - RenderUtil.mc.method_1561().field_4686.method_19326().method_10215());
        class_289 class_2892 = class_289.method_1348();
        class_287 class_2872 = class_2892.method_1349();
        RenderUtil.setup3D();
        RenderSystem.lineWidth((float)((float)a));
        RenderSystem.setShader(class_757::method_34535);
        RenderSystem.defaultBlendFunc();
        class_287 class_2873 = class_2872;
        class_2873.method_1328(class_293.class_5596.field_27377, class_290.field_29337);
        class_761.method_22980((class_4587)a4, (class_4588)class_2873, (double)a22, (double)f, (double)f2, (double)f3, (double)f4, (double)f5, (float)((float)a3.getRed() / 255.0f), (float)((float)a3.getGreen() / 255.0f), (float)((float)a3.getBlue() / 255.0f), (float)((float)a3.getAlpha() / 255.0f));
        class_2892.method_1350();
        RenderUtil.clean3D();
    }

    /*
     * WARNING - void declaration
     */
    public static void rect(class_4587 class_45872, float f, float f2, float f3, float f4, int n) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        int n2 = n;
        class_4587 a6 = class_45872;
        RenderUtil.rectFilled(a6, (float)a2, (float)a, (float)a5, (float)a3, (int)a4);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawBox(class_4587 class_45872, class_243 class_2432, Color color, double d) {
        void a;
        void a2;
        Object a3 = color;
        class_4587 a4 = class_45872;
        RenderUtil.drawBox(a4, class_238.method_29968((class_243)a), (Color)a3, (double)a2);
    }

    public static void setup() {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawBoxFilled(class_4587 class_45872, class_243 class_2432, Color color) {
        void a;
        Object a2 = color;
        class_4587 a3 = class_45872;
        RenderUtil.drawBoxFilled(a3, class_238.method_29968((class_243)a), (Color)a2);
    }

    /*
     * WARNING - void declaration
     */
    public static void rect(class_4587 class_45872, float f, float f2, float f3, float f4, int n, float f5) {
        void a;
        void a2;
        void a3;
        void a4;
        class_4587 a5;
        void a6;
        void a7;
        float f6 = f5;
        class_4587 class_45873 = a5 = class_45872;
        class_4587 class_45874 = a5;
        RenderUtil.drawHorizontalLine(class_45874, (float)a3, (float)a7, (float)a2, (int)a, (float)a6);
        RenderUtil.drawVerticalLine(class_45874, (float)a7, (float)a2, (float)a4, (int)a, (float)a6);
        RenderUtil.drawHorizontalLine(class_45873, (float)a3, (float)a7, (float)a4, (int)a, (float)a6);
        RenderUtil.drawVerticalLine(class_45873, (float)a3, (float)a2, (float)a4, (int)a, (float)a6);
    }

    public static void clean() {
        RenderSystem.disableBlend();
    }

    public static void clean3D() {
        RenderUtil.clean();
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask((boolean)true);
        RenderSystem.enableCull();
    }

    /*
     * WARNING - void declaration
     */
    public static void rectFilled(class_4587 class_45872, float f, float f2, float f3, float f4, int n) {
        void a;
        void a2;
        void a222;
        void a3;
        void a4;
        int n2 = n;
        class_4587 a5 = class_45872;
        if (a3 < a2) {
            void v0 = a3;
            a3 = a2;
            a2 = v0;
        }
        if (a < a4) {
            void v1 = a;
            a = a4;
            a4 = v1;
        }
        float f5 = (float)(a222 >> 24 & 255) / 255.0f;
        float f6 = (float)(a222 >> 16 & 255) / 255.0f;
        float f7 = (float)(a222 >> 8 & 255) / 255.0f;
        float a222 = (float)(a222 & 255) / 255.0f;
        class_287 class_2872 = class_289.method_1348().method_1349();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(class_757::method_34540);
        class_287 class_2873 = class_2872;
        class_4587 class_45873 = a5;
        class_287 class_2874 = class_2872;
        class_2874.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
        class_2874.method_22918(a5.method_23760().method_23761(), (float)a3, (float)a4, 0.0f).method_22915(f6, f7, a222, f5).method_1344();
        class_2872.method_22918(class_45873.method_23760().method_23761(), (float)a2, (float)a4, 0.0f).method_22915(f6, f7, a222, f5).method_1344();
        class_2873.method_22918(class_45873.method_23760().method_23761(), (float)a2, (float)a, 0.0f).method_22915(f6, f7, a222, f5).method_1344();
        class_2873.method_22918(a5.method_23760().method_23761(), (float)a3, (float)a, 0.0f).method_22915(f6, f7, a222, f5).method_1344();
        class_286.method_43433((class_287.class_7433)class_2873.method_1326());
        RenderSystem.disableBlend();
    }

    public RenderUtil() {
        RenderUtil a;
    }

    /*
     * WARNING - void declaration
     */
    public static void drawBoxFilled(class_4587 class_45872, class_2338 class_23382, Color color) {
        void a;
        Object a2 = color;
        class_4587 a3 = class_45872;
        RenderUtil.drawBoxFilled(a3, new class_238((class_2338)a), (Color)a2);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawBoxFilled(class_4587 class_45872, class_238 class_2382, Color color) {
        void a22;
        Color a = color;
        class_4587 a3 = class_45872;
        void v0 = a22;
        float a22 = (float)(v0.field_1323 - RenderUtil.mc.method_1561().field_4686.method_19326().method_10216());
        float f = (float)(v0.field_1322 - RenderUtil.mc.method_1561().field_4686.method_19326().method_10214());
        float f2 = (float)(v0.field_1321 - RenderUtil.mc.method_1561().field_4686.method_19326().method_10215());
        float f3 = (float)(v0.field_1320 - RenderUtil.mc.method_1561().field_4686.method_19326().method_10216());
        float f4 = (float)(v0.field_1325 - RenderUtil.mc.method_1561().field_4686.method_19326().method_10214());
        float f5 = (float)(v0.field_1324 - RenderUtil.mc.method_1561().field_4686.method_19326().method_10215());
        class_289 class_2892 = class_289.method_1348();
        class_287 class_2872 = class_2892.method_1349();
        RenderUtil.setup3D();
        RenderSystem.setShader(class_757::method_34540);
        class_287 class_2873 = class_2872;
        class_4587 class_45873 = a3;
        class_287 class_2874 = class_2872;
        class_4587 class_45874 = a3;
        class_287 class_2875 = class_2872;
        class_4587 class_45875 = a3;
        class_287 class_2876 = class_2872;
        class_4587 class_45876 = a3;
        class_287 class_2877 = class_2872;
        class_4587 class_45877 = a3;
        class_287 class_2878 = class_2872;
        class_4587 class_45878 = a3;
        class_287 class_2879 = class_2872;
        class_4587 class_45879 = a3;
        class_287 class_28710 = class_2872;
        class_4587 class_458710 = a3;
        class_2872.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
        class_2872.method_22918(class_458710.method_23760().method_23761(), a22, f, f2).method_39415(a.getRGB()).method_1344();
        class_28710.method_22918(class_458710.method_23760().method_23761(), f3, f, f2).method_39415(a.getRGB()).method_1344();
        class_28710.method_22918(a3.method_23760().method_23761(), f3, f, f5).method_39415(a.getRGB()).method_1344();
        class_2872.method_22918(class_45879.method_23760().method_23761(), a22, f, f5).method_39415(a.getRGB()).method_1344();
        class_2879.method_22918(class_45879.method_23760().method_23761(), a22, f4, f2).method_39415(a.getRGB()).method_1344();
        class_2879.method_22918(a3.method_23760().method_23761(), a22, f4, f5).method_39415(a.getRGB()).method_1344();
        class_2872.method_22918(class_45878.method_23760().method_23761(), f3, f4, f5).method_39415(a.getRGB()).method_1344();
        class_2878.method_22918(class_45878.method_23760().method_23761(), f3, f4, f2).method_39415(a.getRGB()).method_1344();
        class_2878.method_22918(a3.method_23760().method_23761(), a22, f, f2).method_39415(a.getRGB()).method_1344();
        class_2872.method_22918(class_45877.method_23760().method_23761(), a22, f4, f2).method_39415(a.getRGB()).method_1344();
        class_2877.method_22918(class_45877.method_23760().method_23761(), f3, f4, f2).method_39415(a.getRGB()).method_1344();
        class_2877.method_22918(a3.method_23760().method_23761(), f3, f, f2).method_39415(a.getRGB()).method_1344();
        class_2872.method_22918(class_45876.method_23760().method_23761(), f3, f, f2).method_39415(a.getRGB()).method_1344();
        class_2876.method_22918(class_45876.method_23760().method_23761(), f3, f4, f2).method_39415(a.getRGB()).method_1344();
        class_2876.method_22918(a3.method_23760().method_23761(), f3, f4, f5).method_39415(a.getRGB()).method_1344();
        class_2872.method_22918(class_45875.method_23760().method_23761(), f3, f, f5).method_39415(a.getRGB()).method_1344();
        class_2875.method_22918(class_45875.method_23760().method_23761(), a22, f, f5).method_39415(a.getRGB()).method_1344();
        class_2875.method_22918(a3.method_23760().method_23761(), f3, f, f5).method_39415(a.getRGB()).method_1344();
        class_2872.method_22918(class_45874.method_23760().method_23761(), f3, f4, f5).method_39415(a.getRGB()).method_1344();
        class_2874.method_22918(class_45874.method_23760().method_23761(), a22, f4, f5).method_39415(a.getRGB()).method_1344();
        class_2874.method_22918(a3.method_23760().method_23761(), a22, f, f2).method_39415(a.getRGB()).method_1344();
        class_2872.method_22918(class_45873.method_23760().method_23761(), a22, f, f5).method_39415(a.getRGB()).method_1344();
        class_2873.method_22918(class_45873.method_23760().method_23761(), a22, f4, f5).method_39415(a.getRGB()).method_1344();
        class_2873.method_22918(a3.method_23760().method_23761(), a22, f4, f2).method_39415(a.getRGB()).method_1344();
        class_2892.method_1350();
        RenderUtil.clean3D();
    }
}
