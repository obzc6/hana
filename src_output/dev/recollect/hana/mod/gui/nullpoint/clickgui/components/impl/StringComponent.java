/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl;

import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.Component;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.impl.combat.dev.hanacry.ObsidianHelper;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import java.awt.Color;
import java.util.function.Predicate;
import net.minecraft.class_332;
import net.minecraft.class_4587;

public class StringComponent
extends Component {
    private final StringSetting setting;
    boolean b;
    private final Timer timer;
    boolean hover;

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void update(int n, double d, double d2, boolean bl) {
        StringComponent stringComponent = this;
        if (GuiManager.currentGrabbed == null && stringComponent.isVisible()) {
            void a;
            void a2;
            void a3;
            void a4;
            StringComponent stringComponent2 = stringComponent;
            int n2 = stringComponent2.parent.getX();
            int a5 = stringComponent2.parent.getY();
            int n3 = stringComponent2.parent.getWidth();
            if (a4 >= (double)(n2 + 1) && a4 <= (double)(n2 + n3 - 1) && a2 >= (double)(a5 + a) && a2 <= (double)(a5 + a + stringComponent.defaultHeight - 2)) {
                stringComponent.hover = true;
                if (a3 == false) return;
                ClickGuiScreen.clicked = false;
                StringComponent stringComponent3 = stringComponent;
                stringComponent3.setting.setListening(!stringComponent3.setting.isListening());
                return;
            }
            if (a3 != false && stringComponent.setting.isListening()) {
                stringComponent.setting.setListening(false);
            }
            stringComponent.hover = false;
            return;
        }
        if (stringComponent.setting.isListening()) {
            stringComponent.setting.setListening(false);
        }
        stringComponent.hover = false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean draw(int n, class_332 class_3322, float f, Color color, boolean bl) {
        int a;
        int a2;
        String string;
        void a3;
        StringComponent stringComponent = this;
        if (stringComponent.timer.passed(1000L)) {
            stringComponent.b = !stringComponent.b;
            stringComponent.timer.reset();
        }
        if (a != 0) {
            stringComponent.setting.setListening(false);
        }
        StringComponent stringComponent2 = stringComponent;
        int a4 = stringComponent2.parent.getX();
        int a5 = stringComponent2.parent.getY();
        stringComponent2.currentOffset = StringComponent.animate(stringComponent2.currentOffset, a2);
        if (a != 0 && Math.abs(stringComponent.currentOffset - (double)a2) <= 0.5) {
            return false;
        }
        StringComponent stringComponent3 = stringComponent;
        a2 = (int)((double)stringComponent3.parent.getY() + stringComponent.currentOffset - 2.0);
        a = stringComponent3.parent.getWidth();
        class_4587 class_45872 = a3.method_51448();
        Object a6 = stringComponent3.setting.getValue();
        if (stringComponent.setting.isListening() && stringComponent.b) {
            a6 = (String)a6 + "_";
        }
        String string2 = string = stringComponent.setting.isListening() ? ObsidianHelper.ALLATORIxDEMO("\u0012}\u000e") : stringComponent.setting.getName();
        if (stringComponent.hover) {
            Render2DUtil.drawRect(class_45872, (float)a4 + 1.0f, (float)a2 + 1.0f, (float)a - 3.0f, (float)stringComponent.defaultHeight - 1.0f, UIModule.INSTANCE.shColor.getValue());
        }
        int n2 = a4;
        TextUtil.drawString((class_332)a3, (String)a6, (double)((float)(n2 + 4) + TextUtil.getWidth(string) / 2.0f), (double)((float)((double)a5 + stringComponent.getTextOffsetY() + stringComponent.currentOffset) - 2.0f), 16777215);
        TextUtil.drawStringWithScale((class_332)a3, string, (float)(n2 + 4), (float)((double)a5 + stringComponent.getTextOffsetY() + stringComponent.currentOffset - 2.0), -1, 0.5f);
        return true;
    }

    /*
     * WARNING - void declaration
     */
    public StringComponent(ClickGuiTab clickGuiTab, StringSetting stringSetting) {
        StringComponent a;
        void a2;
        StringSetting a3 = stringSetting;
        StringComponent stringComponent = a = this;
        a.hover = false;
        StringComponent stringComponent2 = a;
        a.timer = new Timer();
        stringComponent.setting = a3;
        stringComponent.parent = a2;
    }

    @Override
    public boolean isVisible() {
        StringComponent a;
        if (a.setting.visibility != null) {
            return a.setting.visibility.test(null);
        }
        return true;
    }
}
