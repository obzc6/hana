/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1511
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_327$class_6415
 *  net.minecraft.class_3532
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_5250
 *  net.minecraft.class_5348
 *  net.minecraft.class_757
 *  net.minecraft.class_7833
 *  org.joml.Matrix3f
 *  org.joml.Matrix4f
 *  org.joml.Quaternionf
 *  org.joml.Vector3f
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.api.utils.render;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.gui.nullpoint.font.FontAdapter;
import dev.recollect.hana.mod.gui.nullpoint.font.FontRenderers;
import dev.recollect.hana.xibao.Snow;
import java.awt.Color;
import net.minecraft.class_1511;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_5250;
import net.minecraft.class_5348;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL11;

public class Render3DUtil
implements Wrapper {
    public static class_4587 matrixFrom(double a, double a2, double a3) {
        class_4587 class_45872 = new class_4587();
        class_4184 class_41842 = Render3DUtil.mc.field_1773.method_19418();
        class_4587 class_45873 = class_45872;
        class_45872.method_22907(class_7833.field_40714.rotationDegrees(class_41842.method_19329()));
        class_45873.method_22907(class_7833.field_40716.rotationDegrees(class_41842.method_19330() + 180.0f));
        class_45873.method_22904(a - class_41842.method_19326().field_1352, a2 - class_41842.method_19326().field_1351, a3 - class_41842.method_19326().field_1350);
        return class_45873;
    }

    public static void drawHoleLine(class_238 a4, Color a2, float a3) {
        class_238 class_2382 = a4;
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableDepthTest();
        class_4587 class_45872 = Render3DUtil.matrixFrom(class_2382.field_1323, class_2382.field_1322, class_2382.field_1321);
        a4 = RenderSystem.renderThreadTesselator();
        class_287 class_2872 = a4.method_1349();
        RenderSystem.disableCull();
        RenderSystem.setShader(class_757::method_34535);
        RenderSystem.lineWidth((float)a3);
        class_2872.method_1328(class_293.class_5596.field_27377, class_290.field_29337);
        class_238 class_2383 = class_2382;
        class_238 class_2384 = class_2382;
        class_238 class_2385 = a3 = class_2384.method_997(new class_243(class_2384.field_1323, class_2382.field_1322, class_2382.field_1321).method_22882());
        a3 = (float)class_2385.field_1323;
        float a4 = (float)class_2385.field_1322;
        float f = (float)class_2385.field_1321;
        float f2 = (float)class_2385.field_1320;
        float f3 = (float)class_2385.field_1324;
        class_4587 class_45873 = class_45872;
        class_287 class_2873 = class_2872;
        Render3DUtil.vertexLine(class_45872, (class_4588)class_2872, a3, a4, f, f2, a4, f, a2);
        Render3DUtil.vertexLine(class_45872, (class_4588)class_2873, f2, a4, f, f2, a4, f3, a2);
        Render3DUtil.vertexLine(class_45873, (class_4588)class_2873, f2, a4, f3, a3, a4, f3, a2);
        Render3DUtil.vertexLine(class_45873, (class_4588)class_2872, a3, a4, f3, a3, a4, f, a2);
        a4.method_1350();
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawBox(class_4587 class_45872, class_238 class_2382, Color color) {
        void a;
        Object a2 = color;
        class_4587 a3 = class_45872;
        Render3DUtil.draw3DBox(a3, (class_238)a, (Color)a2, true, false);
    }

    /*
     * WARNING - void declaration
     */
    public static void draw3DBox(class_4587 class_45872, class_238 class_2382, Color color) {
        void a;
        Object a2 = color;
        class_4587 a3 = class_45872;
        Render3DUtil.draw3DBox(a3, (class_238)a, (Color)a2, true, true);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawLine3D(class_4587 class_45872, class_243 class_2432, class_243 class_2433, Color color) {
        void a;
        void a2;
        Object a3 = color;
        class_4587 a4 = class_45872;
        RenderSystem.setShaderColor((float)((Color)a3).getRed(), (float)((Color)a3).getGreen(), (float)((Color)a3).getBlue(), (float)((Color)a3).getAlpha());
        GL11.glEnable((int)3042);
        GL11.glDisable((int)2929);
        a3 = a4.method_23760().method_23761();
        class_289 class_2892 = RenderSystem.renderThreadTesselator();
        class_287 class_2872 = class_2892.method_1349();
        RenderSystem.setShader(class_757::method_34539);
        class_287 class_2873 = class_2872;
        class_2872.method_1328(class_293.class_5596.field_29344, class_290.field_1592);
        class_2873.method_22918((Matrix4f)a3, (float)a2.field_1352, (float)a2.field_1351, (float)a2.field_1350).method_1344();
        class_2873.method_22918((Matrix4f)a3, (float)a.field_1352, (float)a.field_1351, (float)a.field_1350).method_1344();
        class_2892.method_1350();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)3042);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawLine(class_238 class_2382, Color color, float f) {
        void a;
        float a2 = f;
        class_238 a3 = class_2382;
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableDepthTest();
        class_4587 class_45872 = Render3DUtil.matrixFrom(a3.field_1323, a3.field_1322, a3.field_1321);
        class_289 class_2892 = RenderSystem.renderThreadTesselator();
        class_287 class_2872 = class_2892.method_1349();
        RenderSystem.disableCull();
        RenderSystem.setShader(class_757::method_34535);
        RenderSystem.lineWidth((float)a2);
        class_2872.method_1328(class_293.class_5596.field_27377, class_290.field_29337);
        class_238 class_2383 = a3;
        class_238 class_2384 = a3;
        class_238 class_2385 = a2 = class_2384.method_997(new class_243(class_2384.field_1323, a3.field_1322, a3.field_1321).method_22882());
        a2 = (float)class_2385.field_1323;
        float f2 = (float)class_2385.field_1322;
        float f3 = (float)class_2385.field_1321;
        float f4 = (float)class_2385.field_1320;
        float f5 = (float)class_2385.field_1325;
        float f6 = (float)class_2385.field_1324;
        class_4587 class_45873 = class_45872;
        class_287 class_2873 = class_2872;
        class_4587 class_45874 = class_45872;
        class_287 class_2874 = class_2872;
        class_4587 class_45875 = class_45872;
        class_287 class_2875 = class_2872;
        class_4587 class_45876 = class_45872;
        class_287 class_2876 = class_2872;
        Render3DUtil.vertexLine(class_45872, (class_4588)class_2876, a2, f2, f3, f4, f2, f3, (Color)a);
        Render3DUtil.vertexLine(class_45876, (class_4588)class_2876, f4, f2, f3, f4, f2, f6, (Color)a);
        Render3DUtil.vertexLine(class_45876, (class_4588)class_2872, f4, f2, f6, a2, f2, f6, (Color)a);
        Render3DUtil.vertexLine(class_45872, (class_4588)class_2875, a2, f2, f6, a2, f2, f3, (Color)a);
        Render3DUtil.vertexLine(class_45875, (class_4588)class_2875, a2, f2, f6, a2, f5, f6, (Color)a);
        Render3DUtil.vertexLine(class_45875, (class_4588)class_2872, a2, f2, f3, a2, f5, f3, (Color)a);
        Render3DUtil.vertexLine(class_45872, (class_4588)class_2874, f4, f2, f6, f4, f5, f6, (Color)a);
        Render3DUtil.vertexLine(class_45874, (class_4588)class_2874, f4, f2, f3, f4, f5, f3, (Color)a);
        Render3DUtil.vertexLine(class_45874, (class_4588)class_2872, a2, f5, f3, f4, f5, f3, (Color)a);
        Render3DUtil.vertexLine(class_45872, (class_4588)class_2873, f4, f5, f3, f4, f5, f6, (Color)a);
        Render3DUtil.vertexLine(class_45873, (class_4588)class_2873, f4, f5, f6, a2, f5, f6, (Color)a);
        Render3DUtil.vertexLine(class_45873, (class_4588)class_2872, a2, f5, f6, a2, f5, f3, (Color)a);
        class_2892.method_1350();
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
    }

    public static void endRender() {
        RenderSystem.disableBlend();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawText3D(String string, class_243 class_2432, Color color, float f) {
        void a;
        void a2;
        String a3 = class_2432;
        String a4 = string;
        Object[] arrobject = new Object[3];
        arrobject[0] = ((class_243)a3).field_1352;
        arrobject[1] = ((class_243)a3).field_1351;
        arrobject[2] = ((class_243)a3).field_1350;
        Render3DUtil.drawText3D(class_2561.method_30163((String)String.format(a4, arrobject)), ((class_243)a3).field_1352, ((class_243)a3).field_1351, ((class_243)a3).field_1350, 0.0, 0.0, (double)a, a2.getRGB());
    }

    /*
     * WARNING - void declaration
     */
    public static void drawText3D(class_2561 class_25612, double d, double d2, double d3, double d4, double d5, double d6, int n) {
        void a22;
        void a;
        void a3;
        void a4;
        void a5;
        void a322;
        void a6;
        class_2561 class_25613 = class_25612;
        GL11.glDisable((int)2929);
        class_4587 a22 = Render3DUtil.matrixFrom((double)a22, (double)a322, (double)a);
        class_4184 class_41842 = Render3DUtil.mc.field_1773.method_19418();
        class_4587 class_45872 = a22;
        class_4587 class_45873 = a22;
        class_4587 class_45874 = a22;
        class_45874.method_22907(class_7833.field_40716.rotationDegrees(-class_41842.method_19330()));
        class_45874.method_22907(class_7833.field_40714.rotationDegrees(class_41842.method_19329()));
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        class_45873.method_22904((double)a4, (double)a6, 0.0);
        class_45872.method_22905(-0.025f * (float)a5, -0.025f * (float)a5, 1.0f);
        int a7 = Render3DUtil.mc.field_1772.method_27525((class_5348)class_25613) / 2;
        class_4597.class_4598 a322 = class_4597.method_22991((class_287)class_289.method_1348().method_1349());
        class_45873.method_22903();
        class_45872.method_46416(1.0f, 1.0f, 0.0f);
        Render3DUtil.mc.field_1772.method_30882(class_2561.method_30163((String)class_25613.getString().replaceAll(Snow.ALLATORIxDEMO("\u00f7\u0000F\u0001L|:F:,6Y"), "")), (float)(-a7), 0.0f, 2105376, false, a22.method_23760().method_23761(), (class_4597)a322, class_327.class_6415.field_33994, 0, 15728880);
        a322.method_22993();
        a22.method_22909();
        Render3DUtil.mc.field_1772.method_30882((class_2561)class_25613.method_27661(), (float)(-a7), 0.0f, (int)a3, false, a22.method_23760().method_23761(), (class_4597)a322, class_327.class_6415.field_33994, 0, 15728880);
        a322.method_22993();
        RenderSystem.disableBlend();
        GL11.glEnable((int)2929);
    }

    public Render3DUtil() {
        Render3DUtil a;
    }

    /*
     * WARNING - void declaration
     */
    public static void drawFill(class_4587 class_45872, class_238 class_2382, Color color) {
        void a;
        Object a2 = color;
        class_4587 a3 = class_45872;
        Render3DUtil.draw3DBox(a3, (class_238)a, (Color)a2, false, true);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawLine(class_243 class_2432, class_243 class_2433, Color color) {
        void a;
        class_243 a2 = class_2433;
        class_243 a3 = class_2432;
        Render3DUtil.drawLine(a3.field_1352, a3.method_10214(), a3.field_1350, a2.method_10216(), a2.method_10214(), a2.method_10215(), (Color)a, 1.0f);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawSphere(class_4587 class_45872, class_1511 class_15112, Float f, Float f2, Float f3, Color color) {
        void a;
        class_4587 a2 = class_15112;
        class_4587 a3 = class_45872;
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        class_4587 class_45873 = a2;
        double d = class_45873.field_6038 + (a2.method_23317() - a2.field_6038) * (double)mc.method_1488();
        class_4587 class_45874 = a2;
        double d2 = class_45873.field_5971 + (class_45874.method_23318() - a2.field_5971) * (double)mc.method_1488();
        double d3 = class_45874.field_5989 + (a2.method_23321() - a2.field_5989) * (double)mc.method_1488();
        double d4 = 6.283185307179586;
        a2 = class_289.method_1348();
        class_287 class_2872 = a2.method_1349();
        RenderSystem.setShader(class_757::method_34540);
        RenderSystem.lineWidth((float)a.floatValue());
        class_2872.method_1328(class_293.class_5596.field_29345, class_290.field_1576);
        int n = a = 0;
        while (n <= 180) {
            void a4;
            void a5;
            void a6;
            class_4588 class_45882 = class_2872.method_22918(a3.method_23760().method_23761(), (float)(d + (double)a4.floatValue() * Math.cos((double)a * d4 / 45.0)), (float)(d2 + (double)a6.floatValue()), (float)(d3 + (double)a4.floatValue() * Math.sin((double)a * d4 / 45.0)));
            class_45882.method_1336(a5.getRed(), a5.getGreen(), a5.getBlue(), a5.getAlpha()).method_1344();
            n = ++a;
        }
        a2.method_1350();
        RenderSystem.disableBlend();
    }

    /*
     * WARNING - void declaration
     */
    public static void vertexLine(class_4587 object, class_4588 class_45882, double d, double d2, double d3, double d4, double d5, double d6, Color color) {
        void a;
        void a2;
        void a3;
        void a4;
        class_4587 a5;
        void a6;
        class_4587 a7;
        void a8;
        void a9;
        class_4587 class_45872 = object;
        object = color;
        class_4587 class_45873 = a5 = class_45872;
        Matrix4f matrix4f = class_45873.method_23760().method_23761();
        Matrix3f matrix3f = class_45873.method_23760().method_23762();
        Vector3f vector3f = Render3DUtil.getNormal((float)a6, (float)a4, (float)a3, (float)a2, (float)a, (float)a8);
        a9.method_22918(matrix4f, (float)a6, (float)a4, (float)a3).method_1336(a7.getRed(), a7.getGreen(), a7.getBlue(), a7.getAlpha()).method_23763(matrix3f, vector3f.x(), vector3f.y(), vector3f.z()).method_1344();
        a9.method_22918(matrix4f, (float)a2, (float)a, (float)a8).method_1336(a7.getRed(), a7.getGreen(), a7.getBlue(), a7.getAlpha()).method_23763(matrix3f, vector3f.x(), vector3f.y(), vector3f.z()).method_1344();
    }

    /*
     * WARNING - void declaration
     */
    public static void draw3DCircle(class_243 class_2432, double d, double d2, int n) {
        int n2;
        class_243 class_2433 = class_2432;
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableDepthTest();
        class_4587 a = new class_4587();
        class_243 a2 = Render3DUtil.mc.field_1773.method_19418();
        class_4587 class_45872 = a;
        class_45872.method_22907(class_7833.field_40714.rotationDegrees(a2.method_19329()));
        class_45872.method_22907(class_7833.field_40716.rotationDegrees(a2.method_19330() + 180.0f));
        class_45872.method_22904(class_2433.field_1352 - a2.method_19326().field_1352, class_2433.field_1351 - a2.method_19326().field_1351, class_2433.field_1350 - a2.method_19326().field_1350);
        a = RenderSystem.renderThreadTesselator();
        a2 = a.method_1349();
        RenderSystem.setShader(class_757::method_34540);
        RenderSystem.lineWidth((float)2.0f);
        a2.method_1328(class_293.class_5596.field_29345, class_290.field_1576);
        int n3 = 36;
        int n4 = n2 = 0;
        while (n4 <= n3) {
            void a3;
            void a4;
            double d3 = 6.283185307179586 * (double)n2 / (double)n3;
            class_243 class_2434 = class_2433;
            double d4 = class_2434.field_1352 + a4 * Math.cos(d3);
            d3 = class_2434.field_1350 + a4 * Math.sin(d3);
            a2.method_22912(d4, class_2433.field_1351 + a3, d3).method_1336(Color.red.getRed(), Color.red.getGreen(), Color.red.getBlue(), Color.red.getAlpha()).method_1344();
            n4 = ++n2;
        }
        a.method_1350();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawLine2(class_243 class_2432, class_243 class_2433, Color color) {
        void a;
        class_243 a2 = class_2433;
        class_243 a3 = class_2432;
        Render3DUtil.drawLine(a3.field_1352, a3.method_10214(), a3.field_1350, a2.method_10216(), a2.method_10214(), a2.method_10215(), (Color)a, 1.0f);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawText3D(String string, class_243 class_2432, int n) {
        void a;
        String a2 = class_2432;
        String a3 = string;
        Render3DUtil.drawText3D(class_2561.method_30163((String)a3), ((class_243)a2).field_1352, ((class_243)a2).field_1351, ((class_243)a2).field_1350, 0.0, 0.0, 1.0, (int)a);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawLine(double d, double d2, double d3, double d4, double d5, double d6, Color color, float f) {
        void a;
        void a2;
        void a3;
        void a4;
        double a5;
        void a6;
        void a7;
        Color color2 = color;
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        class_4587 class_45872 = Render3DUtil.matrixFrom(a5, (double)a6, (double)a3);
        class_289 class_2892 = class_289.method_1348();
        class_287 a8 = class_2892.method_1349();
        RenderSystem.disableCull();
        RenderSystem.setShader(class_757::method_34535);
        RenderSystem.lineWidth((float)a4);
        class_287 class_2872 = a8;
        class_2872.method_1328(class_293.class_5596.field_27377, class_290.field_29337);
        Render3DUtil.vertexLine(class_45872, (class_4588)class_2872, 0.0, 0.0, 0.0, (float)(a2 - a5), (float)(a - a6), (float)(a7 - a3), color2);
        class_2892.method_1350();
        RenderSystem.enableCull();
        RenderSystem.lineWidth((float)1.0f);
        RenderSystem.disableBlend();
    }

    /*
     * WARNING - void declaration
     */
    public static void draw3DBox(class_4587 class_45872, class_238 class_2382, Color color, boolean bl, boolean bl2) {
        void a;
        void a2;
        void a3;
        class_4587 a4 = class_2382;
        class_4587 a5 = class_45872;
        a4 = a4.method_997(Render3DUtil.mc.field_1773.method_19418().method_19326().method_22882());
        RenderSystem.enableBlend();
        GL11.glDisable((int)2929);
        Matrix4f matrix4f = a5.method_23760().method_23761();
        class_289 class_2892 = RenderSystem.renderThreadTesselator();
        class_287 class_2872 = class_2892.method_1349();
        if (a2 != false) {
            RenderSystem.setShaderColor((float)((float)a.getRed() / 255.0f), (float)((float)a.getGreen() / 255.0f), (float)((float)a.getBlue() / 255.0f), (float)((float)a.getAlpha() / 255.0f));
            RenderSystem.setShader(class_757::method_34539);
            class_287 class_2873 = class_2872;
            Matrix4f matrix4f2 = matrix4f;
            class_4587 class_45873 = a4;
            class_287 class_2874 = class_2872;
            Matrix4f matrix4f3 = matrix4f;
            class_4587 class_45874 = a4;
            class_287 class_2875 = class_2872;
            Matrix4f matrix4f4 = matrix4f;
            class_4587 class_45875 = a4;
            class_287 class_2876 = class_2872;
            Matrix4f matrix4f5 = matrix4f;
            class_4587 class_45876 = a4;
            class_287 class_2877 = class_2872;
            Matrix4f matrix4f6 = matrix4f;
            class_4587 class_45877 = a4;
            class_287 class_2878 = class_2872;
            Matrix4f matrix4f7 = matrix4f;
            class_4587 class_45878 = a4;
            class_2872.method_1328(class_293.class_5596.field_29344, class_290.field_1592);
            class_2872.method_22918(matrix4f, (float)class_45878.field_1323, (float)a4.field_1322, (float)a4.field_1321).method_1344();
            class_2872.method_22918(matrix4f7, (float)class_45878.field_1320, (float)a4.field_1322, (float)a4.field_1321).method_1344();
            class_2878.method_22918(matrix4f7, (float)a4.field_1320, (float)a4.field_1322, (float)a4.field_1321).method_1344();
            class_2878.method_22918(matrix4f, (float)a4.field_1320, (float)a4.field_1322, (float)a4.field_1324).method_1344();
            class_2872.method_22918(matrix4f, (float)class_45877.field_1320, (float)a4.field_1322, (float)a4.field_1324).method_1344();
            class_2872.method_22918(matrix4f6, (float)class_45877.field_1323, (float)a4.field_1322, (float)a4.field_1324).method_1344();
            class_2877.method_22918(matrix4f6, (float)a4.field_1323, (float)a4.field_1322, (float)a4.field_1324).method_1344();
            class_2877.method_22918(matrix4f, (float)a4.field_1323, (float)a4.field_1322, (float)a4.field_1321).method_1344();
            class_2872.method_22918(matrix4f, (float)class_45876.field_1323, (float)a4.field_1322, (float)a4.field_1321).method_1344();
            class_2872.method_22918(matrix4f5, (float)class_45876.field_1323, (float)a4.field_1325, (float)a4.field_1321).method_1344();
            class_2876.method_22918(matrix4f5, (float)a4.field_1320, (float)a4.field_1322, (float)a4.field_1321).method_1344();
            class_2876.method_22918(matrix4f, (float)a4.field_1320, (float)a4.field_1325, (float)a4.field_1321).method_1344();
            class_2872.method_22918(matrix4f, (float)class_45875.field_1320, (float)a4.field_1322, (float)a4.field_1324).method_1344();
            class_2872.method_22918(matrix4f4, (float)class_45875.field_1320, (float)a4.field_1325, (float)a4.field_1324).method_1344();
            class_2875.method_22918(matrix4f4, (float)a4.field_1323, (float)a4.field_1322, (float)a4.field_1324).method_1344();
            class_2875.method_22918(matrix4f, (float)a4.field_1323, (float)a4.field_1325, (float)a4.field_1324).method_1344();
            class_2872.method_22918(matrix4f, (float)class_45874.field_1323, (float)a4.field_1325, (float)a4.field_1321).method_1344();
            class_2872.method_22918(matrix4f3, (float)class_45874.field_1320, (float)a4.field_1325, (float)a4.field_1321).method_1344();
            class_2874.method_22918(matrix4f3, (float)a4.field_1320, (float)a4.field_1325, (float)a4.field_1321).method_1344();
            class_2874.method_22918(matrix4f, (float)a4.field_1320, (float)a4.field_1325, (float)a4.field_1324).method_1344();
            class_2872.method_22918(matrix4f, (float)class_45873.field_1320, (float)a4.field_1325, (float)a4.field_1324).method_1344();
            class_2872.method_22918(matrix4f2, (float)class_45873.field_1323, (float)a4.field_1325, (float)a4.field_1324).method_1344();
            class_2873.method_22918(matrix4f2, (float)a4.field_1323, (float)a4.field_1325, (float)a4.field_1324).method_1344();
            class_2873.method_22918(matrix4f, (float)a4.field_1323, (float)a4.field_1325, (float)a4.field_1321).method_1344();
            class_2892.method_1350();
        }
        if (a3 != false) {
            RenderSystem.setShaderColor((float)((float)a.getRed() / 255.0f), (float)((float)a.getGreen() / 255.0f), (float)((float)a.getBlue() / 255.0f), (float)((float)a.getAlpha() / 255.0f));
            RenderSystem.setShader(class_757::method_34539);
            class_287 class_2879 = class_2872;
            Matrix4f matrix4f8 = matrix4f;
            class_4587 class_45879 = a4;
            class_287 class_28710 = class_2872;
            Matrix4f matrix4f9 = matrix4f;
            class_4587 class_458710 = a4;
            class_287 class_28711 = class_2872;
            Matrix4f matrix4f10 = matrix4f;
            class_4587 class_458711 = a4;
            class_287 class_28712 = class_2872;
            Matrix4f matrix4f11 = matrix4f;
            class_4587 class_458712 = a4;
            class_287 class_28713 = class_2872;
            Matrix4f matrix4f12 = matrix4f;
            class_4587 class_458713 = a4;
            class_287 class_28714 = class_2872;
            Matrix4f matrix4f13 = matrix4f;
            class_4587 class_458714 = a4;
            class_2872.method_1328(class_293.class_5596.field_27382, class_290.field_1592);
            class_2872.method_22918(matrix4f, (float)class_458714.field_1323, (float)a4.field_1322, (float)a4.field_1321).method_1344();
            class_2872.method_22918(matrix4f13, (float)class_458714.field_1320, (float)a4.field_1322, (float)a4.field_1321).method_1344();
            class_28714.method_22918(matrix4f13, (float)a4.field_1320, (float)a4.field_1322, (float)a4.field_1324).method_1344();
            class_28714.method_22918(matrix4f, (float)a4.field_1323, (float)a4.field_1322, (float)a4.field_1324).method_1344();
            class_2872.method_22918(matrix4f, (float)class_458713.field_1323, (float)a4.field_1325, (float)a4.field_1321).method_1344();
            class_2872.method_22918(matrix4f12, (float)class_458713.field_1323, (float)a4.field_1325, (float)a4.field_1324).method_1344();
            class_28713.method_22918(matrix4f12, (float)a4.field_1320, (float)a4.field_1325, (float)a4.field_1324).method_1344();
            class_28713.method_22918(matrix4f, (float)a4.field_1320, (float)a4.field_1325, (float)a4.field_1321).method_1344();
            class_2872.method_22918(matrix4f, (float)class_458712.field_1323, (float)a4.field_1322, (float)a4.field_1321).method_1344();
            class_2872.method_22918(matrix4f11, (float)class_458712.field_1323, (float)a4.field_1325, (float)a4.field_1321).method_1344();
            class_28712.method_22918(matrix4f11, (float)a4.field_1320, (float)a4.field_1325, (float)a4.field_1321).method_1344();
            class_28712.method_22918(matrix4f, (float)a4.field_1320, (float)a4.field_1322, (float)a4.field_1321).method_1344();
            class_2872.method_22918(matrix4f, (float)class_458711.field_1320, (float)a4.field_1322, (float)a4.field_1321).method_1344();
            class_2872.method_22918(matrix4f10, (float)class_458711.field_1320, (float)a4.field_1325, (float)a4.field_1321).method_1344();
            class_28711.method_22918(matrix4f10, (float)a4.field_1320, (float)a4.field_1325, (float)a4.field_1324).method_1344();
            class_28711.method_22918(matrix4f, (float)a4.field_1320, (float)a4.field_1322, (float)a4.field_1324).method_1344();
            class_2872.method_22918(matrix4f, (float)class_458710.field_1323, (float)a4.field_1322, (float)a4.field_1324).method_1344();
            class_2872.method_22918(matrix4f9, (float)class_458710.field_1320, (float)a4.field_1322, (float)a4.field_1324).method_1344();
            class_28710.method_22918(matrix4f9, (float)a4.field_1320, (float)a4.field_1325, (float)a4.field_1324).method_1344();
            class_28710.method_22918(matrix4f, (float)a4.field_1323, (float)a4.field_1325, (float)a4.field_1324).method_1344();
            class_2872.method_22918(matrix4f, (float)class_45879.field_1323, (float)a4.field_1322, (float)a4.field_1321).method_1344();
            class_2872.method_22918(matrix4f8, (float)class_45879.field_1323, (float)a4.field_1322, (float)a4.field_1324).method_1344();
            class_2879.method_22918(matrix4f8, (float)a4.field_1323, (float)a4.field_1325, (float)a4.field_1324).method_1344();
            class_2879.method_22918(matrix4f, (float)a4.field_1323, (float)a4.field_1325, (float)a4.field_1321).method_1344();
            class_2892.method_1350();
        }
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)2929);
        RenderSystem.disableBlend();
    }

    public static void setupRender() {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawTextIn3D(String string, class_243 class_2432, double d, double d2, double d3, Color color) {
        void a;
        void a2;
        class_4597.class_4598 a3;
        void a4;
        void a5;
        String string2 = string;
        class_4587 class_45872 = new class_4587();
        String a6 = Render3DUtil.mc.field_1773.method_19418();
        RenderSystem.disableCull();
        class_4587 class_45873 = class_45872;
        class_4587 class_45874 = class_45872;
        class_4587 class_45875 = class_45872;
        class_45872.method_22907(class_7833.field_40714.rotationDegrees(a6.method_19329()));
        class_45875.method_22907(class_7833.field_40716.rotationDegrees(a6.method_19330() + 180.0f));
        class_45874.method_22904(a3.method_10216() - a6.method_19326().field_1352, a3.method_10214() - a6.method_19326().field_1351, a3.method_10215() - a6.method_19326().field_1350);
        class_45875.method_22907(class_7833.field_40716.rotationDegrees(-a6.method_19330()));
        class_45874.method_22907(class_7833.field_40714.rotationDegrees(a6.method_19329()));
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        class_45873.method_22904((double)a4, (double)(a2 - 0.1), -0.01);
        class_45873.method_22905(-0.025f, -0.025f, 0.0f);
        a3 = class_4597.method_22991((class_287)class_289.method_1348().method_1349());
        FontRenderers.Arial.drawCenteredString(class_45872, string2, (double)a, 0.0, a5.getRGB());
        a3.method_22993();
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawText3D(class_2561 class_25612, class_243 class_2432, double d, double d2, double d3, Color color) {
        void a;
        void a2;
        void a3;
        void a4;
        class_2561 a5 = class_2432;
        class_2561 a6 = class_25612;
        Render3DUtil.drawText3D(a6, a5.field_1352, a5.field_1351, a5.field_1350, (double)a3, (double)a2, (double)a, a4.getRGB());
    }

    /*
     * WARNING - void declaration
     */
    public static void drawLine2(double d, double d2, double d3, double d4, double d5, double d6, Color color, float f) {
        void a;
        void a2;
        void a3;
        void a4;
        double a5;
        void a6;
        void a7;
        Color color2 = color;
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        class_4587 class_45872 = Render3DUtil.matrixFrom(a5, (double)a6, (double)a3);
        class_289 class_2892 = class_289.method_1348();
        class_287 a8 = class_2892.method_1349();
        RenderSystem.disableCull();
        RenderSystem.setShader(class_757::method_34535);
        RenderSystem.lineWidth((float)a4);
        class_287 class_2872 = a8;
        class_2872.method_1328(class_293.class_5596.field_27377, class_290.field_29337);
        Render3DUtil.vertexLine(class_45872, (class_4588)class_2872, 0.0, 0.0, 0.0, (float)(a2 - a5), (float)(a - a6), (float)(a7 - a3), color2);
        class_2892.method_1350();
        RenderSystem.enableCull();
        RenderSystem.lineWidth((float)1.0f);
        RenderSystem.disableBlend();
    }

    /*
     * WARNING - void declaration
     */
    public static Vector3f getNormal(float f, float f2, float f3, float f4, float f5, float f6) {
        void a;
        float a2;
        float a3;
        void a4;
        void a5;
        float f7 = f;
        f = f5;
        float a6 = f7;
        a2 = a3 - a2;
        a4 = a5 - a4;
        void v1 = a -= a6;
        float f8 = a2;
        void v3 = a4;
        a3 = class_3532.method_15355((float)(v1 * v1 + f8 * f8 + v3 * v3));
        return new Vector3f((float)(a / a3), a2 / a3, (float)(a4 / a3));
    }

    /*
     * WARNING - void declaration
     */
    public static void drawHole(class_4587 class_45872, class_2338 class_23382, Color color, boolean bl, boolean bl2, float f, float f2) {
        void a;
        class_238 a2;
        void a222;
        Color a3 = color;
        class_4587 a4 = class_45872;
        if (a222 != false) {
            void a5;
            Render3DUtil.drawHoleLine(new class_238((class_2338)a2), a3, (float)a5);
        }
        a2 = new class_238((class_2338)a2);
        a2 = a2.method_997(Render3DUtil.mc.field_1773.method_19418().method_19326().method_22882());
        RenderSystem.enableBlend();
        GL11.glDisable((int)2929);
        Matrix4f a222 = a4.method_23760().method_23761();
        class_289 a5 = RenderSystem.renderThreadTesselator();
        class_287 class_2872 = a5.method_1349();
        if (a != false) {
            void a6;
            RenderSystem.setShader(class_757::method_34540);
            RenderSystem.disableCull();
            class_287 class_2873 = class_2872;
            Matrix4f matrix4f = a222;
            class_238 class_2382 = a2;
            class_287 class_2874 = class_2872;
            Matrix4f matrix4f2 = a222;
            class_238 class_2383 = a2;
            class_287 class_2875 = class_2872;
            Matrix4f matrix4f3 = a222;
            class_238 class_2384 = a2;
            class_287 class_2876 = class_2872;
            Matrix4f matrix4f4 = a222;
            class_238 class_2385 = a2;
            class_287 class_2877 = class_2872;
            Matrix4f matrix4f5 = a222;
            class_238 class_2386 = a2;
            class_2872.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
            class_2872.method_22918(a222, (float)class_2386.field_1323, (float)a2.field_1322, (float)a2.field_1321).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), a3.getAlpha()).method_1344();
            class_2872.method_22918(matrix4f5, (float)class_2386.field_1320, (float)a2.field_1322, (float)a2.field_1321).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), a3.getAlpha()).method_1344();
            class_2877.method_22918(matrix4f5, (float)a2.field_1320, (float)a2.field_1322, (float)a2.field_1324).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), a3.getAlpha()).method_1344();
            class_2877.method_22918(a222, (float)a2.field_1323, (float)a2.field_1322, (float)a2.field_1324).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), a3.getAlpha()).method_1344();
            class_2872.method_22918(a222, (float)class_2385.field_1323, (float)a2.field_1322, (float)a2.field_1321).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), a3.getAlpha()).method_1344();
            class_2872.method_22918(matrix4f4, (float)class_2385.field_1323, (float)a2.field_1322 + a6, (float)a2.field_1321).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), 0).method_1344();
            class_2876.method_22918(matrix4f4, (float)a2.field_1320, (float)a2.field_1322 + a6, (float)a2.field_1321).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), 0).method_1344();
            class_2876.method_22918(a222, (float)a2.field_1320, (float)a2.field_1322, (float)a2.field_1321).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), a3.getAlpha()).method_1344();
            class_2872.method_22918(a222, (float)class_2384.field_1320, (float)a2.field_1322, (float)a2.field_1321).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), a3.getAlpha()).method_1344();
            class_2872.method_22918(matrix4f3, (float)class_2384.field_1320, (float)a2.field_1322 + a6, (float)a2.field_1321).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), 0).method_1344();
            class_2875.method_22918(matrix4f3, (float)a2.field_1320, (float)a2.field_1322 + a6, (float)a2.field_1324).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), 0).method_1344();
            class_2875.method_22918(a222, (float)a2.field_1320, (float)a2.field_1322, (float)a2.field_1324).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), a3.getAlpha()).method_1344();
            class_2872.method_22918(a222, (float)class_2383.field_1323, (float)a2.field_1322, (float)a2.field_1324).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), a3.getAlpha()).method_1344();
            class_2872.method_22918(matrix4f2, (float)class_2383.field_1320, (float)a2.field_1322, (float)a2.field_1324).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), a3.getAlpha()).method_1344();
            class_2874.method_22918(matrix4f2, (float)a2.field_1320, (float)a2.field_1322 + a6, (float)a2.field_1324).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), 0).method_1344();
            class_2874.method_22918(a222, (float)a2.field_1323, (float)a2.field_1322 + a6, (float)a2.field_1324).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), 0).method_1344();
            class_2872.method_22918(a222, (float)class_2382.field_1323, (float)a2.field_1322, (float)a2.field_1321).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), a3.getAlpha()).method_1344();
            class_2872.method_22918(matrix4f, (float)class_2382.field_1323, (float)a2.field_1322, (float)a2.field_1324).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), a3.getAlpha()).method_1344();
            class_2873.method_22918(matrix4f, (float)a2.field_1323, (float)a2.field_1322 + a6, (float)a2.field_1324).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), 0).method_1344();
            class_2873.method_22918(a222, (float)a2.field_1323, (float)a2.field_1322 + a6, (float)a2.field_1321).method_1336(a3.getRed(), a3.getGreen(), a3.getBlue(), 0).method_1344();
            a5.method_1350();
            RenderSystem.enableCull();
        }
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)2929);
        RenderSystem.disableBlend();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawText3D(String string, class_243 class_2432, Color color) {
        void a;
        String a2 = class_2432;
        String a3 = string;
        Render3DUtil.drawText3D(class_2561.method_30163((String)a3), ((class_243)a2).field_1352, ((class_243)a2).field_1351, ((class_243)a2).field_1350, 0.0, 0.0, 1.0, a.getRGB());
    }
}
