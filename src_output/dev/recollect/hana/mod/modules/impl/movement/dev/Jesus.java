/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2708
 *  net.minecraft.class_310
 *  net.minecraft.class_3486
 *  net.minecraft.class_638
 *  net.minecraft.class_6862
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.PlayerMoveEvent;
import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.asm.accessors.IVec3d;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2708;
import net.minecraft.class_310;
import net.minecraft.class_3486;
import net.minecraft.class_638;
import net.minecraft.class_6862;
import net.minecraft.class_744;
import net.minecraft.class_746;

public class Jesus
extends Module {
    public final SliderSetting water_speed;
    private final BooleanSetting toggle;
    public final SliderSetting bob;
    private class_310 mc;
    private final BooleanSetting move;
    public static Jesus INSTANCE;
    private final BooleanSetting inWater;
    private final BooleanSetting isSlowed;

    @Override
    public void onUpdate() {
        Jesus a;
        a.inWater.getValue(false);
    }

    @EventHandler
    private /* synthetic */ void onReceive(PacketEvent.Receive receive) {
        PacketEvent.Receive a = receive;
        Jesus a2 = this;
        if (a.getPacket() instanceof class_2708) {
            a2.isSlowed.getValue(true);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent a) {
        Jesus a2;
        Jesus jesus = a2;
        if (jesus.mc.field_1724 != null && class_310.method_1551().field_1687 != null) {
            boolean bl;
            boolean bl2;
            a2 = class_310.method_1551().field_1687.method_8320(jesus.mc.field_1724.method_24515().method_10074()).method_26204();
            class_2248 class_22482 = class_310.method_1551().field_1687.method_8320(jesus.mc.field_1724.method_24515()).method_26204();
            boolean bl3 = jesus.mc.field_1724.method_5799() || jesus.mc.field_1724.method_5771();
            boolean bl4 = bl = !jesus.mc.field_1724.method_5869() && !jesus.mc.field_1724.method_5777(class_3486.field_15518);
            if (a2 != class_2246.field_10382 && class_22482 != class_2246.field_10382) {
                bl2 = bl3;
                jesus.inWater.getValue(false);
            } else {
                if (bl3 && bl) {
                    if (!jesus.inWater.getValue()) {
                        jesus.isSlowed.getValue(false);
                    }
                    jesus.inWater.getValue(true);
                }
                bl2 = bl3;
            }
            if (bl2 && bl) {
                ((IVec3d)jesus.mc.field_1724.method_18798()).setY(jesus.bob.getValue());
                if (jesus.toggle.getValue() && !jesus.mc.field_1724.method_5777(class_3486.field_15518) && !jesus.isSlowed.getValue()) {
                    Jesus jesus2 = jesus;
                    double d = jesus2.water_speed.getValue();
                    a2 = jesus2.mc.field_1724.method_6112(class_1294.field_5904);
                    if (a2 != null) {
                        d *= 1.2 + (double)a2.method_5578() * 0.2;
                    }
                    if ((a2 = jesus.mc.field_1724.method_6112(class_1294.field_5909)) != null) {
                        d /= 1.2 + (double)a2.method_5578() * 0.2;
                    }
                    Jesus jesus3 = jesus;
                    double d2 = jesus3.mc.field_1724.field_3913.field_3905;
                    double d3 = jesus3.mc.field_1724.field_3913.field_3907;
                    d2 = jesus3.getYaw(d2, d3);
                    d3 = Math.cos(Math.toRadians(d2 + 90.0));
                    d2 = Math.sin(Math.toRadians(d2 + 90.0));
                    PlayerMoveEvent playerMoveEvent = a;
                    if (jesus3.move.getValue()) {
                        PlayerMoveEvent playerMoveEvent2 = a;
                        playerMoveEvent.setMovement(new class_243(a.getMovement().field_1352, a.getMovement().field_1351, a.getMovement().field_1350).method_1031(d3 * d, 0.0, d2 * d));
                        return;
                    }
                    playerMoveEvent.setMovement(new class_243(0.0, a.getMovement().field_1351, 0.0));
                }
            }
        }
    }

    public Jesus() {
        Jesus a;
        Jesus jesus = a;
        Jesus jesus2 = a;
        super(WebUtils.ALLATORIxDEMO("P+tq>"), Module.Category.Movement);
        Jesus jesus3 = a;
        jesus3.move = jesus2.add(new BooleanSetting(Alt.ALLATORIxDEMO("o7r;"), true));
        jesus2.inWater = jesus2.add(new BooleanSetting(WebUtils.ALLATORIxDEMO("t=M/sa?"), true));
        jesus2.isSlowed = jesus2.add(new BooleanSetting(Alt.ALLATORIxDEMO("{;W2m/a:"), true));
        jesus2.toggle = jesus2.add(new BooleanSetting(WebUtils.ALLATORIxDEMO("'u)`h("), true));
        jesus2.bob = jesus2.add(new SliderSetting(Alt.ALLATORIxDEMO("%}*$8m*g;"), 0.005, 0.0, 1.0));
        jesus2.water_speed = jesus2.add(new SliderSetting(WebUtils.ALLATORIxDEMO("\u00182n1osi>ba)"), 1, 0, 2));
        jesus.mc = class_310.method_1551();
        jesus.setChinese(Alt.ALLATORIxDEMO("\u7adb\u5770\u6c30\u4e54"));
        INSTANCE = jesus;
    }

    private /* synthetic */ double getYaw(double a, double a2) {
        Jesus a3;
        double d = a3.mc.field_1724.method_36454();
        if (a > 0.0) {
            a3.move.getValue(true);
            return d += a2 > 0.0 ? -45.0 : (a2 < 0.0 ? 45.0 : 0.0);
        }
        if (a < 0.0) {
            a3.move.getValue(true);
            return d += a2 > 0.0 ? -135.0 : (a2 < 0.0 ? 135.0 : 180.0);
        }
        a3.move.getValue(a2 != 0.0);
        return d += a2 > 0.0 ? -90.0 : (a2 < 0.0 ? 90.0 : 0.0);
    }
}
