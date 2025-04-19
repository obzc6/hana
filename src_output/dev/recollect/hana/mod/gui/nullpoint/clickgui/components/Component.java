/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.components;

import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.render.AnimateUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.Objects;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;

public abstract class Component
implements Wrapper {
    protected ClickGuiTab parent;
    public int defaultHeight;
    private int height;
    public double currentOffset;

    public boolean isVisible() {
        return true;
    }

    public void setParent(ClickGuiTab clickGuiTab) {
        ClickGuiTab a = clickGuiTab;
        Component a2 = this;
        a2.parent = a;
    }

    public Component() {
        Component a;
        Component component = a;
        component.height = a.defaultHeight = 16;
        component.currentOffset = 0.0;
    }

    public void setHeight(int n) {
        int a = n;
        Component a2 = this;
        a2.height = a;
    }

    public double getTextOffsetY() {
        Component a;
        Objects.requireNonNull(Wrapper.mc.field_1772);
        return (double)(a.defaultHeight - 9) / 2.0 + 1.0;
    }

    public boolean draw(int n, class_332 class_3322, float f, Color color, boolean bl) {
        int a = n;
        Component a2 = this;
        a2.currentOffset = a;
        return false;
    }

    public static double animate(double a, double a2, double a3) {
        if (a3 >= 1.0) {
            return a2;
        }
        if (a3 == 0.0) {
            return a;
        }
        return AnimateUtil.animate(a, a2, a3, UIModule.INSTANCE.animMode.getValue());
    }

    public abstract void update(int var1, double var2, double var4, boolean var6);

    public static double animate(double a, double a2) {
        return Component.animate(a, a2, UIModule.INSTANCE.animationSpeed.getValue());
    }

    public ClickGuiTab getParent() {
        Component a;
        return a.parent;
    }

    public int getHeight() {
        Component a;
        if (!a.isVisible()) {
            return 0;
        }
        return a.height;
    }
}
