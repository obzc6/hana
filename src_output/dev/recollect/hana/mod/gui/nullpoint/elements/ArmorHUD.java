/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1661
 *  net.minecraft.class_1799
 *  net.minecraft.class_2371
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 *  net.minecraft.class_746
 */
package dev.recollect.hana.mod.gui.nullpoint.elements;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ConfigManager;
import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.utils.dev.hole.Hole;
import dev.recollect.hana.api.utils.entity.EntityUtil;
import dev.recollect.hana.api.utils.render.Render2DUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.impl.client.HUD;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import java.awt.Color;
import java.util.Iterator;
import java.util.Objects;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_2371;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_746;

public class ArmorHUD
extends Tab {
    public ArmorHUD() {
        ArmorHUD a;
        ArmorHUD armorHUD = a;
        ArmorHUD armorHUD2 = a;
        armorHUD2.width = 80;
        armorHUD.height = 34;
        armorHUD2.x = (int)Hana.CONFIG.getFloat(Hole.ALLATORIxDEMO("a\fj\fhv("), 0.0f);
        armorHUD.y = (int)Hana.CONFIG.getFloat(Tab.ALLATORIxDEMO("\n}\u0001}\u0003\u0007B"), 200.0f);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void update(double d, double d2, boolean bl) {
        void a;
        boolean bl2 = bl;
        ArmorHUD a2 = this;
        if (GuiManager.currentGrabbed == null && HUD.INSTANCE.armor.getValue() && a >= (double)a2.x) {
            void a3;
            ArmorHUD armorHUD = a2;
            if (a <= (double)(armorHUD.x + armorHUD.width) && a3 >= (double)a2.y) {
                void a4;
                ArmorHUD armorHUD2 = a2;
                if (a3 <= (double)(armorHUD2.y + armorHUD2.height) && a4 != false) {
                    GuiManager.currentGrabbed = a2;
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void draw(class_332 class_3322, float f, Color color) {
        ArmorHUD armorHUD = this;
        if (HUD.INSTANCE.armor.getValue()) {
            Iterator a;
            void a2;
            if (Hana.GUI.isClickGuiOpen()) {
                Render2DUtil.drawRect(a2.method_51448(), (float)armorHUD.x, (float)armorHUD.y, (float)armorHUD.width, (float)armorHUD.height, new Color(0, 0, 0, 70));
            }
            int a3 = 0;
            Iterator iterator = a = armorHUD.mc.field_1724.method_31548().field_7548.iterator();
            while (iterator.hasNext()) {
                a3 += 20;
                class_1799 class_17992 = (class_1799)a.next();
                if (class_17992.method_7960()) {
                    iterator = a;
                    continue;
                }
                void v1 = a2;
                class_4587 class_45872 = v1.method_51448();
                class_45872.method_22903();
                class_1799 class_17993 = class_17992;
                int a4 = EntityUtil.getDamagePercent(class_17993);
                int n = armorHUD.height / 2;
                v1.method_51427(class_17993, armorHUD.x + armorHUD.width - a3, armorHUD.y + n);
                ArmorHUD armorHUD2 = armorHUD;
                v1.method_51431(armorHUD.mc.field_1772, class_17992, armorHUD2.x + armorHUD2.width - a3, armorHUD.y + n);
                ArmorHUD armorHUD3 = armorHUD;
                Objects.requireNonNull(armorHUD.mc.field_1772);
                v1.method_51433(armorHUD.mc.field_1772, String.valueOf(a4), armorHUD3.x + armorHUD3.width + 8 - a3 - armorHUD.mc.field_1772.method_1727(String.valueOf(a4)) / 2, armorHUD.y + n - 9 - 2, new Color((int)(255.0f * (1.0f - (float)a4 / 100.0f)), (int)(255.0f * ((float)a4 / 100.0f)), 0).getRGB(), true);
                class_45872.method_22909();
                iterator = a;
            }
        }
    }
}
