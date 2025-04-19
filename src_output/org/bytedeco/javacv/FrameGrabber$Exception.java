/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.io.IOException;
import org.bytedeco.javacv.FrameGrabber;

public static class FrameGrabber.Exception
extends IOException {
    /*
     * WARNING - void declaration
     */
    public FrameGrabber.Exception(String string, Throwable throwable) {
        void a;
        Throwable a2 = throwable;
        FrameGrabber.Exception a3 = this;
        super((String)a, a2);
    }

    public FrameGrabber.Exception(String string) {
        String a = string;
        FrameGrabber.Exception a2 = this;
        super(a);
    }
}
