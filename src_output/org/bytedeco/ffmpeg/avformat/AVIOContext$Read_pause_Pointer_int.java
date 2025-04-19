/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVIOContext;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVIOContext.Read_pause_Pointer_int
extends FunctionPointer {
    protected AVIOContext.Read_pause_Pointer_int() {
        AVIOContext.Read_pause_Pointer_int a;
        AVIOContext.Read_pause_Pointer_int read_pause_Pointer_int = a;
        read_pause_Pointer_int.allocate();
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }

    public native int call(Pointer var1, int var2);

    public AVIOContext.Read_pause_Pointer_int(Pointer pointer) {
        AVIOContext.Read_pause_Pointer_int a = pointer;
        AVIOContext.Read_pause_Pointer_int a2 = this;
        super((Pointer)a);
    }
}
