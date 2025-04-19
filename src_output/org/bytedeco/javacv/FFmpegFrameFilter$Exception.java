/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import org.bytedeco.javacv.FFmpegFrameFilter;
import org.bytedeco.javacv.FrameFilter;

public static class FFmpegFrameFilter.Exception
extends FrameFilter.Exception {
    /*
     * WARNING - void declaration
     */
    public FFmpegFrameFilter.Exception(String string, Throwable throwable) {
        void a;
        Throwable a2 = throwable;
        FFmpegFrameFilter.Exception a3 = this;
        super((String)a, a2);
    }

    public FFmpegFrameFilter.Exception(String string) {
        String a = string;
        FFmpegFrameFilter.Exception a2 = this;
        super((String)a + " (For more details, make sure FFmpegLogCallback.set() has been called.)");
    }
}
