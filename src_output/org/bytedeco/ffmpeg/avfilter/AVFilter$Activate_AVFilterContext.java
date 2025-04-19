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

public static class AVFilter.Activate_AVFilterContext
extends FunctionPointer {
    public AVFilter.Activate_AVFilterContext(Pointer pointer) {
        AVFilter.Activate_AVFilterContext a = pointer;
        AVFilter.Activate_AVFilterContext a2 = this;
        super((Pointer)a);
    }

    public native int call(AVFilterContext var1);

    protected AVFilter.Activate_AVFilterContext() {
        AVFilter.Activate_AVFilterContext a;
        AVFilter.Activate_AVFilterContext activate_AVFilterContext = a;
        activate_AVFilterContext.allocate();
    }

    private native /* synthetic */ void allocate();

    static {
        Loader.load();
    }
}
