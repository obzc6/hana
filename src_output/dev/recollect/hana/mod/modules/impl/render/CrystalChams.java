/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.render;

import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.video.FileUtil;
import java.awt.Color;

public class CrystalChams
extends Module {
    public final SliderSetting scale;
    public final SliderSetting spinValue;
    public final SliderSetting bounceHeight;
    public final BooleanSetting texture;
    public static CrystalChams INSTANCE;
    public final ColorSetting core;
    public final ColorSetting innerFrame;
    public final SliderSetting floatValue;
    public final SliderSetting floatOffset;
    public final ColorSetting outerFrame;

    public CrystalChams() {
        CrystalChams a;
        CrystalChams crystalChams = a;
        CrystalChams crystalChams2 = a;
        super(Snow.ALLATORIxDEMO("N+[\u0005}<l\u0017d95"), Module.Category.Render);
        CrystalChams crystalChams3 = a;
        crystalChams3.core = crystalChams2.add(new ColorSetting(FileUtil.ALLATORIxDEMO("[\u0018t\f"), new Color(255, 255, 255, 255)).injectBoolean(true));
        crystalChams2.outerFrame = crystalChams2.add(new ColorSetting(Snow.ALLATORIxDEMO("m\u0003}8r\u0012~9#"), new Color(255, 255, 255, 255)).injectBoolean(true));
        crystalChams2.innerFrame = crystalChams2.add(new ColorSetting(FileUtil.ALLATORIxDEMO("7s\u0017f=j\u0016k\f"), new Color(255, 255, 255, 255)).injectBoolean(true));
        crystalChams2.texture = crystalChams2.add(new BooleanSetting(Snow.ALLATORIxDEMO("\te,x-`#"), true));
        crystalChams2.scale = crystalChams2.add(new SliderSetting(FileUtil.ALLATORIxDEMO("({\u0016j\f"), 1.0, 0.0, 3.0, 0.01));
        crystalChams2.spinValue = crystalChams2.add(new SliderSetting(Snow.ALLATORIxDEMO("%y4n\u0007|=w\""), 1.0, 0.0, 3.0, 0.01));
        crystalChams2.bounceHeight = crystalChams2.add(new SliderSetting(FileUtil.ALLATORIxDEMO("[\u0019C7~\u0017\\\u001eq\u0010n\u001d"), 1.0, 0.0, 3.0, 0.01));
        crystalChams2.floatValue = crystalChams2.add(new SliderSetting(Snow.ALLATORIxDEMO("\u001bM\u0003g>e\u0007|=w\""), 1.0, 0.0, 3.0, 0.01));
        crystalChams.floatOffset = crystalChams2.add(new SliderSetting(FileUtil.ALLATORIxDEMO("+[\u001d~\u0004c\u001d"), 0.0, -1.0, 1.0, 0.01));
        crystalChams.setChinese(Snow.ALLATORIxDEMO("\u6c38\u662e\u901d\u8980"));
        INSTANCE = crystalChams;
    }
}
