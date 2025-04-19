/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.modules.impl.player.dev;

import dev.recollect.hana.api.utils.math.WebUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.util.function.Predicate;
import net.minecraft.class_310;
import net.minecraft.class_746;
import org.bytedeco.javacv.FrameFilter;

public class YawLock
extends Module {
    private final BooleanSetting pitchLock;
    private final SliderSetting yaw;
    public static YawLock INSTANCE;
    private final SliderSetting pitch;
    private final BooleanSetting smart;
    private final BooleanSetting yawLock;

    @Override
    public void onUpdate() {
        YawLock a;
        if (a.yawLock.getValue()) {
            YawLock.mc.field_1724.method_36456(a.smart.getValue() ? (float)Math.round((YawLock.mc.field_1724.method_36454() + 1.0f) / 45.0f) * 45.0f : a.yaw.getValueFloat());
        }
        if (a.pitchLock.getValue()) {
            YawLock.mc.field_1724.method_36457(a.pitch.getValueFloat());
        }
    }

    public YawLock() {
        YawLock a;
        YawLock yawLock = a;
        super(FrameFilter.ALLATORIxDEMO("f,k\r*s"), Module.Category.Player);
        YawLock yawLock2 = a;
        yawLock2.yawLock = yawLock.add(new BooleanSetting(WebUtils.ALLATORIxDEMO("D2m\u0002hg&"), true));
        yawLock.smart = yawLock.add(new BooleanSetting(FrameFilter.ALLATORIxDEMO("O,q;l"), true));
        yawLock.yaw = yawLock.add(new SliderSetting(WebUtils.ALLATORIxDEMO("^e:"), 0.0, -180.0, 180.0, 0.1, object -> {
            Object a = object;
            YawLock a2 = this;
            return !a2.smart.getValue();
        }));
        YawLock yawLock3 = a;
        yawLock3.pitchLock = yawLock3.add(new BooleanSetting(FrameFilter.ALLATORIxDEMO("T\u0007K.t\r*s"), true));
        yawLock3.pitch = yawLock3.add(new SliderSetting(WebUtils.ALLATORIxDEMO("J'sg%"), 0.0, -90.0, 90.0, 0.1));
        INSTANCE = yawLock3;
    }
}
