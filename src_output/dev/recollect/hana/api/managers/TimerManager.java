/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.managers;

import dev.recollect.hana.mod.modules.impl.miscellaneous.Timer;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;

public class TimerManager {
    public float timer = 1.0f;
    public float lastTime;

    public float get() {
        TimerManager a;
        return a.timer;
    }

    public void tryReset() {
        TimerManager a;
        if (a.lastTime != a.getDefault()) {
            a.reset();
        }
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).insert(0, stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 2 << 3;
        4 << 3 ^ 5;
        int n4 = 4 << 3 ^ 2;
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

    public void reset() {
        TimerManager a;
        a.lastTime = a.timer = a.getDefault();
    }

    public TimerManager() {
        TimerManager a;
    }

    public float getDefault() {
        if (Timer.INSTANCE.isOn()) {
            return Timer.INSTANCE.multiplier.getValueFloat();
        }
        return 1.0f;
    }

    public void set(float f) {
        float a = f;
        TimerManager a2 = this;
        if (a < 0.1f) {
            a = 0.1f;
        }
        a2.timer = a;
    }
}
