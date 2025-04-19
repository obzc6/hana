/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVHWFramesContext;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVHWFramesContext.Free_AVHWFramesContext
extends FunctionPointer {
    protected AVHWFramesContext.Free_AVHWFramesContext() {
        AVHWFramesContext.Free_AVHWFramesContext a;
        AVHWFramesContext.Free_AVHWFramesContext free_AVHWFramesContext = a;
        free_AVHWFramesContext.allocate();
    }

    static {
        Loader.load();
    }

    public AVHWFramesContext.Free_AVHWFramesContext(Pointer pointer) {
        AVHWFramesContext.Free_AVHWFramesContext a = pointer;
        AVHWFramesContext.Free_AVHWFramesContext a2 = this;
        super((Pointer)a);
    }

    public native void call(AVHWFramesContext var1);

    private native /* synthetic */ void allocate();
}
