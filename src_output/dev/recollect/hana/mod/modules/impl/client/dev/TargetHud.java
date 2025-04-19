/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_286
 *  net.minecraft.class_287
 *  net.minecraft.class_287$class_7433
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_638
 *  net.minecraft.class_742
 *  net.minecraft.class_746
 *  net.minecraft.class_757
 *  net.minecraft.class_8685
 *  org.joml.Math
 *  org.joml.Matrix4f
 *  org.joml.Vector4d
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.FriendManager;
import dev.recollect.hana.api.managers.PopManager;
import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.gui.nullpoint.font.FontAdapter;
import dev.recollect.hana.mod.gui.nullpoint.font.FontRenderers;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.dev.BetterAnimation;
import dev.recollect.hana.mod.modules.impl.client.dev.BetterDynamicAnimation;
import dev.recollect.hana.mod.modules.impl.combat.Aura;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.HanaAura;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_638;
import net.minecraft.class_742;
import net.minecraft.class_746;
import net.minecraft.class_757;
import net.minecraft.class_8685;
import org.joml.Matrix4f;
import org.joml.Vector4d;

public class TargetHud
extends Module {
    public static BetterDynamicAnimation hurtAnimation;
    private final SliderSetting yOffset;
    private final SliderSetting rainbowSpeed;
    public static BetterDynamicAnimation healthAnimation;
    private final Timer timer;
    private final BooleanSetting customFont;
    private final BooleanSetting move;
    public BetterAnimation animation;
    private final SliderSetting pulseCounter;
    private final ColorSetting textColor;
    private final SliderSetting saturation;
    private boolean direction;
    private final SliderSetting xOffset;
    private final ColorSetting healthColor;
    public static TargetHud INSTANCE;
    private final SliderSetting ra;
    int progress;
    private final ColorSetting colorBack;
    private final BooleanSetting rainBow;
    private static final Stack<Float> alphaMultipliers;
    private final SliderSetting blur;
    private final SliderSetting moveDis;
    private final SliderSetting rainbowDelay;

    public TargetHud() {
        TargetHud a;
        TargetHud targetHud = a;
        super(Tab.ALLATORIxDEMO("8i\u0019h\tf9-_"), Module.Category.Render);
        TargetHud targetHud2 = a;
        targetHud2.xOffset = targetHud.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u0013"), 0, 0, 2000));
        targetHud.yOffset = targetHud.add(new SliderSetting(Tab.ALLATORIxDEMO("b"), 10, 0, 2000));
        targetHud.colorBack = targetHud.add(new ColorSetting(GaussianKernel.ALLATORIxDEMO("\u001a+*02\u0015'/7/"), new Color(0, 0, 0, 200)));
        targetHud.blur = targetHud.add(new SliderSetting(Tab.ALLATORIxDEMO("P\u001d-I"), 20, 0, 50));
        targetHud.customFont = targetHud.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u001b?:/\u001a\n\u000e57?"), true));
        targetHud.healthColor = targetHud.add(new ColorSetting(Tab.ALLATORIxDEMO("G\ts\u001d,S"), new Color(255, 0, 0, 200)));
        targetHud.textColor = targetHud.add(new ColorSetting(GaussianKernel.ALLATORIxDEMO("\u001c?!?"), new Color(255, 255, 255, 255)));
        targetHud.rainBow = targetHud.add(new BooleanSetting(Tab.ALLATORIxDEMO("9n\u0005|\u00137L"), false)).setParent();
        targetHud.pulseCounter = targetHud.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\n=49,\u0018\u001a\u0012&.<9"), 1, 1, 10, object -> {
            Object a = object;
            TargetHud a2 = this;
            return a2.rainBow.isOpen();
        }));
        a.rainbowSpeed = a.add(new SliderSetting(Tab.ALLATORIxDEMO("\bXf\u0002j\u0004x?b\u0014=_"), 200, 1, 400, object -> {
            Object a = object;
            TargetHud a2 = this;
            return a2.rainBow.isOpen();
        }));
        a.saturation = a.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u000b+=.\u0007\u0006<36%"), 130.0, 1.0, 255.0, object -> {
            Object a = object;
            TargetHud a2 = this;
            return a2.rainBow.isOpen();
        }));
        a.rainbowDelay = a.add(new SliderSetting(Tab.ALLATORIxDEMO("(w\u001d9B"), 350, 0, 600, object -> {
            Object a = object;
            TargetHud a2 = this;
            return a2.rainBow.isOpen();
        }));
        TargetHud targetHud3 = a;
        targetHud3.move = targetHud3.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u0014\u001bG*5=2"), false)).setParent();
        targetHud3.moveDis = targetHud3.add(new SliderSetting(Tab.ALLATORIxDEMO("|\u001e\"#5]vLL\u0002|\u0018s\u001f;^"), 8, 1, 100, object -> {
            Object a = object;
            TargetHud a2 = this;
            return a2.move.isOpen();
        }));
        TargetHud targetHud4 = a;
        TargetHud targetHud5 = a;
        TargetHud targetHud6 = a;
        targetHud6.ra = a.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u0007\u0006,3,8"), 3, 0, 10));
        targetHud5.direction = false;
        targetHud6.animation = new BetterAnimation();
        targetHud5.timer = new Timer();
        targetHud4.progress = false ? 1 : 0;
        targetHud4.setChinese(Tab.ALLATORIxDEMO("\u76fc\u6876\u7514\u9759"));
        INSTANCE = targetHud4;
    }

    public class_1657 getTarget() throws IOException {
        TargetHud a2;
        TargetHud targetHud = a2;
        float f = 1000000.0f;
        TargetHud targetHud2 = null;
        for (TargetHud a2 : TargetHud.mc.field_1687.method_18456()) {
            class_1657 class_16572;
            if (!(class_16572.method_5739((class_1297)TargetHud.mc.field_1724) < f) || a2.method_29504() || a2 == TargetHud.mc.field_1724 || Hana.FRIEND.isFriend((class_1657)a2)) continue;
            f = a2.method_5739((class_1297)TargetHud.mc.field_1724);
        }
        return targetHud2;
    }

    @Override
    public void onUpdate() {
        TargetHud a;
        healthAnimation.update();
        hurtAnimation.update();
        TargetHud targetHud = a;
        targetHud.animation.update(targetHud.direction);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender2D(class_332 class_3322, float f) {
        class_746 class_7462;
        void v12;
        String string;
        double d;
        void a;
        float a22 = f;
        TargetHud a3 = this;
        class_1657 a22 = null;
        if (HanaAura.INSTANCE.isOn() && HanaAura.INSTANCE.displayTarget != null && !TargetHud.mc.field_1724.method_29504()) {
            a22 = HanaAura.INSTANCE.displayTarget;
            a3.direction = true;
        }
        if (Aura.INSTANCE.isOn() && Aura.target != null && Aura.target instanceof class_1657) {
            a22 = (class_1657)Aura.target;
            class_7462 = a22;
            a3.direction = true;
        } else if (TargetHud.mc.field_1755 instanceof class_408) {
            a22 = TargetHud.mc.field_1724;
            class_7462 = a22;
            a3.direction = true;
        } else {
            a3.direction = false;
            class_7462 = a22;
        }
        if (class_7462 == null) {
            return;
        }
        a.method_51448().method_22903();
        float f2 = 114514.0f;
        float f3 = 114514.0f;
        if (a3.move.getValue() && (double)a22.method_5739((class_1297)TargetHud.mc.field_1724) <= a3.moveDis.getValue()) {
            class_243 class_2432;
            class_1657 class_16572 = a22;
            double d2 = class_16572.field_6014 + (a22.method_23317() - a22.field_6014) * (double)mc.method_1488();
            class_1657 class_16573 = a22;
            d = class_16572.field_6036 + (class_16573.method_23318() - a22.field_6036) * (double)mc.method_1488();
            double d3 = class_16573.field_5969 + (a22.method_23321() - a22.field_5969) * (double)mc.method_1488();
            string = new class_243(d2, d + a22.method_5829().method_17940() + 0.3, d3);
            string = TextUtil.worldSpaceToScreenSpace(new class_243(((class_243)string).field_1352, ((class_243)string).field_1351, ((class_243)string).field_1350));
            if (class_2432.field_1350 > 0.0 && ((class_243)string).field_1350 < 1.0) {
                Vector4d vector4d = new Vector4d(((class_243)string).field_1352, ((class_243)string).field_1351, ((class_243)string).field_1350, 0.0);
                String string2 = string;
                vector4d.x = org.joml.Math.min((double)((class_243)string2).field_1352, (double)vector4d.x);
                vector4d.y = org.joml.Math.min((double)((class_243)string2).field_1351, (double)vector4d.y);
                vector4d.z = org.joml.Math.max((double)((class_243)string2).field_1352, (double)vector4d.z);
                Vector4d vector4d2 = vector4d;
                float f4 = (float)(vector4d.z - vector4d2.x) / 2.0f;
                f2 = (float)((vector4d2.x + (double)f4) * 1.0);
                f3 = (float)(vector4d.y - (double)(a22.method_17682() / 2.0f));
            }
        }
        if (!a3.move.getValue()) {
            TargetHud targetHud = a3;
            f2 = targetHud.xOffset.getValueFloat();
            f3 = targetHud.yOffset.getValueFloat();
        }
        if (f2 == 114514.0f || f3 == 114514.0f) {
            return;
        }
        class_1657 class_16574 = a22;
        float f5 = (float)class_16574.field_6235 / 8.0f;
        hurtAnimation.setValue(f5);
        String string3 = "Name: " + class_16574.method_5477().getString();
        d = a22.method_6032() + a22.method_6067();
        healthAnimation.setValue(d);
        d = healthAnimation.getAnimationD();
        String string4 = "HP: " + org.joml.Math.round((double)d);
        String string5 = GaussianKernel.ALLATORIxDEMO("{");
        if (Hana.POP.popContainer.containsKey(a22.method_5477().getString())) {
            string5 = String.valueOf(Hana.POP.popContainer.get(a22.method_5477().getString()));
        }
        string = "Pops: " + string5;
        float f6 = (float)org.joml.Math.max((double)org.joml.Math.max((double)TargetHud.mc.field_1772.method_1727(string3), (double)(d * 100.0 / 36.0 + 10.0 + (double)TargetHud.mc.field_1772.method_1727(string4))), (double)TargetHud.mc.field_1772.method_1727(string));
        TargetHud targetHud = a3;
        targetHud.renderRoundedQuad(a.method_51448(), targetHud.colorBack.getValue(), f2, (int)f3, f2 + 46.0f + f6 + 5.0f, f3 + 55.0f, a3.ra.getValue(), 4.0, !(a3.blur.getValue() <= 0.0));
        RenderSystem.setShaderColor((float)1.0f, (float)((float)(1.0 - hurtAnimation.getAnimationD())), (float)((float)(1.0 - hurtAnimation.getAnimationD())), (float)1.0f);
        a.method_25293(((class_742)a22).method_52814().comp_1626(), (int)((double)f2 + hurtAnimation.getAnimationD()) + 5, (int)((double)f3 + hurtAnimation.getAnimationD()) + 5, (int)(44.0 - hurtAnimation.getAnimationD() * 2.0), (int)(44.0 - hurtAnimation.getAnimationD() * 2.0), 8.0f, 8.0f, 8, 8, 64, 64);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        TargetHud targetHud2 = a3;
        void v10 = a;
        a3.drawText((class_332)v10, string3, f2 + 54.0f, f3 + 5.0f, a3.textColor.getValue().getRGB());
        targetHud2.drawText((class_332)v10, string4, f2 + 54.0f, f3 + 33.0f, a3.textColor.getValue().getRGB());
        targetHud2.drawText((class_332)a, string, f2 + 87.0f, f3 + 33.0f, a3.textColor.getValue().getRGB());
        TargetHud targetHud3 = a3;
        if (!targetHud2.rainBow.getValue()) {
            Objects.requireNonNull(TargetHud.mc.field_1772);
            Objects.requireNonNull(TargetHud.mc.field_1772);
            Objects.requireNonNull(TargetHud.mc.field_1772);
            targetHud3.renderRoundedQuad(a.method_51448(), a3.healthColor.getValue(), f2 + 55.0f, f3 + (float)((55 - 9) / 3) + 4.0f, (double)(f2 + 70.0f) + d * 100.0 / 36.0, f3 + (float)((55 - 9) / 3) + 9.0f + 4.0f, a3.ra.getValue(), 4.0, false);
            v12 = a;
        } else {
            double d4;
            if (targetHud3.timer.passed(50L)) {
                TargetHud targetHud4 = a3;
                a3.progress -= targetHud4.rainbowSpeed.getValueInt();
                targetHud4.timer.reset();
            }
            int n = 20;
            double d5 = d4 = 0.0;
            while (d5 <= d * 100.0 / 36.0 - 1.5) {
                int n2;
                TargetHud targetHud5 = a3;
                if (d4 <= d * 100.0 / 36.0 - 1.5) {
                    Objects.requireNonNull(TargetHud.mc.field_1772);
                    Objects.requireNonNull(TargetHud.mc.field_1772);
                    Objects.requireNonNull(TargetHud.mc.field_1772);
                    targetHud5.renderRoundedQuad(a.method_51448(), a3.rainbow(n), (double)(f2 + 50.0f) + d4, f3 + (float)((55 - 9) / 3), (double)(f2 + 50.0f) + d4 + 1.5, f3 + (float)((55 - 9) / 3) + 9.0f, 0.0, 4.0, false);
                    n2 = n;
                } else {
                    Objects.requireNonNull(TargetHud.mc.field_1772);
                    Objects.requireNonNull(TargetHud.mc.field_1772);
                    Objects.requireNonNull(TargetHud.mc.field_1772);
                    targetHud5.renderRoundedQuad(a.method_51448(), a3.rainbow(n), (double)(f2 + 50.0f) + d4, f3 + (float)((55 - 9) / 3), (double)(f2 + 50.0f) + d4 + 1.5, f3 + (float)((55 - 9) / 3) + 9.0f, a3.ra.getValue(), 4.0, false);
                    n2 = n;
                }
                n = n2 + a3.pulseCounter.getValueInt();
                d5 = d4 + 1.5;
            }
            v12 = a;
        }
        v12.method_51448().method_22909();
    }

    @Override
    public void onDisable() {
        TargetHud a;
        a.direction = false;
        a.timer.reset();
    }

    static {
        healthAnimation = new BetterDynamicAnimation();
        hurtAnimation = new BetterDynamicAnimation();
        alphaMultipliers = new Stack();
    }

    public static float transformColor(float a) {
        return TargetHud.compute((int)(a * 255.0f)) / 255.0f;
    }

    private /* synthetic */ Color rainbow(int n) {
        int a = n;
        TargetHud a2 = this;
        return Color.getHSBColor((float)(Math.ceil(((double)a2.progress + (double)a * a2.rainbowDelay.getValue()) / 20.0) % 360.0 / 360.0), a2.saturation.getValueFloat() / 255.0f, 1.0f);
    }

    /*
     * WARNING - void declaration
     */
    public void drawText(class_332 class_3322, String string, float f, float f2, int n) {
        void a;
        void a2;
        void a3;
        void a4;
        void a5;
        int n2 = n;
        TargetHud a6 = this;
        if (a6.customFont.getValue()) {
            FontRenderers.Arial.drawString(a3.method_51448(), (String)a, (float)a2, (float)a5, (int)a4);
            return;
        }
        a3.method_51433(TargetHud.mc.field_1772, (String)a, (int)a2, (int)a5, (int)a4, true);
    }

    @Override
    public void onEnable() {
        TargetHud a;
        a.direction = false;
        a.timer.reset();
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
        Matrix4f a9;
        void a10;
        TargetHud a3222 = class_45872;
        TargetHud a11 = this;
        int a3222 = a9.getRGB();
        a9 = a3222.method_23760().method_23761();
        float a12 = TargetHud.transformColor((float)(a3222 >> 24 & 255) / 255.0f);
        float f = (float)(a3222 >> 16 & 255) / 255.0f;
        float f2 = (float)(a3222 >> 8 & 255) / 255.0f;
        float a3222 = (float)(a3222 & 255) / 255.0f;
        TargetHud.setupRender();
        RenderSystem.setShader(class_757::method_34540);
        a11.renderRoundedQuadInternal(a9, f, f2, a3222, a12, (double)a5, (double)a4, (double)a7, (double)a8, (double)a6, (double)a2, (double)a10, (double)a3, (double)a);
        TargetHud.endRender();
    }

    public static void endRender() {
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
    }

    public static void setupRender() {
        RenderSystem.enableBlend();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
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
        TargetHud a10 = this;
        void v0 = a9;
        a10.renderRoundedQuad((class_4587)a7, (Color)a2, (double)a6, (double)a4, (double)a5, (double)a, (double)v0, (double)v0, (double)v0, (double)v0, (double)a3, (boolean)a8);
    }

    /*
     * WARNING - void declaration
     */
    public void renderRoundedQuadInternal(Matrix4f matrix4f, float f, float f2, float f3, float f4, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        void a;
        void a23;
        void a3;
        int n;
        double a4;
        void a5;
        double a62;
        void a72;
        void a222;
        TargetHud targetHud = this;
        TargetHud a8 = class_289.method_1348().method_1349();
        a8.method_1328(class_293.class_5596.field_27381, class_290.field_1576);
        double[][] arrarrd = new double[4][];
        double[] arrd = new double[3];
        arrd[0] = a222 - a3;
        arrd[1] = a72 - a3;
        arrd[2] = a3;
        arrarrd[0] = arrd;
        double[] arrd2 = new double[3];
        arrd2[0] = a222 - a5;
        arrd2[1] = a62 + a5;
        arrd2[2] = a5;
        arrarrd[1] = arrd2;
        double[] arrd3 = new double[3];
        arrd3[0] = a4 + a23;
        arrd3[1] = a62 + a23;
        arrd3[2] = a23;
        arrarrd[2] = arrd3;
        double[] arrd4 = new double[3];
        arrd4[0] = a4 + a;
        arrd4[1] = a72 - a;
        arrd4[2] = a;
        arrarrd[3] = arrd4;
        double[][] a222 = arrarrd;
        int n2 = n = 0;
        while (n2 < 4) {
            void a9;
            void a10;
            void a11;
            float f5;
            void a12;
            void a13;
            double[] a72 = a222[n];
            a4 = a72[2];
            double d10 = (double)n * 90.0;
            while (d10 < 90.0 + (double)n * 90.0) {
                void a14;
                f5 = (float)org.joml.Math.toRadians((double)a62);
                float a23 = (float)((double)org.joml.Math.sin((float)f5) * a4);
                float f6 = (float)((double)org.joml.Math.cos((float)f5) * a4);
                a8.method_22918((Matrix4f)a13, (float)a72[0] + a23, (float)a72[1] + f6, 0.0f).method_22915((float)a10, (float)a11, (float)a12, (float)a9).method_1344();
                d10 = a62 + 90.0 / a14;
            }
            float a62 = (float)org.joml.Math.toRadians((double)(90.0 + (double)n * 90.0));
            float f7 = (float)((double)org.joml.Math.sin((float)a62) * a4);
            f5 = (float)((double)org.joml.Math.cos((float)a62) * a4);
            a8.method_22918((Matrix4f)a13, (float)a72[0] + f7, (float)a72[1] + f5, 0.0f).method_22915((float)a10, (float)a11, (float)a12, (float)a9).method_1344();
            n2 = ++n;
        }
        class_286.method_43433((class_287.class_7433)a8.method_1326());
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
