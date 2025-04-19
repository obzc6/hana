/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2639
 *  net.minecraft.class_2805
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_7439
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.miscellaneous;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.socket.network.buffer.PacketBuffer;
import dev.recollect.hana.socket.network.client.NpSocketClient;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2639;
import net.minecraft.class_2805;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_7439;
import net.minecraft.class_746;

public class Ping
extends Module {
    private long sendTime;
    private final EnumSetting<Mode> mode;

    public Ping() {
        Ping a;
        Ping ping = a;
        super(MathUtil.ALLATORIxDEMO("?\u001a\b\u001d"), Module.Category.Misc);
        Ping ping2 = a;
        ping.mode = ping.add(new EnumSetting<Mode>(PacketBuffer.ALLATORIxDEMO("8}\u0018~"), Mode.Command));
        ping.setChinese(MathUtil.ALLATORIxDEMO("\u5e90\u8fa5"));
    }

    @Override
    public void onEnable() {
        Ping a;
        if (Ping.nullCheck()) {
            a.disable();
            return;
        }
        a.sendTime = System.currentTimeMillis();
        if (a.mode.getValue() == Mode.Command) {
            Ping.mc.field_1724.field_3944.method_45731(PacketBuffer.ALLATORIxDEMO("v\u001ds\b;"));
            return;
        }
        if (a.mode.getValue() == Mode.Request) {
            Ping.mc.field_1724.field_3944.method_52787((class_2596)new class_2805(1337, MathUtil.ALLATORIxDEMO("\u0000\n\u001f\nZ")));
        }
    }

    @EventHandler
    public void onPacketReceive(PacketEvent.Receive a) {
        class_7439 class_74392;
        Ping a2;
        Ping ping = a2;
        if (ping.mode.getValue() == Mode.Request) {
            class_2639 class_26392;
            a2 = a.getPacket();
            if (a2 instanceof class_2639 && (class_26392 = (class_2639)a2).method_11399() == 1337) {
                CommandManager.sendChatMessage("ping: " + (System.currentTimeMillis() - ping.sendTime) / 2L);
                ping.disable();
                return;
            }
        } else if (ping.mode.getValue() == Mode.Command && (a2 = a.getPacket()) instanceof class_7439 && ((class_74392 = (class_7439)a2).comp_763().getString().contains(PacketBuffer.ALLATORIxDEMO("(D\u0013a[g\u000f~")) || class_74392.comp_763().getString().contains(MathUtil.ALLATORIxDEMO("\u000f|`3<*!#'")) || class_74392.comp_763().getString().contains(PacketBuffer.ALLATORIxDEMO("y\u001c~\u001b}\u000bu")))) {
            CommandManager.sendChatMessage("ping: " + (System.currentTimeMillis() - ping.sendTime) / 2L);
            ping.disable();
        }
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode Command;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode Request;

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[2];
            arrmode[0] = Request;
            arrmode[1] = Command;
            return arrmode;
        }

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

        static {
            Request = new Mode(CrystalUtil.ALLATORIxDEMO("+N*U5R%"), 0);
            Command = new Mode(NpSocketClient.ALLATORIxDEMO("&h*a-c)"), 1);
            $VALUES = Mode.$values();
        }
    }

}
