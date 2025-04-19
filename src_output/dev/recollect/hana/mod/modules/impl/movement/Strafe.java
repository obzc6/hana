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
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.movement.HoleSnap;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.UserInfo;
import dev.recollect.hana.video.FileUtil;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_2596;
import net.minecraft.class_2664;
import net.minecraft.class_2708;
import net.minecraft.class_2743;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class Strafe
extends Module {
    private double lastExp;
    private final SliderSetting lagTime;
    private double distance;
    private final BooleanSetting slow;
    private final BooleanSetting velocity;
    private double speed;
    private final SliderSetting coolDown;
    private boolean boost;
    private final BooleanSetting inWater;
    private int stage;
    private final SliderSetting strafeSpeed;
    private boolean stop;
    private final BooleanSetting explosions;
    private final SliderSetting multiplier;
    private final Timer expTimer;
    private final BooleanSetting inBlock;
    private final SliderSetting vertical;
    private final Timer lagTimer;

    @Override
    public void onEnable() {
        if (Strafe.mc.field_1724 != null) {
            Strafe a;
            Strafe strafe = a;
            strafe.speed = MovementUtil.getSpeed(false);
            strafe.distance = MovementUtil.getDistance2D();
        }
        a.stage = 4;
    }

    public Strafe() {
        Strafe a;
        Strafe strafe = a;
        super(FileUtil.ALLATORIxDEMO("G\u000fa\u001dv\u001a"), Module.Category.Movement);
        Strafe strafe2 = a;
        strafe2.inWater = strafe.add(new BooleanSetting(UserInfo.ALLATORIxDEMO("\u001c\r\u0011\u00055\u00020"), false));
        strafe.inBlock = strafe.add(new BooleanSetting(FileUtil.ALLATORIxDEMO("!z9\u0013s\u0014"), false));
        strafe.strafeSpeed = strafe.add(new SliderSetting(UserInfo.ALLATORIxDEMO("\u0014\u0002<\u000e\u0015\u0014$\u0002&"), 287.3, 100.0, 1000.0, 0.1));
        strafe.explosions = strafe.add(new BooleanSetting(FileUtil.ALLATORIxDEMO("D\u0016w\u0004{\bz\u0013~\f"), false));
        strafe.velocity = strafe.add(new BooleanSetting(UserInfo.ALLATORIxDEMO("&0\u000f)\u0007(\u0013;"), true));
        strafe.multiplier = strafe.add(new SliderSetting(FileUtil.ALLATORIxDEMO("OER\u001ap\b\r"), 1.0, 0.0, 5.0, 0.01));
        strafe.vertical = strafe.add(new SliderSetting(UserInfo.ALLATORIxDEMO("&x%'\u00075\b0"), 1.0, 0.0, 5.0, 0.01));
        strafe.coolDown = strafe.add(new SliderSetting(FileUtil.ALLATORIxDEMO("D\u0007{\u0017W\u0013g\u0011"), 1000.0, 0.0, 5000.0, 1.0));
        strafe.lagTime = strafe.add(new SliderSetting(UserInfo.ALLATORIxDEMO("\u0019\u0002!0(\n'"), 500.0, 0.0, 1000.0, 1.0));
        strafe.slow = strafe.add(new BooleanSetting(FileUtil.ALLATORIxDEMO("T\u0004{\f}\u0019c\f"), false));
        a.expTimer = new Timer();
        a.lagTimer = new Timer();
        a.setChinese(UserInfo.ALLATORIxDEMO("\u7011\u6d7a\u52cf\u4f1e"));
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        Strafe a2 = this;
        if (!MovementUtil.isMoving()) {
            MovementUtil.setMotionX(0.0);
            MovementUtil.setMotionZ(0.0);
        }
        a2.distance = MovementUtil.getDistance2D();
    }

    @EventHandler
    public void invoke(MoveEvent moveEvent) {
        double d;
        Strafe strafe;
        MoveEvent moveEvent2;
        MoveEvent a = moveEvent;
        Strafe a2 = this;
        if (!a2.inWater.getValue() && (Strafe.mc.field_1724.method_5869() || Strafe.mc.field_1724.method_5799()) || Strafe.mc.field_1724.method_21754() || !a2.inBlock.getValue() && EntityUtil.isInsideBlock()) {
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
        if (Strafe.mc.field_1724.method_6128()) {
            return;
        }
        Strafe strafe2 = a2;
        if (!strafe2.lagTimer.passedMs(strafe2.lagTime.getValueInt())) {
            return;
        }
        if (a2.stage == 1 && MovementUtil.isMoving()) {
            d = 0.3999 + MovementUtil.getJumpSpeed();
            MovementUtil.setMotionY(d);
            a.setY(d);
            a2.speed *= a2.boost ? 1.6835 : 1.395;
            strafe = a2;
        } else if (a2.stage == 3) {
            Strafe strafe3 = a2;
            strafe3.speed = strafe3.distance - 0.66 * (a2.distance - MovementUtil.getSpeed(a2.slow.getValue(), a2.strafeSpeed.getValue() / 1000.0));
            strafe3.boost = !strafe3.boost;
            strafe = a2;
        } else {
            if ((Strafe.mc.field_1687.method_39454(null, Strafe.mc.field_1724.method_5829().method_989(0.0, MovementUtil.getMotionY(), 0.0)) || Strafe.mc.field_1724.field_34927) && a2.stage > 0) {
                a2.stage = MovementUtil.isMoving() ? 1 : 0;
            }
            Strafe strafe4 = a2;
            strafe = strafe4;
            a2.speed = strafe4.distance - a2.distance / 159.0;
        }
        strafe.speed = Math.min(a2.speed, 10.0);
        a2.speed = Math.max(a2.speed, MovementUtil.getSpeed(a2.slow.getValue(), a2.strafeSpeed.getValue() / 1000.0));
        d = MovementUtil.getMoveForward();
        double d2 = MovementUtil.getMoveStrafe();
        double d3 = Strafe.mc.field_1724.method_36454();
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

    @EventHandler(priority=100)
    public void invoke(PacketEvent.Receive receive) {
        Object a = receive;
        Strafe a2 = this;
        Object t = ((PacketEvent)a).getPacket();
        if (t instanceof class_2743) {
            class_2743 class_27432 = (class_2743)t;
            if (Strafe.mc.field_1724 != null && class_27432.method_11818() == Strafe.mc.field_1724.method_5628() && a2.velocity.getValue()) {
                double d = Math.sqrt(class_27432.method_11815() * class_27432.method_11815() + class_27432.method_11819() * class_27432.method_11819()) / 8000.0;
                double d2 = a2.lastExp = a2.expTimer.passedMs(a2.coolDown.getValueInt()) ? d : d - a2.lastExp;
                if (a2.lastExp > 0.0) {
                    a2.expTimer.reset();
                    mc.method_18859(() -> {
                        Strafe a;
                        Strafe strafe = a;
                        strafe.speed += a.lastExp * a.multiplier.getValue();
                        strafe.distance += a.lastExp * a.multiplier.getValue();
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
                if (Strafe.mc.field_1724 != null) {
                    a2.distance = 0.0;
                }
                a2.speed = 0.0;
                a2.stage = 4;
                return;
            }
            t = ((PacketEvent)a).getPacket();
            if (t instanceof class_2664) {
                a = (class_2664)t;
                if (a2.explosions.getValue() && MovementUtil.isMoving() && Strafe.mc.field_1724.method_5649(a.method_11475(), a.method_11477(), a.method_11478()) < 200.0) {
                    double d = Math.sqrt(Math.abs(a.method_11472() * a.method_11472()) + Math.abs(a.method_11474() * a.method_11474()));
                    double d3 = a2.lastExp = a2.expTimer.passedMs(a2.coolDown.getValueInt()) ? d : d - a2.lastExp;
                    if (a2.lastExp > 0.0) {
                        a2.expTimer.reset();
                        Strafe strafe = a2;
                        strafe.speed += a2.lastExp * a2.multiplier.getValue();
                        strafe.distance += a2.lastExp * a2.multiplier.getValue();
                        if (MovementUtil.getMotionY() > 0.0) {
                            MovementUtil.setMotionY(MovementUtil.getMotionY() * a2.vertical.getValue());
                        }
                    }
                }
            }
        }
    }
}
