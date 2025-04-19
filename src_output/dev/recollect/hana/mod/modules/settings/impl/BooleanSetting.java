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

public class BooleanSetting
extends Setting {
    private boolean value;
    public boolean parent;
    public boolean injectTask;
    public Runnable task;
    public boolean popped;

    public final void setValue(boolean bl) {
        boolean a = bl;
        BooleanSetting a2 = this;
        a2.value = a;
    }

    /*
     * WARNING - void declaration
     */
    public BooleanSetting(String string, boolean bl, Predicate predicate) {
        void a;
        void a2;
        Predicate a3 = predicate;
        BooleanSetting a4 = this;
        void v0 = a2;
        super((String)v0, ModuleManager.lastLoadMod.getName() + "_" + (String)v0, a3);
        BooleanSetting booleanSetting = a4;
        BooleanSetting booleanSetting2 = a4;
        a4.parent = false;
        booleanSetting2.popped = false;
        booleanSetting2.task = null;
        booleanSetting.injectTask = false;
        booleanSetting.value = a;
    }

    @Override
    public void loadSetting() {
        BooleanSetting a;
        a.value = Hana.CONFIG.getBoolean(a.getLine(), a.value);
    }

    /*
     * WARNING - void declaration
     */
    public BooleanSetting(String string, boolean bl) {
        void a;
        boolean a2 = bl;
        BooleanSetting a3 = this;
        void v0 = a;
        super((String)v0, ModuleManager.lastLoadMod.getName() + "_" + (String)v0);
        BooleanSetting booleanSetting = a3;
        BooleanSetting booleanSetting2 = a3;
        a3.parent = false;
        booleanSetting2.popped = false;
        booleanSetting2.task = null;
        booleanSetting.injectTask = false;
        booleanSetting.value = a2;
    }

    public final boolean isOpen() {
        BooleanSetting a;
        if (a.parent) {
            return a.popped;
        }
        return true;
    }

    public final boolean getValue() {
        BooleanSetting a;
        return a.value;
    }

    public BooleanSetting injectTask(Runnable runnable) {
        Runnable a = runnable;
        BooleanSetting a2 = this;
        a2.task = a;
        a2.injectTask = true;
        return a2;
    }

    public boolean isOpen(Object object) {
        Object a = object;
        BooleanSetting a2 = this;
        if (a2.parent) {
            return a2.popped;
        }
        return true;
    }

    public BooleanSetting setParent() {
        BooleanSetting a;
        a.parent = true;
        return a;
    }

    public final void toggleValue() {
        BooleanSetting a;
        a.value = !a.value;
    }

    public boolean getValue(Object object) {
        Object a = object;
        BooleanSetting a2 = this;
        return a2.value;
    }
}
