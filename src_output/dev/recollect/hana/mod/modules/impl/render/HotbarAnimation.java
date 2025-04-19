/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.api.alts.Alt;
import dev.recollect.hana.api.utils.dev.TipUtils;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;

public class HotbarAnimation
extends Module {
    public final EnumSetting<AnimateUtil.AnimMode> animMode;
    public final SliderSetting hotbarSpeed;
    public static HotbarAnimation INSTANCE;

    public HotbarAnimation() {
        HotbarAnimation a;
        HotbarAnimation hotbarAnimation = a;
        HotbarAnimation hotbarAnimation2 = a;
        super(Alt.ALLATORIxDEMO("\u000bq0x!d\rm0s%l+v-"), Module.Category.Render);
        HotbarAnimation hotbarAnimation3 = a;
        hotbarAnimation3.animMode = hotbarAnimation2.add(new EnumSetting<AnimateUtil.AnimMode>(TipUtils.ALLATORIxDEMO("\u0007\u0007(\u0003\u0011\u001cr\\"), AnimateUtil.AnimMode.Mio));
        hotbarAnimation.hotbarSpeed = hotbarAnimation2.add(new SliderSetting(Alt.ALLATORIxDEMO("\by8a8l\u0017h'|'"), 0.2, 0.01, 1.0, 0.01));
        hotbarAnimation.setChinese(TipUtils.ALLATORIxDEMO("\u52be\u7502"));
        INSTANCE = hotbarAnimation;
    }
}
