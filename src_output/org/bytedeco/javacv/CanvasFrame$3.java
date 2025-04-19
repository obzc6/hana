/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import org.bytedeco.javacv.CanvasFrame;

class CanvasFrame.3
implements KeyEventDispatcher {
    final /* synthetic */ CanvasFrame this$0;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent a) {
        CanvasFrame a2;
        CanvasFrame.3 var2_2 = a2;
        if (a.getID() == 401) {
            a2 = var2_2.this$0;
            synchronized (a2) {
                var2_2.this$0.keyEvent = a;
                var2_2.this$0.notify();
            }
        }
        return false;
    }

    CanvasFrame.3(CanvasFrame canvasFrame) {
        CanvasFrame a = canvasFrame;
        CanvasFrame.3 a2 = this;
        a2.this$0 = a;
    }
}
