/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.SelfTrap;
import dev.recollect.hana.mod.modules.impl.combat.Surround;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import dev.recollect.hana.xibao.Snow;
import java.util.function.Predicate;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class NewStep
extends Module {
    boolean timer;
    public final BooleanSetting useTimer;
    private final SliderSetting height;
    int packets;
    private final EnumSetting<Mode> mode;
    public final BooleanSetting sneakingPause;
    public static NewStep INSTANCE;
    public final BooleanSetting fast;
    public final BooleanSetting inWebPause;
    public final BooleanSetting pathingPause;
    public final BooleanSetting onlyMoving;
    public final BooleanSetting surroundPause;
    public final BooleanSetting inBlockPause;

    public NewStep() {
        NewStep a;
        NewStep newStep = a;
        super(NpSocketClient.ALLATORIxDEMO("\u000fy(hs"), FadeUtils.ALLATORIxDEMO("3E\u0010TJH\u0019MKX\u0000R\u0012KHD"), Module.Category.Movement);
        NewStep newStep2 = a;
        newStep2.mode = newStep.add(new EnumSetting<Mode>(NpSocketClient.ALLATORIxDEMO("@\"|="), Mode.Vanilla));
        newStep.height = newStep.add(new SliderSetting(FadeUtils.ALLATORIxDEMO("$X\u0018GS\u001e"), 1.0, 0.0, 5.0, 0.5));
        newStep.onlyMoving = newStep.add(new BooleanSetting(NpSocketClient.ALLATORIxDEMO("P1W\u0002Q3{$v?"), true));
        newStep.useTimer = newStep.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("i\u0018M^\u0018"), true, object -> {
            Object a = object;
            NewStep a2 = this;
            return a2.mode.getValue() == Mode.OldNCP || a2.mode.getValue() == Mode.NCP;
        }));
        a.fast = a.add(new BooleanSetting(NpSocketClient.ALLATORIxDEMO("K,k,"), true, object -> {
            Object a = object;
            NewStep a2 = this;
            return a2.mode.getValue() == Mode.NCP && a2.useTimer.getValue();
        }));
        NewStep newStep3 = a;
        NewStep newStep4 = a;
        newStep4.surroundPause = newStep4.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("wL\u001a\u001eR\u001eT\bm\u0010UH\u000f"), true));
        newStep4.inWebPause = newStep4.add(new BooleanSetting(NpSocketClient.ALLATORIxDEMO("V1l\u001e~\fl8k="), true));
        newStep4.inBlockPause = newStep4.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("p\u0006.Q\u0004Y\u0007m\u0010UH\u000f"), true));
        newStep4.sneakingPause = newStep4.add(new BooleanSetting(NpSocketClient.ALLATORIxDEMO("5c(~4R\u0015{\fl8k="), true));
        newStep4.pathingPause = newStep4.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("i\t\u0018U\u0002T\u000bm\u0010UH\u000f"), true));
        newStep3.packets = 0;
        newStep3.setChinese(NpSocketClient.ALLATORIxDEMO("\u65ec\u6b68\u8801\u8f9d\u52f1"));
        INSTANCE = newStep3;
    }

    @EventHandler
    public void onStep(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a3 = updateWalkingEvent;
        NewStep a2 = this;
        if (a3.isPost()) {
            --a2.packets;
            return;
        }
        if (a2.timer && a2.packets <= 0) {
            Hana.TIMER.reset();
            a2.timer = false;
        }
        boolean bl = a3 = a2.mode.getValue() == Mode.NCP;
        if (a2.mode.getValue().equals((Object)Mode.OldNCP) || a3) {
            double d = NewStep.mc.field_1724.method_23318() - NewStep.mc.field_1724.field_6036;
            if (d <= 0.75 || d > a2.height.getValue()) {
                return;
            }
            double[] a3 = a2.getOffset(d);
            if (a3 != null && a3.length > 1) {
                int n;
                if (a2.useTimer.getValue()) {
                    Hana.TIMER.set((float)a2.getTimer(d));
                    NewStep newStep = a2;
                    newStep.timer = true;
                    newStep.packets = 2;
                }
                int n2 = a3.length;
                int n3 = n = 0;
                while (n3 < n2) {
                    d = a3[n];
                    mc.method_1562().method_52787((class_2596)new class_2828.class_2829(NewStep.mc.field_1724.field_6014, NewStep.mc.field_1724.field_6036 + d, NewStep.mc.field_1724.field_5969, false));
                    n3 = ++n;
                }
            }
        }
    }

    public double getTimer(double a3) {
        NewStep a2;
        if (a3 > 0.6 && a3 <= 1.0) {
            if (!a2.fast.getValue() && a2.mode.getValue() == Mode.NCP) {
                return 0.3333333333333333;
            }
            return 0.5;
        }
        double[] a3 = a2.getOffset(a3);
        if (a3 == null) {
            return 1.0;
        }
        return 1.0 / (double)a3.length;
    }

    @Override
    public String getInfo() {
        NewStep a;
        return a.mode.getValue().name();
    }

    @Override
    public void onDisable() {
        if (NewStep.nullCheck()) {
            return;
        }
        NewStep.mc.field_1724.method_49477(0.6f);
        Hana.TIMER.reset();
    }

    @Override
    public void onUpdate() {
        NewStep a;
        if (a.pathingPause.getValue() || a.sneakingPause.getValue() && NewStep.mc.field_1724.method_5715() || a.inBlockPause.getValue() && EntityUtil.isInsideBlock() || NewStep.mc.field_1724.method_5771() || NewStep.mc.field_1724.method_5799() || a.inWebPause.getValue() && EntityUtil.isInWeb() || !NewStep.mc.field_1724.method_24828() || a.onlyMoving.getValue() && !MovementUtil.isMoving() || a.surroundPause.getValue() && (Surround.INSTANCE.isOn() || SelfTrap.INSTANCE.isOn())) {
            NewStep.mc.field_1724.method_49477(0.6f);
            return;
        }
        NewStep.mc.field_1724.method_49477(a.height.getValueFloat());
    }

    public double[] getOffset(double a) {
        NewStep a2;
        NewStep newStep = a2;
        boolean bl = a2 = newStep.mode.getValue() == Mode.NCP;
        if (a == 0.75) {
            if (a2) {
                double[] arrd = new double[3];
                arrd[0] = 0.42;
                arrd[1] = 0.753;
                arrd[2] = 0.75;
                return arrd;
            }
            double[] arrd = new double[2];
            arrd[0] = 0.42;
            arrd[1] = 0.753;
            return arrd;
        }
        if (a == 0.8125) {
            if (a2) {
                double[] arrd = new double[3];
                arrd[0] = 0.39;
                arrd[1] = 0.7;
                arrd[2] = 0.8125;
                return arrd;
            }
            double[] arrd = new double[2];
            arrd[0] = 0.39;
            arrd[1] = 0.7;
            return arrd;
        }
        if (a == 0.875) {
            if (a2) {
                double[] arrd = new double[3];
                arrd[0] = 0.39;
                arrd[1] = 0.7;
                arrd[2] = 0.875;
                return arrd;
            }
            double[] arrd = new double[2];
            arrd[0] = 0.39;
            arrd[1] = 0.7;
            return arrd;
        }
        if (a == 1.0) {
            if (a2) {
                double[] arrd = new double[3];
                arrd[0] = 0.42;
                arrd[1] = 0.753;
                arrd[2] = 1.0;
                return arrd;
            }
            double[] arrd = new double[2];
            arrd[0] = 0.42;
            arrd[1] = 0.753;
            return arrd;
        }
        if (a == 1.5) {
            double[] arrd = new double[6];
            arrd[0] = 0.42;
            arrd[1] = 0.75;
            arrd[2] = 1.0;
            arrd[3] = 1.16;
            arrd[4] = 1.23;
            arrd[5] = 1.2;
            return arrd;
        }
        if (a == 2.0) {
            double[] arrd = new double[8];
            arrd[0] = 0.42;
            arrd[1] = 0.78;
            arrd[2] = 0.63;
            arrd[3] = 0.51;
            arrd[4] = 0.9;
            arrd[5] = 1.21;
            arrd[6] = 1.45;
            arrd[7] = 1.43;
            return arrd;
        }
        if (a == 2.5) {
            double[] arrd = new double[10];
            arrd[0] = 0.425;
            arrd[1] = 0.821;
            arrd[2] = 0.699;
            arrd[3] = 0.599;
            arrd[4] = 1.022;
            arrd[5] = 1.372;
            arrd[6] = 1.652;
            arrd[7] = 1.869;
            arrd[8] = 2.019;
            arrd[9] = 1.907;
            return arrd;
        }
        return null;
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode Vanilla = new Mode(Snow.ALLATORIxDEMO("smin`jl"), 0);
        public static final /* enum */ Mode NCP;
        public static final /* enum */ Mode OldNCP;
        private static final /* synthetic */ Mode[] $VALUES;

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[3];
            arrmode[0] = Vanilla;
            arrmode[1] = OldNCP;
            arrmode[2] = NCP;
            return arrmode;
        }

        static {
            OldNCP = new Mode(ObsidianHelper.ALLATORIxDEMO("l$L\rj\u0012"), 1);
            NCP = new Mode(Snow.ALLATORIxDEMO("BE]"), 2);
            $VALUES = Mode.$values();
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

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }
    }

}
