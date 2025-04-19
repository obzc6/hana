/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  io.netty.util.internal.ConcurrentSet
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2708
 *  net.minecraft.class_2793
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_2828$class_2831
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.events.Event;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.user.User;
import io.netty.util.internal.ConcurrentSet;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2708;
import net.minecraft.class_2793;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_744;
import net.minecraft.class_746;

public class PacketFly
extends Module {
    public final SliderSetting extraFactor;
    public final BooleanSetting flight;
    private int teleportID;
    public final SliderSetting loops;
    public final BooleanSetting setID;
    public final SliderSetting flightMode;
    public final BooleanSetting strafeFactor;
    public final BooleanSetting setMove;
    public final BooleanSetting nocliperino;
    public final SliderSetting antiFactor;
    public final BooleanSetting sendTeleport;
    private int flightCounter;
    public final BooleanSetting invalidPacket;
    private final Set<class_2828> packets;
    public final BooleanSetting antiRotation;
    public final BooleanSetting setPos;

    public PacketFly() {
        PacketFly a;
        PacketFly packetFly = a;
        super(CameraState.ALLATORIxDEMO("e)G\u0011s$z)P"), User.ALLATORIxDEMO("fZDbpWyZS"), Module.Category.Movement);
        PacketFly packetFly2 = a;
        packetFly2.flight = packetFly.add(new BooleanSetting(CameraState.ALLATORIxDEMO("<z9[-]"), true).setParent());
        packetFly.flightMode = packetFly.add(new SliderSetting(User.ALLATORIxDEMO("SnPRO"), 0, 0, 1, object -> {
            Object a = object;
            PacketFly a2 = this;
            return a2.flight.isOpen();
        }));
        PacketFly packetFly3 = a;
        PacketFly packetFly4 = a;
        packetFly4.antiFactor = packetFly4.add(new SliderSetting(CameraState.ALLATORIxDEMO("\u0018[<M<w3H*["), 1.0, 0.1, 3.0));
        packetFly4.extraFactor = packetFly4.add(new SliderSetting(User.ALLATORIxDEMO("}RBIFOt@KYX"), 1.0, 0.1, 3.0));
        packetFly4.strafeFactor = packetFly4.add(new BooleanSetting(CameraState.ALLATORIxDEMO("\u0004O+T.A<w3H*["), true));
        packetFly4.loops = packetFly4.add(new SliderSetting(User.ALLATORIxDEMO("YLPFY"), 1, 1, 10));
        packetFly4.antiRotation = packetFly4.add(new BooleanSetting(CameraState.ALLATORIxDEMO("\u0016U-\\\u001aK\u000ew$U*G"), false));
        packetFly4.setID = packetFly4.add(new BooleanSetting(User.ALLATORIxDEMO("FFKn"), true));
        packetFly4.setMove = packetFly4.add(new BooleanSetting(CameraState.ALLATORIxDEMO("w\u001fb\u001dS3L"), false));
        packetFly4.nocliperino = packetFly4.add(new BooleanSetting(User.ALLATORIxDEMO("Gz`S_Z"), false));
        packetFly4.sendTeleport = packetFly4.add(new BooleanSetting(CameraState.ALLATORIxDEMO("\u001cA\u0016s S7]"), true));
        packetFly4.setPos = packetFly4.add(new BooleanSetting(User.ALLATORIxDEMO("ZpWoYY"), false));
        packetFly3.invalidPacket = packetFly4.add(new BooleanSetting(CameraState.ALLATORIxDEMO("z9M8Y!@*w3W ]"), true));
        packetFly3.packets = new ConcurrentSet();
        packetFly3.flightCounter = 0;
        a.teleportID = 0;
        a.setChinese(User.ALLATORIxDEMO("\u53f2\u533a\u98e8\u8866"));
    }

    private /* synthetic */ boolean checkHitBoxes() {
        return PacketFly.mc.field_1687.method_39454((class_1297)PacketFly.mc.field_1724, PacketFly.mc.field_1724.method_5829().method_1009(-0.0625, -0.0625, -0.0625));
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void sendPackets(double d, double d2, double d3, boolean bl) {
        void a;
        void a2;
        void a3;
        void a222;
        PacketFly packetFly = this;
        class_243 a222 = new class_243((double)a222, (double)a3, (double)a);
        PacketFly a4 = PacketFly.mc.field_1724.method_19538().method_1019(a222);
        PacketFly packetFly2 = packetFly;
        class_243 class_2432 = packetFly2.outOfBoundsVec((class_243)a4);
        packetFly2.packetSender((class_2828)new class_2828.class_2829(((class_243)a4).field_1352, ((class_243)a4).field_1351, ((class_243)a4).field_1350, PacketFly.mc.field_1724.method_24828()));
        if (packetFly.invalidPacket.getValue()) {
            packetFly.packetSender((class_2828)new class_2828.class_2829(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, PacketFly.mc.field_1724.method_24828()));
        }
        if (packetFly.setPos.getValue()) {
            PacketFly.mc.field_1724.method_5814(((class_243)a4).field_1352, ((class_243)a4).field_1351, ((class_243)a4).field_1350);
        }
        packetFly.teleportPacket((boolean)a2);
    }

    @EventHandler
    public void onUpdateWalkingPlayer(UpdateWalkingEvent updateWalkingEvent) {
        double d;
        int n;
        UpdateWalkingEvent a322 = updateWalkingEvent;
        PacketFly a = this;
        if (PacketFly.nullCheck()) {
            return;
        }
        if (a322.isPost()) {
            return;
        }
        PacketFly.mc.field_1724.method_18800(0.0, 0.0, 0.0);
        boolean a322 = a.checkHitBoxes();
        double d2 = PacketFly.mc.field_1724.field_3913.field_3904 && (a322 || !MovementUtil.isMoving()) ? (a.flight.getValue() && !a322 ? (a.flightMode.getValue() == 0.0 ? (a.resetCounter(10) ? -0.032 : 0.062) : (a.resetCounter(20) ? -0.032 : 0.062)) : 0.062) : (PacketFly.mc.field_1724.field_3913.field_3903 ? -0.062 : (!a322 ? (a.resetCounter(4) ? (a.flight.getValue() ? -0.04 : 0.0) : 0.0) : (d = 0.0)));
        if (a322 && MovementUtil.isMoving() && d != 0.0) {
            d /= a.antiFactor.getValue();
        }
        PacketFly packetFly = a;
        double[] a322 = packetFly.getMotion(packetFly.strafeFactor.getValue() && a322 ? 0.031 : 0.26);
        int n2 = n = 1;
        while ((double)n2 < a.loops.getValue() + 1.0) {
            double[] arrd = a322;
            MovementUtil.setMotionX(arrd[0] * (double)n * a.extraFactor.getValue());
            MovementUtil.setMotionY(d * (double)n);
            PacketFly packetFly2 = a;
            MovementUtil.setMotionZ(arrd[1] * (double)n * packetFly2.extraFactor.getValue());
            packetFly2.sendPackets(MovementUtil.getMotionX(), MovementUtil.getMotionY(), MovementUtil.getMotionZ(), a.sendTeleport.getValue());
            n2 = ++n;
        }
    }

    private /* synthetic */ boolean resetCounter(int n) {
        int a = n;
        PacketFly a2 = this;
        if (++a2.flightCounter >= a) {
            a2.flightCounter = 0;
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private /* synthetic */ double[] getMotion(double a) {
        var3_3 = a;
        a = MovementUtil.getMoveForward();
        var4_4 = MovementUtil.getMoveStrafe();
        var5_5 = PacketFly.mc.field_1724.field_5982 + (PacketFly.mc.field_1724.method_36454() - PacketFly.mc.field_1724.field_5982) * PacketFly.mc.method_1488();
        if (a == 0.0f) ** GOTO lbl17
        if (var4_4 > 0.0f) {
            var5_5 += (float)(a > 0.0f ? -45 : 45);
        } else if (var4_4 < 0.0f) {
            var5_5 += (float)(a > 0.0f ? 45 : -45);
        }
        var4_4 = 0.0f;
        if (a > 0.0f) {
            v0 = a = 1.0f;
        } else {
            if (a < 0.0f) {
                a = -1.0f;
            }
lbl17: // 4 sources:
            v0 = a;
        }
        var6_6 = (double)v0 * a * -Math.sin(Math.toRadians(var5_5)) + (double)var4_4 * a * Math.cos(Math.toRadians(var5_5));
        a = (double)a * a * Math.cos(Math.toRadians(var5_5)) - (double)var4_4 * a * -Math.sin(Math.toRadians(var5_5));
        v1 = new double[2];
        v1[0] = var6_6;
        v1[1] = a;
        return v1;
    }

    private /* synthetic */ class_243 outOfBoundsVec(class_243 class_2432) {
        PacketFly a = class_2432;
        PacketFly a2 = this;
        return a.method_1031(0.0, 1337.0, 0.0);
    }

    @EventHandler
    public void onPacketSend(PacketEvent.Send send) {
        PacketEvent.Send a = send;
        PacketFly a2 = this;
        if (PacketFly.nullCheck()) {
            return;
        }
        if (a.getPacket() instanceof class_2828) {
            if (!a2.packets.remove((Object)((class_2828)a.getPacket()))) {
                if (a.getPacket() instanceof class_2828.class_2831 && !a2.antiRotation.getValue()) {
                    return;
                }
                a.cancel();
            }
        }
    }

    @EventHandler
    public void onMove(MoveEvent moveEvent) {
        MoveEvent a = moveEvent;
        PacketFly a2 = this;
        if (PacketFly.nullCheck()) {
            return;
        }
        if (a2.setMove.getValue() && a2.flightCounter != 0) {
            Object object = a;
            ((MoveEvent)object).setX(MovementUtil.getMotionX());
            ((MoveEvent)object).setY(MovementUtil.getMotionY());
            ((MoveEvent)object).setZ(MovementUtil.getMotionZ());
            if (a2.nocliperino.getValue() && a2.checkHitBoxes()) {
                PacketFly.mc.field_1724.field_5960 = true;
            }
        }
    }

    private /* synthetic */ void packetSender(class_2828 class_28282) {
        PacketFly a = class_28282;
        PacketFly a2 = this;
        a2.packets.add((class_2828)a);
        PacketFly.mc.field_1724.field_3944.method_52787((class_2596)a);
    }

    @EventHandler
    public void onReceivePacket(PacketEvent.Receive receive) {
        Object a = receive;
        PacketFly a2 = this;
        if (PacketFly.nullCheck()) {
            return;
        }
        if (((Event)a).isCancelled()) {
            return;
        }
        if (((PacketEvent)a).getPacket() instanceof class_2708) {
            a = (class_2708)((PacketEvent)a).getPacket();
            if (a2.setID.getValue()) {
                a2.teleportID = a.method_11737();
            }
        }
    }

    private /* synthetic */ void teleportPacket(boolean bl) {
        boolean a = bl;
        PacketFly a2 = this;
        if (a) {
            PacketFly.mc.field_1724.field_3944.method_52787((class_2596)new class_2793(++a2.teleportID));
        }
    }
}
