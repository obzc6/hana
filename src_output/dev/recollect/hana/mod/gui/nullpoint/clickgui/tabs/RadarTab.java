/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1429
 *  net.minecraft.class_1569
 *  net.minecraft.class_1657
 *  net.minecraft.class_241
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 *  net.minecraft.class_5348
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.ClickGuiTab;
import dev.recollect.hana.mod.modules.impl.client.UIModule;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import java.awt.Color;
import java.util.Iterator;
import java.util.Objects;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1429;
import net.minecraft.class_1569;
import net.minecraft.class_1657;
import net.minecraft.class_241;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_5348;
import net.minecraft.class_638;
import net.minecraft.class_746;

public class RadarTab
extends ClickGuiTab {
    float distance;

    /*
     * WARNING - void declaration
     */
    @Override
    public void draw(class_332 class_3322, float f, Color color) {
        float f2;
        void a;
        float f3;
        float f4;
        RadarTab a2;
        float f5;
        float f6;
        RadarTab radarTab = this;
        class_4587 a3 = a.method_51448();
        Objects.requireNonNull(radarTab);
        RadarTab radarTab2 = radarTab;
        class_4587 class_45872 = a3;
        RadarTab radarTab3 = radarTab;
        Render2DUtil.drawRound(a3, radarTab.x, radarTab3.y, radarTab.width, radarTab.height + 30, 4.0f, UIModule.INSTANCE.bgColor.getValue());
        Render2DUtil.drawRect(class_45872, (float)radarTab3.x, (float)(radarTab.y + 30) + (float)radarTab.height / 2.0f, (float)(radarTab.width - 1), 1.0f, new Color(128, 128, 128));
        Render2DUtil.drawRect(class_45872, (float)radarTab.x + (float)radarTab.width / 2.0f, (float)(radarTab.y + 30), 1.0f, (float)radarTab.height, new Color(128, 128, 128));
        Render2DUtil.drawBox(a3, radarTab2.x + radarTab.width / 2 - 2, radarTab.y + 30 + radarTab.height / 2 - 2, 5, 5, Hana.GUI.getColor(), 1.0f);
        RadarTab radarTab4 = radarTab;
        float f7 = (float)Math.sin(Math.toRadians(-radarTab4.mc.field_1724.method_5802().field_1342));
        float f8 = (float)Math.cos(Math.toRadians(-radarTab4.mc.field_1724.method_5802().field_1342));
        int n = radarTab4.x + radarTab.width / 2;
        int n2 = radarTab2.y + 28 + radarTab.height / 2;
        Iterator iterator = radarTab2.mc.field_1687.method_18112().iterator();
        block0 : do {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                a2 = (class_1297)iterator.next();
                if (!(a2 instanceof class_1309)) continue block0;
                if (a2 instanceof class_1657) {
                    iterator2 = iterator;
                    continue;
                }
                if (!(a2 instanceof class_1429)) {
                    Color color2;
                    if (a2 instanceof class_1569) {
                        Color color3 = color2;
                        color2 = new Color(255, 0, 0);
                    } else {
                        Color color4 = color2;
                        color2 = new Color(0, 0, 255);
                    }
                }
                Color color5 = new Color(0, 255, 0);
                iterator2 = iterator;
                RadarTab radarTab5 = a2;
                RadarTab radarTab6 = radarTab;
                f4 = (float)(radarTab5.method_23317() - radarTab.mc.field_1724.method_23317()) / radarTab6.distance;
                f2 = (float)(radarTab5.method_23321() - radarTab.mc.field_1724.method_23321()) / radarTab.distance;
                f5 = (float)radarTab.x + (float)radarTab.width / 2.0f - (float)radarTab.width * f4 / 2.0f;
                f3 = (float)(radarTab6.y + 28) + (float)radarTab.height / 2.0f - (float)radarTab.width * f2 / 2.0f;
                f6 = f8 * (f5 - (float)n) - f7 * (f3 - (float)n2) + (float)n;
                float f9 = f7 * (f5 - (float)n) + f8 * (f3 - (float)n2) + (float)n2;
                RadarTab radarTab7 = radarTab;
                Render2DUtil.drawRect(a3, (float)((int)Math.min((float)(radarTab7.x + radarTab7.width - 5), Math.max((float)radarTab.x, f6))), (float)((int)Math.min((float)(radarTab.y + 25 + radarTab.height), Math.max((float)(radarTab.y + 30), f9))), 3.0f, 3.0f, color5);
            }
            break;
        } while (true);
        iterator = radarTab.mc.field_1687.method_18112().iterator();
        Iterator iterator3 = iterator;
        while (iterator3.hasNext()) {
            void a4;
            a2 = (class_1297)iterator.next();
            if (a2 == radarTab.mc.field_1724) {
                iterator3 = iterator;
                continue;
            }
            RadarTab radarTab8 = a2;
            float f10 = (float)(radarTab8.method_23317() - radarTab.mc.field_1724.method_23317()) / radarTab.distance;
            f4 = (float)(radarTab8.method_23321() - radarTab.mc.field_1724.method_23321()) / radarTab.distance;
            iterator3 = iterator;
            RadarTab radarTab9 = radarTab;
            f2 = (float)radarTab.x + (float)radarTab.width / 2.0f - (float)radarTab9.width * f10 / 2.0f;
            f5 = (float)(radarTab9.y + 28) + (float)radarTab.height / 2.0f - (float)radarTab.width * f4 / 2.0f;
            f3 = f8 * (f2 - (float)n) - f7 * (f5 - (float)n2) + (float)n;
            f6 = f7 * (f2 - (float)n) + f8 * (f5 - (float)n2) + (float)n2;
            RadarTab radarTab10 = radarTab;
            Render2DUtil.drawBox(a3, (int)Math.min((float)(radarTab10.x + radarTab10.width - 5), Math.max((float)radarTab.x, f3)), (int)Math.min((float)(radarTab.y + 25 + radarTab.height), Math.max((float)(radarTab.y + 30), f6)), 3, 3, new Color(255, 255, 255), 1.0f);
            RadarTab radarTab11 = radarTab;
            TextUtil.drawStringWithScale((class_332)a, a2.method_5477().getString(), (float)((int)Math.min((float)(radarTab11.x + radarTab11.width - 5), Math.max((float)radarTab.x, f3))) - (float)radarTab.mc.field_1772.method_27525((class_5348)a2.method_5477()) * 0.5f, (float)((int)Math.min((float)(radarTab.y + 25 + radarTab.height), Math.max((float)(radarTab.y + 30), f6)) - 10), (Color)a4, 1.0f);
        }
        RadarTab radarTab12 = radarTab;
        TextUtil.drawCustomText((class_332)a, radarTab12.title, (double)(radarTab12.x + 8), (double)(radarTab.y + 8), Hana.GUI.getColor());
    }

    /*
     * WARNING - void declaration
     */
    public RadarTab(String string, int n, int n2) {
        void a;
        void a2;
        RadarTab a3;
        int a4 = n2;
        RadarTab radarTab = a3 = this;
        super((String)a2, (int)a, a4);
        a3.distance = 50.0f;
        radarTab.setWidth(190);
        radarTab.setHeight(190);
    }
}
