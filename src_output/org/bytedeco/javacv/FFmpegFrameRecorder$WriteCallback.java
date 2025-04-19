/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.javacv;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import org.bytedeco.ffmpeg.avformat.Write_packet_Pointer_BytePointer_int;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacv.FFmpegFrameRecorder;

static class FFmpegFrameRecorder.WriteCallback
extends Write_packet_Pointer_BytePointer_int {
    /*
     * WARNING - void declaration
     */
    @Override
    public int call(Pointer pointer, BytePointer bytePointer, int n) {
        byte[] arrby = this;
        try {
            void a;
            void a2;
            OutputStream a3;
            byte[] a4 = new byte[a2];
            a3 = outputStreams.get(a3);
            a.get(a4, 0, (int)a2);
            a3.write(a4, 0, (int)a2);
            return (int)a2;
        }
        catch (Throwable a4) {
            System.err.println("Error on OutputStream.write(): " + String.valueOf(a4));
            return -1;
        }
    }

    FFmpegFrameRecorder.WriteCallback() {
        FFmpegFrameRecorder.WriteCallback a;
    }
}
