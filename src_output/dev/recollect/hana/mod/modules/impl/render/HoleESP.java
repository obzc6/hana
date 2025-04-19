/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.api.utils.render.Render3DUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_746;
import org.bytedeco.javacv.BaseSettings;
import org.bytedeco.javacv.BufferRing;

public class HoleESP
extends Module {
    private final ColorSetting obiHole;
    private final SliderSetting range;
    private final ColorSetting otherHole;
    public static HoleESP INSTANCE;
    private final ColorSetting brHole;
    private final SliderSetting yRange;
    public final BooleanSetting doubleHole;

    public HoleESP() {
        HoleESP a;
        HoleESP holeESP = a;
        HoleESP holeESP2 = a;
        super(WebUtils.ALLATORIxDEMO("U<v+BW\u001d"), BaseSettings.ALLATORIxDEMO("tfpL*zZl"), Module.Category.Render);
        HoleESP holeESP3 = a;
        holeESP3.range = holeESP2.add(new SliderSetting(WebUtils.ALLATORIxDEMO("H/ic("), 6.0, 0.0, 20.0));
        holeESP2.yRange = holeESP2.add(new SliderSetting(BaseSettings.ALLATORIxDEMO("e{kQnY"), 5.0, 0.0, 20.0));
        holeESP2.obiHole = holeESP2.add(new ColorSetting(WebUtils.ALLATORIxDEMO("i- s0t2t\u0006hh("), new Color(255, 255, 255, 200)));
        holeESP2.brHole = holeESP2.add(new ColorSetting(BaseSettings.ALLATORIxDEMO("aPdNfBBPeY"), new Color(0, 255, 0, 200)));
        holeESP2.otherHole = holeESP2.add(new ColorSetting(WebUtils.ALLATORIxDEMO("U u6h\u0006hh("), new Color(255, 255, 0, 200)));
        holeESP.doubleHole = holeESP2.add(new BooleanSetting(BaseSettings.ALLATORIxDEMO("qoIkpLBPeY"), true));
        holeESP.setChinese(WebUtils.ALLATORIxDEMO("\u5756\u900b\u898b"));
        INSTANCE = holeESP;
    }

    @Override
    public void onRender3D(class_4587 a, float a22) {
        int n;
        HoleESP a3;
        HoleESP holeESP = a3;
        if (HoleESP.nullCheck()) {
            return;
        }
        class_2338 a22 = HoleESP.mc.field_1724.method_24515();
        int n2 = n = a22.method_10263() - holeESP.range.getValueInt();
        while (n2 < a22.method_10263() + holeESP.range.getValueInt()) {
            int n3 = a22.method_10260() - holeESP.range.getValueInt();
            while (n3 < a22.method_10260() + holeESP.range.getValueInt()) {
                int n4;
                int n5 = a22.method_10264() + holeESP.yRange.getValueInt();
                while (n5 > a22.method_10264() - holeESP.yRange.getValueInt()) {
                    int n6;
                    a3 = new class_2338(n, n6, n4);
                    if (HoleESP.isHole((class_2338)a3, true, true, class_2246.field_10540, false)) {
                        Render3DUtil.drawHole(a, (class_2338)a3, holeESP.obiHole.getValue(), true, true, 0.8f, 2.0f);
                    } else if (HoleESP.isHole((class_2338)a3, true, true, class_2246.field_9987, false)) {
                        Render3DUtil.drawHole(a, (class_2338)a3, holeESP.brHole.getValue(), true, true, 0.8f, 2.0f);
                    } else if (HoleESP.isHole((class_2338)a3, true, true, class_2246.field_9987, true)) {
                        Render3DUtil.drawHole(a, (class_2338)a3, holeESP.otherHole.getValue(), true, true, 0.8f, 2.0f);
                    }
                    n5 = --n6;
                }
                n3 = ++n4;
            }
            n2 = ++n;
        }
    }

    @Override
    public String getInfo() {
        return "";
    }

    /*
     * WARNING - void declaration
     */
    public static boolean isHole(class_2338 class_23382, boolean bl, boolean bl2, class_2248 class_22482, boolean bl3) {
        int n;
        void a;
        void a2;
        class_2338 class_23383 = class_23382;
        int n2 = 0;
        class_2350[] arrclass_2350 = class_2350.values();
        int n3 = arrclass_2350.length;
        int n4 = n = 0;
        while (n4 < n3) {
            void a3;
            void a4;
            class_2338 a5 = arrclass_2350[n];
            if (a5 != class_2350.field_11036 && a5 != class_2350.field_11033 && (CombatUtil.isHard(class_23383.method_10093((class_2350)a5)) && a4 != false || BlockUtil.getBlock(class_23383.method_10093((class_2350)a5)) == a3)) {
                ++n2;
            }
            n4 = ++n;
        }
        return (a == false || BlockUtil.getBlock(class_23383) == class_2246.field_10124 && BlockUtil.getBlock(class_23383.method_10069(0, 1, 0)) == class_2246.field_10124 && BlockUtil.getBlock(class_23383.method_10069(0, 2, 0)) == class_2246.field_10124) && n2 > 3 && (a2 == false || BlockUtil.getState(class_23383.method_10069(0, -1, 0)).method_51366());
    }

    public static final class HoleType
    extends Enum<HoleType> {
        public static final /* enum */ HoleType Obsidian = new HoleType(BufferRing.ALLATORIxDEMO("\u0001\u0018:\u00140\tD"), 0);
        private static final /* synthetic */ HoleType[] $VALUES;
        public static final /* enum */ HoleType Bedrock = new HoleType(GaussianFilter.ALLATORIxDEMO("f*G Q{\u001f"), 1);
        public static final /* enum */ HoleType Other = new HoleType(BufferRing.ALLATORIxDEMO("2 \b{X"), 2);

        public static HoleType[] values() {
            return (HoleType[])$VALUES.clone();
        }

        public static HoleType valueOf(String a) {
            return Enum.valueOf(HoleType.class, a);
        }

        static {
            $VALUES = HoleType.$values();
        }

        private static /* synthetic */ HoleType[] $values() {
            HoleType[] arrholeType = new HoleType[3];
            arrholeType[0] = Obsidian;
            arrholeType[1] = Bedrock;
            arrholeType[2] = Other;
            return arrholeType;
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ HoleType() {
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
