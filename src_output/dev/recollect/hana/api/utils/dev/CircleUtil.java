/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1297
 *  net.minecraft.class_243
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
 *  net.minecraft.class_898
 *  org.joml.Matrix4f
 *  org.joml.Quaternionf
 */
package dev.recollect.hana.api.utils.dev;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.Wrapper;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1297;
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
import org.joml.Quaternionf;

public class CircleUtil
implements Wrapper {
    private static final float STAR_RADIUS = 1.0f;
    private static final int POINT_COUNT = 5;

    private static /* synthetic */ List<class_243> calculateStarPoints(class_243 a, double a2) {
        class_243 class_2432 = a;
        ArrayList<class_243> arrayList = new ArrayList<class_243>();
        double d = 1.2566370614359172;
        double d2 = 1.0 * Math.cos(0.6283185307179586) / (1.0 + Math.cos(0.6283185307179586));
        int n = a = 0;
        while (n < 10) {
            double d3 = a % 2 == 0 ? 1.0 : d2;
            double d4 = (double)a * d - 1.5707963267948966 + Math.toRadians(a2);
            class_243 class_2433 = class_2432;
            double d5 = class_2433.field_1352 + d3 * Math.cos(d4);
            double d6 = class_2433.field_1351;
            d3 = class_2433.field_1350 + d3 * Math.sin(d4);
            arrayList.add(new class_243(d5, d6, d3));
            n = ++a;
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     */
    public static void drawStarLines(class_4587 class_45872, class_243 class_2432, int n, int n2, int n3, double d) {
        int n4;
        void a22;
        Object a = class_2432;
        class_4587 a3 = class_45872;
        a = CircleUtil.calculateStarPoints((class_243)a, (double)a22);
        Matrix4f a22 = a3.method_23760().method_23761();
        RenderSystem.setShader(class_757::method_34540);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.lineWidth((float)2.0f);
        class_289 class_2892 = class_289.method_1348();
        class_287 class_2872 = class_2892.method_1349();
        class_2872.method_1328(class_293.class_5596.field_29344, class_290.field_1576);
        int n5 = n4 = 0;
        while (n5 < a.size()) {
            void a4;
            void a5;
            void a6;
            class_243 class_2433 = (class_243)a.get(n4);
            Object object = a;
            class_243 class_2434 = (class_243)object.get((n4 + 2) % object.size());
            class_287 class_2873 = class_2872;
            class_2873.method_22918(a22, (float)class_2433.field_1352, (float)class_2433.field_1351, (float)class_2433.field_1350).method_1336((int)a6, (int)a4, (int)a5, 255).method_1344();
            class_2873.method_22918(a22, (float)class_2434.field_1352, (float)class_2434.field_1351, (float)class_2434.field_1350).method_1336((int)a6, (int)a4, (int)a5, 255).method_1344();
            n5 = ++n4;
        }
        class_2872.method_1326();
        class_2892.method_1350();
        RenderSystem.lineWidth((float)1.0f);
        RenderSystem.disableBlend();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawCircle2D(class_4587 class_45872, class_1297 class_12972, Color color, float f, double d) {
        int n;
        double a;
        class_4587 a2 = class_12972;
        class_4587 a3 = class_45872;
        class_4587 class_45873 = a2;
        class_4587 class_45874 = a2;
        double d2 = class_45873.field_6014 + (class_45874.method_23317() - a2.field_6014) * (double)mc.method_1488() - CircleUtil.mc.method_1561().field_4686.method_19326().method_10216();
        double d3 = class_45874.field_6036 + (a2.method_23318() - a2.field_6036) * (double)mc.method_1488() - CircleUtil.mc.method_1561().field_4686.method_19326().method_10214() - 0.01;
        double d4 = class_45873.field_5969 + (a2.method_23321() - a2.field_5969) * (double)mc.method_1488() - CircleUtil.mc.method_1561().field_4686.method_19326().method_10215();
        class_4587 class_45875 = a3;
        class_4587 class_45876 = a3;
        class_45876.method_22903();
        class_45876.method_22904(d2, d3, d4);
        class_4587 class_45877 = a3;
        class_45875.method_22907(new Quaternionf().rotationY((float)Math.toRadians(a)));
        class_45875.method_22904(-d2, -d3, -d4);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask((boolean)false);
        a2 = class_289.method_1348();
        class_287 class_2872 = a2.method_1349();
        RenderSystem.setShader(class_757::method_34540);
        class_2872.method_1328(class_293.class_5596.field_29344, class_290.field_1576);
        int n2 = n = 0;
        while (n2 <= 360) {
            void a4;
            void a5;
            a = Math.toRadians(n);
            double d5 = Math.toRadians((n + 10) % 360);
            double d6 = Math.cos(a) * (double)a4;
            a = Math.sin(a) * (double)a4;
            double d7 = Math.cos(d5) * (double)a4;
            d5 = Math.sin(d5) * (double)a4;
            class_287 class_2873 = class_2872;
            class_2873.method_22918(a3.method_23760().method_23761(), (float)(d2 + d6), (float)d3, (float)(d4 + a)).method_1336(a5.getRed(), a5.getGreen(), a5.getBlue(), a5.getAlpha()).method_1344();
            class_2873.method_22918(a3.method_23760().method_23761(), (float)(d2 + d7), (float)d3, (float)(d4 + d5)).method_1336(a5.getRed(), a5.getGreen(), a5.getBlue(), a5.getAlpha()).method_1344();
            n2 = n += 10;
        }
        a2.method_1350();
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask((boolean)true);
        RenderSystem.disableBlend();
        a3.method_22909();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawCircle(class_4587 class_45872, class_1297 class_12972, Color color, float f, double d) {
        int n;
        double a;
        void a2;
        class_4587 a3 = class_12972;
        class_4587 a4 = class_45872;
        class_4587 class_45873 = a3;
        class_4587 class_45874 = a3;
        double d2 = class_45873.field_6014 + (class_45874.method_23317() - a3.field_6014) * (double)mc.method_1488() - CircleUtil.mc.method_1561().field_4686.method_19326().method_10216();
        double d3 = class_45874.field_6036 + (a3.method_23318() - a3.field_6036) * (double)mc.method_1488() - CircleUtil.mc.method_1561().field_4686.method_19326().method_10214() - 0.01;
        double d4 = class_45873.field_5969 + (a3.method_23321() - a3.field_5969) * (double)mc.method_1488() - CircleUtil.mc.method_1561().field_4686.method_19326().method_10215();
        class_4587 class_45875 = a4;
        class_4587 class_45876 = a4;
        class_45876.method_22903();
        class_45876.method_22904(d2, d3, d4);
        class_4587 class_45877 = a4;
        class_45875.method_22907(new Quaternionf().rotationY((float)Math.toRadians(a)));
        class_45875.method_22904(-d2, -d3, -d4);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask((boolean)false);
        a3 = class_289.method_1348();
        class_287 class_2872 = a3.method_1349();
        RenderSystem.setShader(class_757::method_34540);
        class_287 class_2873 = class_2872;
        class_2873.method_1328(class_293.class_5596.field_27381, class_290.field_1576);
        class_2873.method_22918(a4.method_23760().method_23761(), (float)d2, (float)d3, (float)d4).method_1336(a2.getRed(), a2.getGreen(), a2.getBlue(), a2.getAlpha()).method_1344();
        int n2 = n = 0;
        while (n2 <= 360) {
            void a5;
            a = Math.toRadians(n);
            double d5 = Math.cos(a) * (double)a5;
            a = Math.sin(a) * (double)a5;
            class_2872.method_22918(a4.method_23760().method_23761(), (float)(d2 + d5), (float)d3, (float)(d4 + a)).method_1336(a2.getRed(), a2.getGreen(), a2.getBlue(), a2.getAlpha()).method_1344();
            n2 = n += 10;
        }
        a3.method_1350();
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask((boolean)true);
        RenderSystem.disableBlend();
        a4.method_22909();
    }

    /*
     * WARNING - void declaration
     */
    public static void drawStar2D(class_4587 class_45872, class_1297 class_12972, Color color, float f, float f2, double d) {
        int n;
        void a;
        class_4587 a2 = class_12972;
        class_4587 a3 = class_45872;
        class_4587 class_45873 = a2;
        class_4587 class_45874 = a2;
        double d2 = class_45873.field_6014 + (class_45874.method_23317() - a2.field_6014) * (double)mc.method_1488() - CircleUtil.mc.method_1561().field_4686.method_19326().method_10216();
        double d3 = class_45874.field_6036 + (a2.method_23318() - a2.field_6036) * (double)mc.method_1488() - CircleUtil.mc.method_1561().field_4686.method_19326().method_10214() - 0.01;
        double d4 = class_45873.field_5969 + (a2.method_23321() - a2.field_5969) * (double)mc.method_1488() - CircleUtil.mc.method_1561().field_4686.method_19326().method_10215();
        class_4587 class_45875 = a3;
        class_4587 class_45876 = a3;
        class_45876.method_22903();
        class_45876.method_22904(d2, d3, d4);
        class_4587 class_45877 = a3;
        class_45875.method_22907(new Quaternionf().rotationY((float)Math.toRadians((double)a)));
        class_45875.method_22904(-d2, -d3, -d4);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask((boolean)false);
        a2 = class_289.method_1348();
        class_287 class_2872 = a2.method_1349();
        RenderSystem.setShader(class_757::method_34540);
        class_2872.method_1328(class_293.class_5596.field_29344, class_290.field_1576);
        int n2 = 5;
        ArrayList<class_243> arrayList = new ArrayList<class_243>();
        int n3 = n = 0;
        while (n3 < n2 * 2) {
            void a4;
            void a5;
            double d5 = Math.toRadians((double)n * (360.0 / (double)(n2 * 2)) + a);
            double d6 = n % 2 == 0 ? (double)a5 : (double)a4;
            double d7 = Math.cos(d5) * d6;
            d6 = Math.sin(d5) * d6;
            arrayList.add(new class_243(d2 + d7, d3, d4 + d6));
            n3 = ++n;
        }
        int n4 = n = 0;
        while (n4 < arrayList.size()) {
            void a6;
            class_243 class_2432 = (class_243)arrayList.get(n);
            ArrayList<class_243> arrayList2 = arrayList;
            class_243 class_2433 = (class_243)arrayList2.get((n + 2) % arrayList2.size());
            class_287 class_2873 = class_2872;
            class_2873.method_22918(a3.method_23760().method_23761(), (float)class_2432.field_1352, (float)class_2432.field_1351, (float)class_2432.field_1350).method_1336(a6.getRed(), a6.getGreen(), a6.getBlue(), a6.getAlpha()).method_1344();
            class_2873.method_22918(a3.method_23760().method_23761(), (float)class_2433.field_1352, (float)class_2433.field_1351, (float)class_2433.field_1350).method_1336(a6.getRed(), a6.getGreen(), a6.getBlue(), a6.getAlpha()).method_1344();
            n4 = ++n;
        }
        a2.method_1350();
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask((boolean)true);
        RenderSystem.disableBlend();
        a3.method_22909();
    }

    public CircleUtil() {
        CircleUtil a;
    }
}
