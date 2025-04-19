/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 *  net.minecraft.class_7172
 */
package dev.recollect.hana.mod.gui.nullpoint.elements;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ConfigManager;
import dev.recollect.hana.api.managers.GuiManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.render.TextUtil;
import dev.recollect.hana.mod.gui.nullpoint.clickgui.tabs.Tab;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.HUD;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.xibao.Snow;
import java.awt.Color;
import java.util.ArrayList;
import net.minecraft.class_1041;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_7172;

public class IngameGUI
extends Tab {
    int index;
    private class_304 keybindRight;
    ArrayList<Module> modules;
    private class_304 keybindDown;
    private class_304 keybindLeft;
    int indexMods;
    Module.Category[] categories;
    boolean isCategoryMenuOpen;
    private class_304 keybindUp;

    public IngameGUI() {
        IngameGUI a;
        IngameGUI ingameGUI = a;
        IngameGUI ingameGUI2 = a;
        IngameGUI ingameGUI3 = a;
        a.index = 0;
        ingameGUI3.indexMods = 0;
        ingameGUI3.isCategoryMenuOpen = false;
        IngameGUI ingameGUI4 = a;
        ingameGUI2.modules = new ArrayList();
        ingameGUI4.keybindUp = new class_304(Snow.ALLATORIxDEMO("nct\n[W__Q"), 265, TimeHelper.ALLATORIxDEMO("\u0005k52=a6\u0010PO\u0010N\u0000SL\\\u0010\u0015T"));
        ingameGUI2.keybindDown = new class_304(Snow.ALLATORIxDEMO("bk|(yEMRR]O"), 264, TimeHelper.ALLATORIxDEMO("\u0005k52=a6\u0010PO\u0010N\u0000SL\\\u0010\u0015T"));
        ingameGUI2.keybindLeft = new class_304(Snow.ALLATORIxDEMO("bk|(yEMZXLU"), 263, TimeHelper.ALLATORIxDEMO("\u0005k52=a6\u0010PO\u0010N\u0000SL\\\u0010\u0015T"));
        ingameGUI2.keybindRight = new class_304(Snow.ALLATORIxDEMO("ilw+rlF]_ZBU"), 262, TimeHelper.ALLATORIxDEMO("\u0005k52=a6\u0010PO\u0010N\u0000SL\\\u0010\u0015T"));
        ingameGUI2.categories = Module.Category.values();
        ingameGUI2.x = (int)Hana.CONFIG.getFloat(Snow.ALLATORIxDEMO("ocCN[XuY"), 0.0f);
        ingameGUI2.y = (int)Hana.CONFIG.getFloat(TimeHelper.ALLATORIxDEMO("N\u000bG\u0003P\u001a(L"), 30.0f);
        ingameGUI.width = 150;
        ingameGUI.height = 30;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void draw(class_332 class_3322, float f, Color color) {
        void a;
        void a2;
        float a222 = f;
        IngameGUI a3 = this;
        class_310 a222 = class_310.method_1551();
        class_4587 class_45872 = a.method_51448();
        a222.method_22683();
        class_4587 class_45873 = class_45872;
        class_45873.method_22903();
        class_45873.method_22905(1.0f / (float)((Integer)a222.field_1690.method_42474().method_41753()).intValue(), 1.0f / (float)((Integer)a222.field_1690.method_42474().method_41753()).intValue(), 1.0f);
        TextUtil.drawString((class_332)a, Snow.ALLATORIxDEMO("Egy}Sw$#DU-+VjafbicnPx_SA\f"), 8.0, 8.0, (Color)a2);
        if (HUD.INSTANCE.tabGui.getValue()) {
            IngameGUI ingameGUI = a3;
            IngameGUI ingameGUI2 = a3;
            TextUtil.drawOutlinedBox(class_45872, ingameGUI.x, ingameGUI.y, ingameGUI2.width, ingameGUI2.height * a3.categories.length, new Color(30, 30, 30), 0.4f);
            int n = a222 = 0;
            while (n < a3.categories.length) {
                if (a3.index == a222) {
                    IngameGUI ingameGUI3 = a3;
                    TextUtil.drawString((class_332)a, "> \u00a7f" + a3.categories[a222].name(), (double)(a3.x + 8), (double)(ingameGUI3.y + ingameGUI3.height * a222 + 8), (Color)a2);
                } else {
                    IngameGUI ingameGUI4 = a3;
                    TextUtil.drawString((class_332)a, a3.categories[a222].name(), (double)(a3.x + 8), (double)(ingameGUI4.y + ingameGUI4.height * a222 + 8), 16777215);
                }
                n = ++a222;
            }
            if (a3.isCategoryMenuOpen) {
                IngameGUI ingameGUI5 = a3;
                IngameGUI ingameGUI6 = a3;
                IngameGUI ingameGUI7 = a3;
                TextUtil.drawOutlinedBox(class_45872, ingameGUI5.x + ingameGUI5.width, ingameGUI6.y + ingameGUI6.height * a3.index, 165, ingameGUI7.height * ingameGUI7.modules.size(), new Color(30, 30, 30), 0.4f);
                int n2 = a222 = 0;
                while (n2 < a3.modules.size()) {
                    if (a3.indexMods == a222) {
                        void v10 = a;
                        if (a3.modules.get(a222).isOn()) {
                            IngameGUI ingameGUI8 = a3;
                            IngameGUI ingameGUI9 = a3;
                            TextUtil.drawString((class_332)v10, "> " + a3.modules.get(a222).getName(), (double)(ingameGUI8.x + ingameGUI8.width + 5), (double)(a3.y + a222 * a3.height + ingameGUI9.index * ingameGUI9.height + 8), a2.getRGB());
                        } else {
                            IngameGUI ingameGUI10 = a3;
                            IngameGUI ingameGUI11 = a3;
                            TextUtil.drawString((class_332)v10, "> \u00a7f" + a3.modules.get(a222).getName(), (double)(ingameGUI10.x + ingameGUI10.width + 5), (double)(a3.y + a222 * a3.height + ingameGUI11.index * ingameGUI11.height + 8), a2.getRGB());
                        }
                    } else {
                        IngameGUI ingameGUI12 = a3;
                        IngameGUI ingameGUI13 = a3;
                        TextUtil.drawString((class_332)a, a3.modules.get(a222).getName(), (double)(ingameGUI12.x + ingameGUI12.width + 5), (double)(a3.y + a222 * a3.height + ingameGUI13.index * ingameGUI13.height + 8), a3.modules.get(a222).isOn() ? a2.getRGB() : 16777215);
                    }
                    n2 = ++a222;
                }
            }
        }
        class_45872.method_22909();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void update(double var1_3, double var3_5, boolean var5_6) {
        block18 : {
            var0_1 = var5_6;
            a = this;
            if (HUD.INSTANCE.tabGui.getValue() == false) return;
            if (Hana.GUI.isClickGuiOpen() && GuiManager.currentGrabbed == null && a >= (double)a.x) {
                v0 = a;
                if (a <= (double)(v0.x + v0.width) && a >= (double)a.y) {
                    v1 = a;
                    if (a <= (double)(v1.y + v1.height) && a != false) {
                        GuiManager.currentGrabbed = a;
                    }
                }
            }
            if (a.keybindUp.method_1434()) {
                if (!a.isCategoryMenuOpen) {
                    if (a.index == 0) {
                        a.index = a.categories.length - 1;
                        v2 = a;
                    } else {
                        v3 = a;
                        v2 = v3;
                        --v3.index;
                    }
                } else if (a.indexMods == 0) {
                    a.indexMods = a.modules.size() - 1;
                    v2 = a;
                } else {
                    --a.indexMods;
                    v2 = a;
                }
                v2.keybindUp.method_23481(false);
                return;
            }
            if (a.keybindDown.method_1434()) {
                v4 = a;
                if (!a.isCategoryMenuOpen) {
                    v4.index = (a.index + 1) % a.categories.length;
                    v5 = a;
                } else {
                    v4.indexMods = (a.indexMods + 1) % a.modules.size();
                    v5 = a;
                }
                v5.keybindDown.method_23481(false);
                return;
            }
            if (!a.keybindRight.method_1434()) break block18;
            if (a.isCategoryMenuOpen) ** GOTO lbl-1000
            v6 = a;
            if (v6.x != -v6.width) {
                a.isCategoryMenuOpen = true;
                if (a.modules.isEmpty()) {
                    for (Module a : Hana.MODULE.modules) {
                        v7 = a;
                        if (!a.isCategory(v7.categories[v7.index])) continue;
                        a.modules.add(a);
                    }
                }
            } else lbl-1000: // 2 sources:
            {
                v8 = a;
                v8.modules.get(v8.indexMods).toggle();
            }
            a.keybindRight.method_23481(false);
            return;
        }
        if (a.keybindLeft.method_1434() == false) return;
        if (a.isCategoryMenuOpen) {
            a.indexMods = 0;
            a.modules.clear();
            a.isCategoryMenuOpen = false;
        }
        a.keybindLeft.method_23481(false);
    }
}
