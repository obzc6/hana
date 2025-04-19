/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.recollect.hana.api.utils.dev;

import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Kernel;
import java.awt.image.WritableRaster;
import java.util.Hashtable;
import org.jetbrains.annotations.NotNull;

public class GaussianFilter {
    protected float radius;
    protected Kernel kernel;

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).insert(0, stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 3 ^ (3 ^ 5);
        5 << 3 ^ 1;
        int n4 = 4 << 4 ^ 5 << 1;
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
    public BufferedImage createCompatibleDestImage(BufferedImage bufferedImage, ColorModel colorModel) {
        void a;
        Object a2 = colorModel;
        GaussianFilter a3 = this;
        if (a2 == null) {
            a2 = a.getColorModel();
        }
        Object object = a2;
        return new BufferedImage((ColorModel)object, ((ColorModel)a2).createCompatibleWritableRaster(a.getWidth(), a.getHeight()), ((ColorModel)object).isAlphaPremultiplied(), null);
    }

    public GaussianFilter(float f) {
        GaussianFilter a;
        float a2 = f;
        GaussianFilter gaussianFilter = a = this;
        gaussianFilter.setRadius(a2);
    }

    public static int clamp(int a) {
        if (a < 0) {
            return 0;
        }
        return Math.min(a, 255);
    }

    public static Kernel makeKernel(float a) {
        float f = a;
        int n = (int)Math.ceil(f);
        int n2 = n * 2 + 1;
        float[] arrf = new float[n2];
        float f2 = f / 3.0f;
        float f3 = 2.0f * f2 * f2;
        f2 = (float)Math.sqrt(6.2831855f * f2);
        float f4 = f;
        float f5 = f4 * f4;
        float f6 = 0.0f;
        int n3 = 0;
        int n4 = a = -n;
        while (n4 <= n) {
            int n5 = a;
            float f7 = n5 * n5;
            arrf[n3] = f7 > f5 ? 0.0f : (float)Math.exp(-f7 / f3) / f2;
            f6 += arrf[n3++];
            n4 = ++a;
        }
        int n6 = a = 0;
        while (n6 < n2) {
            float[] arrf2 = arrf;
            float f8 = arrf2[a] / f6;
            arrf2[a] = f8;
            n6 = ++a;
        }
        return new Kernel(n2, 1, arrf);
    }

    public BufferedImage filter(BufferedImage a, BufferedImage a2) {
        GaussianFilter a222;
        GaussianFilter gaussianFilter = a222;
        BufferedImage bufferedImage = a;
        int a222 = bufferedImage.getWidth();
        int n = bufferedImage.getHeight();
        if (a2 == null) {
            a2 = gaussianFilter.createCompatibleDestImage(a, null);
        }
        int[] arrn = new int[a222 * n];
        int[] arrn2 = new int[a222 * n];
        a.getRGB(0, 0, a222, n, arrn, 0, a222);
        if (gaussianFilter.radius > 0.0f) {
            GaussianFilter gaussianFilter2 = gaussianFilter;
            GaussianFilter.convolveAndTranspose(gaussianFilter2.kernel, arrn, arrn2, a222, n, 1 != 0, 1 != 0, false, 1);
            GaussianFilter.convolveAndTranspose(gaussianFilter2.kernel, arrn2, arrn, n, a222, 1 != 0, false, 1 != 0, 1);
        }
        BufferedImage bufferedImage2 = a2;
        bufferedImage2.setRGB(0, 0, a222, n, arrn, 0, a222);
        return bufferedImage2;
    }

    public void setRadius(float f) {
        GaussianFilter a;
        float a2 = f;
        GaussianFilter gaussianFilter = a = this;
        gaussianFilter.radius = a2;
        gaussianFilter.kernel = GaussianFilter.makeKernel(a2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static void convolveAndTranspose(@NotNull Kernel var0, int[] var1_3, int[] var2_4, int var3_5, int var4_6, boolean var5_7, boolean var6_8, boolean var7_9, int var8_10) {
        v0 = var20_11 = var0;
        var9_12 = v0.getKernelData(null);
        var10_13 = v0.getWidth() / 2;
        v1 = var11_14 = 0;
        block0 : do {
            if (v1 >= height) return;
            var12_15 = var11_14;
            var13_16 = var11_14 * width;
            v2 = var14_17 = 0;
            do {
                if (v2 < width) {
                    var15_18 = 0.0f;
                    var16_19 = 0.0f;
                    var17_20 = 0.0f;
                    var18_21 = 0.0f;
                    var19_22 = var10_13;
                    v3 = -var10_13;
                } else {
                    v1 = ++var11_14;
                    continue block0;
                }
                while (v3 <= var10_13) {
                    block10 : {
                        block13 : {
                            block11 : {
                                block12 : {
                                    var21_23 = var9_12[var19_22 + kernel];
                                    if (var21_23 == 0.0f) break block10;
                                    var22_24 = var14_17 + kernel;
                                    if (var22_24 >= 0) break block11;
                                    if (edgeAction != true) break block12;
                                    var22_24 = 0;
                                    v4 = inPixels;
                                    break block13;
                                }
                                if (edgeAction != 2) ** GOTO lbl43
                                var22_24 = (var14_17 + width) % width;
                                v4 = inPixels;
                                break block13;
                            }
                            if (var22_24 < width) ** GOTO lbl43
                            if (edgeAction == true) {
                                var22_24 = width - true;
                                v4 = inPixels;
                            } else {
                                if (edgeAction == 2) {
                                    var22_24 = (var14_17 + width) % width;
                                }
lbl43: // 5 sources:
                                v4 = inPixels;
                            }
                        }
                        var23_25 = v4[var13_16 + var22_24];
                        var24_26 = var23_25 >> 24 & 255;
                        var25_27 = var23_25 >> 16 & 255;
                        var26_28 = var23_25 >> 8 & 255;
                        var27_29 = var23_25 & 255;
                        if (premultiply != false) {
                            var28_30 = (float)var24_26 * 0.003921569f;
                            var25_27 = (int)((float)var25_27 * var28_30);
                            var26_28 = (int)((float)var26_28 * var28_30);
                            var27_29 = (int)((float)var27_29 * var28_30);
                        }
                        var18_21 += var21_23 * (float)var24_26;
                        var15_18 += var21_23 * (float)var25_27;
                        var16_19 += var21_23 * (float)var26_28;
                        var17_20 += var21_23 * (float)var27_29;
                    }
                    v3 = ++kernel;
                }
                if (unpremultiply != false && var18_21 != 0.0f && var18_21 != 255.0f) {
                    kernel = 255.0f / var18_21;
                    var15_18 *= kernel;
                    var16_19 *= kernel;
                    var17_20 *= kernel;
                }
                kernel /* !! */  = (Kernel)(alpha != false ? GaussianFilter.clamp((int)((double)var18_21 + 0.5)) : 255);
                var21_23 = GaussianFilter.clamp((int)((double)var15_18 + 0.5));
                var22_24 = GaussianFilter.clamp((int)((double)var16_19 + 0.5));
                var23_25 = GaussianFilter.clamp((int)((double)var17_20 + 0.5));
                v5 = var12_15;
                outPixels[v5] = kernel /* !! */  << 24 | var21_23 << 16 | var22_24 << 8 | var23_25;
                var12_15 = v5 + height;
                v2 = ++var14_17;
            } while (true);
            break;
        } while (true);
    }

    public String toString() {
        return BetterDynamicAnimation.ALLATORIxDEMO("BXu\\5as\\nr\\Ot\u000b]_rP8\u001b/");
    }
}
