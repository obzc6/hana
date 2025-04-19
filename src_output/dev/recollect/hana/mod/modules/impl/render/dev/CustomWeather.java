/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1920
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4588
 *  net.minecraft.class_5819
 *  net.minecraft.class_638
 *  net.minecraft.class_757
 *  net.minecraft.class_761
 *  net.minecraft.class_765
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.events.Event;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.WeatherRenderEvent;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.Snow;
import dev.recollect.hana.xibao.SnowAnimation;
import java.awt.Color;
import net.minecraft.class_1920;
import net.minecraft.class_2338;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4588;
import net.minecraft.class_5819;
import net.minecraft.class_638;
import net.minecraft.class_757;
import net.minecraft.class_761;
import net.minecraft.class_765;

public class CustomWeather
extends Module {
    private final SliderSetting height;
    private static final float[] weatherXCoords;
    public static CustomWeather INSTANCE;
    private int ticks;
    private final SliderSetting expandSize;
    private static final float[] weatherYCoords;
    private final ColorSetting weatherColor;
    private final SliderSetting snowFallingSpeedMultiplier;
    private final EnumSetting<Mode> modesetting;
    private final SliderSetting strength;
    private static final class_2960 SNOW;
    private static final class_2960 RAIN;

    public CustomWeather() {
        CustomWeather a;
        CustomWeather customWeather = a;
        CustomWeather customWeather2 = a;
        super(SnowAnimation.ALLATORIxDEMO("\u0016L\u0014I\fE!Q\u000bM\u000fK\u0002"), dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("Q3f5a7,/S\u0003p8e&5$o;a3g4"), Module.Category.Render);
        CustomWeather customWeather3 = a;
        customWeather3.modesetting = customWeather2.add(new EnumSetting<Mode>(SnowAnimation.ALLATORIxDEMO("t\bJ\u0015"), Mode.None));
        customWeather2.weatherColor = customWeather2.add(new ColorSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u001ek<|5"), -1));
        customWeather2.expandSize = customWeather2.add(new SliderSetting(SnowAnimation.ALLATORIxDEMO("\"E\u0013I\u0018PJj\u000eT\u0015"), 10, 1, 100));
        customWeather2.height = customWeather2.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("A8m7{3"), 128, 1, 256));
        customWeather2.strength = customWeather2.add(new SliderSetting(SnowAnimation.ALLATORIxDEMO("{\u0002F\u000fW\u0000Z\u0018"), 1.0, 0.0, 1.0));
        customWeather.snowFallingSpeedMultiplier = customWeather2.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("A(z6.\u001cm4Z\u000bj7 \u0013g(d\u000et5v#"), 1.0, 0.1, 5.0));
        customWeather.setChinese(SnowAnimation.ALLATORIxDEMO("\u8180\u5ba3\u4e2e\u5907\u6c64"));
        INSTANCE = customWeather;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void render(WeatherRenderEvent weatherRenderEvent, Mode mode) {
        class_765 a;
        int n;
        CustomWeather customWeather = this;
        void v0 = a;
        a = v0.lightmapTextureManager;
        double d = v0.cameraX;
        double d2 = v0.cameraY;
        double d3 = v0.cameraZ;
        float f = v0.tickDelta;
        CustomWeather customWeather2 = customWeather;
        float f2 = customWeather2.strength.getValueFloat();
        float f3 = (float)customWeather2.weatherColor.getValue().getRed() / 255.0f;
        float f4 = (float)customWeather2.weatherColor.getValue().getGreen() / 255.0f;
        float f5 = (float)customWeather2.weatherColor.getValue().getBlue() / 255.0f;
        a.method_3316();
        int n2 = class_3532.method_15357((double)d);
        int n3 = class_3532.method_15357((double)d2);
        int n4 = class_3532.method_15357((double)d3);
        class_289 class_2892 = class_289.method_1348();
        class_287 class_2872 = class_2892.method_1349();
        RenderSystem.disableCull();
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask((boolean)class_310.method_29611());
        RenderSystem.setShader(class_757::method_34546);
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        CustomWeather customWeather3 = customWeather;
        int n5 = customWeather3.expandSize.getValueInt();
        int n6 = -1;
        float f6 = (float)customWeather3.ticks + f;
        int n7 = n = n4 - n5;
        while (n7 <= n4 + n5) {
            int n8 = n2 - n5;
            while (n8 <= n2 + n5) {
                int n9;
                int a2 = (n - n4 + 16) * 32 + n9 - n2 + 16;
                if (a2 >= 0 && a2 <= 1023) {
                    double d4 = (double)weatherXCoords[a2] * 0.5;
                    double d5 = (double)weatherYCoords[a2] * 0.5;
                    class_23392.method_10102((double)n9, d2, (double)n);
                    a2 = customWeather.height.getValueInt();
                    int n10 = n3 - n5;
                    int n11 = n3 + n5;
                    if (n10 < a2) {
                        n10 = a2;
                    }
                    if (n11 < a2) {
                        n11 = a2;
                    }
                    a2 = Math.max(a2, n3);
                    if (n10 != n11) {
                        float f7;
                        float f8;
                        void a3;
                        class_5819 class_58192 = class_5819.method_43049((long)((long)n9 * (long)n9 * 3121L + (long)n9 * 45238971L ^ (long)n * (long)n * 418711L + (long)n * 13761L));
                        class_23392.method_10103(n9, n10, n);
                        a3.toMC();
                        if (a3 == Mode.Rain) {
                            float f9;
                            if (n6 != 0) {
                                if (n6 >= 0) {
                                    class_2892.method_1350();
                                }
                                n6 = 0;
                                RenderSystem.setShaderTexture((int)0, (class_2960)RAIN);
                                class_2872.method_1328(class_293.class_5596.field_27382, class_290.field_1584);
                            }
                            int n12 = n9;
                            int n13 = n;
                            int n14 = customWeather.ticks + n12 * n12 * 3121 + n9 * 45238971 + n13 * n13 * 418711 + n * 13761 & 31;
                            f7 = -((float)n14 + f) / 32.0f * (3.0f + class_58192.method_43057());
                            double d6 = (double)n9 + 0.5 - d;
                            double d7 = (double)n + 0.5 - d3;
                            double d8 = d6;
                            double d9 = d7;
                            float f10 = f9 = (float)Math.sqrt(d8 * d8 + d9 * d9) / (float)n5;
                            f8 = ((1.0f - f10 * f10) * 0.5f + 0.5f) * f2;
                            class_23392.method_10103(n9, a2, n);
                            int n15 = class_761.method_23794((class_1920)CustomWeather.mc.field_1687, (class_2338)class_23392);
                            class_287 class_2873 = class_2872;
                            int n16 = n9;
                            class_2872.method_22912((double)n9 - d - d4 + 0.5, (double)n11 - d2, (double)n - d3 - d5 + 0.5).method_22913(0.0f, (float)n10 * 0.25f + f7).method_22915(f3, f4, f5, f8).method_22916(n15).method_1344();
                            class_2872.method_22912((double)n16 - d + d4 + 0.5, (double)n11 - d2, (double)n - d3 + d5 + 0.5).method_22913(1.0f, (float)n10 * 0.25f + f7).method_22915(f3, f4, f5, f8).method_22916(n15).method_1344();
                            class_2873.method_22912((double)n16 - d + d4 + 0.5, (double)n10 - d2, (double)n - d3 + d5 + 0.5).method_22913(1.0f, (float)n11 * 0.25f + f7).method_22915(f3, f4, f5, f8).method_22916(n15).method_1344();
                            class_2873.method_22912((double)n9 - d - d4 + 0.5, (double)n10 - d2, (double)n - d3 - d5 + 0.5).method_22913(0.0f, (float)n11 * 0.25f + f7).method_22915(f3, f4, f5, f8).method_22916(n15).method_1344();
                        } else if (a3 == Mode.Snow) {
                            if (n6 != 1) {
                                if (n6 == 0) {
                                    class_2892.method_1350();
                                }
                                n6 = 1;
                                RenderSystem.setShaderTexture((int)0, (class_2960)SNOW);
                                class_2872.method_1328(class_293.class_5596.field_27382, class_290.field_1584);
                            }
                            float f11 = -((float)(customWeather.ticks & 511) + f) / 512.0f;
                            class_5819 class_58193 = class_58192;
                            f7 = (float)(class_58193.method_43058() + (double)f6 * 0.01 * (double)((float)class_58192.method_43059()));
                            float f12 = (float)((double)((float)(class_58193.method_43058() + (double)(f6 * (float)class_58192.method_43059()) * 0.001)) * Double.valueOf(customWeather.snowFallingSpeedMultiplier.getValue()));
                            double d10 = (double)n9 + 0.5 - d;
                            double d11 = (double)n + 0.5 - d3;
                            double d12 = d10;
                            double d13 = d11;
                            float f13 = f8 = (float)Math.sqrt(d12 * d12 + d13 * d13) / (float)n5;
                            float f14 = ((1.0f - f13 * f13) * 0.3f + 0.5f) * f2;
                            class_23392.method_10103(n9, a2, n);
                            a2 = 0;
                            if (CustomWeather.mc.field_1687 != null) {
                                a2 = class_761.method_23794((class_1920)CustomWeather.mc.field_1687, (class_2338)class_23392);
                            }
                            int n17 = a2 >> 16 & 65535;
                            a2 &= 65535;
                            n17 = (n17 * 3 + 240) / 4;
                            a2 = (a2 * 3 + 240) / 4;
                            class_287 class_2874 = class_2872;
                            int n18 = n9;
                            class_2872.method_22912((double)n9 - d - d4 + 0.5, (double)n11 - d2, (double)n - d3 - d5 + 0.5).method_22913(0.0f + f7, (float)n10 * 0.25f + f11 + f12).method_22915(f3, f4, f5, f14).method_22921(a2, n17).method_1344();
                            class_2872.method_22912((double)n18 - d + d4 + 0.5, (double)n11 - d2, (double)n - d3 + d5 + 0.5).method_22913(1.0f + f7, (float)n10 * 0.25f + f11 + f12).method_22915(f3, f4, f5, f14).method_22921(a2, n17).method_1344();
                            class_2874.method_22912((double)n18 - d + d4 + 0.5, (double)n10 - d2, (double)n - d3 + d5 + 0.5).method_22913(1.0f + f7, (float)n11 * 0.25f + f11 + f12).method_22915(f3, f4, f5, f14).method_22921(a2, n17).method_1344();
                            class_2874.method_22912((double)n9 - d - d4 + 0.5, (double)n10 - d2, (double)n - d3 - d5 + 0.5).method_22913(0.0f + f7, (float)n11 * 0.25f + f11 + f12).method_22915(f3, f4, f5, f14).method_22921(a2, n17).method_1344();
                        }
                    }
                }
                n8 = ++n9;
            }
            n7 = ++n;
        }
        if (n6 >= 0) {
            class_2892.method_1350();
        }
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        a.method_3315();
    }

    static {
        int n;
        RAIN = new class_2960(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("7*cV\u0003f%aip/x3~7X\u000fa>t{g `3* } "));
        SNOW = new class_2960(SnowAnimation.ALLATORIxDEMO("\u0000\u0017Tk4[\u0012\\^M\u0018E\u0004C\u0000e8\\\tIL[\u0018[\u001d\u0017\u0017@\u0017"));
        weatherXCoords = new float[1024];
        weatherYCoords = new float[1024];
        int n2 = n = 0;
        while (n2 < 32) {
            int n3;
            int n4 = n3 = 0;
            while (n4 < 32) {
                float f = n3 - 16;
                float f2 = n - 16;
                float f3 = f;
                float f4 = f2;
                float f5 = class_3532.method_15355((float)(f3 * f3 + f4 * f4));
                CustomWeather.weatherXCoords[n << 5 | n3] = -f2 / f5;
                int n5 = n << 5 | n3;
                CustomWeather.weatherYCoords[n5] = f / f5;
                n4 = ++n3;
            }
            n2 = ++n;
        }
    }

    @EventHandler
    private /* synthetic */ void onWeather(WeatherRenderEvent weatherRenderEvent) {
        WeatherRenderEvent a = weatherRenderEvent;
        CustomWeather a2 = this;
        if (a2.modesetting.getValue().equals((Object)Mode.Both)) {
            Object object = a;
            a2.render(a, Mode.Rain);
            a2.render((WeatherRenderEvent)object, Mode.Snow);
            ((Event)object).cancel();
            return;
        }
        a2.render(a, a2.modesetting.getValue());
        a.cancel();
    }

    @Override
    public void onUpdate() {
        CustomWeather a;
        ++a.ticks;
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode Snow;
        public static final /* enum */ Mode Rain;
        public static final /* enum */ Mode Both;
        public static final /* enum */ Mode None;
        private static final /* synthetic */ Mode[] $VALUES;

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[4];
            arrmode[0] = Rain;
            arrmode[1] = Snow;
            arrmode[2] = Both;
            arrmode[3] = None;
            return arrmode;
        }

        /*
         * Exception decompiling
         */
        public Mode toMC() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[DOLOOP]], but top level block is 2[CASE]
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:696)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:778)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:886)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
            // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
            // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
            // org.benf.cfr.reader.Main.main(Main.java:48)
            throw new IllegalStateException("Decompilation failed");
        }

        static {
            Rain = new Mode(TipUtils.ALLATORIxDEMO("\u000e\u0012W"), 0);
            Snow = new Mode(Snow.ALLATORIxDEMO("Tbiz"), 1);
            Both = new Mode(TipUtils.ALLATORIxDEMO("\u001e\u001cbQ"), 2);
            None = new Mode(Snow.ALLATORIxDEMO("Ichh"), 3);
            $VALUES = Mode.$values();
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Mode() {
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
    }

}
