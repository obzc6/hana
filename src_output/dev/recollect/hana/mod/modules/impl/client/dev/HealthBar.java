/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1041
 *  net.minecraft.class_286
 *  net.minecraft.class_287
 *  net.minecraft.class_287$class_7433
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_746
 *  net.minecraft.class_757
 *  org.joml.Math
 *  org.joml.Matrix4f
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.video.Renderer;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;
import java.util.function.Predicate;
import net.minecraft.class_1041;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_746;
import net.minecraft.class_757;
import org.joml.Math;
import org.joml.Matrix4f;

public class HealthBar
extends Module {
    private final SliderSetting minAccumulate;
    private final SliderSetting accumulate;
    private final SliderSetting yOffset;
    private static final Stack<Float> alphaMultipliers;
    private final SliderSetting movingms;
    private final SliderSetting movingms2;
    private final BooleanSetting rainBow;
    static DecimalFormat df;
    private final SliderSetting saturation;
    private final ColorSetting bgcolor;
    private final ColorSetting charging;
    private final SliderSetting rainbowSpeed;
    int progress;
    private final SliderSetting ra;
    private final SliderSetting rainbowDelay;
    private final Timer timer;
    private final SliderSetting pulseCounter;
    private final ColorSetting work;
    private final SliderSetting xOffset;
    public static HealthBar INSTANCE;

    public static float transformColor(float a) {
        return HealthBar.compute((int)(a * 255.0f)) / 255.0f;
    }

    private /* synthetic */ Color rainbow(int n) {
        int a = n;
        HealthBar a2 = this;
        return Color.getHSBColor((float)(java.lang.Math.ceil(((double)a2.progress + (double)a * a2.rainbowDelay.getValue()) / 20.0) % 360.0 / 360.0), a2.saturation.getValueFloat() / 255.0f, 1.0f);
    }

    public static void setupRender() {
        RenderSystem.enableBlend();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void endRender() {
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }

    /*
     * WARNING - void declaration
     */
    public void renderRoundedQuadInternal(Matrix4f matrix4f, float f, float f2, float f3, float f4, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        void a14;
        void a23;
        double a32;
        int n;
        void a222;
        void a4;
        void a5;
        double a6;
        void a7;
        HealthBar healthBar = this;
        HealthBar a8 = class_289.method_1348().method_1349();
        a8.method_1328(class_293.class_5596.field_27381, class_290.field_1576);
        double[][] arrarrd = new double[4][];
        double[] arrd = new double[3];
        arrd[0] = a222 - a4;
        arrd[1] = a14 - a4;
        arrd[2] = a4;
        arrarrd[0] = arrd;
        double[] arrd2 = new double[3];
        arrd2[0] = a222 - a7;
        arrd2[1] = a32 + a7;
        arrd2[2] = a7;
        arrarrd[1] = arrd2;
        double[] arrd3 = new double[3];
        arrd3[0] = a6 + a23;
        arrd3[1] = a32 + a23;
        arrd3[2] = a23;
        arrarrd[2] = arrd3;
        double[] arrd4 = new double[3];
        arrd4[0] = a6 + a5;
        arrd4[1] = a14 - a5;
        arrd4[2] = a5;
        arrarrd[3] = arrd4;
        double[][] a222 = arrarrd;
        int n2 = n = 0;
        while (n2 < 4) {
            void a9;
            void a10;
            void a11;
            void a12;
            float f5;
            void a13;
            double[] a14 = a222[n];
            a6 = a14[2];
            double d10 = (double)n * 90.0;
            while (d10 < 90.0 + (double)n * 90.0) {
                void a15;
                f5 = (float)Math.toRadians((double)a32);
                float a23 = (float)((double)Math.sin((float)f5) * a6);
                float f6 = (float)((double)Math.cos((float)f5) * a6);
                a8.method_22918((Matrix4f)a11, (float)a14[0] + a23, (float)a14[1] + f6, 0.0f).method_22915((float)a12, (float)a9, (float)a10, (float)a13).method_1344();
                d10 = a32 + 90.0 / a15;
            }
            float a32 = (float)Math.toRadians((double)(90.0 + (double)n * 90.0));
            float f7 = (float)((double)Math.sin((float)a32) * a6);
            f5 = (float)((double)Math.cos((float)a32) * a6);
            a8.method_22918((Matrix4f)a11, (float)a14[0] + f7, (float)a14[1] + f5, 0.0f).method_22915((float)a12, (float)a9, (float)a10, (float)a13).method_1344();
            n2 = ++n;
        }
        class_286.method_43433((class_287.class_7433)a8.method_1326());
    }

    static {
        df = new DecimalFormat(Renderer.ALLATORIxDEMO("Md\u0007"));
        alphaMultipliers = new Stack();
    }

    public HealthBar() {
        HealthBar a;
        HealthBar healthBar = a;
        super(Renderer.ALLATORIxDEMO("(\u0006q\u0014h?+E"), Module.Category.Client);
        HealthBar healthBar2 = a;
        healthBar2.xOffset = healthBar.add(new SliderSetting(ObsidianHelper.ALLATORIxDEMO("\u0016A\u0003K5[!"), 0.0, -400.0, 400.0, 1.0));
        healthBar.yOffset = healthBar.add(new SliderSetting(Renderer.ALLATORIxDEMO("?R\u0006f\u000e/C"), 0.0, -400.0, 400.0, 1.0));
        healthBar.movingms = healthBar.add(new SliderSetting(ObsidianHelper.ALLATORIxDEMO("I x\fC!S&"), 0.0, 0.0, 300.0, 1.0));
        healthBar.movingms2 = healthBar.add(new SliderSetting(Renderer.ALLATORIxDEMO("\ru\u0011t\u000eg\u00109\u0005"), 0.0, 0.0, 300.0, 1.0));
        healthBar.minAccumulate = healthBar.add(new SliderSetting(ObsidianHelper.ALLATORIxDEMO("\u001eM!M\rL4Y0"), 500.0, 1.0, 10000.0, 50.0).setSuffix(Renderer.ALLATORIxDEMO("'D")));
        healthBar.accumulate = healthBar.add(new SliderSetting(ObsidianHelper.ALLATORIxDEMO("M\rL4Y0"), 2000.0, 1.0, 10000.0, 50.0).setSuffix(Renderer.ALLATORIxDEMO("'D")));
        healthBar.ra = healthBar.add(new SliderSetting(ObsidianHelper.ALLATORIxDEMO("|\u0004I/K&"), 3, 0, 10));
        healthBar.rainBow = healthBar.add(new BooleanSetting(Renderer.ALLATORIxDEMO("5|\tn\u001f%@"), false)).setParent();
        healthBar.pulseCounter = healthBar.add(new SliderSetting(ObsidianHelper.ALLATORIxDEMO("p>T A\fa\u0010C2['"), 1, 1, 10, object -> {
            Object a = object;
            HealthBar a2 = this;
            return a2.rainBow.isOpen();
        }));
        a.rainbowSpeed = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("\u001aTt\u000ex\bj3p\u0018/S"), 200, 1, 400, object -> {
            Object a = object;
            HealthBar a2 = this;
            return a2.rainBow.isOpen();
        }));
        a.saturation = a.add(new SliderSetting(ObsidianHelper.ALLATORIxDEMO("k2P:|\u0004Y/Q;"), 130.0, 1.0, 255.0, object -> {
            Object a = object;
            HealthBar a2 = this;
            return a2.rainBow.isOpen();
        }));
        a.rainbowDelay = a.add(new SliderSetting(Renderer.ALLATORIxDEMO("$e\u0011+N"), 350, 0, 600, object -> {
            Object a = object;
            HealthBar a2 = this;
            return a2.rainBow.isOpen();
        }));
        HealthBar healthBar3 = a;
        HealthBar healthBar4 = a;
        healthBar4.work = healthBar4.add(new ColorSetting(ObsidianHelper.ALLATORIxDEMO("\u0010K\"~\tH2[1"), new Color(0, 255, 0)));
        healthBar4.charging = healthBar4.add(new ColorSetting(Renderer.ALLATORIxDEMO("Y\u000f|\u0012g\u0014$P"), new Color(255, 0, 0)));
        healthBar4.bgcolor = healthBar4.add(new ColorSetting(ObsidianHelper.ALLATORIxDEMO("-i&B*Q'"), new Color(187, 187, 187, 150)));
        healthBar4.timer = new Timer();
        healthBar3.progress = 0;
        healthBar3.setChinese(Renderer.ALLATORIxDEMO("\u880a\u6756"));
        INSTANCE = healthBar3;
    }

    @Override
    public void onRender2D(class_332 class_3322, float f) {
        HealthBar healthBar;
        HealthBar a = class_3322;
        HealthBar a2 = this;
        if (HealthBar.nullCheck()) {
            return;
        }
        double d = HealthBar.mc.field_1724.method_6032() + HealthBar.mc.field_1724.method_6067();
        double d2 = Math.max((double)(a2.movingms.getValue() - a2.movingms2.getValue()), (double)0.0);
        boolean a3 = d2 > 0.0 || d2 >= (double)a2.minAccumulate.getValueInt();
        a2.accumulate.getValue();
        ObsidianHelper.ALLATORIxDEMO("F\u0000L*J=");
        HealthBar healthBar2 = a2;
        d2 = (double)(mc.method_22683().method_4486() / 3) - healthBar2.xOffset.getValue();
        double d3 = (double)(mc.method_22683().method_4502() / 2) + a2.yOffset.getValue();
        if (!healthBar2.rainBow.getValue()) {
            Color color;
            double d4;
            HealthBar healthBar3 = a2;
            if (a3) {
                color = healthBar3.work.getValue();
                d4 = d2;
            } else {
                color = healthBar3.charging.getValue();
                d4 = d2;
            }
            Objects.requireNonNull(HealthBar.mc.field_1772);
            Objects.requireNonNull(HealthBar.mc.field_1772);
            Objects.requireNonNull(HealthBar.mc.field_1772);
            healthBar3.renderRoundedQuad(a.method_51448(), color, d4, d3 + (double)((55 - 9) / 3), d2 + d * 100.0 / 36.0, d3 + (double)((55 - 9) / 3) + 9.0, a2.ra.getValue(), 4.0, false);
            healthBar = a2;
        } else {
            double d5;
            if (a2.timer.passed(50L)) {
                HealthBar healthBar4 = a2;
                a2.progress -= healthBar4.rainbowSpeed.getValueInt();
                healthBar4.timer.reset();
            }
            int n = 20;
            double d6 = d5 = 0.0;
            while (d6 <= d * 100.0 / 36.0 - 1.5) {
                double d7;
                HealthBar healthBar5 = a2;
                if (d5 <= d * 100.0 / 36.0 - 1.5) {
                    Objects.requireNonNull(HealthBar.mc.field_1772);
                    Objects.requireNonNull(HealthBar.mc.field_1772);
                    Objects.requireNonNull(HealthBar.mc.field_1772);
                    healthBar5.renderRoundedQuad(a.method_51448(), a2.rainbow(n), d2 + d5, d3 + (double)((55 - 9) / 3), d2 + d * 100.0 / 36.0, d3 + (double)((55 - 9) / 3) + 9.0, a2.ra.getValue(), 4.0, false);
                    d7 = d5;
                } else {
                    Objects.requireNonNull(HealthBar.mc.field_1772);
                    Objects.requireNonNull(HealthBar.mc.field_1772);
                    Objects.requireNonNull(HealthBar.mc.field_1772);
                    healthBar5.renderRoundedQuad(a.method_51448(), a2.rainbow(n), d2 + d5, d3 + (double)((55 - 9) / 3), d2 + d * 100.0 / 36.0, d3 + (double)((55 - 9) / 3) + 9.0, a2.ra.getValue(), 4.0, false);
                    d7 = d5;
                }
                d6 = d7 + 1.5;
            }
            healthBar = a2;
        }
        Objects.requireNonNull(HealthBar.mc.field_1772);
        double d8 = d2;
        Objects.requireNonNull(HealthBar.mc.field_1772);
        Objects.requireNonNull(HealthBar.mc.field_1772);
        healthBar.renderRoundedQuad(a.method_51448(), a2.bgcolor.getValue(), d8, d3 + (double)((55 - 9) / 3), d8 + 100.0, d3 + (double)((55 - 9) / 3) + 9.0, 0.0, 4.0, false);
        Objects.requireNonNull(HealthBar.mc.field_1772);
        double d9 = d3 + (double)((55 - 9) / 3);
    }

    /*
     * WARNING - void declaration
     */
    public void renderRoundedQuad(class_4587 class_45872, Color color, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, boolean bl) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        void a7;
        void a8;
        void a9;
        Matrix4f a10;
        HealthBar a3222 = class_45872;
        HealthBar a11 = this;
        int a3222 = a10.getRGB();
        a10 = a3222.method_23760().method_23761();
        float a12 = HealthBar.transformColor((float)(a3222 >> 24 & 255) / 255.0f);
        float f = (float)(a3222 >> 16 & 255) / 255.0f;
        float f2 = (float)(a3222 >> 8 & 255) / 255.0f;
        float a3222 = (float)(a3222 & 255) / 255.0f;
        HealthBar.setupRender();
        RenderSystem.setShader(class_757::method_34540);
        a11.renderRoundedQuadInternal(a10, f, f2, a3222, a12, (double)a7, (double)a9, (double)a6, (double)a2, (double)a4, (double)a3, (double)a, (double)a5, (double)a8);
        HealthBar.endRender();
    }

    /*
     * WARNING - void declaration
     */
    public void renderRoundedQuad(class_4587 class_45872, Color color, double d, double d2, double d3, double d4, double d5, double d6, boolean bl) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        void a7;
        void a8;
        void a9;
        boolean bl2 = bl;
        HealthBar a10 = this;
        void v0 = a;
        a10.renderRoundedQuad((class_4587)a9, (Color)a6, (double)a5, (double)a8, (double)a3, (double)a4, (double)v0, (double)v0, (double)v0, (double)v0, (double)a2, (boolean)a7);
    }

    public static float compute(int a2) {
        Iterator iterator;
        int n = a2;
        float a2 = n;
        Iterator iterator2 = iterator = alphaMultipliers.iterator();
        while (iterator2.hasNext()) {
            Float f = (Float)iterator.next();
            a2 *= f.floatValue();
            iterator2 = iterator;
        }
        return a2;
    }
}
