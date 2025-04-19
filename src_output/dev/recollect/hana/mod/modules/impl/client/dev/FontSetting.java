/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import dev.recollect.hana.api.utils.dev.hole.OLEPOSSUtils;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.particle.Snow;
import dev.recollect.hana.mod.gui.nullpoint.font.FontRenderers;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;

public class FontSetting
extends Module {
    public static FontSetting INSTANCE;
    public final SliderSetting size;
    public final SliderSetting yOffset;

    public FontSetting() {
        FontSetting a;
        FontSetting fontSetting = a;
        FontSetting fontSetting2 = a;
        super(OLEPOSSUtils.ALLATORIxDEMO("\u000eXl\t"), Module.Category.Client);
        FontSetting fontSetting3 = a;
        fontSetting3.size = fontSetting2.add(new SliderSetting(Snow.ALLATORIxDEMO("\\2|7"), 8.0, 1.0, 15.0, 1.0));
        fontSetting.yOffset = fontSetting2.add(new SliderSetting(OLEPOSSUtils.ALLATORIxDEMO("\u001aL.Dg\t"), 0.0, -5.0, 15.0, 0.1));
        fontSetting.setChinese(Snow.ALLATORIxDEMO("\u5b51\u4f01"));
        INSTANCE = fontSetting;
    }

    @Override
    public void enable() {
        FontSetting a22;
        FontSetting fontSetting = a22;
        try {
            FontRenderers.createArial(fontSetting.size.getValueFloat());
            return;
        }
        catch (Exception a22) {
            a22.printStackTrace();
            return;
        }
    }
}
