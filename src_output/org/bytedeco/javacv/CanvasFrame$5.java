/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.awt.event.ComponentListener;
import org.bytedeco.javacv.CanvasFrame;

static class CanvasFrame.5
implements Runnable {
    final /* synthetic */ int val$y;
    final /* synthetic */ CanvasFrame[] val$frames;
    final /* synthetic */ int val$n;
    final /* synthetic */ CanvasFrame.1MovedListener val$movedListener;
    final /* synthetic */ int val$x;

    @Override
    public void run() {
        CanvasFrame.5 a;
        CanvasFrame.5 v0 = a;
        CanvasFrame.5 v1 = a;
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
        v0.val$frames[v0.val$n].addComponentListener(v1.val$movedListener);
        CanvasFrame.5 v2 = a;
        v1.val$frames[a.val$n].setLocation(v2.val$x, v2.val$y);
    }

    /*
     * WARNING - void declaration
     */
    CanvasFrame.5() {
        void a;
        CanvasFrame.5 var5_7;
        int n4 = n3;
        CanvasFrame.5 v0 = var5_7 = this;
        var5_7.val$frames = arrcanvasFrame;
        v0.val$n = n;
        v0.val$movedListener = movedListener;
        var5_7.val$x = n2;
        var5_7.val$y = a;
    }
}
