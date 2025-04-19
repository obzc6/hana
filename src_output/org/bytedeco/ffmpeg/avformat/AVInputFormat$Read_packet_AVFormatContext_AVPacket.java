/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avcodec.AVPacket;
import org.bytedeco.ffmpeg.avformat.AVFormatContext;
import org.bytedeco.ffmpeg.avformat.AVInputFormat;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVInputFormat.Read_packet_AVFormatContext_AVPacket
extends FunctionPointer {
    static {
        Loader.load();
    }

    public AVInputFormat.Read_packet_AVFormatContext_AVPacket(Pointer pointer) {
        AVInputFormat.Read_packet_AVFormatContext_AVPacket a = pointer;
        AVInputFormat.Read_packet_AVFormatContext_AVPacket a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    public native int call(AVFormatContext var1, AVPacket var2);

    protected AVInputFormat.Read_packet_AVFormatContext_AVPacket() {
        AVInputFormat.Read_packet_AVFormatContext_AVPacket a;
        AVInputFormat.Read_packet_AVFormatContext_AVPacket read_packet_AVFormatContext_AVPacket = a;
        read_packet_AVFormatContext_AVPacket.allocate();
    }
}
