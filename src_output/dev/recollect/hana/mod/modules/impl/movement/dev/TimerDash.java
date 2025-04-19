/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.movement.HoleSnap;
import dev.recollect.hana.mod.modules.impl.movement.TickShift;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.text.DecimalFormat;
import java.util.Objects;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;

public class TimerDash
extends Module {
    private final BooleanSetting indicator;
    long lastMs;
    private final FadeUtils end;
    private final SliderSetting accumulate;
    private final BooleanSetting smooth;
    private final SliderSetting multiplier;
    private final Timer timer2;
    public static TimerDash INSTANCE;
    private final Timer timer;
    boolean moving;

    @Override
    public void onEnable() {
        Hana.TIMER.reset();
    }

    public TimerDash() {
        TimerDash a;
        TimerDash timerDash = a;
        TimerDash timerDash2 = a;
        TimerDash timerDash3 = a;
        super(ProjectionUtils.ALLATORIxDEMO("$i+@\u0011s\u0010_\u0002"), Module.Category.Movement);
        TimerDash timerDash4 = a;
        timerDash4.multiplier = timerDash3.add(new SliderSetting(NCPRaytracer.ALLATORIxDEMO("vhRfH"), 2.0, 1.0, 10.0, 0.10000000149011612));
        timerDash3.accumulate = timerDash3.add(new SliderSetting(ProjectionUtils.ALLATORIxDEMO("w\u0013c3H\u0016[\u0010X\u000f"), 2000.0, 1.0, 10000.0, 50.0));
        timerDash3.smooth = timerDash3.add(new BooleanSetting(NCPRaytracer.ALLATORIxDEMO("YHwXwD"), true));
        timerDash3.indicator = timerDash3.add(new BooleanSetting(ProjectionUtils.ALLATORIxDEMO("9n\"L\u0000V\u0005C\u0018"), true));
        timerDash3.timer = new Timer();
        timerDash3.timer2 = new Timer();
        timerDash2.end = new FadeUtils(500L);
        timerDash2.lastMs = 0L;
        timerDash.moving = false;
        timerDash.setChinese(NCPRaytracer.ALLATORIxDEMO("\u53d8\u9015\u564d\u84dc\u52ac\u663d\u7916"));
        INSTANCE = timerDash;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender2D(class_332 class_3322, float f) {
        TimerDash timerDash;
        TimerDash a;
        double d;
        block8 : {
            block9 : {
                block5 : {
                    block6 : {
                        block7 : {
                            float a2 = f;
                            a = this;
                            a.timer.setMs(Math.min(Math.max(0L, a.timer.getPassedTimeMs()), (long)a.accumulate.getValueInt()));
                            if (!MovementUtil.isMoving() && !HoleSnap.INSTANCE.isOn() || EntityUtil.isInsideBlock()) break block5;
                            if (!a.moving) {
                                a.timer2.reset();
                                a.lastMs = a.timer.getPassedTimeMs();
                                a.moving = true;
                            }
                            TimerDash timerDash2 = a;
                            timerDash2.timer.reset();
                            if (!timerDash2.timer2.passed(a.lastMs)) break block6;
                            if (!HoleSnap.INSTANCE.isOn()) break block7;
                            Hana.TIMER.set(HoleSnap.INSTANCE.timer.getValueFloat());
                            timerDash = a;
                            break block8;
                        }
                        if (TickShift.INSTANCE.isOn()) break block9;
                        Hana.TIMER.reset();
                        timerDash = a;
                        break block8;
                    }
                    if (a.smooth.getValue()) {
                        d = 1.0 + (1.0 - a.end.easeOutQuad()) * (double)(a.multiplier.getValueFloat() - 1.0f) * ((double)a.lastMs / a.accumulate.getValue());
                        Hana.TIMER.set((float)Math.max(1.0, d));
                        timerDash = a;
                    } else {
                        Hana.TIMER.set(a.multiplier.getValueFloat());
                        timerDash = a;
                    }
                    break block8;
                }
                if (a.moving) {
                    Hana.TIMER.reset();
                    a.timer.setMs(Math.max(a.lastMs - a.timer2.getPassedTimeMs(), 0L));
                    a.moving = false;
                }
                TimerDash timerDash3 = a;
                timerDash3.end.setLength(timerDash3.timer.getPassedTimeMs());
                timerDash3.end.reset();
            }
            timerDash = a;
        }
        if (timerDash.indicator.getValue()) {
            void a3;
            String a2;
            TimerDash timerDash4 = a;
            d = a.moving ? Math.max(timerDash4.lastMs - a.timer2.getPassedTimeMs(), 0L) : timerDash4.timer.getPassedTimeMs();
            double d2 = a.accumulate.getValue();
            String string = a2 = new DecimalFormat(ProjectionUtils.ALLATORIxDEMO("A\u0002Z")).format(d / d2 * 100.0) + "%";
            Objects.requireNonNull(TimerDash.mc.field_1772);
            a3.method_51433(TimerDash.mc.field_1772, string, mc.method_22683().method_4486() / 2 - TimerDash.mc.field_1772.method_1727(string) / 2, mc.method_22683().method_4502() / 2 + 9, -1, true);
        }
    }

    @EventHandler
    public final void RotateEvent(RotateEvent rotateEvent) {
        RotateEvent a = rotateEvent;
        TimerDash a2 = this;
        Object object = a;
        ((RotateEvent)object).setRotation(a.getYaw() + TimerDash.nextFloat(1.0f, 3.0f), ((RotateEvent)object).getPitch() + TimerDash.nextFloat(1.0f, 3.0f));
    }

    @Override
    public void onDisable() {
        Hana.TIMER.reset();
    }

    public static float nextFloat(float f, float f2) {
        float a = f;
        float a2 = f2;
        if (a == a2 || a2 - a <= 0.0f) {
            return a;
        }
        return (float)((double)a + (double)(a2 - a) * Math.random());
    }
}
