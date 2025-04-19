/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ConfigManager;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.Component;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.BindComponent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.BooleanComponent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.ColorComponents;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.EnumComponent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.SliderComponent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;

public class OptionsTab
extends ClickGuiTab {
    public void addChild(Setting setting) {
        Setting a = setting;
        OptionsTab a2 = this;
        if (a == null) {
            return;
        }
        Hana.CONFIG.saveSettings();
        if (a instanceof SliderSetting) {
            OptionsTab optionsTab = a2;
            OptionsTab optionsTab2 = a2;
            optionsTab2.addChild(new SliderComponent(optionsTab2, (SliderSetting)a));
            return;
        }
        if (a instanceof BooleanSetting) {
            OptionsTab optionsTab = a2;
            optionsTab.addChild(new BooleanComponent(optionsTab, (BooleanSetting)a));
            return;
        }
        if (a instanceof EnumSetting) {
            OptionsTab optionsTab = a2;
            optionsTab.addChild(new EnumComponent(optionsTab, (EnumSetting)a));
            return;
        }
        if (a instanceof BindSetting) {
            OptionsTab optionsTab = a2;
            optionsTab.addChild(new BindComponent(optionsTab, (BindSetting)a));
            return;
        }
        if (a instanceof ColorSetting) {
            OptionsTab optionsTab = a2;
            optionsTab.addChild(new ColorComponents(optionsTab, (ColorSetting)a));
        }
    }

    /*
     * WARNING - void declaration
     */
    public OptionsTab(String string, int n, int n2) {
        void a;
        OptionsTab a2;
        void a3;
        int a4 = n2;
        OptionsTab optionsTab = a2 = this;
        super((String)a3, (int)a, a4);
        optionsTab.setWidth(180);
    }
}
