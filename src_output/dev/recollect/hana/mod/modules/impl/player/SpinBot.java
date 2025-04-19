/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1753
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_2596
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.skybox.BackgroundInfo;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.Snow;
import net.minecraft.class_1753;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2596;
import net.minecraft.class_2846;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_746;

public class SpinBot
extends Module {
    public final SliderSetting pitchDelta;
    public final BooleanSetting allowInteract;
    private final EnumSetting<Mode> pitchMode;
    private float rotationYaw;
    public final SliderSetting yawDelta;
    private float rotationPitch;
    private final EnumSetting<Mode> yawMode;

    @EventHandler
    public void onPacket(PacketEvent.Send send) {
        Object a = send;
        SpinBot a2 = this;
        if ((a = ((PacketEvent)a).getPacket()) instanceof class_2846 && ((class_2846)a).method_12363() == class_2846.class_2847.field_12974 && SpinBot.mc.field_1724.method_6030().method_7909() instanceof class_1753) {
            EntityUtil.sendYawAndPitch(SpinBot.mc.field_1724.method_36454(), SpinBot.mc.field_1724.method_36455());
        }
    }

    @EventHandler(priority=200)
    public void onUpdateWalkingPlayerPre(RotateEvent rotateEvent) {
        RotateEvent a = rotateEvent;
        SpinBot a2 = this;
        if (a2.pitchMode.getValue() == Mode.RandomAngle) {
            a2.rotationPitch = MathUtil.random(90.0f, -90.0f);
        }
        if (a2.yawMode.getValue() == Mode.RandomAngle) {
            a2.rotationYaw = MathUtil.random(0.0f, 360.0f);
        }
        if (a2.yawMode.getValue() == Mode.Spin) {
            a2.rotationYaw = (float)((double)a2.rotationYaw + a2.yawDelta.getValue());
        }
        if (a2.rotationYaw > 360.0f) {
            a2.rotationYaw = 0.0f;
        }
        if (a2.rotationYaw < 0.0f) {
            a2.rotationYaw = 360.0f;
        }
        if (a2.pitchMode.getValue() == Mode.Spin) {
            a2.rotationPitch = (float)((double)a2.rotationPitch + a2.pitchDelta.getValue());
        }
        if (a2.rotationPitch > 90.0f) {
            a2.rotationPitch = -90.0f;
        }
        if (a2.rotationPitch < -90.0f) {
            a2.rotationPitch = 90.0f;
        }
        if (a2.pitchMode.getValue() == Mode.Static) {
            SpinBot spinBot = a2;
            SpinBot spinBot2 = a2;
            spinBot.rotationPitch = SpinBot.mc.field_1724.method_36455() + spinBot2.pitchDelta.getValueFloat();
            spinBot.rotationPitch = MathUtil.clamp(spinBot2.rotationPitch, -90.0f, 90.0f);
        }
        if (a2.yawMode.getValue() == Mode.Static) {
            a2.rotationYaw = SpinBot.mc.field_1724.method_36454() % 360.0f + a2.yawDelta.getValueFloat();
        }
        if (a2.allowInteract.getValue() && (SpinBot.mc.field_1690.field_1904.method_1434() && !EntityUtil.isUsing() || SpinBot.mc.field_1690.field_1886.method_1434())) {
            return;
        }
        if (a2.yawMode.getValue() != Mode.None) {
            a.setYaw(a2.rotationYaw);
        }
        if (a2.pitchMode.getValue() != Mode.None) {
            a.setPitch(a2.rotationPitch);
        }
    }

    public SpinBot() {
        SpinBot a;
        SpinBot spinBot = a;
        SpinBot spinBot2 = a;
        super(Snow.ALLATORIxDEMO("UQCbExh"), Tab.ALLATORIxDEMO("\u0017-U"), Module.Category.Player);
        SpinBot spinBot3 = a;
        spinBot3.pitchMode = spinBot2.add(new EnumSetting<Mode>(Snow.ALLATORIxDEMO("QdrBBAhsy"), Mode.None));
        spinBot2.yawMode = spinBot2.add(new EnumSetting<Mode>(Tab.ALLATORIxDEMO("2n\u001b_\u001e<^"), Mode.None));
        spinBot2.yawDelta = spinBot2.add(new SliderSetting(Snow.ALLATORIxDEMO("TgVnikc}"), 60, -360, 360));
        spinBot2.pitchDelta = spinBot2.add(new SliderSetting(Tab.ALLATORIxDEMO("_\u0005|\bg(w\u001d,Z"), 10, -90, 90));
        spinBot.allowInteract = spinBot.add(new BooleanSetting(Snow.ALLATORIxDEMO("ztevDhUO~fth"), true));
        spinBot.setChinese(Tab.ALLATORIxDEMO("\u72ca\u7b7a\u768b\u86ab\u5c14\u51e8\u653b\u65bc"));
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode Spin;
        public static final /* enum */ Mode Static;
        public static final /* enum */ Mode None;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode RandomAngle;

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[4];
            arrmode[0] = None;
            arrmode[1] = RandomAngle;
            arrmode[2] = Spin;
            arrmode[3] = Static;
            return arrmode;
        }

        static {
            None = new Mode(BackgroundInfo.ALLATORIxDEMO("\u000f9ey"), 0);
            RandomAngle = new Mode(CrystalUtil.ALLATORIxDEMO("\u0012\u0001~m\u0016F\u001aN7M4"), 1);
            Spin = new Mode(BackgroundInfo.ALLATORIxDEMO("\u0012&br"), 2);
            Static = new Mode(CrystalUtil.ALLATORIxDEMO("x/A$H2"), 3);
            $VALUES = Mode.$values();
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
    }

}
