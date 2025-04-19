/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_239
 *  net.minecraft.class_243
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_4050
 *  net.minecraft.class_4587
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.events.eventbus.EventHandler;
import dev.recollect.hana.api.events.impl.KeyboardInputEvent;
import dev.recollect.hana.api.events.impl.RotateEvent;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.entity.MovementUtil;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.skybox.BackgroundInfo;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_4050;
import net.minecraft.class_4587;
import net.minecraft.class_744;
import net.minecraft.class_746;

public class FreeCam
extends Module {
    private double fakeZ;
    private final SliderSetting speed;
    private double prevFakeY;
    private float prevFakeYaw;
    final BooleanSetting rotate;
    private double prevFakeZ;
    private float fakePitch;
    public static FreeCam INSTANCE;
    private float prePitch;
    private double prevFakeX;
    private float preYaw;
    private float fakeYaw;
    private float prevFakePitch;
    private double fakeY;
    private double fakeX;
    private final SliderSetting hspeed;

    public double getFakeY() {
        FreeCam a;
        return MathUtil.interpolate(a.prevFakeY, a.fakeY, mc.method_1488());
    }

    @EventHandler(priority=200)
    public void onRotate(RotateEvent rotateEvent) {
        RotateEvent a = rotateEvent;
        FreeCam a2 = this;
        Object object = a;
        ((RotateEvent)object).setYawNoModify(a2.preYaw);
        ((RotateEvent)object).setPitchNoModify(a2.prePitch);
    }

    public double getFakeZ() {
        FreeCam a;
        return MathUtil.interpolate(a.prevFakeZ, a.fakeZ, mc.method_1488());
    }

    @Override
    public void onDisable() {
        FreeCam.mc.field_1730 = true;
    }

    public float getFakePitch() {
        FreeCam a;
        return (float)MathUtil.interpolate(a.prevFakePitch, a.fakePitch, mc.method_1488());
    }

    @EventHandler
    public void onKeyboardInput(KeyboardInputEvent keyboardInputEvent) {
        double[] a = keyboardInputEvent;
        FreeCam a2 = this;
        if (FreeCam.mc.field_1724 == null) {
            return;
        }
        FreeCam freeCam = a2;
        a = MovementUtil.directionSpeed(freeCam.speed.getValue());
        freeCam.prevFakeX = freeCam.fakeX;
        freeCam.prevFakeY = freeCam.fakeY;
        freeCam.prevFakeZ = freeCam.fakeZ;
        freeCam.fakeX += a[0];
        freeCam.fakeZ += a[1];
        if (FreeCam.mc.field_1690.field_1903.method_1434()) {
            a2.fakeY += a2.hspeed.getValue();
        }
        if (FreeCam.mc.field_1690.field_1832.method_1434()) {
            a2.fakeY -= a2.hspeed.getValue();
        }
        FreeCam.mc.field_1724.field_3913.field_3905 = 0.0f;
        FreeCam.mc.field_1724.field_3913.field_3907 = 0.0f;
        FreeCam.mc.field_1724.field_3913.field_3904 = false;
        FreeCam.mc.field_1724.field_3913.field_3903 = false;
    }

    public double getFakeX() {
        FreeCam a;
        return MathUtil.interpolate(a.prevFakeX, a.fakeX, mc.method_1488());
    }

    public float getFakeYaw() {
        FreeCam a;
        return (float)MathUtil.interpolate(a.prevFakeYaw, a.fakeYaw, mc.method_1488());
    }

    public FreeCam() {
        FreeCam a;
        FreeCam freeCam = a;
        FreeCam freeCam2 = a;
        super(ColorUtil.ALLATORIxDEMO("Z/~%Ek!"), Module.Category.Render);
        FreeCam freeCam3 = a;
        freeCam3.speed = freeCam2.add(new SliderSetting(BackgroundInfo.ALLATORIxDEMO("\u0014\u001813nx"), 1.0, 0.0, 3.0));
        freeCam2.hspeed = freeCam2.add(new SliderSetting(ColorUtil.ALLATORIxDEMO("\u000bH0co("), 0.42, 0.0, 3.0));
        freeCam.rotate = freeCam2.add(new BooleanSetting(BackgroundInfo.ALLATORIxDEMO("\u000e$57y"), true));
        freeCam.setChinese(ColorUtil.ALLATORIxDEMO("\u7035\u9b44\u51f0\u7ac1"));
        INSTANCE = freeCam;
    }

    @Override
    public void onUpdate() {
        float[] a;
        float[] arrf = a;
        if (arrf.rotate.getValue() && FreeCam.mc.field_1765 != null && FreeCam.mc.field_1765.method_17784() != null) {
            a = EntityUtil.getLegitRotations(FreeCam.mc.field_1765.method_17784());
            float[] arrf2 = arrf;
            arrf2.preYaw = a[0];
            arrf2.prePitch = a[1];
        }
    }

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        FreeCam a;
        float a2 = f;
        FreeCam freeCam = a = this;
        freeCam.prevFakeYaw = freeCam.fakeYaw;
        freeCam.prevFakePitch = freeCam.fakePitch;
        freeCam.fakeYaw = FreeCam.mc.field_1724.method_36454();
        freeCam.fakePitch = FreeCam.mc.field_1724.method_36455();
    }

    @Override
    public void onEnable() {
        FreeCam a;
        if (FreeCam.nullCheck()) {
            a.disable();
            return;
        }
        FreeCam.mc.field_1730 = false;
        FreeCam freeCam = a;
        freeCam.preYaw = FreeCam.mc.field_1724.method_36454();
        freeCam.prePitch = FreeCam.mc.field_1724.method_36455();
        freeCam.fakePitch = FreeCam.mc.field_1724.method_36455();
        freeCam.fakeYaw = FreeCam.mc.field_1724.method_36454();
        freeCam.prevFakePitch = freeCam.fakePitch;
        freeCam.prevFakeYaw = freeCam.fakeYaw;
        freeCam.fakeX = FreeCam.mc.field_1724.method_23317();
        freeCam.fakeY = FreeCam.mc.field_1724.method_23318() + (double)FreeCam.mc.field_1724.method_18381(FreeCam.mc.field_1724.method_18376());
        freeCam.fakeZ = FreeCam.mc.field_1724.method_23321();
        freeCam.prevFakeX = freeCam.fakeX;
        freeCam.prevFakeY = freeCam.fakeY;
        freeCam.prevFakeZ = freeCam.fakeZ;
    }
}
