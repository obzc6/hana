/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_744;
import net.minecraft.class_746;
import org.bytedeco.javacv.FrameConverter;

public class Flight
extends Module {
    private MoveEvent event;
    public final SliderSetting downFactor;
    private final SliderSetting sneakDownSpeed;
    public final SliderSetting speed;
    private final SliderSetting upSpeed;
    public static Flight INSTANCE;

    private /* synthetic */ void setY(double a) {
        Flight a2;
        double d = a;
        a2.event.setY(d);
        MovementUtil.setMotionY(d);
    }

    private /* synthetic */ void setX(double a) {
        Flight a2;
        double d = a;
        a2.event.setX(d);
        MovementUtil.setMotionX(d);
    }

    private /* synthetic */ void setZ(double a) {
        Flight a2;
        double d = a;
        a2.event.setZ(d);
        MovementUtil.setMotionZ(d);
    }

    public Flight() {
        Flight a;
        Flight flight = a;
        Flight flight2 = a;
        super(Alt.ALLATORIxDEMO("V&v\"k-"), FrameConverter.ALLATORIxDEMO("H#"), Module.Category.Movement);
        Flight flight3 = a;
        flight3.speed = flight2.add(new SliderSetting(Alt.ALLATORIxDEMO("\u0006l-}\u0019o f="), 1.0, 0.10000000149011612, 10.0));
        flight2.sneakDownSpeed = flight2.add(new SliderSetting(FrameConverter.ALLATORIxDEMO("U\u001aa\u001cB\u001fi@\""), 1.0, 0.10000000149011612, 10.0));
        flight2.upSpeed = flight2.add(new SliderSetting(Alt.ALLATORIxDEMO("\u0011`\u0019o f="), 1.0, 0.10000000149011612, 10.0));
        flight.downFactor = flight2.add(new SliderSetting(FrameConverter.ALLATORIxDEMO("6~\u0002x4p\fxJ4"), 0.0, 0.0, 1.0, 9.999999974752427E-7));
        flight.setChinese(Alt.ALLATORIxDEMO("\u98dd\u8815"));
        INSTANCE = flight;
    }

    @EventHandler
    public void onMove(MoveEvent moveEvent) {
        Flight flight;
        double[] a = moveEvent;
        Flight a2 = this;
        if (Flight.nullCheck()) {
            return;
        }
        a2.event = a;
        if (!Flight.mc.field_1690.field_1832.method_1434() || !Flight.mc.field_1724.field_3913.field_3904) {
            if (Flight.mc.field_1690.field_1832.method_1434()) {
                Flight flight2 = a2;
                flight = flight2;
                flight2.setY(-flight2.sneakDownSpeed.getValue());
            } else {
                Flight flight3 = a2;
                if (Flight.mc.field_1724.field_3913.field_3904) {
                    flight3.setY(a2.upSpeed.getValue());
                    flight = a2;
                } else {
                    flight3.setY(-a2.downFactor.getValue());
                    flight = a2;
                }
            }
        } else {
            Flight flight4 = a2;
            flight = flight4;
            flight4.setY(0.0);
        }
        a = MovementUtil.directionSpeed(flight.speed.getValue());
        Flight flight5 = a2;
        flight5.setX(a[0]);
        flight5.setZ(a[1]);
    }
}
