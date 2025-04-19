/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.GlStateManager
 *  com.mojang.blaze3d.platform.GlStateManager$class_4534
 *  com.mojang.blaze3d.platform.GlStateManager$class_4535
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry$SkyRenderer
 *  net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext
 *  net.minecraft.class_287
 *  net.minecraft.class_287$class_7433
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_291
 *  net.minecraft.class_291$class_8555
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_5819
 *  net.minecraft.class_5820
 *  net.minecraft.class_5944
 *  net.minecraft.class_638
 *  net.minecraft.class_757
 *  net.minecraft.class_758
 *  org.joml.Matrix4f
 *  org.joml.Quaternionf
 *  org.joml.Vector3f
 */
package dev.recollect.hana.mod.modules.impl.render.skybox;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.mod.modules.impl.render.skybox.Skybox;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import java.awt.Color;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_291;
import net.minecraft.class_293;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5819;
import net.minecraft.class_5820;
import net.minecraft.class_5944;
import net.minecraft.class_638;
import net.minecraft.class_757;
import net.minecraft.class_758;
import org.bytedeco.javacv.BaseSettings;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class CustomSkyRenderer
implements DimensionRenderingRegistry.SkyRenderer {
    private class_291 fog;
    private class_291 nebula1;
    private class_291 stars1;
    private static final class_2960 FOG;
    private class_291 nebula2;
    private Vector3f axis4;
    private class_291 horizon;
    private Vector3f axis2;
    private static final class_2960 NEBULA_1;
    private static final class_2960 STARS;
    private class_291 stars2;
    private Vector3f axis1;
    private class_291 stars4;
    private class_291 stars3;
    private static final class_2960 NEBULA_2;
    private boolean initialised;
    private Vector3f axis3;
    private static final class_2960 HORIZON;

    static {
        NEBULA_1 = CustomSkyRenderer.id(BaseSettings.ALLATORIxDEMO("wQy~J@bS:xUE&Yg_}Pht,\u0012yEy"));
        NEBULA_2 = CustomSkyRenderer.id(TimeHelper.ALLATORIxDEMO("\u001bI\u0016O\f^\u000bHV\u0006\\SGK\u0002B\u0017K\u0004Q\u0013\u000f\u0019R"));
        HORIZON = CustomSkyRenderer.id(BaseSettings.ALLATORIxDEMO("wQy~J@bS:xUE&Yg_}Pht/\u0012yEy"));
        STARS = CustomSkyRenderer.id(TimeHelper.ALLATORIxDEMO("O\u001cT\u001aN\u000b\u0010D\u0005\u001bN\u001e\u000f\u0011S\u0004R\u0011\u0013\u000f\u0019R"));
        FOG = CustomSkyRenderer.id(BaseSettings.ALLATORIxDEMO("FbXa~LYz\u0018qVq\u0013oDy\u0012yEy"));
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ class_291 buildBuffer(class_287 class_2872, class_291 class_2912, double d, double d2, int n, long l, BufferFunction bufferFunction) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        CustomSkyRenderer a7 = class_2912;
        CustomSkyRenderer a8 = this;
        if (a7 != null) {
            a7.close();
        }
        a7 = new class_291(class_291.class_8555.field_44793);
        void v0 = a;
        a2.make((class_287)v0, (double)a6, (double)a5, (int)a4, (long)a3);
        CustomSkyRenderer customSkyRenderer = a7;
        customSkyRenderer.method_1353();
        customSkyRenderer.method_1352(v0.method_1326());
        return customSkyRenderer;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ class_291 buildBufferHorizon(class_287 class_2873, class_291 class_2912) {
        void a;
        CustomSkyRenderer a2 = class_2912;
        CustomSkyRenderer a3 = this;
        return a3.buildBuffer((class_287)a, (class_291)a2, 0.0, 0.0, 0, 0L, (class_2872, d, d2, n, l) -> {
            CustomSkyRenderer a = class_2872;
            CustomSkyRenderer a2 = this;
            a2.makeCylinder((class_287)a, 16, 50.0, 100.0);
        });
    }

    private /* synthetic */ void initialise() {
        CustomSkyRenderer a;
        CustomSkyRenderer customSkyRenderer = a;
        if (!customSkyRenderer.initialised) {
            CustomSkyRenderer customSkyRenderer2 = customSkyRenderer;
            customSkyRenderer2.initStars();
            a = new class_5820(131L);
            CustomSkyRenderer customSkyRenderer3 = customSkyRenderer;
            customSkyRenderer2.axis1 = new Vector3f(a.method_43057(), a.method_43057(), a.method_43057());
            customSkyRenderer3.axis2 = new Vector3f(a.method_43057(), a.method_43057(), a.method_43057());
            customSkyRenderer2.axis3 = new Vector3f(a.method_43057(), a.method_43057(), a.method_43057());
            customSkyRenderer2.axis4 = new Vector3f(a.method_43057(), a.method_43057(), a.method_43057());
            customSkyRenderer2.axis1.normalize();
            customSkyRenderer.axis2.normalize();
            customSkyRenderer.axis3.normalize();
            customSkyRenderer.axis4.normalize();
            customSkyRenderer.initialised = true;
        }
    }

    public static class_2960 id(String a) {
        return new class_2960(TimeHelper.ALLATORIxDEMO("Y\u001cX\u001a^\u000b\u0011F\u0016"), a);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ class_291 buildBufferFog(class_287 class_2873, class_291 class_2912) {
        void a;
        CustomSkyRenderer a2 = class_2912;
        CustomSkyRenderer a3 = this;
        return a3.buildBuffer((class_287)a, (class_291)a2, 0.0, 0.0, 0, 0L, (class_2872, d, d2, n, l) -> {
            CustomSkyRenderer a = class_2872;
            CustomSkyRenderer a2 = this;
            a2.makeCylinder((class_287)a, 16, 50.0, 70.0);
        });
    }

    private /* synthetic */ void initStars() {
        CustomSkyRenderer a;
        CustomSkyRenderer customSkyRenderer = a;
        a = class_289.method_1348().method_1349();
        if (Skybox.INSTANCE.stars.getValue()) {
            CustomSkyRenderer customSkyRenderer2 = customSkyRenderer;
            customSkyRenderer2.stars1 = customSkyRenderer2.buildBuffer((class_287)a, customSkyRenderer2.stars1, 0.1, 0.3, 3500, 41315L, (class_2872, d, d2, n, l) -> {
                void a;
                void a22;
                void a3;
                int n2;
                CustomSkyRenderer customSkyRenderer = this;
                class_5820 class_58202 = new class_5820((long)a22);
                RenderSystem.setShader(class_757::method_34539);
                a3.method_1328(class_293.class_5596.field_27382, class_290.field_1592);
                int n3 = n2 = 0;
                while (n3 < a) {
                    void a4;
                    void a5;
                    double d3;
                    class_5820 class_58203 = class_58202;
                    double a22 = class_58203.method_43058() * 2.0 - 1.0;
                    double d4 = class_58203.method_43058() * 2.0 - 1.0;
                    double d5 = class_58203.method_43058() * 2.0 - 1.0;
                    double d6 = CustomSkyRenderer.randRange((double)a4, (double)a5, (class_5819)class_58202);
                    double d7 = a22;
                    double d8 = d4;
                    double d9 = d5;
                    double d10 = d7 * d7 + d8 * d8 + d9 * d9;
                    if (d3 < 1.0 && d10 > 0.001) {
                        int a6;
                        d10 = 1.0 / Math.sqrt(d10);
                        double d11 = (a22 *= d10) * 100.0;
                        double d12 = (d4 *= d10) * 100.0;
                        d5 *= d10;
                        d10 = d5 * 100.0;
                        double d13 = Math.atan2(a22, d5);
                        double d14 = Math.sin(d13);
                        double d15 = Math.cos(d13);
                        double d16 = a22;
                        double d17 = d5;
                        d13 = Math.atan2(Math.sqrt(d16 * d16 + d17 * d17), d4);
                        a22 = Math.sin(d13);
                        d4 = Math.cos(d13);
                        d13 = class_58202.method_43058() * 3.141592653589793 * 2.0;
                        d5 = Math.sin(d13);
                        d13 = Math.cos(d13);
                        int n4 = a6 = 0;
                        while (n4 < 4) {
                            double d18 = (double)((a6 & 2) - 1) * d6;
                            double d19 = (double)((a6 + 1 & 2) - 1) * d6;
                            double d20 = d18 * d13 - d19 * d5;
                            d18 = d19 * d13 + d18 * d5;
                            d19 = d20 * a22 + 0.0 * d4;
                            d20 = 0.0 * a22 - d20 * d4;
                            double d21 = d20 * d14 - d18 * d15;
                            d18 = d18 * d14 + d20 * d15;
                            a3.method_22912(d11 + d21, d12 + d19, d10 + d18).method_1344();
                            n4 = ++a6;
                        }
                    }
                    n3 = ++n2;
                }
            });
            CustomSkyRenderer customSkyRenderer3 = customSkyRenderer;
            customSkyRenderer3.stars2 = customSkyRenderer3.buildBuffer((class_287)a, customSkyRenderer3.stars2, 0.1, 0.35, 2000, 35151L, (class_2872, d, d2, n, l) -> {
                void a;
                void a22;
                void a3;
                int n2;
                CustomSkyRenderer customSkyRenderer = this;
                class_5820 class_58202 = new class_5820((long)a22);
                RenderSystem.setShader(class_757::method_34539);
                a3.method_1328(class_293.class_5596.field_27382, class_290.field_1592);
                int n3 = n2 = 0;
                while (n3 < a) {
                    void a4;
                    void a5;
                    double d3;
                    class_5820 class_58203 = class_58202;
                    double a22 = class_58203.method_43058() * 2.0 - 1.0;
                    double d4 = class_58203.method_43058() * 2.0 - 1.0;
                    double d5 = class_58203.method_43058() * 2.0 - 1.0;
                    double d6 = CustomSkyRenderer.randRange((double)a4, (double)a5, (class_5819)class_58202);
                    double d7 = a22;
                    double d8 = d4;
                    double d9 = d5;
                    double d10 = d7 * d7 + d8 * d8 + d9 * d9;
                    if (d3 < 1.0 && d10 > 0.001) {
                        int a6;
                        d10 = 1.0 / Math.sqrt(d10);
                        double d11 = (a22 *= d10) * 100.0;
                        double d12 = (d4 *= d10) * 100.0;
                        d5 *= d10;
                        d10 = d5 * 100.0;
                        double d13 = Math.atan2(a22, d5);
                        double d14 = Math.sin(d13);
                        double d15 = Math.cos(d13);
                        double d16 = a22;
                        double d17 = d5;
                        d13 = Math.atan2(Math.sqrt(d16 * d16 + d17 * d17), d4);
                        a22 = Math.sin(d13);
                        d4 = Math.cos(d13);
                        d13 = class_58202.method_43058() * 3.141592653589793 * 2.0;
                        d5 = Math.sin(d13);
                        d13 = Math.cos(d13);
                        int n4 = a6 = 0;
                        while (n4 < 4) {
                            double d18 = (double)((a6 & 2) - 1) * d6;
                            double d19 = (double)((a6 + 1 & 2) - 1) * d6;
                            double d20 = d18 * d13 - d19 * d5;
                            d18 = d19 * d13 + d18 * d5;
                            d19 = d20 * a22 + 0.0 * d4;
                            d20 = 0.0 * a22 - d20 * d4;
                            double d21 = d20 * d14 - d18 * d15;
                            d18 = d18 * d14 + d20 * d15;
                            a3.method_22912(d11 + d21, d12 + d19, d10 + d18).method_1344();
                            n4 = ++a6;
                        }
                    }
                    n3 = ++n2;
                }
            });
            CustomSkyRenderer customSkyRenderer4 = customSkyRenderer;
            customSkyRenderer4.stars3 = customSkyRenderer4.buildBuffer((class_287)a, customSkyRenderer4.stars3, 0.4, 1.2, 1000, 61354L, (class_2872, d, d2, n, l) -> {
                void a;
                void a22;
                void a3;
                int n2;
                CustomSkyRenderer customSkyRenderer = this;
                class_5820 class_58202 = new class_5820((long)a22);
                RenderSystem.setShader(class_757::method_34542);
                a3.method_1328(class_293.class_5596.field_27382, class_290.field_1585);
                int n3 = n2 = 0;
                while (n3 < a) {
                    void a4;
                    void a5;
                    double d3;
                    class_5820 class_58203 = class_58202;
                    double a22 = class_58203.method_43058() * 2.0 - 1.0;
                    double d4 = class_58203.method_43058() * 2.0 - 1.0;
                    double d5 = class_58203.method_43058() * 2.0 - 1.0;
                    double d6 = CustomSkyRenderer.randRange((double)a4, (double)a5, (class_5819)class_58202);
                    double d7 = a22;
                    double d8 = d4;
                    double d9 = d5;
                    double d10 = d7 * d7 + d8 * d8 + d9 * d9;
                    if (d3 < 1.0 && d10 > 0.001) {
                        int a6;
                        d10 = 1.0 / Math.sqrt(d10);
                        double d11 = (a22 *= d10) * 100.0;
                        double d12 = (d4 *= d10) * 100.0;
                        d5 *= d10;
                        d10 = d5 * 100.0;
                        double d13 = Math.atan2(a22, d5);
                        double d14 = Math.sin(d13);
                        double d15 = Math.cos(d13);
                        double d16 = a22;
                        double d17 = d5;
                        d13 = Math.atan2(Math.sqrt(d16 * d16 + d17 * d17), d4);
                        a22 = Math.sin(d13);
                        d4 = Math.cos(d13);
                        class_5820 class_58204 = class_58202;
                        d13 = class_58204.method_43058() * 3.141592653589793 * 2.0;
                        d5 = Math.sin(d13);
                        d13 = Math.cos(d13);
                        float f = (float)class_58204.method_43048(4) / 4.0f;
                        int n4 = a6 = 0;
                        while (n4 < 4) {
                            double d18 = (double)((a6 & 2) - 1) * d6;
                            double d19 = (double)((a6 + 1 & 2) - 1) * d6;
                            double d20 = d18 * d13 - d19 * d5;
                            d18 = d19 * d13 + d18 * d5;
                            d19 = d20 * a22 + 0.0 * d4;
                            d20 = 0.0 * a22 - d20 * d4;
                            double d21 = d20 * d14 - d18 * d15;
                            d18 = d18 * d14 + d20 * d15;
                            float f2 = a6 >> 1 & 1;
                            float f3 = (float)(a6 + 1 >> 1 & 1) / 4.0f + f;
                            a3.method_22912(d11 + d21, d12 + d19, d10 + d18).method_22913(f2, f3).method_1344();
                            n4 = ++a6;
                        }
                    }
                    n3 = ++n2;
                }
            });
            CustomSkyRenderer customSkyRenderer5 = customSkyRenderer;
            customSkyRenderer5.stars4 = customSkyRenderer5.buildBuffer((class_287)a, customSkyRenderer5.stars4, 0.4, 1.2, 1000, 61355L, (class_2872, d, d2, n, l) -> {
                void a;
                void a22;
                void a3;
                int n2;
                CustomSkyRenderer customSkyRenderer = this;
                class_5820 class_58202 = new class_5820((long)a22);
                RenderSystem.setShader(class_757::method_34542);
                a3.method_1328(class_293.class_5596.field_27382, class_290.field_1585);
                int n3 = n2 = 0;
                while (n3 < a) {
                    void a4;
                    void a5;
                    double d3;
                    class_5820 class_58203 = class_58202;
                    double a22 = class_58203.method_43058() * 2.0 - 1.0;
                    double d4 = class_58203.method_43058() * 2.0 - 1.0;
                    double d5 = class_58203.method_43058() * 2.0 - 1.0;
                    double d6 = CustomSkyRenderer.randRange((double)a4, (double)a5, (class_5819)class_58202);
                    double d7 = a22;
                    double d8 = d4;
                    double d9 = d5;
                    double d10 = d7 * d7 + d8 * d8 + d9 * d9;
                    if (d3 < 1.0 && d10 > 0.001) {
                        int a6;
                        d10 = 1.0 / Math.sqrt(d10);
                        double d11 = (a22 *= d10) * 100.0;
                        double d12 = (d4 *= d10) * 100.0;
                        d5 *= d10;
                        d10 = d5 * 100.0;
                        double d13 = Math.atan2(a22, d5);
                        double d14 = Math.sin(d13);
                        double d15 = Math.cos(d13);
                        double d16 = a22;
                        double d17 = d5;
                        d13 = Math.atan2(Math.sqrt(d16 * d16 + d17 * d17), d4);
                        a22 = Math.sin(d13);
                        d4 = Math.cos(d13);
                        class_5820 class_58204 = class_58202;
                        d13 = class_58204.method_43058() * 3.141592653589793 * 2.0;
                        d5 = Math.sin(d13);
                        d13 = Math.cos(d13);
                        float f = (float)class_58204.method_43048(4) / 4.0f;
                        int n4 = a6 = 0;
                        while (n4 < 4) {
                            double d18 = (double)((a6 & 2) - 1) * d6;
                            double d19 = (double)((a6 + 1 & 2) - 1) * d6;
                            double d20 = d18 * d13 - d19 * d5;
                            d18 = d19 * d13 + d18 * d5;
                            d19 = d20 * a22 + 0.0 * d4;
                            d20 = 0.0 * a22 - d20 * d4;
                            double d21 = d20 * d14 - d18 * d15;
                            d18 = d18 * d14 + d20 * d15;
                            float f2 = a6 >> 1 & 1;
                            float f3 = (float)(a6 + 1 >> 1 & 1) / 4.0f + f;
                            a3.method_22912(d11 + d21, d12 + d19, d10 + d18).method_22913(f2, f3).method_1344();
                            n4 = ++a6;
                        }
                    }
                    n3 = ++n2;
                }
            });
        }
        CustomSkyRenderer customSkyRenderer6 = customSkyRenderer;
        customSkyRenderer.nebula1 = customSkyRenderer6.buildBuffer((class_287)a, customSkyRenderer6.nebula1, 40.0, 60.0, 30, 11515L, (class_2872, d, d2, n, l) -> {
            void a;
            void a22;
            void a3;
            int n2;
            CustomSkyRenderer customSkyRenderer = this;
            class_5820 class_58202 = new class_5820((long)a22);
            RenderSystem.setShader(class_757::method_34542);
            a3.method_1328(class_293.class_5596.field_27382, class_290.field_1585);
            int n3 = n2 = 0;
            while (n3 < a) {
                void a4;
                void a5;
                class_5820 class_58203 = class_58202;
                double a22 = class_58203.method_43058() * 2.0 - 1.0;
                double d3 = class_58203.method_43058() - 0.5;
                double d4 = class_58203.method_43058() * 2.0 - 1.0;
                double d5 = CustomSkyRenderer.randRange((double)a4, (double)a5, (class_5819)class_58202);
                double d6 = a22;
                double d7 = d3;
                double d8 = d4;
                double d9 = d6 * d6 + d7 * d7 + d8 * d8;
                double d10 = 2.0;
                if (d9 < 1.0 && d9 > 0.001) {
                    int a6;
                    d9 = d10 / Math.sqrt(d9);
                    d5 *= d10;
                    d10 = (a22 *= d9) * 100.0;
                    double d11 = (d3 *= d9) * 100.0;
                    d4 *= d9;
                    d9 = d4 * 100.0;
                    double d12 = Math.atan2(a22, d4);
                    double d13 = Math.sin(d12);
                    double d14 = Math.cos(d12);
                    double d15 = a22;
                    double d16 = d4;
                    d12 = Math.atan2(Math.sqrt(d15 * d15 + d16 * d16), d3);
                    a22 = Math.sin(d12);
                    d3 = Math.cos(d12);
                    d12 = class_58202.method_43058() * 3.141592653589793 * 2.0;
                    d4 = Math.sin(d12);
                    d12 = Math.cos(d12);
                    int n4 = a6 = 0;
                    while (n4 < 4) {
                        double d17 = (double)((a6 & 2) - 1) * d5;
                        double d18 = (double)((a6 + 1 & 2) - 1) * d5;
                        double d19 = d17 * d12 - d18 * d4;
                        d17 = d18 * d12 + d17 * d4;
                        d18 = d19 * a22 + 0.0 * d3;
                        d19 = 0.0 * a22 - d19 * d3;
                        double d20 = d19 * d13 - d17 * d14;
                        d17 = d17 * d13 + d19 * d14;
                        float f = a6 >> 1 & 1;
                        float f2 = a6 + 1 >> 1 & 1;
                        a3.method_22912(d10 + d20, d11 + d18, d9 + d17).method_22913(f, f2).method_1344();
                        n4 = ++a6;
                    }
                }
                n3 = ++n2;
            }
        });
        CustomSkyRenderer customSkyRenderer7 = customSkyRenderer;
        customSkyRenderer7.nebula2 = customSkyRenderer7.buildBuffer((class_287)a, customSkyRenderer7.nebula2, 40.0, 60.0, 10, 14151L, (class_2872, d, d2, n, l) -> {
            void a;
            void a22;
            void a3;
            int n2;
            CustomSkyRenderer customSkyRenderer = this;
            class_5820 class_58202 = new class_5820((long)a22);
            RenderSystem.setShader(class_757::method_34542);
            a3.method_1328(class_293.class_5596.field_27382, class_290.field_1585);
            int n3 = n2 = 0;
            while (n3 < a) {
                void a4;
                void a5;
                class_5820 class_58203 = class_58202;
                double a22 = class_58203.method_43058() * 2.0 - 1.0;
                double d3 = class_58203.method_43058() - 0.5;
                double d4 = class_58203.method_43058() * 2.0 - 1.0;
                double d5 = CustomSkyRenderer.randRange((double)a4, (double)a5, (class_5819)class_58202);
                double d6 = a22;
                double d7 = d3;
                double d8 = d4;
                double d9 = d6 * d6 + d7 * d7 + d8 * d8;
                double d10 = 2.0;
                if (d9 < 1.0 && d9 > 0.001) {
                    int a6;
                    d9 = d10 / Math.sqrt(d9);
                    d5 *= d10;
                    d10 = (a22 *= d9) * 100.0;
                    double d11 = (d3 *= d9) * 100.0;
                    d4 *= d9;
                    d9 = d4 * 100.0;
                    double d12 = Math.atan2(a22, d4);
                    double d13 = Math.sin(d12);
                    double d14 = Math.cos(d12);
                    double d15 = a22;
                    double d16 = d4;
                    d12 = Math.atan2(Math.sqrt(d15 * d15 + d16 * d16), d3);
                    a22 = Math.sin(d12);
                    d3 = Math.cos(d12);
                    d12 = class_58202.method_43058() * 3.141592653589793 * 2.0;
                    d4 = Math.sin(d12);
                    d12 = Math.cos(d12);
                    int n4 = a6 = 0;
                    while (n4 < 4) {
                        double d17 = (double)((a6 & 2) - 1) * d5;
                        double d18 = (double)((a6 + 1 & 2) - 1) * d5;
                        double d19 = d17 * d12 - d18 * d4;
                        d17 = d18 * d12 + d17 * d4;
                        d18 = d19 * a22 + 0.0 * d3;
                        d19 = 0.0 * a22 - d19 * d3;
                        double d20 = d19 * d13 - d17 * d14;
                        d17 = d17 * d13 + d19 * d14;
                        float f = a6 >> 1 & 1;
                        float f2 = a6 + 1 >> 1 & 1;
                        a3.method_22912(d10 + d20, d11 + d18, d9 + d17).method_22913(f, f2).method_1344();
                        n4 = ++a6;
                    }
                }
                n3 = ++n2;
            }
        });
        CustomSkyRenderer customSkyRenderer8 = customSkyRenderer;
        CustomSkyRenderer customSkyRenderer9 = customSkyRenderer;
        customSkyRenderer9.horizon = customSkyRenderer9.buildBufferHorizon((class_287)a, customSkyRenderer9.horizon);
        customSkyRenderer8.fog = customSkyRenderer8.buildBufferFog((class_287)a, customSkyRenderer8.fog);
    }

    public static double randRange(double a, double a2, class_5819 a3) {
        return a + a3.method_43058() * (a2 - a);
    }

    public void render(WorldRenderContext a3) {
        Object a2;
        CustomSkyRenderer customSkyRenderer = a2;
        if (a3.world() == null || a3.matrixStack() == null) {
            return;
        }
        customSkyRenderer.initialise();
        WorldRenderContext worldRenderContext = a3;
        Matrix4f matrix4f = worldRenderContext.projectionMatrix();
        class_4587 class_45872 = worldRenderContext.matrixStack();
        float f = ((float)worldRenderContext.world().method_8532() + a3.tickDelta()) % 360000.0f * 1.7453292E-5f;
        float f2 = f * 2.0f;
        float f3 = f * 3.0f;
        class_758.method_3212();
        RenderSystem.depthMask((boolean)false);
        RenderSystem.enableBlend();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.blendFunc((GlStateManager.class_4535)GlStateManager.class_4535.SRC_ALPHA, (GlStateManager.class_4534)GlStateManager.class_4534.ONE_MINUS_SRC_ALPHA);
        float f4 = 1.0f;
        float f5 = 1.0f * 0.2f;
        float f6 = f4 * 0.6f;
        if (f4 > 0.0f) {
            class_4587 class_45873 = class_45872;
            class_4587 class_45874 = class_45872;
            class_45872.method_22903();
            class_4587 class_45875 = class_45872;
            class_45874.method_22907(new Quaternionf().rotationXYZ(0.0f, f, 0.0f));
            RenderSystem.setShaderTexture((int)0, (class_2960)HORIZON);
            a2 = Skybox.INSTANCE.color.getValue();
            CustomSkyRenderer customSkyRenderer2 = customSkyRenderer;
            customSkyRenderer2.renderBuffer(class_45872, matrix4f, customSkyRenderer2.horizon, class_290.field_1585, (float)((Color)a2).getRed() / 255.0f, (float)((Color)a2).getGreen() / 255.0f, (float)((Color)a2).getBlue() / 255.0f, 0.7f * f4);
            class_45873.method_22909();
            class_45874.method_22903();
            class_45873.method_22907(new Quaternionf().rotationXYZ(0.0f, -f, 0.0f));
            RenderSystem.setShaderTexture((int)0, (class_2960)NEBULA_1);
            a2 = Skybox.INSTANCE.color2.getValue();
            CustomSkyRenderer customSkyRenderer3 = customSkyRenderer;
            customSkyRenderer3.renderBuffer(class_45872, matrix4f, customSkyRenderer3.nebula1, class_290.field_1585, (float)((Color)a2).getRed() / 255.0f, (float)((Color)a2).getGreen() / 255.0f, (float)((Color)a2).getBlue() / 255.0f, f5);
            class_45873.method_22909();
            class_45873.method_22903();
            class_45873.method_22907(new Quaternionf().rotationXYZ(0.0f, f2, 0.0f));
            RenderSystem.setShaderTexture((int)0, (class_2960)NEBULA_2);
            a2 = Skybox.INSTANCE.color3.getValue();
            CustomSkyRenderer customSkyRenderer4 = customSkyRenderer;
            customSkyRenderer4.renderBuffer(class_45872, matrix4f, customSkyRenderer4.nebula2, class_290.field_1585, (float)((Color)a2).getRed() / 255.0f, (float)((Color)a2).getGreen() / 255.0f, (float)((Color)a2).getBlue() / 255.0f, f5);
            class_45873.method_22909();
            if (Skybox.INSTANCE.stars.getValue()) {
                RenderSystem.setShaderTexture((int)0, (class_2960)STARS);
                class_4587 class_45876 = class_45872;
                class_45876.method_22903();
                class_45876.method_22907(new Quaternionf().setAngleAxis(f, customSkyRenderer.axis3.x, customSkyRenderer.axis3.y, customSkyRenderer.axis3.z));
                a2 = Skybox.INSTANCE.color4.getValue();
                class_4587 class_45877 = class_45872;
                customSkyRenderer.renderBuffer(class_45877, matrix4f, customSkyRenderer.stars3, class_290.field_1585, (float)((Color)a2).getRed() / 255.0f, (float)((Color)a2).getGreen() / 255.0f, (float)((Color)a2).getBlue() / 255.0f, f6);
                class_45877.method_22909();
                class_45876.method_22903();
                class_45876.method_22907(new Quaternionf().setAngleAxis(f2, customSkyRenderer.axis4.x, customSkyRenderer.axis4.y, customSkyRenderer.axis4.z));
                a2 = Skybox.INSTANCE.color5.getValue();
                CustomSkyRenderer customSkyRenderer5 = customSkyRenderer;
                customSkyRenderer5.renderBuffer(class_45872, matrix4f, customSkyRenderer5.stars4, class_290.field_1585, (float)((Color)a2).getRed() / 255.0f, (float)((Color)a2).getGreen() / 255.0f, (float)((Color)a2).getBlue() / 255.0f, f6);
                class_45876.method_22909();
            }
        }
        float a3 = 0.0f;
        if (0.0f > 0.0f) {
            if (a3 > 1.0f) {
                a3 = 1.0f;
            }
            RenderSystem.setShaderTexture((int)0, (class_2960)FOG);
            CustomSkyRenderer customSkyRenderer6 = customSkyRenderer;
            customSkyRenderer6.renderBuffer(class_45872, matrix4f, customSkyRenderer6.fog, class_290.field_1585, 0.3061791f, 0.2449433f, 0.3061791f, a3);
        }
        if (Skybox.INSTANCE.stars.getValue() && f4 > 0.0f) {
            class_4587 class_45878 = class_45872;
            class_4587 class_45879 = class_45872;
            class_4587 class_458710 = class_45872;
            class_458710.method_22903();
            class_458710.method_22907(new Quaternionf().setAngleAxis(f3, customSkyRenderer.axis1.x, customSkyRenderer.axis1.y, customSkyRenderer.axis1.z));
            customSkyRenderer.renderBuffer(class_45879, matrix4f, customSkyRenderer.stars1, class_290.field_1592, 1.0f, 1.0f, 1.0f, f6);
            class_45879.method_22909();
            class_45879.method_22903();
            class_45878.method_22907(new Quaternionf().setAngleAxis(f2, customSkyRenderer.axis2.x, customSkyRenderer.axis2.y, customSkyRenderer.axis2.z));
            customSkyRenderer.renderBuffer(class_45878, matrix4f, customSkyRenderer.stars2, class_290.field_1592, 0.95f, 0.64f, 0.93f, f6);
            class_45878.method_22909();
        }
        RenderSystem.depthMask((boolean)true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void makeCylinder(class_287 class_2872, int n, double d, double d2) {
        void a;
        void a2;
        int a3;
        CustomSkyRenderer customSkyRenderer = this;
        RenderSystem.setShader(class_757::method_34542);
        a2.method_1328(class_293.class_5596.field_27382, class_290.field_1585);
        int n2 = a3 = 0;
        while (n2 < a) {
            void a4;
            void a5;
            double d3 = (double)a3 * 3.141592653589793 * 2.0 / (double)a;
            double d4 = (double)(a3 + 1) * 3.141592653589793 * 2.0 / (double)a;
            double d5 = Math.sin(d3) * a5;
            d3 = Math.cos(d3) * a5;
            double d6 = Math.sin(d4) * a5;
            d4 = Math.cos(d4) * a5;
            float f = (float)a3 / (float)a;
            float f2 = (float)(a3 + 1) / (float)a;
            void v1 = a2;
            void v2 = a2;
            v2.method_22912(d5, (double)(-a4), d3).method_22913(f, 0.0f).method_1344();
            v2.method_22912(d5, (double)a4, d3).method_22913(f, 1.0f).method_1344();
            v1.method_22912(d6, (double)a4, d4).method_22913(f2, 1.0f).method_1344();
            v1.method_22912(d6, (double)(-a4), d4).method_22913(f2, 0.0f).method_1344();
            n2 = ++a3;
        }
    }

    public CustomSkyRenderer() {
        CustomSkyRenderer a;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void renderBuffer(class_4587 class_45872, Matrix4f matrix4f, class_291 class_2912, class_293 class_2932, float f, float f2, float f3, float f4) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        void a7;
        CustomSkyRenderer a8 = class_2912;
        CustomSkyRenderer a9 = this;
        RenderSystem.setShaderColor((float)a5, (float)a3, (float)a4, (float)a7);
        a8.method_1353();
        if (a6 == class_290.field_1592) {
            a8.method_34427(a2.method_23760().method_23761(), (Matrix4f)a, class_757.method_34539());
        } else {
            a8.method_34427(a2.method_23760().method_23761(), (Matrix4f)a, class_757.method_34542());
        }
        class_291.method_1354();
    }

    @FunctionalInterface
    static interface BufferFunction {
        public void make(class_287 var1, double var2, double var4, int var6, long var7);
    }

}
