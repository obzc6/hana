/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import org.bytedeco.javacv.BaseChildSettings;
import org.bytedeco.javacv.FrameConverter;

public class AspectRatio
extends Module {
    public final SliderSetting ratio;
    public static AspectRatio INSTANCE;

    public AspectRatio() {
        AspectRatio a;
        AspectRatio aspectRatio = a;
        super(BaseChildSettings.ALLATORIxDEMO("GT#E7S\u0001[:\u0019k"), Module.Category.Render);
        aspectRatio.ratio = a.add(new SliderSetting(FrameConverter.ALLATORIxDEMO("C\u000exL)"), 1.78, 0.0, 5.0, 0.01));
        aspectRatio.setChinese(BaseChildSettings.ALLATORIxDEMO("\u5c75\u5e1b\u5bcd\u5ea2"));
        INSTANCE = aspectRatio;
    }
}
