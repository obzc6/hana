/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ConfigManager;
import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.utils.dev.GaussianFilter;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.Component;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.gui.nullpoint.font.FontAdapter;
import dev.recollect.hana.mod.gui.nullpoint.font.FontRenderers;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import org.bytedeco.javacv.BufferRing;

public class ClickGuiTab
extends Tab {
    private final Color textColor;
    protected final boolean drawBorder = true;
    protected final ArrayList<Component> children;
    private boolean popped;
    protected String title;
    private final Color borderColor;
    private final Color backgroundColor;
    public double currentHeight;
    private final Color headerColor;
    private Module.Category category;

    public static double animate(double a, double a2, double a3) {
        double d;
        boolean bl = a2 > a;
        a3 = (Math.max(a2, a) - Math.min(a2, a)) * a3;
        if (Math.abs(d) <= 0.001) {
            return a2;
        }
        return a + (bl ? a3 : -a3);
    }

    @Override
    public final void setHeight(int n) {
        int a = n;
        ClickGuiTab a2 = this;
        a2.height = a;
    }

    public static double animate(double a, double a2) {
        return ClickGuiTab.animate(a, a2, UIModule.INSTANCE.animationSpeed.getValue());
    }

    /*
     * WARNING - void declaration
     */
    public void onMouseClick(double d, double d2, boolean bl) {
        void a;
        boolean bl2 = bl;
        ClickGuiTab a2 = this;
        if (GuiManager.currentGrabbed == null && a >= (double)a2.x) {
            void a3;
            ClickGuiTab clickGuiTab = a2;
            if (a <= (double)(clickGuiTab.x + clickGuiTab.width) && a3 >= (double)a2.y && a3 <= (double)(a2.y + 13)) {
                void a4;
                if (a4 != false) {
                    GuiManager.currentGrabbed = a2;
                    return;
                }
                if (ClickGuiScreen.rightClicked) {
                    a2.popped = !a2.popped;
                    ClickGuiScreen.rightClicked = false;
                }
            }
        }
    }

    @Override
    public final void setY(int n) {
        int a = n;
        ClickGuiTab a2 = this;
        a2.y = a;
    }

    public final String getTitle() {
        ClickGuiTab a;
        return a.title;
    }

    public ArrayList<Component> getChildren() {
        ClickGuiTab a;
        return a.children;
    }

    @Override
    public final int getWidth() {
        ClickGuiTab a;
        return a.width;
    }

    @Override
    public final void setX(int n) {
        int a = n;
        ClickGuiTab a2 = this;
        a2.x = a;
    }

    public final void addChild(Component component) {
        Component a = component;
        ClickGuiTab a2 = this;
        a2.children.add(a);
    }

    @Override
    public final int getHeight() {
        ClickGuiTab a;
        return a.height;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void update(double d, double d2, boolean bl) {
        void a;
        void a2;
        ClickGuiTab clickGuiTab;
        void a3;
        ClickGuiTab clickGuiTab2 = clickGuiTab = this;
        clickGuiTab2.onMouseClick((double)a, (double)a2, (boolean)a3);
        if (clickGuiTab2.popped) {
            Object object;
            Iterator<Component> iterator;
            int a42 = 1;
            Iterator<Component> iterator2 = iterator = clickGuiTab.children.iterator();
            while (iterator2.hasNext()) {
                object = iterator.next();
                a42 += ((Component)object).getHeight();
                iterator2 = iterator;
            }
            clickGuiTab.height = a42;
            int n = 15;
            Object object2 = object = clickGuiTab.children.iterator();
            while (object2.hasNext()) {
                Component a42 = (Component)object.next();
                object2 = object;
                int n2 = n;
                a42.update(n2, (double)a, (double)a2, (boolean)a3);
                n = n2 + a42.getHeight();
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void draw(class_332 class_3322, float f, Color color) {
        Iterator<Component> a6222;
        class_4587 class_45872;
        void a2;
        void a3;
        ClickGuiTab clickGuiTab = this;
        int n = 1;
        Iterator<Component> iterator = a6222 = clickGuiTab.children.iterator();
        while (iterator.hasNext()) {
            Component component = a6222.next();
            n += component.getHeight();
            iterator = a6222;
        }
        clickGuiTab.height = n;
        class_4587 a6222 = a2.method_51448();
        clickGuiTab.currentHeight = Component.animate(clickGuiTab.currentHeight, clickGuiTab.height);
        if (UIModule.INSTANCE.categoryEnd.booleanValue) {
            class_4587 class_45873 = a6222;
            class_45872 = class_45873;
            Render2DUtil.drawRectVertical(class_45873, clickGuiTab.x, clickGuiTab.y - 2, clickGuiTab.width, 15.0f, (Color)a3, UIModule.INSTANCE.categoryEnd.getValue());
        } else {
            class_4587 class_45874 = a6222;
            class_45872 = class_45874;
            Render2DUtil.drawRect(class_45874, (float)clickGuiTab.x, (float)(clickGuiTab.y - 2), (float)clickGuiTab.width, 15.0f, a3.getRGB());
        }
        Render2DUtil.drawRect(class_45872, (float)clickGuiTab.x, (float)(clickGuiTab.y - 2 + 15), (float)clickGuiTab.width, 1.0f, new Color(38, 38, 38));
        if (clickGuiTab.popped) {
            Render2DUtil.drawRect(a6222, (float)clickGuiTab.x, (float)(clickGuiTab.y + 14), (float)clickGuiTab.width, (float)((int)clickGuiTab.currentHeight), UIModule.INSTANCE.bgColor.getValue());
        }
        if (clickGuiTab.popped) {
            int n2 = 15;
            for (Component a6222 : clickGuiTab.children) {
                ClickGuiTab clickGuiTab2;
                if (a6222.isVisible()) {
                    void a5;
                    a6222.draw(n2, (class_332)a2, (float)a5, (Color)a3, false);
                    n2 += a6222.getHeight();
                    clickGuiTab2 = clickGuiTab;
                } else {
                    a6222.currentOffset = n2 - 15;
                    clickGuiTab2 = clickGuiTab;
                }
                if (clickGuiTab2.title.equals(GaussianFilter.ALLATORIxDEMO("\u0017W*I0I"))) {
                    FontRenderers.big_icons.drawString(a2.method_51448(), BufferRing.ALLATORIxDEMO("R"), clickGuiTab.x + 3, clickGuiTab.y + 1, new Color(255, 255, 255).getRGB());
                }
                if (clickGuiTab.title.equals(GaussianFilter.ALLATORIxDEMO("\nB\"^"))) {
                    FontRenderers.big_icons.drawString(a2.method_51448(), BufferRing.ALLATORIxDEMO("P"), clickGuiTab.x + 3, clickGuiTab.y + 1, new Color(255, 255, 255).getRGB());
                }
                if (clickGuiTab.title.equals(GaussianFilter.ALLATORIxDEMO("\u000fA\"]*N?I"))) {
                    FontRenderers.big_icons.drawString(a2.method_51448(), BufferRing.ALLATORIxDEMO("V"), clickGuiTab.x + 3, clickGuiTab.y + 1, new Color(255, 255, 255).getRGB());
                }
                if (clickGuiTab.title.equals(GaussianFilter.ALLATORIxDEMO("\u0004T&R4O"))) {
                    FontRenderers.big_icons.drawString(a2.method_51448(), BufferRing.ALLATORIxDEMO("U"), clickGuiTab.x + 3, clickGuiTab.y + 1, new Color(255, 255, 255).getRGB());
                }
                if (clickGuiTab.title.equals(GaussianFilter.ALLATORIxDEMO("\u0006])O4O"))) {
                    FontRenderers.big_icons.drawString(a2.method_51448(), BufferRing.ALLATORIxDEMO("S"), clickGuiTab.x + 3, clickGuiTab.y + 1, new Color(255, 255, 255).getRGB());
                }
                if (clickGuiTab.title.equals(GaussianFilter.ALLATORIxDEMO("\u0017T.N?I"))) {
                    FontRenderers.big_icons.drawString(a2.method_51448(), BufferRing.ALLATORIxDEMO("Q"), clickGuiTab.x + 3, clickGuiTab.y + 1, new Color(255, 255, 255).getRGB());
                }
                if (clickGuiTab.title.equals(GaussianFilter.ALLATORIxDEMO("k,H+D8I"))) {
                    FontRenderers.big_icons.drawString(a2.method_51448(), BufferRing.ALLATORIxDEMO("W"), clickGuiTab.x + 3, clickGuiTab.y + 1, new Color(255, 255, 255).getRGB());
                }
                ClickGuiTab clickGuiTab3 = clickGuiTab;
                TextUtil.drawString((class_332)a2, clickGuiTab3.title, (double)clickGuiTab3.x + (double)clickGuiTab.width / 2.0 - (double)(TextUtil.getWidth(clickGuiTab.title) / 2.0f), (double)(clickGuiTab.y + 2), new Color(255, 255, 255));
                if (clickGuiTab.category == null) continue;
                String a6222 = "[" + String.valueOf(Hana.MODULE.categoryModules.get((Object)clickGuiTab.category)) + "]";
                ClickGuiTab clickGuiTab4 = clickGuiTab;
                String string = a6222;
                TextUtil.drawStringWithScale((class_332)a2, string, (float)(clickGuiTab4.x + clickGuiTab4.width - 4) - TextUtil.getWidth(string) * 0.5f, (float)(clickGuiTab.y + 2), new Color(255, 255, 255), 0.5f);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public ClickGuiTab(String string, int n, int n2) {
        void a;
        void a2;
        ClickGuiTab a3;
        String a4 = string;
        ClickGuiTab clickGuiTab = a3 = this;
        ClickGuiTab clickGuiTab2 = a3;
        ClickGuiTab clickGuiTab3 = a3;
        ClickGuiTab clickGuiTab4 = a3;
        clickGuiTab4.drawBorder = true;
        clickGuiTab4.category = null;
        ClickGuiTab clickGuiTab5 = a3;
        clickGuiTab4.children = new ArrayList();
        clickGuiTab3.popped = true;
        clickGuiTab3.currentHeight = 0.0;
        clickGuiTab2.borderColor = new Color(50, 50, 50, 255);
        clickGuiTab2.headerColor = new Color(30, 30, 30, 255);
        clickGuiTab2.backgroundColor = new Color(20, 20, 20, 255);
        clickGuiTab.textColor = new Color(255, 255, 255, 255);
        clickGuiTab.title = a4;
        clickGuiTab.x = Hana.CONFIG.getInt((String)a4 + "_x", (int)a2);
        a3.y = Hana.CONFIG.getInt((String)a4 + "_y", (int)a);
        ClickGuiTab clickGuiTab6 = a3;
        clickGuiTab6.width = 100;
        clickGuiTab6.mc = class_310.method_1551();
    }

    /*
     * WARNING - void declaration
     */
    public ClickGuiTab(Module.Category category, int n, int n2) {
        void a;
        void a2;
        Module.Category a3 = category;
        ClickGuiTab a4 = this;
        a4(a3.name(), (int)a2, (int)a);
        a4.category = a3;
    }

    public final boolean isGrabbed() {
        ClickGuiTab a;
        return GuiManager.currentGrabbed == a;
    }

    @Override
    public final int getX() {
        ClickGuiTab a;
        return a.x;
    }

    @Override
    public final int getY() {
        ClickGuiTab a;
        return a.y;
    }

    public final void setTitle(String string) {
        String a = string;
        ClickGuiTab a2 = this;
        a2.title = a;
    }

    @Override
    public final void setWidth(int n) {
        int a = n;
        ClickGuiTab a2 = this;
        a2.width = a;
    }
}
