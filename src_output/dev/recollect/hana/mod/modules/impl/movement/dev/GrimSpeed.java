/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1531
 *  net.minecraft.class_1656
 *  net.minecraft.class_238
 *  net.minecraft.class_241
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2664
 *  net.minecraft.class_2708
 *  net.minecraft.class_2743
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_638
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.movement.dev.GlidePuls;
import dev.recollect.hana.mod.modules.impl.movement.dev.SprintPlus;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.packet.Packet;
import java.util.function.Predicate;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1531;
import net.minecraft.class_1656;
import net.minecraft.class_238;
import net.minecraft.class_241;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2664;
import net.minecraft.class_2708;
import net.minecraft.class_2743;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_638;
import net.minecraft.class_744;
import net.minecraft.class_746;
import org.bytedeco.javacv.FrameFilter;

public class GrimSpeed
extends Module {
    private final SliderSetting vertical;
    private final SliderSetting multiplier;
    private int stage;
    private final BooleanSetting explosions;
    public static GrimSpeed INSTANCE;
    private double distance;
    private final BooleanSetting inWater;
    private int strictTicks;
    private final BooleanSetting slow;
    private final SliderSetting lagTime;
    private int strafe;
    private boolean stop;
    private final SliderSetting coolDown;
    private double lastExp;
    private final SliderSetting strafeSpeed;
    private boolean boost;
    private final BooleanSetting velocity;
    private final BooleanSetting inBlock;
    private final BooleanSetting jump;
    private double speed;
    private final BooleanSetting airStop;
    private final EnumSetting<Mode> mode;
    private final Timer expTimer;
    private final Timer lagTimer;
    public final SliderSetting collideSpeed;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public class_241 handleStrafeMotion(float a) {
        var2_3 = a;
        a = GrimSpeed.mc.field_1724.field_3913.field_3905;
        var4_4 = GrimSpeed.mc.field_1724.field_3913.field_3907;
        var3_5 = GrimSpeed.mc.field_1724.field_5982 + (GrimSpeed.mc.field_1724.method_36454() - GrimSpeed.mc.field_1724.field_5982) * GrimSpeed.mc.method_1488();
        if (a == 0.0f && var4_4 == 0.0f) {
            return class_241.field_1340;
        }
        if (a == 0.0f) ** GOTO lbl23
        if (var4_4 >= 1.0f) {
            var3_5 += a > 0.0f ? -45.0f : 45.0f;
            var4_4 = 0.0f;
            v0 = a;
        } else {
            if (var4_4 <= -1.0f) {
                var3_5 += a > 0.0f ? 45.0f : -45.0f;
                var4_4 = 0.0f;
            }
            v0 = a;
        }
        if (v0 > 0.0f) {
            a = 1.0f;
            v1 = var3_5;
        } else {
            if (a < 0.0f) {
                a = -1.0f;
            }
lbl23: // 4 sources:
            v1 = var3_5;
        }
        var5_6 = (float)Math.cos(Math.toRadians(v1));
        var3_5 = (float)(-Math.sin(Math.toRadians(var3_5)));
        return new class_241(a * a * var3_5 + var4_4 * a * var5_6, a * a * var5_6 - var4_4 * a * var3_5);
    }

    @EventHandler(priority=100)
    public void invoke(PacketEvent.Receive a) {
        GrimSpeed a2;
        GrimSpeed grimSpeed = a2;
        if (grimSpeed.mode.is(Mode.Custom)) {
            Object t = a.getPacket();
            if (t instanceof class_2743) {
                a2 = (class_2743)t;
                if (GrimSpeed.mc.field_1724 != null && a2.method_11818() == GrimSpeed.mc.field_1724.method_5628() && grimSpeed.velocity.getValue()) {
                    double d = Math.sqrt(a2.method_11815() * a2.method_11815() + a2.method_11819() * a2.method_11819()) / 8000.0;
                    double d2 = grimSpeed.lastExp = grimSpeed.expTimer.passedMs(grimSpeed.coolDown.getValueInt()) ? d : d - grimSpeed.lastExp;
                    if (grimSpeed.lastExp > 0.0) {
                        grimSpeed.expTimer.reset();
                        mc.method_18859(() -> {
                            GrimSpeed a;
                            GrimSpeed grimSpeed = a;
                            grimSpeed.speed += a.lastExp * a.multiplier.getValue();
                            grimSpeed.distance += a.lastExp * a.multiplier.getValue();
                            if (MovementUtil.getMotionY() > 0.0 && a.vertical.getValue() != 0.0) {
                                MovementUtil.setMotionY(MovementUtil.getMotionY() * a.vertical.getValue());
                            }
                        });
                        return;
                    }
                }
            } else {
                if (a.getPacket() instanceof class_2708) {
                    grimSpeed.lagTimer.reset();
                    if (GrimSpeed.mc.field_1724 != null) {
                        grimSpeed.distance = 0.0;
                    }
                    grimSpeed.speed = 0.0;
                    grimSpeed.stage = 4;
                    return;
                }
                t = a.getPacket();
                if (t instanceof class_2664) {
                    a2 = (class_2664)t;
                    if (grimSpeed.explosions.getValue() && MovementUtil.isMoving() && GrimSpeed.mc.field_1724.method_5649(a2.method_11475(), a2.method_11477(), a2.method_11478()) < 200.0) {
                        double d = Math.sqrt(Math.abs(a2.method_11472() * a2.method_11472()) + Math.abs(a2.method_11474() * a2.method_11474()));
                        double d3 = grimSpeed.lastExp = grimSpeed.expTimer.passedMs(grimSpeed.coolDown.getValueInt()) ? d : d - grimSpeed.lastExp;
                        if (grimSpeed.lastExp > 0.0) {
                            grimSpeed.expTimer.reset();
                            GrimSpeed grimSpeed2 = grimSpeed;
                            grimSpeed2.speed += grimSpeed.lastExp * grimSpeed.multiplier.getValue();
                            grimSpeed2.distance += grimSpeed.lastExp * grimSpeed.multiplier.getValue();
                            if (MovementUtil.getMotionY() > 0.0) {
                                MovementUtil.setMotionY(MovementUtil.getMotionY() * grimSpeed.vertical.getValue());
                                return;
                            }
                        }
                    }
                }
            }
        } else if (a.getPacket() instanceof class_2708) {
            grimSpeed.resetStrafe();
        }
    }

    @Override
    public void onUpdate() {
        GrimSpeed grimSpeed = this;
        double d = GrimSpeed.mc.field_1724.method_23317() - GrimSpeed.mc.field_1724.field_6014;
        double d2 = GrimSpeed.mc.field_1724.method_23321() - GrimSpeed.mc.field_1724.field_5969;
        double d3 = d;
        double d4 = d2;
        grimSpeed.distance = Math.sqrt(d3 * d3 + d4 * d4);
        if (grimSpeed.mode.is(Mode.GrimCollide)) {
            if (!MovementUtil.isMoving()) {
                return;
            }
            int n = 0;
            class_238 class_2382 = GrimSpeed.mc.field_1724.method_5829().method_1014(1.0);
            for (GrimSpeed a : GrimSpeed.mc.field_1687.method_18112()) {
                class_238 class_2383 = a.method_5829();
                if (!grimSpeed.canCauseSpeed((class_1297)a) || !class_2382.method_994(class_2383)) continue;
                ++n;
            }
            double d5 = Math.toRadians(SprintPlus.getSprintYaw(GrimSpeed.mc.field_1724.method_36454()));
            d2 = grimSpeed.collideSpeed.getValue() * (double)n;
            GrimSpeed.mc.field_1724.method_5762(-Math.sin(d5) * d2, 0.0, Math.cos(d5) * d2);
        }
    }

    public void resetStrafe() {
        GrimSpeed a;
        GrimSpeed grimSpeed = a;
        GrimSpeed grimSpeed2 = a;
        grimSpeed2.strafe = 4;
        grimSpeed2.strictTicks = 0;
        grimSpeed.speed = 0.0;
        grimSpeed.distance = 0.0;
    }

    private /* synthetic */ boolean canCauseSpeed(class_1297 class_12972) {
        GrimSpeed a = class_12972;
        GrimSpeed a2 = this;
        return a != GrimSpeed.mc.field_1724 && a instanceof class_1309 && !(a instanceof class_1531);
    }

    /*
     * WARNING - void declaration
     */
    @EventHandler
    public void invoke(MoveEvent moveEvent) {
        double d;
        void a;
        GrimSpeed grimSpeed = this;
        if (GlidePuls.INSTANCE != null && GlidePuls.INSTANCE.isOn() && GrimSpeed.mc.field_1724.method_6059(class_1294.field_5906)) {
            return;
        }
        if (!MovementUtil.isMoving() && grimSpeed.airStop.getValue() && !grimSpeed.mode.is(Mode.GrimCollide)) {
            MovementUtil.setMotionX(0.0);
            MovementUtil.setMotionZ(0.0);
        }
        if (!grimSpeed.inWater.getValue() && (GrimSpeed.mc.field_1724.method_5869() || GrimSpeed.mc.field_1724.method_5799() || GrimSpeed.mc.field_1724.method_5771()) || GrimSpeed.mc.field_1724.method_3144() || GrimSpeed.mc.field_1724.method_21754() || !grimSpeed.inBlock.getValue() && EntityUtil.isInsideBlock() || GrimSpeed.mc.field_1724.method_31549().field_7479 || GrimSpeed.mc.field_1724.method_6128() || !MovementUtil.isMoving()) {
            grimSpeed.resetStrafe();
            grimSpeed.stop = true;
            return;
        }
        if (grimSpeed.mode.is(Mode.Custom)) {
            void v6;
            GrimSpeed grimSpeed2;
            double d2;
            if (grimSpeed.stop) {
                grimSpeed.stop = false;
                return;
            }
            GrimSpeed grimSpeed3 = grimSpeed;
            if (!grimSpeed3.lagTimer.passedMs(grimSpeed3.lagTime.getValueInt())) {
                return;
            }
            if (grimSpeed.stage == 1) {
                GrimSpeed grimSpeed4 = grimSpeed;
                grimSpeed2 = grimSpeed4;
                grimSpeed4.speed = 1.35 * MovementUtil.getSpeed(grimSpeed4.slow.getValue(), grimSpeed.strafeSpeed.getValue()) - 0.01;
            } else if (grimSpeed.stage == 2 && GrimSpeed.mc.field_1724.method_24828() && (GrimSpeed.mc.field_1690.field_1903.method_1434() || grimSpeed.jump.getValue())) {
                d2 = 0.3999 + MovementUtil.getJumpSpeed();
                MovementUtil.setMotionY(d2);
                a.setY(d2);
                grimSpeed.speed *= grimSpeed.boost ? 1.6835 : 1.395;
                grimSpeed2 = grimSpeed;
            } else if (grimSpeed.stage == 3) {
                GrimSpeed grimSpeed5 = grimSpeed;
                grimSpeed5.speed = grimSpeed5.distance - 0.66 * (grimSpeed.distance - MovementUtil.getSpeed(grimSpeed.slow.getValue(), grimSpeed.strafeSpeed.getValue()));
                grimSpeed5.boost = !grimSpeed5.boost;
                grimSpeed2 = grimSpeed;
            } else {
                if ((GrimSpeed.mc.field_1687.method_39454(null, GrimSpeed.mc.field_1724.method_5829().method_989(0.0, MovementUtil.getMotionY(), 0.0)) || GrimSpeed.mc.field_1724.field_34927) && grimSpeed.stage > 0) {
                    grimSpeed.stage = 1;
                }
                GrimSpeed grimSpeed6 = grimSpeed;
                grimSpeed2 = grimSpeed6;
                grimSpeed.speed = grimSpeed6.distance - grimSpeed.distance / 159.0;
            }
            grimSpeed2.speed = Math.min(grimSpeed.speed, 10.0);
            grimSpeed.speed = Math.max(grimSpeed.speed, MovementUtil.getSpeed(grimSpeed.slow.getValue(), grimSpeed.strafeSpeed.getValue()));
            d2 = MovementUtil.getMoveForward();
            double d3 = MovementUtil.getMoveStrafe();
            double d4 = GrimSpeed.mc.field_1724.method_36454();
            if (d2 == 0.0 && d3 == 0.0) {
                void v5 = a;
                v6 = v5;
                v5.setX(0.0);
                v5.setZ(0.0);
            } else {
                if (d2 != 0.0 && d3 != 0.0) {
                    d2 *= Math.sin(0.7853981633974483);
                    d3 *= Math.cos(0.7853981633974483);
                }
                v6 = a;
            }
            v6.setX((d2 * grimSpeed.speed * -Math.sin(Math.toRadians(d4)) + d3 * grimSpeed.speed * Math.cos(Math.toRadians(d4))) * 0.99);
            a.setZ((d2 * grimSpeed.speed * Math.cos(Math.toRadians(d4)) - d3 * grimSpeed.speed * -Math.sin(Math.toRadians(d4))) * 0.99);
            ++grimSpeed.stage;
            return;
        }
        double d5 = 1.0;
        double d6 = 1.0;
        if (GrimSpeed.mc.field_1724.method_6059(class_1294.field_5904)) {
            d = GrimSpeed.mc.field_1724.method_6112(class_1294.field_5904).method_5578();
            d5 = 1.0 + 0.2 * (d + 1.0);
        }
        if (GrimSpeed.mc.field_1724.method_6059(class_1294.field_5909)) {
            d = GrimSpeed.mc.field_1724.method_6112(class_1294.field_5909).method_5578();
            d6 = 1.0 + 0.2 * (d + 1.0);
        }
        d = 0.2872999906539917 * d5 / d6;
        float a22 = 0.0f;
        if (GrimSpeed.mc.field_1724.method_6059(class_1294.field_5913)) {
            a22 += (float)(GrimSpeed.mc.field_1724.method_6112(class_1294.field_5913).method_5578() + 1) * 0.1f;
        }
        if (grimSpeed.mode.getValue() == Mode.StrafeStrict) {
            GrimSpeed grimSpeed7;
            GrimSpeed grimSpeed8 = grimSpeed;
            if (!grimSpeed8.lagTimer.passed(grimSpeed8.lagTime.getValueInt())) {
                return;
            }
            if (grimSpeed.strafe == 1) {
                grimSpeed7 = grimSpeed;
                grimSpeed.speed = 1.350000023841858 * d - 0.009999999776482582;
            } else if (grimSpeed.strafe == 2) {
                if (GrimSpeed.mc.field_1724.field_3913.field_3904 || !GrimSpeed.mc.field_1724.method_24828()) {
                    return;
                }
                float f = 0.39999995f + a22;
                grimSpeed7 = grimSpeed;
                float f2 = f;
                a.setY(f2);
                MovementUtil.setMotionY(f2);
                grimSpeed.speed *= 2.149;
            } else if (grimSpeed.strafe == 3) {
                double d7 = 0.66 * (grimSpeed.distance - d);
                GrimSpeed grimSpeed9 = grimSpeed;
                grimSpeed7 = grimSpeed9;
                grimSpeed9.speed = grimSpeed9.distance - d7;
            } else {
                if ((!GrimSpeed.mc.field_1687.method_8587((class_1297)GrimSpeed.mc.field_1724, GrimSpeed.mc.field_1724.method_5829().method_989(0.0, GrimSpeed.mc.field_1724.method_18798().method_10214(), 0.0)) || GrimSpeed.mc.field_1724.field_5992) && grimSpeed.strafe > 0) {
                    grimSpeed.strafe = 1;
                }
                GrimSpeed grimSpeed10 = grimSpeed;
                grimSpeed7 = grimSpeed10;
                grimSpeed.speed = grimSpeed10.distance - grimSpeed.distance / 159.0;
            }
            ++grimSpeed7.strictTicks;
            GrimSpeed grimSpeed11 = grimSpeed;
            grimSpeed11.speed = Math.max(grimSpeed11.speed, d);
            double d8 = 0.465 * d5 / d6;
            d5 = 0.44 * d5 / d6;
            grimSpeed.speed = Math.min(grimSpeed11.speed, grimSpeed.strictTicks > 25 ? d8 : d5);
            if (grimSpeed.strictTicks > 50) {
                grimSpeed.strictTicks = 0;
            }
            GrimSpeed grimSpeed12 = grimSpeed;
            class_241 a22 = grimSpeed12.handleStrafeMotion((float)grimSpeed12.speed);
            void v14 = a;
            v14.setX(a22.field_1343);
            v14.setZ(a22.field_1342);
            ++grimSpeed12.strafe;
        }
    }

    @Override
    public String getInfo() {
        GrimSpeed a;
        return a.mode.getValue().name();
    }

    @Override
    public void onEnable() {
        if (GrimSpeed.mc.field_1724 != null) {
            GrimSpeed a;
            GrimSpeed grimSpeed = a;
            grimSpeed.speed = MovementUtil.getSpeed(false);
            grimSpeed.distance = MovementUtil.getDistance2D();
        }
        a.stage = 4;
    }

    public GrimSpeed() {
        GrimSpeed a;
        GrimSpeed grimSpeed = a;
        super(Packet.ALLATORIxDEMO("IxDrko]{]"), Module.Category.Movement);
        GrimSpeed grimSpeed2 = a;
        grimSpeed2.mode = grimSpeed.add(new EnumSetting<Mode>(HoleUtils.ALLATORIxDEMO("orGy"), Mode.Custom));
        grimSpeed.collideSpeed = grimSpeed.add(new SliderSetting(Packet.ALLATORIxDEMO("T_EbcIzko]{]"), 0.08, 0.01, 0.08, 0.01, object -> {
            Object a = object;
            GrimSpeed a2 = this;
            return a2.mode.is(Mode.GrimCollide);
        }));
        a.inWater = a.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("ALJCiFn"), false, object -> {
            Object a = object;
            GrimSpeed a2 = this;
            return !a2.mode.is(Mode.GrimCollide);
        }));
        a.inBlock = a.add(new BooleanSetting(Packet.ALLATORIxDEMO("dqzsW}R"), false, object -> {
            Object a = object;
            GrimSpeed a2 = this;
            return !a2.mode.is(Mode.GrimCollide);
        }));
        a.airStop = a.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("IKoqiLl"), false, object -> {
            Object a = object;
            GrimSpeed a2 = this;
            return !a2.mode.is(Mode.GrimCollide);
        }));
        a.lagTime = a.add(new SliderSetting(Packet.ALLATORIxDEMO("a~_KQs\\"), 500.0, 0.0, 1000.0, 1.0, object -> {
            Object a = object;
            GrimSpeed a2 = this;
            return !a2.mode.is(Mode.GrimCollide);
        }));
        a.jump = a.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("hhNl"), true, object -> {
            Object a = object;
            GrimSpeed a2 = this;
            return a2.mode.is(Mode.Custom);
        }));
        a.strafeSpeed = a.add(new SliderSetting(Packet.ALLATORIxDEMO("IxDrko]{]"), 0.2873, 0.0, 1.0, 1.0E-4, object -> {
            Object a = object;
            GrimSpeed a2 = this;
            return a2.mode.is(Mode.Custom);
        }));
        a.explosions = a.add(new BooleanSetting(HoleUtils.ALLATORIxDEMO("OVaFzgBXfQ_MrPh"), false, object -> {
            Object a = object;
            GrimSpeed a2 = this;
            return a2.mode.is(Mode.Custom);
        }));
        a.velocity = a.add(new BooleanSetting(Packet.ALLATORIxDEMO("br\\FmcYfzpWmM"), true, object -> {
            Object a = object;
            GrimSpeed a2 = this;
            return a2.mode.is(Mode.Custom);
        }));
        a.multiplier = a.add(new SliderSetting(HoleUtils.ALLATORIxDEMO("%d|AiLn"), 1.0, 0.0, 5.0, 0.01, object -> {
            Object a = object;
            GrimSpeed a2 = this;
            return a2.mode.is(Mode.Custom);
        }));
        a.vertical = a.add(new SliderSetting(Packet.ALLATORIxDEMO("\\\u0000YY|LqK"), 1.0, 0.0, 5.0, 0.01, object -> {
            Object a = object;
            GrimSpeed a2 = this;
            return a2.mode.is(Mode.Custom);
        }));
        a.coolDown = a.add(new SliderSetting(HoleUtils.ALLATORIxDEMO("tgMqfrTr"), 1000.0, 0.0, 5000.0, 1.0, object -> {
            Object a = object;
            GrimSpeed a2 = this;
            return a2.mode.is(Mode.Custom);
        }));
        a.slow = a.add(new BooleanSetting(Packet.ALLATORIxDEMO("YApOq]mJ"), false, object -> {
            Object a = object;
            GrimSpeed a2 = this;
            return a2.mode.is(Mode.Custom);
        }));
        GrimSpeed grimSpeed3 = a;
        GrimSpeed grimSpeed4 = a;
        grimSpeed4.expTimer = new Timer();
        grimSpeed4.lagTimer = new Timer();
        grimSpeed3.strafe = 4;
        grimSpeed3.setChinese(HoleUtils.ALLATORIxDEMO("\u9afa\u53d0\u4f7e\u5f17\u903c\u5eba"));
        INSTANCE = grimSpeed3;
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode GrimCollide;
        public static final /* enum */ Mode StrafeStrict;
        public static final /* enum */ Mode Custom;
        private static final /* synthetic */ Mode[] $VALUES;

        static {
            Custom = new Mode(Setting.ALLATORIxDEMO("X-u1#b"), 0);
            GrimCollide = new Mode(FrameFilter.ALLATORIxDEMO("Pt>\u0002}\"p*~#s"), 1);
            StrafeStrict = new Mode(Setting.ALLATORIxDEMO("M)i9z:H,t,/{"), 2);
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

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        private static /* synthetic */ Mode[] $values() {
            Mode[] arrmode = new Mode[3];
            arrmode[0] = Custom;
            arrmode[1] = GrimCollide;
            arrmode[2] = StrafeStrict;
            return arrmode;
        }

        public static Mode valueOf(String a) {
            return Enum.valueOf(Mode.class, a);
        }
    }

}
