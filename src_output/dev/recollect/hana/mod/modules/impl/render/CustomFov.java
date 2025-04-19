/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.skid.Start;
import dev.recollect.hana.socket.network.user.User;

public class CustomFov
extends Module {
    public static CustomFov INSTANCE;
    public final SliderSetting itemFovModifier;
    public final BooleanSetting itemFov;
    public final SliderSetting fov;

    public CustomFov() {
        CustomFov a;
        CustomFov customFov = a;
        CustomFov customFov2 = a;
        super(User.ALLATORIxDEMO("WM}zMzVS"), Module.Category.Render);
        CustomFov customFov3 = a;
        customFov3.fov = customFov2.add(new SliderSetting(Start.ALLATORIxDEMO("Y\u0014#"), 120, 0, 160));
        customFov2.itemFov = customFov2.add(new BooleanSetting(User.ALLATORIxDEMO("W}pMzVS"), true));
        customFov.itemFovModifier = customFov2.add(new SliderSetting(Start.ALLATORIxDEMO("0#IofjHkWv\u001e'"), 120, 0, 358));
        customFov.setChinese(User.ALLATORIxDEMO("\u81ff\u5bba\u4e75\u5e46\u89f7"));
        INSTANCE = customFov;
    }
}
