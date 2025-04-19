/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_241
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2708
 *  net.minecraft.class_287
 *  net.minecraft.class_289
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_746
 *  net.minecraft.class_757
 *  net.minecraft.class_824
 *  org.joml.Matrix4f
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.mod.modules.impl.movement.dev;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.TimerEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.dev.BlockUpUtil;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.movement.dev.NewStep;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.function.Predicate;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_241;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2708;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_746;
import net.minecraft.class_757;
import net.minecraft.class_824;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

public class HoleSnapPlus
extends Module {
    private int stuckTicks;
    public final BooleanSetting any;
    private final SliderSetting range;
    private final SliderSetting timeoutTicks;
    public static HoleSnapPlus INSTANCE;
    public final SliderSetting circleSize;
    public final BooleanSetting fade;
    public final ColorSetting color;
    private boolean resetMove;
    private int enabledTicks;
    public final SliderSetting timer;
    public final SliderSetting segments;
    private class_243 targetPos;
    private class_2338 holePos;
    public final BooleanSetting render;
    public final BooleanSetting enableStep;

    @EventHandler(priority=-99)
    public void onTimer(TimerEvent timerEvent) {
        TimerEvent a = timerEvent;
        HoleSnapPlus a2 = this;
        a.set(a2.timer.getValueFloat());
    }

    @Override
    public void onUpdate() {
        HoleSnapPlus a;
        if (a.holePos == null) {
            return;
        }
        if (HoleUtils.getHole(a.holePos, 3, true).getType() != Hole.HoleType.NotHole) {
            HoleSnapPlus holeSnapPlus = a;
            holeSnapPlus.holePos = holeSnapPlus.findClosestHole(holeSnapPlus.range.getValueInt());
        }
    }

    @Override
    public void onDisable() {
        HoleSnapPlus a;
        HoleSnapPlus holeSnapPlus = a;
        a.holePos = null;
        holeSnapPlus.stuckTicks = 0;
        holeSnapPlus.enabledTicks = 0;
        if (HoleSnapPlus.nullCheck()) {
            return;
        }
        if (a.enableStep.getValue()) {
            NewStep.INSTANCE.disable();
        }
        if (a.resetMove) {
            MovementUtil.setMotionX(0.0);
            MovementUtil.setMotionZ(0.0);
        }
    }

    private /* synthetic */ class_2338 findClosestHole(int n) {
        int n2;
        int a = n;
        HoleSnapPlus a2 = this;
        class_2338 class_23382 = HoleSnapPlus.mc.field_1724.method_24515();
        class_2338 class_23383 = null;
        double d = Double.MAX_VALUE;
        int n3 = n2 = -a;
        while (n3 <= a) {
            int n4 = -a;
            while (n4 <= a) {
                int n5;
                int n6 = -a;
                while (n6 <= a) {
                    int n7;
                    class_2338 class_23384 = class_23382.method_10069(n2, n5, n7);
                    if (HoleUtils.getHole(class_23384, true, true, true, 3, true).getType() != Hole.HoleType.NotHole) {
                        double d2;
                        double d3 = class_23382.method_40081((double)class_23384.method_10263(), (double)class_23384.method_10264(), (double)class_23384.method_10260());
                        if (d2 < d) {
                            d = d3;
                            class_23383 = class_23384;
                        }
                    }
                    n6 = ++n7;
                }
                n4 = ++n5;
            }
            n3 = ++n2;
        }
        return class_23383;
    }

    private static /* synthetic */ class_241 getRotationFromVec(class_243 a) {
        class_243 class_2432 = a;
        double d = class_2432.field_1352;
        double d2 = class_2432.field_1350;
        d = Math.hypot(d, d2);
        d2 = class_2432.field_1350;
        double d3 = class_2432.field_1352;
        d2 = HoleSnapPlus.normalizeAngle(Math.toDegrees(Math.atan2(d2, d3)) - 90.0);
        d = HoleSnapPlus.normalizeAngle(Math.toDegrees(-Math.atan2(class_2432.field_1351, d)));
        return new class_241((float)d2, (float)d);
    }

    @Override
    public void onEnable() {
        HoleSnapPlus a;
        if (HoleSnapPlus.nullCheck()) {
            a.disable();
            return;
        }
        if (a.enableStep.getValue()) {
            NewStep.INSTANCE.enable();
        }
        HoleSnapPlus holeSnapPlus = a;
        holeSnapPlus.resetMove = false;
        holeSnapPlus.holePos = holeSnapPlus.findClosestHole(holeSnapPlus.range.getValueInt());
    }

    @Override
    public void onRender3D(class_4587 a, float a22) {
        HoleSnapPlus a3;
        HoleSnapPlus holeSnapPlus = a3;
        if (holeSnapPlus.targetPos == null || holeSnapPlus.holePos == null) {
            return;
        }
        if (!holeSnapPlus.render.getValue()) {
            return;
        }
        GL11.glEnable((int)3042);
        Color a22 = holeSnapPlus.color.getValue();
        HoleSnapPlus holeSnapPlus2 = holeSnapPlus;
        a3 = new class_243(holeSnapPlus2.targetPos.field_1352, (double)holeSnapPlus.holePos.method_10264(), holeSnapPlus.targetPos.field_1350);
        if (holeSnapPlus2.fade.getValue()) {
            double d;
            double d2 = 0.01;
            double d3 = d = 0.0;
            while (d3 < holeSnapPlus.circleSize.getValue()) {
                Color color = a22;
                double d4 = d;
                HoleSnapPlus.doCircle(a, ColorUtil.injectAlpha(color, (int)Math.min((double)(color.getAlpha() * 2) / (holeSnapPlus.circleSize.getValue() / d2), 255.0)), d4, (class_243)a3, holeSnapPlus.segments.getValueInt());
                d3 = d4 + d2;
            }
        } else {
            HoleSnapPlus.doCircle(a, a22, holeSnapPlus.circleSize.getValue(), (class_243)a3, holeSnapPlus.segments.getValueInt());
        }
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)3042);
    }

    /*
     * WARNING - void declaration
     */
    public static void doCircle(class_4587 class_45872, Color color, double d, class_243 class_2432, int n) {
        double d2;
        Object a = color;
        class_4587 a2 = class_45872;
        class_243 class_2433 = HoleSnapPlus.mc.method_31975().field_4344.method_19326();
        GL11.glDisable((int)2929);
        Matrix4f matrix4f = a2.method_23760().method_23761();
        class_289 class_2892 = RenderSystem.renderThreadTesselator();
        class_287 class_2872 = class_2892.method_1349();
        RenderSystem.setShaderColor((float)((float)((Color)a).getRed() / 255.0f), (float)((float)((Color)a).getGreen() / 255.0f), (float)((float)((Color)a).getBlue() / 255.0f), (float)((float)((Color)a).getAlpha() / 255.0f));
        RenderSystem.setShader(class_757::method_34539);
        class_2872.method_1328(class_293.class_5596.field_27381, class_290.field_1592);
        double d3 = d2 = 0.0;
        while (d3 < 360.0) {
            void a3;
            void a4;
            void a5;
            double d4 = Math.sin(Math.toRadians(d2)) * a3;
            double d5 = Math.cos(Math.toRadians(d2)) * a3;
            a = new class_243(a4.field_1352 + d4, a4.field_1351, a4.field_1350 + d5).method_1031(-class_2433.field_1352, -class_2433.field_1351, -class_2433.field_1350);
            class_2872.method_22918(matrix4f, (float)((class_243)a).field_1352, (float)((class_243)a).field_1351, (float)((class_243)a).field_1350).method_1344();
            d3 = d2 + 360.0 / (double)a5;
        }
        class_2892.method_1350();
        GL11.glEnable((int)2929);
    }

    private static /* synthetic */ double normalizeAngle(double a) {
        double d;
        double d2 = a;
        d2 %= 360.0;
        if (d >= 180.0) {
            d2 -= 360.0;
        }
        if (d2 < -180.0) {
            d2 += 360.0;
        }
        return d2;
    }

    public HoleSnapPlus() {
        HoleSnapPlus a;
        HoleSnapPlus holeSnapPlus = a;
        super(BlockUpUtil.ALLATORIxDEMO("RMq@IVf\u0002f"), Hole.ALLATORIxDEMO("c=\u0012b*n\u001fw3v\\#"), Module.Category.Movement);
        HoleSnapPlus holeSnapPlus2 = a;
        holeSnapPlus2.any = holeSnapPlus.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("\\Kcph\u001e("), true));
        holeSnapPlus.range = holeSnapPlus.add(new SliderSetting(Hole.ALLATORIxDEMO("U\u0002tN5"), 5, 1, 50));
        holeSnapPlus.timeoutTicks = holeSnapPlus.add(new SliderSetting(BlockUpUtil.ALLATORIxDEMO("ILw]H\u00079"), 40, 0, 100));
        holeSnapPlus.timer = holeSnapPlus.add(new SliderSetting(Hole.ALLATORIxDEMO("S\nwL\""), 1.0, 0.1, 8.0, 0.1));
        holeSnapPlus.render = holeSnapPlus.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("wVc\u0017?"), true)).setParent();
        holeSnapPlus.enableStep = holeSnapPlus.add(new BooleanSetting(Hole.ALLATORIxDEMO("XE3\u001ck\u001cN\u001bp0nL "), true));
        holeSnapPlus.color = holeSnapPlus.add(new ColorSetting(BlockUpUtil.ALLATORIxDEMO("YWk\u001d?"), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            HoleSnapPlus a2 = this;
            return a2.render.isOpen();
        }));
        a.circleSize = a.add(new SliderSetting(Hole.ALLATORIxDEMO("=n\u000bc\u0012b0sS5"), 1.0, 0.10000000149011612, 2.5, object -> {
            Object a = object;
            HoleSnapPlus a2 = this;
            return a2.render.isOpen();
        }));
        a.fade = a.add(new BooleanSetting(BlockUpUtil.ALLATORIxDEMO("~f\u0016("), true, object -> {
            Object a = object;
            HoleSnapPlus a2 = this;
            return a2.render.isOpen();
        }));
        a.segments = a.add(new SliderSetting(Hole.ALLATORIxDEMO("*e\u0019j\u0006t]#"), 180, 0, 360, object -> {
            Object a = object;
            HoleSnapPlus a2 = this;
            return a2.render.isOpen();
        }));
        HoleSnapPlus holeSnapPlus3 = a;
        holeSnapPlus3.resetMove = false;
        holeSnapPlus3.setChinese(BlockUpUtil.ALLATORIxDEMO("\u5f6f\u6618\u62bb\u571c"));
        INSTANCE = holeSnapPlus3;
    }

    public static class_241 getRotationTo(class_243 class_2432, class_243 class_2433) {
        class_243 a = class_2433;
        class_243 a2 = class_2432;
        return HoleSnapPlus.getRotationFromVec(a.method_1020(a2));
    }

    @EventHandler
    public void onMove(MoveEvent a) {
        Hole a22;
        HoleSnapPlus holeSnapPlus;
        HoleSnapPlus holeSnapPlus2 = holeSnapPlus = a22;
        ++holeSnapPlus2.enabledTicks;
        if ((double)holeSnapPlus2.enabledTicks > holeSnapPlus.timeoutTicks.getValue() - 1.0) {
            holeSnapPlus.disable();
            return;
        }
        if (!HoleSnapPlus.mc.field_1724.method_5805() || HoleSnapPlus.mc.field_1724.method_6128()) {
            holeSnapPlus.disable();
            return;
        }
        if (holeSnapPlus.stuckTicks > 8) {
            holeSnapPlus.disable();
            return;
        }
        if (holeSnapPlus.holePos == null) {
            CommandManager.sendChatMessageWidthId(Hole.ALLATORIxDEMO("\u00c3x# $ \u00fdE0n\r}\u00014"), holeSnapPlus.hashCode());
            holeSnapPlus.disable();
            return;
        }
        class_243 class_2432 = HoleSnapPlus.mc.field_1724.method_19538();
        holeSnapPlus.targetPos = new class_243((double)holeSnapPlus.holePos.method_10263() + 0.5, HoleSnapPlus.mc.field_1724.method_23318(), (double)holeSnapPlus.holePos.method_10260() + 0.5);
        a22 = HoleUtils.getHole(holeSnapPlus.holePos, true, true, true, 3, true);
        if (a22.getType() == Hole.HoleType.DoubleX || a22.getType() == Hole.HoleType.DoubleZ) {
            class_2350 class_23502 = a22.getType() == Hole.HoleType.DoubleX ? class_2350.field_11034 : class_2350.field_11035;
            holeSnapPlus.targetPos = holeSnapPlus.targetPos.method_1019(new class_243((double)class_23502.method_10163().method_10263() * 0.5, (double)class_23502.method_10163().method_10264() * 0.5, (double)class_23502.method_10163().method_10260() * 0.5));
        }
        holeSnapPlus.resetMove = true;
        class_243 class_2433 = class_2432;
        HoleSnapPlus holeSnapPlus3 = holeSnapPlus;
        float f = HoleSnapPlus.getRotationTo((class_243)class_2433, (class_243)holeSnapPlus3.targetPos).field_1343;
        float a22 = f / 180.0f * 3.1415927f;
        double d = class_2433.method_1022(holeSnapPlus3.targetPos);
        d = Math.min(0.2873, d);
        double d2 = (double)(-((float)Math.sin(a22))) * d;
        d = (double)((float)Math.cos(a22)) * d;
        MoveEvent moveEvent = a;
        moveEvent.setX(d2);
        moveEvent.setZ(d);
        if (Math.abs(d2) < 0.1 && Math.abs(d) < 0.1 && class_2432.field_1351 <= (double)holeSnapPlus.holePos.method_10264() + 0.5) {
            holeSnapPlus.disable();
        }
        if (HoleSnapPlus.mc.field_1724.field_5976) {
            ++holeSnapPlus.stuckTicks;
            return;
        }
        holeSnapPlus.stuckTicks = 0;
    }

    @EventHandler
    public void onReceivePacket(PacketEvent.Receive receive) {
        PacketEvent.Receive a = receive;
        HoleSnapPlus a2 = this;
        if (a.getPacket() instanceof class_2708) {
            a2.disable();
        }
    }
}
