/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.util.concurrent.Callable;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;

class FrameGrabber.1
implements Callable<Void> {
    final /* synthetic */ long val$delayTime;
    final /* synthetic */ long val$start;
    final /* synthetic */ FrameGrabber this$0;

    FrameGrabber.1() {
        FrameGrabber a = frameGrabber;
        FrameGrabber.1 a2 = this;
        a2.this$0 = a;
        a2.val$start = l;
        a2.val$delayTime = l2;
    }

    @Override
    public Void call() throws FrameGrabber.Exception {
        FrameGrabber.1 a;
        do {
            a.this$0.delayedFrame = a.this$0.grab();
            a.this$0.delayedTime = System.nanoTime() / 1000L - a.val$start;
        } while (a.this$0.delayedTime < a.val$delayTime);
        return null;
    }
}
