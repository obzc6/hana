/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1656
 *  net.minecraft.class_1661
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_238
 *  net.minecraft.class_2596
 *  net.minecraft.class_2708
 *  net.minecraft.class_2739
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.TravelEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.Iterator;
import net.minecraft.class_1297;
import net.minecraft.class_1656;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_238;
import net.minecraft.class_2596;
import net.minecraft.class_2708;
import net.minecraft.class_2739;
import net.minecraft.class_2848;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class PacketElytra
extends Module {
    private final Timer pingTimer;
    private final BooleanSetting accelerate;
    private final SliderSetting factor;
    private float acceleration;
    private final BooleanSetting stopOnGround;
    private final SliderSetting speed;
    private final BooleanSetting infDurability;

    @EventHandler
    public void onPacketReceive(PacketEvent.Receive receive) {
        PacketEvent.Receive a = receive;
        PacketElytra a2 = this;
        Object t = a.getPacket();
        if (t instanceof class_2739 && ((class_2739)t).comp_1127() == PacketElytra.mc.field_1724.method_5628()) {
            a.cancel();
        }
        if (a.getPacket() instanceof class_2708) {
            a2.acceleration = 0.0f;
            a2.pingTimer.reset();
        }
    }

    @Override
    public void onEnable() {
        PacketElytra a;
        if (PacketElytra.nullCheck()) {
            return;
        }
        a.acceleration = 0.0f;
        a.pingTimer.reset();
    }

    @EventHandler
    public void onSync(UpdateWalkingEvent updateWalkingEvent) {
        UpdateWalkingEvent a = updateWalkingEvent;
        PacketElytra a2 = this;
        if (a.isPost()) {
            return;
        }
        if (!(a2.isBoxCollidingGround() && a2.stopOnGround.getValue() || PacketElytra.mc.field_1724.method_31548().method_5438(38).method_7909() != class_1802.field_8833 || !a2.infDurability.getValue() && PacketElytra.mc.field_1724.method_6128())) {
            PacketElytra.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)PacketElytra.mc.field_1724, class_2848.class_2849.field_12982));
        }
    }

    private /* synthetic */ boolean isBoxCollidingGround() {
        return PacketElytra.mc.field_1687.method_20812((class_1297)PacketElytra.mc.field_1724, PacketElytra.mc.field_1724.method_5829().method_1009(-0.25, 0.0, -0.25).method_989(0.0, -0.3, 0.0)).iterator().hasNext();
    }

    @EventHandler(priority=-200)
    public void onMove(MoveEvent moveEvent) {
        MoveEvent a = moveEvent;
        PacketElytra a2 = this;
        PacketElytra.mc.field_1724.method_31549().field_7479 = false;
        PacketElytra.mc.field_1724.method_31549().method_7248(0.05f);
        if (a2.isBoxCollidingGround() && a2.stopOnGround.getValue() || PacketElytra.mc.field_1724.method_31548().method_5438(38).method_7909() != class_1802.field_8833) {
            return;
        }
        PacketElytra.mc.field_1724.method_31549().field_7479 = true;
        PacketElytra.mc.field_1724.method_31549().method_7248(a2.speed.getValueFloat() / 15.0f * (a2.accelerate.getValue() ? Math.min((a2.acceleration += (float)a2.factor.getValue()) / 100.0f, 1.0f) : 1.0f));
        if (PacketElytra.mc.field_1724.field_6012 % 3 == 0) {
            Object object = a;
            a.setY(0.0);
            ((MoveEvent)object).setX(0.0);
            ((MoveEvent)object).setZ(0.0);
            return;
        }
        if (Math.abs(a.getX()) < 0.05) {
            a.setX(0.0);
        }
        if (Math.abs(a.getZ()) < 0.05) {
            a.setZ(0.0);
        }
        a.setY(-4.000355602329364E-12);
        if (PacketElytra.mc.field_1724.field_5976 && PacketElytra.mc.field_1724.field_6012 % 2 == 0) {
            a.setY(-0.07840000152587923);
        }
        if (!MovementUtil.isMoving() && Math.abs(a.getX()) < 0.121 && Math.abs(a.getX()) < 0.121) {
            float f = (float)Math.toRadians(4.5 * (double)(PacketElytra.mc.field_1724.field_6012 % 80));
            Object object = a;
            ((MoveEvent)object).setX(Math.sin(f) * 0.12);
            ((MoveEvent)object).setZ(Math.cos(f) * 0.12);
        }
    }

    @EventHandler
    public void modifyVelocity(TravelEvent travelEvent) {
        TravelEvent a = travelEvent;
        PacketElytra a2 = this;
    }

    @Override
    public void onDisable() {
        PacketElytra.mc.field_1724.method_31549().field_7479 = false;
        PacketElytra.mc.field_1724.method_31549().method_7248(0.05f);
    }

    public PacketElytra() {
        PacketElytra a;
        PacketElytra packetElytra = a;
        super(WebUtils.ALLATORIxDEMO("V.0q1i\u0016v7sv,"), Module.Category.Movement);
        PacketElytra packetElytra2 = a;
        packetElytra2.stopOnGround = packetElytra.add(new BooleanSetting(CameraState.ALLATORIxDEMO("*a?L\nG\u000fV!W3U"), false));
        packetElytra.infDurability = packetElytra.add(new BooleanSetting(WebUtils.ALLATORIxDEMO("[h)\u0017o&|1s\"np4"), true));
        packetElytra.speed = packetElytra.add(new SliderSetting(CameraState.ALLATORIxDEMO("{7@%w>G8U"), 1.5499999523162842, 0.10000000149011612, 10.0));
        packetElytra.accelerate = packetElytra.add(new BooleanSetting(WebUtils.ALLATORIxDEMO("G,08x!{:nk#"), false));
        a.factor = packetElytra.add(new SliderSetting(CameraState.ALLATORIxDEMO("\u000eE-V2C"), 9.0, 0.0, 100.0));
        a.pingTimer = new Timer();
        a.setChinese(WebUtils.ALLATORIxDEMO("\u539f\u5302\u979c\u7f88"));
    }
}
