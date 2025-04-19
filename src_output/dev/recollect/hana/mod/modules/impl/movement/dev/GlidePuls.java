/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.socket.network.info.record.UserInfo;
import net.minecraft.class_1291;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_744;
import net.minecraft.class_746;

public class GlidePuls
extends Module {
    public final SliderSetting speed;
    public final SliderSetting yOffset;
    public final SliderSetting downFactor;
    private MoveEvent event;
    public final BooleanSetting onlyFall;
    public static GlidePuls INSTANCE;
    public final BooleanSetting noCollision;

    public GlidePuls() {
        GlidePuls a;
        GlidePuls glidePuls = a;
        GlidePuls glidePuls2 = a;
        super(Alt.ALLATORIxDEMO("E4r%au"), Module.Category.Movement);
        GlidePuls glidePuls3 = a;
        glidePuls3.onlyFall = glidePuls2.add(new BooleanSetting(UserInfo.ALLATORIxDEMO("\u001d\u0019\u001b+(*\u001d8"), false));
        glidePuls2.noCollision = glidePuls2.add(new BooleanSetting(Alt.ALLATORIxDEMO("\u0007}\u000bH\u0011n1h(k0"), false));
        glidePuls2.yOffset = glidePuls2.add(new SliderSetting(UserInfo.ALLATORIxDEMO(".84\b8\u0014 "), 0.6, 0.1, 1.0, 0.01));
        glidePuls2.speed = glidePuls2.add(new SliderSetting(Alt.ALLATORIxDEMO("\u000fU\u0014o\u000bk$a:"), 0.6, 0.1, 1.0, 0.01));
        glidePuls.downFactor = glidePuls2.add(new SliderSetting(UserInfo.ALLATORIxDEMO("\u00043\u001b\u001b\u0001\u001e.\u00140"), 0.0, 0.0, 1.0, 1.0E-6));
        glidePuls.setChinese(Alt.ALLATORIxDEMO("\u594e\u6604\u4efb\u6ed5\u7f8a"));
        INSTANCE = glidePuls;
    }

    @EventHandler(priority=-100)
    public void onMove(MoveEvent moveEvent) {
        double[] a = moveEvent;
        GlidePuls a2 = this;
        if (GlidePuls.nullCheck()) {
            return;
        }
        if (GlidePuls.mc.field_1724.field_3913.field_3903) {
            return;
        }
        if (!GlidePuls.mc.field_1724.method_6059(class_1294.field_5906)) {
            return;
        }
        if (a2.onlyFall.getValue() && GlidePuls.mc.field_1724.field_6017 <= 0.0f) {
            return;
        }
        if (GlidePuls.mc.field_1724.method_24828()) {
            return;
        }
        if (GlidePuls.mc.field_1724.field_5976 && a2.noCollision.getValue()) {
            return;
        }
        if (GlidePuls.mc.field_1687.method_39454((class_1297)GlidePuls.mc.field_1724, GlidePuls.mc.field_1724.method_5829().method_989(0.0, -a2.yOffset.getValue(), 0.0))) {
            GlidePuls glidePuls = a2;
            glidePuls.event = a;
            glidePuls.setY(-glidePuls.downFactor.getValue());
            a = MovementUtil.directionSpeed(glidePuls.speed.getValue());
            glidePuls.setX(a[0]);
            glidePuls.setZ(a[1]);
        }
    }

    private /* synthetic */ void setX(double a) {
        GlidePuls a2;
        double d = a;
        a2.event.setX(d);
        MovementUtil.setMotionX(d);
    }

    private /* synthetic */ void setZ(double a) {
        GlidePuls a2;
        double d = a;
        a2.event.setZ(d);
        MovementUtil.setMotionZ(d);
    }

    private /* synthetic */ void setY(double a) {
        GlidePuls a2;
        double d = a;
        a2.event.setY(d);
        MovementUtil.setMotionY(d);
    }
}
