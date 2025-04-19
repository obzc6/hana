/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.settings;

import java.util.function.Predicate;

public abstract class Setting {
    public final Predicate visibility;
    private final String line;
    public boolean hide;
    private final String name;

    /*
     * WARNING - void declaration
     */
    public Setting(String string, String string2) {
        void a;
        Setting a2;
        String a3 = string2;
        Setting setting = a2 = this;
        Setting setting2 = a2;
        setting2.hide = false;
        setting2.name = a;
        setting.line = a3;
        setting.visibility = null;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).insert(0, stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = (2 ^ 5) << 4 ^ 1 << 1;
        5 << 3 ^ (3 ^ 5);
        int n4 = (3 ^ 5) << 3 ^ 1;
        int n5 = a2 = string2.length() - 1;
        String string3 = string2;
        while (n2 >= 0) {
            int n6 = n2--;
            arrc[n6] = (char)(n4 ^ (string.charAt(n6) ^ string3.charAt(a2)));
            if (n2 < 0) break;
            int n7 = n2--;
            char c = arrc[n7] = (char)(n3 ^ (string.charAt(n7) ^ string3.charAt(a2)));
            if (--a2 < 0) {
                int a2 = n5;
            }
            int n8 = n2;
        }
        return new String(arrc);
    }

    /*
     * WARNING - void declaration
     */
    public Setting(String string, String string2, Predicate predicate) {
        void a;
        Setting a2;
        void a3;
        Predicate a4 = predicate;
        Setting setting = a2 = this;
        Setting setting2 = a2;
        setting2.hide = false;
        setting2.name = a;
        setting.line = a3;
        setting.visibility = a4;
    }

    public final String getLine() {
        Setting a;
        return a.line;
    }

    public abstract void loadSetting();

    public void hide() {
        a.hide = true;
    }

    public final String getName() {
        Setting a;
        return a.name;
    }
}
