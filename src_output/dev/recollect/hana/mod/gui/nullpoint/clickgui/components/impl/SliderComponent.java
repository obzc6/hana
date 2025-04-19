/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl;

import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.Component;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.function.Predicate;
import net.minecraft.class_332;
import net.minecraft.class_4587;

public class SliderComponent
extends Component {
    final SliderSetting setting;
    private boolean clicked;
    private final ClickGuiTab parent;
    private boolean firstUpdate;
    private boolean hover;
    private double currentSliderPosition;
    public double renderSliderPosition;

    /*
     * WARNING - void declaration
     */
    public SliderComponent(ClickGuiTab clickGuiTab, SliderSetting sliderSetting) {
        SliderComponent a;
        void a2;
        SliderSetting a3 = sliderSetting;
        SliderComponent sliderComponent = a = this;
        SliderComponent sliderComponent2 = a;
        SliderComponent sliderComponent3 = a;
        sliderComponent3.clicked = false;
        sliderComponent3.hover = false;
        sliderComponent2.firstUpdate = true;
        sliderComponent2.renderSliderPosition = 0.0;
        sliderComponent.parent = a2;
        sliderComponent.setting = a3;
    }

    @Override
    public boolean isVisible() {
        SliderComponent a;
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
        void a3;
        SliderComponent sliderComponent = this;
        if (sliderComponent.firstUpdate) {
            sliderComponent.currentSliderPosition = (float)((sliderComponent.setting.getValue() - sliderComponent.setting.getMinimum()) / sliderComponent.setting.getRange());
            sliderComponent.firstUpdate = false;
        }
        SliderComponent sliderComponent2 = sliderComponent;
        int a4 = sliderComponent2.parent.getX();
        int n2 = sliderComponent2.parent.getY();
        int n3 = sliderComponent2.parent.getWidth();
        if (a2 >= (double)a4 && a2 <= (double)(a4 + n3 - 2) && a >= (double)(n2 + a3) && a <= (double)(n2 + a3 + sliderComponent.defaultHeight - 2)) {
            void a5;
            sliderComponent.hover = true;
            if (GuiManager.currentGrabbed == null && sliderComponent.isVisible() && (a5 != false || ClickGuiScreen.hoverClicked && sliderComponent.clicked)) {
                SliderComponent sliderComponent3 = sliderComponent;
                sliderComponent.clicked = true;
                ClickGuiScreen.hoverClicked = true;
                ClickGuiScreen.clicked = false;
                sliderComponent3.currentSliderPosition = (float)Math.min((double)((a2 - 1.0 - (double)a4) / (double)(n3 - 3)), 1.0);
                sliderComponent3.currentSliderPosition = Math.max(0.0, sliderComponent.currentSliderPosition);
                sliderComponent.setting.setValue(sliderComponent.currentSliderPosition * sliderComponent.setting.getRange() + sliderComponent.setting.getMinimum());
                return;
            }
        } else {
            sliderComponent.clicked = false;
            sliderComponent.hover = false;
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean draw(int n, class_332 class_3322, float f, Color color, boolean bl) {
        SliderComponent a;
        void a2;
        void a3;
        void a4;
        int a222 = n;
        SliderComponent sliderComponent = a = this;
        SliderComponent sliderComponent2 = a;
        int a5 = sliderComponent2.parent.getX();
        int n2 = sliderComponent2.parent.getY();
        int n3 = sliderComponent.parent.getWidth();
        class_4587 class_45872 = a4.method_51448();
        sliderComponent.currentOffset = SliderComponent.animate(sliderComponent.currentOffset, a222);
        if (a3 != false && Math.abs(a.currentOffset - (double)a222) <= 0.5) {
            a.renderSliderPosition = 0.0;
            return false;
        }
        a.renderSliderPosition = SliderComponent.animate(a.renderSliderPosition, Math.floor((double)(n3 - 2) * a.currentSliderPosition), UIModule.INSTANCE.sliderSpeed.getValue());
        Render2DUtil.drawRect(class_45872, (float)(a5 + 1), (float)((int)((double)n2 + a.currentOffset - 1.0)), (float)((int)a.renderSliderPosition), (float)(a.defaultHeight - 1), (Color)(a.hover ? UIModule.INSTANCE.mainHover.getValue() : a2));
        if (a.setting == null) {
            return true;
        }
        SliderComponent sliderComponent3 = a;
        Object a222 = (String)((double)a.setting.getValueInt() == a.setting.getValue() ? (a222 = String.valueOf(sliderComponent3.setting.getValueInt())) : (a222 = String.valueOf(sliderComponent3.setting.getValueFloat()))) + a.setting.getSuffix();
        void v3 = a4;
        TextUtil.drawString((class_332)v3, a.setting.getName(), (double)(a5 + 4), (double)((float)((double)n2 + a.getTextOffsetY() + a.currentOffset - 2.0)), 16777215);
        TextUtil.drawString((class_332)v3, (String)a222, (double)((float)(a5 + n3) - TextUtil.getWidth((String)a222) - 5.0f), (double)((float)((double)n2 + a.getTextOffsetY() + a.currentOffset - 2.0)), 16777215);
        return true;
    }
}
