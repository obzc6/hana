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
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.KeyboardInputEvent;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_744;
import net.minecraft.class_746;

public class FastSwim
extends Module {
    private final SliderSetting upSpeed;
    public final SliderSetting downFactor;
    private final SliderSetting sneakDownSpeed;
    public final SliderSetting speed;
    private MoveEvent event;
    public static FastSwim INSTANCE;

    private /* synthetic */ void setY(double a) {
        FastSwim a2;
        double d = a;
        a2.event.setY(d);
        MovementUtil.setMotionY(d);
    }

    @EventHandler
    public void onKeyboardInput(KeyboardInputEvent keyboardInputEvent) {
        KeyboardInputEvent a = keyboardInputEvent;
        FastSwim a2 = this;
        if (FastSwim.mc.field_1724.method_52535()) {
            FastSwim.mc.field_1724.field_3913.field_3903 = false;
        }
    }

    public FastSwim() {
        FastSwim a;
        FastSwim fastSwim = a;
        FastSwim fastSwim2 = a;
        super(TimeHelper.ALLATORIxDEMO("a\u0004S\u0016n\b\u001eX"), Module.Category.Movement);
        FastSwim fastSwim3 = a;
        fastSwim3.speed = fastSwim2.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("3Y\u0018\u0006S"), 0.2, 0.0, 1.0, 0.01));
        fastSwim2.sneakDownSpeed = fastSwim2.add(new SliderSetting(TimeHelper.ALLATORIxDEMO("&H\u0012N1M\u001a\u0012Q"), 0.2, 0.0, 1.0, 0.01));
        fastSwim2.upSpeed = fastSwim2.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("2D3Y\u0018\u0006S"), 0.2, 0.0, 1.0, 0.01));
        fastSwim.downFactor = fastSwim2.add(new SliderSetting(TimeHelper.ALLATORIxDEMO("d\rP\u000bf\u0003^\u000b\u0018G"), 0.0, 0.0, 1.0, 1.0E-6));
        fastSwim.setChinese(RadiusUtils.ALLATORIxDEMO("\u5fc2\u9062\u6e5b\u6cc4"));
        INSTANCE = fastSwim;
    }

    @EventHandler
    public void onMove(MoveEvent moveEvent) {
        double[] a = moveEvent;
        FastSwim a2 = this;
        if (FastSwim.nullCheck()) {
            return;
        }
        if (FastSwim.mc.field_1724.method_52535()) {
            FastSwim fastSwim;
            a2.event = a;
            if (!FastSwim.mc.field_1690.field_1832.method_1434() || !FastSwim.mc.field_1724.field_3913.field_3904) {
                if (FastSwim.mc.field_1690.field_1832.method_1434()) {
                    FastSwim fastSwim2 = a2;
                    fastSwim = fastSwim2;
                    fastSwim2.setY(-fastSwim2.sneakDownSpeed.getValue());
                } else {
                    FastSwim fastSwim3 = a2;
                    if (FastSwim.mc.field_1724.field_3913.field_3904) {
                        fastSwim3.setY(a2.upSpeed.getValue());
                        fastSwim = a2;
                    } else {
                        fastSwim3.setY(-a2.downFactor.getValue());
                        fastSwim = a2;
                    }
                }
            } else {
                FastSwim fastSwim4 = a2;
                fastSwim = fastSwim4;
                fastSwim4.setY(0.0);
            }
            a = MovementUtil.directionSpeed(fastSwim.speed.getValue());
            FastSwim fastSwim5 = a2;
            fastSwim5.setX(a[0]);
            fastSwim5.setZ(a[1]);
        }
    }

    private /* synthetic */ void setX(double a) {
        FastSwim a2;
        double d = a;
        a2.event.setX(d);
        MovementUtil.setMotionX(d);
    }

    private /* synthetic */ void setZ(double a) {
        FastSwim a2;
        double d = a;
        a2.event.setZ(d);
        MovementUtil.setMotionZ(d);
    }
}
