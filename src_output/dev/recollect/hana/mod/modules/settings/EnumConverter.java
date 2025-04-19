/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Converter
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonPrimitive
 *  org.jetbrains.annotations.NotNull
 */
package dev.recollect.hana.mod.modules.settings;

import com.google.common.base.Converter;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import org.jetbrains.annotations.NotNull;

public class EnumConverter
extends Converter<Enum, JsonElement> {
    private final Class<? extends Enum> clazz;

    public EnumConverter(Class<? extends Enum> class_) {
        Object a = class_;
        EnumConverter a2 = this;
        a2.clazz = a;
    }

    public Enum doBackward(String string) {
        Object a = string;
        EnumConverter a2 = this;
        try {
            return Enum.valueOf(a2.clazz, (String)a);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    public static Enum increaseEnum(Enum a) {
        Enum enum_ = a;
        int n = EnumConverter.currentEnum(enum_);
        int n2 = a = 0;
        while (n2 < ((Enum[])enum_.getClass().getEnumConstants()).length) {
            Enum enum_2 = ((Enum[])enum_.getClass().getEnumConstants())[a];
            if (a == n + 1) {
                return enum_2;
            }
            n2 = ++a;
        }
        return ((Enum[])enum_.getClass().getEnumConstants())[0];
    }

    public static String getProperName(Enum a) {
        return Character.toUpperCase(a.name().charAt(0)) + a.name().toLowerCase().substring(1);
    }

    public static int currentEnum(Enum a) {
        Enum enum_ = a;
        int n = a = 0;
        while (n < ((Enum[])enum_.getClass().getEnumConstants()).length) {
            if (((Enum[])enum_.getClass().getEnumConstants())[a].name().equalsIgnoreCase(enum_.name())) {
                return a;
            }
            n = ++a;
        }
        return -1;
    }

    @NotNull
    public JsonElement doForward(Enum enum_) {
        Enum a = enum_;
        EnumConverter a2 = this;
        return new JsonPrimitive(a.toString());
    }

    @NotNull
    public Enum doBackward(JsonElement jsonElement) {
        EnumConverter a = jsonElement;
        EnumConverter a2 = this;
        try {
            return Enum.valueOf(a2.clazz, a.getAsString());
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }
}
