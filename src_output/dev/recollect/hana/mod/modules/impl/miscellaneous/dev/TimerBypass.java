/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2708
 *  net.minecraft.class_2793
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import java.util.function.Predicate;
import net.minecraft.class_2596;
import net.minecraft.class_2708;
import net.minecraft.class_2793;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class TimerBypass
extends Module {
    private final EnumSetting mode;
    private final SliderSetting boostSpeed;
    private final SliderSetting slowSpeed;
    private final BooleanSetting disabler;
    int tick;
    private final SliderSetting boostTime;
    private final SliderSetting slowTime;

    public TimerBypass() {
        TimerBypass a;
        TimerBypass timerBypass = a;
        super(GaussianKernel.ALLATORIxDEMO("9-;(-\u001e7>==/"), Module.Category.Misc);
        TimerBypass timerBypass2 = a;
        timerBypass2.mode = timerBypass.add(new EnumSetting<Mode>(RenderHelper.ALLATORIxDEMO(":gY'"), Mode.ThreeC3u));
        timerBypass.slowSpeed = timerBypass.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u0005!0+\u001d>9+8"), 0.28, 0.0, 2.0, 0.01, object -> {
            Object a = object;
            TimerBypass a2 = this;
            return a2.mode.getValue() == Mode.ThreeC3u;
        }));
        a.slowTime = a.add(new SliderSetting(RenderHelper.ALLATORIxDEMO(">~\u0005b#aP'"), 4, 0, 40, object -> {
            Object a = object;
            TimerBypass a2 = this;
            return a2.mode.getValue() == Mode.ThreeC3u;
        }));
        a.boostSpeed = a.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u00069\",(\u001d>9+8"), 1.66, 0.0, 4.0, 0.01, object -> {
            Object a = object;
            TimerBypass a2 = this;
            return a2.mode.getValue() == Mode.ThreeC3u;
        }));
        a.boostTime = a.add(new SliderSetting(RenderHelper.ALLATORIxDEMO("W\u0002}\u0019a#aP'"), 28, 0, 100, object -> {
            Object a = object;
            TimerBypass a2 = this;
            return a2.mode.getValue() == Mode.ThreeC3u;
        }));
        a.disabler = a.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\t,5/,0+."), false, object -> {
            Object a = object;
            TimerBypass a2 = this;
            return a2.mode.getValue() == Mode.ThreeC3u;
        }));
        a.tick = 0;
        a.setChinese(RenderHelper.ALLATORIxDEMO("\u53cd\u9068\u5660\u7ee8\u8f85"));
    }

    @EventHandler
    public void onReceive(PacketEvent.Receive receive) {
        Object a = receive;
        TimerBypass a2 = this;
        if ((a = ((PacketEvent)a).getPacket()) instanceof class_2708) {
            a = (class_2708)a;
            if (a2.disabler.getValue()) {
                TimerBypass.mc.field_1724.field_3944.method_52787((class_2596)new class_2793(a.method_11737() + 1));
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void onUpdate() {
        if (TimerBypass.nullCheck()) {
            return;
        }
        if (!MovementUtil.isMoving()) {
            return;
        }
        if (a.mode.getValue() != Mode.ThreeC3u) ** GOTO lbl12
        v0 = a;
        if ((double)(v0.tick % (v0.slowTime.getValueInt() + a.boostTime.getValueInt())) < a.slowTime.getValue()) {
            Hana.TIMER.set(a.slowSpeed.getValueFloat());
            v1 = a;
        } else {
            Hana.TIMER.set(a.boostSpeed.getValueFloat());
lbl12: // 2 sources:
            v1 = a;
        }
        ++v1.tick;
    }

    @Override
    public void onEnable() {
        a.tick = 0;
    }

    public static final class Mode
    extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode ThreeC3u = new Mode(RadiusUtils.ALLATORIxDEMO("g\u000fF\u0005L>PB"), 0);

        static {
            $VALUES = Mode.$values();
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
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
            Mode[] arrmode = new Mode[1];
            arrmode[0] = ThreeC3u;
            return arrmode;
        }
    }

}
