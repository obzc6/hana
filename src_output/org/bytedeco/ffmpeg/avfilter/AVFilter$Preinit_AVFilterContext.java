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

public static class AVFilter.Preinit_AVFilterContext
extends FunctionPointer {
    static {
        Loader.load();
    }

    public AVFilter.Preinit_AVFilterContext(Pointer pointer) {
        AVFilter.Preinit_AVFilterContext a = pointer;
        AVFilter.Preinit_AVFilterContext a2 = this;
        super((Pointer)a);
    }

    private native /* synthetic */ void allocate();

    public native int call(AVFilterContext var1);

    protected AVFilter.Preinit_AVFilterContext() {
        AVFilter.Preinit_AVFilterContext a;
        AVFilter.Preinit_AVFilterContext preinit_AVFilterContext = a;
        preinit_AVFilterContext.allocate();
    }
}
