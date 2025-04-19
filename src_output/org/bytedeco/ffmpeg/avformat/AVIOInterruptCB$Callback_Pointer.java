/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.ffmpeg.avformat;

import org.bytedeco.ffmpeg.avformat.AVIOInterruptCB;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVIOInterruptCB.Callback_Pointer
extends FunctionPointer {
    private native /* synthetic */ void allocate();

    public native int call(Pointer var1);

    static {
        Loader.load();
    }

    public AVIOInterruptCB.Callback_Pointer(Pointer pointer) {
        AVIOInterruptCB.Callback_Pointer a = pointer;
        AVIOInterruptCB.Callback_Pointer a2 = this;
        super((Pointer)a);
    }

    protected AVIOInterruptCB.Callback_Pointer() {
        AVIOInterruptCB.Callback_Pointer a;
        AVIOInterruptCB.Callback_Pointer callback_Pointer = a;
        callback_Pointer.allocate();
    }
}
