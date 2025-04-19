/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.settings.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ConfigManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.api.utils.math.Timer;
import dev.recollect.hana.mod.Mod;
import dev.recollect.hana.mod.modules.settings.Setting;
import java.awt.Color;
import java.util.function.Predicate;

public class ColorSetting
extends Setting {
    public final float effectSpeed = 4.0f;
    private Color value;
    public boolean injectBoolean;
    public boolean booleanValue;
    public final Timer timer;
    public boolean isRainbow;

    /*
     * WARNING - void declaration
     */
    public ColorSetting(String string, Color color) {
        void a;
        Color a2 = color;
        ColorSetting a3 = this;
        void v0 = a;
        super((String)v0, ModuleManager.lastLoadMod.getName() + "_" + (String)v0);
        ColorSetting colorSetting = a3;
        ColorSetting colorSetting2 = a3;
        a3.isRainbow = false;
        ColorSetting colorSetting3 = a3;
        colorSetting3.timer = new Timer();
        colorSetting2.injectBoolean = false;
        colorSetting2.booleanValue = false;
        colorSetting.effectSpeed = 4.0f;
        colorSetting.value = a2;
    }

    public final void setRainbow(boolean bl) {
        boolean a = bl;
        ColorSetting a2 = this;
        a2.isRainbow = a;
    }

    public final void setValue(Color color) {
        Color a = color;
        ColorSetting a2 = this;
        a2.value = a;
    }

    public final void setValue(int n) {
        ColorSetting a;
        int a2 = n;
        ColorSetting colorSetting = a = this;
        colorSetting.value = new Color(a2, true);
    }

    public final Color getValue() {
        Object a;
        float[] arrf = a;
        if (arrf.isRainbow) {
            float[] arrf2 = arrf;
            float[] arrf3 = arrf;
            a = Color.RGBtoHSB(arrf2.value.getRed(), arrf3.value.getGreen(), arrf.value.getBlue(), null);
            a = Color.getHSBColor((float)arrf2.timer.getPassedTimeMs() * 0.36f * 4.0f / 20.0f % 361.0f / 360.0f, a[1], a[2]);
            float[] arrf4 = arrf;
            arrf3.setValue(new Color(((Color)a).getRed(), ((Color)a).getGreen(), ((Color)a).getBlue(), arrf.value.getAlpha()));
        }
        return arrf.value;
    }

    @Override
    public void loadSetting() {
        ColorSetting a;
        ColorSetting colorSetting = a;
        colorSetting.value = new Color(Hana.CONFIG.getInt(a.getLine(), a.value.getRGB()), true);
        colorSetting.isRainbow = Hana.CONFIG.getBoolean(a.getLine() + "Rainbow");
        if (a.injectBoolean) {
            a.booleanValue = Hana.CONFIG.getBoolean(a.getLine() + "Boolean", a.booleanValue);
        }
    }

    /*
     * WARNING - void declaration
     */
    public ColorSetting(String string, Color color, Predicate predicate) {
        void a;
        void a2;
        Predicate a3 = predicate;
        ColorSetting a4 = this;
        void v0 = a2;
        super((String)v0, ModuleManager.lastLoadMod.getName() + "_" + (String)v0, a3);
        ColorSetting colorSetting = a4;
        ColorSetting colorSetting2 = a4;
        a4.isRainbow = false;
        ColorSetting colorSetting3 = a4;
        colorSetting3.timer = new Timer();
        colorSetting2.injectBoolean = false;
        colorSetting2.booleanValue = false;
        colorSetting.effectSpeed = 4.0f;
        colorSetting.value = a;
    }

    /*
     * WARNING - void declaration
     */
    public ColorSetting(String string, int n) {
        void a;
        int a2 = n;
        ColorSetting a3 = this;
        a3((String)a, new Color(a2));
    }

    /*
     * WARNING - void declaration
     */
    public ColorSetting(String string, int n, Predicate predicate) {
        void a;
        void a2;
        Predicate a3 = predicate;
        ColorSetting a4 = this;
        a4((String)a2, new Color((int)a), a3);
    }

    public ColorSetting injectBoolean(boolean bl) {
        boolean a = bl;
        ColorSetting a2 = this;
        a2.injectBoolean = true;
        a2.booleanValue = a;
        return a2;
    }
}
