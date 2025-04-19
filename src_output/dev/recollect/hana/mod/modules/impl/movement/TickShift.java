/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_2596
 *  net.minecraft.class_2708
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_2828$class_2830
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 */
package dev.recollect.hana.mod.modules.impl.movement;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.managers.TimerManager;
import dev.recollect.hana.api.utils.GaussianKernel;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Beta;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.function.Predicate;
import net.minecraft.class_1041;
import net.minecraft.class_2596;
import net.minecraft.class_2708;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;

@Beta
public class TickShift
extends Module {
    private final BooleanSetting indicator;
    private final SliderSetting accumulate;
    private final ColorSetting charging;
    boolean moving;
    private final EnumSetting<FadeUtils.Quad> quad;
    private final SliderSetting yOffset;
    private int normalLookPos;
    static DecimalFormat df = new DecimalFormat(GaussianKernel.ALLATORIxDEMO("ygk"));
    private int normalPos;
    private final BooleanSetting reset;
    private final SliderSetting minAccumulate;
    private final ColorSetting work;
    private final FadeUtils end;
    long lastMs;
    private final Timer timer;
    private int rotationMode;
    private final SliderSetting multiplier;
    private final Timer timer2;
    public static TickShift INSTANCE;
    private final BooleanSetting smooth;

    /*
     * WARNING - void declaration
     */
    @Override
    public void onRender2D(class_332 class_3322, float f) {
        TickShift tickShift;
        double d;
        float a4 = f;
        TickShift a2 = this;
        a2.timer.setMs(Math.min(Math.max(0L, a2.timer.getPassedTimeMs()), (long)a2.accumulate.getValueInt()));
        if (MovementUtil.isMoving() && !EntityUtil.isInsideBlock()) {
            if (!a2.moving) {
                TickShift tickShift2;
                TickShift tickShift3 = a2;
                if (tickShift3.timer.passedMs(tickShift3.minAccumulate.getValue())) {
                    TickShift tickShift4 = a2;
                    a2.timer2.reset();
                    tickShift2 = tickShift4;
                    tickShift4.lastMs = tickShift4.timer.getPassedTimeMs();
                } else {
                    tickShift2 = a2;
                    a2.lastMs = 0L;
                }
                tickShift2.moving = true;
            }
            TickShift tickShift5 = a2;
            tickShift5.timer.reset();
            if (tickShift5.timer2.passed(a2.lastMs)) {
                Hana.TIMER.reset();
                tickShift = a2;
            } else if (a2.smooth.getValue()) {
                TickShift tickShift6 = a2;
                d = (double)Hana.TIMER.getDefault() + (1.0 - tickShift6.end.getQuad(tickShift6.quad.getValue())) * (double)(a2.multiplier.getValueFloat() - 1.0f) * ((double)a2.lastMs / a2.accumulate.getValue());
                Hana.TIMER.set((float)Math.max((double)Hana.TIMER.getDefault(), d));
                tickShift = a2;
            } else {
                Hana.TIMER.set(a2.multiplier.getValueFloat());
                tickShift = a2;
            }
        } else {
            if (a2.moving) {
                TickShift tickShift7;
                Hana.TIMER.reset();
                TickShift tickShift8 = a2;
                if (a2.reset.getValue()) {
                    tickShift8.timer.reset();
                    tickShift7 = a2;
                } else {
                    tickShift8.timer.setMs(Math.max(a2.lastMs - a2.timer2.getPassedTimeMs(), 0L));
                    tickShift7 = a2;
                }
                tickShift7.moving = false;
            }
            TickShift tickShift9 = a2;
            tickShift = tickShift9;
            TickShift tickShift10 = a2;
            tickShift9.end.setLength(tickShift10.timer.getPassedTimeMs());
            tickShift10.end.reset();
        }
        if (tickShift.indicator.getValue()) {
            void a3;
            String string;
            TickShift tickShift11 = a2;
            d = a2.moving ? Math.max(tickShift11.lastMs - a2.timer2.getPassedTimeMs(), 0L) : tickShift11.timer.getPassedTimeMs();
            boolean a4 = a2.moving && d > 0.0 || d >= (double)a2.minAccumulate.getValueInt();
            double d2 = a2.accumulate.getValue();
            String string2 = string = df.format(d / d2 * 100.0) + "%";
            Objects.requireNonNull(TickShift.mc.field_1772);
            TickShift tickShift12 = a2;
            a3.method_51433(TickShift.mc.field_1772, string2, mc.method_22683().method_4486() / 2 - TickShift.mc.field_1772.method_1727(string2) / 2, mc.method_22683().method_4502() / 2 + 9 - a2.yOffset.getValueInt(), a4 ? tickShift12.work.getValue().getRGB() : tickShift12.charging.getValue().getRGB(), true);
        }
    }

    @EventHandler
    public final void RotateEvent(RotateEvent rotateEvent) {
        RotateEvent a = rotateEvent;
        TickShift a2 = this;
        if (a2.rotationMode == 2) {
            Object object = a;
            ((RotateEvent)object).setRotation(a.getYaw() + TickShift.nextFloat(1.0f, 3.0f), ((RotateEvent)object).getPitch() + TickShift.nextFloat(1.0f, 3.0f));
        }
    }

    @Override
    public void onEnable() {
        Hana.TIMER.reset();
    }

    @Override
    public String getInfo() {
        TickShift a;
        double d = a.moving ? Math.max(a.lastMs - a.timer2.getPassedTimeMs(), 0L) : a.timer.getPassedTimeMs();
        double d2 = a.accumulate.getValue();
        d = Math.min(d / d2 * 100.0, 100.0);
        return df.format(d) + "%";
    }

    @EventHandler
    public void onReceivePacket(PacketEvent.Receive receive) {
        PacketEvent.Receive a = receive;
        TickShift a2 = this;
        if (a.getPacket() instanceof class_2708) {
            a2.lastMs = 0L;
        }
    }

    @EventHandler
    public final void onPacketSend(PacketEvent.Send send) {
        PacketEvent.Send a = send;
        TickShift a2 = this;
        if (TickShift.nullCheck()) {
            return;
        }
        if (a.getPacket() instanceof class_2828.class_2829 && a2.rotationMode == 1) {
            TickShift tickShift = a2;
            ++tickShift.normalPos;
            if (tickShift.normalPos > 20) {
                a2.rotationMode = 2;
                return;
            }
        } else if (a.getPacket() instanceof class_2828.class_2830 && a2.rotationMode == 2) {
            TickShift tickShift = a2;
            ++tickShift.normalLookPos;
            if (tickShift.normalLookPos > 20) {
                a2.rotationMode = 1;
            }
        }
    }

    @Override
    public void onDisable() {
        Hana.TIMER.reset();
    }

    public TickShift() {
        TickShift a;
        TickShift tickShift = a;
        super(GaussianKernel.ALLATORIxDEMO("(<$?\u00153 //"), Module.Category.Movement);
        TickShift tickShift2 = a;
        tickShift2.multiplier = tickShift.add(new SliderSetting(CameraState.ALLATORIxDEMO("D&Q8j*S-@"), 2.0, 1.0, 10.0, 0.1));
        tickShift.accumulate = tickShift.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u0017.:;.>"), 2000.0, 1.0, 10000.0, 50.0).setSuffix(CameraState.ALLATORIxDEMO("%W")));
        tickShift.minAccumulate = tickShift.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("1<)\u0017.:;.>"), 500.0, 1.0, 10000.0, 50.0).setSuffix(CameraState.ALLATORIxDEMO("%W")));
        tickShift.smooth = tickShift.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u0007+4&=3"), true).setParent());
        tickShift.quad = tickShift.add(new EnumSetting<FadeUtils.Quad>(CameraState.ALLATORIxDEMO("\u000bC)@"), FadeUtils.Quad.In, object -> {
            Object a = object;
            TickShift a2 = this;
            return a2.smooth.isOpen();
        }));
        TickShift tickShift3 = a;
        tickShift3.reset = tickShift3.add(new BooleanSetting(GaussianKernel.ALLATORIxDEMO("\u0014>:,/"), true));
        tickShift3.indicator = tickShift3.add(new BooleanSetting(CameraState.ALLATORIxDEMO("J:\\<Z;B'V"), true).setParent());
        tickShift3.work = tickShift3.add(new ColorSetting(GaussianKernel.ALLATORIxDEMO("?:*$*>=,?"), new Color(0, 255, 0), object -> {
            Object a = object;
            TickShift a2 = this;
            return a2.indicator.isOpen();
        }));
        a.charging = a.add(new ColorSetting(CameraState.ALLATORIxDEMO("\u0017P4K=_&C"), new Color(255, 0, 0), object -> {
            Object a = object;
            TickShift a2 = this;
            return a2.indicator.isOpen();
        }));
        a.yOffset = a.add(new SliderSetting(GaussianKernel.ALLATORIxDEMO("\u001e\u001b =:,/"), 0.0, -200.0, 200.0, 1.0, object -> {
            Object a = object;
            TickShift a2 = this;
            return a2.indicator.isOpen();
        }));
        TickShift tickShift4 = a;
        TickShift tickShift5 = a;
        TickShift tickShift6 = a;
        tickShift6.timer = new Timer();
        tickShift6.timer2 = new Timer();
        tickShift5.end = new FadeUtils(500L);
        tickShift5.lastMs = 0L;
        tickShift4.moving = false;
        tickShift4.setChinese(CameraState.ALLATORIxDEMO("\u849e\u52ad\u5390\u903b"));
        INSTANCE = tickShift4;
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
