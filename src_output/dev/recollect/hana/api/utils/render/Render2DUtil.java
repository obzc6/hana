/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.GlStateManager
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1011
 *  net.minecraft.class_1043
 *  net.minecraft.class_1044
 *  net.minecraft.class_1060
 *  net.minecraft.class_286
 *  net.minecraft.class_287
 *  net.minecraft.class_287$class_7433
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_757
 *  org.apache.commons.lang3.RandomStringUtils
 *  org.joml.Matrix4f
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.api.utils.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.gui.nullpoint.font.Texture;
import dev.recollect.hana.socket.network.info.ClientInfo;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_757;
import org.apache.commons.lang3.RandomStringUtils;
import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class Render2DUtil
implements Wrapper {
    /*
     * WARNING - void declaration
     */
    private static /* synthetic */ void drawCenter(class_287 object, Matrix4f matrix4f, float f, float f2, float f3, float f4, Color color, Color color2) {
        void a22;
        void a;
        class_287 a32;
        void a4;
        void a5;
        void a6;
        void a7;
        class_287 class_2872 = object;
        object = color2;
        class_287 a8 = class_2872;
        void v1 = a22;
        float a22 = (float)v1.getRed() / 255.0f;
        float f5 = (float)v1.getGreen() / 255.0f;
        float f6 = (float)v1.getBlue() / 255.0f;
        float f7 = (float)v1.getAlpha() / 255.0f;
        class_287 class_2873 = a32;
        float a32 = (float)class_2873.getRed() / 255.0f;
        float f8 = (float)class_2873.getGreen() / 255.0f;
        float f9 = (float)class_2873.getBlue() / 255.0f;
        float f10 = (float)a32.getAlpha() / 255.0f;
        class_287 class_2874 = a8;
        void v4 = a7;
        a8.method_22918((Matrix4f)a7, (float)a5, (float)a, 0.0f).method_22915(a22, f5, f6, f7).method_1344();
        a8.method_22918((Matrix4f)v4, (float)a6, (float)a, 0.0f).method_22915(a32, f8, f9, f10).method_1344();
        class_2874.method_22918((Matrix4f)v4, (float)a6, (float)a4, 0.0f).method_22915(a32, f8, f9, f10).method_1344();
        class_2874.method_22918((Matrix4f)a7, (float)a5, (float)a4, 0.0f).method_22915(a22, f5, f6, f7).method_1344();
    }

    public static void registerBufferedImageTexture(Texture a3, BufferedImage a2) {
        Texture texture = a3;
        try {
            a3 = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage)a2, ClientInfo.ALLATORIxDEMO("%a%"), (OutputStream)a3);
            a2 = ((ByteArrayOutputStream)a3).toByteArray();
            Render2DUtil.registerTexture(texture, a2);
            return;
        }
        catch (Exception a3) {
            return;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void drawGradientRound(class_4587 class_45872, float f, float f2, float f3, float f4, float f5, Color color, Color color2) {
        void a;
        void a2;
        class_287 a3;
        void a4;
        void a5;
        void a6;
        float f6 = f5;
        class_4587 a7 = class_45872;
        Render2DUtil.setupRender();
        RenderSystem.setShader(class_757::method_34540);
        void var8_12 = a6;
        void var9_13 = a4;
        Matrix4f a8 = a7.method_23760().method_23761();
        class_287 class_2872 = a3 = class_289.method_1348().method_1349();
        Matrix4f matrix4f = a8;
        class_287 class_2873 = a3;
        Matrix4f matrix4f2 = a8;
        class_287 class_2874 = a3;
        Matrix4f matrix4f3 = a8;
        a3.method_1328(class_293.class_5596.field_27381, class_290.field_1576);
        void v6 = a5;
        Render2DUtil.drawCorner(a3, matrix4f3, (float)var8_12, (float)var9_13, (float)a2, (Color)v6, (Color)v6);
        Render2DUtil.drawCorner(class_2874, matrix4f3, (float)((a6 += a8) - a2), (float)var9_13, (float)a2, (Color)a, (Color)a5);
        void v7 = a;
        Render2DUtil.drawCorner(class_2874, a8, (float)(a6 - a2), (float)((a4 += a3) - a2), (float)a2, (Color)v7, (Color)v7);
        Render2DUtil.drawCorner(a3, matrix4f2, (float)var8_12, (float)(a4 - a2), (float)a2, (Color)a5, (Color)a);
        void v8 = var9_13;
        void v9 = a5;
        Render2DUtil.drawEdge(class_2873, matrix4f2, (float)(var8_12 + a2), (float)v8, (float)(a6 - a2), (float)v8, (Color)v9, (Color)v9);
        Render2DUtil.drawEdge(class_2873, a8, (float)a6, (float)(var9_13 + a2), (float)a6, (float)(a4 - a2), (Color)a, (Color)a5);
        void v10 = a4;
        Render2DUtil.drawEdge(a3, matrix4f, (float)(var8_12 + a2), (float)v10, (float)(a6 - a2), (float)v10, (Color)a5, (Color)a);
        Render2DUtil.drawEdge(class_2872, matrix4f, (float)var8_12, (float)(var9_13 + a2), (float)var8_12, (float)(a4 - a2), (Color)a5, (Color)a);
        Render2DUtil.drawCenter(class_2872, a8, (float)(var8_12 + a2), (float)(var9_13 + a2), (float)(a6 - a2), (float)(a4 - a2), (Color)a5, (Color)a);
        class_286.method_43433((class_287.class_7433)class_2872.method_1326());
        Render2DUtil.endRender();
    }

    public static Color injectAlpha(Color color, int n) {
        int a = n;
        Color a2 = color;
        return new Color(a2.getRed(), a2.getGreen(), a2.getBlue(), class_3532.method_15340((int)a, (int)0, (int)255));
    }

    /*
     * WARNING - void declaration
     */
    private static /* synthetic */ void drawEdge(class_287 object, Matrix4f matrix4f, float f, float f2, float f3, float f4, Color color, Color color2) {
        void a22;
        void a;
        class_287 a32;
        void a4;
        void a5;
        void a6;
        void a7;
        class_287 class_2872 = object;
        object = color2;
        class_287 a8 = class_2872;
        void v1 = a22;
        float a22 = (float)v1.getRed() / 255.0f;
        float f5 = (float)v1.getGreen() / 255.0f;
        float f6 = (float)v1.getBlue() / 255.0f;
        float f7 = (float)v1.getAlpha() / 255.0f;
        class_287 class_2873 = a32;
        float a32 = (float)class_2873.getRed() / 255.0f;
        float f8 = (float)class_2873.getGreen() / 255.0f;
        float f9 = (float)class_2873.getBlue() / 255.0f;
        float f10 = (float)a32.getAlpha() / 255.0f;
        class_287 class_2874 = a8;
        class_2874.method_22918((Matrix4f)a7, (float)a5, (float)a, 0.0f).method_22915(a22, f5, f6, f7).method_1344();
        class_2874.method_22918((Matrix4f)a7, (float)a6, (float)a4, 0.0f).method_22915(a32, f8, f9, f10).method_1344();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawCircle(class_4587 object, float f, float f2, float f3, int n, Color color) {
        void a;
        void a2;
        void a3;
        class_4587 a4;
        int n2;
        void a5;
        class_4587 class_45872 = object;
        object = color;
        class_4587 a6 = class_45872;
        if (a4.getAlpha() <= 5) {
            return;
        }
        System.out.println("Drawing circle at (" + (float)a5 + ", " + (float)a2 + ") with radius " + (float)a + " and color " + String.valueOf((Object)a4));
        Matrix4f matrix4f = a6.method_23760().method_23761();
        class_287 class_2872 = class_289.method_1348().method_1349();
        Render2DUtil.setupRender();
        RenderSystem.setShader(class_757::method_34540);
        class_287 class_2873 = class_2872;
        class_2873.method_1328(class_293.class_5596.field_27381, class_290.field_1576);
        class_2873.method_22918(matrix4f, (float)a5, (float)a2, 0.0f).method_1336(a4.getRed(), a4.getGreen(), a4.getBlue(), a4.getAlpha()).method_1344();
        int n3 = n2 = 0;
        while (n3 <= a3) {
            double d = 6.283185307179586 * (double)n2 / (double)a3;
            float f4 = (float)((double)a5 + (double)a * Math.cos(d));
            float f5 = (float)((double)a2 + (double)a * Math.sin(d));
            class_2872.method_22918(matrix4f, f4, f5, 0.0f).method_1336(a4.getRed(), a4.getGreen(), a4.getBlue(), a4.getAlpha()).method_1344();
            n3 = ++n2;
        }
        class_289.method_1348().method_1350();
        Render2DUtil.endRender();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawRect(class_4587 class_45872, float f, float f2, float f3, float f4, int n) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        int n2 = n;
        class_4587 a6 = class_45872;
        Render2DUtil.drawRect(a6, (float)a5, (float)a4, (float)a2, (float)a, new Color((int)a3, true));
    }

    /*
     * WARNING - void declaration
     */
    public static void renderRoundedQuad(class_4587 class_45872, Color color, double d, double d2, double d3, double d4, double d5, double d6) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        Color a7 = color;
        class_4587 a8 = class_45872;
        Render2DUtil.setupRender();
        RenderSystem.setShader(class_757::method_34540);
        Render2DUtil.renderRoundedQuadInternal(a8.method_23760().method_23761(), (float)a7.getRed() / 255.0f, (float)a7.getGreen() / 255.0f, (float)a7.getBlue() / 255.0f, (float)a7.getAlpha() / 255.0f, (double)a5, (double)a4, (double)a3, (double)a2, (double)a, (double)a6);
        Render2DUtil.endRender();
    }

    /*
     * WARNING - void declaration
     */
    public static void verticalGradient(class_4587 class_45872, float f, float f2, float f3, float f4, Color color, Color color2) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        class_4587 class_45873 = class_45872;
        Matrix4f matrix4f = class_45873.method_23760().method_23761();
        class_4587 a7 = class_289.method_1348().method_1349();
        Render2DUtil.setupRender();
        RenderSystem.setShader(class_757::method_34540);
        class_4587 class_45874 = a7;
        Matrix4f matrix4f2 = matrix4f;
        void v2 = a6;
        a7.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
        a7.method_22918(matrix4f, (float)v2, (float)a5, 0.0f).method_39415(a4.getRGB()).method_1344();
        a7.method_22918(matrix4f2, (float)v2, (float)a2, 0.0f).method_39415(a3.getRGB()).method_1344();
        class_45874.method_22918(matrix4f2, (float)a, (float)a2, 0.0f).method_39415(a3.getRGB()).method_1344();
        class_45874.method_22918(matrix4f, (float)a, (float)a5, 0.0f).method_39415(a4.getRGB()).method_1344();
        class_286.method_43433((class_287.class_7433)class_45874.method_1326());
        Render2DUtil.endRender();
    }

    /*
     * WARNING - void declaration
     */
    private static /* synthetic */ void drawCorner(class_287 class_2872, Matrix4f matrix4f, float f, float f2, float f3, Color color, Color color2) {
        void a22;
        int a;
        void a32;
        class_287 class_2873 = class_2872;
        void v0 = a22;
        float a22 = (float)v0.getRed() / 255.0f;
        float f4 = (float)v0.getGreen() / 255.0f;
        float f5 = (float)v0.getBlue() / 255.0f;
        float f6 = (float)v0.getAlpha() / 255.0f;
        void v1 = a32;
        float a32 = (float)v1.getRed() / 255.0f;
        float f7 = (float)v1.getGreen() / 255.0f;
        float f8 = (float)v1.getBlue() / 255.0f;
        float f9 = (float)v1.getAlpha() / 255.0f;
        int n = 16;
        int n2 = a = 0;
        while (n2 <= n) {
            void a4;
            void a5;
            void a6;
            void a7;
            float f10 = (float)((double)a * 3.141592653589793 / 2.0 / (double)n);
            float f11 = (float)((double)a7 + (double)a4 * Math.cos(f10));
            f10 = (float)((double)a6 + (double)a4 * Math.sin(f10));
            float f12 = a22;
            float f13 = f12 + (a32 - f12) * ((float)a / (float)n);
            float f14 = f4;
            float f15 = f14 + (f7 - f14) * ((float)a / (float)n);
            float f16 = f5;
            float f17 = f16 + (f8 - f16) * ((float)a / (float)n);
            float f18 = f6;
            float f19 = f18 + (f9 - f18) * ((float)a / (float)n);
            class_2873.method_22918((Matrix4f)a5, f11, f10, 0.0f).method_22915(f13, f15, f17, f19).method_1344();
            n2 = ++a;
        }
    }

    public static void setupRender() {
        RenderSystem.enableBlend();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawRectHorizontal(class_4587 class_45872, float f, float f2, float f3, float f4, Color color, Color color2) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        class_4587 class_45873 = class_45872;
        Matrix4f matrix4f = class_45873.method_23760().method_23761();
        class_4587 a7 = class_289.method_1348().method_1349();
        Render2DUtil.setupRender();
        RenderSystem.setShader(class_757::method_34540);
        class_4587 class_45874 = a7;
        Matrix4f matrix4f2 = matrix4f;
        void v2 = a6;
        a7.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
        a7.method_22918(matrix4f, (float)v2, (float)a5, 0.0f).method_39415(a4.getRGB()).method_1344();
        a7.method_22918(matrix4f2, (float)v2, (float)(a5 + a2), 0.0f).method_39415(a4.getRGB()).method_1344();
        class_45874.method_22918(matrix4f2, (float)(a6 + a), (float)(a5 + a2), 0.0f).method_39415(a3.getRGB()).method_1344();
        class_45874.method_22918(matrix4f, (float)(a6 + a), (float)a5, 0.0f).method_39415(a3.getRGB()).method_1344();
        class_286.method_43433((class_287.class_7433)class_45874.method_1326());
        Render2DUtil.endRender();
    }

    /*
     * WARNING - void declaration
     */
    public static void renderRoundedQuadInternal(Matrix4f matrix4f, float f, float f2, float f3, float f4, double d, double d2, double d3, double d4, double d5, double d6) {
        void a12;
        int n;
        void a22;
        void a32;
        double a4;
        double a52;
        Matrix4f matrix4f2 = matrix4f;
        Matrix4f a6 = class_289.method_1348().method_1349();
        a6.method_1328(class_293.class_5596.field_27381, class_290.field_1576);
        double[][] arrarrd = new double[4][];
        double[] arrd = new double[3];
        arrd[0] = a22 - a12;
        arrd[1] = a32 - a12;
        arrd[2] = a12;
        arrarrd[0] = arrd;
        double[] arrd2 = new double[3];
        arrd2[0] = a22 - a12;
        arrd2[1] = a52 + a12;
        arrd2[2] = a12;
        arrarrd[1] = arrd2;
        double[] arrd3 = new double[3];
        arrd3[0] = a4 + a12;
        arrd3[1] = a52 + a12;
        arrd3[2] = a12;
        arrarrd[2] = arrd3;
        double[] arrd4 = new double[3];
        arrd4[0] = a4 + a12;
        arrd4[1] = a32 - a12;
        arrd4[2] = a12;
        arrarrd[3] = arrd4;
        double[][] a22 = arrarrd;
        int n2 = n = 0;
        while (n2 < 4) {
            void a7;
            void a8;
            void a9;
            float f5;
            void a10;
            double[] a32 = a22[n];
            a4 = a32[2];
            double d7 = (double)n * 90.0;
            while (d7 < 90.0 + (double)n * 90.0) {
                void a11;
                f5 = (float)Math.toRadians(a52);
                float a12 = (float)(Math.sin(f5) * a4);
                float f6 = (float)(Math.cos(f5) * a4);
                a6.method_22918(matrix4f2, (float)a32[0] + a12, (float)a32[1] + f6, 0.0f).method_22915((float)a10, (float)a8, (float)a7, (float)a9).method_1344();
                d7 = a52 + 90.0 / a11;
            }
            float a52 = (float)Math.toRadians(90.0 + (double)n * 90.0);
            float f7 = (float)(Math.sin(a52) * a4);
            f5 = (float)(Math.cos(a52) * a4);
            a6.method_22918(matrix4f2, (float)a32[0] + f7, (float)a32[1] + f5, 0.0f).method_22915((float)a10, (float)a8, (float)a7, (float)a9).method_1344();
            n2 = ++n;
        }
        class_286.method_43433((class_287.class_7433)a6.method_1326());
    }

    /*
     * WARNING - void declaration
     */
    public static void drawRectVertical(class_4587 class_45872, float f, float f2, float f3, float f4, Color color, Color color2) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        class_4587 class_45873 = class_45872;
        Matrix4f matrix4f = class_45873.method_23760().method_23761();
        class_4587 a7 = class_289.method_1348().method_1349();
        Render2DUtil.setupRender();
        RenderSystem.setShader(class_757::method_34540);
        class_4587 class_45874 = a7;
        Matrix4f matrix4f2 = matrix4f;
        void v2 = a6;
        a7.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
        a7.method_22918(matrix4f, (float)v2, (float)a5, 0.0f).method_39415(a4.getRGB()).method_1344();
        a7.method_22918(matrix4f2, (float)v2, (float)(a5 + a2), 0.0f).method_39415(a3.getRGB()).method_1344();
        class_45874.method_22918(matrix4f2, (float)(a6 + a), (float)(a5 + a2), 0.0f).method_39415(a3.getRGB()).method_1344();
        class_45874.method_22918(matrix4f, (float)(a6 + a), (float)a5, 0.0f).method_39415(a4.getRGB()).method_1344();
        class_286.method_43433((class_287.class_7433)class_45874.method_1326());
        Render2DUtil.endRender();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawCircle(class_4587 class_45872, float f, float f2, float f3, int n, int n2) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        int n3 = n2;
        class_4587 a6 = class_45872;
        Render2DUtil.drawCircle(a6, (float)a5, (float)a4, (float)a2, (int)a, new Color((int)a3, true));
    }

    public static void endRender() {
        RenderSystem.disableBlend();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawRect(class_332 object, float f, float f2, float f3, float f4, Color color) {
        void a;
        void a2;
        void a3;
        class_332 a4;
        void a5;
        class_332 class_3322 = object;
        object = color;
        class_332 a6 = class_3322;
        Render2DUtil.drawRect(a6.method_51448(), (float)a5, (float)a3, (float)a2, (float)a, (Color)a4);
    }

    public static void resetColor() {
        GlStateManager._clearColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    /*
     * WARNING - void declaration
     */
    public static void setRectPoints(class_287 class_2872, Matrix4f matrix4f, float f, float f2, float f3, float f4, Color color, Color color2, Color color3, Color color4) {
        class_287 a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        void a7;
        void a8;
        void a9;
        class_287 a10 = matrix4f;
        class_287 class_2873 = a = class_2872;
        class_287 class_2874 = a10;
        a.method_22918((Matrix4f)a10, (float)a9, (float)a8, 0.0f).method_39415(a7.getRGB()).method_1344();
        a.method_22918((Matrix4f)class_2874, (float)a5, (float)a8, 0.0f).method_39415(a4.getRGB()).method_1344();
        class_2873.method_22918((Matrix4f)class_2874, (float)a5, (float)a3, 0.0f).method_39415(a2.getRGB()).method_1344();
        class_2873.method_22918((Matrix4f)a10, (float)a9, (float)a3, 0.0f).method_39415(a6.getRGB()).method_1344();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawRect(class_4587 class_45872, float f, float f2, float f3, float f4, Color color) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        class_4587 class_45873 = class_45872;
        if (a4.getAlpha() <= 5) {
            return;
        }
        Matrix4f matrix4f = class_45873.method_23760().method_23761();
        class_4587 a6 = class_289.method_1348().method_1349();
        Render2DUtil.setupRender();
        RenderSystem.setShader(class_757::method_34540);
        class_4587 class_45874 = a6;
        Matrix4f matrix4f2 = matrix4f;
        void v2 = a5;
        a6.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
        a6.method_22918(matrix4f, (float)v2, (float)(a3 + a2), 0.0f).method_39415(a4.getRGB()).method_1344();
        a6.method_22918(matrix4f2, (float)(v2 + a), (float)(a3 + a2), 0.0f).method_39415(a4.getRGB()).method_1344();
        class_45874.method_22918(matrix4f2, (float)(a5 + a), (float)a3, 0.0f).method_39415(a4.getRGB()).method_1344();
        class_45874.method_22918(matrix4f, (float)a5, (float)a3, 0.0f).method_39415(a4.getRGB()).method_1344();
        class_289.method_1348().method_1350();
        Render2DUtil.endRender();
    }

    public static void registerTexture(Texture texture, byte[] arrby) {
        Object a22 = arrby;
        Texture a = texture;
        try {
            a22 = BufferUtils.createByteBuffer((int)((byte[])a22).length).put((byte[])a22);
            a22.flip();
            class_1043 class_10432 = new class_1043(class_1011.method_4324((ByteBuffer)a22));
            mc.execute(() -> {
                Texture a = class_10432;
                Texture a2 = a;
                mc.method_1531().method_4616((class_2960)a2, (class_1044)a);
            });
            return;
        }
        catch (Exception a22) {
            return;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void drawRound(class_4587 class_45872, float f, float f2, float f3, float f4, float f5, Color color) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        float a6 = f2;
        class_4587 a7 = class_45872;
        Render2DUtil.renderRoundedQuad(a7, (Color)a5, (double)a4, a6, (double)(a3 + a4), (double)(a + a6), (double)a2, 4.0);
    }

    public Render2DUtil() {
        Render2DUtil a;
    }

    /*
     * WARNING - void declaration
     */
    public static void drawBox(class_4587 object, int n, int n2, int n3, int n4, Color color, float f) {
        void a;
        void a22;
        void a3;
        void a4;
        class_4587 a5;
        void a6;
        class_4587 class_45872 = object;
        object = color;
        class_4587 a7 = class_45872;
        RenderSystem.setShaderColor((float)((float)a5.getRed() / 255.0f), (float)((float)a5.getGreen() / 255.0f), (float)((float)a5.getBlue() / 255.0f), (float)a22);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)2929);
        a5 = a7.method_23760().method_23761();
        class_289 a22 = RenderSystem.renderThreadTesselator();
        class_287 class_2872 = a22.method_1349();
        RenderSystem.setShader(class_757::method_34540);
        class_287 class_2873 = class_2872;
        class_4587 class_45873 = a5;
        void v3 = a6;
        class_2872.method_1328(class_293.class_5596.field_27382, class_290.field_1592);
        class_2872.method_22918((Matrix4f)a5, (float)v3, (float)a3, 0.0f).method_1344();
        class_2872.method_22918((Matrix4f)class_45873, (float)(v3 + a), (float)a3, 0.0f).method_1344();
        class_2873.method_22918((Matrix4f)class_45873, (float)(a6 + a), (float)(a3 + a4), 0.0f).method_1344();
        class_2873.method_22918((Matrix4f)a5, (float)a6, (float)(a3 + a4), 0.0f).method_1344();
        a22.method_1350();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)3042);
    }

    public static boolean isHovered(double a, double a2, double a3, double a4, double a5, double a6) {
        return a >= a3 && a - a5 <= a3 && a2 >= a4 && a2 - a6 <= a4;
    }

    /*
     * WARNING - void declaration
     */
    public static void draw2DGradientRect(class_4587 class_45872, float f, float f2, float f3, float f4, Color color, Color color2, Color color3, Color color4) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        void a7;
        void a8;
        class_4587 class_45873 = class_45872;
        Matrix4f matrix4f = class_45873.method_23760().method_23761();
        class_4587 a9 = class_289.method_1348().method_1349();
        Render2DUtil.setupRender();
        RenderSystem.setShader(class_757::method_34540);
        class_4587 class_45874 = a9;
        Matrix4f matrix4f2 = matrix4f;
        class_4587 class_45875 = a9;
        class_45875.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
        class_45875.method_22918(matrix4f, (float)a2, (float)a4, 0.0f).method_39415(a6.getRGB()).method_1344();
        a9.method_22918(matrix4f2, (float)a8, (float)a4, 0.0f).method_39415(a7.getRGB()).method_1344();
        class_45874.method_22918(matrix4f2, (float)a8, (float)a5, 0.0f).method_39415(a3.getRGB()).method_1344();
        class_45874.method_22918(matrix4f, (float)a2, (float)a5, 0.0f).method_39415(a.getRGB()).method_1344();
        class_286.method_43433((class_287.class_7433)class_45874.method_1326());
        Render2DUtil.endRender();
    }

    /*
     * WARNING - void declaration
     */
    public static void horizontalGradient(class_4587 class_45872, float f, float f2, float f3, float f4, Color color, Color color2) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        class_4587 class_45873 = class_45872;
        Matrix4f matrix4f = class_45873.method_23760().method_23761();
        class_4587 a7 = class_289.method_1348().method_1349();
        Render2DUtil.setupRender();
        RenderSystem.setShader(class_757::method_34540);
        class_4587 class_45874 = a7;
        Matrix4f matrix4f2 = matrix4f;
        void v2 = a6;
        a7.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
        a7.method_22918(matrix4f, (float)v2, (float)a5, 0.0f).method_39415(a4.getRGB()).method_1344();
        a7.method_22918(matrix4f2, (float)v2, (float)a2, 0.0f).method_39415(a4.getRGB()).method_1344();
        class_45874.method_22918(matrix4f2, (float)a, (float)a2, 0.0f).method_39415(a3.getRGB()).method_1344();
        class_45874.method_22918(matrix4f, (float)a, (float)a5, 0.0f).method_39415(a3.getRGB()).method_1344();
        class_286.method_43433((class_287.class_7433)class_45874.method_1326());
        Render2DUtil.endRender();
    }

    public static class BlurredShadow {
        Texture id;

        public BlurredShadow(BufferedImage bufferedImage) {
            BufferedImage a = bufferedImage;
            BlurredShadow a2 = this;
            BlurredShadow blurredShadow = a2;
            blurredShadow.id = new Texture("texture/remote/" + RandomStringUtils.randomAlphanumeric((int)16));
            Render2DUtil.registerBufferedImageTexture(a2.id, a);
        }

        public void bind() {
            BlurredShadow a;
            RenderSystem.setShaderTexture((int)0, (class_2960)a.id);
        }
    }

}
