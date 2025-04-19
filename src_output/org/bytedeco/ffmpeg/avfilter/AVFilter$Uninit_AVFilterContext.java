/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 */
package org.bytedeco.ffmpeg.avfilter;

import org.bytedeco.ffmpeg.avfilter.AVFilter;
import org.bytedeco.ffmpeg.avfilter.AVFilterContext;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;

public static class AVFilter.Uninit_AVFilterContext
extends FunctionPointer {
    protected AVFilter.Uninit_AVFilterContext() {
        AVFilter.Uninit_AVFilterContext a;
        AVFilter.Uninit_AVFilterContext uninit_AVFilterContext = a;
        uninit_AVFilterContext.allocate();
    }

    static {
        Loader.load();
    }

    private native /* synthetic */ void allocate();

    public AVFilter.Uninit_AVFilterContext(Pointer pointer) {
        AVFilter.Uninit_AVFilterContext a = pointer;
        AVFilter.Uninit_AVFilterContext a2 = this;
        super((Pointer)a);
    }

    public native void call(AVFilterContext var1);
}
