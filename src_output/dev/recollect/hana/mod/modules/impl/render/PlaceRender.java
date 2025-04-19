/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Consumer;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_638;
import org.bytedeco.javacv.BufferRing;

public class PlaceRender
extends Module {
    private final EnumSetting<FadeUtils.Quad> quad;
    public static final HashMap<class_2338, PlacePos> renderMap = new HashMap();
    private final EnumSetting<Mode> mode;
    public final SliderSetting fadeTime;
    private final ColorSetting tryPlaceFill;
    private final ColorSetting box;
    private final ColorSetting fill;
    private final ColorSetting tryPlaceBox;
    public static PlaceRender INSTANCE;
    public final SliderSetting timeout;

    private /* synthetic */ void lambda$onRender3D$0(class_2338 class_23382) {
        PlaceRender a = class_23382;
        PlaceRender a2 = this;
        renderMap.put((class_2338)a, new PlacePos(a2, (class_2338)a));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void onRender3D(class_4587 a, float a) {
        var3_4 = a;
        BlockUtil.placedPos.forEach((Consumer<class_2338>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, lambda$onRender3D$0(net.minecraft.class_2338 ), (Lnet/minecraft/class_2338;)V)((PlaceRender)var3_4));
        BlockUtil.placedPos.clear();
        if (PlaceRender.renderMap.isEmpty()) {
            return;
        }
        a = true;
        var4_5 = PlaceRender.renderMap.values().iterator();
        block0 : do {
            v0 = var4_5;
            do {
                if (!v0.hasNext()) {
                    if (a == false) return;
                    PlaceRender.renderMap.clear();
                    return;
                }
                a = var4_5.next();
                if (!a.isAir) ** GOTO lbl32
                if (!PlaceRender.mc.field_1687.method_22347(a.pos)) {
                    v1 = a;
                    a.isAir = false;
                } else {
                    if (a.timer.passed(var3_4.timeout.getValue())) continue block0;
                    a.fade.reset();
                    var5_6 = (double)new class_238(a.pos);
                    if (var3_4.tryPlaceFill.booleanValue) {
                        Render3DUtil.drawFill(a, (class_238)var5_6, var3_4.tryPlaceFill.getValue());
                    }
                    if (var3_4.tryPlaceBox.booleanValue) {
                        Render3DUtil.drawBox(a, (class_238)var5_6, var3_4.tryPlaceBox.getValue());
                    }
                    a = false;
                    v0 = var4_5;
                    continue;
lbl32: // 1 sources:
                    v1 = a;
                }
                var5_6 = v1.fade.getQuad(var3_4.quad.getValue());
                if (var5_6 != 1.0) break;
                v0 = var4_5;
            } while (true);
            a = false;
            var7_7 = var3_4.mode.getValue() == Mode.Fade || var3_4.mode.getValue() == Mode.All ? 1.0 - var5_6 : 1.0;
            var9_8 /* !! */  = var3_4.mode.getValue() == Mode.Shrink || var3_4.mode.getValue() == Mode.All ? var5_6 : 0.0;
            a = new class_238(a.pos).method_1009(-var9_8 /* !! */  * 0.5, -var9_8 /* !! */  * 0.5, -var9_8 /* !! */  * 0.5);
            if (var3_4.fill.booleanValue) {
                Render3DUtil.drawFill(a, (class_238)a, ColorUtil.injectAlpha(var3_4.fill.getValue(), (int)((double)var3_4.fill.getValue().getAlpha() * var7_7)));
            }
            if (!var3_4.box.booleanValue) continue;
            Render3DUtil.drawBox(a, (class_238)a, ColorUtil.injectAlpha(var3_4.box.getValue(), (int)((double)var3_4.box.getValue().getAlpha() * var7_7)));
        } while (true);
    }

    public PlaceRender() {
        PlaceRender a;
        PlaceRender placeRender = a;
        PlaceRender placeRender2 = a;
        super(HoleUtils.ALLATORIxDEMO("zN|JsqyLyPx"), Module.Category.Render);
        PlaceRender placeRender3 = a;
        placeRender3.box = placeRender2.add(new ColorSetting(NCPRaytracer.ALLATORIxDEMO("cvN"), new Color(255, 255, 255, 255)).injectBoolean(true));
        placeRender2.fill = placeRender2.add(new ColorSetting(HoleUtils.ALLATORIxDEMO("dtYf"), new Color(255, 255, 255, 100)).injectBoolean(true));
        placeRender2.fadeTime = placeRender2.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("CKkEZHtS"), 500, 0, 3000));
        placeRender2.tryPlaceBox = placeRender2.add(new ColorSetting(HoleUtils.ALLATORIxDEMO("~PdyzBG_Zr"), new Color(178, 178, 178, 255)).injectBoolean(true));
        placeRender2.tryPlaceFill = placeRender2.add(new ColorSetting(NCPRaytracer.ALLATORIxDEMO("mdwqiKlEHHuZ"), new Color(255, 119, 119, 157)).injectBoolean(true));
        placeRender2.timeout = placeRender2.add(new SliderSetting(HoleUtils.ALLATORIxDEMO("BJqGR@~"), 500, 0, 3000));
        placeRender2.quad = placeRender2.add(new EnumSetting<FadeUtils.Quad>(NCPRaytracer.ALLATORIxDEMO("_TxR"), FadeUtils.Quad.In));
        a.mode = placeRender2.add(new EnumSetting<Mode>(HoleUtils.ALLATORIxDEMO("orQo"), Mode.All));
        placeRender.setChinese(NCPRaytracer.ALLATORIxDEMO("\u65b6\u5777\u6530\u7f4f\u6627\u790c"));
        a.enable();
        INSTANCE = placeRender;
    }

    private static final class Mode
    extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode Shrink;
        public static final /* enum */ Mode All;
        public static final /* enum */ Mode Fade;

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        static {
            Fade = new Mode(BufferRing.ALLATORIxDEMO("\u0012\u0001zO"), 0);
            Shrink = new Mode(TipUtils.ALLATORIxDEMO("\u0012\u0006.\u001axR"), 1);
            All = new Mode(BufferRing.ALLATORIxDEMO("!rF"), 2);
            $VALUES = Mode.$values();
        }

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[3];
            arrmode[0] = Fade;
            arrmode[1] = Shrink;
            arrmode[2] = All;
            return arrmode;
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

    public class PlacePos {
        final /* synthetic */ PlaceRender this$0;
        public final Timer timer;
        public final FadeUtils fade;
        public boolean isAir;
        public final class_2338 pos;

        /*
         * WARNING - void declaration
         */
        public PlacePos(PlaceRender placeRender, class_2338 class_23382) {
            void a;
            PlacePos a2;
            PlaceRender a3 = placeRender;
            PlacePos placePos = a2 = this;
            a2.this$0 = a3;
            PlacePos placePos2 = a2;
            placePos2.fade = new FadeUtils((long)a3.fadeTime.getValue());
            placePos.pos = a;
            placePos.timer = new Timer();
            placePos.isAir = true;
        }
    }

}
