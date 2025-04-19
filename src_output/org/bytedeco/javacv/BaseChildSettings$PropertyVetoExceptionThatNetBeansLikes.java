/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.io.Serializable;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.bytedeco.javacv.BaseChildSettings;

public static class BaseChildSettings.PropertyVetoExceptionThatNetBeansLikes
extends PropertyVetoException
implements Callable {
    public Object call() throws Exception {
        Serializable a;
        BaseChildSettings.PropertyVetoExceptionThatNetBeansLikes propertyVetoExceptionThatNetBeansLikes = a;
        a = new LogRecord(Level.ALL, propertyVetoExceptionThatNetBeansLikes.getMessage());
        ((LogRecord)a).setResourceBundle(new ListResourceBundle(propertyVetoExceptionThatNetBeansLikes){
            final /* synthetic */ BaseChildSettings.PropertyVetoExceptionThatNetBeansLikes this$0;

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
                BaseChildSettings.PropertyVetoExceptionThatNetBeansLikes a = propertyVetoExceptionThatNetBeansLikes;
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
    public BaseChildSettings.PropertyVetoExceptionThatNetBeansLikes(String string, PropertyChangeEvent propertyChangeEvent) {
        void a;
        Serializable a2 = propertyChangeEvent;
        BaseChildSettings.PropertyVetoExceptionThatNetBeansLikes a3 = this;
        super((String)a, (PropertyChangeEvent)a2);
    }

}
