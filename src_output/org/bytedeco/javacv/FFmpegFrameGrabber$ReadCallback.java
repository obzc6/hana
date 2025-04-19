/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.javacv;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import org.bytedeco.ffmpeg.avformat.Read_packet_Pointer_BytePointer_int;
import org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacv.FFmpegFrameGrabber;

static class FFmpegFrameGrabber.ReadCallback
extends Read_packet_Pointer_BytePointer_int {
    /*
     * WARNING - void declaration
     */
    @Override
    public int call(Pointer pointer, BytePointer bytePointer, int n) {
        void a;
        byte[] a23;
        int a222;
        block3 : {
            byte[] arrby = this;
            try {
                void a222;
                void a3;
                a23 = new byte[a3];
                a222 = inputStreams.get(a222).read(a23, 0, (int)a3);
                if (a222 >= 0) break block3;
                return avutil.AVERROR_EOF();
            }
            catch (Throwable a23) {
                System.err.println("Error on InputStream.read(): " + String.valueOf(a23));
                return -1;
            }
        }
        a.put(a23, 0, a222);
        return a222;
    }

    FFmpegFrameGrabber.ReadCallback() {
        FFmpegFrameGrabber.ReadCallback a;
    }
}
