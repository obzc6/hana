/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1041
 *  net.minecraft.class_243
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_5348
 *  net.minecraft.class_5481
 *  net.minecraft.class_757
 *  net.minecraft.class_898
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector3f
 *  org.joml.Vector4f
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.api.utils.render;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.gui.nullpoint.font.FontAdapter;
import dev.recollect.hana.mod.gui.nullpoint.font.FontRenderers;
import dev.recollect.hana.mod.modules.impl.client.ChatSetting;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import java.awt.Color;
import java.util.HashMap;
import java.util.Objects;
import net.minecraft.class_1041;
import net.minecraft.class_243;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5348;
import net.minecraft.class_5481;
import net.minecraft.class_757;
import net.minecraft.class_898;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;

public class TextUtil
implements Wrapper {
    public static final Matrix4f lastProjMat = new Matrix4f();
    public static final Matrix4f lastModMat = new Matrix4f();
    public static final Matrix4f lastWorldSpaceMatrix = new Matrix4f();

    /*
     * WARNING - void declaration
     */
    public static void drawString(class_332 class_3322, String string, double d, double d2, int n, boolean bl) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        int n2 = n;
        class_332 a6 = class_3322;
        if (a2 != false) {
            FontRenderers.sigma.drawString(a6.method_51448(), (String)a, (float)a5, (float)a3 + 2.0f, (int)a4);
            return;
        }
        a6.method_51433(TextUtil.mc.field_1772, (String)a, (int)a5, (int)a3, (int)a4, true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static void drawStringWithScale(class_332 var0, String var1_2, float var2_3, float var3_4, int var4_5, float var5_6) {
        var0_1 = var5_6;
        a = var0;
        var6_8 = a.method_51448();
        if (a == 1.0f) ** GOTO lbl14
        v0 = var6_8;
        v0.method_22903();
        v1 = a;
        v0.method_22905((float)a, (float)v1, 1.0f);
        if (v1 > 1.0f) {
            v2 = a;
            var6_8.method_46416((float)(-a / a), (float)(-a / a), 0.0f);
        } else {
            var6_8.method_46416((float)(a / a / 2.0f), (float)(a / a / 2.0f), 0.0f);
lbl14: // 2 sources:
            v2 = a;
        }
        TextUtil.drawString(v2, (String)a, (double)a, (double)a, (int)a);
        var6_8.method_22909();
    }

    public static float getWidth(String a) {
        if (TextUtil.isCustomFont()) {
            return FontRenderers.sigma.getWidth(a);
        }
        return TextUtil.mc.field_1772.method_1727(a);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawText(class_332 class_3322, String string, class_243 class_2432, int n) {
        class_243 class_2433;
        class_332 a5 = class_2432;
        class_332 a2 = class_3322;
        class_332 class_3323 = a5;
        a5 = TextUtil.worldSpaceToScreenSpace(new class_243(a5.field_1352, a5.field_1351, a5.field_1350));
        if (class_2433.field_1350 > 0.0 && a5.field_1350 < 1.0) {
            void a3;
            void a4;
            class_332 class_3324 = a5;
            double d = class_3324.field_1352;
            double d2 = class_3324.field_1351;
            double d3 = Math.max(class_3324.field_1352, a5.field_1350);
            float a5 = (float)Math.max(1.0 - EntityUtil.getEyesPos().method_1022((class_243)class_3323) * 0.025, 0.0);
            float f = (float)(d3 - d) / 2.0f;
            float f2 = (float)TextUtil.mc.field_1772.method_1727((String)a4) * a5;
            f = (float)((d + (double)f - (double)(f2 / 2.0f)) * 1.0);
            class_332 class_3325 = a2;
            class_3325.method_51448().method_22903();
            float f3 = a5;
            class_3325.method_51448().method_22905(f3, f3, f3);
            Objects.requireNonNull(TextUtil.mc.field_1772);
            class_3325.method_51433(TextUtil.mc.field_1772, (String)a4, (int)(f / a5), (int)((d2 - 11.0 + 9.0 * 1.2) / (double)a5), (int)a3, true);
            a2.method_51448().method_22909();
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void drawStringPulse(class_332 class_3322, String string, double d, double d2, Color color, Color color2, double d3, int n, boolean bl) {
        char[] a;
        int n2;
        class_332 class_3323 = class_3322;
        a = a.toCharArray();
        int n3 = 0;
        boolean bl2 = false;
        String string2 = null;
        int n4 = a.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            char a2 = a[n2];
            if (a2 == '\u00a7') {
                bl2 = true;
            } else if (bl2) {
                string2 = a2 == 'r' ? null : "\u00a7" + a2;
                bl2 = false;
            } else {
                void a3;
                void v2;
                void a4;
                void a5;
                void a6;
                ++n3;
                class_332 class_3324 = class_3323;
                if (string2 != null) {
                    TextUtil.drawString(class_3324, string2 + a2, (double)a4, (double)a5, a6.getRGB(), (boolean)a3);
                    v2 = a4;
                } else {
                    void a7;
                    void a8;
                    void a9;
                    TextUtil.drawString(class_3324, String.valueOf(a2), (double)a4, (double)a5, ColorUtil.pulseColor((Color)a6, (Color)a7, n3, (int)a8, (double)a9).getRGB(), (boolean)a3);
                    v2 = a4;
                }
                a4 = v2 + (a3 != false ? (double)FontRenderers.sigma.getWidth(String.valueOf(a2)) : (double)TextUtil.mc.field_1772.method_1727(String.valueOf(a2)));
            }
            n5 = ++n2;
        }
    }

    public static boolean isCustomFont() {
        return UIModule.INSTANCE.customFont.getValue() && FontRenderers.sigma != null;
    }

    /*
     * WARNING - void declaration
     */
    public static void drawCustomText(class_332 object, String string, double d, double d2, Color color) {
        void a;
        void a2;
        void a3;
        class_332 a4;
        class_332 class_3322 = object;
        object = color;
        class_332 a5 = class_3322;
        TextUtil.drawCustomText(a5, (String)a3, (double)a2, (double)a, a4.getRGB());
    }

    /*
     * WARNING - void declaration
     */
    public static void drawString(class_332 class_3322, String string, double d, double d2, int n) {
        void a;
        void a2;
        void a3;
        void a4;
        int n2 = n;
        class_332 a5 = class_3322;
        if (TextUtil.isCustomFont()) {
            FontRenderers.sigma.drawString(a5.method_51448(), (String)a, (float)a4, (float)a2 + 2.0f, (int)a3);
            return;
        }
        a5.method_51433(TextUtil.mc.field_1772, (String)a, (int)a4, (int)a2, (int)a3, true);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawCustomText(class_332 class_3322, String string, double d, double d2, int n) {
        void a;
        void a2;
        class_332 class_3323;
        void a3;
        void a4;
        class_332 a5;
        class_332 class_3324 = class_3322;
        class_310 class_3102 = class_310.method_1551();
        class_332 class_3325 = a5 = class_3324.method_51448();
        a5.method_22903();
        class_3325.method_22905(2.0f, 2.0f, 1.0f);
        class_3325.method_22904((double)(-a4 / 2.0), (double)(-a / 2.0), 0.0);
        if (UIModule.INSTANCE.customFont.getValue()) {
            FontRenderers.lexend.drawString(class_3324.method_51448(), (String)a3, (float)a4, (float)a + 2.0f, (int)a2);
            class_3323 = a5;
        } else {
            class_3324.method_51433(class_3102.field_1772, (String)a3, (int)a4, (int)a, (int)a2, true);
            class_3323 = a5;
        }
        class_3323.method_22909();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawCustomSmallText(class_332 class_3322, String string, double d, double d2, int n) {
        void a;
        void a2;
        void a3;
        void a4;
        int n2 = n;
        class_332 a5 = class_3322;
        if (UIModule.INSTANCE.customFont.getValue()) {
            FontRenderers.sigma.drawString(a5.method_51448(), (String)a, (float)a4, (float)a2 + 1.0f, (int)a3);
            return;
        }
        a5.method_51433(TextUtil.mc.field_1772, (String)a, (int)a4, (int)a2, (int)a3, true);
    }

    public TextUtil() {
        TextUtil a;
    }

    /*
     * WARNING - void declaration
     */
    public static void drawOutlinedBox(class_4587 object, int n, int n2, int n3, int n4, Color color, float f) {
        void a;
        void a2;
        void a3;
        class_4587 a4;
        void a5;
        void a6;
        class_4587 class_45872 = object;
        object = color;
        class_4587 a7 = class_45872;
        RenderSystem.setShaderColor((float)((float)a4.getRed() / 255.0f), (float)((float)a4.getGreen() / 255.0f), (float)((float)a4.getBlue() / 255.0f), (float)a5);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)2929);
        a4 = a7.method_23760().method_23761();
        class_289 class_2892 = RenderSystem.renderThreadTesselator();
        class_287 class_2872 = class_2892.method_1349();
        RenderSystem.setShader(class_757::method_34539);
        class_287 class_2873 = class_2872;
        class_4587 class_45873 = a4;
        void v3 = a6;
        class_2872.method_1328(class_293.class_5596.field_27382, class_290.field_1592);
        class_2872.method_22918((Matrix4f)a4, (float)v3, (float)a2, 0.0f).method_1344();
        class_2872.method_22918((Matrix4f)class_45873, (float)(v3 + a), (float)a2, 0.0f).method_1344();
        class_2873.method_22918((Matrix4f)class_45873, (float)(a6 + a), (float)(a2 + a3), 0.0f).method_1344();
        class_2873.method_22918((Matrix4f)a4, (float)a6, (float)(a2 + a3), 0.0f).method_1344();
        class_2892.method_1350();
        RenderSystem.setShaderColor((float)0.0f, (float)0.0f, (float)0.0f, (float)a5);
        RenderSystem.setShader(class_757::method_34539);
        class_287 class_2874 = class_2872;
        class_4587 class_45874 = a4;
        void v6 = a6;
        class_287 class_2875 = class_2872;
        class_2875.method_1328(class_293.class_5596.field_29345, class_290.field_1592);
        class_2875.method_22918((Matrix4f)a4, (float)a6, (float)a2, 0.0f).method_1344();
        class_2872.method_22918((Matrix4f)a4, (float)(v6 + a), (float)a2, 0.0f).method_1344();
        class_2872.method_22918((Matrix4f)class_45874, (float)(v6 + a), (float)(a2 + a3), 0.0f).method_1344();
        class_2874.method_22918((Matrix4f)class_45874, (float)a6, (float)(a2 + a3), 0.0f).method_1344();
        class_2874.method_22918((Matrix4f)a4, (float)a6, (float)a2, 0.0f).method_1344();
        class_2892.method_1350();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)3042);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawString(class_332 object, String string, double d, double d2, Color color) {
        void a;
        void a2;
        void a3;
        class_332 a4;
        class_332 class_3322 = object;
        object = color;
        class_332 a5 = class_3322;
        TextUtil.drawString(a5, (String)a3, (double)a2, (double)a, a4.getRGB());
    }

    /*
     * WARNING - void declaration
     */
    public static void drawStringWithScale(class_332 class_3322, String string, float f, float f2, Color color, float f3) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        float f4 = f3;
        class_332 a6 = class_3322;
        TextUtil.drawStringWithScale(a6, (String)a2, (float)a5, (float)a, a4.getRGB(), (float)a3);
    }

    /*
     * WARNING - void declaration
     */
    public static void drawText(class_332 class_3322, String string, class_243 class_2432) {
        void a;
        class_332 a2 = class_2432;
        class_332 a3 = class_3322;
        TextUtil.drawText(a3, (String)a, (class_243)a2, -1);
    }

    public static class_243 worldSpaceToScreenSpace(class_243 a) {
        class_243 class_2432 = a;
        a = TextUtil.mc.method_1561().field_4686;
        int n = mc.method_22683().method_4507();
        int[] arrn = new int[4];
        GL11.glGetIntegerv((int)2978, (int[])arrn);
        Vector3f vector3f = new Vector3f();
        class_243 class_2433 = class_2432;
        double d = class_2433.field_1352 - a.method_19326().field_1352;
        double d2 = class_2433.field_1351 - a.method_19326().field_1351;
        double d3 = class_2433.field_1350 - a.method_19326().field_1350;
        a = new Vector4f((float)d, (float)d2, (float)d3, 1.0f).mul((Matrix4fc)lastWorldSpaceMatrix);
        Matrix4f matrix4f = new Matrix4f((Matrix4fc)lastProjMat);
        Matrix4f matrix4f2 = new Matrix4f((Matrix4fc)lastModMat);
        matrix4f.mul((Matrix4fc)matrix4f2).project(a.x(), a.y(), a.z(), arrn, vector3f);
        return new class_243((double)vector3f.x / mc.method_22683().method_4495(), (double)((float)n - vector3f.y) / mc.method_22683().method_4495(), (double)vector3f.z);
    }

    /*
     * WARNING - void declaration
     */
    public static int drawStringPulse(class_332 class_3322, class_5481 class_54812, double d, double d2, Color color, Color color2, double d3, int n) {
        char[] a;
        void a2;
        int n2;
        class_332 class_3323 = class_3322;
        a = ChatSetting.chatMessage.get(a).getString().toCharArray();
        int n3 = 0;
        boolean bl = false;
        String string = null;
        int n4 = a.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            char a3 = a[n2];
            if (a3 == '\u00a7') {
                bl = true;
            } else if (bl) {
                string = a3 == 'r' ? null : "\u00a7" + a3;
                bl = false;
            } else {
                void v2;
                void a4;
                void a5;
                ++n3;
                class_332 class_3324 = class_3323;
                if (string != null) {
                    class_3324.method_25303(TextUtil.mc.field_1772, string + a3, (int)a2, (int)a4, a5.getRGB());
                    v2 = a2;
                } else {
                    void a6;
                    void a7;
                    void a8;
                    class_3324.method_25303(TextUtil.mc.field_1772, String.valueOf(a3), (int)a2, (int)a4, ColorUtil.pulseColor((Color)a5, (Color)a6, n3, (int)a7, (double)a8).getRGB());
                    v2 = a2;
                }
                a2 = v2 + (double)TextUtil.mc.field_1772.method_1727(String.valueOf(a3));
            }
            n5 = ++n2;
        }
        return (int)a2;
    }

    public static float getHeight() {
        if (TextUtil.isCustomFont()) {
            return FontRenderers.sigma.getFontHeight();
        }
        Objects.requireNonNull(TextUtil.mc.field_1772);
        return 9.0f;
    }
}
