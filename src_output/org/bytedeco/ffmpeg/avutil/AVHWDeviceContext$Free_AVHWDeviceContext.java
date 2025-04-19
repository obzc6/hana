/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVHWDeviceContext;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVHWDeviceContext.Free_AVHWDeviceContext
extends FunctionPointer {
    static {
        Loader.load();
    }

    public AVHWDeviceContext.Free_AVHWDeviceContext(Pointer pointer) {
        AVHWDeviceContext.Free_AVHWDeviceContext a = pointer;
        AVHWDeviceContext.Free_AVHWDeviceContext a2 = this;
        super((Pointer)a);
    }

    public native void call(AVHWDeviceContext var1);

    protected AVHWDeviceContext.Free_AVHWDeviceContext() {
        AVHWDeviceContext.Free_AVHWDeviceContext a;
        AVHWDeviceContext.Free_AVHWDeviceContext free_AVHWDeviceContext = a;
        free_AVHWDeviceContext.allocate();
    }

    private native /* synthetic */ void allocate();
}
