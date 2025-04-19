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

public static class AVFilter.Init_AVFilterContext
extends FunctionPointer {
    protected AVFilter.Init_AVFilterContext() {
        AVFilter.Init_AVFilterContext a;
        AVFilter.Init_AVFilterContext init_AVFilterContext = a;
        init_AVFilterContext.allocate();
    }

    private native /* synthetic */ void allocate();

    public AVFilter.Init_AVFilterContext(Pointer pointer) {
        AVFilter.Init_AVFilterContext a = pointer;
        AVFilter.Init_AVFilterContext a2 = this;
        super((Pointer)a);
    }

    public native int call(AVFilterContext var1);

    static {
        Loader.load();
    }
}
