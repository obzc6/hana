/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  net.minecraft.class_1297
 *  net.minecraft.class_1703
 *  net.minecraft.class_2540
 *  net.minecraft.class_2596
 *  net.minecraft.class_2815
 *  net.minecraft.class_2824
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  org.jetbrains.annotations.NotNull
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.class_1297;
import net.minecraft.class_1703;
import net.minecraft.class_2540;
import net.minecraft.class_2596;
import net.minecraft.class_2815;
import net.minecraft.class_2824;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.jetbrains.annotations.NotNull;

public class AntiNCPMiss
extends Module {
    private final BooleanSetting debug;
    private boolean send;
    private final BooleanSetting smart;
    public static AntiNCPMiss INSTANT;
    private final SliderSetting delay;
    Timer timer;

    @Override
    public void onUpdate() {
        AntiNCPMiss a;
        if (AntiNCPMiss.nullCheck()) {
            return;
        }
        if (AntiNCPMiss.mc.field_1755 != null) {
            return;
        }
        if (a.smart.getValue()) {
            return;
        }
        AntiNCPMiss antiNCPMiss = a;
        if (antiNCPMiss.timer.passedMs((long)antiNCPMiss.delay.getValue())) {
            a.timer.reset();
            a.bypass();
        }
    }

    @EventHandler
    public void onPacketSend(PacketEvent.Send a) {
        AntiNCPMiss a2;
        AntiNCPMiss antiNCPMiss = a2;
        a2 = a.getPacket();
        if (a2 instanceof class_2824) {
            a2 = (class_2824)a2;
            if (antiNCPMiss.smart.getValue() && AntiNCPMiss.getInteractType((class_2824)a2) == InteractType.ATTACK && AntiNCPMiss.getEntity((class_2824)a2) != null) {
                antiNCPMiss.bypass();
            }
        }
        if (AntiNCPMiss.mc.field_1755 != null && antiNCPMiss.send && a.getPacket() instanceof class_2815) {
            a.cancel();
        }
    }

    public AntiNCPMiss() {
        AntiNCPMiss a;
        AntiNCPMiss antiNCPMiss = a;
        AntiNCPMiss antiNCPMiss2 = a;
        super(CameraState.ALLATORIxDEMO("R\u0002t\u0018S\u0016i\u0002J<P"), Module.Category.Misc);
        AntiNCPMiss antiNCPMiss3 = a;
        antiNCPMiss3.delay = antiNCPMiss2.add(new SliderSetting(GameInfo.ALLATORIxDEMO("Hkzoo"), 50, 0, 10000));
        antiNCPMiss2.smart = antiNCPMiss2.add(new BooleanSetting(CameraState.ALLATORIxDEMO("j\"B=W"), true));
        a.debug = a.add(new BooleanSetting(GameInfo.ALLATORIxDEMO("hkt{q"), true));
        a.send = false;
        antiNCPMiss.timer = new Timer();
        antiNCPMiss.setChinese(CameraState.ALLATORIxDEMO("\u53a1N2M\u0018P<P\u56b1\u815d"));
        INSTANT = antiNCPMiss;
    }

    public static class_1297 getEntity(@NotNull class_2824 packet) {
        class_2824 class_28242 = packet;
        packet = new class_2540(Unpooled.buffer());
        class_28242.method_11052((class_2540)packet);
        return AntiNCPMiss.mc.field_1687.method_8469(packet.method_10816());
    }

    @Override
    public void onEnable() {
        AntiNCPMiss a;
        a.timer.reset();
    }

    public static InteractType getInteractType(@NotNull class_2824 packet) {
        class_2824 class_28242 = packet;
        class_2824 class_28243 = packet = new class_2540(Unpooled.buffer());
        class_28242.method_11052((class_2540)class_28243);
        class_28243.method_10816();
        return (InteractType)class_28243.method_10818(InteractType.class);
    }

    public void bypass() {
        if (AntiNCPMiss.mc.field_1755 == null) {
            AntiNCPMiss a;
            a.send = true;
            AntiNCPMiss.mc.field_1724.field_3944.method_52787((class_2596)new class_2815(AntiNCPMiss.mc.field_1724.field_7512.field_7763));
            if (a.debug.getValue()) {
                CommandManager.sendChatMessage(GameInfo.ALLATORIxDEMO("HJge}Bp{sO^Fm\bvu~w}e"));
            }
            a.send = false;
        }
    }

    public static final class InteractType
    extends Enum<InteractType> {
        public static final /* enum */ InteractType INTERACT_AT;
        public static final /* enum */ InteractType INTERACT;
        private static final /* synthetic */ InteractType[] $VALUES;
        public static final /* enum */ InteractType ATTACK;

        /*
         * Exception decompiling
         */
        private /* synthetic */ InteractType() {
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
            INTERACT = new InteractType(FPSManager.ALLATORIxDEMO("^?D3_*\u0004u"), 0);
            ATTACK = new InteractType(RenderHelper.ALLATORIxDEMO("+A#I~\t"), 1);
            INTERACT_AT = new InteractType(FPSManager.ALLATORIxDEMO(":^\"R#Q5Y4\u0006u"), 2);
            $VALUES = InteractType.$values();
        }

        private static /* synthetic */ InteractType[] $values() {
            InteractType[] arrinteractType = new InteractType[3];
            arrinteractType[0] = INTERACT;
            arrinteractType[1] = ATTACK;
            arrinteractType[2] = INTERACT_AT;
            return arrinteractType;
        }

        public static InteractType[] values() {
            return (InteractType[])$VALUES.clone();
        }

        public static InteractType valueOf(String a) {
            return Enum.valueOf(InteractType.class, a);
        }
    }

}
