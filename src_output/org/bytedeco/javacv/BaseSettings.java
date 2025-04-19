/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.beancontext.BeanContextSupport;
import java.util.Arrays;
import org.bytedeco.javacv.BaseChildSettings;

public class BaseSettings
extends BeanContextSupport
implements Comparable<BaseSettings> {
    public void addPropertyChangeListener(PropertyChangeListener a) {
        int n;
        Object a2;
        BaseSettings baseSettings;
        BaseSettings baseSettings2 = baseSettings = a2;
        baseSettings2.pcSupport.addPropertyChangeListener(a);
        Object[] arrobject = baseSettings2.toArray();
        int n2 = arrobject.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a2 = arrobject[n];
            if (a2 instanceof BaseChildSettings) {
                ((BaseChildSettings)a2).addPropertyChangeListener(a);
            } else if (a2 instanceof BaseSettings) {
                ((BaseSettings)a2).addPropertyChangeListener(a);
            }
            n3 = ++n;
        }
    }

    @Override
    public int compareTo(BaseSettings baseSettings) {
        BaseSettings a = baseSettings;
        BaseSettings a2 = this;
        return a2.getName().compareTo(a.getName());
    }

    public void removePropertyChangeListener(PropertyChangeListener a) {
        int n;
        Object a2;
        BaseSettings baseSettings;
        BaseSettings baseSettings2 = baseSettings = a2;
        baseSettings2.pcSupport.removePropertyChangeListener(a);
        Object[] arrobject = baseSettings2.toArray();
        int n2 = arrobject.length;
        int n3 = n = 0;
        while (n3 < n2) {
            a2 = arrobject[n];
            if (a2 instanceof BaseChildSettings) {
                ((BaseChildSettings)a2).removePropertyChangeListener(a);
            } else if (a2 instanceof BaseSettings) {
                ((BaseSettings)a2).addPropertyChangeListener(a);
            }
            n3 = ++n;
        }
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        Object[] a = arrobject;
        Object[] a2 = this;
        a = super.toArray(a);
        Arrays.sort(a);
        return a;
    }

    protected String getName() {
        return "";
    }

    @Override
    public Object[] toArray() {
        BaseSettings a;
        Object[] arrobject = super.toArray();
        Arrays.sort(arrobject);
        return arrobject;
    }

    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getMethodName()).append(stackTraceElement.getClassName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 5 << 4 ^ (2 << 2 ^ 1);
        4 << 3 ^ 1;
        int n4 = (3 ^ 5) << 4 ^ (3 ^ 5) << 1;
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

    public BaseSettings() {
        BaseSettings a;
    }
}
