/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2708
 *  net.minecraft.class_310
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.TimerEvent;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.HoleKick;
import dev.recollect.hana.mod.modules.impl.movement.Flight;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.Snow;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2708;
import net.minecraft.class_310;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class FastFall
extends Module {
    boolean onGround;
    private final SliderSetting height;
    private final EnumSetting<Mode> mode;
    private boolean useTimer;
    private final BooleanSetting noLag;
    private final Timer lagTimer;

    @Override
    public void onDisable() {
        a.useTimer = false;
    }

    @Override
    public String getInfo() {
        FastFall a;
        return a.mode.getValue().name();
    }

    @EventHandler
    public void onTimer(TimerEvent timerEvent) {
        TimerEvent a = timerEvent;
        FastFall a2 = this;
        if (FastFall.nullCheck()) {
            return;
        }
        if (!FastFall.mc.field_1724.method_24828() && a2.useTimer) {
            a.set(2.5f);
        }
    }

    private /* synthetic */ boolean trace() {
        Object a;
        FastFall fastFall = a;
        class_238 class_2383 = FastFall.mc.field_1724.method_5829();
        a = class_2383.method_1005();
        double d = class_2383.field_1323;
        double d2 = class_2383.field_1321;
        double d3 = class_2383.field_1320;
        double d4 = class_2383.field_1324;
        HashMap<FastFall, class_243> hashMap = new HashMap<FastFall, class_243>();
        FastFall fastFall2 = a;
        FastFall fastFall3 = a;
        hashMap.put(fastFall3, new class_243(((class_243)fastFall3).field_1352, ((class_243)a).field_1351 - 1.0, ((class_243)a).field_1350));
        hashMap.put((FastFall)new class_243(d, ((class_243)a).field_1351, d2), new class_243(d, ((class_243)a).field_1351 - 1.0, d2));
        hashMap.put((FastFall)new class_243(d3, ((class_243)a).field_1351, d2), new class_243(d3, ((class_243)a).field_1351 - 1.0, d2));
        hashMap.put((FastFall)new class_243(d, ((class_243)a).field_1351, d4), new class_243(d, ((class_243)a).field_1351 - 1.0, d4));
        hashMap.put((FastFall)new class_243(d3, ((class_243)a).field_1351, d4), new class_243(d3, ((class_243)a).field_1351 - 1.0, d4));
        a = hashMap.keySet().iterator();
        while (a.hasNext()) {
            class_243 class_2432;
            class_243 class_2433 = class_2432 = (class_243)a.next();
            class_3959 class_39592 = new class_3959(class_2433, (class_243)hashMap.get((Object)class_2433), class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)FastFall.mc.field_1724);
            if ((class_39592 = FastFall.mc.field_1687.method_17742(class_39592)) == null || class_39592.method_17783() != class_239.class_240.field_1332) continue;
            return false;
        }
        a = FastFall.mc.field_1687.method_8320((class_2338)new BlockPosX(FastFall.mc.field_1724.method_23317(), FastFall.mc.field_1724.method_23318() - 1.0, FastFall.mc.field_1724.method_23321()));
        return a.method_26215();
    }

    private /* synthetic */ int traceDown() {
        FastFall a;
        FastFall fastFall = a;
        int n = 0;
        int n2 = a = (int)Math.round(FastFall.mc.field_1724.method_23318()) - 1;
        while (n2 >= 0) {
            class_3965 class_39652 = FastFall.mc.field_1687.method_17742(new class_3959(FastFall.mc.field_1724.method_19538(), new class_243(FastFall.mc.field_1724.method_23317(), (double)a, FastFall.mc.field_1724.method_23321()), class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)FastFall.mc.field_1724));
            if (class_39652 != null && class_39652.method_17783() == class_239.class_240.field_1332) {
                return n;
            }
            ++n;
            n2 = --a;
        }
        return n;
    }

    @EventHandler
    public void onPacket(PacketEvent.Receive receive) {
        PacketEvent.Receive a = receive;
        FastFall a2 = this;
        if (!FastFall.nullCheck() && a.getPacket() instanceof class_2708) {
            a2.lagTimer.reset();
        }
    }

    public FastFall() {
        FastFall a;
        FastFall fastFall = a;
        super(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("\u0014p7B\u0001s1^-h)"), FadeUtils.ALLATORIxDEMO("\u000e{\u001dT\u000eQIKV\u0006LN\u0002W\u0019Q\u0010TT\u0018"), Module.Category.Movement);
        FastFall fastFall2 = a;
        fastFall2.mode = fastFall.add(new EnumSetting<Mode>(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("@6i<"), Mode.Fast));
        fastFall.noLag = fastFall.add(new BooleanSetting(FadeUtils.ALLATORIxDEMO("s\u001elZ\r"), true, object -> {
            Object a = object;
            FastFall a2 = this;
            return a2.mode.getValue() == Mode.Fast;
        }));
        a.height = a.add(new SliderSetting(dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow.ALLATORIxDEMO("H1d>e-"), 10.0, 1.0, 20.0, 0.5));
        a.lagTimer = new Timer();
        a.onGround = false;
        a.setChinese(FadeUtils.ALLATORIxDEMO("\u53a1\u542c\u6b14\u886c\u8fbe\u52c3"));
    }

    @Override
    public void onUpdate() {
        FastFall a;
        if (a.height.getValue() > 0.0 && (double)a.traceDown() > a.height.getValue() || FastFall.mc.field_1724.method_5757() || FastFall.mc.field_1724.method_5869() || FastFall.mc.field_1724.method_5771() || FastFall.mc.field_1724.method_21754() || !a.lagTimer.passedMs(1000L) || FastFall.mc.field_1724.method_6128() || Flight.INSTANCE.isOn() || FastFall.nullCheck()) {
            return;
        }
        if (HoleKick.isInWeb((class_1657)FastFall.mc.field_1724)) {
            return;
        }
        if (FastFall.mc.field_1724.method_24828()) {
            if (a.mode.getValue() == Mode.Fast) {
                MovementUtil.setMotionY(MovementUtil.getMotionY() - (double)(a.noLag.getValue() ? 0.62f : 1.0f));
            }
            if (a.traceDown() != 0 && (double)a.traceDown() <= a.height.getValue() && a.trace()) {
                MovementUtil.setMotionX(MovementUtil.getMotionX() * 0.05);
                MovementUtil.setMotionZ(MovementUtil.getMotionZ() * 0.05);
            }
        }
        if (a.mode.getValue() == Mode.Strict) {
            if (!FastFall.mc.field_1724.method_24828()) {
                if (a.onGround) {
                    a.useTimer = true;
                }
                if (MovementUtil.getMotionY() >= 0.0) {
                    a.useTimer = false;
                }
                a.onGround = false;
                return;
            }
            a.useTimer = false;
            MovementUtil.setMotionY(-0.08);
            a.onGround = true;
            return;
        }
        a.useTimer = false;
    }

    private static final class Mode
    extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode Fast = new Mode(HoleUtils.ALLATORIxDEMO("e}Qi"), 0);
        public static final /* enum */ Mode Strict = new Mode(Snow.ALLATORIxDEMO("_sueey"), 1);

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[2];
            arrmode[0] = Fast;
            arrmode[1] = Strict;
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

        static {
            $VALUES = Mode.$values();
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }
    }

}
