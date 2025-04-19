/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVFormatContext;
import org.bytedeco.ffmpeg.avformat.AVIOContext;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVFormatContext.Io_close_AVFormatContext_AVIOContext
extends FunctionPointer {
    @Deprecated
    public native void call(AVFormatContext var1, AVIOContext var2);

    protected AVFormatContext.Io_close_AVFormatContext_AVIOContext() {
        AVFormatContext.Io_close_AVFormatContext_AVIOContext a;
        AVFormatContext.Io_close_AVFormatContext_AVIOContext io_close_AVFormatContext_AVIOContext = a;
        io_close_AVFormatContext_AVIOContext.allocate();
    }

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();

    public AVFormatContext.Io_close_AVFormatContext_AVIOContext(Pointer pointer) {
        AVFormatContext.Io_close_AVFormatContext_AVIOContext a = pointer;
        AVFormatContext.Io_close_AVFormatContext_AVIOContext a2 = this;
        super((Pointer)a);
    }
}
