/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.javacv;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import org.bytedeco.ffmpeg.avformat.Seek_Pointer_long_int;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Seekable;

static class FFmpegFrameRecorder.SeekCallback
extends Seek_Pointer_long_int {
    /*
     * WARNING - void declaration
     */
    @Override
    public long call(Pointer pointer, long l, int n) {
        Object a22 = pointer;
        FFmpegFrameRecorder.SeekCallback a = this;
        try {
            void a3;
            void a4;
            a22 = outputStreams.get(a22);
            ((Seekable)a22).seek((long)a3, (int)a4);
            return 0L;
        }
        catch (Throwable a22) {
            System.err.println("Error on OutputStream.seek(): " + String.valueOf(a22));
            return -1L;
        }
    }

    FFmpegFrameRecorder.SeekCallback() {
        FFmpegFrameRecorder.SeekCallback a;
    }
}
