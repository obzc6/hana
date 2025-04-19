/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package dev.recollect.hana.mod.modules.impl.player;

import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.xibao.SnowAnimation;
import net.minecraft.class_310;

public class FastUse
extends Module {
    private final SliderSetting delay;

    @Override
    public void onUpdate() {
        FastUse a;
        if (FastUse.mc.field_1752 <= 4 - a.delay.getValueInt()) {
            FastUse.mc.field_1752 = 0;
        }
    }

    public FastUse() {
        FastUse a;
        FastUse fastUse = a;
        super(ProjectionUtils.ALLATORIxDEMO("0p$C$R\u0002"), Module.Category.Player);
        FastUse fastUse2 = a;
        fastUse.delay = fastUse.add(new SliderSetting(SnowAnimation.ALLATORIxDEMO("\u0013J\u001dX\u001e"), 0.0, 0.0, 4.0, 1.0));
        fastUse.setChinese(ProjectionUtils.ALLATORIxDEMO("\u5fdc\u906e\u4f5e\u754f"));
    }
}
