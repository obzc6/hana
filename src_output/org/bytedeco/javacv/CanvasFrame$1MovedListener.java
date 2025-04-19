/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.Serializable;
import org.bytedeco.javacv.CanvasFrame;

class CanvasFrame.1MovedListener
extends ComponentAdapter {
    boolean moved = false;

    CanvasFrame.1MovedListener() {
        CanvasFrame.1MovedListener a;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void componentMoved(ComponentEvent a) {
        Serializable a2;
        CanvasFrame.1MovedListener movedListener = a2;
        movedListener.moved = true;
        a = ((ComponentEvent)a).getComponent();
        a2 = a;
        synchronized (a) {
            a.notify();
            // ** MonitorExit[a] (shouldn't be in output)
            return;
        }
    }
}
