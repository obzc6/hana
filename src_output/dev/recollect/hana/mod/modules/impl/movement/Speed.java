/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_2596
 *  net.minecraft.class_2664
 *  net.minecraft.class_2708
 *  net.minecraft.class_2743
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.movement.HoleSnap;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_2596;
import net.minecraft.class_2664;
import net.minecraft.class_2708;
import net.minecraft.class_2743;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class Speed
extends Module {
    private double distance;
    private double lastExp;
    private final SliderSetting strafeSpeed;
    private final Timer expTimer;
    private final Timer lagTimer;
    private boolean stop;
    private final BooleanSetting explosions;
    private int stage;
    public static Speed INSTANCE;
    private final BooleanSetting inBlock;
    private final SliderSetting lagTime;
    private boolean boost;
    private final SliderSetting vertical;
    private final BooleanSetting velocity;
    private final SliderSetting multiplier;
    private final BooleanSetting slow;
    private final SliderSetting coolDown;
    private final BooleanSetting inWater;
    private final BooleanSetting jump;
    private double speed;

    @Override
    public String getInfo() {
        return Snow.ALLATORIxDEMO("W$v1c4");
    }

    public Speed() {
        Speed a;
        Speed speed = a;
        Speed speed2 = a;
        super(BlockUpUtil.ALLATORIxDEMO("IHb\u0017)"), Module.Category.Movement);
        Speed speed3 = a;
        speed3.jump = speed2.add(new BooleanSetting(Snow.ALLATORIxDEMO("N%h!"), true));
        speed2.inWater = speed2.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("TKMYs\u0017?"), false));
        speed2.inBlock = speed2.add(new BooleanSetting(Snow.ALLATORIxDEMO("\fj\u0012h?f:"), false));
        speed2.strafeSpeed = speed2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("IHb\u0017)"), 287.3, 100.0, 1000.0, 0.1));
        speed2.explosions = speed2.add(new BooleanSetting(Snow.ALLATORIxDEMO("w\u001ea)k#m?k\""), false));
        speed2.velocity = speed2.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("txIu[n\u00064"), true));
        speed2.multiplier = speed2.add(new SliderSetting(Snow.ALLATORIxDEMO("YhB1g$j#"), 1.0, 0.0, 5.0, 0.01));
        speed2.vertical = speed2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("t0c{[s\u001d?"), 1.0, 0.0, 5.0, 0.01));
        speed2.coolDown = speed2.add(new SliderSetting(Snow.ALLATORIxDEMO("R*k<@?r?"), 1000.0, 0.0, 5000.0, 1.0));
        speed2.lagTime = speed2.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("QD}ln\u001f("), 500.0, 0.0, 1000.0, 1.0));
        speed2.slow = speed2.add(new BooleanSetting(Snow.ALLATORIxDEMO("B)k'j5v\""), false));
        speed2.expTimer = new Timer();
        speed.lagTimer = new Timer();
        speed.setChinese(BlockUpUtil.ALLATORIxDEMO("\u906d\u5eeb"));
        INSTANCE = speed;
    }

    @Override
    public void onEnable() {
        if (Speed.mc.field_1724 != null) {
            Speed a;
            Speed speed = a;
            speed.speed = MovementUtil.getSpeed(false);
            speed.distance = MovementUtil.getDistance2D();
        }
        a.stage = 4;
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        Speed a2 = this;
        if (!MovementUtil.isMoving()) {
            MovementUtil.setMotionX(0.0);
            MovementUtil.setMotionZ(0.0);
        }
        a2.distance = MovementUtil.getDistance2D();
    }

    @EventHandler(priority=100)
    public void invoke(PacketEvent.Receive receive) {
        Object a = receive;
        Speed a2 = this;
        Object t = ((PacketEvent)a).getPacket();
        if (t instanceof class_2743) {
            class_2743 class_27432 = (class_2743)t;
            if (Speed.mc.field_1724 != null && class_27432.method_11818() == Speed.mc.field_1724.method_5628() && a2.velocity.getValue()) {
                double d = Math.sqrt(class_27432.method_11815() * class_27432.method_11815() + class_27432.method_11819() * class_27432.method_11819()) / 8000.0;
                double d2 = a2.lastExp = a2.expTimer.passedMs(a2.coolDown.getValueInt()) ? d : d - a2.lastExp;
                if (a2.lastExp > 0.0) {
                    a2.expTimer.reset();
                    mc.method_18859(() -> {
                        Speed a;
                        Speed speed = a;
                        speed.speed += a.lastExp * a.multiplier.getValue();
                        speed.distance += a.lastExp * a.multiplier.getValue();
                        if (MovementUtil.getMotionY() > 0.0 && a.vertical.getValue() != 0.0) {
                            MovementUtil.setMotionY(MovementUtil.getMotionY() * a.vertical.getValue());
                        }
                    });
                    return;
                }
            }
        } else {
            if (((PacketEvent)a).getPacket() instanceof class_2708) {
                a2.lagTimer.reset();
                if (Speed.mc.field_1724 != null) {
                    a2.distance = 0.0;
                }
                a2.speed = 0.0;
                a2.stage = 4;
                return;
            }
            t = ((PacketEvent)a).getPacket();
            if (t instanceof class_2664) {
                a = (class_2664)t;
                if (a2.explosions.getValue() && MovementUtil.isMoving() && Speed.mc.field_1724.method_5649(a.method_11475(), a.method_11477(), a.method_11478()) < 200.0) {
                    double d = Math.sqrt(Math.abs(a.method_11472() * a.method_11472()) + Math.abs(a.method_11474() * a.method_11474()));
                    double d3 = a2.lastExp = a2.expTimer.passedMs(a2.coolDown.getValueInt()) ? d : d - a2.lastExp;
                    if (a2.lastExp > 0.0) {
                        a2.expTimer.reset();
                        Speed speed = a2;
                        speed.speed += a2.lastExp * a2.multiplier.getValue();
                        speed.distance += a2.lastExp * a2.multiplier.getValue();
                        if (MovementUtil.getMotionY() > 0.0) {
                            MovementUtil.setMotionY(MovementUtil.getMotionY() * a2.vertical.getValue());
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void invoke(MoveEvent moveEvent) {
        MoveEvent moveEvent2;
        double d;
        Speed speed;
        MoveEvent a = moveEvent;
        Speed a2 = this;
        if (!a2.inWater.getValue() && (Speed.mc.field_1724.method_5869() || Speed.mc.field_1724.method_5799()) || Speed.mc.field_1724.method_21754() || !a2.inBlock.getValue() && EntityUtil.isInsideBlock()) {
            a2.stop = true;
            return;
        }
        if (a2.stop) {
            a2.stop = false;
            return;
        }
        if (!MovementUtil.isMoving() || HoleSnap.INSTANCE.isOn()) {
            return;
        }
        if (Speed.mc.field_1724.method_6128()) {
            return;
        }
        Speed speed2 = a2;
        if (!speed2.lagTimer.passedMs(speed2.lagTime.getValueInt())) {
            return;
        }
        if (a2.stage == 1 && MovementUtil.isMoving()) {
            Speed speed3 = a2;
            speed = speed3;
            speed3.speed = 1.35 * MovementUtil.getSpeed(speed3.slow.getValue(), a2.strafeSpeed.getValue() / 1000.0) - 0.01;
        } else if (a2.stage == 2 && Speed.mc.field_1724.method_24828() && MovementUtil.isMoving() && (Speed.mc.field_1690.field_1903.method_1434() || a2.jump.getValue())) {
            d = 0.3999 + MovementUtil.getJumpSpeed();
            MovementUtil.setMotionY(d);
            a.setY(d);
            a2.speed *= a2.boost ? 1.6835 : 1.395;
            speed = a2;
        } else if (a2.stage == 3) {
            Speed speed4 = a2;
            speed4.speed = speed4.distance - 0.66 * (a2.distance - MovementUtil.getSpeed(a2.slow.getValue(), a2.strafeSpeed.getValue() / 1000.0));
            speed4.boost = !speed4.boost;
            speed = a2;
        } else {
            if ((Speed.mc.field_1687.method_39454(null, Speed.mc.field_1724.method_5829().method_989(0.0, MovementUtil.getMotionY(), 0.0)) || Speed.mc.field_1724.field_34927) && a2.stage > 0) {
                a2.stage = MovementUtil.isMoving() ? 1 : 0;
            }
            Speed speed5 = a2;
            speed = speed5;
            a2.speed = speed5.distance - a2.distance / 159.0;
        }
        speed.speed = Math.min(a2.speed, 10.0);
        a2.speed = Math.max(a2.speed, MovementUtil.getSpeed(a2.slow.getValue(), a2.strafeSpeed.getValue() / 1000.0));
        d = MovementUtil.getMoveForward();
        double d2 = MovementUtil.getMoveStrafe();
        double d3 = Speed.mc.field_1724.method_36454();
        if (d == 0.0 && d2 == 0.0) {
            Object object = a;
            moveEvent2 = object;
            ((MoveEvent)object).setX(0.0);
            ((MoveEvent)object).setZ(0.0);
        } else {
            if (d != 0.0 && d2 != 0.0) {
                d *= Math.sin(0.7853981633974483);
                d2 *= Math.cos(0.7853981633974483);
            }
            moveEvent2 = a;
        }
        moveEvent2.setX((d * a2.speed * -Math.sin(Math.toRadians(d3)) + d2 * a2.speed * Math.cos(Math.toRadians(d3))) * 0.99);
        a.setZ((d * a2.speed * Math.cos(Math.toRadians(d3)) - d2 * a2.speed * -Math.sin(Math.toRadians(d3))) * 0.99);
        if (MovementUtil.isMoving()) {
            ++a2.stage;
        }
    }

    public static final class SpeedMode
    extends Enum<SpeedMode> {
        public static final /* enum */ SpeedMode NCP;
        public static final /* enum */ SpeedMode Vanilla;
        public static final /* enum */ SpeedMode VHop;
        public static final /* enum */ SpeedMode LowHop;
        public static final /* enum */ SpeedMode Constantiam;
        public static final /* enum */ SpeedMode Strafe;
        public static final /* enum */ SpeedMode None;
        public static final /* enum */ SpeedMode Bhop;
        private static final /* synthetic */ SpeedMode[] $VALUES;
        public static final /* enum */ SpeedMode GayHop;
        public static final /* enum */ SpeedMode Instant;
        public static final /* enum */ SpeedMode OnGround;
        public static final /* enum */ SpeedMode OldGround;

        /*
         * Exception decompiling
         */
        private /* synthetic */ SpeedMode() {
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

        public static SpeedMode[] values() {
            return (SpeedMode[])$VALUES.clone();
        }

        public static SpeedMode valueOf(String a) {
            return Enum.valueOf(SpeedMode.class, a);
        }

        static {
            Instant = new SpeedMode(TimerManager.ALLATORIxDEMO("\u0005\u00178\u00107@h"), 0);
            OldGround = new SpeedMode(HoleUtils.ALLATORIxDEMO("SfQoeLiLy"), 1);
            OnGround = new SpeedMode(TimerManager.ALLATORIxDEMO("1\">9\u000b#@x"), 2);
            Vanilla = new SpeedMode(HoleUtils.ALLATORIxDEMO("cIyJpN|"), 3);
            NCP = new SpeedMode(TimerManager.ALLATORIxDEMO("\u0018mL"), 4);
            Strafe = new SpeedMode(HoleUtils.ALLATORIxDEMO("{cQ}Dx"), 5);
            GayHop = new SpeedMode(TimerManager.ALLATORIxDEMO(">*\u001d\u001eAl"), 6);
            Bhop = new SpeedMode(HoleUtils.ALLATORIxDEMO("atMm"), 7);
            VHop = new SpeedMode(TimerManager.ALLATORIxDEMO("2\u001eAl"), 8);
            LowHop = new SpeedMode(HoleUtils.ALLATORIxDEMO("dxTTMm"), 9);
            Constantiam = new SpeedMode(TimerManager.ALLATORIxDEMO("\r\u0016%\r8\u0018%\u0010?Oq"), 10);
            None = new SpeedMode(HoleUtils.ALLATORIxDEMO("msLx"), 11);
            $VALUES = SpeedMode.$values();
        }

        private static /* synthetic */ SpeedMode[] $values() {
            SpeedMode[] arrspeedMode = new SpeedMode[12];
            arrspeedMode[0] = Instant;
            arrspeedMode[1] = OldGround;
            arrspeedMode[2] = OnGround;
            arrspeedMode[3] = Vanilla;
            arrspeedMode[4] = NCP;
            arrspeedMode[5] = Strafe;
            arrspeedMode[6] = GayHop;
            arrspeedMode[7] = Bhop;
            arrspeedMode[8] = VHop;
            arrspeedMode[9] = LowHop;
            arrspeedMode[10] = Constantiam;
            arrspeedMode[11] = None;
            return arrspeedMode;
        }
    }

}
