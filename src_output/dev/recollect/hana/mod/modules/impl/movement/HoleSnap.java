/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_2338
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
package dev.recollect.hana.mod.modules.impl.movement;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.MoveEvent;
import dev.recollect.hana.api.events.impl.PacketEvent;
import dev.recollect.hana.api.events.impl.TimerEvent;
import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.combat.CombatUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.path.Vec3;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.api.utils.world.BlockUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.movement.dev.NewStep;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.function.Predicate;
import net.minecraft.class_2338;
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

public class HoleSnap
extends Module {
    private int stuckTicks;
    private class_2338 holePos;
    private final SliderSetting timeoutTicks;
    public static HoleSnap INSTANCE;
    class_243 targetPos;
    public final SliderSetting segments;
    public final ColorSetting color;
    public final SliderSetting circleSize;
    private final SliderSetting range;
    public final BooleanSetting fade;
    public final BooleanSetting enableStep;
    public final SliderSetting timer;
    public final BooleanSetting any;
    boolean resetMove;
    public final BooleanSetting render;
    private int enabledTicks;

    public static class_241 getRotationTo(class_243 class_2432, class_243 class_2433) {
        class_243 a = class_2433;
        class_243 a2 = class_2432;
        return HoleSnap.getRotationFromVec(a.method_1020(a2));
    }

    /*
     * WARNING - void declaration
     */
    public static void doCircle(class_4587 class_45872, Color color, double d, class_243 class_2432, int n) {
        double d2;
        Object a = color;
        class_4587 a2 = class_45872;
        class_243 class_2433 = HoleSnap.mc.method_31975().field_4344.method_19326();
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

    @EventHandler(priority=-99)
    public void onTimer(TimerEvent timerEvent) {
        TimerEvent a = timerEvent;
        HoleSnap a2 = this;
        a.set(a2.timer.getValueFloat());
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

    @EventHandler
    public void onMove(MoveEvent a) {
        HoleSnap a22;
        HoleSnap holeSnap;
        HoleSnap holeSnap2 = holeSnap = a22;
        ++holeSnap2.enabledTicks;
        if ((double)holeSnap2.enabledTicks > holeSnap.timeoutTicks.getValue() - 1.0) {
            holeSnap.disable();
            return;
        }
        if (!HoleSnap.mc.field_1724.method_5805() || HoleSnap.mc.field_1724.method_6128()) {
            holeSnap.disable();
            return;
        }
        if (holeSnap.stuckTicks > 8) {
            holeSnap.disable();
            return;
        }
        if (holeSnap.holePos == null) {
            CommandManager.sendChatMessageWidthId(Setting.ALLATORIxDEMO("\u00a5$FA\u0098\u001aU1h\"dk"), holeSnap.hashCode());
            holeSnap.disable();
            return;
        }
        class_243 class_2432 = HoleSnap.mc.field_1724.method_19538();
        holeSnap.targetPos = new class_243((double)holeSnap.holePos.method_10263() + 0.5, HoleSnap.mc.field_1724.method_23318(), (double)holeSnap.holePos.method_10260() + 0.5);
        if (CombatUtil.isDoubleHole(holeSnap.holePos) && (a22 = CombatUtil.is3Block(holeSnap.holePos)) != null) {
            holeSnap.targetPos = holeSnap.targetPos.method_1019(new class_243((double)a22.method_10163().method_10263() * 0.5, (double)a22.method_10163().method_10264() * 0.5, (double)a22.method_10163().method_10260() * 0.5));
        }
        holeSnap.resetMove = true;
        class_243 class_2433 = class_2432;
        HoleSnap holeSnap3 = holeSnap;
        float a22 = HoleSnap.getRotationTo((class_243)class_2433, (class_243)holeSnap3.targetPos).field_1343;
        a22 = a22 / 180.0f * 3.1415927f;
        double d = class_2433.method_1022(holeSnap3.targetPos);
        d = Math.min(0.2873, d);
        double d2 = (double)(-((float)Math.sin(a22))) * d;
        d = (double)((float)Math.cos(a22)) * d;
        MoveEvent moveEvent = a;
        moveEvent.setX(d2);
        moveEvent.setZ(d);
        if (Math.abs(d2) < 0.1 && Math.abs(d) < 0.1 && class_2432.field_1351 <= (double)holeSnap.holePos.method_10264() + 0.5) {
            holeSnap.disable();
        }
        if (HoleSnap.mc.field_1724.field_5976) {
            ++holeSnap.stuckTicks;
            return;
        }
        holeSnap.stuckTicks = 0;
    }

    private static /* synthetic */ class_241 getRotationFromVec(class_243 a) {
        class_243 class_2432 = a;
        double d = class_2432.field_1352;
        double d2 = class_2432.field_1350;
        d = Math.hypot(d, d2);
        d2 = class_2432.field_1350;
        double d3 = class_2432.field_1352;
        d2 = HoleSnap.normalizeAngle(Math.toDegrees(Math.atan2(d2, d3)) - 90.0);
        d = HoleSnap.normalizeAngle(Math.toDegrees(-Math.atan2(class_2432.field_1351, d)));
        return new class_241((float)d2, (float)d);
    }

    public HoleSnap() {
        HoleSnap a;
        HoleSnap holeSnap = a;
        super(Vec3.ALLATORIxDEMO("f+\u001cO\u0018l\u0017"), Setting.ALLATORIxDEMO("T0w=U+-"), Module.Category.Movement);
        HoleSnap holeSnap2 = a;
        holeSnap2.any = holeSnap.add(new BooleanSetting(Vec3.ALLATORIxDEMO("\u0005}\u0000T\u0019a\u0002"), true));
        holeSnap.range = holeSnap.add(new SliderSetting(Setting.ALLATORIxDEMO("\ng++j"), 5, 1, 50));
        holeSnap.timeoutTicks = holeSnap.add(new SliderSetting(Vec3.ALLATORIxDEMO("\u0010z\u0014y9x\u0013"), 40, 0, 100));
        holeSnap.timer = holeSnap.add(new SliderSetting(Setting.ALLATORIxDEMO("\fo()}"), 1.0, 0.1, 8.0, 0.1));
        holeSnap.render = holeSnap.add(new BooleanSetting(Vec3.ALLATORIxDEMO("A\u001cr\u0012h\u0015"), true)).setParent();
        holeSnap.enableStep = holeSnap.add(new BooleanSetting(Setting.ALLATORIxDEMO("\u0004 ly4y\u0011~/U1)"), true));
        holeSnap.color = holeSnap.add(new ColorSetting(Vec3.ALLATORIxDEMO(":s\u001ab\u0015"), new Color(255, 255, 255, 100), object -> {
            Object a = object;
            HoleSnap a2 = this;
            return a2.render.isOpen();
        }));
        a.circleSize = a.add(new SliderSetting(Setting.ALLATORIxDEMO("X1n<w=U,6j"), 1.0, 0.10000000149011612, 2.5, object -> {
            Object a = object;
            HoleSnap a2 = this;
            return a2.render.isOpen();
        }));
        a.fade = a.add(new BooleanSetting(Vec3.ALLATORIxDEMO("Z\u0017i\u0002"), true, object -> {
            Object a = object;
            HoleSnap a2 = this;
            return a2.render.isOpen();
        }));
        a.segments = a.add(new SliderSetting(Setting.ALLATORIxDEMO("O:|5c+8|"), 180, 0, 360, object -> {
            Object a = object;
            HoleSnap a2 = this;
            return a2.render.isOpen();
        }));
        HoleSnap holeSnap3 = a;
        holeSnap3.resetMove = false;
        holeSnap3.setChinese(Vec3.ALLATORIxDEMO("\u81f6\u52de\u62c4\u5736"));
        INSTANCE = holeSnap3;
    }

    @Override
    public void onUpdate() {
        HoleSnap a;
        if (a.holePos == null) {
            return;
        }
        if (!BlockUtil.isHole(a.holePos) && !CombatUtil.isDoubleHole(a.holePos)) {
            a.holePos = CombatUtil.getHole((float)a.range.getValue(), true, a.any.getValue());
        }
    }

    @Override
    public void onDisable() {
        HoleSnap a;
        HoleSnap holeSnap = a;
        a.holePos = null;
        holeSnap.stuckTicks = 0;
        holeSnap.enabledTicks = 0;
        if (HoleSnap.nullCheck()) {
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

    @Override
    public void onEnable() {
        HoleSnap a;
        if (HoleSnap.nullCheck()) {
            a.disable();
            return;
        }
        if (a.enableStep.getValue()) {
            NewStep.INSTANCE.enable();
        }
        a.resetMove = false;
        a.holePos = CombatUtil.getHole((float)a.range.getValue(), true, a.any.getValue());
    }

    @Override
    public void onRender3D(class_4587 a, float a22) {
        HoleSnap a3;
        HoleSnap holeSnap = a3;
        if (holeSnap.targetPos == null || holeSnap.holePos == null) {
            return;
        }
        if (!holeSnap.render.getValue()) {
            return;
        }
        GL11.glEnable((int)3042);
        Color a22 = holeSnap.color.getValue();
        HoleSnap holeSnap2 = holeSnap;
        a3 = new class_243(holeSnap2.targetPos.field_1352, (double)holeSnap.holePos.method_10264(), holeSnap.targetPos.method_10215());
        if (holeSnap2.fade.getValue()) {
            double d;
            double d2 = 0.01;
            double d3 = d = 0.0;
            while (d3 < holeSnap.circleSize.getValue()) {
                Color color = a22;
                double d4 = d;
                HoleSnap.doCircle(a, ColorUtil.injectAlpha(color, (int)Math.min((double)(color.getAlpha() * 2) / (holeSnap.circleSize.getValue() / d2), 255.0)), d4, (class_243)a3, holeSnap.segments.getValueInt());
                d3 = d4 + d2;
            }
        } else {
            HoleSnap.doCircle(a, a22, holeSnap.circleSize.getValue(), (class_243)a3, holeSnap.segments.getValueInt());
        }
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)3042);
    }

    @EventHandler
    public void onReceivePacket(PacketEvent.Receive receive) {
        PacketEvent.Receive a = receive;
        HoleSnap a2 = this;
        if (a.getPacket() instanceof class_2708) {
            a2.disable();
        }
    }
}
