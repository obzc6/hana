/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1311
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1799
 *  net.minecraft.class_2371
 *  net.minecraft.class_238
 *  net.minecraft.class_241
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
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
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_757
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Vector4d
 */
package dev.recollect.hana.mod.modules.impl.render;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.gui.nullpoint.font.FontAdapter;
import dev.recollect.hana.mod.gui.nullpoint.font.FontRenderers;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1311;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_2371;
import net.minecraft.class_238;
import net.minecraft.class_241;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_757;
import org.bytedeco.javacv.FrameConverter;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector4d;

public class TwoDESP
extends Module {
    private final BooleanSetting others;
    private final ColorSetting friendsC;
    private final BooleanSetting drawItemC;
    private final BooleanSetting crystals;
    public final ColorSetting armorDuraColor;
    private final BooleanSetting font;
    private final EnumSetting page;
    private final ColorSetting othersC;
    private final ColorSetting playersC;
    private final BooleanSetting players;
    public final ColorSetting textcolor;
    private final ColorSetting crystalsC;
    public final ColorSetting countColor;
    private final ColorSetting monstersC;
    public final ColorSetting hHealth;
    private final ColorSetting creaturesC;
    private final SliderSetting durascale;
    private final BooleanSetting drawItem;
    private final ColorSetting ambientsC;
    private final BooleanSetting friends;
    public final ColorSetting mHealth;
    private final BooleanSetting renderArmor;
    private final BooleanSetting creatures;
    public final ColorSetting lHealth;
    private final BooleanSetting renderHealth;
    private final BooleanSetting monsters;
    private final BooleanSetting ambients;
    private final BooleanSetting outline;

    /*
     * Exception decompiling
     */
    public boolean shouldRender(class_1297 var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[DOLOOP]], but top level block is 1[CASE]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:696)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - void declaration
     */
    public void drawBox(class_287 class_2872, @NotNull class_1297 class_12972, Matrix4f matrix4f, class_332 class_3322) {
        Object ent;
        int n;
        class_1309 class_13092 = class_13093;
        class_1309 class_13093 = class_3322;
        class_1309 a = class_13092;
        void v1 = ent;
        double d = v1.field_6014 + (ent.method_23317() - ((class_1297)ent).field_6014) * (double)mc.method_1488();
        void v2 = ent;
        double d2 = v1.field_6036 + (v2.method_23318() - ((class_1297)ent).field_6036) * (double)mc.method_1488();
        double d3 = v2.field_5969 + (ent.method_23321() - ((class_1297)ent).field_5969) * (double)mc.method_1488();
        class_13093 = v1.method_5829();
        class_13093 = new class_238(class_13093.field_1323 - ent.method_23317() + d - 0.05, class_13093.field_1322 - ent.method_23318() + d2, class_13093.field_1321 - ent.method_23321() + d3 - 0.05, class_13093.field_1320 - ent.method_23317() + d + 0.05, class_13093.field_1325 - ent.method_23318() + d2 + 0.15, class_13093.field_1324 - ent.method_23321() + d3 + 0.05);
        class_1309 class_13094 = new class_243[8];
        class_13094[0] = new class_243(class_13093.field_1323, class_13093.field_1322, class_13093.field_1321);
        class_13094[1] = new class_243(class_13093.field_1323, class_13093.field_1325, class_13093.field_1321);
        class_13094[2] = new class_243(class_13093.field_1320, class_13093.field_1322, class_13093.field_1321);
        class_13094[3] = new class_243(class_13093.field_1320, class_13093.field_1325, class_13093.field_1321);
        class_13094[4] = new class_243(class_13093.field_1323, class_13093.field_1322, class_13093.field_1324);
        class_13094[5] = new class_243(class_13093.field_1323, class_13093.field_1325, class_13093.field_1324);
        class_13094[6] = new class_243(class_13093.field_1320, class_13093.field_1322, class_13093.field_1324);
        class_13094[7] = new class_243(class_13093.field_1320, class_13093.field_1325, class_13093.field_1324);
        class_13093 = class_13094;
        Color color = a.getEntityColor((class_1297)ent);
        Vector4d vector4d = null;
        class_1309 class_13095 = class_13093;
        int n2 = ((class_243[])class_13095).length;
        int n3 = n = 0;
        while (n3 < n2) {
            class_243 class_2432;
            class_243 class_2433 = class_13095[n];
            class_2433 = TextUtil.worldSpaceToScreenSpace(new class_243(class_2433.field_1352, class_2433.field_1351, class_2433.field_1350));
            if (class_2432.field_1350 > 0.0 && class_2433.field_1350 < 1.0) {
                if (vector4d == null) {
                    vector4d = new Vector4d(class_2433.field_1352, class_2433.field_1351, class_2433.field_1350, 0.0);
                }
                Vector4d vector4d2 = vector4d;
                class_243 class_2434 = class_2433;
                class_243 class_2435 = class_2433;
                vector4d.x = Math.min(class_2435.field_1352, vector4d.x);
                vector4d.y = Math.min(class_2435.field_1351, vector4d.y);
                vector4d2.z = Math.max(class_2434.field_1352, vector4d.z);
                vector4d2.w = Math.max(class_2434.field_1351, vector4d.w);
            }
            n3 = ++n;
        }
        if (vector4d != null) {
            void matrix;
            void bufferBuilder;
            Vector4d vector4d3 = vector4d;
            double d4 = vector4d3.x;
            double d5 = vector4d3.y;
            d3 = vector4d3.z;
            double d6 = vector4d3.w;
            if (a.outline.getValue()) {
                void v10 = bufferBuilder;
                double d7 = d4;
                void v12 = bufferBuilder;
                double d8 = d4;
                void v14 = bufferBuilder;
                double d9 = d4;
                Render2DUtil.setRectPoints((class_287)v14, (Matrix4f)matrix, (float)(d9 - 1.0), (float)d5, (float)(d4 + 0.5), (float)(d6 + 0.5), Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK);
                Render2DUtil.setRectPoints((class_287)v14, (Matrix4f)matrix, (float)(d9 - 1.0), (float)(d5 - 0.5), (float)(d3 + 0.5), (float)(d5 + 0.5 + 0.5), Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK);
                Render2DUtil.setRectPoints((class_287)bufferBuilder, (Matrix4f)matrix, (float)(d3 - 0.5 - 0.5), (float)d5, (float)(d3 + 0.5), (float)(d6 + 0.5), Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK);
                Render2DUtil.setRectPoints((class_287)v12, (Matrix4f)matrix, (float)(d8 - 1.0), (float)(d6 - 0.5 - 0.5), (float)(d3 + 0.5), (float)(d6 + 0.5), Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK);
                Color color2 = color;
                Render2DUtil.setRectPoints((class_287)v12, (Matrix4f)matrix, (float)(d8 - 0.5), (float)d5, (float)(d4 + 0.5 - 0.5), (float)d6, color2, color2, color2, color2);
                Color color3 = color;
                Render2DUtil.setRectPoints((class_287)v10, (Matrix4f)matrix, (float)d7, (float)(d6 - 0.5), (float)d3, (float)d6, color3, color3, color3, color3);
                Color color4 = color;
                Render2DUtil.setRectPoints((class_287)v10, (Matrix4f)matrix, (float)(d7 - 0.5), (float)d5, (float)d3, (float)(d5 + 0.5), color4, color4, color4, color4);
                Color color5 = color;
                Render2DUtil.setRectPoints((class_287)bufferBuilder, (Matrix4f)matrix, (float)(d3 - 0.5), (float)d5, (float)d3, (float)d6, color5, color5, color5, color5);
            }
            if (ent instanceof class_1309 && (class_13093 = (class_1309)ent).method_6032() != 0.0f && a.renderHealth.getValue()) {
                void v20 = bufferBuilder;
                Render2DUtil.setRectPoints((class_287)v20, (Matrix4f)matrix, (float)(d4 - 4.0), (float)d5, (float)d4 - 3.0f, (float)d6, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK);
                Color color6 = a.getcolor(class_13093.method_6032());
                double d10 = d6;
                Color color7 = color6;
                Render2DUtil.setRectPoints((class_287)v20, (Matrix4f)matrix, (float)(d4 - 4.0), (float)(d10 + (d5 - d10) * (double)class_13093.method_6032() / (double)class_13093.method_6063()), (float)d4 - 3.0f, (float)d6, color7, color7, color7, color7);
            }
            if (ent instanceof class_1657) {
                class_13093 = (class_1657)ent;
                if (a.renderArmor.getValue()) {
                    double d11 = (d6 - d5) / 4.0;
                    ent = new ArrayList<class_1799>();
                    ((ArrayList)ent).add((class_1799)class_13093.method_31548().field_7548.get(3));
                    ((ArrayList)ent).add((class_1799)class_13093.method_31548().field_7548.get(2));
                    ((ArrayList)ent).add((class_1799)class_13093.method_31548().field_7548.get(1));
                    ((ArrayList)ent).add((class_1799)class_13093.method_31548().field_7548.get(0));
                    int n4 = -1;
                    ent = ((ArrayList)ent).iterator();
                    while (ent.hasNext()) {
                        ++n4;
                        color = (class_1799)ent.next();
                        if (color.method_7960()) continue;
                        int n5 = (int)((float)(color.method_7936() - color.method_7919()) / (float)color.method_7936() * 100.0f);
                        d4 = d11 * (double)(n5 / 100);
                        Render2DUtil.setRectPoints((class_287)bufferBuilder, (Matrix4f)matrix, (float)(d3 + 1.5), (float)((double)((float)d5) + d11 * (double)n4 + 1.2 * (double)(n4 + 1)), (float)d3 + 3.0f, (int)(d5 + d11 * (double)n4 + 1.2 * (double)(n4 + 1) + d4), a.armorDuraColor.getValue(), a.armorDuraColor.getValue(), a.armorDuraColor.getValue(), a.armorDuraColor.getValue());
                    }
                }
            }
        }
    }

    public Color getcolor(float f) {
        float a = f;
        TwoDESP a2 = this;
        if (a >= 20.0f) {
            return a2.hHealth.getValue();
        }
        if (20.0f > a && a > 10.0f) {
            return a2.mHealth.getValue();
        }
        return a2.lHealth.getValue();
    }

    /*
     * Exception decompiling
     */
    public Color getEntityColor(class_1297 var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[DOLOOP]], but top level block is 1[CASE]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:696)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender2D(class_332 class_3322, float f) {
        void a;
        TwoDESP twoDESP = this;
        Matrix4f a2 = a.method_51448().method_23760().method_23761();
        class_287 class_2872 = class_289.method_1348().method_1349();
        Render2DUtil.setupRender();
        RenderSystem.setShader(class_757::method_34540);
        class_2872.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
        for (class_1297 class_12972 : TwoDESP.mc.field_1687.method_18112()) {
            if (!twoDESP.shouldRender(class_12972)) continue;
            twoDESP.drawBox(class_2872, class_12972, a2, (class_332)a);
        }
        class_286.method_43433((class_287.class_7433)class_2872.method_1326());
        Render2DUtil.endRender();
        for (class_1297 class_12972 : TwoDESP.mc.field_1687.method_18112()) {
            if (!twoDESP.shouldRender(class_12972)) continue;
            twoDESP.drawText(class_12972, (class_332)a);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void drawText(class_1297 class_12972, class_332 class_3322) {
        int n;
        Iterator a;
        class_1542 class_15422 = this;
        void v0 = a;
        double d = v0.field_6014 + (a.method_23317() - ((class_1297)a).field_6014) * (double)mc.method_1488();
        void v1 = a;
        double d2 = v0.field_6036 + (v1.method_23318() - ((class_1297)a).field_6036) * (double)mc.method_1488();
        double d3 = v1.field_5969 + (a.method_23321() - ((class_1297)a).field_5969) * (double)mc.method_1488();
        class_1542 a2 = v0.method_5829();
        a2 = new class_238(a2.field_1323 - a.method_23317() + d - 0.05, a2.field_1322 - a.method_23318() + d2, a2.field_1321 - a.method_23321() + d3 - 0.05, a2.field_1320 - a.method_23317() + d + 0.05, a2.field_1325 - a.method_23318() + d2 + 0.15, a2.field_1324 - a.method_23321() + d3 + 0.05);
        class_1542 class_15423 = new class_243[8];
        class_15423[0] = new class_243(a2.field_1323, a2.field_1322, a2.field_1321);
        class_15423[1] = new class_243(a2.field_1323, a2.field_1325, a2.field_1321);
        class_15423[2] = new class_243(a2.field_1320, a2.field_1322, a2.field_1321);
        class_15423[3] = new class_243(a2.field_1320, a2.field_1325, a2.field_1321);
        class_15423[4] = new class_243(a2.field_1323, a2.field_1322, a2.field_1324);
        class_15423[5] = new class_243(a2.field_1323, a2.field_1325, a2.field_1324);
        class_15423[6] = new class_243(a2.field_1320, a2.field_1322, a2.field_1324);
        class_15423[7] = new class_243(a2.field_1320, a2.field_1325, a2.field_1324);
        a2 = class_15423;
        class_15422.getEntityColor((class_1297)a);
        Vector4d vector4d = null;
        class_1542 class_15424 = a2;
        int n2 = ((class_243[])class_15424).length;
        int n3 = n = 0;
        while (n3 < n2) {
            class_243 class_2432;
            class_243 class_2433 = class_15424[n];
            class_2433 = TextUtil.worldSpaceToScreenSpace(new class_243(class_2433.field_1352, class_2433.field_1351, class_2433.field_1350));
            if (class_2432.field_1350 > 0.0 && class_2433.field_1350 < 1.0) {
                if (vector4d == null) {
                    vector4d = new Vector4d(class_2433.field_1352, class_2433.field_1351, class_2433.field_1350, 0.0);
                }
                Vector4d vector4d2 = vector4d;
                class_243 class_2434 = class_2433;
                class_243 class_2435 = class_2433;
                vector4d.x = Math.min(class_2435.field_1352, vector4d.x);
                vector4d.y = Math.min(class_2435.field_1351, vector4d.y);
                vector4d2.z = Math.max(class_2434.field_1352, vector4d.z);
                vector4d2.w = Math.max(class_2434.field_1351, vector4d.w);
            }
            n3 = ++n;
        }
        if (vector4d != null) {
            void a3;
            int n4;
            Vector4d vector4d3 = vector4d;
            double d4 = vector4d3.x;
            double d5 = vector4d3.y;
            d3 = vector4d3.z;
            double d6 = vector4d3.w;
            if (a instanceof class_1542) {
                a2 = (class_1542)a;
                if (class_15422.drawItem.getValue()) {
                    float f = (float)((d3 - d4) / 2.0);
                    float f2 = FontRenderers.Arial.getWidth(a2.method_5476().getString()) * 1.0f;
                    float f3 = (float)((d4 + (double)f - (double)(f2 / 2.0f)) * 1.0);
                    n4 = a2.method_6983().method_7947();
                    a3.method_51433(TwoDESP.mc.field_1772, a2.method_5476().getString(), (int)f3, (int)(d5 - 10.0), class_15422.textcolor.getValue().getRGB(), false);
                    if (class_15422.drawItemC.getValue()) {
                        a3.method_51433(TwoDESP.mc.field_1772, "x" + n4, (int)(f3 + (float)TwoDESP.mc.field_1772.method_1727(a2.method_5476().getString() + " ")), (int)d5 - 10, class_15422.countColor.getValue().getRGB(), false);
                    }
                }
            }
            if (a instanceof class_1657) {
                a2 = (class_1657)a;
                if (class_15422.renderArmor.getValue()) {
                    double d7 = (d6 - d5) / 4.0;
                    vector4d = new ArrayList();
                    vector4d.add((class_1799)a2.method_31548().field_7548.get(3));
                    vector4d.add((class_1799)a2.method_31548().field_7548.get(2));
                    vector4d.add((class_1799)a2.method_31548().field_7548.get(1));
                    vector4d.add((class_1799)a2.method_31548().field_7548.get(0));
                    n4 = -1;
                    a = vector4d.iterator();
                    while (a.hasNext()) {
                        ++n4;
                        a2 = (class_1799)a.next();
                        if (a2.method_7960()) continue;
                        int n5 = (int)((float)(a2.method_7936() - a2.method_7919()) / (float)a2.method_7936() * 100.0f);
                        d4 = d7 * (double)(n5 / 100);
                        a3.method_51427((class_1799)a2, (int)(d3 + 4.0), (int)(d5 + d7 * (double)n4 + 1.2 * (double)(n4 + 1) + d4 / 2.0));
                    }
                }
            }
        }
    }

    public static float getRotations(class_241 a) {
        if (TwoDESP.mc.field_1724 == null) {
            return 0.0f;
        }
        class_241 class_2412 = a;
        double d = (double)class_2412.field_1343 - TwoDESP.mc.field_1724.method_19538().field_1352;
        double d2 = (double)class_2412.field_1342 - TwoDESP.mc.field_1724.method_19538().field_1350;
        return (float)(-(Math.atan2(d, d2) * 57.29577951308232));
    }

    public TwoDESP() {
        TwoDESP a;
        TwoDESP twoDESP = a;
        super(Alt.ALLATORIxDEMO("Z`;t-"), Module.Category.Render);
        TwoDESP twoDESP2 = a;
        twoDESP2.page = twoDESP.add(new EnumSetting<Page>(Alt.ALLATORIxDEMO("`\fF\u001cM\u0010@\u000e"), Page.Target));
        twoDESP.outline = twoDESP.add(new BooleanSetting(Alt.ALLATORIxDEMO("&G\u001cH\u0017I\u0018"), true, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Setting;
        }));
        a.renderHealth = a.add(new BooleanSetting(Alt.ALLATORIxDEMO("r?v&V\u001bz\rE\u0012S\u0015"), true, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Setting;
        }));
        a.renderArmor = a.add(new BooleanSetting(Alt.ALLATORIxDEMO("Y0^\u0006@H`\u000bU\u001c"), true, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Setting;
        }));
        a.durascale = a.add(new SliderSetting(Alt.ALLATORIxDEMO("\u0006F\u001bS;G\u001fK\u0018"), 1.0, 0.0, 2.0, 0.1, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.renderArmor.getValue();
        }));
        a.drawItem = a.add(new BooleanSetting(Alt.ALLATORIxDEMO("G\u000ba-8\u000bG\f_Hj\u001fJ\u0018"), true, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Setting;
        }));
        a.drawItemC = a.add(new BooleanSetting(Alt.ALLATORIxDEMO("gQ\u0018wzQ6V\u0004\u0012+K\u000bI\t"), true, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Setting && a2.drawItem.getValue();
        }));
        a.font = a.add(new BooleanSetting(Alt.ALLATORIxDEMO("[7@\u001d]\u0005b\u0011I\t"), true, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Setting;
        }));
        a.players = a.add(new BooleanSetting(Alt.ALLATORIxDEMO("9^\t]\u001bU\u000e"), true, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.friends = a.add(new BooleanSetting(Alt.ALLATORIxDEMO("/@\u0001A\u0010C\u000e"), true, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.crystals = a.add(new BooleanSetting(Alt.ALLATORIxDEMO("p\u001bK\u001bP\u001fK\u000e"), true, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.creatures = a.add(new BooleanSetting(Alt.ALLATORIxDEMO("\u0001A\fS\u001cQ\fB\u000e"), false, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.monsters = a.add(new BooleanSetting(Alt.ALLATORIxDEMO("~\u0006\\\u001bP\u001bU\u000e"), false, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.ambients = a.add(new BooleanSetting(Alt.ALLATORIxDEMO("r\u0004P\u0001A\u0010S\u000e"), false, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.others = a.add(new BooleanSetting(Alt.ALLATORIxDEMO("}\u001cL\u001bU\u000e"), false, object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Target;
        }));
        a.playersC = a.add(new ColorSetting(Alt.ALLATORIxDEMO("H.R\u0010W\u001aW<H\u0005"), new Color(16749056), object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Color;
        }));
        a.friendsC = a.add(new ColorSetting(Alt.ALLATORIxDEMO("^0Z\f\\\fW<H\u0005"), new Color(3211008), object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Color;
        }));
        a.crystalsC = a.add(new ColorSetting(Alt.ALLATORIxDEMO("\u0019j;@\u001dS\u0004W<H\u0005"), new Color(48127), object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Color;
        }));
        a.creaturesC = a.add(new ColorSetting(Alt.ALLATORIxDEMO("C(}#G\u001c@\rW<H\u0005"), new Color(10527910), object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Color;
        }));
        a.monstersC = a.add(new ColorSetting(Alt.ALLATORIxDEMO("\u0017w,@\u001dW\u001aW<H\u0005"), new Color(16711680), object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Color;
        }));
        a.ambientsC = a.add(new ColorSetting(Alt.ALLATORIxDEMO("\u001bu Z\f\\\u001cW<H\u0005"), new Color(8061183), object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Color;
        }));
        a.othersC = a.add(new ColorSetting(Alt.ALLATORIxDEMO("\rG\u0001W\u001aW<H\u0005"), new Color(16711778), object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Color;
        }));
        a.armorDuraColor = a.add(new ColorSetting(Alt.ALLATORIxDEMO("\u0018qN\u0016rz\\7A\b\u0012+K\u0012H\u000f"), new Color(3145472), object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Color;
        }));
        a.textcolor = a.add(new ColorSetting(Alt.ALLATORIxDEMO("JW\u001cmzV#^\f\u0012+K\u0012H\u000f"), new Color(255, 255, 255, 255), object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Color && a2.drawItem.getValue();
        }));
        a.countColor = a.add(new ColorSetting(Alt.ALLATORIxDEMO("\u0010wF\u0014 \u0019w7]\u001d\u0012+K\u0012H\u000f"), new Color(255, 255, 0, 255), object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Color && a2.drawItemC.getValue();
        }));
        a.hHealth = a.add(new ColorSetting(Alt.ALLATORIxDEMO("\u00170dKYH?y.G\u0001\u0012+K\u0012H\u000f"), new Color(0, 255, 0, 255), object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Color;
        }));
        a.mHealth = a.add(new ColorSetting(Alt.ALLATORIxDEMO("\u0014jGYH?y.G\u0001\u0012+K\u0012H\u000f"), new Color(255, 255, 0, 255), object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Color;
        }));
        a.lHealth = a.add(new ColorSetting(Alt.ALLATORIxDEMO("\u0015lTYH?y.G\u0001\u0012+K\u0012H\u000f"), new Color(255, 0, 0, 255), object -> {
            Object a = object;
            TwoDESP a2 = this;
            return a2.page.getValue() == Page.Color;
        }));
        a.setChinese(Alt.ALLATORIxDEMO("\u0016:\u9028\u89bb"));
    }

    public static final class Page
    extends Enum<Page> {
        public static final /* enum */ Page Setting = new Page(ObsidianHelper.ALLATORIxDEMO("$H2_)G%"), 0);
        public static final /* enum */ Page Color;
        private static final /* synthetic */ Page[] $VALUES;
        public static final /* enum */ Page Target;

        public static Page valueOf(String a) {
            return Enum.valueOf(Page.class, a);
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Page() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.lang.IllegalStateException
            // org.benf.cfr.reader.bytecode.analysis.variables.VariableFactory.localVariable(VariableFactory.java:53)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.mkRetrieve(Op02WithProcessedDataAndRefs.java:931)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.createStatement(Op02WithProcessedDataAndRefs.java:979)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.access$100(Op02WithProcessedDataAndRefs.java:56)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2060)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2057)
            // org.benf.cfr.reader.util.graph.AbstractGraphVisitorFI.process(AbstractGraphVisitorFI.java:60)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.convertToOp03List(Op02WithProcessedDataAndRefs.java:2069)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:342)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:901)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:778)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:886)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
            // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
            // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
            // org.benf.cfr.reader.Main.main(Main.java:48)
            throw new IllegalStateException("Decompilation failed");
        }

        private static /* synthetic */ Page[] $values() {
            Page[] arrpage = new Page[3];
            arrpage[0] = Setting;
            arrpage[1] = Target;
            arrpage[2] = Color;
            return arrpage;
        }

        public static Page[] values() {
            return (Page[])$VALUES.clone();
        }

        static {
            Target = new Page(FrameConverter.ALLATORIxDEMO("&p\u001dk@2"), 1);
            Color = new Page(ObsidianHelper.ALLATORIxDEMO("\u0005D,F0"), 2);
            $VALUES = Page.$values();
        }
    }

}
