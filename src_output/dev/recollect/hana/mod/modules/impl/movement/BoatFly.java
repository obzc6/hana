/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1690
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2661
 *  net.minecraft.class_2680
 *  net.minecraft.class_2684
 *  net.minecraft.class_2692
 *  net.minecraft.class_2708
 *  net.minecraft.class_2740
 *  net.minecraft.class_2824
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2831
 *  net.minecraft.class_2833
 *  net.minecraft.class_2851
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.BoatMoveEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.world.BlockPosX;
import dev.recollect.hana.asm.accessors.IVec3d;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.SnowAnimation;
import java.util.ArrayList;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1690;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2661;
import net.minecraft.class_2680;
import net.minecraft.class_2684;
import net.minecraft.class_2692;
import net.minecraft.class_2708;
import net.minecraft.class_2740;
import net.minecraft.class_2824;
import net.minecraft.class_2828;
import net.minecraft.class_2833;
import net.minecraft.class_2851;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class BoatFly
extends Module {
    public static BoatFly INSTANCE;
    public BooleanSetting spoofpackets;
    public BooleanSetting gravity;
    public BooleanSetting stop;
    private final SliderSetting glidespeed;
    public BooleanSetting stopunloaded;
    public BooleanSetting limit;
    private boolean Field2266;
    public BooleanSetting phase;
    public BooleanSetting ongroundpacket;
    public BooleanSetting remount;
    public BooleanSetting strict;
    private final SliderSetting height;
    private final SliderSetting timer;
    private int Field2264;
    private boolean Field2268;
    public BooleanSetting cancel;
    public BooleanSetting cancelrotations;
    private final SliderSetting offset;
    private final EnumSetting<Mode> mode;
    private final SliderSetting waitticks;
    private final ArrayList<class_2833> Field2263;
    private boolean Field2267;
    private final SliderSetting yspeed;
    private int Field2265;
    private final SliderSetting speed;
    public BooleanSetting ylimit;
    private final SliderSetting enableticks;

    @EventHandler
    public void onPacketReceive(PacketEvent.Receive receive) {
        PacketEvent.Receive a = receive;
        BoatFly a2 = this;
        if (BoatFly.nullCheck()) {
            return;
        }
        if (a.getPacket() instanceof class_2661) {
            a2.toggle();
        }
        if (!BoatFly.mc.field_1724.method_3144() || a2.Field2267 || a2.Field2266) {
            return;
        }
        if (a.getPacket() instanceof class_2692 && BoatFly.mc.field_1724.method_3144() && a2.cancel.getValue()) {
            a.cancel();
        }
        if (a.getPacket() instanceof class_2708 && BoatFly.mc.field_1724.method_3144() && a2.cancel.getValue()) {
            a.cancel();
        }
        if (a.getPacket() instanceof class_2684 && a2.cancel.getValue()) {
            a.cancel();
        }
        if (a.getPacket() instanceof class_2740 && a2.cancel.getValue()) {
            a.cancel();
        }
    }

    private /* synthetic */ void Method2875(class_2833 class_28332) {
        BoatFly a = class_28332;
        BoatFly a2 = this;
        a2.Field2263.add((class_2833)a);
        BoatFly.mc.field_1724.field_3944.method_52787((class_2596)a);
    }

    @Override
    public void onEnable() {
        if (BoatFly.nullCheck()) {
            BoatFly a;
            a.disable();
        }
    }

    private /* synthetic */ void Method2876(class_1297 class_12972) {
        int n;
        BoatFly a = class_12972;
        BoatFly a2 = this;
        double d = a.method_23318();
        BlockPosX blockPosX = new BlockPosX(a.method_23317(), (int)a.method_23318(), a.method_23321());
        int n2 = n = 0;
        while (n2 < 255) {
            if (!BoatFly.mc.field_1687.method_8320((class_2338)blockPosX).method_45474() || BoatFly.mc.field_1687.method_8320((class_2338)blockPosX).method_26204() == class_2246.field_10382) {
                ((IVec3d)a.method_19538()).setY(blockPosX.method_10264() + 1);
                a2.Method2875(new class_2833((class_1297)a));
                ((IVec3d)a.method_19538()).setY(d);
                return;
            }
            blockPosX = blockPosX.method_10069(0, -1, 0);
            n2 = ++n;
        }
    }

    public BoatFly() {
        BoatFly a;
        BoatFly boatFly = a;
        BoatFly boatFly2 = a;
        BoatFly boatFly3 = a;
        BoatFly boatFly4 = a;
        super(BOEntityUtils.ALLATORIxDEMO("iZxkuf_"), Module.Category.Movement);
        boatFly4.Field2263 = new ArrayList();
        boatFly4.strict = a.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("Q0Z\u0007^\u000f"), false));
        boatFly4.limit = boatFly4.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("Uv^cR"), true));
        boatFly4.phase = boatFly4.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("\u0014@\u000fN\u001e"), true));
        boatFly4.gravity = boatFly4.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("lGxiZ~_"), true));
        boatFly4.ongroundpacket = boatFly4.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("I.l\u001fJ\u0016^\u0012R%K\u0005X\u000f"), false));
        boatFly4.spoofpackets = boatFly4.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("O@}Qa{TztV~U"), false));
        boatFly4.cancelrotations = boatFly4.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("og.H\bI1_\u0002c0A\u0001S\b"), true));
        boatFly4.cancel = boatFly4.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("vxqPoJ"), true));
        boatFly4.remount = boatFly4.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("$g)G\u001bS\u000f"), true));
        boatFly4.stop = boatFly4.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("LGeV"), false));
        boatFly4.ylimit = boatFly4.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("{\bA\u0003T\u000f"), false));
        boatFly4.stopunloaded = boatFly4.add(new BooleanSetting(BOEntityUtils.ALLATORIxDEMO("OD}NREYv~WoB"), true));
        boatFly4.mode = boatFly4.add(new EnumSetting<Mode>(ProjectionUtils.ALLATORIxDEMO("e\u0001Y\u001e"), Mode.Packet));
        boatFly4.speed = boatFly4.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("yuBXJoVoB"), 2.0, 0.0, 45.0));
        boatFly4.yspeed = boatFly4.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("[\u0017X\u000bX\u001f"), 1.0, 0.0, 10.0));
        boatFly4.glidespeed = boatFly4.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("URnOPJoVoB"), 1.0, 0.0, 10.0));
        boatFly4.timer = boatFly4.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("\u0010A\u0003X\t"), 1.0, 0.0, 5.0));
        boatFly4.height = boatFly4.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("}|vTbR"), 127.0, 0.0, 256.0));
        boatFly4.offset = boatFly4.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("M\"N\u001dX\u000f"), 0.10000000149011612, 0.0, 10.0));
        boatFly4.enableticks = boatFly4.add(new SliderSetting(BOEntityUtils.ALLATORIxDEMO("u|_eGPMvPaU"), 10, 1, 100));
        boatFly4.waitticks = boatFly4.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("4Q\u001fv\u0010A\rV\b"), 10, 1, 100));
        boatFly3.Field2264 = 0;
        boatFly3.Field2265 = 0;
        boatFly2.Field2266 = 0;
        boatFly2.Field2267 = false;
        boatFly.Field2268 = false;
        boatFly.setChinese(BOEntityUtils.ALLATORIxDEMO("\u8233\u98f8"));
        INSTANCE = boatFly;
    }

    @Override
    public void onDisable() {
        BoatFly a;
        Hana.TIMER.timer = 1.0f;
        a.Field2263.clear();
        a.Field2266 = false;
        if (BoatFly.mc.field_1724 == null) {
            return;
        }
        if (a.phase.getValue() && a.mode.getValue() == Mode.Motion) {
            if (BoatFly.mc.field_1724.method_5854() != null) {
                BoatFly.mc.field_1724.method_5854().field_5960 = false;
            }
            BoatFly.mc.field_1724.field_5960 = false;
        }
        if (BoatFly.mc.field_1724.method_5854() != null) {
            BoatFly.mc.field_1724.method_5854().method_5875(false);
        }
        BoatFly.mc.field_1724.method_5875(false);
    }

    @EventHandler
    public void onPacketSend(PacketEvent.Send send) {
        PacketEvent.Send a = send;
        BoatFly a2 = this;
        if (BoatFly.nullCheck()) {
            return;
        }
        if ((a.getPacket() instanceof class_2828.class_2831 && a2.cancelrotations.getValue() || a.getPacket() instanceof class_2851) && BoatFly.mc.field_1724.method_3144()) {
            a.cancel();
        }
        if (a2.Field2267 && a.getPacket() instanceof class_2833) {
            a.cancel();
        }
        if (!BoatFly.mc.field_1724.method_3144() || a2.Field2267 || a2.Field2266) {
            return;
        }
        class_1297 class_12972 = BoatFly.mc.field_1724.method_5854();
        if (!BoatFly.mc.field_1687.method_8393(class_12972.method_24515().method_10263() >> 4, class_12972.method_24515().method_10260() >> 4) && a2.stopunloaded.getValue()) {
            return;
        }
        if (a.getPacket() instanceof class_2833 && a2.limit.getValue() && a2.mode.getValue() == Mode.Packet) {
            class_12972 = (class_2833)a.getPacket();
            if (a2.Field2263.contains((Object)class_12972)) {
                a2.Field2263.remove((Object)class_12972);
                return;
            }
            a.cancel();
        }
    }

    @EventHandler
    public void onBoatMove(BoatMoveEvent boatMoveEvent) {
        Object a = boatMoveEvent;
        BoatFly a2 = this;
        if (BoatFly.nullCheck()) {
            return;
        }
        if ((a = ((BoatMoveEvent)a).getBoat()).method_5642() != BoatFly.mc.field_1724) {
            return;
        }
        if (a2.phase.getValue() && a2.mode.getValue() == Mode.Motion) {
            ((class_1690)a).field_5960 = true;
            a.method_5875(true);
            BoatFly.mc.field_1724.field_5960 = true;
        }
        if (!a2.Field2267) {
            a.method_5875(!a2.gravity.getValue());
            BoatFly.mc.field_1724.method_5875(!a2.gravity.getValue());
        }
        if (a2.stop.getValue()) {
            if ((double)a2.Field2264 > a2.enableticks.getValue() && !a2.Field2266) {
                BoatFly boatFly = a2;
                a2.Field2264 = 0;
                boatFly.Field2266 = true;
                boatFly.Field2265 = a2.waitticks.getValueInt();
            }
            if (a2.Field2265 > 0 && a2.Field2266) {
                --a2.Field2265;
                return;
            }
            if (a2.Field2265 <= 0) {
                a2.Field2266 = false;
            }
        }
        if (!BoatFly.mc.field_1687.method_8393(a.method_24515().method_10263() >> 4, a.method_24515().method_10260() >> 4) && a2.stopunloaded.getValue()) {
            a2.Field2267 = true;
            return;
        }
        if (a2.timer.getValue() != 1.0) {
            Hana.TIMER.timer = a2.timer.getValueFloat();
        }
        Object object = a;
        Object object2 = a;
        object2.method_36456(BoatFly.mc.field_1724.method_36454());
        class_243 class_2432 = BoatFly.Method1330(a2.speed.getValue());
        double d = object.method_23317() + class_2432[0];
        double d2 = object2.method_23321() + class_2432[1];
        double d3 = object.method_23318();
        if (!BoatFly.mc.field_1687.method_8393((int)d >> 4, (int)d2 >> 4) && a2.stopunloaded.getValue()) {
            a2.Field2267 = true;
            return;
        }
        a2.Field2267 = false;
        ((IVec3d)a.method_18798()).setY(-(a2.glidespeed.getValue() / 100.0));
        if (a2.mode.getValue() == Mode.Motion) {
            ((IVec3d)a.method_18798()).setX(class_2432[0]);
            ((IVec3d)a.method_18798()).setZ(class_2432[1]);
        }
        if (BoatFly.mc.field_1690.field_1903.method_1434()) {
            if (!a2.ylimit.getValue() || a.method_23318() <= a2.height.getValue()) {
                if (a2.mode.getValue() == Mode.Motion) {
                    ((IVec3d)a.method_18798()).setY(a.method_18798().method_10214() + a2.yspeed.getValue());
                } else {
                    d3 += a2.yspeed.getValue();
                }
            }
        } else if (BoatFly.mc.field_1690.field_1832.method_1434()) {
            if (a2.mode.getValue() == Mode.Motion) {
                ((IVec3d)a.method_18798()).setY(a.method_18798().method_10214() + -a2.yspeed.getValue());
            } else {
                d3 += -a2.yspeed.getValue();
            }
        }
        if (!MovementUtil.isMoving()) {
            ((IVec3d)a.method_18798()).setX(0.0);
            ((IVec3d)a.method_18798()).setZ(0.0);
        }
        if (a2.ongroundpacket.getValue()) {
            a2.Method2876((class_1297)a);
        }
        if (a2.mode.getValue() != Mode.Motion) {
            a.method_5814(d, d3, d2);
        }
        if (a2.mode.getValue() == Mode.Packet) {
            a2.Method2875(new class_2833((class_1297)a));
        }
        if (a2.strict.getValue()) {
            BoatFly.mc.field_1761.method_2906(BoatFly.mc.field_1724.field_7512.field_7763, 0, 0, class_1713.field_7796, (class_1657)BoatFly.mc.field_1724);
        }
        if (a2.spoofpackets.getValue()) {
            class_2432 = a.method_19538().method_1031(0.0, (double)a2.Method2874(), 0.0);
            class_243 class_2433 = class_2432 = new class_1690((class_1937)BoatFly.mc.field_1687, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
            class_2433.method_36456(a.method_36454());
            class_2433.method_36457(a.method_36455());
            a2.Method2875(new class_2833((class_1297)class_2432));
        }
        if (a2.remount.getValue()) {
            BoatFly.mc.field_1724.field_3944.method_52787((class_2596)class_2824.method_34207((class_1297)a, (boolean)false, (class_1268)class_1268.field_5808));
        }
        ++a2.Field2264;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static double[] Method1330(double a) {
        var2_1 = MovementUtil.getMoveForward();
        var4_2 = MovementUtil.getMoveStrafe();
        var6_3 = BoatFly.mc.field_1724.field_5982 + (BoatFly.mc.field_1724.method_36454() - BoatFly.mc.field_1724.field_5982) * BoatFly.mc.method_1488();
        if (var2_1 == 0.0) ** GOTO lbl17
        if (var4_2 > 0.0) {
            var6_3 += (float)(var2_1 > 0.0 ? -45 : 45);
        } else if (var4_2 < 0.0) {
            var6_3 += (float)(var2_1 > 0.0 ? 45 : -45);
        }
        var4_2 = 0.0;
        if (var2_1 > 0.0) {
            var2_1 = 1.0;
            v0 = var6_3;
        } else {
            if (var2_1 < 0.0) {
                var2_1 = -1.0;
            }
lbl17: // 4 sources:
            v0 = var6_3;
        }
        var7_4 = Math.sin(Math.toRadians(v0 + 90.0f));
        var9_5 = Math.cos(Math.toRadians(var6_3 + 90.0f));
        var11_6 = var2_1 * a * var9_5 + var4_2 * a * var7_4;
        var2_1 = var2_1 * a * var7_4 - var4_2 * a * var9_5;
        v1 = new double[2];
        v1[0] = var11_6;
        v1[1] = var2_1;
        return v1;
    }

    private /* synthetic */ float Method2874() {
        BoatFly a;
        boolean bl = a.Field2268 = !a.Field2268;
        if (a.Field2268) {
            return a.offset.getValueFloat();
        }
        return -a.offset.getValueFloat();
    }

    public static final class Mode
    extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES;
        public static final /* enum */ Mode Motion;
        public static final /* enum */ Mode Packet;

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        static {
            Packet = new Mode(SnowAnimation.ALLATORIxDEMO("c\f[\r\\\u0013"), 0);
            Motion = new Mode(CameraState.ALLATORIxDEMO("\u001eP,]6["), 1);
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

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[2];
            arrmode[0] = Packet;
            arrmode[1] = Motion;
            return arrmode;
        }
    }

}
