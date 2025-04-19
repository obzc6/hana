/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1690
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2692
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_3675
 *  net.minecraft.class_408
 *  net.minecraft.class_437
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.BoatMoveEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.UpdateWalkingEvent;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.asm.accessors.IVec3d;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.Snow;
import net.minecraft.class_1041;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1690;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2692;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3675;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_746;

public class EntityControl
extends Module {
    public static EntityControl INSTANCE;
    public final BooleanSetting fly;
    private final SliderSetting verticalSpeed;
    public final SliderSetting fallSpeed;
    public final BooleanSetting yaw;
    public final SliderSetting speed;
    public final BooleanSetting speedBoolean;
    private final BooleanSetting noSync;

    @EventHandler
    public void onBoat(BoatMoveEvent boatMoveEvent) {
        EntityControl entityControl;
        double d;
        Object a = boatMoveEvent;
        EntityControl a2 = this;
        if (EntityControl.nullCheck()) {
            return;
        }
        if ((a = ((BoatMoveEvent)a).getBoat()) == null) {
            return;
        }
        if (a.method_5642() != EntityControl.mc.field_1724) {
            return;
        }
        if (a2.yaw.getValue()) {
            a.method_36456(EntityControl.mc.field_1724.method_36454());
        }
        class_243 class_2432 = MovementUtil.getHorizontalVelocity(a2.speed.getValue());
        double d2 = class_2432.method_10216();
        double d3 = class_2432.method_10215();
        if (EntityControl.mc.field_1755 instanceof class_408 || EntityControl.mc.field_1755 != null && UIModule.INSTANCE.isOff()) {
            EntityControl entityControl2 = a2;
            entityControl = entityControl2;
            d = -entityControl2.fallSpeed.getValue() / 20.0;
        } else {
            boolean bl = class_3675.method_15987((long)mc.method_22683().method_4490(), (int)class_3675.method_15981((String)EntityControl.mc.field_1690.field_1867.method_1428()).method_1444());
            if (class_3675.method_15987((long)mc.method_22683().method_4490(), (int)class_3675.method_15981((String)EntityControl.mc.field_1690.field_1903.method_1428()).method_1444())) {
                EntityControl entityControl3 = a2;
                if (bl) {
                    d = -entityControl3.fallSpeed.getValue() / 20.0;
                    entityControl = a2;
                } else {
                    d = entityControl3.verticalSpeed.getValue() / 20.0;
                    entityControl = a2;
                }
            } else {
                EntityControl entityControl4 = a2;
                if (bl) {
                    d = -entityControl4.verticalSpeed.getValue() / 20.0;
                    entityControl = a2;
                } else {
                    d = -entityControl4.fallSpeed.getValue() / 20.0;
                    entityControl = a2;
                }
            }
        }
        if (entityControl.speedBoolean.getValue()) {
            ((IVec3d)a.method_18798()).setX(d2);
        }
        if (a2.fly.getValue()) {
            ((IVec3d)a.method_18798()).setY(d);
        }
        if (a2.speedBoolean.getValue()) {
            ((IVec3d)a.method_18798()).setZ(d3);
        }
    }

    @EventHandler
    private /* synthetic */ void onReceivePacket(PacketEvent.Receive receive) {
        PacketEvent.Receive a = receive;
        EntityControl a2 = this;
        if (a.getPacket() instanceof class_2692 && a2.noSync.getValue()) {
            a.cancel();
        }
    }

    public EntityControl() {
        EntityControl a;
        EntityControl entityControl = a;
        EntityControl entityControl2 = a;
        super(Snow.ALLATORIxDEMO("nbsdrn_~txu`h"), Module.Category.Movement);
        EntityControl entityControl3 = a;
        entityControl3.yaw = entityControl2.add(new BooleanSetting(ObsidianHelper.ALLATORIxDEMO("\u0011A<"), true));
        entityControl2.speedBoolean = entityControl2.add(new BooleanSetting(Snow.ALLATORIxDEMO("I|bj`"), true));
        entityControl2.speed = entityControl2.add(new SliderSetting(ObsidianHelper.ALLATORIxDEMO("v\u0006S-E/"), 5.0, 0.1, 50.0));
        entityControl2.fly = entityControl2.add(new BooleanSetting(Snow.ALLATORIxDEMO("Ac}"), true));
        entityControl2.verticalSpeed = entityControl2.add(new SliderSetting(ObsidianHelper.ALLATORIxDEMO("h\u0006S-E/"), 6.0, 0.0, 20.0));
        entityControl2.fallSpeed = entityControl2.add(new SliderSetting(Snow.ALLATORIxDEMO("@vp}I|bj`"), 0.1, 0.0, 50.0));
        entityControl.noSync = entityControl2.add(new BooleanSetting(ObsidianHelper.ALLATORIxDEMO("p:p1N("), false));
        entityControl.setChinese(Snow.ALLATORIxDEMO("\u5b92\u4f54\u63a8\u5232"));
        INSTANCE = entityControl;
    }

    @EventHandler
    public void onUpdateWalking(UpdateWalkingEvent updateWalkingEvent) {
        EntityControl entityControl;
        double d;
        Object a = updateWalkingEvent;
        EntityControl a2 = this;
        if (EntityControl.nullCheck()) {
            return;
        }
        a = EntityControl.mc.field_1724.method_5854();
        if (a == null) {
            return;
        }
        if (a2.yaw.getValue()) {
            a.method_36456(EntityControl.mc.field_1724.method_36454());
        }
        class_243 class_2432 = MovementUtil.getHorizontalVelocity(a2.speed.getValue());
        double d2 = class_2432.method_10216();
        double d3 = class_2432.method_10215();
        if (EntityControl.mc.field_1755 instanceof class_408 || EntityControl.mc.field_1755 != null && UIModule.INSTANCE.isOff()) {
            EntityControl entityControl2 = a2;
            entityControl = entityControl2;
            d = -entityControl2.fallSpeed.getValue() / 20.0;
        } else {
            boolean bl = class_3675.method_15987((long)mc.method_22683().method_4490(), (int)class_3675.method_15981((String)EntityControl.mc.field_1690.field_1867.method_1428()).method_1444());
            if (class_3675.method_15987((long)mc.method_22683().method_4490(), (int)class_3675.method_15981((String)EntityControl.mc.field_1690.field_1903.method_1428()).method_1444())) {
                EntityControl entityControl3 = a2;
                if (bl) {
                    d = -entityControl3.fallSpeed.getValue() / 20.0;
                    entityControl = a2;
                } else {
                    d = entityControl3.verticalSpeed.getValue() / 20.0;
                    entityControl = a2;
                }
            } else {
                EntityControl entityControl4 = a2;
                if (bl) {
                    d = -entityControl4.verticalSpeed.getValue() / 20.0;
                    entityControl = a2;
                } else {
                    d = -entityControl4.fallSpeed.getValue() / 20.0;
                    entityControl = a2;
                }
            }
        }
        if (entityControl.speedBoolean.getValue()) {
            ((IVec3d)a.method_18798()).setX(d2);
        }
        if (a2.fly.getValue()) {
            ((IVec3d)a.method_18798()).setY(d);
        }
        if (a2.speedBoolean.getValue()) {
            ((IVec3d)a.method_18798()).setZ(d3);
        }
    }
}
