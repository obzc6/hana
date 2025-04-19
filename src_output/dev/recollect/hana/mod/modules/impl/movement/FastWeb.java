/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.TimerEvent;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.HoleKick;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import dev.recollect.hana.xibao.Snow;
import java.util.function.Predicate;
import net.minecraft.class_1657;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_746;

public class FastWeb
extends Module {
    public final EnumSetting<Mode> mode;
    public final BooleanSetting onlySneak;
    private boolean work;
    public final SliderSetting xZSlow;
    public static FastWeb INSTANCE;
    private final SliderSetting fastSpeed;
    public final SliderSetting ySlow;

    public FastWeb() {
        FastWeb a;
        FastWeb fastWeb = a;
        super(Snow.ALLATORIxDEMO("ZULrZdh"), NpSocketClient.ALLATORIxDEMO("R.%<w-$ )h\"1'){;imq*-&c#l|2oC\u000b{it5<7Z\u0006o$d."), Module.Category.Movement);
        FastWeb fastWeb2 = a;
        fastWeb2.mode = fastWeb.add(new EnumSetting<Mode>(Snow.ALLATORIxDEMO("Kbeo"), Mode.Vanilla));
        fastWeb.fastSpeed = fastWeb.add(new SliderSetting(NpSocketClient.ALLATORIxDEMO("\u001cn5R,}(o."), 3.0, 0.0, 8.0, object -> {
            Object a = object;
            FastWeb a2 = this;
            return a2.mode.getValue() == Mode.Vanilla || a2.mode.getValue() == Mode.Strict;
        }));
        a.xZSlow = a.add(new SliderSetting(Snow.ALLATORIxDEMO("Dnlvhdn"), 25.0, 0.0, 100.0, 0.1, object -> {
            Object a = object;
            FastWeb a2 = this;
            return a2.mode.getValue() == Mode.Custom;
        }).setSuffix(NpSocketClient.ALLATORIxDEMO("o")));
        a.ySlow = a.add(new SliderSetting(Snow.ALLATORIxDEMO("mlvhdn"), 100.0, 0.0, 100.0, 0.1, object -> {
            Object a = object;
            FastWeb a2 = this;
            return a2.mode.getValue() == Mode.Custom;
        }).setSuffix(NpSocketClient.ALLATORIxDEMO("o")));
        FastWeb fastWeb3 = a;
        a.onlySneak = a.add(new BooleanSetting(Snow.ALLATORIxDEMO("TypMlhh`a"), true));
        fastWeb3.work = false;
        fastWeb3.setChinese(NpSocketClient.ALLATORIxDEMO("\u5f94\u9012\u8755\u86d1\u7f1b"));
        INSTANCE = fastWeb3;
    }

    public boolean isWorking() {
        FastWeb a;
        return a.work;
    }

    @EventHandler(priority=-100)
    public void onTimer(TimerEvent timerEvent) {
        TimerEvent a = timerEvent;
        FastWeb a2 = this;
        if (a2.work && a2.mode.getValue() == Mode.Strict) {
            a.set(a2.fastSpeed.getValueFloat());
        }
    }

    @Override
    public void onUpdate() {
        FastWeb a;
        boolean bl = a.work = !FastWeb.mc.field_1724.method_24828() && (FastWeb.mc.field_1690.field_1832.method_1434() || !a.onlySneak.getValue()) && HoleKick.isInWeb((class_1657)FastWeb.mc.field_1724);
        if (a.work && a.mode.getValue() == Mode.Vanilla) {
            MovementUtil.setMotionY(MovementUtil.getMotionY() - a.fastSpeed.getValue());
        }
    }

    @Override
    public String getInfo() {
        FastWeb a;
        return a.mode.getValue().name();
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode Vanilla = new Mode(PacketBuffer.ALLATORIxDEMO("g\u0015}\u0016t\u0012x"), 0);
        public static final /* enum */ Mode Strict = new Mode(Vec3.ALLATORIxDEMO("A\fk\u001a{\u0006"), 1);
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode Ignore;
        public static final /* enum */ Mode Custom;

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
            Mode[] arrmode = new Mode[4];
            arrmode[0] = Vanilla;
            arrmode[1] = Strict;
            arrmode[2] = Custom;
            arrmode[3] = Ignore;
            return arrmode;
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        static {
            Custom = new Mode(PacketBuffer.ALLATORIxDEMO("7f\fl\u0011t"), 2);
            Ignore = new Mode(Vec3.ALLATORIxDEMO("[\u001fw\u001cj\u0017"), 3);
            $VALUES = Mode.$values();
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }
    }

}
