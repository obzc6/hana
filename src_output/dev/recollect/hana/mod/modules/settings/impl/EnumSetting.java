/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.settings.impl;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.managers.ConfigManager;
import dev.recollect.hana.api.managers.ModuleManager;
import dev.recollect.hana.mod.Mod;
import dev.recollect.hana.mod.modules.settings.EnumConverter;
import dev.recollect.hana.mod.modules.settings.Setting;
import java.util.function.Predicate;

public class EnumSetting<T extends Enum<T>>
extends Setting {
    public boolean popped;
    private T value;

    public void setEnumValue(String a) {
        EnumSetting a2;
        EnumSetting enumSetting = a2;
        Enum[] arrenum = (Enum[])enumSetting.value.getClass().getEnumConstants();
        int n = arrenum.length;
        int n2 = a2 = 0;
        while (n2 < n) {
            Enum enum_ = arrenum[a2];
            if (enum_.name().equalsIgnoreCase(a)) {
                enumSetting.value = enum_;
            }
            n2 = ++a2;
        }
    }

    /*
     * WARNING - void declaration
     */
    public EnumSetting(String string, T t, Predicate predicate) {
        void a;
        void a2;
        Predicate a3 = predicate;
        EnumSetting a4 = this;
        void v0 = a2;
        super((String)v0, ModuleManager.lastLoadMod.getName() + "_" + (String)v0, a3);
        EnumSetting enumSetting = a4;
        enumSetting.popped = false;
        enumSetting.value = a;
    }

    /*
     * WARNING - void declaration
     */
    public EnumSetting(String string, T t) {
        void a;
        EnumSetting<T> a2 = t;
        EnumSetting a3 = this;
        void v0 = a;
        super((String)v0, ModuleManager.lastLoadMod.getName() + "_" + (String)v0);
        EnumSetting enumSetting = a3;
        enumSetting.popped = false;
        enumSetting.value = a2;
    }

    public boolean is(T t) {
        EnumSetting<T> a = t;
        EnumSetting a2 = this;
        return a2.getValue() == a;
    }

    @Override
    public void loadSetting() {
        Object a;
        EnumSetting enumSetting = a;
        a = new EnumConverter(enumSetting.value.getClass());
        String string = Hana.CONFIG.getString(enumSetting.getLine());
        if (string == null) {
            return;
        }
        if ((a = ((EnumConverter)((Object)a)).doBackward(string)) != null) {
            enumSetting.value = a;
        }
    }

    public void increaseEnum() {
        EnumSetting a;
        a.value = EnumConverter.increaseEnum(a.value);
    }

    public final T getValue() {
        EnumSetting a;
        return a.value;
    }
}
