/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.awt.Canvas;
import org.bytedeco.javacv.CanvasFrame;

class CanvasFrame.4
implements Runnable {
    final /* synthetic */ int val$width;
    final /* synthetic */ CanvasFrame this$0;
    final /* synthetic */ int val$height;

    @Override
    public void run() {
        CanvasFrame.4 a;
        CanvasFrame.4 v0 = a;
        v0.this$0.setExtendedState(0);
        CanvasFrame.4 v1 = a;
        v0.this$0.canvas.setSize(a.val$width, v1.val$height);
        v1.this$0.pack();
        v0.this$0.canvas.setSize(a.val$width + 1, a.val$height + 1);
        CanvasFrame.4 v2 = a;
        v0.this$0.canvas.setSize(v2.val$width, v2.val$height);
        v0.this$0.needInitialResize = false;
    }

    /*
     * WARNING - void declaration
     */
    CanvasFrame.4() {
        void a;
        int a2 = n2;
        CanvasFrame.4 var3_5 = this;
        var3_5.this$0 = a;
        var3_5.val$width = n;
        var3_5.val$height = a2;
    }
}
