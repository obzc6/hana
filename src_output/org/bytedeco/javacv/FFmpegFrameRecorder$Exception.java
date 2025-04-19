/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.FrameRecorder;

public static class FFmpegFrameRecorder.Exception
extends FrameRecorder.Exception {
    /*
     * WARNING - void declaration
     */
    public FFmpegFrameRecorder.Exception(String string, Throwable throwable) {
        void a;
        Throwable a2 = throwable;
        FFmpegFrameRecorder.Exception a3 = this;
        super((String)a, a2);
    }

    public FFmpegFrameRecorder.Exception(String string) {
        String a = string;
        FFmpegFrameRecorder.Exception a2 = this;
        super((String)a + " (For more details, make sure FFmpegLogCallback.set() has been called.)");
    }
}
