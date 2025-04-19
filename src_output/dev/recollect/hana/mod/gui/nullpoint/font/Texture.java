/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 */
package dev.recollect.hana.mod.gui.nullpoint.font;

import dev.recollect.hana.mod.modules.settings.Setting;
import java.util.Locale;
import net.minecraft.class_2960;

public class Texture
extends class_2960 {
    public static String validatePath(String a) {
        String string = a;
        if (Texture.method_20207((String)string)) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] arrc = string.toLowerCase(Locale.getDefault()).toCharArray();
        int n = arrc.length;
        int n2 = a = 0;
        while (n2 < n) {
            char c = arrc[a];
            if (Texture.method_29184((char)c)) {
                stringBuilder.append(c);
            }
            n2 = ++a;
        }
        return stringBuilder.toString();
    }

    public Texture(class_2960 class_29602) {
        Texture a = class_29602;
        Texture a2 = this;
        super(a.method_12836(), a.method_12832());
    }

    public Texture(String string) {
        Object a = string;
        Texture a2 = this;
        super(Setting.ALLATORIxDEMO("d$?j"), Texture.validatePath((String)a));
    }
}
