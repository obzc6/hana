/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1656
 *  net.minecraft.class_1770
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_5911
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.TravelEvent;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.Iterator;
import net.minecraft.class_1297;
import net.minecraft.class_1656;
import net.minecraft.class_1770;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_2848;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_634;
import net.minecraft.class_746;

public class ElytraFlyPlus
extends Module {
    public static ElytraFlyPlus INSTANCE;
    public SliderSetting horizontalSpeed;
    public boolean hasElytra;
    public SliderSetting verticalSpeed;
    private final class_243 vec3d;

    @EventHandler
    public void onPacketSend(PacketEvent.Send send) {
        PacketEvent.Send a = send;
        ElytraFlyPlus a2 = this;
        if (a.getPacket() instanceof class_2828) {
            ElytraFlyPlus.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)ElytraFlyPlus.mc.field_1724, class_2848.class_2849.field_12982));
        }
    }

    @Override
    public void onDisable() {
        ElytraFlyPlus.mc.field_1724.method_31549().field_7479 = false;
        ElytraFlyPlus.mc.field_1724.method_31549().field_7478 = false;
    }

    public ElytraFlyPlus() {
        ElytraFlyPlus a;
        ElytraFlyPlus elytraFlyPlus = a;
        super(RadiusUtils.ALLATORIxDEMO("?\rL@\u0012R!X\u0019y\u0011\u0016D"), Module.Category.Movement);
        ElytraFlyPlus elytraFlyPlus2 = a;
        a.vec3d = new class_243(0.0, 0.0, 0.0);
        a.hasElytra = false;
        a.horizontalSpeed = a.add(new SliderSetting(TipUtils.ALLATORIxDEMO(":4\u0006}A.\u00002\b-=,\u0016s]"), 1.3, 0.1, 40.0));
        elytraFlyPlus.verticalSpeed = a.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("2D3Y\u0018\u0006S"), 1.3, 0.1, 40.0));
        elytraFlyPlus.setChinese(TipUtils.ALLATORIxDEMO("\u97f6\u7f99\u98ad\u885a\u0012"));
        INSTANCE = elytraFlyPlus;
    }

    @Override
    public void onUpdate() {
        Object a;
        ElytraFlyPlus elytraFlyPlus = a;
        if (ElytraFlyPlus.nullCheck()) {
            return;
        }
        Object object = a = ElytraFlyPlus.mc.field_1724.method_5661().iterator();
        while (object.hasNext()) {
            if (((class_1799)a.next()).method_7909() instanceof class_1770) {
                elytraFlyPlus.hasElytra = true;
                if (ElytraFlyPlus.mc.field_1690.field_1894.method_1434()) {
                    elytraFlyPlus.vec3d.method_1031(0.0, 0.0, elytraFlyPlus.horizontalSpeed.getValue());
                    elytraFlyPlus.vec3d.method_1024(-((float)Math.toRadians(ElytraFlyPlus.mc.field_1724.method_36454())));
                } else if (ElytraFlyPlus.mc.field_1690.field_1881.method_1434()) {
                    elytraFlyPlus.vec3d.method_1031(0.0, 0.0, elytraFlyPlus.horizontalSpeed.getValue());
                    elytraFlyPlus.vec3d.method_1024((float)Math.toRadians(ElytraFlyPlus.mc.field_1724.method_36454()));
                }
                if (ElytraFlyPlus.mc.field_1690.field_1903.method_1434()) {
                    elytraFlyPlus.vec3d.method_1031(0.0, elytraFlyPlus.verticalSpeed.getValue(), 0.0);
                } else if (!ElytraFlyPlus.mc.field_1690.field_1903.method_1434()) {
                    elytraFlyPlus.vec3d.method_1031(0.0, -elytraFlyPlus.verticalSpeed.getValue(), 0.0);
                }
                ElytraFlyPlus.mc.field_1724.method_18799(elytraFlyPlus.vec3d);
                ElytraFlyPlus.mc.field_1724.field_3944.method_52787((class_2596)new class_2848((class_1297)ElytraFlyPlus.mc.field_1724, class_2848.class_2849.field_12982));
                ElytraFlyPlus.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_5911(true));
                return;
            }
            elytraFlyPlus.hasElytra = false;
            object = a;
        }
    }

    @EventHandler
    public void onMove(TravelEvent travelEvent) {
        TravelEvent a = travelEvent;
        ElytraFlyPlus a2 = this;
        if (ElytraFlyPlus.nullCheck()) {
            return;
        }
        ElytraFlyPlus.mc.field_1724.method_31549().field_7479 = true;
        ElytraFlyPlus.mc.field_1724.method_31549().method_7248(a2.horizontalSpeed.getValueFloat() / 20.0f);
    }
}
