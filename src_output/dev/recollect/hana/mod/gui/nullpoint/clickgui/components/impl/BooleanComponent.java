/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl;

import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.utils.dev.CrystalUtil;
import dev.recollect.hana.api.utils.dev.hole.HoleUtils;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.Component;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.function.Predicate;
import net.minecraft.class_332;
import net.minecraft.class_4587;

public class BooleanComponent
extends Component {
    public double currentWidth;
    boolean hover;
    final BooleanSetting setting;

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean draw(int n, class_332 class_3322, float f, Color color, boolean bl) {
        void a;
        void a2;
        int a3;
        int a4 = n;
        BooleanComponent a5 = this;
        a5.currentOffset = BooleanComponent.animate(a5.currentOffset, a4);
        if (a3 != 0 && Math.abs(a5.currentOffset - (double)a4) <= 0.5) {
            a5.currentWidth = 0.0;
            return false;
        }
        BooleanComponent booleanComponent = a5;
        a4 = booleanComponent.parent.getX();
        int a6 = (int)((double)booleanComponent.parent.getY() + a5.currentOffset - 2.0);
        a3 = booleanComponent.parent.getWidth();
        class_4587 class_45872 = a.method_51448();
        Render2DUtil.drawRect(class_45872, (float)a4 + 1.0f, (float)a6 + 1.0f, (float)a3 - 2.0f, (float)a5.defaultHeight - 1.0f, a5.hover ? UIModule.INSTANCE.shColor.getValue() : UIModule.INSTANCE.sbgColor.getValue());
        a5.currentWidth = BooleanComponent.animate(a5.currentWidth, a5.setting.getValue() ? (double)a3 - 2.0 : 0.0, UIModule.INSTANCE.booleanSpeed.getValue());
        Render2DUtil.drawRect(class_45872, (float)a4 + 1.0f, (float)a6 + 1.0f, (float)a5.currentWidth, (float)a5.defaultHeight - 1.0f, (Color)(a5.hover ? UIModule.INSTANCE.mainHover.getValue() : a2));
        BooleanComponent booleanComponent2 = a5;
        TextUtil.drawString((class_332)a, booleanComponent2.setting.getName(), (double)(a4 + 4), (double)a6 + a5.getTextOffsetY(), new Color(-1).getRGB());
        if (booleanComponent2.setting.parent) {
            String string;
            int n2;
            if (a5.setting.popped) {
                string = HoleUtils.ALLATORIxDEMO("!");
                n2 = a4;
            } else {
                string = CrystalUtil.ALLATORIxDEMO("k");
                n2 = a4;
            }
            TextUtil.drawString((class_332)a, string, (double)(n2 + a3 - 11), (double)a6 + a5.getTextOffsetY(), new Color(255, 255, 255).getRGB());
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    public BooleanComponent(ClickGuiTab clickGuiTab, BooleanSetting booleanSetting) {
        void a;
        BooleanComponent a2;
        BooleanSetting a3 = booleanSetting;
        BooleanComponent booleanComponent = a2 = this;
        BooleanComponent booleanComponent2 = a2;
        booleanComponent2.hover = false;
        booleanComponent2.currentWidth = 0.0;
        booleanComponent.parent = a;
        booleanComponent.setting = a3;
    }

    @Override
    public boolean isVisible() {
        BooleanComponent a;
        if (a.setting.visibility != null) {
            return a.setting.visibility.test(null);
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void update(int n, double d, double d2, boolean bl) {
        void a;
        void a2;
        BooleanComponent booleanComponent;
        void a3;
        BooleanComponent booleanComponent2 = booleanComponent = this;
        int n2 = booleanComponent2.parent.getX();
        int a4 = booleanComponent2.parent.getY();
        int n3 = booleanComponent2.parent.getWidth();
        if (GuiManager.currentGrabbed == null && booleanComponent.isVisible() && a >= (double)(n2 + 1) && a <= (double)(n2 + n3 - 1) && a3 >= (double)(a4 + a2) && a3 <= (double)(a4 + a2 + booleanComponent.defaultHeight - 2)) {
            void a5;
            booleanComponent.hover = true;
            if (a5 != false) {
                ClickGuiScreen.clicked = false;
                booleanComponent.setting.toggleValue();
            }
            if (ClickGuiScreen.rightClicked) {
                ClickGuiScreen.rightClicked = false;
                booleanComponent.setting.popped = !booleanComponent.setting.popped;
                return;
            }
        } else {
            booleanComponent.hover = false;
        }
    }
}
