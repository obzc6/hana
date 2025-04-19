/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.beancontext.BeanContextChildSupport;
import java.io.Serializable;
import java.util.EventListener;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class BaseChildSettings
extends BeanContextChildSupport
implements Comparable<BaseChildSettings> {
    public static String ALLATORIxDEMO(String a2) {
        String string = a2;
        StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[1];
        String string2 = new StringBuffer(stackTraceElement.getClassName()).append(stackTraceElement.getMethodName()).toString();
        int n = string.length();
        int n2 = n - 1;
        char[] arrc = new char[n];
        int n3 = 4 << 4 ^ (2 ^ 5) << 1;
        (3 ^ 5) << 4 ^ 3 << 1;
        int n4 = (2 ^ 5) << 3 ^ 2;
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

    public BaseChildSettings() {
        BaseChildSettings a;
    }

    @Override
    public int compareTo(BaseChildSettings baseChildSettings) {
        BaseChildSettings a = baseChildSettings;
        BaseChildSettings a2 = this;
        return a2.getName().compareTo(a.getName());
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        EventListener a = propertyChangeListener;
        BaseChildSettings a2 = this;
        a2.pcSupport.addPropertyChangeListener((PropertyChangeListener)a);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        EventListener a = propertyChangeListener;
        BaseChildSettings a2 = this;
        a2.pcSupport.removePropertyChangeListener((PropertyChangeListener)a);
    }

    protected String getName() {
        return "";
    }

    public static class PropertyVetoExceptionThatNetBeansLikes
    extends PropertyVetoException
    implements Callable {
        public Object call() throws Exception {
            Serializable a;
            PropertyVetoExceptionThatNetBeansLikes propertyVetoExceptionThatNetBeansLikes = a;
            a = new LogRecord(Level.ALL, propertyVetoExceptionThatNetBeansLikes.getMessage());
            ((LogRecord)a).setResourceBundle(new ListResourceBundle(propertyVetoExceptionThatNetBeansLikes){
                final /* synthetic */ PropertyVetoExceptionThatNetBeansLikes this$0;

                @Override
                protected Object[][] getContents() {
                    1 a;
                    Object[][] arrobject = new Object[1][];
                    Object[] arrobject2 = new Object[2];
                    arrobject2[0] = a.this$0.getMessage();
                    arrobject2[1] = a.this$0.getMessage();
                    arrobject[0] = arrobject2;
                    return arrobject;
                }
                {
                    PropertyVetoExceptionThatNetBeansLikes a = propertyVetoExceptionThatNetBeansLikes;
                    1 a2 = this;
                    a2.this$0 = a;
                }
            });
            LogRecord[] arrlogRecord = new LogRecord[1];
            arrlogRecord[0] = a;
            return arrlogRecord;
        }

        /*
         * WARNING - void declaration
         */
        public PropertyVetoExceptionThatNetBeansLikes(String string, PropertyChangeEvent propertyChangeEvent) {
            void a;
            Serializable a2 = propertyChangeEvent;
            PropertyVetoExceptionThatNetBeansLikes a3 = this;
            super((String)a, (PropertyChangeEvent)a2);
        }

    }

}
