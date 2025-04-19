/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_4587
 *  net.minecraft.class_5498
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_4587;
import net.minecraft.class_5498;
import org.bytedeco.javacv.BaseChildSettings;

public class CameraClip
extends Module {
    private final BooleanSetting noFront;
    public static CameraClip INSTANCE;
    private final FadeUtils animation;
    boolean first;
    public final SliderSetting distance;
    public final SliderSetting animateTime;

    @Override
    public void onRender3D(class_4587 class_45872, float f) {
        float a = f;
        CameraClip a2 = this;
        if (CameraClip.mc.field_1690.method_31044() == class_5498.field_26666 && a2.noFront.getValue()) {
            CameraClip.mc.field_1690.method_31043(class_5498.field_26664);
        }
        CameraClip cameraClip = a2;
        cameraClip.animation.setLength(cameraClip.animateTime.getValueInt());
        if (CameraClip.mc.field_1690.method_31044() == class_5498.field_26664) {
            if (!a2.first) {
                a2.first = true;
                a2.animation.reset();
                return;
            }
        } else if (a2.first) {
            a2.first = false;
            a2.animation.reset();
        }
    }

    public double getDistance() {
        CameraClip a;
        double d = CameraClip.mc.field_1690.method_31044() == class_5498.field_26664 ? 1.0 - a.animation.easeOutQuad() : a.animation.easeOutQuad();
        return 1.0 + (a.distance.getValue() - 1.0) * d;
    }

    public CameraClip() {
        CameraClip a;
        CameraClip cameraClip = a;
        CameraClip cameraClip2 = a;
        super(Timer.ALLATORIxDEMO("zUSVKUgE\u0007\u0013"), Module.Category.Render);
        CameraClip cameraClip3 = a;
        cameraClip3.distance = cameraClip2.add(new SliderSetting(BaseChildSettings.ALLATORIxDEMO("d=T'[ \u0013a"), 4.0, 1.0, 20.0));
        cameraClip2.animateTime = cameraClip2.add(new SliderSetting(Timer.ALLATORIxDEMO("l\u0002\bTUJZVZp@\u0003\u0006"), 200, 0, 1000));
        cameraClip2.noFront = cameraClip2.add(new BooleanSetting(BaseChildSettings.ALLATORIxDEMO("\u001aH\u0015H!\u001ep"), false));
        cameraClip2.animation = new FadeUtils(300L);
        cameraClip.first = false;
        cameraClip.setChinese(Timer.ALLATORIxDEMO("\u7b15\u4e3d\u4e9e\u79d9\u7a11\u58fa"));
        INSTANCE = cameraClip;
    }
}
