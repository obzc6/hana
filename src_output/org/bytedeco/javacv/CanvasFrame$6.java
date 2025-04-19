/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.awt.event.ComponentListener;
import org.bytedeco.javacv.CanvasFrame;

static class CanvasFrame.6
implements Runnable {
    final /* synthetic */ CanvasFrame.1MovedListener val$movedListener;
    final /* synthetic */ int val$n;
    final /* synthetic */ CanvasFrame[] val$frames;

    @Override
    public void run() {
        CanvasFrame.6 a;
        CanvasFrame.6 v0 = a;
        class MovedListener
        extends java.awt.event.ComponentAdapter {
            boolean moved;

            MovedListener() {
                MovedListener a;
                a.moved = false;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void componentMoved(java.awt.event.ComponentEvent a) {
                java.io.Serializable a2;
                MovedListener movedListener = a2;
                movedListener.moved = true;
                a = ((java.awt.event.ComponentEvent)a).getComponent();
                a2 = a;
                synchronized (a) {
                    a.notify();
                    // ** MonitorExit[a] (shouldn't be in output)
                    return;
                }
            }
        }
        v0.val$frames[v0.val$n].removeComponentListener(a.val$movedListener);
    }

    CanvasFrame.6() {
        Object a = object;
        object = this;
        object.val$frames = arrcanvasFrame;
        object.val$n = n;
        object.val$movedListener = a;
        object();
    }
}
