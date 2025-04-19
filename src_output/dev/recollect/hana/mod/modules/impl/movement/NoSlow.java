/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1661
 *  net.minecraft.class_2596
 *  net.minecraft.class_2868
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.socket.network.info.record.OnlineUserInfo;
import dev.recollect.hana.socket.network.packet.Packet;
import net.minecraft.class_1661;
import net.minecraft.class_2596;
import net.minecraft.class_2868;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class NoSlow
extends Module {
    public static NoSlow INSTANCE;
    private final EnumSetting<Mode> mode;

    public NoSlow() {
        NoSlow a;
        NoSlow noSlow = a;
        super(OnlineUserInfo.ALLATORIxDEMO("b4|4X7"), Module.Category.Movement);
        noSlow.mode = a.add(new EnumSetting<Mode>(FPSManager.ALLATORIxDEMO("@\u0004#D"), Mode.Vanilla));
        noSlow.setChinese(OnlineUserInfo.ALLATORIxDEMO("\u65b8\u51f8\u905f"));
        INSTANCE = noSlow;
    }

    @Override
    public String getInfo() {
        NoSlow a;
        return a.mode.getValue().name();
    }

    @Override
    public void onUpdate() {
        NoSlow a;
        if (a.mode.getValue() == Mode.NCP && NoSlow.mc.field_1724.method_6115() && !NoSlow.mc.field_1724.method_3144() && !NoSlow.mc.field_1724.method_6128()) {
            NoSlow.mc.field_1724.field_3944.method_52787((class_2596)new class_2868(NoSlow.mc.field_1724.method_31548().field_7545));
        }
    }

    public static final class Mode
    extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode NCP;
        public static final /* enum */ Mode Vanilla;

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
            Mode[] arrmode = new Mode[2];
            arrmode[0] = Vanilla;
            arrmode[1] = NCP;
            return arrmode;
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        static {
            Vanilla = new Mode(Packet.ALLATORIxDEMO("Ft\\wUsY"), 0);
            NCP = new Mode(ProjectionUtils.ALLATORIxDEMO("(b7"), 1);
            $VALUES = Mode.$values();
        }
    }

}
