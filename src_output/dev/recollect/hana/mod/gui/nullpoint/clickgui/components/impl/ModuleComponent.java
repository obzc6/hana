/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3675
 *  net.minecraft.class_4587
 *  org.lwjgl.opengl.GL11
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl;

import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.Component;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.BindComponent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.BooleanComponent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.ColorComponents;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.EnumComponent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.SliderComponent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl.StringComponent;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.impl.render.freelook.ProjectionUtils;
import dev.recollect.hana.mod.modules.settings.Setting;
import dev.recollect.hana.mod.modules.settings.impl.BindSetting;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import dev.recollect.hana.mod.modules.settings.impl.StringSetting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3675;
import net.minecraft.class_4587;
import org.lwjgl.opengl.GL11;

public class ModuleComponent
extends Component {
    private int expandedHeight;
    private boolean popped;
    public double currentWidth;
    private final ClickGuiTab parent;
    boolean hovered;
    public boolean isPopped;
    private final String text;
    private final List<Component> settingsList;
    private final Module module;

    /*
     * WARNING - void declaration
     */
    public void setScissorRegion(int n, int n2, int n3, int n4) {
        void a;
        void a2;
        void a3;
        void a4;
        int n5 = n4;
        ModuleComponent a5 = this;
        if (a2 > mc.method_22683().method_4507()) {
            return;
        }
        double d = mc.method_22683().method_4507() - (a2 + a4);
        GL11.glEnable((int)3089);
        GL11.glScissor((int)a, (int)((int)d), (int)a3, (int)a4);
    }

    /*
     * WARNING - void declaration
     */
    public ModuleComponent(String string, ClickGuiTab clickGuiTab, Module module) {
        Component a;
        Iterator<Setting> a2;
        ModuleComponent a3;
        void var2_5;
        void a422 = var2_5;
        ModuleComponent moduleComponent = a3 = this;
        ModuleComponent moduleComponent2 = a3;
        ModuleComponent moduleComponent3 = a3;
        ModuleComponent moduleComponent4 = a3;
        moduleComponent3.popped = false;
        moduleComponent3.expandedHeight = moduleComponent4.defaultHeight;
        ModuleComponent moduleComponent5 = a3;
        moduleComponent3.settingsList = new ArrayList<Component>();
        moduleComponent2.hovered = false;
        moduleComponent2.isPopped = false;
        moduleComponent.currentWidth = 0.0;
        moduleComponent.text = a2;
        a3.parent = a422;
        a3.module = a;
        for (Setting a422 : a3.module.getSettings()) {
            if ((a422.hide ? (a = null) : (a422 instanceof SliderSetting ? new SliderComponent(a3.parent, (SliderSetting)a422) : (a422 instanceof BooleanSetting ? new BooleanComponent(a3.parent, (BooleanSetting)a422) : (a422 instanceof BindSetting ? new BindComponent(a3.parent, (BindSetting)a422) : (a422 instanceof EnumSetting ? new EnumComponent(a3.parent, (EnumSetting)a422) : (a422 instanceof ColorSetting ? new ColorComponents(a3.parent, (ColorSetting)a422) : (a422 instanceof StringSetting ? new StringComponent(a3.parent, (StringSetting)a422) : (a = null)))))))) == null) continue;
            a3.settingsList.add(a);
        }
        a3.RecalculateExpandedHeight();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean draw(int n, class_332 class_3322, float f, Color color, boolean bl) {
        void a2;
        void a3;
        class_4587 class_45872;
        void a4;
        ModuleComponent moduleComponent;
        void a;
        ModuleComponent moduleComponent2 = moduleComponent = this;
        int a5 = moduleComponent2.parent.getX();
        int n2 = moduleComponent2.parent.getY();
        int n3 = moduleComponent2.parent.getWidth();
        moduleComponent2.module.getDisplayName();
        class_4587 class_45873 = a4.method_51448();
        moduleComponent2.currentOffset = ModuleComponent.animate(moduleComponent2.currentOffset, (double)a3);
        if (UIModule.fade.getQuad(FadeUtils.Quad.Out) >= 1.0 && UIModule.INSTANCE.scissor.getValue()) {
            moduleComponent.setScissorRegion(a5 * 2, (int)(((double)n2 + moduleComponent.currentOffset + (double)moduleComponent.defaultHeight) * 2.0), n3 * 2, mc.method_22683().method_4507() - (int)((double)n2 + moduleComponent.currentOffset + (double)moduleComponent.defaultHeight));
        }
        if (moduleComponent.popped) {
            moduleComponent.isPopped = true;
            ModuleComponent moduleComponent3 = moduleComponent;
            void string = a3 + moduleComponent3.defaultHeight + true;
            for (Component a6 : moduleComponent3.settingsList) {
                Component component;
                if (a6.isVisible()) {
                    a6.draw((int)string, (class_332)a4, (float)a, (Color)a2, false);
                    string += a6.getHeight();
                    continue;
                }
                if (a6 instanceof SliderComponent) {
                    SliderComponent sliderComponent = (SliderComponent)a6;
                    component = a6;
                    sliderComponent.renderSliderPosition = 0.0;
                } else if (a6 instanceof BooleanComponent) {
                    ((BooleanComponent)a6).currentWidth = 0.0;
                    component = a6;
                } else {
                    if (a6 instanceof ColorComponents) {
                        ((ColorComponents)a6).currentWidth = 0.0;
                    }
                    component = a6;
                }
                component.currentOffset = (double)(string - moduleComponent.defaultHeight);
            }
        } else if (moduleComponent.isPopped) {
            boolean bl2 = true;
            boolean bl3 = false;
            for (Component component : moduleComponent.settingsList) {
                if (!component.isVisible()) continue;
                if (!component.draw((int)moduleComponent.currentOffset, (class_332)a4, (float)a, (Color)a2, true)) {
                    bl3 = true;
                    continue;
                }
                bl2 = false;
            }
            if (bl3 && bl2) {
                moduleComponent.isPopped = false;
            }
        } else {
            Iterator<Component> iterator;
            Iterator<Component> iterator2 = iterator = moduleComponent.settingsList.iterator();
            while (iterator2.hasNext()) {
                Component component = iterator.next();
                iterator2 = iterator;
                component.currentOffset = moduleComponent.currentOffset;
            }
        }
        if (UIModule.fade.getQuad(FadeUtils.Quad.Out) >= 1.0 && UIModule.INSTANCE.scissor.getValue()) {
            GL11.glDisable((int)3089);
        }
        moduleComponent.currentWidth = ModuleComponent.animate(moduleComponent.currentWidth, moduleComponent.module.isOn() ? (double)n3 - 2.0 : 0.0, UIModule.INSTANCE.booleanSpeed.getValue());
        class_4587 class_45874 = class_45873;
        if (UIModule.INSTANCE.moduleEnd.booleanValue) {
            Render2DUtil.drawRectHorizontal(class_45874, a5 + 1, (int)((double)n2 + moduleComponent.currentOffset), (float)moduleComponent.currentWidth, moduleComponent.defaultHeight - 1, UIModule.INSTANCE.moduleEnable.getValue(), UIModule.INSTANCE.moduleEnd.getValue());
            class_45872 = class_45873;
        } else {
            Render2DUtil.drawRect(class_45874, (float)(a5 + 1), (float)((int)((double)n2 + moduleComponent.currentOffset)), (float)moduleComponent.currentWidth, (float)(moduleComponent.defaultHeight - 1), UIModule.INSTANCE.moduleEnable.getValue());
            class_45872 = class_45873;
        }
        Render2DUtil.drawRect(class_45872, (float)(a5 + 1), (float)((int)((double)n2 + moduleComponent.currentOffset)), (float)(n3 - 2), (float)(moduleComponent.defaultHeight - 1), moduleComponent.hovered ? UIModule.INSTANCE.mhColor.getValue() : UIModule.INSTANCE.mbgColor.getValue());
        if (moduleComponent.hovered && class_3675.method_15987((long)mc.method_22683().method_4490(), (int)340)) {
            TextUtil.drawString((class_332)a4, "Drawn " + (moduleComponent.module.drawnSetting.getValue() ? ProjectionUtils.ALLATORIxDEMO("\u008d\r\u0018") : MathUtil.ALLATORIxDEMO("\u00df\f<\u0013\u000f")), (double)(a5 + 4), (double)((float)((double)n2 + moduleComponent.getTextOffsetY() + moduleComponent.currentOffset) - 1.0f), -1);
        } else {
            TextUtil.drawString((class_332)a4, moduleComponent.text, (double)(a5 + 4), (double)((float)((double)n2 + moduleComponent.getTextOffsetY() + moduleComponent.currentOffset) - 1.0f), moduleComponent.module.isOn() ? UIModule.INSTANCE.enableText.getValue().getRGB() : UIModule.INSTANCE.disableText.getValue().getRGB());
        }
        if (UIModule.INSTANCE.bindC.booleanValue && moduleComponent.module.getBind().getKey() != -1) {
            String string = "[" + moduleComponent.module.getBind().getBind() + "]";
            TextUtil.drawStringWithScale((class_332)a4, string, (float)(a5 + 5) + TextUtil.getWidth(moduleComponent.text), (float)((double)n2 + moduleComponent.getTextOffsetY() + moduleComponent.currentOffset - (double)(TextUtil.getHeight() / 4.0f)), UIModule.INSTANCE.bindC.getValue(), 0.5f);
        }
        if (UIModule.INSTANCE.gearColor.booleanValue) {
            void v6 = a4;
            if (moduleComponent.isPopped) {
                TextUtil.drawString((class_332)v6, ProjectionUtils.ALLATORIxDEMO("\u2670"), (double)(a5 + n3 - 12), (double)n2 + moduleComponent.getTextOffsetY() + moduleComponent.currentOffset - 3.0, UIModule.INSTANCE.gearColor.getValue().getRGB());
            } else {
                TextUtil.drawString((class_332)v6, MathUtil.ALLATORIxDEMO("\u266c"), (double)(a5 + n3 - 11), (double)n2 + moduleComponent.getTextOffsetY() + moduleComponent.currentOffset, UIModule.INSTANCE.gearColor.getValue().getRGB());
            }
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
        void a4;
        ModuleComponent moduleComponent;
        ModuleComponent moduleComponent2 = moduleComponent = this;
        int n2 = moduleComponent2.parent.getX();
        int n3 = moduleComponent2.parent.getY();
        int n4 = moduleComponent2.parent.getWidth();
        if (moduleComponent2.popped) {
            Iterator<Component> iterator;
            void var10_9 = a + moduleComponent.defaultHeight + true;
            Iterator<Component> iterator2 = iterator = moduleComponent.settingsList.iterator();
            while (iterator2.hasNext()) {
                Component a5 = iterator.next();
                iterator2 = iterator;
                void v2 = var10_9;
                a5.update((int)v2, (double)a3, (double)a4, (boolean)a2);
                var10_9 = v2 + a5.getHeight();
            }
        }
        boolean bl2 = moduleComponent.hovered = a3 >= (double)n2 && a3 <= (double)(n2 + n4) && a4 >= (double)(n3 + a) && a4 <= (double)(n3 + a + moduleComponent.defaultHeight - 1);
        if (moduleComponent.hovered && GuiManager.currentGrabbed == null) {
            if (a2 != false) {
                ClickGuiScreen.clicked = false;
                if (class_3675.method_15987((long)mc.method_22683().method_4490(), (int)340)) {
                    moduleComponent.module.drawnSetting.setValue(!moduleComponent.module.drawnSetting.getValue());
                } else {
                    moduleComponent.module.toggle();
                }
            }
            if (ClickGuiScreen.rightClicked) {
                ClickGuiScreen.rightClicked = false;
                moduleComponent.popped = !moduleComponent.popped;
            }
        }
        ModuleComponent moduleComponent3 = moduleComponent;
        moduleComponent3.RecalculateExpandedHeight();
        ModuleComponent moduleComponent4 = moduleComponent;
        if (moduleComponent3.popped) {
            moduleComponent4.setHeight(moduleComponent.expandedHeight);
            return;
        }
        moduleComponent4.setHeight(moduleComponent.defaultHeight);
    }

    public void RecalculateExpandedHeight() {
        ModuleComponent a22;
        ModuleComponent moduleComponent;
        ModuleComponent moduleComponent2 = moduleComponent = a22;
        int a22 = moduleComponent2.defaultHeight;
        for (Component component : moduleComponent2.settingsList) {
            if (component == null || !component.isVisible()) continue;
            a22 += component.getHeight();
        }
        moduleComponent.expandedHeight = a22;
    }

    public List<Component> getSettingsList() {
        ModuleComponent a;
        return a.settingsList;
    }
}
