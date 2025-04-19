/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;

public static class FFmpegFrameGrabber.Exception
extends FrameGrabber.Exception {
    public FFmpegFrameGrabber.Exception(String string) {
        String a = string;
        FFmpegFrameGrabber.Exception a2 = this;
        super((String)a + " (For more details, make sure FFmpegLogCallback.set() has been called.)");
    }

    /*
     * WARNING - void declaration
     */
    public FFmpegFrameGrabber.Exception(String string, Throwable throwable) {
        void a;
        Throwable a2 = throwable;
        FFmpegFrameGrabber.Exception a3 = this;
        super((String)a, a2);
    }
}
