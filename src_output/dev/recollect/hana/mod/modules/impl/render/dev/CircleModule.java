/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.render.dev;

import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.dev.CircleUtil;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.video.FileUtil;
import java.awt.Color;
import net.minecraft.class_1297;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_746;

public class CircleModule
extends Module {
    private final SliderSetting circleSize;
    public final EnumSetting<Mode> drawMode;
    private final FadeUtils fadeIn;
    private final FadeUtils rotationFade;
    private final ColorSetting circleColor;
    private double currentRotation;
    private final RadiusUtils radiusUtils;
    private final BooleanSetting xuanzhuan;
    private final FadeUtils fadeOut;

    public CircleModule() {
        CircleModule a;
        CircleModule circleModule = a;
        super(HoleUtils.ALLATORIxDEMO("I\\ZtOybOaNx"), FileUtil.ALLATORIxDEMO("T\rb\u001b(\u0014Wy\u001au\u000bz\u001c9\u0003~\u001b]%:\f~\u000brO\u0013u\u000b"), Module.Category.Render);
        CircleModule circleModule2 = a;
        circleModule2.circleSize = circleModule.add(new SliderSetting(HoleUtils.ALLATORIxDEMO("vAe@pW-x}Xx"), 1.0, 0.5, 6.0, 0.1));
        circleModule.circleColor = circleModule.add(new ColorSetting(FileUtil.ALLATORIxDEMO("{>h\u0016}\u001b ,v\u001a\r"), new Color(255, 0, 0, 255)));
        circleModule.drawMode = circleModule.add(new EnumSetting<Mode>(HoleUtils.ALLATORIxDEMO("f{Fx"), Mode.Star));
        circleModule.xuanzhuan = circleModule.add(new BooleanSetting(FileUtil.ALLATORIxDEMO("j8n\u0014e\u001bC\u0006k\u0015|\u001a"), true));
        circleModule.radiusUtils = new RadiusUtils(a.circleSize.getValue(), 1000L);
        circleModule.fadeIn = new FadeUtils(1000L);
        circleModule.fadeOut = new FadeUtils(1000L);
        circleModule.rotationFade = new FadeUtils(1000L);
        a.currentRotation = 180.0;
        a.setChinese(HoleUtils.ALLATORIxDEMO("\u8131\u4e1f\u516b\u73b2"));
    }

    @Override
    public void onRender3D(class_4587 a, float a22) {
        Object a3;
        CircleModule circleModule = a3;
        class_310 a22 = class_310.method_1551();
        if (a22.field_1724 == null) {
            return;
        }
        a22 = a22.field_1724;
        CircleModule circleModule2 = circleModule;
        a3 = circleModule2.circleColor.getValue();
        if (circleModule2.circleSize.getValue() != circleModule.radiusUtils.getTargetRadius()) {
            CircleModule circleModule3 = circleModule;
            circleModule3.radiusUtils.setTargetRadius(circleModule3.circleSize.getValue());
        }
        double d = circleModule.isOn() ? circleModule.fadeIn.ease(FadeUtils.Ease.In) : circleModule.fadeOut.ease(FadeUtils.Ease.Out);
        int n = (int)((double)((Color)a3).getAlpha() * d);
        a3 = new Color(((Color)a3).getRed(), ((Color)a3).getGreen(), ((Color)a3).getBlue(), n);
        CircleModule circleModule4 = circleModule;
        float f = (float)circleModule4.radiusUtils.getCurrentRadius();
        if (circleModule4.xuanzhuan.getValue()) {
            CircleModule circleModule5 = circleModule;
            circleModule5.currentRotation += circleModule.rotationFade.ease(FadeUtils.Ease.Out) * 360.0;
            if (circleModule5.rotationFade.isEnd()) {
                circleModule.currentRotation = (circleModule.currentRotation % 360.0 + 360.0) % 360.0;
            }
        }
        CircleUtil.drawCircle2D(a, (class_1297)a22, (Color)a3, f, circleModule.currentRotation);
        if (circleModule.drawMode.getValue() == Mode.Circle) {
            CircleUtil.drawCircle(a, (class_1297)a22, (Color)a3, f, circleModule.currentRotation);
        }
        if (circleModule.drawMode.getValue() == Mode.Circle2D) {
            CircleUtil.drawCircle2D(a, (class_1297)a22, (Color)a3, f, circleModule.currentRotation);
        }
        if (circleModule.drawMode.getValue() == Mode.Star) {
            float f2 = f;
            CircleUtil.drawStar2D(a, (class_1297)a22, (Color)a3, f2, f2, circleModule.currentRotation);
        }
    }

    @Override
    public void onEnable() {
        CircleModule a;
        CircleModule circleModule = a;
        circleModule.radiusUtils.reset();
        circleModule.fadeIn.reset();
        a.rotationFade.reset();
        a.currentRotation = 0.0;
    }

    @Override
    public void onDisable() {
        CircleModule a;
        a.fadeOut.reset();
    }

    public static final class Mode
    extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode Circle;
        public static final /* enum */ Mode Star;
        public static final /* enum */ Mode Circle2D;

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
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

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[3];
            arrmode[0] = Star;
            arrmode[1] = Circle2D;
            arrmode[2] = Circle;
            return arrmode;
        }

        static {
            Star = new Mode(TimerManager.ALLATORIxDEMO("7\"On"), 0);
            Circle2D = new Mode(FileUtil.ALLATORIxDEMO("{>h\u0016}\u001b\";"), 1);
            Circle = new Mode(TimerManager.ALLATORIxDEMO(":\"\u00165By"), 2);
            $VALUES = Mode.$values();
        }
    }

}
