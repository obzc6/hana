/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1656
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2540
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2824
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.combat;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.combat.Aura;
import dev.recollect.hana.mod.modules.impl.combat.TPAura;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.socket.network.client.SocketClient;
import dev.recollect.hana.xibao.xibaoutil.RenderHelper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1656;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2540;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2824;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class Criticals
extends Module {
    public static Criticals INSTANCE;
    public final EnumSetting<Mode> mode;

    public static InteractType getInteractType(class_2824 a) {
        class_2824 class_28242 = a;
        class_2824 class_28243 = a = new class_2540(Unpooled.buffer());
        class_28242.method_11052((class_2540)class_28243);
        class_28243.method_10816();
        return (InteractType)class_28243.method_10818(InteractType.class);
    }

    public static class_1297 getEntity(class_2824 a) {
        class_2824 class_28242 = a;
        a = new class_2540(Unpooled.buffer());
        class_28242.method_11052((class_2540)a);
        if (Criticals.mc.field_1687 == null) {
            return null;
        }
        return Criticals.mc.field_1687.method_8469(a.method_10816());
    }

    @Override
    public String getInfo() {
        Criticals a;
        return a.mode.getValue().name();
    }

    public void doCrit() {
        if ((Criticals.mc.field_1724.method_24828() || Criticals.mc.field_1724.method_31549().field_7479) && !Criticals.mc.field_1724.method_5771() && !Criticals.mc.field_1724.method_5869()) {
            Criticals a;
            if (a.mode.getValue() == Mode.Strict && Criticals.mc.field_1687.method_8320(Criticals.mc.field_1724.method_24515()).method_26204() != class_2246.field_10343) {
                Criticals.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 0.062600301692775, Criticals.mc.field_1724.method_23321(), false));
                Criticals.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 0.07260029960661, Criticals.mc.field_1724.method_23321(), false));
                Criticals.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318(), Criticals.mc.field_1724.method_23321(), false));
                Criticals.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318(), Criticals.mc.field_1724.method_23321(), false));
                return;
            }
            if (a.mode.getValue() == Mode.NCP) {
                Criticals.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 0.0625, Criticals.mc.field_1724.method_23321(), false));
                Criticals.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318(), Criticals.mc.field_1724.method_23321(), false));
                return;
            }
            if (a.mode.getValue() == Mode.Packet) {
                Criticals.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 1.058293536E-5, Criticals.mc.field_1724.method_23321(), false));
                Criticals.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 9.16580235E-6, Criticals.mc.field_1724.method_23321(), false));
                Criticals.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 1.0371854E-7, Criticals.mc.field_1724.method_23321(), false));
                return;
            }
            if (a.mode.getValue() == Mode.LowPacket) {
                Criticals.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 2.71875E-7, Criticals.mc.field_1724.method_23321(), false));
                Criticals.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318(), Criticals.mc.field_1724.method_23321(), false));
                return;
            }
            if (a.mode.getValue() == Mode.OldNCP) {
                mc.method_1562().method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 1.058293536E-5, Criticals.mc.field_1724.method_23321(), false));
                mc.method_1562().method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 9.16580235E-6, Criticals.mc.field_1724.method_23321(), false));
                mc.method_1562().method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 1.0371854E-7, Criticals.mc.field_1724.method_23321(), false));
                return;
            }
            if (a.mode.getValue() == Mode.NewNCP) {
                mc.method_1562().method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 2.71875E-7, Criticals.mc.field_1724.method_23321(), false));
                mc.method_1562().method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318(), Criticals.mc.field_1724.method_23321(), false));
                return;
            }
            if (a.mode.is(Mode.Hypixel2K22)) {
                mc.method_1562().method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 0.0045, Criticals.mc.field_1724.method_23321(), true));
                mc.method_1562().method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 1.52121E-4, Criticals.mc.field_1724.method_23321(), false));
                mc.method_1562().method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 0.3, Criticals.mc.field_1724.method_23321(), false));
                mc.method_1562().method_52787((class_2596)new class_2828.class_2829(Criticals.mc.field_1724.method_23317(), Criticals.mc.field_1724.method_23318() + 0.025, Criticals.mc.field_1724.method_23321(), false));
            }
        }
    }

    public Criticals() {
        Criticals a;
        Criticals criticals = a;
        super(RenderHelper.ALLATORIxDEMO("V\u001f{\u001e|\u0014iQ1"), Module.Category.Combat);
        criticals.mode = a.add(new EnumSetting<Mode>(SocketClient.ALLATORIxDEMO("ohY}"), Mode.Packet));
        criticals.setChinese(RenderHelper.ALLATORIxDEMO("\u5277\u5208\u6689\u51b9"));
        INSTANCE = criticals;
    }

    @EventHandler
    public void onPacketSend(PacketEvent.Send send) {
        class_2824 class_28242;
        Object t;
        Object a = send;
        Criticals a2 = this;
        if (!Aura.INSTANCE.sweeping && !TPAura.attacking && (t = ((PacketEvent)a).getPacket()) instanceof class_2824 && Criticals.getInteractType(class_28242 = (class_2824)t) == InteractType.ATTACK && !((a = Criticals.getEntity(class_28242)) instanceof class_1511)) {
            Criticals.mc.field_1724.method_7277((class_1297)a);
            a2.doCrit();
        }
    }

    private static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode NCP = new Mode(Timer.ALLATORIxDEMO("g-3"), 0);
        public static final /* enum */ Mode Hypixel2K22;
        public static final /* enum */ Mode Strict;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode OldNCP;
        public static final /* enum */ Mode LowPacket;
        public static final /* enum */ Mode Packet;
        public static final /* enum */ Mode NewNCP;

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[7];
            arrmode[0] = NCP;
            arrmode[1] = Strict;
            arrmode[2] = Packet;
            arrmode[3] = LowPacket;
            arrmode[4] = Hypixel2K22;
            arrmode[5] = NewNCP;
            arrmode[6] = OldNCP;
            return arrmode;
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

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }

        static {
            Strict = new Mode(WebUtils.ALLATORIxDEMO("\u0000n<ng9"), 1);
            Packet = new Mode(Timer.ALLATORIxDEMO("iUGB\u000b\u0017"), 2);
            LowPacket = new Mode(WebUtils.ALLATORIxDEMO("V;j\u0003{-la9"), 3);
            Hypixel2K22 = new Mode(Timer.ALLATORIxDEMO("y@DWK\\X\u0016b\\Q"), 4);
            NewNCP = new Mode(WebUtils.ALLATORIxDEMO("\u001d9IG\u001d"), 5);
            OldNCP = new Mode(Timer.ALLATORIxDEMO("vX@g-3"), 6);
            $VALUES = Mode.$values();
        }
    }

    public static final class InteractType
    extends Enum<InteractType> {
        private static final /* synthetic */ InteractType[] $VALUES;
        public static final /* enum */ InteractType INTERACT_AT;
        public static final /* enum */ InteractType ATTACK;
        public static final /* enum */ InteractType INTERACT;

        public static InteractType valueOf(String a) {
            return Enum.valueOf(InteractType.class, a);
        }

        static {
            INTERACT = new InteractType(TipUtils.ALLATORIxDEMO("\u000f'\u0015+\u000e2Um"), 0);
            ATTACK = new InteractType(ObsidianHelper.ALLATORIxDEMO("t\nh\u0016j\t"), 1);
            INTERACT_AT = new InteractType(TipUtils.ALLATORIxDEMO("\"\u000f:\u0003;\u0000-\b,Wm"), 2);
            $VALUES = InteractType.$values();
        }

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

        public static InteractType[] values() {
            return (InteractType[])$VALUES.clone();
        }

        private static /* synthetic */ InteractType[] $values() {
            InteractType[] arrinteractType = new InteractType[3];
            arrinteractType[0] = INTERACT;
            arrinteractType[1] = ATTACK;
            arrinteractType[2] = INTERACT_AT;
            return arrinteractType;
        }
    }

}
