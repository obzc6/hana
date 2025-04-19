/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.settings.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ConfigManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.mod.Mod;
import dev.recollect.hana.mod.modules.settings.Setting;
import java.util.function.Predicate;

public class SliderSetting
extends Setting {
    private final double maxValue;
    private double value;
    public boolean injectTask;
    public boolean update;
    private final double minValue;
    private final double increment;
    public Runnable task;
    private String suffix;

    public final double getIncrement() {
        SliderSetting a;
        return a.increment;
    }

    public final double getValue() {
        SliderSetting a;
        return a.value;
    }

    /*
     * WARNING - void declaration
     */
    public SliderSetting(String string, double d, double d2, double d3, double d4, Predicate predicate) {
        void a;
        void a2;
        void a3;
        Predicate a4;
        void a5;
        void a6;
        SliderSetting sliderSetting = predicate2;
        Predicate predicate2 = predicate;
        SliderSetting a7 = sliderSetting;
        void v1 = a5;
        super((String)v1, ModuleManager.lastLoadMod.getName() + "_" + (String)v1, a4);
        SliderSetting sliderSetting2 = a7;
        SliderSetting sliderSetting3 = a7;
        SliderSetting sliderSetting4 = a7;
        SliderSetting sliderSetting5 = a7;
        sliderSetting5.suffix = "";
        sliderSetting5.update = false;
        sliderSetting4.task = null;
        sliderSetting4.injectTask = false;
        sliderSetting3.value = a2;
        sliderSetting3.minValue = a6;
        sliderSetting2.maxValue = a;
        sliderSetting2.increment = a3;
    }

    public final double getRange() {
        SliderSetting a;
        return a.maxValue - a.minValue;
    }

    public final float getValueFloat() {
        SliderSetting a;
        return (float)a.value;
    }

    public final int getValueInt() {
        SliderSetting a;
        return (int)a.value;
    }

    /*
     * WARNING - void declaration
     */
    public SliderSetting(String string, double d, double d2, double d3, Predicate predicate) {
        void a;
        void a2;
        void a3;
        Predicate a4;
        void a5;
        SliderSetting sliderSetting = predicate2;
        Predicate predicate2 = predicate;
        SliderSetting a6 = sliderSetting;
        a6((String)a2, (double)a3, (double)a5, (double)a, 0.1, a4);
    }

    /*
     * WARNING - void declaration
     */
    public SliderSetting(String string, int n, int n2, int n3, Predicate predicate) {
        void a;
        void a2;
        void a3;
        Predicate a4;
        void a5;
        SliderSetting sliderSetting = predicate2;
        Predicate predicate2 = predicate;
        SliderSetting a6 = sliderSetting;
        a6((String)a3, (double)a, (double)a2, (double)a5, 1.0, a4);
    }

    /*
     * WARNING - void declaration
     */
    public SliderSetting(String string, double d, double d2, double d3) {
        void a;
        void a2;
        void a3;
        String a4 = string;
        SliderSetting a5 = this;
        a5(a4, (double)a2, (double)a3, (double)a, 0.1);
    }

    public SliderSetting injectTask(Runnable runnable) {
        Runnable a = runnable;
        SliderSetting a2 = this;
        a2.task = a;
        a2.injectTask = true;
        return a2;
    }

    public SliderSetting setSuffix(String string) {
        String a = string;
        SliderSetting a2 = this;
        a2.suffix = a;
        return a2;
    }

    public final void setValue(double a) {
        SliderSetting a2;
        a2.value = (double)Math.round(a / a2.increment) * a2.increment;
    }

    public final double getMaximum() {
        SliderSetting a;
        return a.maxValue;
    }

    @Override
    public void loadSetting() {
        SliderSetting a;
        SliderSetting sliderSetting = a;
        sliderSetting.setValue(Hana.CONFIG.getFloat(a.getLine(), (float)sliderSetting.value));
    }

    public String getSuffix() {
        SliderSetting a;
        return a.suffix;
    }

    /*
     * WARNING - void declaration
     */
    public SliderSetting(String string, double d, double d2, double d3, double d4) {
        void a;
        void a2;
        void a3;
        void a4;
        String a5 = string;
        SliderSetting a6 = this;
        Object object = a5;
        super((String)object, ModuleManager.lastLoadMod.getName() + "_" + (String)object);
        SliderSetting sliderSetting = a6;
        SliderSetting sliderSetting2 = a6;
        SliderSetting sliderSetting3 = a6;
        SliderSetting sliderSetting4 = a6;
        sliderSetting4.suffix = "";
        sliderSetting4.update = false;
        sliderSetting3.task = null;
        sliderSetting3.injectTask = false;
        sliderSetting2.value = a3;
        sliderSetting2.minValue = a4;
        sliderSetting.maxValue = a2;
        sliderSetting.increment = a;
    }

    /*
     * WARNING - void declaration
     */
    public SliderSetting(String string, int n, int n2, int n3) {
        void a;
        void a2;
        void a3;
        void a4;
        int n4 = n3;
        SliderSetting a5 = this;
        a5((String)a2, (double)a4, (double)a3, (double)a, 1.0);
    }

    public final double getMinimum() {
        SliderSetting a;
        return a.minValue;
    }
}
