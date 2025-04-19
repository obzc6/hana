/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.asm.accessors.IPlayerMoveC2SPacket;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.bytedeco.javacv.BufferRing;

public class NoFall
extends Module {
    private final BooleanSetting no_void;
    private final BooleanSetting elytraCheck;
    private final SliderSetting distance;
    private final EnumSetting<Mode> mode;

    @EventHandler
    public void onPacketSend(PacketEvent.Send a) {
        NoFall a22;
        class_2828 class_28282;
        NoFall noFall = a22;
        if (NoFall.nullCheck()) {
            return;
        }
        if (noFall.elytraCheck.getValue()) {
            for (NoFall a22 : NoFall.mc.field_1724.method_5661()) {
                if (a22.method_7909() != class_1802.field_8833) continue;
                return;
            }
        }
        if (noFall.mode.getValue() == Mode.SpoofGround && (a22 = a.getPacket()) instanceof class_2828) {
            class_28282 = (class_2828)a22;
            if (NoFall.mc.field_1724.field_6017 >= (float)noFall.distance.getValue()) {
                ((IPlayerMoveC2SPacket)class_28282).setOnGround(true);
            }
        }
        if (noFall.mode.getValue() == Mode.Hypixel && (a22 = a.getPacket()) instanceof class_2828) {
            class_28282 = (class_2828)a22;
            if (NoFall.mc.field_1724.field_6017 >= (float)noFall.distance.getValue()) {
                ((IPlayerMoveC2SPacket)class_28282).setOnGround(true);
                if (!(NoFall.mc.field_1724.method_23318() > 0.0) || !(NoFall.mc.field_1724.field_6017 >= 2.0f) || !(NoFall.mc.field_1724.field_6036 - NoFall.mc.field_1724.method_23318() > 0.0) || NoFall.mc.field_1724.method_18798().field_1351 == 0.0 || noFall.no_void.getValue() && !noFall.isBlockUnder((class_1657)NoFall.mc.field_1724, (class_1937)NoFall.mc.field_1687) || NoFall.mc.field_1724.field_6017 > 255.0f || noFall.isBlockUnder((class_1657)NoFall.mc.field_1724, (class_1937)NoFall.mc.field_1687) || NoFall.mc.field_1724.field_6017 > 50.0f) {
                    // empty if block
                }
            }
        }
        if (noFall.mode.getValue() == Mode.AACV364 && (a22 = a.getPacket()) instanceof class_2828) {
            class_28282 = (class_2828)a22;
            ((IPlayerMoveC2SPacket)class_28282).setOnGround(true);
            if (NoFall.mc.field_1724.field_6017 >= (float)noFall.distance.getValue()) {
                if (!mc.method_1496()) {
                    a22 = NoFall.mc.field_1724.method_19538();
                    mc.method_1562().method_52787((class_2596)new class_2828.class_2829(((class_243)a22).field_1352, Double.NaN, ((class_243)a22).field_1350, false));
                }
                NoFall.mc.field_1724.field_6017 = 0.0f;
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ boolean isBlockUnder(class_1657 class_16572, class_1937 class_19372) {
        void a;
        NoFall a2 = class_16572;
        NoFall a3 = this;
        class_2680 class_26802 = a.method_8320((class_2338)(a2 = a2.method_24515().method_10074()));
        return class_26802.method_26212((class_1922)a, (class_2338)a2) || !class_26802.method_26220((class_1922)a, (class_2338)a2).method_1110();
    }

    public NoFall() {
        NoFall a;
        NoFall noFall = a;
        NoFall noFall2 = a;
        super(ProjectionUtils.ALLATORIxDEMO("k\fn\u000fD\u0002"), Module.Category.Movement);
        NoFall noFall3 = a;
        noFall3.mode = noFall2.add(new EnumSetting<Mode>(NCPRaytracer.ALLATORIxDEMO("JGcM"), Mode.SpoofGround));
        noFall2.distance = noFall2.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("F-V\u0017I\u0000K\u000b"), 3.0, 0.0, 8.0, 0.1));
        noFall2.elytraCheck = noFall2.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("`f}__c*foMdC"), true));
        noFall2.no_void = noFall2.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("k\f~\u0001A\n"), true));
        noFall.setChinese(NCPRaytracer.ALLATORIxDEMO("\u65c8\u638e\u8415"));
        noFall.setDescription(ProjectionUtils.ALLATORIxDEMO("?S\u0002\\\t^\u0002\u0019\fl-G\u0001\" D\u000eI\tM@"));
    }

    @Override
    public String getInfo() {
        return NCPRaytracer.ALLATORIxDEMO("YtDBdMWh]iL");
    }

    @Override
    public void onUpdate() {
        if (NoFall.nullCheck()) {
            return;
        }
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode Hypixel;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode SpoofGround;
        public static final /* enum */ Mode AACV364;

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[3];
            arrmode[0] = SpoofGround;
            arrmode[1] = Hypixel;
            arrmode[2] = AACV364;
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

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        static {
            SpoofGround = new Mode(BufferRing.ALLATORIxDEMO("+9\u0012!\u001c\u000e\u000f;\u0015pN"), 0);
            Hypixel = new Mode(ProjectionUtils.ALLATORIxDEMO("\u0007R\u001dI\u001eD\u000b"), 1);
            AACV364 = new Mode(BufferRing.ALLATORIxDEMO(";\b>\u0002S(\u001e"), 2);
            $VALUES = Mode.$values();
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }
    }

}
