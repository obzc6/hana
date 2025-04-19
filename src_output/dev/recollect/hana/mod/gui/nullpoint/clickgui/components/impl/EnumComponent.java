/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.components.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.math.Animation;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.ClickGuiScreen;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.components.Component;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.EnumSetting;
import java.awt.Color;
import java.util.function.Predicate;
import net.minecraft.class_332;
import net.minecraft.class_4587;

public class EnumComponent
extends Component {
    boolean isback;
    private boolean hover;
    private final EnumSetting setting;

    /*
     * WARNING - void declaration
     */
    public EnumComponent(ClickGuiTab clickGuiTab, EnumSetting enumSetting) {
        EnumComponent a;
        void a2;
        EnumSetting a3 = enumSetting;
        EnumComponent enumComponent = a = this;
        a.hover = false;
        enumComponent.parent = a2;
        enumComponent.setting = a3;
    }

    @Override
    public boolean isVisible() {
        EnumComponent a;
        if (a.setting.visibility != null) {
            return a.setting.visibility.test(null);
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean draw(int n, class_332 class_3322, float f, Color color, boolean bl) {
        String string;
        void a6;
        int n2;
        int a2;
        void a3;
        float a222 = f;
        EnumComponent a4 = this;
        a4.isback = a6;
        a4.currentOffset = EnumComponent.animate(a4.currentOffset, a2);
        if (a6 != false && Math.abs(a4.currentOffset - (double)a2) <= 0.5) {
            return false;
        }
        EnumComponent enumComponent = a4;
        a2 = enumComponent.parent.getX();
        int a222 = (int)((double)enumComponent.parent.getY() + a4.currentOffset - 2.0);
        int a5 = enumComponent.parent.getWidth();
        Render2DUtil.drawRect(a3.method_51448(), (float)a2 + 1.0f, (float)a222 + 1.0f, (float)a5 - 2.0f, (float)a4.defaultHeight - 1.0f, a4.hover ? UIModule.INSTANCE.mainHover.getValue() : Hana.GUI.getColor());
        TextUtil.drawString((class_332)a3, a4.setting.getName() + ": " + ((Enum)a4.setting.getValue()).name(), (double)(a2 + 4), (double)a222 + a4.getTextOffsetY(), new Color(-1).getRGB());
        if (a4.setting.popped) {
            string = Hole.ALLATORIxDEMO("4");
            n2 = a2;
        } else {
            string = Animation.ALLATORIxDEMO("'");
            n2 = a2;
        }
        TextUtil.drawString((class_332)a3, string, (double)(n2 + a5 - 11), (double)a222 + a4.getTextOffsetY(), new Color(255, 255, 255).getRGB());
        EnumComponent enumComponent2 = a4;
        a222 = (int)((double)a4.parent.getY() + enumComponent2.currentOffset - 1.0 + (double)(a4.defaultHeight - 2)) - 2;
        if (enumComponent2.setting.popped && a6 == false) {
            int n3;
            Enum[] a6 = (Enum[])a4.setting.getValue().getClass().getEnumConstants();
            int n4 = a6.length;
            int n5 = n3 = 0;
            while (n5 < n4) {
                String string2;
                String string3 = string2 = a6[n3].toString();
                TextUtil.drawString((class_332)a3, string3, (double)a5 / 2.0 - (double)(TextUtil.getWidth(string3) / 2.0f) + 2.0 + (double)a2, (double)(TextUtil.getHeight() / 2.0f + (float)a222), ((Enum)a4.setting.getValue()).name().equals(string2) ? -1 : new Color(120, 120, 120).getRGB());
                a222 = (int)((float)a222 + TextUtil.getHeight());
                n5 = ++n3;
            }
        }
        return true;
    }

    @Override
    public int getHeight() {
        EnumComponent a2;
        EnumComponent enumComponent = a2;
        if (!enumComponent.isVisible()) {
            return 0;
        }
        if (enumComponent.setting.popped && !enumComponent.isback) {
            int n;
            int a2 = 0;
            Enum[] arrenum = (Enum[])enumComponent.setting.getValue().getClass().getEnumConstants();
            int n2 = arrenum.length;
            int n3 = n = 0;
            while (n3 < n2) {
                arrenum[n];
                a2 = (int)((float)a2 + TextUtil.getHeight());
                n3 = ++n;
            }
            return enumComponent.defaultHeight + a2;
        }
        return enumComponent.defaultHeight;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void update(int n, double d, double d2, boolean bl) {
        void a;
        void a22;
        EnumComponent a3;
        void a4;
        int a5 = n;
        EnumComponent enumComponent = a3 = this;
        int n2 = enumComponent.parent.getX();
        int n3 = enumComponent.parent.getY();
        int n4 = enumComponent.parent.getWidth();
        if (a4 >= (double)(n2 + 2) && a4 <= (double)(n2 + n4 - 2) && a >= (double)(n3 + a5) && a <= (double)(n3 + a5 + a3.defaultHeight - 2)) {
            a3.hover = true;
            if (GuiManager.currentGrabbed == null && a3.isVisible()) {
                if (a22 != false) {
                    ClickGuiScreen.clicked = false;
                    a3.setting.increaseEnum();
                }
                if (ClickGuiScreen.rightClicked) {
                    a3.setting.popped = !a3.setting.popped;
                    ClickGuiScreen.rightClicked = false;
                }
            }
        } else {
            a3.hover = false;
        }
        if (GuiManager.currentGrabbed == null && a3.isVisible() && a22 != false) {
            a5 = n3 + a5 - 1 + (a3.defaultHeight - 2) - 2;
            if (a3.setting.popped) {
                int n5;
                Enum[] a22 = (Enum[])a3.setting.getValue().getClass().getEnumConstants();
                n3 = a22.length;
                int n6 = n5 = 0;
                while (n6 < n3) {
                    Enum enum_ = a22[n5];
                    if (a4 >= (double)n2 && a4 <= (double)(n2 + n4) && a >= (double)(TextUtil.getHeight() / 2.0f + (float)a5) && a < (double)(TextUtil.getHeight() + TextUtil.getHeight() / 2.0f + (float)a5)) {
                        a3.setting.setEnumValue(String.valueOf(enum_));
                        ClickGuiScreen.clicked = false;
                        return;
                    }
                    a5 = (int)((float)a5 + TextUtil.getHeight());
                    n6 = ++n5;
                }
            }
        }
    }
}
